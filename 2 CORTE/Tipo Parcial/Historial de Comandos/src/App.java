import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Historial historial = new Historial();

        int opcion;

        do {
            System.out.println("\nMENU HISTORIAL");
            System.out.println("1. Nuevo comando");
            System.out.println("2. Comando anterior");
            System.out.println("3. Comando siguiente");
            System.out.println("4. Borrar actual");
            System.out.println("5. Buscar comando");
            System.out.println("6. Mostrar historial");
            System.out.println("7. Salir");
            System.out.print("Seleccione: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese comando: ");
                    String cmd = sc.nextLine();

                    System.out.print("Hora: ");
                    String hora = sc.nextLine();

                    historial.agregar(cmd, hora);
                    break;

                case 2:
                    historial.anterior();
                    break;

                case 3:
                    historial.siguiente();
                    break;

                case 4:
                    historial.borrarActual();
                    break;

                case 5:
                    System.out.print("Buscar texto exacto: ");
                    String buscar = sc.nextLine();
                    historial.buscar(buscar);
                    break;

                case 6:
                    historial.mostrarHistorial();
                    break;

                case 7:
                    System.out.println("Saliendo....");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 7);

        sc.close();
    }
}
