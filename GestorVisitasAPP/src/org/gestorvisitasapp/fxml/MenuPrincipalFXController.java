package org.gestorvisitasapp.fxml;

import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
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
import javafx.stage.Stage; 

public class MenuPrincipalFXController implements Initializable {

    @FXML private BorderPane rootPane;
    
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
        tablaView.getColumns().addAll(colId, colNombres, colApellidos, colTipo);
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
        tablaView.getColumns().addAll(colId, colNombres, colApellidos, colCargo);
        ObservableList<Secretarios> lista = FXCollections.observableArrayList(new SecretariosDAOImpl().listar());
        tablaView.setItems(lista);
        lblTitulo.setText("Modulo de Secretarios");
    }

    @FXML
    private void cargarAreas() {
        tablaView.getColumns().clear();
        TableColumn<Areas, Integer> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<>("idArea"));
        TableColumn<Areas, String> colNombre = new TableColumn<>("Area");
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombreArea"));
        TableColumn<Areas, String> colCarrera = new TableColumn<>("Carrera");
        colCarrera.setCellValueFactory(new PropertyValueFactory<>("carreraTecnicaAsignada"));
        tablaView.getColumns().addAll(colId, colNombre, colCarrera);
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
        tablaView.getColumns().addAll(colId, colTipo, colEstado);
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
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipoVehiculo"));
        TableColumn<Vehiculos, String> colColor = new TableColumn<>("Color");
        colColor.setCellValueFactory(new PropertyValueFactory<>("colorVehiculo"));
        tablaView.getColumns().addAll(colPlaca, colTipo, colColor);
        ObservableList<Vehiculos> lista = FXCollections.observableArrayList(new VehiculosDAOImpl().listar());
        tablaView.setItems(lista);
        lblTitulo.setText("Modulo de Vehiculos");
    }

    @FXML
    private void cargarVisitas() {
     cambiarEscena("FormularioVisitasFX");   
    }
    
    private void cambiarEscena(String vista) {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(vista + ".fxml"));
        Parent nodoHijo = loader.load();

        // Reemplaza TODA la ventana (no solo el centro), asi el menu lateral desaparece
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.getScene().setRoot(nodoHijo);

    } catch (IOException e) {
        System.err.println("Error al cargar la vista FXML: " + vista);
        e.printStackTrace();
    } catch (NullPointerException e) {
        System.err.println("No se encontró el archivo FXML: " + vista + ".fxml en la ruta especificada.");
        e.printStackTrace();
    }
}
}
