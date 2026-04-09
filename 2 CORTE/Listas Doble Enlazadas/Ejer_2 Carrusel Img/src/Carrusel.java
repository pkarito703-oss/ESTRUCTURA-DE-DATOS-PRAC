public class Carrusel {
    private Nodos inicio;
    private Nodos actual;

    public void agregarFoto(String nombre, double tamano, String resolucion) {
        Nodos nuevo = new Nodos(nombre, tamano, resolucion);

        if (inicio == null) {
            inicio = nuevo;
            actual = nuevo;
        } else {
            Nodos temp = inicio;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevo;
            nuevo.anterior = temp;
        }
    }

    public void mostrarActual() {
        if (actual != null) {
            actual.mostrar();
        } else {
            System.out.println("No hay fotos.");
        }
    }
    public void siguiente() {
        if (actual != null && actual.siguiente != null) {
            actual = actual.siguiente;
            mostrarActual();
        } else {
            System.out.println("Última foto.");
        }
    }

    public void anterior() {
        if (actual != null && actual.anterior != null) {
            actual = actual.anterior;
            mostrarActual();
        } else {
            System.out.println("Primera foto.");
        }
    }

    public void reproducirGaleria() {
        if (inicio == null) {
            System.out.println("No hay fotos.");
            return;

        }

        System.out.println("----> Hacia adelante:");
        Nodos temp = inicio;

        while (temp != null) {
            temp.mostrar();
            if (temp.siguiente == null) break;
            temp = temp.siguiente;
        }

        System.out.println("<---- Hacia atrás:");
        while (temp != null) {
            temp.mostrar();
            temp = temp.anterior;
        }
    }
}