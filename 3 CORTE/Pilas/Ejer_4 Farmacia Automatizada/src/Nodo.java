public class Nodo {

    String nombre;
    String lote;
    int diasParaVencer;

    Nodo siguiente;

    public Nodo(String nombre,
                String lote,
                int diasParaVencer) {

        this.nombre = nombre;
        this.lote = lote;
        this.diasParaVencer = diasParaVencer;

        this.siguiente = null;
    }
}
