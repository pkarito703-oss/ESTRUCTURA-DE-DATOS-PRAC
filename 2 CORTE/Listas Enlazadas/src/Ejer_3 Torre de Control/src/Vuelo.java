
public class Vuelo {
    private String numeroVuelo;
    private String aerolinea;
    private int combustibleRestante;
    private int pasajeros;
    Vuelo siguiente;

    public Vuelo(String numeroVuelo, String aerolinea, int combustibleRestante, int pasajeros) {
        this.numeroVuelo = numeroVuelo;
        this.aerolinea = aerolinea;
        this.combustibleRestante = combustibleRestante;
        this.pasajeros = pasajeros;
        this.siguiente = null;
    }

    public String getNumeroVuelo() { return numeroVuelo; }
    public String getAerolinea() { return aerolinea; }
    public int getCombustibleRestante() { return combustibleRestante; }
    public int getPasajeros() { return pasajeros; }
    public void setCombustibleRestante(int combustible) { this.combustibleRestante = combustible; }

    @Override
    public String toString() {
        String alerta = combustibleRestante < 10 ? " EMERGENCIA" : "";
        return String.format("[%s | %s | Combustible: %d | Pasajeros: %d%s]",
                numeroVuelo, aerolinea, combustibleRestante, pasajeros, alerta);
    }
}