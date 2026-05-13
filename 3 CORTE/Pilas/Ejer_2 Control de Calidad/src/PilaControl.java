public class PilaControl {

    private Nodo tope;

    public PilaControl() {

        this.tope = null;
    }

    public boolean isEmpty() {

        return tope == null;
    }

    public void push(String nombrePieza,
                     String numeroSerie,
                     boolean esDefectuosa) {

        Nodo nuevo = new Nodo(
                nombrePieza,
                numeroSerie,
                esDefectuosa
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
                    "[" + auxiliar.nombrePieza + "]"
            );

            if (auxiliar.siguiente != null) {

                System.out.print(" -> ");
            }

            auxiliar = auxiliar.siguiente;
        }

        System.out.println(" -> BASE");
    }

    public void limpiarHastaDefecto() {

        if (isEmpty()) {

            System.out.println("La pila esta vacia");
            return;
        }

        boolean encontrada = false;

        while (!isEmpty()) {

            Nodo actual = peek();

            if (actual.esDefectuosa) {

                System.out.println(
                        "\nPieza defectuosa encontrada:"
                );

                System.out.println(
                        "Nombre: " + actual.nombrePieza
                );

                System.out.println(
                        "Serie: " + actual.numeroSerie
                );

                encontrada = true;

                break;
            }

            Nodo retirada = pop();

            System.out.println(
                    "Pieza buena retirada y descartada: "
                            + retirada.nombrePieza
            );
        }

        if (!encontrada) {

            System.out.println(
                    "No se encontro ninguna pieza defectuosa"
            );
        }
    }
}