public class Ruleta {

    private Participante cabeza; 
    private Participante actual; 

    public void insertar(String nombre, int boleto) {
        Participante nuevo = new Participante(nombre, boleto);

        if (cabeza == null) {
            cabeza = nuevo;
            cabeza.siguiente = cabeza;
            cabeza.anterior = cabeza;
            actual = cabeza;
        } else {
            Participante ultimo = cabeza.anterior;

            ultimo.siguiente = nuevo;
            nuevo.anterior = ultimo;

            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
        }

        System.out.println("Participante agregado correctamente.");
    }

    public void siguiente() {
        if (actual != null) {
            actual = actual.siguiente;
            mostrarActual();
        } else {
            System.out.println("No hay participantes.");
        }
    }

    public void anterior() {
        if (actual != null) {
            actual = actual.anterior;
            mostrarActual();
        } else {
            System.out.println("No hay participantes.");
        }
    }

    public void mostrarActual() {
        if (actual != null) {
            System.out.println("Turno actual:");
            System.out.println("Nombre: " + actual.nombre + " | Boleto: " + actual.boleto);
        }
    }

    public void mostrarTodos() {
        if (cabeza == null) {
            System.out.println("Lista vacía.");
            return;
        }

        Participante temp = cabeza;

        System.out.println("\nLista de participantes (circular):");

        do {
            System.out.println("Nombre: " + temp.nombre + " | Boleto: " + temp.boleto);
            temp = temp.siguiente;
        } while (temp != cabeza);

        System.out.println("(Regresa al inicio: " + cabeza.nombre + ")");
    }
}
