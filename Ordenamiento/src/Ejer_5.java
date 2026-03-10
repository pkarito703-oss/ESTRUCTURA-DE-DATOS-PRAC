//5. El Inspector de Eficiencia (Duelo de Métodos)
//Algoritmos obligatorios: Selección vs Inserción

//Contexto: Un analista de sistemas quiere saber cuál algoritmo es más "pesado" en términos de operaciones para un caso específico.
//Detalle del ejercicio: El usuario debe ingresar 6 números enteros desordenados. El programa aplicará AMBOS métodos al mismo conjunto de datos (puedes usar una copia del arreglo original).
//Lógica de Conteo:
//En Selección: Cuenta cada vez que ocurre un swap (intercambio físico de posiciones).
//En Inserción: Cuenta cada vez que un elemento se "mueve" hacia la izquierda dentro del bucle interno.
//Resultado esperado: El programa debe imprimir cuántos intercambios hizo Selección y cuántos movimientos hizo Inserción. El estudiante debe concluir cuál fue más eficiente para esos datos ingresados por el teclado.

import java.util.Arrays;
import java.util.Scanner;

public class Ejer_5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] original = new int[6];

        System.out.println("Ingrese 6 numeros:");

        for (int i = 0; i < 6; i++) {
            original[i] = sc.nextInt();
        }

        int[] seleccion = original.clone();
        int[] insercion = original.clone();

        System.out.println("******************************************");
        System.out.println("Originales:" + Arrays.toString(original));

        int swaps = 0;
        int movimientos = 0;

        // SELECTION SORT
        for (int i = 0; i < seleccion.length - 1; i++) {

            int min = i;

            for (int j = i + 1; j < seleccion.length; j++) {
                if (seleccion[j] < seleccion[min]) {
                    min = j;
                }
            }

            if (min != i) {
                int temp = seleccion[i];
                seleccion[i] = seleccion[min];
                seleccion[min] = temp;

                swaps++;
            }
        }

        // INSERTION SORT
        for (int i = 1; i < insercion.length; i++) {

            int clave = insercion[i];
            int j = i - 1;

            while (j >= 0 && insercion[j] > clave) {

                insercion[j + 1] = insercion[j];
                j--;

                movimientos++;
            }

            insercion[j + 1] = clave;
        }

        System.out.println("\nIntercambios en Selection Sort: " + swaps);
        System.out.println("Movimientos en Insertion Sort: " + movimientos);

        System.out.println("\nOrdenado: " + Arrays.toString(seleccion));
        System.out.println("******************************************");

        sc.close();
    }
}

// RESPUESTAAAA:
// El método Inserción es más eficiente porque solo mueve los elementos
// necesarios para ordenarlos. En cambio, Selección siempre recorre todo el
// arreglo buscando el número menor, lo que puede hacer más operaciones.