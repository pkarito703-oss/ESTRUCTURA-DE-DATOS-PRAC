public class PilaControl {

    private Nodo tope;

    public PilaControl() {

        this.tope = null;
    }

    public boolean isEmpty() {

        return tope == null;
    }

    public void push(String nombrePunto,
                     int profundidad,
                     double nivelOxigeno) {

        Nodo nuevo = new Nodo(
                nombrePunto,
                profundidad,
                nivelOxigeno
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

            System.out.println("No hay estaciones");
            return;
        }

        Nodo auxiliar = tope;

        System.out.print("\nTOPE -> ");

        while (auxiliar != null) {

            System.out.print(
                    "[" + auxiliar.nombrePunto + "]"
            );

            if (auxiliar.siguiente != null) {

                System.out.print(" -> ");
            }

            auxiliar = auxiliar.siguiente;
        }

        System.out.println(" -> BASE");
    }

    public void retrocederASuperficie() {

        if (isEmpty()) {

            System.out.println("No hay estaciones registradas");
            return;
        }

        System.out.println(
                "\nINICIANDO RETORNO A LA SUPERFICIE\n"
        );

        while (!isEmpty()) {

            Nodo actual = pop();

            System.out.println(
                    "Pasando por estacion: "
                            + actual.nombrePunto
            );

            System.out.println(
                    "Profundidad: "
                            + actual.profundidad
                            + " metros"
            );

            System.out.println(
                    "Nivel de oxigeno: "
                            + actual.nivelOxigeno
                            + "%"
            );

            if (actual.nivelOxigeno < 18) {

                System.out.println(
                        "ALERTA: Uso de Tanque de Emergencia Requerido"
                );
            }

            System.out.println();
        }

        System.out.println(
                "El equipo ha regresado a la superficie"
        );
    }
}
