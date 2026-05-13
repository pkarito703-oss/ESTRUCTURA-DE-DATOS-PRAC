public class Nodo {

    String placa;
    String conductor;
    double cargaToneladas;

    Nodo siguiente;

    public Nodo(String placa,
                String conductor,
                double cargaToneladas) {

        this.placa = placa;
        this.conductor = conductor;
        this.cargaToneladas = cargaToneladas;

        this.siguiente = null;
    }
}