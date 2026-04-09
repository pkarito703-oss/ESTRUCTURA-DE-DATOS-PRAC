/*3. Navegación de Pestañas de Navegador
Imagina un navegador donde puedes moverte entre pestañas abiertas.

La Clase Pestana (Nodo): Debe contener tituloPagina (String), url (String) y horaApertura (String).
El Problema: Las pestañas se abren una tras otra. A veces el usuario quiere cerrar la pestaña actual y el foco debe pasar a la pestaña anterior.
Reto: Implementar el método cerrarPestanaActual(String url) que busque la pestaña por URL, la elimine de la lista y reconecte el nodo anterior con el siguiente correctamente (¡Cuidado con la Cabeza y la Cola!).
*/
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Navegador nav = new Navegador();
        int op;

        do {
            System.out.println("\n===== NAVEGADOR =====");
            System.out.println("1. Abrir pestaña");
            System.out.println("2. Mostrar actual");
            System.out.println("3. Siguiente");
            System.out.println("4. Anterior");
            System.out.println("5. Cerrar pestaña por URL");
            System.out.println("6. Mostrar todas");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    System.out.print("Titulo: ");
                    String titulo = sc.nextLine();

                    System.out.print("URL: ");
                    String url = sc.nextLine();

                    System.out.print("Hora: ");
                    String hora = sc.nextLine();

                    nav.abrirPestana(titulo, url, hora);
                    break;

                case 2:
                    nav.mostrarActual();
                    break;

                case 3:
                    nav.siguiente();
                    break;

                case 4:
                    nav.anterior();
                    break;

                case 5:
                    System.out.print("Ingrese URL a cerrar: ");
                    String cerrar = sc.nextLine();
                    nav.cerrarPestanaActual(cerrar);
                    break;

                case 6:
                    nav.mostrarTodas();
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción invalida");
            }

        } while (op != 0);

        sc.close();
    }
}
