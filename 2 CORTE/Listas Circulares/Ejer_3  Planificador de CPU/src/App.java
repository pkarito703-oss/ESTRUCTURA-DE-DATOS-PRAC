import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Planificador p = new Planificador();

        int opcion;

        do {
            System.out.println("\n--- PLANIFICADOR ROUND ROBIN ---");
            System.out.println("1. Agregar proceso");
            System.out.println("2. Mostrar procesos");
            System.out.println("3. Ejecutar");
            System.out.println("4. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("PID: ");
                    int pid = sc.nextInt();

                    System.out.print("Tiempo restante: ");
                    int tiempo = sc.nextInt();

                    System.out.print("Prioridad (1-3): ");
                    int prioridad = sc.nextInt();

                    p.agregar(nombre, pid, tiempo, prioridad);
                    break;

                case 2:
                    p.mostrar();
                    break;

                case 3:
                    System.out.print("Ingrese quantum: ");
                    int quantum = sc.nextInt();
                    p.ejecutar(quantum);
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        } while (opcion != 4);

        sc.close();
    }
}
