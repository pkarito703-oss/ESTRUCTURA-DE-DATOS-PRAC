public class Nodos {
    String nombre;
    boolean visible;
    String tipo;

    Nodos siguiente;
    Nodos anterior;

    public Nodos(String nombre, boolean visible, String tipo) {
        this.nombre = nombre;
        this.visible = visible;
        this.tipo = tipo;
        this.siguiente = null;
        this.anterior = null;
    }
}
