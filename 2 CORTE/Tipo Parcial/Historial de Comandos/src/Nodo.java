public class Nodo {
    String comando;
    String hora;

    Nodo siguiente;
    Nodo anterior;

    public Nodo(String comando, String hora) {
        this.comando = comando;
        this.hora = hora;
        this.siguiente = null;
        this.anterior = null;
    }
}
