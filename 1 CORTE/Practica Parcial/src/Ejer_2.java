/*
Ejercicio 2: Competencia de Atletismo (Inserción)
Objetivo:Ingresar puntajes y organizarlos de mayor a menor para determinar el podio.
¿Qué debes hacer?
1. Entrada:Pide al usuario que ingrese 6 puntajes (números enteros) por teclado.
2. Ordenamiento:Usa el algoritmo de Inserción (Insertion Sort) para ordenar los puntajes de mayor a menor.
3. Búsqueda:Pide un puntaje al usuario y búscalo usando Búsqueda Lineal.
Debes indicar en qué posición (lugar) de la tabla quedó.*/

import java.util.Scanner;

public class Ejer_2 {

    // Insertion Sort (de mayor a menor)
    public static void insertionSort(int[] puntajes) {
        int n = puntajes.length;

        for (int i = 1; i < n; i++) {
            int key = puntajes[i];
            int j = i - 1;

            // Orden descendente
            while (j >= 0 && puntajes[j] < key) {
                puntajes[j + 1] = puntajes[j];
                j--;
            }
            puntajes[j + 1] = key;
        }
    }

    // Búsqueda Lineal
    public static int busquedaLineal(int[] puntajes, int buscado) {
        for (int i = 0; i < puntajes.length; i++) {
            if (puntajes[i] == buscado) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int[] puntajes = new int[6];
        double suma = 0;

        //INGRESO
        System.out.println("--- INGRESO DE PUNTAJES ---");

        for (int i = 0; i < 6; i++) {
            System.out.print("Puntaje del Intento " + (i + 1) + ": ");
            puntajes[i] = leer.nextInt();
            suma += puntajes[i];
        }

        //ORIGINAL
        System.out.println("\n--- PUNTAJES ORIGINALES ---");
        for (int i = 0; i < puntajes.length; i++) {
        System.out.print(puntajes[i] + " ");
        }
        System.out.println();

        //ORDENAR
        insertionSort(puntajes);

        //MOSTRAR RESULTADOS
        System.out.println("\n--- TABLA DE RESULTADOS (De mayor a menor) ---");

        for (int i = 0; i < puntajes.length; i++) {
            System.out.println((i + 1) + "° Lugar: " + puntajes[i]);
        }

        //PROMEDIO
        double promedio = suma / puntajes.length;
        System.out.printf("El promedio total de los puntajes fue: %.1f%n", promedio);

        //BÚSQUEDA
        System.out.println("\n--- BÚSQUEDA LINEAL ---");
        System.out.print("Ingrese puntaje a buscar: ");
        int buscado = leer.nextInt();

        int pos = busquedaLineal(puntajes, buscado);

        if (pos != -1) {
            System.out.println(">> El puntaje " + buscado +
                    " se encuentra en el " + (pos + 1) + "° lugar de la tabla.");
        } else {
            System.out.println(">> Puntaje no encontrado.");
        }

        leer.close();
    }
}