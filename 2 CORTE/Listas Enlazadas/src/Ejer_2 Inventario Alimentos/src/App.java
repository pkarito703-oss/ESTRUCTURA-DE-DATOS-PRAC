/*
Clase principal

Prueba el inventario de productos lácteos
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
