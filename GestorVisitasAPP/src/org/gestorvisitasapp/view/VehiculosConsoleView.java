package org.gestorvisitasapp.view;

import org.gestorvisitasapp.model.Vehiculos;
import java.util.List;
import java.util.Scanner;

public class VehiculosConsoleView {
    private final Scanner scanner = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n--- MÓDULO: GESTIÓN DE VEHICULOS ---");
        System.out.println("1. Registrar nuevo vehiculo");
        System.out.println("2. Listar todos los vehiculos");
        System.out.println("3. Buscar vehiculos por PLACA");
        System.out.println("4. Modificar un vehiculo");
        System.out.println("5. Eliminar un vehiculo");
        System.out.println("6. Regresar al Menú Principal");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public String solicitarPlaca() {
        System.out.print("Ingrese la PLACA del vehiculo: ");
        return scanner.next();
    }

    public String solicitarTipo_vehiculo() {
        System.out.print("Ingrese el tipo del vehiculo: ");
        scanner.nextLine();
        return scanner.nextLine();
    }

    public String solicitarMarca() {
        System.out.print("Ingrese la marca del vehiculo: ");
        return scanner.nextLine();
    }

    public String solicitarColor() {
        System.out.print("Ingrese el color del vehiculo: ");
        return scanner.nextLine();
    }

    public String solicitarTextoOpcional(String mensaje, String valorActual) {
        System.out.print(mensaje + " [" + valorActual + "]: ");
        return scanner.nextLine();
    }

    public void desplegarLista(List<Vehiculos> vehiculos) {
        System.out.println("\n=== LISTADO DE VEHICULOS ===");
        System.out.printf("%-5s %-20s %-20s %-25s\n", "PLACA", "TIPO_VEHICULO", "MARCA", "COLOR");
        System.out.println("--------------------------------------------------------------------------");
        for (Vehiculos c : vehiculos) {
            System.out.printf("%-5s %-20s %-20s %-25s\n",
                c.getPlaca(), c.getTipo_vehiculo(), c.getMarca(), c.getColor());
        }
    }

    public void desplegarVehiculos(Vehiculos c) {
        System.out.println("\n=== DETALLE DEL VEHICULO ===");
        System.out.println("PLACA: " + c.getPlaca());
        System.out.println("Tipo_Vehiculo: " + c.getTipo_vehiculo());
        System.out.println("Marca: " + c.getMarca());
        System.out.println("Color: " + c.getColor());
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}