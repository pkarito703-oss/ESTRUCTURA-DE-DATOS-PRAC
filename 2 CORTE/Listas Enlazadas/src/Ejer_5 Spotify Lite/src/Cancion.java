
public class Cancion {
    private String titulo;
    private String artista;
    private int duracionSegundos;
    private String genero;
    public Cancion siguiente;

    public Cancion(String titulo, String artista, int duracionSegundos, String genero) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracionSegundos = duracionSegundos;
        this.genero = genero;
        this.siguiente = null;
    }

    public String getTitulo()          { return titulo; }
    public String getArtista()         { return artista; }
    public int getDuracionSegundos()   { return duracionSegundos; }
    public String getGenero()          { return genero; }

   
    public String getDuracionFormateada() {
        int min = duracionSegundos / 60;
        int seg = duracionSegundos % 60;
        return String.format("%02d:%02d", min, seg);
    }

    @Override
    public String toString() {
        return String.format("%-35s | %-25s | %s | %s",
                titulo, artista, getDuracionFormateada(), genero);
    }
}
