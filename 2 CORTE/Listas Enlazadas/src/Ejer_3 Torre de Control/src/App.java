/*
3. Torre de Control (Aterrizajes de Emergencia) Simula la cola de aviones esperando para aterrizar en un aeropuerto congestionado. La Clase Vuelo (Nodo): Debe contener numeroVuelo (String), aerolinea (String), combustibleRestante (int) y pasajeros (int). El Problema: Normalmente los vuelos se forman al final de la cola. Sin embargo, si un vuelo reporta menos de 10 unidades de combustible, debe ser movido inmediatamente al inicio de la lista (Cabeza). Reto: Implementar el método reportarEmergencia(String numeroVuelo) que busque un vuelo en la cola y lo mueva al principio.
*/
public class App {

    public static void main(String[] args) {

        TorreControl torre = new TorreControl("El Dorado BOG");

        // ─── 1. Registrar vuelos normales ─────────────────────────────────────
        System.out.println("=== REGISTRANDO VUELOS ===");
        torre.agregarVuelo("AV101", "Avianca",      45, 180);
        torre.agregarVuelo("LA302", "LATAM",         30, 210);
        torre.agregarVuelo("VV520", "Viva Air",      22, 150);
        torre.agregarVuelo("IB880", "Iberia",        18, 270);
        torre.agregarVuelo("AA099", "American",      50, 190);

        torre.mostrarEstado();

        // ─── 2. Vuelo que ingresa ya con combustible crítico ──────────────────
        System.out.println("\n=== VUELO CON EMERGENCIA AL INGRESAR ===");
        torre.agregarVuelo("CM777", "Copa Airlines", 5, 160);

        torre.mostrarEstado();

        // ─── 3. Reportar emergencia de un vuelo ya en cola ───────────────────
        // Caso A: vuelo con combustible suficiente (no aplica emergencia)
        torre.reportarEmergencia("LA302");

        // Caso B: vuelo con combustible crítico en cola
        torre.agregarVuelo("EM001", "SkyTest", 7, 100);
        torre.reportarEmergencia("EM001");

        torre.mostrarEstado();

        // ─── 4. Autorizar aterrizajes en orden ───────────────────────────────
        System.out.println("\n=== AUTORIZANDO ATERRIZAJES ===");
        torre.autorizarAterrizaje();
        torre.autorizarAterrizaje();
        torre.autorizarAterrizaje();

        torre.mostrarEstado();

        // ─── 5. Vuelo inexistente ─────────────────────────────────────────────
        System.out.println("\n=== CASO: VUELO NO ENCONTRADO ===");
        torre.reportarEmergencia("XX999");
    }
}