public class PilaControl {

    private Nodo tope;

    public PilaControl() {

        this.tope = null;
    }

    public boolean isEmpty() {

        return tope == null;
    }

    public void push(String placa,
                     String conductor,
                     double cargaToneladas) {

        Nodo nuevo = new Nodo(
                placa,
                conductor,
                cargaToneladas
        );

        nuevo.siguiente = tope;

        tope = nuevo;
    }

    public Nodo pop() {

        if (isEmpty()) {

            return null;
        }

        Nodo eliminado = tope;

        tope = tope.siguiente;

        return eliminado;
    }

    public Nodo peek() {

        if (isEmpty()) {

            return null;
        }

        return tope;
    }

    public void mostrarPila() {

        if (isEmpty()) {

            System.out.println("No hay camiones");
            return;
        }

        Nodo auxiliar = tope;

        System.out.print("\nTOPE -> ");

        while (auxiliar != null) {

            System.out.print(
                    "[" + auxiliar.placa + "]"
            );

            if (auxiliar.siguiente != null) {

                System.out.print(" -> ");
            }

            auxiliar = auxiliar.siguiente;
        }

        System.out.println(" -> BASE");
    }

    public double calcularCargaTotal() {

        double suma = 0;

        PilaControl auxiliar = new PilaControl();

        while (!isEmpty()) {

            Nodo camion = pop();

            suma += camion.cargaToneladas;

            auxiliar.push(
                    camion.placa,
                    camion.conductor,
                    camion.cargaToneladas
            );
        }

        // Reconstruir pila original
        while (!auxiliar.isEmpty()) {

            Nodo camion = auxiliar.pop();

            push(
                    camion.placa,
                    camion.conductor,
                    camion.cargaToneladas
            );
        }

        return suma;
    }
}
