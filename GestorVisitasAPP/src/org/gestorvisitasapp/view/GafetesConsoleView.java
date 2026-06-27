package org.gestorvisitasapp.view;

import org.gestorvisitasapp.model.Gafetes;
import java.util.List;
import java.util.Scanner;

public class GafetesConsoleView {
    private final Scanner scanner = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n--- MÓDULO: GESTIÓN DE GAFETES ---");
        System.out.println("1. Registrar nuevo gafete");
        System.out.println("2. Listar todos los gafetes");
        System.out.println("3. Buscar gafete por ID");
        System.out.println("4. Modificar un gafete");
        System.out.println("5. Eliminar un gafete");
        System.out.println("6. Regresar al Menú Principal");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public int solicitarIdGafete() {
        System.out.print("Ingrese el ID del gafete: ");
        return scanner.nextInt();
    }

    public String solicitarTipoGafete() {
        System.out.print("Ingrese el tipo de gafete: ");
        scanner.nextLine();
        return scanner.nextLine();
    }

    public String solicitarEstadoGafete() {
        System.out.print("Ingrese el estado del gafete: ");
        return scanner.nextLine();
    }

    public String solicitarDireccionVisita() {
        System.out.print("Ingrese la direccion del visitante: ");
        return scanner.nextLine();
    }

    public String solicitarEstadoVuelta() {
        System.out.print("Ingrese el estado de vuelta: ");
        return scanner.nextLine();
    }

   

    public String solicitarTextoOpcional(String mensaje, String valorActual) {
        System.out.print(mensaje + " [" + valorActual + "]: ");
        return scanner.nextLine();
    }

    public void desplegarLista(List<Gafetes> gafetes) {
        System.out.println("\n=== LISTADO De GAFETES ===");
        System.out.printf("%-5s %-20s %-20s %-25s %-15s\n", "ID", "TIPO_GAFETE", "ESTADO_GAFETE", "DIRECCION_VISITANTE", "ESTADO_VUELTA");
        System.out.println("--------------------------------------------------------------------------");
        for (Gafetes g : gafetes) {
            System.out.printf("%-5d %-20s %-20s %-25s %-15s\n",
                g.getIdGafete(), g.getTipoGafete(), g.getEstadoGafete(), g.getDireccionVisita(), g.getEstadoVuelta());
        }
    }

    public void desplegarGafetes(Gafetes g) {
        System.out.println("\n=== DETALLE DEL SECRETARIO ===");
        System.out.println("ID: " + g.getIdGafete());
        System.out.println("Nombre Completo: " + g.getTipoGafete());
        System.out.println("Cargo: " + g.getEstadoGafete());
        System.out.println("Correo: " + g.getDireccionVisita());
        System.out.println("Jornada: " + g.getEstadoVuelta());
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
