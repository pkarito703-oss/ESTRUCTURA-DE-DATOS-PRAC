
/*
Clase Producto (Nodo)

*/

public class Producto {
    private String nombre;
    private int cantidad;
    private int diasParaVencer;
    private Producto siguiente;

    public Producto(String nombre, int cantidad, int diasParaVencer) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.diasParaVencer = diasParaVencer;
        this.siguiente = null;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getDiasParaVencer() {
        return diasParaVencer;
    }

    public Producto getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Producto siguiente) {
        this.siguiente = siguiente;
    }
}