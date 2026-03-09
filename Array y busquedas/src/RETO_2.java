import java.util.Scanner;

public class RETO_2 {

    public static void main(String[] args) {

        int[] listaNegra = { 456, 123, 987, 898, 456, 888 };
        Scanner sc = new Scanner(System.in);
        int[] id = new int[8];

        for (int i = 0; i < id.length; i++) {
            System.out.print("Ingrese los id " + (i + 1) + ": ");
            id[i] = sc.nextInt();
        }

        double max = id[0];

        for (int i = 1; i < id.length; i++) {
            if (id[i] > max) {
                max = id[i];
            }
        }
        System.out.println("El id mas alto encontrado fue: " + max);

        int izquierda = 0;
        int derecha = id.length - 1;
        int posicion = -1;

        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;

            if (id[medio] == max) {
                posicion = medio;
                break;
            } else if (id[medio] < max) {
                izquierda = medio + 1; // Buscar en la mitad derecha
            } else {
                derecha = medio - 1; // Buscar en la mitad izquierda
            }
        }

        if (posicion != -1) {
            System.out.println("ENCONTRADO: " + max);
        } else {
            System.out.println("No encontrado salvado.");
        }

        sc.close();

    }
}
