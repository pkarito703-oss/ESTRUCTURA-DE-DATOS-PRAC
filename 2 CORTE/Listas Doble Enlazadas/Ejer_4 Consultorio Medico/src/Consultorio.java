public class Consultorio {
    Nodos cabeza;

    public Consultorio() {
        cabeza = null;
    }

    public void agregarPaciente(String nombre, int edad, String enfermedad) {
        Nodos nuevo = new Nodos(nombre, edad, enfermedad);

        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodos actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }

    public void mostrarPacientes() {
        if (cabeza == null) {
            System.out.println("No hay pacientes.");
            return;
        }

        Nodos actual = cabeza;
        while (actual != null) {
            System.out.println("Nombre: " + actual.nombre);
            System.out.println("Edad: " + actual.edad);
            System.out.println("Enfermedad: " + actual.enfermedad);
            System.out.println("----------------------");
            actual = actual.siguiente;
        }
    }

    public void buscarPaciente(String nombre) {
        Nodos actual = cabeza;

        while (actual != null) {
            if (actual.nombre.equalsIgnoreCase(nombre)) {
                System.out.println("Paciente encontrado:");
                System.out.println("Nombre: " + actual.nombre);
                System.out.println("Edad: " + actual.edad);
                System.out.println("Enfermedad: " + actual.enfermedad);
                return;
            }
            actual = actual.siguiente;
        }

        System.out.println("Paciente no encontrado.");
    }

    public void eliminarPaciente(String nombre) {
        if (cabeza == null) {
            System.out.println("Lista vacia.");
            return;
        }

        if (cabeza.nombre.equalsIgnoreCase(nombre)) {
            cabeza = cabeza.siguiente;
            System.out.println("Paciente eliminado.");
            return;
        }

        Nodos actual = cabeza;
        while (actual.siguiente != null) {
            if (actual.siguiente.nombre.equalsIgnoreCase(nombre)) {
                actual.siguiente = actual.siguiente.siguiente;
                System.out.println("Paciente eliminado.");
                return;
            }
            actual = actual.siguiente;
        }

        System.out.println("Paciente no encontrado.");
    }
}
