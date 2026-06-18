package org.gestorvisitasapp.controller;

import org.gestorvisitasapp.dao.SecretariosDAO;
import org.gestorvisitasapp.dao.impl.SecretariosDAOImpl;
import org.gestorvisitasapp.model.Secretarios;
import org.gestorvisitasapp.view.SecretariosConsoleView;

import java.util.List;

public class SecretariosController {

    private final SecretariosDAO dao;
    private final SecretariosConsoleView vista;

    public SecretariosController() {
        this.dao = new SecretariosDAOImpl();
        this.vista = new SecretariosConsoleView();
    }

    public void iniciar() {
        int opcion;
        do {
            opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1 ->
                    registrar();
                case 2 ->
                    listar();
                case 3 ->
                    buscar();
                case 4 ->
                    actualizar();
                case 5 ->
                    eliminar();
                case 6 ->
                    vista.mostrarMensaje("Regresando al menú principal...");
                default ->
                    vista.mostrarMensaje("Opción no válida.");
            }
        } while (opcion != 6);
    }

    private void registrar() {
        int idSecretario = vista.solicitarId();
        String nombres = vista.solicitarNombres();
        String apellidos = vista.solicitarApellidos();
        String cargoPuesto = vista.solicitarCargoPuesto();
        String correoElectronico = vista.solicitarCorreoElectronico();
        String jornadaLaboral = vista.solicitarJornadaLaboral();

        Secretarios nuevo = new Secretarios(idSecretario, nombres, apellidos, cargoPuesto, correoElectronico, jornadaLaboral);
        if (dao.insertar(nuevo)) {
            vista.mostrarMensaje("Secretario registrado con éxito.");
        } else {
            vista.mostrarMensaje(" Error al registrar al secretario en la base de datos.");
        }
    }

    private void listar() {
        List<Secretarios> lista = dao.listar();
        if (lista.isEmpty()) {
            vista.mostrarMensaje("No hay Secretarios registrados.");
        } else {
            vista.desplegarLista(lista);
        }
    }

    private void buscar() {
        int id = vista.solicitarId();
        Secretarios s = dao.buscar(id);
        if (s != null) {
            vista.desplegarSecretario(s);
        } else {
            vista.mostrarMensaje("Secretario no encontrado con el ID: " + id);
        }
    }

    private void actualizar() {
        int id = vista.solicitarId();
        Secretarios existente = dao.buscar(id);

        if (existente == null) {
            vista.mostrarMensaje("Secretario no encontrado.");
            return;
        }

        
        vista.solicitarTextoOpcional("", ""); 

        String nombres = vista.solicitarTextoOpcional("Nuevo Nombre", existente.getNombres());
        if (!nombres.trim().isEmpty()) {
            existente.setNombres(nombres);
        }

        String apellidos = vista.solicitarTextoOpcional("Nuevo Apellido", existente.getApellidos());
        if (!apellidos.trim().isEmpty()) {
            existente.setApellidos(apellidos);
        }
        
        String cargoPuesto = vista.solicitarTextoOpcional("Nuevo Cargo", existente.getCargoPuesto());
        if (!cargoPuesto.trim().isEmpty()) {
            existente.setCargoPuesto(cargoPuesto);
        }

        String correoElectronico = vista.solicitarTextoOpcional("Nuevo Correo", existente.getCorreoElectronico());
        if (!correoElectronico.trim().isEmpty()) {
            existente.setCorreoElectronico(correoElectronico);
        }

        String jornadaLaboral = vista.solicitarTextoOpcional("Nueva Jornada", existente.getJornadaLaboral());
        if (!jornadaLaboral.trim().isEmpty()) {
            existente.setJornadaLaboral(jornadaLaboral);
        }

        if (dao.actualizar(existente)) {
            vista.mostrarMensaje("Secretario actualizado exitosamente.");
        } else {
            vista.mostrarMensaje("Error al actualizar el secretario.");
        }
    }

    private void eliminar() {
        int id = vista.solicitarId();
        if (dao.eliminar(id)) {
            vista.mostrarMensaje("Secretario eliminado de la base de datos.");
        } else {
            vista.mostrarMensaje("Error al eliminar al secretario");
        }
    }
}