public class Pelicula {
    String titulo;
    String genero;
    int duracion;
    Pelicula siguiente;

    public Pelicula(String titulo, String genero, int duracion) {
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
        this.siguiente = null;
    }
}

