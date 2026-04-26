public class Comandos {
    private Nodos cabeza;
    private Nodos cursor;

    public void agregar(String texto, boolean exitoso, String directorio) {
        Nodos nuevo = new Nodos(texto, exitoso, directorio);

        if (cabeza == null) {
            cabeza = nuevo;
            cabeza.siguiente = cabeza;
            cabeza.anterior = cabeza;
            cursor = cabeza;
        } else {
            Nodos ultimo = cabeza.anterior;

            ultimo.siguiente = nuevo;
            nuevo.anterior = ultimo;

            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
        }
    }

    public void arriba() {
        if (cursor != null) {
            cursor = cursor.anterior;
        } else {
            System.out.println("Historial vacío");
        }
    }

    public void abajo() {
        if (cursor != null) {
            cursor = cursor.siguiente;
        } else {
            System.out.println("Historial vacío");
        }
    }

    public void mostrarCursor() {
        if (cursor != null) {
            System.out.println(cursor.texto +
                    " | Dir: " + cursor.directorio +
                    " | Exitoso: " + cursor.exitoso);
        } else {
            System.out.println("No hay comandos.");
        }
    }

    public void eliminarActual() {
        if (cursor == null) return;

        if (cursor.siguiente == cursor) {
            cabeza = null;
            cursor = null;
            return;
        }

        Nodos anterior = cursor.anterior;
        Nodos siguiente = cursor.siguiente;

        anterior.siguiente = siguiente;
        siguiente.anterior = anterior;

        if (cursor == cabeza) {
            cabeza = siguiente;
        }

        cursor = siguiente;
    }

    public void mostrarHistorial() {
        if (cabeza == null) {
            System.out.println("Historial vacio");
            return;
        }

        Nodos temp = cabeza;

        do {
            if (temp == cursor) {
                System.out.println(temp.texto + " (CURSOR)");
            } else {
                System.out.println(temp.texto);
            }
            temp = temp.siguiente;
        } while (temp != cabeza);
    }
}
