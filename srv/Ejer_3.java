package srv;
//un sensor industrial registra temperaturas. El sistema recibe:

//Temperatura actual en Celsius (double)
//Nombre del sensor (String)
//Número de lectura (int)
//Si la temperatura supera el límite de 80°C, una variable boolean llamada enAlarma debe ser true.
//Imprime el estado del sensor con todos sus datos.

public class Ejer_3 {
    public static void main(String[] args) {

        double Temperatura_Celsius = 81.0;
        String Sensor = "DHT11";
        int numero_de_lecturas = 5;
        boolean alarma = false;

        if (Temperatura_Celsius > 80) {
            alarma = true;
        }
        System.out.println("**********Datos del sensor de temperatura*************");
        System.out.println("Temperatura: " + Temperatura_Celsius);
        System.out.println("Sensor: " + Sensor);
        System.out.println("Numero de lecturas: " + numero_de_lecturas);
        System.out.println("Alarma activada: " + alarma);
    }
}