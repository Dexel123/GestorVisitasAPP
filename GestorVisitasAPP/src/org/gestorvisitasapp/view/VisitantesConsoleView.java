package org.gestorvisitasapp.view;

import org.gestorvisitasapp.model.Visitantes; 
import java .util.List; 
import java.util.Scanner; 

public class VisitantesConsoleView {
    private final Scanner scanner = new Scanner(System.in); 
    
    public int mostrarMenu() {
         System.out.println("\n--- MÓDULO: GESTIÓN DE VISITANTES ---");
        System.out.println("1. Registrar nuevo visitante");
        System.out.println("2. Listar todos los visitantes");
        System.out.println("3. Buscar visitante por ID");
        System.out.println("4. Modificar un visitante");
        System.out.println("5. Eliminar un visitante");
        System.out.println("6. Regresar al Menú Principal");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt(); 
    }
    
   
    public int solicitarId() {
        System.out.print("Ingrese el ID del visitante: ");
        return scanner.nextInt();
    }

    public String solicitarNombres() {
        System.out.print("Ingrese los nombres del visitante: ");
        scanner.nextLine();
        return scanner.nextLine();
    }

    public String solicitarApellidos() {
        System.out.print("Ingrese los apellidos del visitante: ");
        return scanner.nextLine();
    }

    public String solicitarTipoVisitante() {
        System.out.print("Ingrese el tipo de visitante (Padre de familia / Exalumno / Empresa externa): ");
        return scanner.nextLine();
    }

    public String solicitarTelefonoContacto() {
        System.out.print("Ingrese el teléfono de contacto: ");
        return scanner.nextLine();
    }
    
    public String solicitarTextoOpcional(String mensaje, String valorActual) {
        System.out.print(mensaje + " [" + valorActual + "]: ");
        return scanner.nextLine();
    }
    
    public void desplegarLista(List<Visitantes> visitantes) {
        System.out.println("\n----------------------------------------LISTADO DE VISITANTES----------------------------------------");
        System.out.printf("%-5s %-20s %-20s %-20s %-15s\n", "ID", "NOMBRES", "APELLIDOS", "TIPO", "TELEFONO");
        System.out.println("-------------------------------------------------------------------------------------------------------");
        for (Visitantes v : visitantes) {
            System.out.printf("%-5d %-20s %-20s %-20s %-15s\n",
                v.getIdVisitante(), v.getNombres(), v.getApellidos(), v.getTipoVisitante(), v.getTelefonoContacto());
        }
    }
    
    public void desplegarVisitante(Visitantes v) {
        System.out.println("\n-----DETALLE DEL VISITANTE-----");
        System.out.println("ID: " + v.getIdVisitante());
        System.out.println("Nombre Completo: " + v.getNombres() + " " + v.getApellidos());
        System.out.println("Tipo: " + v.getTipoVisitante());
        System.out.println("Teléfono: " + v.getTelefonoContacto());
    }
    
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
