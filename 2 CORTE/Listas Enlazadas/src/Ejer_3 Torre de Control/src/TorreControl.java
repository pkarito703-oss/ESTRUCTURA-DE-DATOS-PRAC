/**
 * Clase TorreControl - Gestiona la cola de aterrizaje como lista enlazada.
 * Vuelos normales se agregan al final; emergencias (combustible < 10) van al inicio.
 */
public class TorreControl {

    private Vuelo cabeza;
    private int tamanio;
    private String nombreAeropuerto;

    public TorreControl(String nombreAeropuerto) {
        this.nombreAeropuerto = nombreAeropuerto;
        this.cabeza = null;
        this.tamanio = 0;
    }

    public void agregarVuelo(String numeroVuelo, String aerolinea, int combustible, int pasajeros) {
        Vuelo vuelo = new Vuelo(numeroVuelo, aerolinea, combustible, pasajeros);
        if (combustible < 10) {
            System.out.println("Vuelo " + numeroVuelo + " ingresa con emergencia. Movido al inicio.");
            insertarAlInicio(vuelo);
        } else {
            insertarAlFinal(vuelo);
            System.out.println("Vuelo " + numeroVuelo + " agregado al final de la cola.");
        }
        tamanio++;
    }

    private void insertarAlFinal(Vuelo vuelo) {
        if (cabeza == null) {
            cabeza = vuelo;
            return;
        }
        Vuelo actual = cabeza;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }
        actual.siguiente = vuelo;
    }

    private void insertarAlInicio(Vuelo vuelo) {
        vuelo.siguiente = cabeza;
        cabeza = vuelo;
    }

    // ─── Reportar emergencia ─────────────────────────────────────────────────

    /**
     * Busca un vuelo en la cola y lo mueve al inicio si su combustible es < 10.
     * @param numeroVuelo número del vuelo a buscar
     */
    public void reportarEmergencia(String numeroVuelo) {
        System.out.println("\n EMERGENCIA reportada — Vuelo: " + numeroVuelo);

        if (cabeza == null) {
            System.out.println("La cola está vacía.");
            return;
        }

        // Ya está en la cabeza
        if (cabeza.getNumeroVuelo().equalsIgnoreCase(numeroVuelo)) {
            System.out.println(" El vuelo ya está en la primera posición.");
            return;
        }

        Vuelo anterior = cabeza;
        Vuelo actual = cabeza.siguiente;

        while (actual != null) {
            if (actual.getNumeroVuelo().equalsIgnoreCase(numeroVuelo)) {
                if (actual.getCombustibleRestante() >= 10) {
                    System.out.println("Vuelo " + numeroVuelo + " tiene " +
                            actual.getCombustibleRestante() +
                            " unidades de combustible. No califica como emergencia (requiere < 10).");
                    return;
                }
                // Desconectar de su posición y mover al inicio
                anterior.siguiente = actual.siguiente;
                actual.siguiente = cabeza;
                cabeza = actual;
                System.out.println("Vuelo " + numeroVuelo + " movido al inicio. Combustible crítico: "
                        + actual.getCombustibleRestante() + " unidades.");
                return;
            }
            anterior = actual;
            actual = actual.siguiente;
        }

        System.out.println("Vuelo " + numeroVuelo + " no encontrado en la cola.");
    }

    // ─── Aterrizaje ──────────────────────────────────────────────────────────

    /**
     * Retira y atiende el primer vuelo de la cola.
     */
    public void autorizarAterrizaje() {
        if (cabeza == null) {
            System.out.println("No hay vuelos en espera.");
            return;
        }
        Vuelo atendido = cabeza;
        cabeza = cabeza.siguiente;
        atendido.siguiente = null;
        tamanio--;
        System.out.println("Vuelo " + atendido.getNumeroVuelo() +
                " (" + atendido.getAerolinea() + ") autorizado para aterrizar.");
    }

    // ─── Estado ──────────────────────────────────────────────────────────────

    public void mostrarEstado() {
        System.out.println("\n╔══════════════════════════════════════════════╗");
        System.out.printf( "║  TORRE DE CONTROL — %-25s║%n", nombreAeropuerto);
        System.out.printf( "║  Vuelos en espera: %-26d║%n", tamanio);
        System.out.println("╠══════════════════════════════════════════════╣");
        if (cabeza == null) {
            System.out.println("  (Cola vacía)");
        } else {
            int pos = 1;
            Vuelo actual = cabeza;
            while (actual != null) {
                System.out.println("  " + pos + ". " + actual);
                actual = actual.siguiente;
                pos++;
            }
        }
        System.out.println("╚══════════════════════════════════════════════╝");
    }
}