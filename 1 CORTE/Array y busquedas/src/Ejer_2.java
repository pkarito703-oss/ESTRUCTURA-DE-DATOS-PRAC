//Buscador de Cédulas (Base de Datos Bancaria)
//Un banco tiene una lista de 1.000 clientes organizados de forma estricta y 
//ascendente por su número de cédula o ID.

//El Problema: Un cliente llega a la ventanilla y da su número. El sistema debe encontrar sus datos de la manera más rápida posible (en pocos pasos).
//Algoritmo a usar: Búsqueda Binaria. Como los datos ya están ordenados, este algoritmo permitirá encontrar al cliente dividiendo la lista a la mitad en cada paso.
import java.util.Scanner;

public class Ejer_2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //int[] cedulas = {1001, 1020, 1050, 1100, 1200, 1300, 1500, 1700, 2000};
         int[] cedulas = new int[1000];

        for (int i = 0; i < cedulas.length; i++) {
            cedulas[i] = 1000 + i; 
        }

        System.out.print("Ingrese el numero de cedula a buscar: ");
        int cbuscar = sc.nextInt();

        int izquierda = 0;
        int derecha = cedulas.length - 1;
        int posicion = -1;

        // Búsqueda Binaria
        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;

            if (cedulas[medio] == cbuscar) {
                posicion = medio;
                break;
            } 
            else if (cedulas[medio] < cbuscar) {
                izquierda = medio + 1; // Buscar en la mitad derecha
            } 
            else {
                derecha = medio - 1; // Buscar en la mitad izquierda
            }
        }

        if (posicion != -1) {
            System.out.println("Cliente encontrado en la posicion: " + posicion);
        } else {
            System.out.println("Cliente no encontrado.");
        }

        sc.close();
    }
}
