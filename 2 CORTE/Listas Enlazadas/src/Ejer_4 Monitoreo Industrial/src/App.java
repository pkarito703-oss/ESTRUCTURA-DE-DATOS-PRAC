/*4. Monitoreo Industrial (Sensores en Tiempo Real)
Una planta química registra lecturas de sus tanques cada hora en una lista enlazada para auditoría.
La Clase Lectura (Nodo): Debe contener idSensor (int), temperatura (double), presion (double) y hora (String).
El Problema: Las lecturas se van agregando al inicio para que la más reciente sea siempre la primera que vea el supervisor.
Reto: Implementa un método que busque y muestre la lectura con la temperatura más alta registrada en el historial.*/

public class App {
    public static void main(String[] args) throws Exception {
        ListaLecturas lista = new ListaLecturas();

        lista.insertarLectura(1, 75.5, 1.5, "12:00");
        lista.insertarLectura(2, 99.3, 1.8, "05:30");
        lista.insertarLectura(3, 71.9, 1.1, "10:55");
        lista.insertarLectura(4, 85.0, 1.0, "11:00");

        System.out.println("Lecturas registradas:");
        lista.imprimirLecturas();

        System.out.println("\n Temperatura máxima: ");
        lista.mostrarTemperaturaMaxima();

    }
}
