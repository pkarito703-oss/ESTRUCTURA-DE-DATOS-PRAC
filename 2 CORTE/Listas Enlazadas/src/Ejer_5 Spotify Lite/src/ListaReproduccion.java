
public class ListaReproduccion {

    private Cancion cabeza;
    private Cancion actual;   
    private int tamanio;
    private String nombre;

    public ListaReproduccion(String nombre) {
        this.nombre = nombre;
        this.cabeza  = null;
        this.actual  = null;
        this.tamanio = 0;
    }

    // Agrega una canción al final de la lista.
    public void agregarAlFinal(String titulo, String artista, int segundos, String genero) {
        Cancion nueva = new Cancion(titulo, artista, segundos, genero);

        if (cabeza == null) {
            cabeza  = nueva;
            actual  = nueva;   
        } else {
            Cancion temp = cabeza;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nueva;
        }
        tamanio++;
        System.out.println("\"" + titulo + "\" agregada al final de la cola.");
    }

    // Agrega una canción justo después de la canción actual.
    public void agregarAContinuacion(String titulo, String artista, int segundos, String genero) {
        Cancion nueva = new Cancion(titulo, artista, segundos, genero);

        if (actual == null) {
            cabeza  = nueva;
            actual  = nueva;
        } else {
            nueva.siguiente   = actual.siguiente;
            actual.siguiente  = nueva;
        }
        tamanio++;
        System.out.println("Cancion \"" + titulo + "\" insertada a continuación de \"" + actual.getTitulo() + "\".");
    }

    // Pasa a la siguiente canción de la lista.
    public void siguiente() {
        if (actual == null || actual.siguiente == null) {
            System.out.println("No hay más canciones en la lista.");
            return;
        }
        actual = actual.siguiente;
        System.out.println("Reproduciendo: " + actual.getTitulo() + " — " + actual.getArtista());
    }

    // Muestra la canción que está sonando actualmente.
    public void mostrarActual() {
        if (actual == null) {
            System.out.println("   (Sin canción en reproducción)");
        } else {
            System.out.println("Actual: " + actual);
        }
    }

    // Calcula la duración total de todas las canciones de la lista.
    public String calcularDuracionTotal() {
        int totalSegundos = 0;
        Cancion temp = cabeza;
        while (temp != null) {
            totalSegundos += temp.getDuracionSegundos();
            temp = temp.siguiente;
        }
        int min = totalSegundos / 60;
        int seg = totalSegundos % 60;
        return String.format("%02d:%02d", min, seg);
    }

    public void mostrarLista() {
        System.out.println("\n╔═════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.printf("║ %-83s ║%n", nombre);
        System.out.printf("║  Canciones: %-3d | Duración total: %-49s ║%n", tamanio, calcularDuracionTotal());

        System.out.println("╠═════════════════════════════════════════════════════════════════════════════════════╣");
        System.out.printf("║ %-3s %-35s %-25s %-6s %-10s ║%n", "#", "Título", "Artista", "Dur.", "Género");
        System.out.println("╠" + "═".repeat(85) + "╣");

        if (cabeza == null) {
            System.out.printf("║ %-85s ║%n", "(Lista vacía)");
        } else {
            int pos = 1;
            Cancion temp = cabeza;
            while (temp != null) {
                String indicador = (temp == actual) ? "-" : " ";
                String duracion = String.format("%02d:%02d", temp.getDuracionSegundos() / 60, temp.getDuracionSegundos() % 60);

                System.out.printf("║ %s%-2d %-35s %-25s %-6s %-10s ║%n",
                        indicador, pos, temp.getTitulo(), temp.getArtista(), duracion, temp.getGenero());

                temp = temp.siguiente;
                pos++;
            }
        }

        System.out.println("╚" + "═".repeat(85) + "╝");
    }
}