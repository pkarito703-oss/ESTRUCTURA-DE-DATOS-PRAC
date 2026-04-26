public class Metro {
    private Nodos cabeza;

    public void agregar(String nombre, int zona, int pasajeros) {
        Nodos nueva = new Nodos(nombre, zona, pasajeros);

        if (cabeza == null) {
            cabeza = nueva;
            cabeza.siguiente = cabeza;
            cabeza.anterior = cabeza;
        } else {
            Nodos ultimo = cabeza.anterior;

            ultimo.siguiente = nueva;
            nueva.anterior = ultimo;

            nueva.siguiente = cabeza;
            cabeza.anterior = nueva;
        }
    }

    private Nodos buscar(String nombre) {
        if (cabeza == null) return null;

        Nodos temp = cabeza;

        do {
            if (temp.nombre.equalsIgnoreCase(nombre)) {
                return temp;
            }
            temp = temp.siguiente;
        } while (temp != cabeza);

        return null;
    }

    public void rutaMasCorta(String origen, String destino) {
        Nodos start = buscar(origen);
        Nodos end = buscar(destino);

        if (start == null || end == null) {
            System.out.println("Estación no encontrada.");
            return;
        }

        // HACIA ADELANTE
        int pasosAdelante = 0;
        String rutaAdelante = start.nombre;

        Nodos temp = start;
        while (temp != end) {
            temp = temp.siguiente;
            rutaAdelante += " -> " + temp.nombre;
            pasosAdelante++;
        }

        // HACIA ATRAS 
        int pasosAtras = 0;
        String rutaAtras = start.nombre;

        temp = start;
        while (temp != end) {
            temp = temp.anterior;
            rutaAtras += " -> " + temp.nombre;
            pasosAtras++;
        }

        // Mostrar resultados
        System.out.println("\nRuta hacia adelante:");
        System.out.println(rutaAdelante + " | Paradas: " + pasosAdelante);

        System.out.println("\nRuta hacia atrás:");
        System.out.println(rutaAtras + " | Paradas: " + pasosAtras);

        // Comparación
        System.out.println("\nResultado:");
        if (pasosAdelante < pasosAtras) {
            System.out.println("La ruta más corta es HACIA ADELANTE.");
        } else if (pasosAtras < pasosAdelante) {
            System.out.println("La ruta más corta es HACIA ATRÁS.");
        } else {
            System.out.println("Ambas rutas tienen la misma distancia.");
        }
    }

    public void mostrar() {
        if (cabeza == null) {
            System.out.println("No hay estaciones.");
            return;
        }

        Nodos temp = cabeza;
        do {
            System.out.println(temp.nombre + " | Zona: " + temp.zona +
                    " | Pasajeros: " + temp.pasajerosDiarios);
            temp = temp.siguiente;
        } while (temp != cabeza);
    }
}
