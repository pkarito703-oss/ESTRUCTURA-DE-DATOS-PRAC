//1. El Cajero del Supermercado (Inventario)
//Un cajero escanea un producto con el código de barras 770123. 
//El sistema tiene un arreglo desordenado con los códigos de los productos disponibles en la estantería actual.

//El Problema: Debes recorrer la lista para verificar si el producto existe y en qué posición de la estantería se encuentra.
//Algoritmo a usar: Búsqueda Lineal. Es el ideal porque los productos en la estantería no tienen un orden numérico específico.

public class Ejer_1 {

    public static void main(String[] args) {

        int[] codigos = {345678, 113422, 770555, 950477, 770123, 598677};
        int buscar = 770123;
        int posicion = -1;

        for (int i = 0; i < codigos.length; i++) {
            if (codigos[i] == buscar) {
                posicion = i;
                break;
            }
        }

        if (posicion != -1) {
            System.out.println("Producto encontrado en la posición: " + posicion);
        } else {
            System.out.println("Producto no encontrado en la estantería.");
        }
    }
}
