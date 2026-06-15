package org.gestorvisitasapp.controller;

import org.gestorvisitasapp.dao.VisitantesDAO; 
import org.gestorvisitasapp.dao.impl.VisitantesDAOImpl; 
import org.gestorvisitasapp.model.Visitantes; 
import org.gestorvisitasapp.view.VisitantesConsoleView; 
import java.util.List; 

public class VisitantesController {
    private final VisitantesDAO dao; 
    private final VisitantesConsoleView vista; 
    
    
    public VisitantesController() {
        this.dao = new VisitantesDAOImpl();
        this.vista = new VisitantesConsoleView();
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
                default -> vista.mostrarMensaje("Opción no válida.");
            }
        } while (opcion != 6);
    }

    private void registrar() {
        int idVisitante = vista.solicitarIdVisitante();
        String nombres = vista.solicitarNombres();
        String apellidos = vista.solicitarApellidos();
        String tipoVisitante = vista.solicitarTipoVisitante();
        String telefonoContacto = vista.solicitarTelefonoContacto();

        Visitantes nuevo = new Visitantes(idVisitante, nombres, apellidos, tipoVisitante, telefonoContacto);
        if (dao.insertar(nuevo)) {
            vista.mostrarMensaje("Visitante registrado con éxito.");
        } else {
            vista.mostrarMensaje("Error al registrar el visitante.");
        }
    }

    private void listar() {
        List<Visitantes> lista = dao.listar();
        if (lista.isEmpty()) {
            vista.mostrarMensaje("No hay visitantes registrados.");
        } else {
            vista.desplegarLista(lista);
        }
    }

    private void buscar() {
        int idVisitante = vista.solicitarIdVisitante();
        Visitantes v = dao.buscar(idVisitante);
        if (v != null) {
            vista.desplegarVisitante(v);
        } else {
            vista.mostrarMensaje("Visitante no encontrado con el ID: " + idVisitante);
        }
    }

    private void actualizar() {
        int idVisitante = vista.solicitarIdVisitante();
        Visitantes existente = dao.buscar(idVisitante);

        if (existente == null) {
            vista.mostrarMensaje("Visitante no encontrado.");
            return;
        }

        vista.solicitarTextoOpcional( "" , "" );

        String nombres = vista.solicitarTextoOpcional("Nuevo Nombre", existente.getNombres());
        if (!nombres.trim().isEmpty()) {
            existente.setNombres(nombres);
        }

        String apellidos = vista.solicitarTextoOpcional("Nuevo Apellido", existente.getApellidos());
        if (!apellidos.trim().isEmpty()) {
            existente.setApellidos(apellidos);
        }
        
        String tipoVisitante = vista.solicitarTextoOpcional("Nuevo Tipo Visitante", existente.getTipoVisitante());
        if (!tipoVisitante.trim().isEmpty()) {
            existente.setTipoVisitante(tipoVisitante);
        }
        
        String telefonoContacto = vista.solicitarTextoOpcional("Nuevo Telefono", existente.getTelefonoContacto());
        if (!telefonoContacto.trim().isEmpty()) {
            existente.setTelefonoContacto(telefonoContacto);
        }
        
        if (dao.actualizar(existente)) {
            vista.mostrarMensaje("Visitante actualizado exitosamente.");
        } else {
            vista.mostrarMensaje("Error al actualizar el visitante.");
        }
    }

    private void eliminar() {
        int idVisitante = vista.solicitarIdVisitante();
        if (dao.eliminar(idVisitante)) {
            vista.mostrarMensaje("Visitante eliminado de la base de datos.");
        } else {
            vista.mostrarMensaje("Error al eliminar el visitante.");
        }
    }
}
    

