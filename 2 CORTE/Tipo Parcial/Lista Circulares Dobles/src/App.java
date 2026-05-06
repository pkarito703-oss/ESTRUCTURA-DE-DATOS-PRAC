import java.util.Scanner;

/*
 * Clase principal
 * Contiene el menú interactivo
 */
public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Metro metro = new Metro();

        // =========================
        // ESTACIONES PREDEFINIDAS
        // (mínimo 6 como pide el reto)
        // =========================
        metro.agregarEstacion("Centro", 1, 5000);
        metro.agregarEstacion("Norte", 2, 3000);
        metro.agregarEstacion("Sur", 3, 4000);
        metro.agregarEstacion("Universidad", 1, 6000);
        metro.agregarEstacion("Aeropuerto", 3, 7000);
        metro.agregarEstacion("Estadio", 2, 3500);

        int opcion;

        do {
            System.out.println("\n===== METRO CIRCULAR =====");
            System.out.println("1. Mostrar estaciones");
            System.out.println("2. Calcular ruta más corta");
            System.out.println("3. Agregar estación");
            System.out.println("4. Salir");
            System.out.print("Opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    metro.mostrar();
                    break;

                case 2:
                    System.out.print("Origen: ");
                    String origen = sc.nextLine();

                    System.out.print("Destino: ");
                    String destino = sc.nextLine();

                    metro.rutaMasCorta(origen, destino);
                    break;

                case 3:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Zona (1-3): ");
                    int zona = sc.nextInt();

                    System.out.print("Pasajeros diarios: ");
                    int pasajeros = sc.nextInt();

                    metro.agregarEstacion(nombre, zona, pasajeros);
                    System.out.println("Estación agregada.");
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 4);

        sc.close();
    }
}
