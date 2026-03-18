
import java.util.Arrays;
import java.util.Scanner;

public class Gym {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] pesos = new int[7];

        System.out.println("Ingrese 7 pesos del gym:");
        for (int i = 0; i < pesos.length; i++) {
            System.out.print("Peso " + (i + 1) + ": ");
            pesos[i] = sc.nextInt();
        }

        //desordenados
        System.out.println("\nPesos desordenados:");
            System.out.println(Arrays.toString(pesos));

        // Bubble Sort
        for (int i = 0; i < pesos.length - 1; i++) {
            for (int j = 0; j < pesos.length - 1 - i; j++) {
                if (pesos[j] < pesos[j + 1]) {
                    int temp = pesos[j];
                    pesos[j] = pesos[j + 1];
                    pesos[j + 1] = temp;
                }
            }
        }

        //ordenados
        System.out.println("\n\nPesos ordenados (Descendente):");
         System.out.println(Arrays.toString(pesos));

        // busqueda lineal
        System.out.print("\n\nIngrese el peso a buscar: ");
        int buscado = sc.nextInt();
        boolean encontrado = false;

        for (int i = 0; i < pesos.length; i++) {
            if (pesos[i] == buscado) {
                System.out.println("Peso encontrado en la posición: " + i);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Peso no encontrado.");
        }

        // maximo
        double max = pesos[0];
        for (int i = 1; i < pesos.length; i++) {
            if (pesos[i] > max) {
                max = pesos[i];
            }
        }

        System.out.println("\nEl peso maximo es: " + max);

        sc.close();
    }
}