/*
2. Inventario de Alimentos (Control de Caducidad)
Un supermercado necesita gestionar su estante de lácteos. Los productos que vencen más pronto deben colocarse al principio para ser vendidos primero.

La Clase Producto (Nodo): Debe contener nombre (String), cantidad (int) y diasParaVencer (int).
El Problema: Si llega un producto que vence en menos de 3 días, debe insertarse al inicio de la lista (prioridad de venta). Si vence en más tiempo, se pone al final.
Reto: Crea un método que imprima solo los productos que tienen menos de 5 días para vencer.
*/

public class App {
    public static void main(String[] args) {

        Inventario inventario = new Inventario();

        inventario.agregarProducto(new Producto("Leche", 10, 2));  // prioridad
        inventario.agregarProducto(new Producto("Queso", 5, 7));
        inventario.agregarProducto(new Producto("Yogurt", 8, 1));  // prioridad
        inventario.agregarProducto(new Producto("Mantequilla", 4, 4));

        System.out.println("=== Inventario completo ===");
        inventario.mostrarInventario();

        System.out.println("\n=== Productos próximos a vencer ===");
        inventario.mostrarProximosAVencer();
    }
}
