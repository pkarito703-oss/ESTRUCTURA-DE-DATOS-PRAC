public class Nodos {
    String titulo;
    int duracionSegundos;
    int vecesRepetido;
    String categoria;
    Nodos siguiente;

    public Nodos(String titulo, int duracionSegundos, String categoria) {
        this.titulo = titulo;
        this.duracionSegundos = duracionSegundos;
        this.categoria = categoria;
        this.vecesRepetido = 0;
        this.siguiente = null;
    }
}
