//Una tienda de barrio vende productos al por menor. El cajero necesita calcular:
//Precio unitario de un producto (double)
//Cantidad comprada (int)
//Descuento aplicado en porcentaje (double)
//Total a pagar después del descuento
//Declara las variables, realiza el cálculo y muestra el resultado por consola.

import java.util.Scanner;
public class Ejer_2 { 
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int Precio_Pan = 500;
        int Precio_Leche = 1500;
        int Precio_Huevo = 3000;
        System.out.println("**********Tienda de Barrio Minorista*************");
        System.out.println("Todos los productos tienen un 10% de descuento");
        System.out.println("Productos disponibles: \nPan: $ " + Precio_Pan + "\nLeche: $ " + Precio_Leche + "\nHuevo: $ " + Precio_Huevo);
        System.out.println("Ingrese el producto que desea comprar: ");

        String producto = scanner.nextLine();

        System.out.println("Ingrese la cantidad que desea comprar: ");
        int cantidad = scanner.nextInt();

        if (producto.equalsIgnoreCase("Pan")) {
            int total = Precio_Pan * cantidad;
            System.out.println("El precio del pan es: " + Precio_Pan);
            System.out.println("La cantidad que desea comprar es: " + cantidad);
            System.out.println("el descuento aplicado es del 10%");
            double descuento = total * 0.10;
            System.out.println("El total a pagar por " + cantidad + " unidades de Pan es: " + (total - descuento));
            System.out.println("el total sin descuento es de: " + total);
        } else if (producto.equalsIgnoreCase("Leche")) {
            int total = Precio_Leche * cantidad;
            System.out.println("El precio de la leche es: " + Precio_Leche);
            System.out.println("La cantidad que desea comprar es: " + cantidad);
            System.out.println("el descuento aplicado es del 10%");
            double descuento = total * 0.10;
            System.out.println("El total a pagar por " + cantidad + " unidades de Leche es: " + (total - descuento));
            System.out.println("el total sin descuento es de: " + total);
        } else if (producto.equalsIgnoreCase("Huevo")) {
            int total = Precio_Huevo * cantidad;
            System.out.println("El precio del huevo es: " + Precio_Huevo);
            System.out.println("La cantidad que desea comprar es: " + cantidad);
            System.out.println("el descuento aplicado es del 10%");
            double descuento = total * 0.10;
            System.out.println("El total a pagar por " + cantidad + " unidades de Huevo es: " + (total - descuento));
            System.out.println("el total sin descuento es de: " + total);
        } else {
            System.out.println("Producto no disponible.");
        } 
    }
}