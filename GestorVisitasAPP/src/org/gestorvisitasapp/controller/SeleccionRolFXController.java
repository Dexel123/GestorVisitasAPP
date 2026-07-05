package org.gestorvisitasapp.controller;

import java.io.IOException;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SeleccionRolFXController {

    private static final String CLAVE_ADMINISTRACION = "Expokinal2026";

    @javafx.fxml.FXML
    private void irAdministracion(ActionEvent event) {
        if (validarContrasena()) {
            cambiarVentana(event, "/org/gestorvisitasapp/fxml/MenuPrincipalFX.fxml", "Gestor de Visitantes - Administracion");
        }
    }

    @javafx.fxml.FXML
    private void irSecretaria(ActionEvent event) {
        cambiarVentana(event, "/org/gestorvisitasapp/fxml/FormularioVisitasFX.fxml", "Gestor de Visitantes - Secretaria");
    }

    private boolean validarContrasena() {
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Acceso restringido");
        dialog.setHeaderText("Ingrese la contraseña de Administracion");

        // --- APLICAMOS TU CSS AL DIÁLOGO ---
        dialog.getDialogPane().getStylesheets().add(getClass().getResource("/org/gestorvisitasapp/css/styles.css").toExternalForm());

        ButtonType btnAceptar = new ButtonType("Aceptar", javafx.scene.control.ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(btnAceptar, ButtonType.CANCEL);

        PasswordField campoClave = new PasswordField();
        campoClave.setPromptText("Contraseña");

        VBox contenido = new VBox(10);
        contenido.getChildren().addAll(new Label("Contraseña:"), campoClave);
        contenido.setStyle("-fx-padding: 10;");
        dialog.getDialogPane().setContent(contenido);

        dialog.setResultConverter(boton -> boton == btnAceptar ? campoClave.getText() : null);

        Optional<String> resultado = dialog.showAndWait();

        if (resultado.isPresent()) {
            if (CLAVE_ADMINISTRACION.equals(resultado.get())) {
                return true;
            } else {
                mostrarAlerta("Contraseña incorrecta", "La contraseña ingresada no es valida.");
                return false;
            }
        }
        // El usuario cancelo el dialogo
        return false;
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        
        // --- APLICAMOS TU CSS A LA ALERTA DE ERROR ---
        alert.getDialogPane().getStylesheets().add(getClass().getResource("/org/gestorvisitasapp/css/styles.css").toExternalForm());
        
        alert.showAndWait();
    }

    private void cambiarVentana(ActionEvent event, String ruta, String titulo) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(ruta));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle(titulo);
            stage.getScene().setRoot(root);

            // Forzamos un tamaño generoso para que no se vea apretado
            stage.setWidth(1000);
            stage.setHeight(650);
            stage.centerOnScreen();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}