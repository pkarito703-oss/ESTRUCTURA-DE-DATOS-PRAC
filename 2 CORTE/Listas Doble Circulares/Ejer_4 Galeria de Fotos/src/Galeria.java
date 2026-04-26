public class Galeria {
    private Nodos cabeza;
    private Nodos actual;

    public void agregar(String titulo, String fecha) {
        Nodos nueva = new Nodos(titulo, fecha);

        if (cabeza == null) {
            cabeza = nueva;
            cabeza.siguiente = cabeza;
            cabeza.anterior = cabeza;
            actual = cabeza;
        } else {
            Nodos ultimo = cabeza.anterior;

            ultimo.siguiente = nueva;
            nueva.anterior = ultimo;

            nueva.siguiente = cabeza;
            cabeza.anterior = nueva;
        }
    }

    public void siguiente() {
        if (actual != null) {
            actual = actual.siguiente;
        }
    }

    public void anterior() {
        if (actual != null) {
            actual = actual.anterior;
        }
    }

    public void toggleFavorita() {
        if (actual != null) {
            actual.esFavorita = !actual.esFavorita;
        }
    }

    public void eliminarActual() {
        if (actual == null) return;

        if (actual.siguiente == actual) {
            cabeza = null;
            actual = null;
            return;
        }

        Nodos ant = actual.anterior;
        Nodos sig = actual.siguiente;

        ant.siguiente = sig;
        sig.anterior = ant;

        if (actual == cabeza) {
            cabeza = sig;
        }

        actual = sig;
    }

    public void mostrarGaleria() {
        if (cabeza == null) {
            System.out.println("Galeria vacia.");
            return;
        }

        Nodos temp = cabeza;

        do {
            String actualMark = (temp == actual) ? "[▶]" : "   ";
            String favMark = temp.esFavorita ? "[★]" : "[ ]";

            System.out.println(actualMark + " " + favMark + " " 
                + temp.titulo + " | " + temp.fecha);

            temp = temp.siguiente;
        } while (temp != cabeza);
    }
}
