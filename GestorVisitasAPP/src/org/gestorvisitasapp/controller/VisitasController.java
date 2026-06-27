package org.gestorvisitasapp.controller;

import org.gestorvisitasapp.dao.VisitasDAO;
import org.gestorvisitasapp.dao.impl.VisitasDAOImpl;
import org.gestorvisitasapp.model.Visitas;
import org.gestorvisitasapp.view.VisitasConsoleView;

import java.util.List;

public class VisitasController {

    private final VisitasDAO dao;
    private final VisitasConsoleView vista;

    public VisitasController() {
        this.dao = new VisitasDAOImpl();
        this.vista = new VisitasConsoleView();
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
        int id_visita = vista.solicitarIdVisita();
        String fecha_hora_entrada = vista.solicitarFechaHoraEntrada();
        String fecha_hora_salida = vista.solicitarFechaHoraSalida();
        String motivo_visita = vista.solicitarMotivoVisita();
        String nombre_alumno_relacionado = vista.solicitarNombreAlumnoRelacionado();
        String grado_seccion_alumno = vista.solicitarGradoSeccionAlumno();
        String nombres = vista.solicitarNombres();
        String apellidos = vista.solicitarApellidos();
        String tipo_visitante = vista.solicitarTipoVisitante();
        String nombre_secretario = vista.solicitarNombreSecretario();
        String nombre_area = vista.solicitarNombreArea();
        String sector_edificio = vista.solicitarSectorEdificio();
        String tipo_gafete = vista.solicitarTipoGafete();
        String estado_de_vuelta = vista.solicitarNombres();
        String placa = vista.solicitarPlaca();
        String marca = vista.solicitarMarca();
        String color = vista.solicitarColor();

        Visitas nuevo = new Visitas(id_visita,fecha_hora_entrada,fecha_hora_salida,nombre_alumno_relacionado,motivo_visita,grado_seccion_alumno,nombres, apellidos, tipo_visitante, nombre_secretario, nombre_area,sector_edificio,tipo_gafete,estado_de_vuelta,placa,marca,color);
        if (dao.insertar(nuevo)) {
            vista.mostrarMensaje("Visita registrada con éxito.");
        } else {
            vista.mostrarMensaje(" Error al registrar la visita en la base de datos.");
        }
    }

    private void listar() {
        List<Visitas> lista = dao.listar();
        if (lista.isEmpty()) {
            vista.mostrarMensaje("No hay Visitas registrados.");
        } else {
            vista.desplegarLista(lista);
        }
    }

    private void buscar() {
        int id_visita = vista.solicitarIdVisita();
        Visitas v = dao.buscar(id_visita);
        if (v!= null) {
            vista.desplegarVisitas(v);
        } else {
            vista.mostrarMensaje("Visita no encontrada con el ID: " + id_visita);
        }
    }

    private void actualizar() {
        int id_visita = vista.solicitarIdVisita();
        Visitas existente = dao.buscar(id_visita);

        if (existente == null) {
            vista.mostrarMensaje("Visita no encontrada.");
            return;
        }

        
        vista.solicitarTextoOpcional("", ""); 

        String fecha_hora_entrada = vista.solicitarTextoOpcional("Fecha y hora de entrada", existente.getFecha_hora_entrada());
        if (! fecha_hora_entrada.trim().isEmpty()) {
            existente.setFecha_hora_entrada( fecha_hora_entrada);
        }

        String fecha_hora_salida = vista.solicitarTextoOpcional("Fecha y Hora de salida", existente.getFecha_hora_salida());
        if (!fecha_hora_salida.trim().isEmpty()) {
            existente.setFecha_hora_salida(fecha_hora_salida);
        }
        
        String motivo_visita = vista.solicitarTextoOpcional("Morivo de la visita", existente.getMotivo_visita());
        if (!motivo_visita.trim().isEmpty()) {
            existente.setMotivo_visita(motivo_visita);
        }

        String nombre_alumno_relacionado = vista.solicitarTextoOpcional("Nombre del alumno relacionado", existente.getNombre_alumno_relacionado());
        if (!nombre_alumno_relacionado.trim().isEmpty()) {
            existente.setNombre_alumno_relacionado(nombre_alumno_relacionado);
        }

        String grado_seccion_alumno = vista.solicitarTextoOpcional("Nueva Jornada", existente.getGrado_seccion_alumno());
        if (!grado_seccion_alumno.trim().isEmpty()) {
            existente.setGrado_seccion_alumno(grado_seccion_alumno);
        }
        
        String nombres = vista.solicitarTextoOpcional("Nuevo Nombre", existente.getNombres());
        if (!nombres.trim().isEmpty()) {
            existente.setNombres(nombres);
        }
        
        String apellidos = vista.solicitarTextoOpcional("Nuevo Apellido", existente.getApellidos());
        if (!apellidos.trim().isEmpty()) {
            existente.setApellidos(apellidos);
        }
        
        String tipo_visitante = vista.solicitarTextoOpcional("Tipo de visitante", existente.getTipo_visitante());
        if (! tipo_visitante.trim().isEmpty()) {
            existente.setTipo_visitante (tipo_visitante);
        }
        String nombre_secretario = vista.solicitarTextoOpcional("Nombre Secretario", existente.getNombre_secretario());
        if (!nombre_secretario.trim().isEmpty()) {
            existente.setNombre_secretario(nombre_secretario);
        }
        String nombre_area = vista.solicitarTextoOpcional("Nombre del area", existente.getNombre_area());
        if (!nombre_area.trim().isEmpty()) {
            existente.setNombre_area(nombre_area);
        }
        String sector_edificio = vista.solicitarTextoOpcional("Sector del edificio", existente.getSector_edificio());
        if (!sector_edificio.trim().isEmpty()) {
           existente.setSector_edificio(sector_edificio);
        }
        String tipo_gafete = vista.solicitarTextoOpcional("Tipo del gafete", existente.getTipo_gafete());
        if (!tipo_gafete.trim().isEmpty()) {
            existente.setTipo_gafete(tipo_gafete);
        }
        String estado_de_vuelta = vista.solicitarTextoOpcional("Estado de vuelta", existente.getEstado_de_vuelta());
        if (!estado_de_vuelta.trim().isEmpty()) {
            existente.setEstado_de_vuelta(estado_de_vuelta);
        }
        String placa = vista.solicitarTextoOpcional("Nueva Placa", existente.getPlaca());
        if (!placa.trim().isEmpty()) {
            existente.setPlaca(placa);
        }
        String marca = vista.solicitarTextoOpcional("Marca", existente.getMarca());
        if (!marca.trim().isEmpty()) {
            existente.setMarca(marca);
        }
        
        String color = vista.solicitarTextoOpcional("Color", existente.getColor());
        if (!color.trim().isEmpty()) {
            existente.setColor(color);
        }
    

        if (dao.actualizar(existente)) {
            vista.mostrarMensaje("Visita actualizada exitosamente.");
        } else {
            vista.mostrarMensaje("Error al actualizar la visita.");
        }
    }

    private void eliminar() {
        int id_visita = vista.solicitarIdVisita();
        if (dao.eliminar(id_visita)) {
            vista.mostrarMensaje("Visita eliminada de la base de datos.");
        } else {
            vista.mostrarMensaje("Error al eliminar la visita");
        }
    }
}