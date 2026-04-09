/*2. Carrusel de Imágenes (Galería Interactiva)
Simula el comportamiento de una galería de fotos en una aplicación móvil.
La Clase Fotografia (Nodo): Debe contener nombreArchivo (String), tamanoMB (double) y resolucion (String).
El Problema: El usuario puede avanzar a la "Siguiente Foto" o retroceder a la "Foto Anterior". Si llega al final, no puede avanzar más (a menos que sea circular, pero por ahora manténlo lineal).
Reto: Crea un método reproducirGaleria() que recorra toda la lista hacia adelante y luego toda la lista hacia atrás para mostrar todas las fotos.
*/
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Carrusel carrusel = new Carrusel();
        int opcion;

        do {
            System.out.println("\n=====  CARRUSEL =====");
            System.out.println("1. Agregar foto");
            System.out.println("2. Mostrar actual");
            System.out.println("3. Siguiente");
            System.out.println("4. Anterior");
            System.out.println("5. Reproducir galería");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Tamaño MB: ");
                    double tamano = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Resolucion: ");
                    String resolucion = sc.nextLine();

                    carrusel.agregarFoto(nombre, tamano, resolucion);
                    break;

                case 2:
                    carrusel.mostrarActual();
                    break;

                case 3:
                    carrusel.siguiente();
                    break;

                case 4:
                    carrusel.anterior();
                    break;

                case 5:
                    carrusel.reproducirGaleria();
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
