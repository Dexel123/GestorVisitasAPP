package org.gestorvisitasapp.view;

import java.util.Scanner;
import org.gestorvisitasapp.controller.VisitantesController;
import org.gestorvisitasapp.controller.SecretariosController;
import org.gestorvisitasapp.controller.AreasController;
import org.gestorvisitasapp.controller.VehiculosController;
import org.gestorvisitasapp.controller. GafetesController;

public class MenuPrincipal {
    private final Scanner scanner = new Scanner(System.in);

    public void arrancarSistema() {
        int opcion;
        do {
            System.out.println("\n==============================================");
            System.out.println("   SISTEMA GESTOR DE VISITANTES - KINAL      ");
            System.out.println("==============================================");
            System.out.println("1. Modulo de Visitantes");
            System.out.println("2. Modulo de Secretarios");
            System.out.println("3. Modulo de Areas");
            System.out.println("4. Modulo de Gafetes");
            System.out.println("5. Modulo de Vehiculos");
            System.out.println("6. Modulo de Visitas");
            System.out.println("0. Salir del Sistema");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> {
                    VisitantesController controlVisitantes = new VisitantesController();
                    controlVisitantes.iniciar();
                }
                case 2 -> {
                    SecretariosController controlSecretarios = new SecretariosController();
                    controlSecretarios.iniciar();
                }
                case 3 -> {
                    AreasController controlAreas = new AreasController();
                    controlAreas.iniciar();
                }
                case 5 -> {
                    VehiculosController controlVehiculos = new VehiculosController();
                    controlVehiculos.iniciar();
                }
                case 4 -> {
                    GafetesController controlGafetes = new  GafetesController();
                    controlGafetes.iniciar();
                }
                
                case 6 -> System.out.println("Modulo de Visitas - Pendiente (Angel)");
                case 0 -> System.out.println("\nCerrando sistema... Hasta luego!");
                default -> System.out.println("Opcion no valida.");
            }
        } while (opcion != 0);
    }
}