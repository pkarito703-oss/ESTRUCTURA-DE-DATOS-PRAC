/*Ejercicio 1: Inventario "TecnoStore" (Shell Sort)
Objetivo:
Registrar productos y ordenarlos por su ID para realizar búsquedas rápidas.
¿Qué debes hacer?
1.Clase:Crea una claseProductocon:id(int),nombre(String),precio (double) y stock(int).
2.Entrada de Datos:Pide al usuario que ingrese los datos de 5 productos por teclado y guárdalos en un arreglo Producto[].
3.Ordenamiento:Usa Shell Sort para ordenar los productos de menor a mayor según su id.
4.Búsqueda:Pide un id al usuario y búscalo usando Búsqueda Binaria.*/

import java.util.Scanner;

class Producto {
    int id;
    String nombre;
    double precio;
    int stock;

    public Producto(int id, String nombre, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }
}

public class Ejer_1 {

    // Shell Sort
    public static void shellSort(Producto[] productos) {
        int n = productos.length;

        for (int salto = n / 2; salto > 0; salto /= 2) {
            for (int i = salto; i < n; i++) {
                Producto temp = productos[i];
                int j = i;

                while (j >= salto && productos[j - salto].id > temp.id) {
                    productos[j] = productos[j - salto];
                    j -= salto;
                }
                productos[j] = temp;
            }
        }
    }

    //Búsqueda Binaria
    public static int busquedaBinaria(Producto[] productos, int idBuscado) {
        int inicio = 0;
        int fin = productos.length - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;

            if (productos[medio].id == idBuscado) {
                return medio;
            } else if (productos[medio].id < idBuscado) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Producto[] productos = new Producto[5];

        //REGISTRO
        System.out.println("--- REGISTRO DE PRODUCTOS ---");

        for (int i = 0; i < 5; i++) {
            System.out.println("Producto " + (i + 1) + ":");

            System.out.print("Ingrese ID: ");
            int id = leer.nextInt();
            leer.nextLine();

            System.out.print("Ingrese Nombre: ");
            String nombre = leer.nextLine();

            System.out.print("Ingrese Precio: ");
            double precio = leer.nextDouble();

            System.out.print("Ingrese Stock: ");
            int stock = leer.nextInt();

            productos[i] = new Producto(id, nombre, precio, stock);
        }

        //ORDENAMIENTO
        shellSort(productos);

        System.out.println("\n--- INVENTARIO ORDENADO POR ID (Shell Sort) ---");

        for (Producto p : productos) {
        System.out.printf("ID: %-5d | Nombre: %-15s | Precio: %-10.1f | Stock: %-5d%n",
            p.id, p.nombre, p.precio, p.stock);
}

        //BÚSQUEDA
        System.out.println("\n--- BÚSQUEDA DE PRODUCTO ---");
        System.out.print("Ingrese el ID a buscar: ");
        int idBuscado = leer.nextInt();

        int pos = busquedaBinaria(productos, idBuscado);

        if (pos != -1) {
            Producto p = productos[pos];
            System.out.println(">> PRODUCTO ENCONTRADO: " +
                    p.nombre + " - Precio: $" + p.precio +
                    " - Stock: " + p.stock);
        } else {
            System.out.println(">> PRODUCTO NO ENCONTRADO");
        }

        leer.close();
    }
}
