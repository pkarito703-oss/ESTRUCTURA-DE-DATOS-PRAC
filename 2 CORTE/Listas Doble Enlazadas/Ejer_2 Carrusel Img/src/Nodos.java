public class Nodos {
    String nombreArchivo;
    double tamanoMB;
    String resolucion;
    Nodos siguiente;
    Nodos anterior;

    public Nodos(String nombreArchivo, double tamanoMB, String resolucion) {
        this.nombreArchivo = nombreArchivo;
        this.tamanoMB = tamanoMB;
        this.resolucion = resolucion;
        this.siguiente = null;
        this.anterior = null;
    }

    public void mostrar() {
        System.out.println("Nombre: " + nombreArchivo);
        System.out.println("Tamaño: " + tamanoMB + " MB");
        System.out.println("Resolucion: " + resolucion);
        System.out.println("----------------------");
    }
}
