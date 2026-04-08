public class ListaEnlazada {

    private Nodos cabeza;
    
    public ListaEnlazada() {
        this.cabeza = null;
    }
    
    // Método para contar los nodos
    public int contarNodos() {
        int contador = 0;
        Nodos actual = cabeza;
        
        // Recorrer toda la lista, sumando 1 por cada nodo
        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }
        
        return contador;
    }
    
    // Método para insertar un elemento al final
    public void insertarAlFinal(int dato) {
        Nodos nuevoNodo = new Nodos(dato);
        
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodos actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }
    
    // Método para insertar un elemento al inicio
    public void insertarAlInicio(int dato) {
        Nodos nuevoNodo = new Nodos(dato);
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
    }
    
    // Método para imprimir la lista
    public void imprimir() {
        System.out.println("Lista enlazada: ");
        Nodos actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " → ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }
}
