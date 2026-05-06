public class Historial {

    // Apunta al último nodo insertado (cola)
    // En lista circular doble:
    // cola.siguiente -> cabeza
    // cabeza.anterior -> cola
    private Nodo cola;

    // Cursor: simula la posición actual (flechas arriba/abajo)
    private Nodo cursor;

    public Historial() {
        cola = null;
        cursor = null;
    }

    // ==============================
    // a) NUEVO COMANDO (al final)
    // ==============================
    public void agregar(String comando, String hora) {
        Nodo nuevo = new Nodo(comando, hora);

        if (cola == null) {
            // Primer nodo: se enlaza consigo mismo
            nuevo.siguiente = nuevo;
            nuevo.anterior = nuevo;
            cola = nuevo;
            cursor = nuevo;
        } else {
            Nodo cabeza = cola.siguiente;

            // Enlaces del nuevo nodo
            nuevo.siguiente = cabeza;
            nuevo.anterior = cola;

            // Reconectar extremos
            cola.siguiente = nuevo;
            cabeza.anterior = nuevo;

            // Mover cola al nuevo
            cola = nuevo;

            // Cursor queda en el nuevo comando
            cursor = nuevo;
        }

        System.out.println("Comando agregado");
    }

    // ==============================
    // b) COMANDO ANTERIOR (↑)
    // ==============================
    public void anterior() {
        if (cursor == null) {
            System.out.println("Historial vacío");
            return;
        }
        cursor = cursor.anterior;
        mostrarActual();
    }

    // ==============================
    // c) COMANDO SIGUIENTE (↓)
    // ==============================
    public void siguiente() {
        if (cursor == null) {
            System.out.println("Historial vacío");
            return;
        }
        cursor = cursor.siguiente;
        mostrarActual();
    }

    // ==============================
    // d) BORRAR ACTUAL (O(1))
    // ==============================
    public void borrarActual() {
        if (cursor == null) {
            System.out.println("Historial vacío");
            return;
        }

        // Caso: un solo nodo
        if (cursor.siguiente == cursor) {
            cola = null;
            cursor = null;
            System.out.println("Comando eliminado (lista vacía)");
            return;
        }

        Nodo prev = cursor.anterior;
        Nodo next = cursor.siguiente;

        // Reconectar en O(1)
        prev.siguiente = next;
        next.anterior = prev;

        // Si se elimina la cola, moverla
        if (cursor == cola) {
            cola = prev;
        }

        // Mover cursor a un nodo válido
        cursor = next;

        System.out.println("Comando eliminado");
    }

    // ==============================
    // e) BUSCAR Y MOVER CURSOR
    // ==============================
    public void buscar(String texto) {
        if (cola == null) {
            System.out.println("Historial vacío");
            return;
        }

        Nodo actual = cola.siguiente; // cabeza
        do {
            if (actual.comando.equalsIgnoreCase(texto)) {
                cursor = actual;
                System.out.println("Comando encontrado y cursor actualizado");
                mostrarActual();
                return;
            }
            actual = actual.siguiente;
        } while (actual != cola.siguiente);

        System.out.println("Comando no encontrado");
    }

    // ==============================
    // MOSTRAR ACTUAL
    // ==============================
    public void mostrarActual() {
        if (cursor == null) {
            System.out.println("Sin comandos");
            return;
        }

        System.out.println("Actual -> [" + cursor.comando + "] (" + cursor.hora + ")");
    }

    // ==============================
    // MOSTRAR LISTA (VALIDACIÓN CIRCULAR)
    // ==============================
    public void mostrarHistorial() {
        if (cola == null) {
            System.out.println("Historial vacío");
            return;
        }

        Nodo actual = cola.siguiente; // cabeza

        System.out.print("Historial: ");

        do {
            // Marca visual del cursor
            if (actual == cursor) {
                System.out.print("{" + actual.comando + "} -> ");
            } else {
                System.out.print(actual.comando + " -> ");
            }

            actual = actual.siguiente;

        } while (actual != cola.siguiente);

        // Demostración de circularidad
        System.out.println("(vuelve al inicio)");
    }
}
