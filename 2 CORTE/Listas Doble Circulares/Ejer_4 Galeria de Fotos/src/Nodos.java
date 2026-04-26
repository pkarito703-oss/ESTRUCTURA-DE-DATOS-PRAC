public class Nodos {
    String titulo;
    String fecha;
    boolean esFavorita;

    Nodos siguiente;
    Nodos anterior;

    public Nodos(String titulo, String fecha) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.esFavorita = false;
        this.siguiente = null;
        this.anterior = null;
    }
}