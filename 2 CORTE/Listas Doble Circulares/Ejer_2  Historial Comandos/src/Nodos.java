public class Nodos {
    String texto;
    boolean exitoso;
    String directorio;

    Nodos siguiente;
    Nodos anterior;

    public Nodos(String texto, boolean exitoso, String directorio) {
        this.texto = texto;
        this.exitoso = exitoso;
        this.directorio = directorio;
        this.siguiente = null;
        this.anterior = null;
    }
}
