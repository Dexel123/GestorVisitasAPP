package org.gestorvisitasapp.controller;

import org.gestorvisitasapp.dao.GafetesDAO;
import org.gestorvisitasapp.dao.impl.GafetesDAOImpl;
import org.gestorvisitasapp.model.Gafetes;
import org.gestorvisitasapp.view.GafetesConsoleView;

import java.util.List;

public class GafetesController {

    private final GafetesDAO dao;
    private final GafetesConsoleView vista;

    public GafetesController() {
        this.dao = new GafetesDAOImpl();
        this.vista = new GafetesConsoleView();
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
        int id_gafete = vista.solicitarIdGafete();
        String tipo_gafete = vista.solicitarTipoGafete();
        String estado_gafete = vista.solicitarEstadoGafete();
        String direccion_de_visita = vista.solicitarDireccionVisita();
        String estado_de_vuelta = vista.solicitarEstadoVuelta();
       

        Gafetes nuevo = new Gafetes(id_gafete, tipo_gafete, estado_gafete, direccion_de_visita,  estado_de_vuelta);
        if (dao.insertar(nuevo)) {
            vista.mostrarMensaje("Gafete registrado con éxito.");
        } else {
            vista.mostrarMensaje(" Error al registrar el Gafete en la base de datos.");
        }
    }

    private void listar() {
        List<Gafetes> lista = dao.listar();
        if (lista.isEmpty()) {
            vista.mostrarMensaje("No hay Gafetes registrados.");
        } else {
            vista.desplegarLista(lista);
        }
    }

    private void buscar() {
        int id_gafete = vista.solicitarIdGafete();
        Gafetes g = dao.buscar(id_gafete);
        if (g != null) {
            vista.desplegarGafetes(g);
        } else {
            vista.mostrarMensaje("Gafete no encontrado con el ID: " + id_gafete);
        }
    }

    private void actualizar() {
        int id_gafete = vista.solicitarIdGafete();
        Gafetes existente = dao.buscar(id_gafete);

        if (existente == null) {
            vista.mostrarMensaje("Gafete no encontrado.");
            return;
        }

        
        vista.solicitarTextoOpcional("", ""); 

        String tipo_gafete = vista.solicitarTextoOpcional("Tipo del Gafete", existente.getTipoGafete());
        if (!tipo_gafete.trim().isEmpty()) {
            existente.setTipoGafete(tipo_gafete);
        }

        String estado_gafete = vista.solicitarTextoOpcional("Estado del Gafete", existente.getEstadoGafete());
        if (!estado_gafete.trim().isEmpty()) {
            existente.setEstadoGafete(estado_gafete);
        }
        
        String direccion_de_visita = vista.solicitarTextoOpcional("Nueva Direciion", existente.getDireccionVisita());
        if (!direccion_de_visita.trim().isEmpty()) {
            existente.setDireccionVisita(direccion_de_visita);
        }

        String estado_de_vuelta = vista.solicitarTextoOpcional("Estado de Vuelta", existente.getEstadoVuelta());
        if (!estado_de_vuelta.trim().isEmpty()) {
            existente.setEstadoVuelta(estado_de_vuelta);
        }
 
        if (dao.actualizar(existente)) {
            vista.mostrarMensaje("Gafete actualizado exitosamente.");
        } else {
            vista.mostrarMensaje("Error al actualizar el gafete.");
        }
    }

    private void eliminar() {
        int id_gafete = vista.solicitarIdGafete();
        if (dao.eliminar(id_gafete)) {
            vista.mostrarMensaje("Gafete eliminado de la base de datos.");
        } else {
            vista.mostrarMensaje("Error al eliminar el gafete");
        }
    }
}