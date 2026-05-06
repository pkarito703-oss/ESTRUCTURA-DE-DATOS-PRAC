import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cartelera cartelera = new Cartelera();

        int opcion;

        do {
            System.out.println("\n1. Agregar | 2. Buscar | 3. Ver cartelera | 4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Digite el título: ");
                    String titulo = sc.nextLine();

                    System.out.print("Digite el género: ");
                    String genero = sc.nextLine();

                    System.out.print("Digite la duración en minutos: ");
                    int duracion = sc.nextInt();
                    sc.nextLine();

                    cartelera.agregarPelicula(titulo, genero, duracion);
                    break;

                case 2:
                    System.out.print("Digite el título a buscar: ");
                    String tituloBuscar = sc.nextLine();

                    cartelera.buscarPorTitulo(tituloBuscar);
                    break;

                case 3:
                    cartelera.verCartelera();
                    break;

                case 4:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 4);

        sc.close();
    }
}

