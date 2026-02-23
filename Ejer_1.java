//Un sistema universitario necesita registrar la información básica de un 
//estudiante: nombre completo, código (número entero), semestre actual,
//promedio acumulado y si está matriculado o no.

public class Ejer_1 {
    public static void main(String[] args) {
        String nombre = "Karoll Juliana Perez Rangel";
        int codigo = 12345;
        String carrera = "Ingenieria en Sistemas";
        float promedio = 4.2f;
        boolean matriculado = true;

        System.out.println("**********Datos del estudiante*************" );

        System.out.println("Nombre: " + nombre);
        System.out.println("Codigo: " + codigo);
        System.out.println("Carrera: " + carrera);
        System.out.println("Promedio: " + promedio);
        System.out.println("Matriculado: " + matriculado);
    }
}