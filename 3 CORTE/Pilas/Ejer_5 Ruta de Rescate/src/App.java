/*5. Ruta de Rescate (Espeleología Geológica)
Un equipo de rescatistas entra en una cueva inexplorada. Para no perderse, van dejando "Estaciones de Seguridad" representadas por una baliza que registra los datos del entorno.

La Clase Estacion (Nodo): Debe contener nombrePunto (String), profundidad (int) y nivelOxigeno (double).
El Problema: Para salir de la cueva, el equipo debe seguir las estaciones en el orden inverso al que fueron colocadas (de la más profunda a la entrada).
Reto: Implementa el método retrocederASuperficie(). Este debe mostrar el nombre de cada estación a medida que se desapila. Importante: Si en alguna estación el nivelOxigeno es inferior al 18%, el sistema debe imprimir una alerta de "Uso de Tanque de Emergencia Requerido" al pasar por ese punto.
*/
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        PilaControl pila = new PilaControl();

                    // DATOS DE PRUEBA
            pila.push("Tunel Norte", 12, 20.8);
            pila.push("Tunel Oscura", 40, 18.9);
            pila.push("Paso Estrecho", 75, 17.0);
            pila.push("Pozo de Eco", 110, 16.2);
            pila.push("Tunel Abandonado", 145, 14.8);

        int opcion;

        do {

            System.out.println("\n========== MENU ==========");
            System.out.println("1. Agregar estacion");
            System.out.println("2. Mostrar ruta");
            System.out.println("3. Retroceder a superficie");
            System.out.println("4. Ver estacion en el tope");
            System.out.println("5. Retirar estacion");
            System.out.println("0. Salir");

            System.out.print("Seleccione una opcion: ");
            opcion = leer.nextInt();
            leer.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print("Nombre del punto: ");
                    String nombre = leer.nextLine();

                    System.out.print("Profundidad: ");
                    int profundidad = leer.nextInt();

                    System.out.print("Nivel de oxigeno: ");
                    double oxigeno = leer.nextDouble();

                    pila.push(nombre, profundidad, oxigeno);

                    System.out.println("Estacion agregada");
                    break;

                case 2:

                    pila.mostrarPila();
                    break;

                case 3:

                    pila.retrocederASuperficie();
                    break;

                case 4:

                    Nodo cima = pila.peek();

                    if (cima == null) {

                        System.out.println("No hay estaciones");

                    } else {

                        System.out.println("\nESTACION EN EL TOPE");
                        System.out.println("Nombre: "
                                + cima.nombrePunto);

                        System.out.println("Profundidad: "
                                + cima.profundidad);

                        System.out.println("Oxigeno: "
                                + cima.nivelOxigeno + "%");
                    }

                    break;

                case 5:

                    Nodo retirada = pila.pop();

                    if (retirada == null) {

                        System.out.println("No hay estaciones");

                    } else {

                        System.out.println(
                                "Estacion retirada: "
                                        + retirada.nombrePunto
                        );

                    }

                    break;

                case 0:

                    System.out.println("Programa finalizado");
                    break;

                default:

                    System.out.println("Opcion invalida");
            }

        } while (opcion != 0);

    }
}
