/*
 * Clase Metro
 * Maneja la lista circular doble de estaciones
 */
public class Metro {

    private Nodo inicio;

    /*
     * Constructor
     */
    public Metro() {
        inicio = null;
    }

    /*
     * Agregar estación al final
     * Mantiene la estructura circular doble
     */
    public void agregarEstacion(String nombre, int zona, int pasajeros) {

        Nodo nuevo = new Nodo(nombre, zona, pasajeros);

        if (inicio == null) {
            // Primera estación
            inicio = nuevo;
            inicio.siguiente = inicio;
            inicio.anterior = inicio;
        } else {
            Nodo ultimo = inicio.anterior;

            // Enlace doble
            ultimo.siguiente = nuevo;
            nuevo.anterior = ultimo;

            nuevo.siguiente = inicio;
            inicio.anterior = nuevo;
        }
    }

    /*
     * Mostrar estaciones
     */
    public void mostrar() {

        if (inicio == null) {
            System.out.println("No hay estaciones.");
            return;
        }

        Nodo temp = inicio;

        System.out.println("\n--- ESTACIONES ---");

        do {
            System.out.println(temp.nombre +
                    " | Zona: " + temp.zona +
                    " | Pasajeros: " + temp.pasajerosDiarios);

            temp = temp.siguiente;

        } while (temp != inicio);
    }

    /*
     * Buscar estación por nombre
     */
    private Nodo buscar(String nombre) {

        if (inicio == null) return null;

        Nodo temp = inicio;

        do {
            if (temp.nombre.equalsIgnoreCase(nombre)) {
                return temp;
            }
            temp = temp.siguiente;

        } while (temp != inicio);

        return null;
    }

    /*
     * MÉTODO PRINCIPAL DEL RETO
     * Calcula la ruta más corta entre dos estaciones
     */
    public void rutaMasCorta(String origenNombre, String destinoNombre) {

        Nodo origen = buscar(origenNombre);
        Nodo destino = buscar(destinoNombre);

        if (origen == null || destino == null) {
            System.out.println("Una de las estaciones no existe.");
            return;
        }

        // =========================
        // RECORRIDO HACIA ADELANTE
        // =========================
        Nodo temp = origen;
        int paradasAdelante = 0;

        String rutaAdelante = origen.nombre;

        while (temp != destino) {
            temp = temp.siguiente;
            rutaAdelante += " -> " + temp.nombre;
            paradasAdelante++;
        }

        // =========================
        // RECORRIDO HACIA ATRÁS
        // =========================
        temp = origen;
        int paradasAtras = 0;

        String rutaAtras = origen.nombre;

        while (temp != destino) {
            temp = temp.anterior;
            rutaAtras += " -> " + temp.nombre;
            paradasAtras++;
        }

        // =========================
        // RESULTADOS
        // =========================
        System.out.println("\n--- RUTA ADELANTE ---");
        System.out.println(rutaAdelante);
        System.out.println("Paradas: " + paradasAdelante);

        System.out.println("\n--- RUTA ATRÁS ---");
        System.out.println(rutaAtras);
        System.out.println("Paradas: " + paradasAtras);

        // Comparación final
        if (paradasAdelante < paradasAtras) {
            System.out.println("\n👉 La ruta más corta es HACIA ADELANTE");
        } else if (paradasAtras < paradasAdelante) {
            System.out.println("\n👉 La ruta más corta es HACIA ATRÁS");
        } else {
            System.out.println("\n👉 Ambas rutas son IGUALES");
        }
    }
}
