package org.gestorvisitasapp.controller;

import org.gestorvisitasapp.dao.VehiculosDAO;
import org.gestorvisitasapp.dao.impl.VehiculosDAOImpl;
import org.gestorvisitasapp.model. Vehiculos;
import org.gestorvisitasapp.view.VehiculosConsoleView;

import java.util.List;

public class VehiculosController {

    private final VehiculosDAO dao;
    private final VehiculosConsoleView vista;

    public  VehiculosController() {
        this.dao = new  VehiculosDAOImpl();
        this.vista = new  VehiculosConsoleView();
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
        String placa = vista.solicitarPlaca();
        String tipo_vehiculo = vista.solicitarTipo_vehiculo();
        String marca = vista.solicitarMarca();
        String color = vista.solicitarColor();
      

       Vehiculos nuevo = new Vehiculos(placa, tipo_vehiculo, marca, color);
        if (dao.insertar(nuevo)) {
            vista.mostrarMensaje("Vehiculo registrado con éxito.");
        } else {
            vista.mostrarMensaje(" Error al registrar al secretario en la base de datos.");
        }
    }

    private void listar() {
        List<Vehiculos> lista = dao.listar();
        if (lista.isEmpty()) {
            vista.mostrarMensaje("No hay Vehiculos registrados.");
        } else {
            vista.desplegarLista(lista);
        }
    }

    private void buscar() {
        String placa = vista.solicitarPlaca();
       Vehiculos c= dao.buscar(placa);
        if (c != null) {
            vista.desplegarVehiculos(c);
        } else {
            vista.mostrarMensaje("Vehiculos no encontrado con la PLACA: " + placa);
        }
    }

    private void actualizar() {
        String placa = vista.solicitarPlaca();
        Vehiculos existente = dao.buscar(placa);

        if (existente == null) {
            vista.mostrarMensaje("Vehiculo no encontrado.");
            return;
        }

        
        vista.solicitarTextoOpcional("", ""); 

        String tipo_vehiculo = vista.solicitarTextoOpcional("Tipo del Vehiculo", existente.getTipo_vehiculo());
        if (!tipo_vehiculo.trim().isEmpty()) {
            existente.setTipo_vehiculo(tipo_vehiculo);
        }

        String marca = vista.solicitarTextoOpcional("Nueva Marca", existente.getMarca());
        if (!marca.trim().isEmpty()) {
            existente.setMarca(marca);
        }
        
        String color = vista.solicitarTextoOpcional("Color", existente.getColor());
        if (!color.trim().isEmpty()) {
            existente.setColor(color);
        }

        if (dao.actualizar(existente)) {
            vista.mostrarMensaje("Vehiculo actualizado exitosamente.");
        } else {
            vista.mostrarMensaje("Error al actualizar el vehiculo.");
        }
    }

    private void eliminar() {
        String placa = vista.solicitarPlaca();
        if (dao.eliminar(placa)) {
            vista.mostrarMensaje("Vehiculo eliminado de la base de datos.");
        } else {
            vista.mostrarMensaje("Error al eliminar el vehiculo");
        }
    }
}