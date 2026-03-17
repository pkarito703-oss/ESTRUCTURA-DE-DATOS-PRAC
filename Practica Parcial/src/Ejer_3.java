
/*
Ejercicio 3: Control de Notas (Selección)
Objetivo:Gestionar las notas de un grupo, encontrar los valores extremos y ordenar la lista.
¿Qué debes hacer?
1. Entrada:Pide al usuario 5 notas (números decimales) por teclado.
2. Estadísticas:Recorre el arreglo para encontrar cuál es la nota más alta y cuál la más baja del grupo.
3. Ordenamiento:Ordena las notas de menor a mayor usando el algoritmo de Selección (Selection Sort).
*/

import java.util.Arrays;
import java.util.Scanner;

public class Ejer_3 {

    // Selection Sort (menor a mayor)
    public static void selectionSort(double[] notas) {
        int n = notas.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (notas[j] < notas[minIndex]) {
                    minIndex = j;
                }
            }

            // Intercambio
            double temp = notas[i];
            notas[i] = notas[minIndex];
            notas[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        double[] notas = new double[5];

        //REGISTRO
        System.out.println("--- REGISTRO DE NOTAS ---");

        for (int i = 0; i < 5; i++) {
            System.out.print("Ingrese nota del Estudiante " + (i + 1) + ": ");
            notas[i] = leer.nextDouble();
        }

        //ESTADÍSTICAS
        double mayor = notas[0];
        double menor = notas[0];

        for (int i = 1; i < notas.length; i++) {
            if (notas[i] > mayor) {
                mayor = notas[i];
            }
            if (notas[i] < menor) {
                menor = notas[i];
            }
        }

        System.out.println("\n--- INFORME ACADÉMICO ---");
        System.out.println("La nota más ALTA del grupo es: " + mayor);
        System.out.println("La nota más BAJA del grupo es: " + menor);

        //ORDENAMIENTO
        selectionSort(notas);

        //MOSTRAR ORDENADO
        System.out.println("\n--- LISTA DE NOTAS ORDENADA (Menor a Mayor) ---");
        System.out.println(Arrays.toString(notas));

        leer.close();
    }
}