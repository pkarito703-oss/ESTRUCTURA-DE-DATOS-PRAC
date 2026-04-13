public class Carrusel {
    private Nodos cabeza;

    public void agregarAnuncio(String titulo, int duracion, String categoria) {
        Nodos nuevo = new Nodos(titulo, duracion, categoria);

        if (cabeza == null) {
            cabeza = nuevo;
            cabeza.siguiente = cabeza;
        } else {
            Nodos temp = cabeza;
            while (temp.siguiente != cabeza) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevo;
            nuevo.siguiente = cabeza;
        }
    }

    public void mostrarAnuncios() {
        if (cabeza == null) {
            System.out.println("No hay anuncios.");
            return;
        }

        Nodos temp = cabeza;
        do {
            System.out.println("Titulo: " + temp.titulo +
                               " | Duración: " + temp.duracionSegundos +
                               " | Categoria: " + temp.categoria +
                               " | Repeticiones: " + temp.vecesRepetido);
            temp = temp.siguiente;
        } while (temp != cabeza);
    }

    // Metodo principal
    public void reproducir(int ciclos) {
        if (cabeza == null) {
            System.out.println("No hay anuncios.");
            return;
        }

        int tiempoTotal = 0;
        Nodos actual = cabeza;

        for (int i = 0; i < ciclos; i++) {
            System.out.println("---- Ciclo " + (i + 1) + " ----");

            do {
                System.out.println("Mostrando: " + actual.titulo +
                                   " (" + actual.categoria + ")");

                actual.vecesRepetido++;
                tiempoTotal += actual.duracionSegundos;

                actual = actual.siguiente;

            } while (actual != cabeza);
        }

        // Buscar el mas repetido
        Nodos masRepetido = cabeza;
        Nodos temp = cabeza.siguiente;

        while (temp != cabeza) {
            if (temp.vecesRepetido > masRepetido.vecesRepetido) {
                masRepetido = temp;
            }
            temp = temp.siguiente;
        }

        System.out.println("\nRESULTADOS:");
        System.out.println("Mas repetido: " + masRepetido.titulo +
                           " (" + masRepetido.vecesRepetido + " veces)");
        System.out.println("Tiempo total: " + tiempoTotal + " segundos");
    }
}