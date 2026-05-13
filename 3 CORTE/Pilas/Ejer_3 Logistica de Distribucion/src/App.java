/*3. Logística de Distribución (Callejón sin Salida)
Un centro de logística urbana tiene un muelle de carga ubicado al final de un callejón muy estrecho. Los camiones de reparto entran uno tras otro y quedan "atrapados" en el orden de llegada. El último camión en entrar debe ser obligatoriamente el primero en salir para permitir que los demás se retiren.

La Clase Camion (Nodo): Debe contener placa (String), conductor (String) y cargaToneladas (double).
El Problema: El supervisor necesita saber cuánta carga total hay en el callejón sin mover los camiones físicamente (solo consultando la estructura).
Reto: Implementa un método que recorra la pila (sin destruirla permanentemente, o reconstruyéndola) y calcule la suma total de cargaToneladas de todos los camiones estacionados.
*/
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        PilaControl pila = new PilaControl();

        // DATOS DE PRUEBA
        pila.push("ABC123", "Carlos Perez", 8.5);
        pila.push("XYZ456", "Juan Torres", 12.3);
        pila.push("KLM789", "Ana Rojas", 6.7);
        pila.push("DEF321", "Luis Gomez", 10.2);

        int opcion;

        do {

            System.out.println("\n========== MENU ==========");
            System.out.println("1. Agregar camion");
            System.out.println("2. Mostrar callejon");
            System.out.println("3. Ver camion en el tope");
            System.out.println("4. Retirar camion");
            System.out.println("5. Calcular carga total");
            System.out.println("0. Salir");

            System.out.print("Seleccione una opcion: ");
            opcion = leer.nextInt();
            leer.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print("Placa: ");
                    String placa = leer.nextLine();

                    System.out.print("Conductor: ");
                    String conductor = leer.nextLine();

                    System.out.print("Carga en toneladas: ");
                    double carga = leer.nextDouble();

                    pila.push(placa, conductor, carga);

                    System.out.println("Camion agregado correctamente");
                    break;

                case 2:

                    pila.mostrarPila();
                    break;

                case 3:

                    Nodo cima = pila.peek();

                    if (cima == null) {

                        System.out.println("No hay camiones");

                    } else {

                        System.out.println("\nCAMION EN EL TOPE");
                        System.out.println("Placa: " + cima.placa);
                        System.out.println("Conductor: " + cima.conductor);
                        System.out.println("Carga: "
                                + cima.cargaToneladas
                                + " toneladas");

                    }

                    break;

                case 4:

                    Nodo retirado = pila.pop();

                    if (retirado == null) {

                        System.out.println("No hay camiones");

                    } else {

                        System.out.println(
                                "Camion retirado: "
                                        + retirado.placa
                        );

                    }

                    break;

                case 5:

                    double total = pila.calcularCargaTotal();

                    System.out.println(
                            "\nCarga total en el callejon: "
                                    + total
                                    + " toneladas"
                    );

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