/*4. Turnos de Consultorio Médico (Prioridad de Emergencia)
Gestiona una fila de pacientes donde algunos pueden tener emergencias.

La Clase Paciente (Nodo): Debe contener nombre (String), edad (int) y nivelUrgencia (1 al 5).
El Problema: Los pacientes normalmente se agregan al final. Pero si un paciente tiene nivelUrgencia == 5, debe ser movido justo después de la Cabeza.
Reto: Implementa un método que recorra la lista desde la Cola hacia la Cabeza para encontrar al paciente de mayor edad y mostrar sus datos.
*/
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Consultorio consultorio = new Consultorio();

        int opcion;

        do {
            System.out.println("\n--- CONSULTORIO ---");
            System.out.println("1. Agregar paciente");
            System.out.println("2. Mostrar pacientes");
            System.out.println("3. Buscar paciente");
            System.out.println("4. Eliminar paciente");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Edad: ");
                    int edad = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enfermedad: ");
                    String enfermedad = sc.nextLine();

                    consultorio.agregarPaciente(nombre, edad, enfermedad);
                    break;

                case 2:
                    consultorio.mostrarPacientes();
                    break;

                case 3:
                    System.out.print("Nombre a buscar: ");
                    nombre = sc.nextLine();
                    consultorio.buscarPaciente(nombre);
                    break;

                case 4:
                    System.out.print("Nombre a eliminar: ");
                    nombre = sc.nextLine();
                    consultorio.eliminarPaciente(nombre);
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 5);

        sc.close();
    }
}
