package org.gestorvisitasapp.fxml;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;
import org.gestorvisitasapp.dao.impl.VisitantesDAOImpl;
import org.gestorvisitasapp.dao.impl.SecretariosDAOImpl;
import org.gestorvisitasapp.dao.impl.AreasDAOImpl;
import org.gestorvisitasapp.dao.impl.GafetesDAOImpl;
import org.gestorvisitasapp.dao.impl.VehiculosDAOImpl;
import org.gestorvisitasapp.dao.impl.VisitasDAOImpl;
import org.gestorvisitasapp.model.Visitantes;
import org.gestorvisitasapp.model.Secretarios;
import org.gestorvisitasapp.model.Areas;
import org.gestorvisitasapp.model.Gafetes;
import org.gestorvisitasapp.model.Vehiculos;
import org.gestorvisitasapp.model.Visitas;

public class MenuPrincipalFXController implements Initializable {
    
    @FXML private Label lblTitulo; 
    @FXML private TableView tablaView; 
    @FXML private Button btnVisitantes;
    @FXML private Button btnSecretarios;
    @FXML private Button btnAreas;
    @FXML private Button btnGafetes;
    @FXML private Button btnVehiculos;
    @FXML private Button btnVisitas;
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    @FXML
    private void cargarVisitantes() {
        tablaView.getColumns().clear();
        TableColumn<Visitantes, Integer> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<>("idVisitante"));
        TableColumn<Visitantes, String> colNombres = new TableColumn<>("Nombres");
        colNombres.setCellValueFactory(new PropertyValueFactory<>("nombres"));
        TableColumn<Visitantes, String> colApellidos = new TableColumn<>("Apellidos");
        colApellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        TableColumn<Visitantes, String> colTipo = new TableColumn<>("Tipo");
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipoVisitante"));
        TableColumn<Visitantes, String> colTelefono = new TableColumn<>("Telefono");
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefonoContacto"));
        tablaView.getColumns().addAll(colId, colNombres, colApellidos, colTipo, colTelefono);
        ObservableList<Visitantes> lista = FXCollections.observableArrayList(new VisitantesDAOImpl().listar());
        tablaView.setItems(lista);
        lblTitulo.setText("Modulo de Visitantes");
    }
    
    @FXML
    private void cargarSecretarios() {
        tablaView.getColumns().clear();
        TableColumn<Secretarios, Integer> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<>("idSecretario"));
        TableColumn<Secretarios, String> colNombres = new TableColumn<>("Nombres");
        colNombres.setCellValueFactory(new PropertyValueFactory<>("nombres"));
        TableColumn<Secretarios, String> colApellidos = new TableColumn<>("Apellidos");
        colApellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        TableColumn<Secretarios, String> colCargo = new TableColumn<>("Cargo");
        colCargo.setCellValueFactory(new PropertyValueFactory<>("cargoPuesto"));
        TableColumn<Secretarios, String> colJornada = new TableColumn<>("Jornada");
        colJornada.setCellValueFactory(new PropertyValueFactory<>("jornadaLaboral"));
        tablaView.getColumns().addAll(colId, colNombres, colApellidos, colCargo, colJornada);
        ObservableList<Secretarios> lista = FXCollections.observableArrayList(new SecretariosDAOImpl().listar());
        tablaView.setItems(lista);
        lblTitulo.setText("Modulo de Secretarios");
    }
    
    @FXML
    private void cargarAreas() {
        tablaView.getColumns().clear();
        TableColumn<Areas, Integer> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<>("idArea"));
        TableColumn<Areas, String> colNombre = new TableColumn<>("Nombre Area");
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombreArea"));
        TableColumn<Areas, String> colSalon = new TableColumn<>("Salon");
        colSalon.setCellValueFactory(new PropertyValueFactory<>("numeroSalonTaller"));
        TableColumn<Areas, String> colSector = new TableColumn<>("Sector");
        colSector.setCellValueFactory(new PropertyValueFactory<>("sectorEdificio"));
        TableColumn<Areas, String> colCarrera = new TableColumn<>("Carrera");
        colCarrera.setCellValueFactory(new PropertyValueFactory<>("carreraTecnicaAsignada"));
        tablaView.getColumns().addAll(colId, colNombre, colSalon, colSector, colCarrera);
        ObservableList<Areas> lista = FXCollections.observableArrayList(new AreasDAOImpl().listar());
        tablaView.setItems(lista);
        lblTitulo.setText("Modulo de Areas");
    }
    
    @FXML
    private void cargarGafetes() {
    tablaView.getColumns().clear();
    TableColumn<Gafetes, Integer> colId = new TableColumn<>("ID");
    colId.setCellValueFactory(new PropertyValueFactory<>("idGafete"));
    TableColumn<Gafetes, String> colTipo = new TableColumn<>("Tipo");
    colTipo.setCellValueFactory(new PropertyValueFactory<>("tipoGafete"));
    TableColumn<Gafetes, String> colEstado = new TableColumn<>("Estado");
    colEstado.setCellValueFactory(new PropertyValueFactory<>("estadoGafete"));
    TableColumn<Gafetes, String> colDireccion = new TableColumn<>("Direccion");
    colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccionVisita"));
    TableColumn<Gafetes, String> colVuelta = new TableColumn<>("Estado Vuelta");
    colVuelta.setCellValueFactory(new PropertyValueFactory<>("estadoVuelta"));
    tablaView.getColumns().addAll(colId, colTipo, colEstado, colDireccion, colVuelta);
    ObservableList<Gafetes> lista = FXCollections.observableArrayList(new GafetesDAOImpl().listar());
    tablaView.setItems(lista);
    lblTitulo.setText("Modulo de Gafetes");
    }
    
    @FXML
    private void cargarVehiculos() {
    tablaView.getColumns().clear();
    TableColumn<Vehiculos, String> colPlaca = new TableColumn<>("Placa");
    colPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
    TableColumn<Vehiculos, String> colTipo = new TableColumn<>("Tipo");
    colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo_vehiculo"));
    TableColumn<Vehiculos, String> colMarca = new TableColumn<>("Marca");
    colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
    TableColumn<Vehiculos, String> colColor = new TableColumn<>("Color");
    colColor.setCellValueFactory(new PropertyValueFactory<>("color"));
    tablaView.getColumns().addAll(colPlaca, colTipo, colMarca, colColor);
    ObservableList<Vehiculos> lista = FXCollections.observableArrayList(new VehiculosDAOImpl().listar());
    tablaView.setItems(lista);
    lblTitulo.setText("Modulo de Vehiculos");
    }
    
    @FXML
    private void cargarVisitas() {
    tablaView.getColumns().clear();
    TableColumn<Visitas, Integer> colId = new TableColumn<>("ID");
    colId.setCellValueFactory(new PropertyValueFactory<>("id_visita"));
    TableColumn<Visitas, String> colNombres = new TableColumn<>("Nombres");
    colNombres.setCellValueFactory(new PropertyValueFactory<>("nombres"));
    TableColumn<Visitas, String> colMotivo = new TableColumn<>("Motivo");
    colMotivo.setCellValueFactory(new PropertyValueFactory<>("motivo_visita"));
    TableColumn<Visitas, String> colArea = new TableColumn<>("Area");
    colArea.setCellValueFactory(new PropertyValueFactory<>("nombre_area"));
    TableColumn<Visitas, String> colFecha = new TableColumn<>("Entrada");
    colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha_hora_entrada"));
    tablaView.getColumns().addAll(colId, colNombres, colMotivo, colArea, colFecha);
    ObservableList<Visitas> lista = FXCollections.observableArrayList(new VisitasDAOImpl().listar());
    tablaView.setItems(lista);
    lblTitulo.setText("Modulo de Visitas");
    } 
}
