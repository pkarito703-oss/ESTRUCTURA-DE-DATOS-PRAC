/*
 * Clase Carrusel
 * Maneja la lista circular de anuncios
 */
public class Carrusel {

    // Apuntador al primer nodo
    private Nodo inicio;

    /*
     * Constructor
     * Inicialmente el carrusel está vacío
     */
    public Carrusel() {
        inicio = null;
    }

    /*
     * Método para agregar anuncios al carrusel
     * Se insertan al final manteniendo la circularidad
     */
    public void agregarAnuncio(String titulo, int duracion, String categoria) {

        Nodo nuevo = new Nodo(titulo, duracion, categoria);

        // Si la lista está vacía
        if (inicio == null) {
            inicio = nuevo;
            inicio.siguiente = inicio; // se apunta a sí mismo (circular)
        } else {
            Nodo temp = inicio;

            // Recorremos hasta el último nodo
            while (temp.siguiente != inicio) {
                temp = temp.siguiente;
            }

            // Insertamos al final
            temp.siguiente = nuevo;
            nuevo.siguiente = inicio;
        }
    }

    /*
     * Método para mostrar todos los anuncios
     */
    public void mostrar() {
        if (inicio == null) {
            System.out.println("No hay anuncios.");
            return;
        }

        Nodo temp = inicio;

        System.out.println("\n--- LISTA DE ANUNCIOS ---");

        do {
            System.out.println("Titulo: " + temp.titulo +
                    " | Duración: " + temp.duracionSegundos +
                    "s | Categoria: " + temp.categoria +
                    " | Veces repetido: " + temp.vecesRepetido);

            temp = temp.siguiente;

        } while (temp != inicio);
    }

    /*
     * Método principal del reto
     * Simula la reproducción del carrusel
     */
    public void reproducir(int ciclos) {

        if (inicio == null) {
            System.out.println("No hay anuncios para reproducir.");
            return;
        }

        Nodo temp = inicio;

        int tiempoTotal = 0; // acumulador del tiempo total

        System.out.println("\n--- REPRODUCIENDO CARRUSEL ---");

        // Repetimos la lista completa "ciclos" veces
        for (int i = 1; i <= ciclos; i++) {

            System.out.println("\nCICLO #" + i);

            do {
                // Simula mostrar anuncio
                System.out.println("Mostrando: " + temp.titulo +
                        " (" + temp.categoria + ")");

                // Incrementa contador de repeticiones
                temp.vecesRepetido++;

                // Suma el tiempo del anuncio
                tiempoTotal += temp.duracionSegundos;

                // Avanza al siguiente nodo
                temp = temp.siguiente;

            } while (temp != inicio); // vuelve al inicio → ciclo completo
        }

        /*
         * Buscar el anuncio más repetido
         */
        Nodo masRepetido = inicio;
        temp = inicio.siguiente;

        do {
            if (temp.vecesRepetido > masRepetido.vecesRepetido) {
                masRepetido = temp;
            }
            temp = temp.siguiente;

        } while (temp != inicio);

        // Resultados finales
        System.out.println("\n--- RESULTADOS ---");
        System.out.println("Anuncio más repetido: " + masRepetido.titulo +
                " (" + masRepetido.vecesRepetido + " veces)");

        System.out.println("Tiempo total en pantalla: " + tiempoTotal + " segundos");
    }
}