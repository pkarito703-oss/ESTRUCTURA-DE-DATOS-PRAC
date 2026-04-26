public class Editor {
    private Nodos cabeza;
    private Nodos capaActiva;

    public void agregar(String nombre, boolean visible, String tipo) {
        Nodos nueva = new Nodos(nombre, visible, tipo);

        if (cabeza == null) {
            cabeza = nueva;
            cabeza.siguiente = cabeza;
            cabeza.anterior = cabeza;
            capaActiva = cabeza;
        } else {
            Nodos ultimo = cabeza.anterior;

            ultimo.siguiente = nueva;
            nueva.anterior = ultimo;

            nueva.siguiente = cabeza;
            cabeza.anterior = nueva;
        }
    }

    public void subirCapa() {
        if (capaActiva != null) {
            capaActiva = capaActiva.siguiente;
        }
    }

    public void bajarCapa() {
        if (capaActiva != null) {
            capaActiva = capaActiva.anterior;
        }
    }

    public void toggleVisibilidad() {
        if (capaActiva != null) {
            capaActiva.visible = !capaActiva.visible;
        }
    }

    public void eliminarActiva() {
        if (capaActiva == null) return;

        if (capaActiva.siguiente == capaActiva) {
            cabeza = null;
            capaActiva = null;
            return;
        }

        Nodos ant = capaActiva.anterior;
        Nodos sig = capaActiva.siguiente;

        ant.siguiente = sig;
        sig.anterior = ant;

        if (capaActiva == cabeza) {
            cabeza = sig;
        }

        capaActiva = sig;
    }

    public void mostrarCapas() {
        if (cabeza == null) {
            System.out.println("No hay capas.");
            return;
        }

        Nodos temp = cabeza;

        do {
            String activa = (temp == capaActiva) ? "[✓]" : "[ ]";
            String vis = temp.visible ? "Visible" : "Oculta";

            System.out.println(activa + " " + temp.nombre +
                    " | Tipo: " + temp.tipo +
                    " | " + vis);

            temp = temp.siguiente;
        } while (temp != cabeza);
    }
}
