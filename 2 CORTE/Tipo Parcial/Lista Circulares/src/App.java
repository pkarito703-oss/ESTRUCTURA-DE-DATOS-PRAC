import java.util.Scanner;

/*
 * Clase principal (Main)
 * Contiene el menú interactivo
 */
public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Carrusel carrusel = new Carrusel();

        int opcion;

        /*
         * Menú interactivo con switch
         */
        do {
            System.out.println("\n===== CARRUSEL DE ANUNCIOS =====");
            System.out.println("1. Agregar anuncio");
            System.out.println("2. Mostrar anuncios");
            System.out.println("3. Reproducir carrusel");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {

                case 1:
                    // Captura de datos
                    System.out.print("Titulo: ");
                    String titulo = sc.nextLine();

                    System.out.print("Duración (segundos): ");
                    int duracion = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Categoria (Oferta, Marca, Evento): ");
                    String categoria = sc.nextLine();

                    carrusel.agregarAnuncio(titulo, duracion, categoria);

                    System.out.println("Anuncio agregado correctamente.");
                    break;

                case 2:
                    carrusel.mostrar();
                    break;

                case 3:
                    System.out.print("Ingrese cantidad de ciclos: ");
                    int ciclos = sc.nextInt();

                    carrusel.reproducir(ciclos);
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
