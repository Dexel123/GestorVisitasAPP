package org.gestorvisitasapp.controller;

import org.gestorvisitasapp.dao.AreasDAO;
import org.gestorvisitasapp.dao.impl.AreasDAOImpl;
import org.gestorvisitasapp.model.Areas;
import org.gestorvisitasapp.view.AreasConsoleView;
import java.util.List;

public class AreasController {
    private final AreasDAO dao;
    private final AreasConsoleView vista;

    public AreasController() {
        this.dao = new AreasDAOImpl();
        this.vista = new AreasConsoleView();
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
                    vista.mostrarMensaje("Opción no válida");
            }
        } while (opcion != 6);
    }

    private void registrar() {
        int idArea = vista.solicitarId();
        String nombreArea = vista.solicitarNombreArea();
        String numeroSalonTaller = vista.solicitarNumeroSalonTaller();
        String sectorEdificio = vista.solicitarSectorEdificio();
        String nivelPiso = vista.solicitarNivelPiso();
        String carreraTecnicaAsignada = vista.solicitarCarreraTecnicaAsignada();

        Areas nuevo = new Areas(idArea, nombreArea, numeroSalonTaller, sectorEdificio, nivelPiso, carreraTecnicaAsignada);
        if (dao.insertar(nuevo)) {
            vista.mostrarMensaje("Area registrada con éxito");
        } else {
            vista.mostrarMensaje("Error al registrar el area");
        }
    }

    private void listar() {
        List<Areas> lista = dao.listar();
        if (lista.isEmpty()) {
            vista.mostrarMensaje("No hay areas registradas");
        } else {
            vista.desplegarLista(lista);
        }
    }

    private void buscar() {
        int id = vista.solicitarId();
        Areas a = dao.buscar(id);
        if (a != null) {
            vista.desplegarArea(a);
        } else {
            vista.mostrarMensaje("Areas no encontrada con el ID: " + id);
        }
    }

    private void actualizar() {
        int id = vista.solicitarId();
        Areas existente = dao.buscar(id);

        if (existente == null) {
            vista.mostrarMensaje("Areas no encontrada");
            return;
        }

        vista.solicitarTextoOpcional("", "");

        String nombreArea = vista.solicitarTextoOpcional("Nuevo Nombre Area", existente.getNombreArea());
        if (!nombreArea.trim().isEmpty()) {
            existente.setNombreArea(nombreArea);
        }

        String numeroSalonTaller = vista.solicitarTextoOpcional("Nuevo Numero Salon", existente.getNumeroSalonTaller());
        if (!numeroSalonTaller.trim().isEmpty()) {
            existente.setNumeroSalonTaller(numeroSalonTaller);
        }

        String sectorEdificio = vista.solicitarTextoOpcional("Nuevo Sector Edificio", existente.getSectorEdificio());
        if (!sectorEdificio.trim().isEmpty()) {
            existente.setSectorEdificio(sectorEdificio);
        }

        String nivelPiso = vista.solicitarTextoOpcional("Nuevo Nivel Piso", existente.getNivelPiso());
        if (!nivelPiso.trim().isEmpty()) {
            existente.setNivelPiso(nivelPiso);
        }

        String carreraTecnicaAsignada = vista.solicitarTextoOpcional("Nueva Carrera Tecnica", existente.getCarreraTecnicaAsignada());
        if (!carreraTecnicaAsignada.trim().isEmpty()) {
            existente.setCarreraTecnicaAsignada(carreraTecnicaAsignada);
        }

        if (dao.actualizar(existente)) {
            vista.mostrarMensaje("Areas actualizada exitosamente");
        } else {
            vista.mostrarMensaje("Error al actualizar el area");
        }
    }

    private void eliminar() {
        int id = vista.solicitarId();
        if (dao.eliminar(id)) {
            vista.mostrarMensaje("Area eliminada de la base de datos");
        } else {
            vista.mostrarMensaje("Error al eliminar el area");
        }
    }
}
