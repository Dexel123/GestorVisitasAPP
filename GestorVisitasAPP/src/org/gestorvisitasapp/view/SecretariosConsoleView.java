package org.gestorvisitasapp.view;

import org.gestorvisitasapp.model.Secretarios;
import java.util.List;
import java.util.Scanner;

public class SecretariosConsoleView {
    private final Scanner scanner = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n--- MÓDULO: GESTIÓN DE SECRETARIOS ---");
        System.out.println("1. Registrar nuevo secretario");
        System.out.println("2. Listar todos los secretarios");
        System.out.println("3. Buscar secretario por ID");
        System.out.println("4. Modificar un secretario");
        System.out.println("5. Eliminar un secretario");
        System.out.println("6. Regresar al Menú Principal");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public int solicitarId() {
        System.out.print("Ingrese el ID del secretario: ");
        return scanner.nextInt();
    }

    public String solicitarNombres() {
        System.out.print("Ingrese los nombres del secretario: ");
        scanner.nextLine();
        return scanner.nextLine();
    }

    public String solicitarApellidos() {
        System.out.print("Ingrese los apellidos del secretario: ");
        return scanner.nextLine();
    }

    public String solicitarCargoPuesto() {
        System.out.print("Ingrese el cargo o puesto: ");
        return scanner.nextLine();
    }

    public String solicitarCorreoElectronico() {
        System.out.print("Ingrese el correo electrónico: ");
        return scanner.nextLine();
    }

    public String solicitarJornadaLaboral() {
        System.out.print("Ingrese la jornada laboral (Matutina / Vespertina): ");
        return scanner.nextLine();
    }

    public String solicitarTextoOpcional(String mensaje, String valorActual) {
        System.out.print(mensaje + " [" + valorActual + "]: ");
        return scanner.nextLine();
    }

    public void desplegarLista(List<Secretarios> secretarios) {
        System.out.println("\n=== LISTADO DE SECRETARIOS ===");
        System.out.printf("%-5s %-20s %-20s %-25s %-15s\n", "ID", "NOMBRES", "APELLIDOS", "CARGO", "JORNADA");
        System.out.println("--------------------------------------------------------------------------");
        for (Secretarios s : secretarios) {
            System.out.printf("%-5d %-20s %-20s %-25s %-15s\n",
                s.getIdSecretario(), s.getNombres(), s.getApellidos(), s.getCargoPuesto(), s.getJornadaLaboral());
        }
    }

    public void desplegarSecretario(Secretarios s) {
        System.out.println("\n=== DETALLE DEL SECRETARIO ===");
        System.out.println("ID: " + s.getIdSecretario());
        System.out.println("Nombre Completo: " + s.getNombres() + " " + s.getApellidos());
        System.out.println("Cargo: " + s.getCargoPuesto());
        System.out.println("Correo: " + s.getCorreoElectronico());
        System.out.println("Jornada: " + s.getJornadaLaboral());
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}