/*
 * Clase Nodo (Estación)
 * Representa cada estación del metro
 * Es un nodo de una lista circular DOBLE
 */
public class Nodo {

    // Datos de la estación
    String nombre;
    int zona;
    int pasajerosDiarios;

    // Apuntadores (doble enlace)
    Nodo siguiente;
    Nodo anterior;

    /*
     * Constructor
     * Inicializa la estación
     */
    public Nodo(String nombre, int zona, int pasajerosDiarios) {
        this.nombre = nombre;
        this.zona = zona;
        this.pasajerosDiarios = pasajerosDiarios;

        // Inicialmente no apunta a nada
        this.siguiente = null;
        this.anterior = null;
    }
}
