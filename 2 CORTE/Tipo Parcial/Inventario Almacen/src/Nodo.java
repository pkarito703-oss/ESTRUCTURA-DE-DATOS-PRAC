public class Nodo {
    int codigo;
    String nombre;
    int cantidad;
    double precio;
    Nodo siguiente;

    public Nodo(int codigo, String nombre, int cantidad, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.siguiente = null;
    }
}
