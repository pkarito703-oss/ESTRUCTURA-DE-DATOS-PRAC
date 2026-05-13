/*4. Farmacia Automatizada (Dispensador Tubo LIFO)
En una farmacia de alta tecnología, los medicamentos de alta rotación se almacenan en tubos dispensadores verticales. El personal introduce las cajas por la parte superior y las retira de la misma forma (el último lote en llegar es el primero en ser despachado).

La Clase Medicamento (Nodo): Debe contener nombre (String), lote (String) y diasParaVencer (int).
El Problema: Por norma de seguridad, no se puede despachar un medicamento si le quedan menos de 10 días para vencer.
Reto: Implementa un método validarDespacho() que revise el medicamento en el tope. Si está a punto de vencer, debe ser retirado automáticamente y el sistema debe revisar el siguiente. El proceso se repite hasta que el tope sea un medicamento seguro o la pila quede vacía.
*/
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        PilaControl pila = new PilaControl();

        // DATOS DE PRUEBA
        pila.push("Pastilla", "K001", 5);
        pila.push("Jarabe", "K002", 7);
        pila.push("Inyeccion", "K003", 15);
        pila.push("Vitamina C", "K004", 30);

        int opcion;

        do {

            System.out.println("\n========== MENU ==========");
            System.out.println("1. Agregar medicamento");
            System.out.println("2. Mostrar dispensador");
            System.out.println("3. Validar despacho");
            System.out.println("4. Ver medicamento en el tope");
            System.out.println("5. Retirar medicamento");
            System.out.println("0. Salir");

            System.out.print("Seleccione una opcion: ");
            opcion = leer.nextInt();
            leer.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print("Nombre: ");
                    String nombre = leer.nextLine();

                    System.out.print("Lote: ");
                    String lote = leer.nextLine();

                    System.out.print("Dias para vencer: ");
                    int dias = leer.nextInt();

                    pila.push(nombre, lote, dias);

                    System.out.println("Medicamento agregado");
                    break;

                case 2:

                    pila.mostrarPila();
                    break;

                case 3:

                    pila.validarDespacho();
                    break;

                case 4:

                    Nodo cima = pila.peek();

                    if (cima == null) {

                        System.out.println("La pila esta vacia");

                    } else {

                        System.out.println("\nMEDICAMENTO EN EL TOPE");
                        System.out.println("Nombre: " + cima.nombre);
                        System.out.println("Lote: " + cima.lote);
                        System.out.println("Dias para vencer: "
                                + cima.diasParaVencer);

                    }

                    break;

                case 5:

                    Nodo retirado = pila.pop();

                    if (retirado == null) {

                        System.out.println("La pila esta vacia");

                    } else {

                        System.out.println(
                                "Medicamento retirado: "
                                        + retirado.nombre
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
