public class Participante {
    String nombre;
    int boleto;
    
    Participante siguiente;
    Participante anterior;

    // Constructor
    public Participante(String nombre, int boleto) {
        this.nombre = nombre;
        this.boleto = boleto;
        this.siguiente = null;
        this.anterior = null;
    }
}
