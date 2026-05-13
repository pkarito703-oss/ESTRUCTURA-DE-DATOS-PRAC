public class Nodo {

    String nombrePieza;
    String numeroSerie;
    boolean esDefectuosa;

    Nodo siguiente;

    public Nodo(String nombrePieza,
                String numeroSerie,
                boolean esDefectuosa) {

        this.nombrePieza = nombrePieza;
        this.numeroSerie = numeroSerie;
        this.esDefectuosa = esDefectuosa;

        this.siguiente = null;
    }
}