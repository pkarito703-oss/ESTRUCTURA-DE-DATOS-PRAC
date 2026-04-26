/*1. Línea de Metro Circular
Una ciudad tiene una línea de metro que forma un anillo cerrado: después de la última estación el tren vuelve automáticamente a la primera. Los pasajeros pueden viajar en cualquier dirección y el sistema debe mostrar cuántas paradas hay en cada sentido entre dos estaciones.

La Clase Estacion (Nodo): Debe contener nombre (String), zona (int — del 1 al 3) y pasajerosDiarios (int).
El Problema: Dado el nombre de una estación de origen y una de destino, el sistema cuenta las paradas yendo hacia adelante (siguiente) y las paradas yendo hacia atrás (anterior), e imprime cuál ruta es más corta.
Reto: Implementa el método rutaMasCorta(String origen, String destino) que imprima las dos rutas con sus estaciones y número de paradas, y anuncie cuál es la más corta. Si ambas son iguales, indícalo. Usa al menos 6 estaciones para la simulación.*/

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Metro metro = new Metro();

        // ===== SIMULACION =====
        metro.agregar("Central", 1, 5000);
        metro.agregar("Norte", 2, 3000);
        metro.agregar("Universidad", 1, 7000);
        metro.agregar("Sur", 3, 2000);
        metro.agregar("Estadio", 2, 4500);
        metro.agregar("Aeropuerto", 3, 6000);

        System.out.println("=== ESTACIONES ===");
        metro.mostrar();

        System.out.println("\n=== PRUEBA RUTA ===");
        metro.rutaMasCorta("Central", "Estadio");

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== METRO =====");
            System.out.println("1. Agregar estación");
            System.out.println("2. Mostrar estaciones");
            System.out.println("3. Calcular ruta más corta");
            System.out.println("0. Salir");
            System.out.print("Seleccione: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Zona (1-3): ");
                    int zona = sc.nextInt();

                    System.out.print("Pasajeros diarios: ");
                    int pasajeros = sc.nextInt();

                    metro.agregar(nombre, zona, pasajeros);
                    break;

                case 2:
                    metro.mostrar();
                    break;

                case 3:
                    System.out.print("Origen: ");
                    String origen = sc.nextLine();

                    System.out.print("Destino: ");
                    String destino = sc.nextLine();

                    metro.rutaMasCorta(origen, destino);
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        } while (opcion != 0);

        sc.close();
    }
}
