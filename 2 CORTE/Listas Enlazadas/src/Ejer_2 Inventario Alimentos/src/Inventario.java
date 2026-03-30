
public class Inventario {
    private Producto cabeza;

    public Inventario() {
        this.cabeza = null;
    }

    // Insertar producto según prioridad
    public void agregarProducto(Producto nuevo) {
        if (nuevo.getDiasParaVencer() < 3) {
            // Insertar al inicio
            nuevo.setSiguiente(cabeza);
            cabeza = nuevo;
        } else {
            // Insertar al final
            if (cabeza == null) {
                cabeza = nuevo;
            } else {
                Producto actual = cabeza;
                while (actual.getSiguiente() != null) {
                    actual = actual.getSiguiente();
                }
                actual.setSiguiente(nuevo);
            }
        }
    }

    // Mostrar productos con menos de 5 días para vencer
    public void mostrarProximosAVencer() {
        Producto actual = cabeza;

        System.out.println("Productos con menos de 5 días para vencer:");

        while (actual != null) {
            if (actual.getDiasParaVencer() < 5) {
                System.out.println("Nombre: " + actual.getNombre() +
                                   ", Cantidad: " + actual.getCantidad() +
                                   ", Días para vencer: " + actual.getDiasParaVencer());
            }
            actual = actual.getSiguiente();
        }
    }

    // Mostrar todo (opcional)
    public void mostrarInventario() {
        Producto actual = cabeza;

        while (actual != null) {
            System.out.println("Nombre: " + actual.getNombre() +
                               ", Cantidad: " + actual.getCantidad() +
                               ", Días: " + actual.getDiasParaVencer());
            actual = actual.getSiguiente();
        }
    }
}