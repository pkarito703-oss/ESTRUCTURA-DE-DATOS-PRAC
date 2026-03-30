/**
5. Spotify Lite (Lista de Reproducción)
Crea un reproductor de música simplificado que gestione una lista de canciones.
La Clase Cancion (Nodo): Debe contener titulo (String), artista (String), duracionSegundos (int) y genero (String).
El Problema: El usuario puede agregar canciones "A continuación" (insertar después de la actual) o "Al final de la cola".
Reto: Implementa un método que sume la duración de todas las canciones y muestre el tiempo total de la lista en formato MM:SS
 */
public class App {

    public static void main(String[] args) {

        ListaReproduccion lista = new ListaReproduccion("Mi Playlist");

        // Cargar canciones al final 
        System.out.println("=== AGREGANDO CANCIONES AL FINAL ===");
        lista.agregarAlFinal("Blinding Lights",   "The Weeknd",     200, "Pop");
        lista.agregarAlFinal("HUMBLE.",            "Kendrick Lamar", 177, "Hip-Hop");
        lista.agregarAlFinal("Bohemian Rhapsody",  "Queen",          354, "Rock");
        lista.agregarAlFinal("Bad Guy",            "Billie Eilish",  194, "Electropop");

        lista.mostrarLista();

        // Ver canción actual y avanzar
        System.out.println("\n=== REPRODUCCIÓN ===");
        lista.mostrarActual();
        lista.siguiente();
        lista.siguiente();

        lista.mostrarLista();   

        // Insertar "A continuación" de la actual 
        System.out.println("\n=== INSERTAR A CONTINUACIÓN ===");
        lista.agregarAContinuacion("Smells Like Teen Spirit", "Nirvana", 301, "Rock");
        lista.agregarAContinuacion("Happier",                 "Olivia Rodrigo", 143, "Pop");

        lista.mostrarLista();

        // Más canciones al final 
        System.out.println("\n=== MÁS CANCIONES AL FINAL ===");
        lista.agregarAlFinal("Levitating", "Dua Lipa", 203, "Dance-Pop");

        lista.mostrarLista();

        // Duración total
        System.out.println("\n=== DURACIÓN TOTAL DE LA PLAYLIST ===");
        System.out.println("Tiempo total: " + lista.calcularDuracionTotal());
    }
}
