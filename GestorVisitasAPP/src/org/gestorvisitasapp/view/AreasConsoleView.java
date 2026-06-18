package org.gestorvisitasapp.view;

import org.gestorvisitasapp.model.Areas;
import java.util.List;
import java.util.Scanner;

public class AreasConsoleView {
    private final Scanner scanner = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n--- MÓDULO: GESTIÓN DE AREAS ---");
        System.out.println("1. Registrar nueva area");
        System.out.println("2. Listar todas las areas");
        System.out.println("3. Buscar area por ID");
        System.out.println("4. Modificar un area");
        System.out.println("5. Eliminar un area");
        System.out.println("6. Regresar al Menú Principal");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public int solicitarId() {
        System.out.print("Ingrese el ID del area: ");
        return scanner.nextInt();
    }

    public String solicitarNombreArea() {
        System.out.print("Ingrese el nombre del area: ");
        scanner.nextLine();
        return scanner.nextLine();
    }

    public String solicitarNumeroSalonTaller() {
        System.out.print("Ingrese el numero de salon o taller: ");
        return scanner.nextLine();
    }

    public String solicitarSectorEdificio() {
        System.out.print("Ingrese el sector del edificio: ");
        return scanner.nextLine();
    }

    public String solicitarNivelPiso() {
        System.out.print("Ingrese el nivel o piso: ");
        return scanner.nextLine();
    }

    public String solicitarCarreraTecnicaAsignada() {
        System.out.print("Ingrese la carrera tecnica asignada: ");
        return scanner.nextLine();
    }

    public String solicitarTextoOpcional(String mensaje, String valorActual) {
        System.out.print(mensaje + " [" + valorActual + "]: ");
        return scanner.nextLine();
    }

    public void desplegarLista(List<Areas> areas) {
        System.out.println("\n=== LISTADO DE AREAS ===");
        System.out.printf("%-5s %-25s %-10s %-10s %-15s %-25s\n", "ID", "NOMBRE", "SALON", "SECTOR", "PISO", "CARRERA");
        System.out.println("--------------------------------------------------------------------------");
        for (Areas a : areas) {
            System.out.printf("%-5d %-25s %-10s %-10s %-15s %-25s\n",
                a.getIdArea(), a.getNombreArea(), a.getNumeroSalonTaller(),
                a.getSectorEdificio(), a.getNivelPiso(), a.getCarreraTecnicaAsignada());
        }
    }

    public void desplegarArea(Areas a) {
        System.out.println("\n=== DETALLE DEL AREA ===");
        System.out.println("ID: " + a.getIdArea());
        System.out.println("Nombre: " + a.getNombreArea());
        System.out.println("Salon/Taller: " + a.getNumeroSalonTaller());
        System.out.println("Sector: " + a.getSectorEdificio());
        System.out.println("Piso: " + a.getNivelPiso());
        System.out.println("Carrera: " + a.getCarreraTecnicaAsignada());
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}