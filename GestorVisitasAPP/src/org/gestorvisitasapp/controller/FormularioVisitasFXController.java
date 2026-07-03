package org.gestorvisitasapp.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.gestorvisitasapp.util.Conexion;

public class FormularioVisitasFXController implements Initializable {

    @FXML private TextField txtIdVisita;
    @FXML private TextField txtNombre;
    @FXML private TextField txtApellido;
    @FXML private TextArea txtMotivo;
    @FXML private RadioButton rbVehiculo;
    @FXML private TextField txtPlaca;
    @FXML private ComboBox<Secretario> cmbSecretario;
    @FXML private ComboBox<Area> cmbArea;
    @FXML private ComboBox<Gafete> cmbGafete;
    @FXML private Button btnNuevaVisita;
    @FXML private Button btnRegistrar;
    @FXML private Button btnModificar;
    @FXML private Button btnMarcarSalida;
    @FXML private Button btnPrimero;
    @FXML private Button btnAnterior;
    @FXML private Button btnSiguiente;
    @FXML private Button btnUltimo;
    @FXML private Button btnVisitasActuales;
    @FXML private Button btnHistorial;

    @FXML private TableView<Visita> tblVisitas;
    @FXML private TableColumn<Visita, Integer> colId;
    @FXML private TableColumn<Visita, String> colVisitante;
    @FXML private TableColumn<Visita, String> colMotivo;
    @FXML private TableColumn<Visita, String> colArea;
    @FXML private TableColumn<Visita, String> colGafete;
    @FXML private TableColumn<Visita, String> colSalida;

    private ObservableList<Secretario> listaSecretarios = FXCollections.observableArrayList();
    private ObservableList<Area> listaAreas = FXCollections.observableArrayList();
    private ObservableList<Gafete> listaGafetes = FXCollections.observableArrayList();
    private ObservableList<Visita> listaVisitas = FXCollections.observableArrayList();

    // Lista maestra sin filtrar, para poder alternar entre Historial y Visitas Actuales
    private List<Visita> todasLasVisitas = new ArrayList<>();

    private Visita visitaSeleccionada;
    private int currentIndex = -1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        configurarColumnasTabla();
        cargarCombos();
        mostrarVisitas();
        configurarSeleccionTabla();
        txtPlaca.setDisable(true);
    }

    private void configurarColumnasTabla() {
        colId.setCellValueFactory(new PropertyValueFactory<>("idVisita"));
        colVisitante.setCellValueFactory(new PropertyValueFactory<>("nombreCompletoVisitante"));
        colMotivo.setCellValueFactory(new PropertyValueFactory<>("motivoVisita"));
        colArea.setCellValueFactory(new PropertyValueFactory<>("nombreArea"));
        colGafete.setCellValueFactory(new PropertyValueFactory<>("tipoGafete"));
        colSalida.setCellValueFactory(new PropertyValueFactory<>("fechaHoraSalida"));
    }

    private void configurarSeleccionTabla() {
        tblVisitas.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if (newSel != null) {
                visitaSeleccionada = newSel;
                currentIndex = tblVisitas.getSelectionModel().getSelectedIndex();
                txtIdVisita.setText(String.valueOf(newSel.getIdVisita()));
                txtNombre.setText(newSel.getNombres());
                txtApellido.setText(newSel.getApellidos());
                txtMotivo.setText(newSel.getMotivoVisita());
                seleccionarComboPorTexto(cmbArea, newSel.getNombreArea());
                seleccionarComboPorTexto(cmbGafete, newSel.getTipoGafete());
                
            }
        });
    }
    
    private <T> void seleccionarComboPorTexto(ComboBox<T> combo, String texto) {
        if (texto == null) return;
        for (T item : combo.getItems()) {
            if (item.toString().startsWith(texto)) {
                combo.getSelectionModel().select(item);
                return;
            }
        }
    }

    @FXML
    private void accionToggleVehiculo() {
        txtPlaca.setDisable(!rbVehiculo.isSelected());
        if (!rbVehiculo.isSelected()) txtPlaca.clear();
    }

    private void cargarCombos() {
        listaSecretarios.clear();
        listaAreas.clear();
        listaGafetes.clear();
        try (Connection con = Conexion.getInstancia().conectar()) {
            try (CallableStatement cs = con.prepareCall("{call sp_listar_secretarios()}");
                 ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    listaSecretarios.add(new Secretario(rs.getInt("id_secretario"),
                        rs.getString("nombres"), rs.getString("apellidos")));
                }
            }
            cmbSecretario.setItems(listaSecretarios);

            try (CallableStatement cs = con.prepareCall("{call sp_listar_areas()}");
                 ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    listaAreas.add(new Area(rs.getInt("id_area"), rs.getString("nombre_area")));
                }
            }
            cmbArea.setItems(listaAreas);

            try (CallableStatement cs = con.prepareCall("{call sp_listar_gafetes()}");
                 ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    if ("Disponible".equalsIgnoreCase(rs.getString("estado_gafete"))) {
                        listaGafetes.add(new Gafete(rs.getInt("id_gafete"),
                            rs.getString("tipo_gafete"), rs.getString("estado_gafete")));
                    }
                }
            }
            cmbGafete.setItems(listaGafetes);
        } catch (SQLException e) {
            mostrarAlerta("Error", "Error al cargar los ComboBoxes: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void mostrarVisitas() {
        todasLasVisitas.clear();
        try (Connection con = Conexion.getInstancia().conectar();
             CallableStatement cs = con.prepareCall("{call sp_listar_visitas()}");
             ResultSet rs = cs.executeQuery()) {
            while (rs.next()) {
                todasLasVisitas.add(new Visita(
                    rs.getInt("id_visita"),
                    rs.getString("fecha_hora_entrada"),
                    rs.getString("fecha_hora_salida"),
                    rs.getString("motivo_visita"),
                    rs.getString("nombres"),
                    rs.getString("apellidos"),
                    rs.getString("tipo_visitante"),
                    rs.getString("nombre_secretario"),
                    rs.getString("nombre_area"),
                    rs.getString("tipo_gafete"),
                    rs.getString("placa")
                ));
            }
            listaVisitas.setAll(todasLasVisitas);
            tblVisitas.setItems(listaVisitas);
        } catch (SQLException e) {
            mostrarAlerta("Error", "Error al listar las visitas: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void accionVisitasActuales() {
        listaVisitas.setAll(todasLasVisitas.stream()
            .filter(v -> "En las instalaciones".equals(v.getFechaHoraSalida()))
            .collect(Collectors.toList()));
        tblVisitas.setItems(listaVisitas);
    }

    @FXML
    private void accionHistorial() {
        listaVisitas.setAll(todasLasVisitas);
        tblVisitas.setItems(listaVisitas);
    }

    @FXML
    private void accionNuevaVisita() {
        limpiarFormulario();
        tblVisitas.getSelectionModel().clearSelection();
        currentIndex = -1;
        txtIdVisita.setText("(automatico)");
    }

    @FXML
    private void accionPrimero() {
        if (!listaVisitas.isEmpty()) {
            tblVisitas.getSelectionModel().select(0);
        }
    }

    @FXML
    private void accionAnterior() {
        if (currentIndex > 0) {
            tblVisitas.getSelectionModel().select(currentIndex - 1);
        }
    }

    @FXML
    private void accionSiguiente() {
        if (currentIndex < listaVisitas.size() - 1) {
            tblVisitas.getSelectionModel().select(currentIndex + 1);
        }
    }

    @FXML
    private void accionUltimo() {
        if (!listaVisitas.isEmpty()) {
            tblVisitas.getSelectionModel().select(listaVisitas.size() - 1);
        }
    }

    @FXML
    private void accionRegistrarVisita() {
    if (txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() || cmbGafete.getSelectionModel().isEmpty()) {
        mostrarAlerta("Campos vacios", "Por favor rellene el nombre, apellido y seleccione un Gafete.", Alert.AlertType.WARNING);
        return;
    }
    try (Connection con = Conexion.getInstancia().conectar()) {
        con.setAutoCommit(false);
        int nuevoIdVisitante = obtenerSiguienteId(con, "SELECT MAX(id_visitante) AS id FROM visitantes");
        int nuevoIdVisita = obtenerSiguienteId(con, "SELECT MAX(id_visita) AS id FROM visitas");
        try (CallableStatement csVisitante = con.prepareCall("{call sp_agregar_visitantes(?, ?, ?, ?)}")) {
            csVisitante.setInt(1, nuevoIdVisitante);
            csVisitante.setString(2, txtNombre.getText());
            csVisitante.setString(3, txtApellido.getText());
            csVisitante.setString(4, "Padre de familia");
            csVisitante.execute();
        }

        // NUEVO: si escribieron placa, revisamos si ya existe en vehiculos
        String placaFinal = null;
        if (rbVehiculo.isSelected() && !txtPlaca.getText().isEmpty()) {
            placaFinal = txtPlaca.getText().trim().toUpperCase();
            boolean existe;
            try (CallableStatement csBuscar = con.prepareCall("{call sp_buscar_vehiculos(?)}")) {
                csBuscar.setString(1, placaFinal);
                try (ResultSet rs = csBuscar.executeQuery()) {
                    existe = rs.next();
                }
            }
            if (!existe) {
                try (CallableStatement csVehiculo = con.prepareCall("{call sp_agregar_vehiculos(?, ?, ?)}")) {
                    csVehiculo.setString(1, placaFinal);
                    csVehiculo.setString(2, "Carro");
                    csVehiculo.setString(3, "Sin especificar");
                    csVehiculo.execute();
                }
            }
        }

        Secretario sec = cmbSecretario.getSelectionModel().getSelectedItem();
        Area area = cmbArea.getSelectionModel().getSelectedItem();
        Gafete gafete = cmbGafete.getSelectionModel().getSelectedItem();
        try (CallableStatement csVisita = con.prepareCall("{call sp_agregar_visitas(?, ?, ?, ?, ?, ?, ?)}")) {
            csVisita.setInt(1, nuevoIdVisita);
            csVisita.setString(2, txtMotivo.getText());
            csVisita.setInt(3, nuevoIdVisitante);
            csVisita.setInt(4, sec != null ? sec.getIdSecretario() : 1);
            csVisita.setInt(5, area != null ? area.getIdArea() : 1);
            csVisita.setInt(6, gafete.getIdGafete());
            if (placaFinal != null) {
                csVisita.setString(7, placaFinal);
            } else {
                csVisita.setNull(7, Types.VARCHAR);
            }
            csVisita.execute();
        }
        try (CallableStatement csGafete = con.prepareCall("{call sp_actualizar_gafetes(?, ?, ?)}")) {
            csGafete.setInt(1, gafete.getIdGafete());
            csGafete.setString(2, gafete.getTipoGafete());
            csGafete.setString(3, "En uso");
            csGafete.execute();
        }
        con.commit();
        mostrarAlerta("Exito", "Visita registrada correctamente", Alert.AlertType.INFORMATION);
        txtIdVisita.setText(String.valueOf(nuevoIdVisita));
        cargarCombos();
        mostrarVisitas();
    } catch (SQLException e) {
        mostrarAlerta("Error", "Error en el proceso de registro: " + e.getMessage(), Alert.AlertType.ERROR);
    }
}

    @FXML
    private void accionMarcarSalida() {
        if (visitaSeleccionada == null) {
            mostrarAlerta("Seleccion requerida", "Por favor, seleccione una visita de la tabla.", Alert.AlertType.WARNING);
            return;
        }
        try (Connection con = Conexion.getInstancia().conectar()) {
            con.setAutoCommit(false);

            try (CallableStatement csSalida = con.prepareCall("{call sp_registrar_salida(?)}")) {
                csSalida.setInt(1, visitaSeleccionada.getIdVisita());
                csSalida.execute();
            }

            int idGafeteAReliberar = -1;
            String tipoGafete = "";
            String query = "SELECT v.id_gafete, g.tipo_gafete FROM visitas v JOIN gafetes g ON v.id_gafete = g.id_gafete WHERE v.id_visita = ?";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setInt(1, visitaSeleccionada.getIdVisita());
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        idGafeteAReliberar = rs.getInt("id_gafete");
                        tipoGafete = rs.getString("tipo_gafete");
                    }
                }
            }

            if (idGafeteAReliberar != -1) {
                try (CallableStatement csGafete = con.prepareCall("{call sp_actualizar_gafetes(?, ?, ?)}")) {
                    csGafete.setInt(1, idGafeteAReliberar);
                    csGafete.setString(2, tipoGafete);
                    csGafete.setString(3, "Disponible");
                    csGafete.execute();
                }
            }

            con.commit();
            mostrarAlerta("Exito", "Salida marcada y gafete devuelto a Disponible.", Alert.AlertType.INFORMATION);
            limpiarFormulario();
            cargarCombos();
            mostrarVisitas();
        } catch (SQLException e) {
            mostrarAlerta("Error", "Error al procesar la salida: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void accionModificar() {
        if (visitaSeleccionada == null) {
            mostrarAlerta("Seleccion requerida", "Seleccione una visita para modificar.", Alert.AlertType.WARNING);
            return;
        }
        // Pendiente: llamar sp_actualizar_visitas con los valores actuales del formulario
    }

    private int obtenerSiguienteId(Connection con, String query) throws SQLException {
        try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(query)) {
            if (rs.next()) return rs.getInt("id") + 1;
        }
        return 1;
    }

    private void limpiarFormulario() {
        txtIdVisita.clear();
        txtNombre.clear();
        txtApellido.clear();
        txtMotivo.clear();
        rbVehiculo.setSelected(false);
        txtPlaca.clear();
        txtPlaca.setDisable(true);
        cmbSecretario.getSelectionModel().clearSelection();
        cmbArea.getSelectionModel().clearSelection();
        cmbGafete.getSelectionModel().clearSelection();
        visitaSeleccionada = null;
    }

    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

  
    public static class Secretario {
        private final int idSecretario;
        private final String nombres;
        private final String apellidos;
        public Secretario(int idSecretario, String nombres, String apellidos) {
            this.idSecretario = idSecretario; this.nombres = nombres; this.apellidos = apellidos;
        }
        public int getIdSecretario() { return idSecretario; }
        @Override public String toString() { return nombres + " " + apellidos; }
    }

    public static class Area {
        private final int idArea;
        private final String nombreArea;
        public Area(int idArea, String nombreArea) { this.idArea = idArea; this.nombreArea = nombreArea; }
        public int getIdArea() { return idArea; }
        @Override public String toString() { return nombreArea; }
    }

    public static class Gafete {
        private final int idGafete;
        private final String tipoGafete;
        private final String estadoGafete;
        public Gafete(int idGafete, String tipoGafete, String estadoGafete) {
            this.idGafete = idGafete; this.tipoGafete = tipoGafete; this.estadoGafete = estadoGafete;
        }
        public int getIdGafete() { return idGafete; }
        public String getTipoGafete() { return tipoGafete; }
        @Override public String toString() { return tipoGafete + " (ID: " + idGafete + ")"; }
    }

    public static class Visita {
        private int idVisita;
        private String fechaHoraEntrada, fechaHoraSalida, motivoVisita;
        private String nombres, apellidos, tipoVisitante, nombreSecretario, nombreArea, tipoGafete, placa;

        public Visita(int idVisita, String fechaHoraEntrada, String fechaHoraSalida, String motivoVisita,
                       String nombres, String apellidos, String tipoVisitante, String nombreSecretario,
                       String nombreArea, String tipoGafete, String placa) {
            this.idVisita = idVisita; this.fechaHoraEntrada = fechaHoraEntrada; this.fechaHoraSalida = fechaHoraSalida;
            this.motivoVisita = motivoVisita; this.nombres = nombres; this.apellidos = apellidos;
            this.tipoVisitante = tipoVisitante; this.nombreSecretario = nombreSecretario;
            this.nombreArea = nombreArea; this.tipoGafete = tipoGafete; this.placa = placa;
        }

        public int getIdVisita() { return idVisita; }
        public String getFechaHoraSalida() { return fechaHoraSalida != null ? fechaHoraSalida : "En las instalaciones"; }
        public String getMotivoVisita() { return motivoVisita; }
        public String getNombres() { return nombres; }
        public String getApellidos() { return apellidos; }
        public String getNombreArea() { return nombreArea; }
        public String getTipoGafete() { return tipoGafete; }
        public String getNombreCompletoVisitante() { return nombres + " " + apellidos; }
    }
}