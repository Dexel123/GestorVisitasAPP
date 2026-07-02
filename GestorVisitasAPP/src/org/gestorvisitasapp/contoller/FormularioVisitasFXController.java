package org.gestorvisitasapp.contoller;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.gestorvisitasapp.util.Conexion;

public class FormularioVisitasFXController implements Initializable {

    // Componentes del Formulario (Asegúrate de poner estos mismos fx:id en Scene Builder)
    @FXML private TextField txtNombre;
    @FXML private TextField txtApellido;
    @FXML private TextArea txtMotivo;
    @FXML private RadioButton rbVehiculo;
    @FXML private ComboBox<Secretario> cmbSecretario;
    @FXML private ComboBox<Area> cmbArea;
    @FXML private ComboBox<Gafete> cmbGafete;
    @FXML private Button btnRegistrar;
    @FXML private Button btnModificar;
    @FXML private Button btnMarcarSalida;

    // Tabla de Visitas y sus Columnas
    @FXML private TableView<Visita> tblVisitas;
    @FXML private TableColumn<Visita, Integer> colId;
    @FXML private TableColumn<Visita, String> colVisitante;
    @FXML private TableColumn<Visita, String> colMotivo;
    @FXML private TableColumn<Visita, String> colArea;
    @FXML private TableColumn<Visita, String> colGafete;
    @FXML private TableColumn<Visita, String> colSalida;

    // Listas observables para los componentes
    private ObservableList<Secretario> listaSecretarios = FXCollections.observableArrayList();
    private ObservableList<Area> listaAreas = FXCollections.observableArrayList();
    private ObservableList<Gafete> listaGafetes = FXCollections.observableArrayList();
    private ObservableList<Visita> listaVisitas = FXCollections.observableArrayList();

    // Variable para almacenar la visita seleccionada en la tabla
    private Visita visitaSeleccionada;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        configurarColumnasTabla();
        cargarCombos();
        mostrarVisitas();
        configurarSeleccionTabla();
    }

    // 1. CONEXIÓN A LA BASE DE DATOS
//    private Connection getConnection() throws SQLException {
//        String url = "jdbc:mysql://localhost:3306/gestor_visitantes_in4cm";
//        String user = "root"; // Cambia por tu usuario de MySQL
//        String password = "admin"; // Cambia por tu contraseña de MySQL
//        return DriverManager.getConnection(url, user, password);
//    }

    // 2. CONFIGURACIÓN INICIAL DE LA TABLA
    private void configurarColumnasTabla() {
        colId.setCellValueFactory(new PropertyValueFactory<>("idVisita"));
        colVisitante.setCellValueFactory(new PropertyValueFactory<>("nombreCompletoVisitante"));
        colMotivo.setCellValueFactory(new PropertyValueFactory<>("motivoVisita"));
        colArea.setCellValueFactory(new PropertyValueFactory<>("nombreArea"));
        colGafete.setCellValueFactory(new PropertyValueFactory<>("tipoGafete"));
        colSalida.setCellValueFactory(new PropertyValueFactory<>("fechaHoraSalida"));
    }

    // Listener para detectar cuándo el usuario selecciona una fila de la tabla
    private void configurarSeleccionTabla() {
        tblVisitas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                visitaSeleccionada = newSelection;
                txtNombre.setText(newSelection.getNombres());
                txtApellido.setText(newSelection.getApellidos());
                txtMotivo.setText(newSelection.getMotivoVisita());
                // Nota: Los objetos ComboBox requieren lógica adicional o mapear por ID para pre-seleccionarlos
            }
        });
    }

    // 3. CARGA DE DATOS DESDE LA DB
    private void cargarCombos() {
        listaSecretarios.clear();
        listaAreas.clear();
        listaGafetes.clear();

        try (Connection con = Conexion.getInstancia().conectar()) {
            // Cargar Secretarios
            try (CallableStatement cs = con.prepareCall("{call sp_listar_secretarios()}"); ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    listaSecretarios.add(new Secretario(rs.getInt("id_secretario"), rs.getString("nombres"), rs.getString("apellidos")));
                }
            }
            cmbSecretario.setItems(listaSecretarios);

            // Cargar Áreas
            try (CallableStatement cs = con.prepareCall("{call sp_listar_areas()}"); ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    listaAreas.add(new Area(rs.getInt("id_area"), rs.getString("nombre_area")));
                }
            }
            cmbArea.setItems(listaAreas);

            // Cargar Gafetes (Filtrando SOLO los Disponibles de forma manual o desde BD)
            try (CallableStatement cs = con.prepareCall("{call sp_listar_gafetes()}"); ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    if ("Disponible".equalsIgnoreCase(rs.getString("estado_gafete"))) {
                        listaGafetes.add(new Gafete(rs.getInt("id_gafete"), rs.getString("tipo_gafete"), rs.getString("estado_gafete")));
                    }
                }
            }
            cmbGafete.setItems(listaGafetes);

        } catch (SQLException e) {
            mostrarAlerta("Error", "Error al cargar los ComboBoxes: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void mostrarVisitas() {
        listaVisitas.clear();
        try (Connection con = Conexion.getInstancia().conectar();
             CallableStatement cs = con.prepareCall("{call sp_listar_visitas()}"); 
             ResultSet rs = cs.executeQuery()) {
            
            while (rs.next()) {
                listaVisitas.add(new Visita(
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
            tblVisitas.setItems(listaVisitas);
        } catch (SQLException e) {
            mostrarAlerta("Error", "Error al listar las visitas: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    // 4. ACCIÓN: REGISTRAR VISITA (Guardar Visitante -> Guardar Visita -> Ocupar Gafete)
    @FXML
    private void accionRegistrarVisita() {
        if (txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() || cmbGafete.getSelectionModel().isEmpty()) {
            mostrarAlerta("Campos vacíos", "Por favor rellene el nombre, apellido y seleccione un Gafete.", Alert.AlertType.WARNING);
            return;
        }

        try (Connection con = Conexion.getInstancia().conectar()) {
            con.setAutoCommit(false); // Iniciar transacción corporativa temporal

            // Generar IDs consecutivos de manera dinámica (ya que no son auto_increment en tu DDL)
            int nuevoIdVisitante = obtenerSiguienteId(con, "SELECT MAX(id_visitante) AS id FROM visitantes");
            int nuevoIdVisita = obtenerSiguienteId(con, "SELECT MAX(id_visita) AS id FROM visitas");

            // Paso A: Registrar el visitante
            try (CallableStatement csVisitante = con.prepareCall("{call sp_agregar_visitantes(?, ?, ?, ?)}")) {
                csVisitante.setInt(1, nuevoIdVisitante);
                csVisitante.setString(2, txtNombre.getText());
                csVisitante.setString(3, txtApellido.getText());
                csVisitante.setString(4, "Padre de familia"); // Valor por defecto o dinámico
                csVisitante.execute();
            }

            // Paso B: Registrar la visita
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
                csVisita.setNull(7, Types.VARCHAR); // Pasamos NULL en placa al no venir en el formulario original
                csVisita.execute();
            }

            // Paso C: Modificar el estado del gafete seleccionado a 'En uso'
            try (CallableStatement csGafete = con.prepareCall("{call sp_actualizar_gafetes(?, ?, ?)}")) {
                csGafete.setInt(1, gafete.getIdGafete());
                csGafete.setString(2, gafete.getTipoGafete());
                csGafete.setString(3, "En uso");
                csGafete.execute();
            }

            con.commit(); // Guardar cambios en la DB
            mostrarAlerta("Éxito", "Visita registrada correctamente", Alert.AlertType.INFORMATION);
            
            limpiarFormulario();
            cargarCombos(); // Recarga los combos actualizando los gafetes disponibles
            mostrarVisitas();

        } catch (SQLException e) {
            mostrarAlerta("Error", "Error en el proceso de registro: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    // 5. ACCIÓN: MARCAR SALIDA (Efectúa salida y devuelve el Gafete a 'Disponible')
    @FXML
    private void accionMarcarSalida() {
        if (visitaSeleccionada == null) {
            mostrarAlerta("Selección requerida", "Por favor, seleccione una visita de la tabla.", Alert.AlertType.WARNING);
            return;
        }

        try (Connection con = Conexion.getInstancia().conectar()) {
            con.setAutoCommit(false);

            // Paso A: Registrar marca de tiempo de salida
            try (CallableStatement csSalida = con.prepareCall("{call sp_registrar_salida(?)}")) {
                csSalida.setInt(1, visitaSeleccionada.getIdVisita());
                csSalida.execute();
            }

            // Paso B: Buscar el ID del gafete usado en esa visita para volverlo a poner disponible
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

            // Paso C: Si se encontró el gafete, regresarlo a estado 'Disponible' mediante tu método existente
            if (idGafeteAReliberar != -1) {
                try (CallableStatement csGafete = con.prepareCall("{call sp_actualizar_gafetes(?, ?, ?)}")) {
                    csGafete.setInt(1, idGafeteAReliberar);
                    csGafete.setString(2, tipoGafete);
                    csGafete.setString(3, "Disponible");
                    csGafete.execute();
                }
            }

            con.commit();
            mostrarAlerta("Éxito", "Salida marcada y gafete devuelto a Disponible.", Alert.AlertType.INFORMATION);
            
            limpiarFormulario();
            cargarCombos();
            mostrarVisitas();

        } catch (SQLException e) {
            mostrarAlerta("Error", "Error al procesar la salida: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    // 6. ACCIÓN: MODIFICAR
    @FXML
    private void accionModificar() {
        if (visitaSeleccionada == null) {
            mostrarAlerta("Selección requerida", "Seleccione una visita para modificar.", Alert.AlertType.WARNING);
            return;
        }
        // Puedes implementar aquí la llamada a sp_actualizar_visitas siguiendo la misma estructura.
    }

    // MÉTODOS AUXILIARES
    private int obtenerSiguienteId(Connection con, String query) throws SQLException {
        try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(query)) {
            if (rs.next()) {
                return rs.getInt("id") + 1;
            }
        }
        return 1;
    }

    private void limpiarFormulario() {
        txtNombre.clear();
        txtApellido.clear();
        txtMotivo.clear();
        rbVehiculo.setSelected(false);
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

    // =========================================================================
    // CLASES ENCAPSULADORAS (POJOs) PARA LOS MODELOS DE DATOS
    // =========================================================================
    public static class Secretario {
        private final int idSecretario;
        private final String nombres;
        private final String apellidos;

        public Secretario(int idSecretario, String nombres, String apellidos) {
            this.idSecretario = idSecretario;
            this.nombres = nombres;
            this.apellidos = apellidos;
        }
        public int getIdSecretario() { return idSecretario; }
        @Override public String toString() { return nombres + " " + apellidos; }
    }

    public static class Area {
        private final int idArea;
        private final String nombreArea;

        public Area(int idArea, String nombreArea) {
            this.idArea = idArea;
            this.nombreArea = nombreArea;
        }
        public int getIdArea() { return idArea; }
        @Override public String toString() { return nombreArea; }
    }

    public static class Gafete {
        private final int idGafete;
        private final String tipoGafete;
        private final String estadoGafete;

        public Gafete(int idGafete, String tipoGafete, String estadoGafete) {
            this.idGafete = idGafete;
            this.tipoGafete = tipoGafete;
            this.estadoGafete = estadoGafete;
        }
        public int getIdGafete() { return idGafete; }
        public String getTipoGafete() { return tipoGafete; }
        @Override public String toString() { return tipoGafete + " (ID: " + idGafete + ")"; }
    }

    public static class Visita {
        private int idVisita;
        private String fechaHoraEntrada;
        private String fechaHoraSalida;
        private String motivoVisita;
        private String nombres;
        private String apellidos;
        private String tipoVisitante;
        private String nombreSecretario;
        private String nombreArea;
        private String tipoGafete;
        private String placa;

        public Visita(int idVisita, String fechaHoraEntrada, String fechaHoraSalida, String motivoVisita, String nombres, String apellidos, String tipoVisitante, String nombreSecretario, String nombreArea, String tipoGafete, String placa) {
            this.idVisita = idVisita;
            this.fechaHoraEntrada = fechaHoraEntrada;
            this.fechaHoraSalida = fechaHoraSalida;
            this.motivoVisita = motivoVisita;
            this.nombres = nombres;
            this.apellidos = apellidos;
            this.tipoVisitante = tipoVisitante;
            this.nombreSecretario = nombreSecretario;
            this.nombreArea = nombreArea;
            this.tipoGafete = tipoGafete;
            this.placa = placa;
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