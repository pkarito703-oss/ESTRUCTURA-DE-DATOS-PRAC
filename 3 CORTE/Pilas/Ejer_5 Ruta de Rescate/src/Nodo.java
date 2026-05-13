public class Nodo {

    String nombrePunto;
    int profundidad;
    double nivelOxigeno;

    Nodo siguiente;

    public Nodo(String nombrePunto,
                int profundidad,
                double nivelOxigeno) {

        this.nombrePunto = nombrePunto;
        this.profundidad = profundidad;
        this.nivelOxigeno = nivelOxigeno;

        this.siguiente = null;
    }
}