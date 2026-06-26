package org.gestorvisitasapp.view;

import org.gestorvisitasapp.model.Visitas;
import java.util.List;
import java.util.Scanner;

public class VisitasConsoleView {
    private final Scanner scanner = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n--- MÓDULO: GESTIÓN DE VISITAS ---");
        System.out.println("1. Registrar nueva visita");
        System.out.println("2. Listar todas las visitas");
        System.out.println("3. Buscar visitas por ID");
        System.out.println("4. Modificar una visita");
        System.out.println("5. Eliminar una visita");
        System.out.println("6. Regresar al Menú Principal");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public int solicitarIdVisita() {
        System.out.print("Ingrese el ID de la visita: ");
        return scanner.nextInt();
    }

    public String solicitarFechaHoraEntrada() {
        System.out.print("Ingrese la fecha y hora de entrada: ");
        scanner.nextLine();
        return scanner.nextLine();
    }

    public String solicitarFechaHoraSalida() {
        System.out.print("Ingrese la fecha y hora de salida: ");
        return scanner.nextLine();
    }

    public String solicitarMotivoVisita() {
        System.out.print("Ingrese el motivo de la visita: ");
        return scanner.nextLine();
    }

    public String solicitarNombreAlumnoRelacionado() {
        System.out.print("Ingrese el nombre del alumno relacionado: ");
        return scanner.nextLine();
    }
    public String solicitarGradoSeccionAlumno() {
        System.out.print("Ingrese el grado y seccion del alumno: ");
        return scanner.nextLine();
    }
    public String solicitarNombres() {
        System.out.print("Ingrese los nombres: ");
        return scanner.nextLine();
    }
    public String solicitarApellidos() {
        System.out.print("Ingrese los apellidos: ");
        return scanner.nextLine();
    }
    public String solicitarTipoVisitante() {
        System.out.print("Ingrese el tipo del visitante: ");
        return scanner.nextLine();
    }
    public String solicitarNombreSecretario() {
        System.out.print("Ingrese el nombre del secretario: ");
        return scanner.nextLine();
    }
    public String solicitarNombreArea() {
        System.out.print("Ingrese el nombre del area: ");
        return scanner.nextLine();
    }
    public String solicitarSectorEdificio() {
        System.out.print("Ingrese el sector del edificio: ");
        return scanner.nextLine();
    }
    public String solicitarTipoGafete() {
        System.out.print("Ingrese el tipo de gafete: ");
        return scanner.nextLine();
    }
    public String solicitarEstadoVuelta() {
        System.out.print("Ingrese el estado de vuelta: ");
        return scanner.nextLine();
    }
    public String solicitarPlaca() {
        System.out.print("Ingrese la placa: ");
        return scanner.nextLine();
    }
    public String solicitarMarca() {
        System.out.print("Ingrese la marca: ");
        return scanner.nextLine();
    }

    public String solicitarColor() {
        System.out.print("Ingrese el color: ");
        return scanner.nextLine();
    }

    public String solicitarTextoOpcional(String mensaje, String valorActual) {
        System.out.print(mensaje + " [" + valorActual + "]: ");
        return scanner.nextLine();
    }

    public void desplegarLista(List<Visitas> visitas) {
        System.out.println("\n=== LISTADO DE VISITAS ===");
        System.out.printf("%-5s %-20s %-20s %-25s %-30s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-15s %-18s %-12s %-15s %-15s\\n", "ID", "FECHA HORA ENTRADA", "FECHA HORA SALIDA", "MOTIVO VISITA", "NOMBRE ALUMNO RELACIONADO" , "GRADO SECCION ALUMNO", "NOMBRES", "APELLIDOS" , "TIPO DE VISITANTE", "NOMBRE SECRETARIO", "NOMBRE AREA" , "SECTOR EDIFICIO", "TIPO GAFETE", "ESTADO DE VUELTA",  "PLACA", "MARCA", "COLOR");
        System.out.println("--------------------------------------------------------------------------");
        for (Visitas v : visitas) {
            System.out.printf("%-5d %-20s %-20s %-25s %-30s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-15s %-18s %-12s %-15s %-15s\\n",
                v.getId_visita(),  v.getFecha_hora_entrada(), v.getFecha_hora_salida(),  v.getMotivo_visita(), v.getNombre_alumno_relacionado(),  v.getGrado_seccion_alumno(),  v.getNombres(), v.getApellidos(), v.getTipo_visitante(), v.getNombre_secretario(), v.getNombre_area(), v.getSector_edificio(),  v.getTipo_gafete(), v.getEstado_de_vuelta(),  v.getPlaca(), v.getMarca(),v.getColor());
        }
    }

    public void desplegarVisitas(Visitas v) {
        System.out.println("\n=== DETALLE DE LAS VISITAS ===");
        System.out.println("ID: " + v.getId_visita());
        System.out.println("Fecha y hora de entrada: " + v.getFecha_hora_entrada());
        System.out.println("Fecha y hora salida: " + v.getFecha_hora_salida());
        System.out.println("Motivo Visita: " + v.getMotivo_visita());
        System.out.println("Nombre Alumno Relacionado: " + v.getNombre_alumno_relacionado());
        System.out.println("Grado Seccion Alumno: " + v.getGrado_seccion_alumno());
        System.out.println("Nombres: " + v.getNombres());
        System.out.println("Apellidos: " + v.getApellidos());
        System.out.println("Tipo de visita: " + v.getTipo_visitante());
        System.out.println("Nombre Secretario: " + v.getNombre_secretario());
        System.out.println("Nombre Area: " + v.getNombre_area());
        System.out.println("Sector del edificio: " + v.getSector_edificio());
        System.out.println("Tipo de gafete: " + v.getTipo_gafete());
        System.out.println("Estado de vuelta: " + v.getEstado_de_vuelta());
        System.out.println("Placa: " + v.getPlaca());
        System.out.println("Marca: " + v.getMarca());
        System.out.println("Color: " + v.getColor());
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}