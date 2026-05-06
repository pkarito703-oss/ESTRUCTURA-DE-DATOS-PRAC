/*
 * Clase Nodo (Anuncio)
 * Representa cada anuncio dentro del carrusel
 * Es un nodo de una lista circular simple
 */
public class Nodo {

    // Atributos del anuncio
    String titulo;
    int duracionSegundos;
    int vecesRepetido;
    String categoria;

    // Apuntador al siguiente nodo (clave para la lista circular)
    Nodo siguiente;

    /*
     * Constructor
     * Inicializa un anuncio con sus datos básicos
     */
    public Nodo(String titulo, int duracionSegundos, String categoria) {
        this.titulo = titulo;
        this.duracionSegundos = duracionSegundos;
        this.categoria = categoria;
        this.vecesRepetido = 0; // inicia en 0 porque aún no se reproduce
        this.siguiente = null;
    }
}
