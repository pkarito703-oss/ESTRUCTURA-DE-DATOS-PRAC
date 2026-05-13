public class PilaControl {

    private Nodo tope;

    public PilaControl() {

        this.tope = null;
    }

    public boolean isEmpty() {

        return tope == null;
    }

    public void push(String nombre,
                     String lote,
                     int diasParaVencer) {

        Nodo nuevo = new Nodo(
                nombre,
                lote,
                diasParaVencer
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

            System.out.println("La pila esta vacia");
            return;
        }

        Nodo auxiliar = tope;

        System.out.print("\nTOPE -> ");

        while (auxiliar != null) {

            System.out.print(
                    "[" + auxiliar.nombre + "]"
            );

            if (auxiliar.siguiente != null) {

                System.out.print(" -> ");
            }

            auxiliar = auxiliar.siguiente;
        }

        System.out.println(" -> BASE");
    }

    public void validarDespacho() {

        if (isEmpty()) {

            System.out.println("No hay medicamentos");
            return;
        }

        while (!isEmpty()) {

            Nodo actual = peek();

            if (actual.diasParaVencer < 10) {

                Nodo retirado = pop();

                System.out.println(
                        "Medicamento retirado por vencimiento cercano: "
                                + retirado.nombre
                );

            } else {

                System.out.println(
                        "\nMedicamento seguro para despacho:"
                );

                System.out.println(
                        "Nombre: " + actual.nombre
                );

                System.out.println(
                        "Lote: " + actual.lote
                );

                System.out.println(
                        "Dias para vencer: "
                                + actual.diasParaVencer
                );

                return;
            }
        }

        System.out.println(
                "\nLa pila quedo vacia. No hay medicamentos seguros."
        );
    }
}
