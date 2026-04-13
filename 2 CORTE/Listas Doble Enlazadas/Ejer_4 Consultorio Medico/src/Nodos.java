public class Nodos {
    String nombre;
    int edad;
    String enfermedad;
    Nodos siguiente;

    public Nodos(String nombre, int edad, String enfermedad) {
        this.nombre = nombre;
        this.edad = edad;
        this.enfermedad = enfermedad;
        this.siguiente = null;
    }
}
