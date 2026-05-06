

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Ruleta ruleta = new Ruleta();

        int opcion;

        do {
            System.out.println("\n===== MENÚ RULETA =====");
            System.out.println("1. Agregar participante");
            System.out.println("2. Siguiente turno");
            System.out.println("3. Turno anterior");
            System.out.println("4. Mostrar todos");
            System.out.println("0. Salir");
            System.out.print("Seleccione: ");

            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {

                case 1:
                    System.out.print("Ingrese nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Ingrese número de boleto: ");
                    int boleto = sc.nextInt();

                    ruleta.insertar(nombre, boleto);
                    break;

                case 2:
                    ruleta.siguiente();
                    break;

                case 3:
                    ruleta.anterior();
                    break;

                case 4:
                    ruleta.mostrarTodos();
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
