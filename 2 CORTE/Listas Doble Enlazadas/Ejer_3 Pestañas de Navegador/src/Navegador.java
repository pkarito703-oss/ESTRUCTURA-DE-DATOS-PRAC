public class Navegador {
    private Nodos inicio;
    private Nodos actual;

    public void abrirPestana(String titulo, String url, String hora) {
        Nodos nueva = new Nodos(titulo, url, hora);

        if (inicio == null) {
            inicio = nueva;
            actual = nueva;
        } else {
            Nodos temp = inicio;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nueva;
            nueva.anterior = temp;
        }
    }

    public void mostrarActual() {
        if (actual != null) {
            actual.mostrar();
        } else {
            System.out.println("No hay pestañas.");
        }
    }

    public void siguiente() {
        if (actual != null && actual.siguiente != null) {
            actual = actual.siguiente;
            mostrarActual();
        } else {
            System.out.println("esta era laultima pestaña.");
        }
    }

    public void anterior() {
        if (actual != null && actual.anterior != null) {
            actual = actual.anterior;
            mostrarActual();
        } else {
            System.out.println("esta era la primera pestaña.");
        }
    }

    public void cerrarPestanaActual(String url) {
        if (inicio == null) {
            System.out.println("No hay pestañas.");
            return;
        }

        Nodos temp = inicio;

        while (temp != null) {
            if (temp.url.equals(url)) {

                // cuando es la primera
                if (temp == inicio) {
                    inicio = temp.siguiente;
                    if (inicio != null) {
                        inicio.anterior = null;
                    }
                }
                // cuando es del medio o final
                else {
                    temp.anterior.siguiente = temp.siguiente;
                    if (temp.siguiente != null) {
                        temp.siguiente.anterior = temp.anterior;
                    }
                }

                // mover el foco (anterior)
                if (temp.anterior != null) {
                    actual = temp.anterior;
                } else {
                    actual = inicio;
                }

                System.out.println("Pestaña cerrada.");
                return;
            }

            temp = temp.siguiente;
        }

        System.out.println("No se encontro la URL.");
    }

    public void mostrarTodas() {
        Nodos temp = inicio;
        while (temp != null) {
            temp.mostrar();
            temp = temp.siguiente;
        }
    }
}
