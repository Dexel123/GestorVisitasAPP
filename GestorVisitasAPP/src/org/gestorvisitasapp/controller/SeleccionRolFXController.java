package org.gestorvisitasapp.controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class SeleccionRolFXController {

    @javafx.fxml.FXML
    private void irAdministracion(ActionEvent event) {
        cambiarVentana(event, "/org/gestorvisitasapp/fxml/MenuPrincipalFX.fxml", "Gestor de Visitantes - Administracion");
    }

    @javafx.fxml.FXML
    private void irSecretaria(ActionEvent event) {
        cambiarVentana(event, "/org/gestorvisitasapp/fxml/FormularioVisitasFX.fxml", "Gestor de Visitantes - Secretaria");
    }

    private void cambiarVentana(ActionEvent event, String ruta, String titulo) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(ruta));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle(titulo);
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}