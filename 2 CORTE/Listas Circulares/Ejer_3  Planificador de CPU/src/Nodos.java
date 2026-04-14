public class Nodos {
    String nombre;
    int pid;
    int tiempoRestante;
    int prioridad;

    Nodos siguiente;

    public Nodos(String nombre, int pid, int tiempoRestante, int prioridad) {
        this.nombre = nombre;
        this.pid = pid;
        this.tiempoRestante = tiempoRestante;
        this.prioridad = prioridad;
        this.siguiente = null;
    }
}
