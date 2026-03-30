public class ListaLecturas {
    Lectura cabeza;

    public ListaLecturas() {
        cabeza = null;
    }

    public void insertarLectura(int idSensor, double temperatura, double presion, String hora) {
        Lectura nuevaLectura = new Lectura(idSensor, temperatura, presion, hora);

        nuevaLectura.siguiente = cabeza;
        cabeza = nuevaLectura;
    }

    public void imprimirLecturas() {
        Lectura actual = cabeza;

        while (actual != null) {
            System.out.println("Sensor: " + actual.idSensor + ", Temp: " + actual.temperatura + ", Presión: " + actual.presion + ", Hora: " + actual.hora);
            actual = actual.siguiente;
        }
    }

    public void mostrarTemperaturaMaxima() {
        if (cabeza == null) {
            System.out.println("No hay lecturas registradas.");
            return;
        }

        Lectura actual = cabeza;
        Lectura maximo = cabeza;

        while (actual != null) {
            if (actual.temperatura > maximo.temperatura) {
                maximo = actual;
            }
            actual = actual.siguiente;
        }

        System.out.println("Lectura con mayor temperatura:");
        System.out.println("Sensor: " + maximo.idSensor + ", Temp: " + maximo.temperatura + ", Presión: " + maximo.presion + ", Hora: " + maximo.hora);
    }
}
