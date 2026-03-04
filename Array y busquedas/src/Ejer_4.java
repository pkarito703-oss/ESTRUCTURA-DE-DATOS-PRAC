 //Control de Acceso (Gimnasio)
//Un gimnasio tiene una lista de códigos de acceso de los socios que pagaron 
//la mensualidad. La lista está ordenada de menor a mayor.

//El Problema: Cuando un socio digita su código, el sistema debe validar si el código está en la lista de "pagos al día". Si no está, se le niega la entrada.
//Algoritmo a usar: Búsqueda Binaria. Es eficiente para buscar códigos numéricos en una lista que ya está organizada.
import java.util.Scanner;

public class Ejer_4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] codigos = new int[500];

        for (int i = 0; i < codigos.length; i++) {
            codigos[i] = 1000 + i;
        }

        System.out.print("Ingrese su codigo de acceso: ");
        int codigoIngresado = sc.nextInt();

        int izquierda = 0;
        int derecha = codigos.length - 1;
        boolean autorizado = false;

        while (izquierda <= derecha) {

            int medio = (izquierda + derecha) / 2;

            if (codigos[medio] == codigoIngresado) {
                autorizado = true;
                break;
            } 
            else if (codigoIngresado > codigos[medio]) {
                izquierda = medio + 1;
            } 
            else {
                derecha = medio - 1;
            }
        }

        if (autorizado) {
            System.out.println("Acceso permitido. Bienvenido al gimnasio.");
        } else {
            System.out.println("Acceso denegado. Mensualidad pendiente.");
        }

        sc.close();
    }
}