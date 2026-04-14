public class Planificador {
    Nodos cabeza = null;
    Nodos cola = null;

    public void agregar(String nombre, int pid, int tiempo, int prioridad) {
        Nodos nuevo = new Nodos(nombre, pid, tiempo, prioridad);

        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
            nuevo.siguiente = cabeza;
        } else {
            cola.siguiente = nuevo;
            cola = nuevo;
            cola.siguiente = cabeza;
        }
    }

    public void mostrar() {
        if (cabeza == null) {
            System.out.println("No hay procesos.");
            return;
        }

        Nodos temp = cabeza;
        do {
            System.out.println("PID: " + temp.pid +
                    " | Nombre: " + temp.nombre +
                    " | Tiempo: " + temp.tiempoRestante +
                    " | Prioridad: " + temp.prioridad);
            temp = temp.siguiente;
        } while (temp != cabeza);
    }

    private void eliminar(Nodos actual, Nodos anterior) {
        if (actual == cabeza && actual == cola) {
            cabeza = null;
            cola = null;
        } else if (actual == cabeza) {
            cabeza = cabeza.siguiente;
            cola.siguiente = cabeza;
        } else if (actual == cola) {
            cola = anterior;
            cola.siguiente = cabeza;
        } else {
            anterior.siguiente = actual.siguiente;
        }
    }

    public void ejecutar(int quantum) {
        if (cabeza == null) {
            System.out.println("No hay procesos para ejecutar.");
            return;
        }

        Nodos actual = cabeza;
        Nodos anterior = cola;

        String ordenFinal = "";

        while (cabeza != null) {

            System.out.println("\nEjecutando proceso: " + actual.nombre + " (PID " + actual.pid + ")");

            actual.tiempoRestante -= quantum;

            if (actual.tiempoRestante > 0) {
                System.out.println("Tiempo restante: " + actual.tiempoRestante);
                anterior = actual;
                actual = actual.siguiente;
            } else {
                System.out.println("Proceso " + actual.nombre + " TERMINADO");

                ordenFinal += actual.nombre + " -> ";

                eliminar(actual, anterior);

                if (cabeza == null) break;

                actual = anterior.siguiente;
            }
        }

        System.out.println("\nOrden de finalización:");
        System.out.println(ordenFinal + "FIN");
    }
}