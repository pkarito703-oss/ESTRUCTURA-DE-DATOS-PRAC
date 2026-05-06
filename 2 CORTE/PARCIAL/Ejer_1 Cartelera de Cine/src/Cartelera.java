public class Cartelera {
    private Pelicula cabeza;

    public void agregarPelicula(String titulo, String genero, int duracion) {
        if (titulo.trim().isEmpty()) {
            System.out.println("Error: el título no puede estar vacío.");
            return;
        }

        if (duracion <= 0) {
            System.out.println("Error: la duración debe ser mayor que 0.");
            return;
        }

        Pelicula nueva = new Pelicula(titulo, genero, duracion);

        if (cabeza == null) {
            cabeza = nueva;
        } else {
            Pelicula actual = cabeza;

            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }

            actual.siguiente = nueva;
        }

        System.out.println("Película agregada correctamente.");
    }

    public void buscarPorTitulo(String titulo) {
        Pelicula actual = cabeza;

        while (actual != null) {
            if (actual.titulo.equalsIgnoreCase(titulo)) {
                System.out.println("Película encontrada:");
                System.out.println("Título: " + actual.titulo);
                System.out.println("Género: " + actual.genero);
                System.out.println("Duración: " + actual.duracion + " min");
                return;
            }

            actual = actual.siguiente;
        }

        System.out.println("No se encontró una película con ese título.");
    }

    public void verCartelera() {
        if (cabeza == null) {
            System.out.println("La cartelera está vacía.");
            return;
        }

        Pelicula actual = cabeza;
        int total = 0;

        System.out.println("--- Cartelera de hoy ---");

        while (actual != null) {
            System.out.println("[" + actual.titulo + " | " + actual.genero + " | " + actual.duracion + " min] ->");
            total += actual.duracion;
            actual = actual.siguiente;
        }

        System.out.println("DURACIÓN TOTAL: " + total + " minutos");
    }
}
