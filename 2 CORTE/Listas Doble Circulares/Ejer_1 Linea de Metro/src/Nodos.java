public class Nodos {
    String nombre;
    int zona;
    int pasajerosDiarios;

    Nodos siguiente;
    Nodos anterior;

    public Nodos(String nombre, int zona, int pasajerosDiarios) {
        this.nombre = nombre;
        this.zona = zona;
        this.pasajerosDiarios = pasajerosDiarios;
        this.siguiente = null;
        this.anterior = null;
    }
}
