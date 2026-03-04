//. Sensor de Temperatura (Control de Calidad)
//Una máquina industrial registra la temperatura cada 10 minutos y guarda los datos en un arreglo.

//El Problema: Al final del día, el supervisor quiere saber cuál fue la temperatura más alta registrada para asegurarse de que la máquina no se recalentó.
//Algoritmo a usar: Búsqueda Lineal de Máximo. Debes recorrer todo el arreglo comparando cada valor para encontrar el mayor de todos.
public class Ejer_3 {

    public static void main(String[] args) {

        // 24 horas * 6 registros por hora = 144 registros
        double[] temp = new double[144];

        for (int i = 0; i < temp.length; i++) {
            temp[i] = 60 + Math.random() * 40;
        }

        double max = temp[0];

        for (int i = 1; i < temp.length; i++) {
            if (temp[i] > max) {
                max = temp[i];
            }
        }
        System.out.println("La temperatura mas alta registrada fue: " + max );
    }
}