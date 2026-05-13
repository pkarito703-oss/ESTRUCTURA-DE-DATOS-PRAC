/*2. Control de Calidad (Línea de Ensamblaje)
Un brazo robótico en una fábrica de motores apila componentes siguiendo una secuencia precisa. Un sensor de visión artificial inspecciona cada pieza después de ser colocada.

La Clase Pieza (Nodo): Debe contener nombrePieza (String), numeroSerie (String) y esDefectuosa (boolean).
El Problema: Si el sensor detecta una pieza defectuosa, la línea de producción debe detenerse inmediatamente.
Reto: Crea un método limpiarHastaDefecto() que extraiga (pop) todas las piezas de la pila hasta encontrar la primera que tenga esDefectuosa = true. El método debe imprimir el nombre de todas las piezas "buenas" que tuvieron que ser retiradas y descartadas antes de llegar a la pieza fallida.
*/
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        PilaControl pila = new PilaControl();

        // DATOS DE PRUEBA
        pila.push("Motor", "M001", false);
        pila.push("Pistón", "P002", false);
        pila.push("Válvula", "V003", false);
        pila.push("Engranaje", "E004", true);
        pila.push("Filtro", "F005", false);

        int opcion;

        do {

            System.out.println("\n========== MENU ==========");
            System.out.println("1. Agregar pieza");
            System.out.println("2. Mostrar pila");
            System.out.println("3. Limpiar hasta defecto");
            System.out.println("4. Ver pieza en el tope");
            System.out.println("5. Retirar pieza");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = leer.nextInt();
            leer.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print("Nombre de la pieza: ");
                    String nombre = leer.nextLine();

                    System.out.print("Numero de serie: ");
                    String serie = leer.nextLine();

                    System.out.print("Es defectuosa? (true/false): ");
                    boolean defecto = leer.nextBoolean();

                    pila.push(nombre, serie, defecto);

                    System.out.println("Pieza agregada correctamente");
                    break;

                case 2:

                    pila.mostrarPila();
                    break;

                case 3:

                    pila.limpiarHastaDefecto();
                    break;

                case 4:

                    Nodo cima = pila.peek();

                    if (cima == null) {

                        System.out.println("La pila esta vacia");

                    } else {

                        System.out.println("\nPIEZA EN EL TOPE");
                        System.out.println("Nombre: " + cima.nombrePieza);
                        System.out.println("Serie: " + cima.numeroSerie);
                        System.out.println("Defectuosa: " + cima.esDefectuosa);

                    }

                    break;

                case 5:

                    Nodo retirada = pila.pop();

                    if (retirada == null) {

                        System.out.println("La pila esta vacia");

                    } else {

                        System.out.println("Pieza retirada: "
                                + retirada.nombrePieza);

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
