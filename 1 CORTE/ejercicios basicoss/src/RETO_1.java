import java.util.Scanner;

public class RETO_1 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        double[] precios = new double[5];
        double sumaTotal = 0;
        double precioMayor = 0;

        
        for (int i = 0; i < precios.length; i++) {
            System.out.print("Ingrese el precio #" + (i + 1) + ": ");
            precios[i] = sc.nextDouble();
            
            sumaTotal += precios[i];
            
            if (i == 0 || precios[i] > precioMayor) {
                precioMayor = precios[i];
            }
        }

        System.out.println("\nSuma total: $" + sumaTotal);

        System.out.println("El precio más alto ingresado es: $" + precioMayor);

        if (sumaTotal > 20000) {
            System.out.println("¡Tienes un descuento de 2.000!");
            sumaTotal -= 2000;
        }

        System.out.println("Total final a pagar: $" + sumaTotal);

        sc.close();
    }
}
