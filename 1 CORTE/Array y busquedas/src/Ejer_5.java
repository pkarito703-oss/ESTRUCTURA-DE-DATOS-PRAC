 //Contador de Estudiantes (Registro Académico)
//Un profesor tiene un arreglo con las notas finales de 30 estudiantes 
//(ej: 3.5, 4.0, 2.8, 5.0, ...).

//El Problema: El profesor necesita saber exactamente cuántos estudiantes sacaron una nota de 5.0.
//Algoritmo a usar: Búsqueda Lineal con Contador. Debes recorrer todo el arreglo y, cada vez que encuentres un 5.0, aumentar una variable contador.
import java.util.Scanner;

public class Ejer_5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //double[] notas = new double[5];
        double [] notas = {3, 4.5, 5, 5, 2, 5, 3.4,5};
        int contador = 0;

       // for (int i = 0; i < notas.length; i++) {
         //   System.out.print("Ingrese la nota del estudiante " + (i + 1) + ": ");
           // notas[i] = sc.nextDouble();
        //}

        for (int i = 0; i < notas.length; i++) {
            if (notas[i] == 5.0) {
                contador++;
            }
        }

        System.out.println("Cantidad de estudiantes con nota 5.0: " + contador);

        sc.close();
    }
}