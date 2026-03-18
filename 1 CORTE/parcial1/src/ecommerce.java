import java.util.Scanner;

public class ecommerce {

    public static class producto {
        int sku;
        String nombre;
        int stock;

        public producto(int sku, String nombre, int stock) {
            this.sku = sku;
            this.nombre = nombre;
            this.stock = stock;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        producto[] productos = new producto[5];

        for (int i = 0; i < productos.length; i++) {
            System.out.println("Producto " + (i + 1) + ":");

            System.out.print("  SKU: ");
            int sku = sc.nextInt();
            sc.nextLine(); // 

            System.out.print("  Nombre: ");
            String nombre = sc.nextLine();

            System.out.print("  Stock: ");
            int stock = sc.nextInt();

            productos[i] = new producto(sku, nombre, stock);
        }

        // original
        System.out.println("\n--- PRODUCTOS INGRESADOS ---");
        mostrar(productos);

        // ordenar
        ordenarPorID(productos);

        System.out.println("\n--- ORDENADOS POR SKU (Shell Sort) ---");
        mostrar(productos);

        // buscar
        System.out.print("\nIngrese SKU a buscar: ");
        int skuBuscado = sc.nextInt();

        busquedaBinaria(productos, skuBuscado);
    }

    // mostrar
    public static void mostrar(producto[] productos) {
        for (producto p : productos) {
            System.out.printf("SKU: %d | Nombre: %s | Stock: %d%n",
                    p.sku, p.nombre, p.stock);
        }
    }

    // ordenar
    public static void ordenarPorID(producto[] productos) {
        int n = productos.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                producto temp = productos[i];
                int j;
                for (j = i; j >= gap && productos[j - gap].sku > temp.sku; j -= gap) {
                    productos[j] = productos[j - gap];
                }
                productos[j] = temp;
            }
        }
    }

    // buscar binario
    public static void busquedaBinaria(producto[] productos, int skuBuscado) {
        int inicio = 0;
        int fin = productos.length - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;

            if (productos[medio].sku == skuBuscado) {
                System.out.println("\nProducto encontrado:");
                System.out.printf("SKU: %-5d | Nombre: %-15s | Stock: %d%n",
                        productos[medio].sku,
                        productos[medio].nombre,
                        productos[medio].stock);
                return;
            } else if (productos[medio].sku < skuBuscado) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }

        System.out.println("Producto no encontrado.");
    }
}
