//3. El Salto de Shell (Optimización de Datos)
//Algoritmo obligatorio: Ordenamiento Shell (Shell Sort)

//Contexto: Una empresa de logística maneja paquetes con diferentes pesos y necesita ordenarlos de forma más eficiente que el método de burbuja o inserción simple.
//Detalle del ejercicio: Solicita al usuario el peso de N paquetes (se recomienda probar con al menos 10 para notar el efecto).
//Lógica de Shell: Implementa el algoritmo usando el salto (gap) inicial de 
//N/2El estudiante debe explicar en comentarios por qué este método es generalmente más rápido que la inserción simple al trabajar con elementos que están muy lejos de su posición final.
//Resultado esperado: Mostrar el arreglo original y el arreglo final ordenado después de aplicar todas las fases de reducción de saltos.

import java.util.Scanner;
import java.util.Arrays;

public class Ejer_3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de paquetes: ");
        int n = sc.nextInt();

        double[] pesos = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese el peso del paquete " + (i + 1) + ": ");
            pesos[i] = sc.nextDouble();
        }

        System.out.println("\nPesos originales:");
        System.out.println(Arrays.toString(pesos));

        // SHELL SORT
        for (int gap = n / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < n; i++) {

                double temp = pesos[i];
                int j;

                for (j = i; j >= gap && pesos[j - gap] > temp; j -= gap) {
                    pesos[j] = pesos[j - gap];
                }
                pesos[j] = temp;
            }
        }
        System.out.println("\nPesos ordenados:");
        System.out.println(Arrays.toString(pesos));

        sc.close();
    }
}
// RESPUESTAAAAA:
// Shell Sort es más rápido que Insertion Sort porque compara elementos
// que están lejos entre sí usando saltos (gap). Esto permite mover
// rápidamente los valores que están muy lejos de su posición final.
// Cuando el gap se reduce a 1, el arreglo ya está casi ordenado,
// haciendo que el proceso final sea mucho más rápido.