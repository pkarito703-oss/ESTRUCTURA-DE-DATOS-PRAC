public class Inventario {

    // Referencia al primer nodo de la lista (inicio del inventario)
    Nodo cabeza;

    // Constructor: inicializa la lista vacía
    public Inventario() {
        cabeza = null;
    }

    // ==============================
    // VALIDAR SI UN CÓDIGO YA EXISTE
    // ==============================
    /*
     * ¿Qué hace?
     * Recorre toda la lista buscando si ya existe un producto con ese código.
     * 
     * ¿Para qué sirve?
     * Evitar que se registren productos con códigos duplicados.
     * 
     * ¿Cómo funciona?
     * Va nodo por nodo comparando el código.
     */
    public boolean existeCodigo(int codigo) {
        Nodo aux = cabeza; // empieza desde el inicio

        while (aux != null) { // mientras no llegue al final
            if (aux.codigo == codigo) {
                return true; // encontró el código
            }
            aux = aux.siguiente; // avanza al siguiente nodo
        }
        return false; // no lo encontró
    }

    // ==============================
    // AGREGAR PRODUCTO AL FINAL
    // ==============================
    /*
     * ¿Qué hace?
     * Inserta un nuevo producto al final de la lista.
     * 
     * ¿Para qué sirve?
     * Para registrar nuevos productos en el inventario.
     * 
     * ¿Cómo funciona?
     * - Primero valida que no haya errores (cantidad negativa o código repetido)
     * - Si la lista está vacía, el nuevo nodo será la cabeza
     * - Si no, recorre hasta el último nodo y lo enlaza ahí
     */
    public void agregar(int codigo, String nombre, int cantidad, double precio) {

        // Validación de cantidad
        if (cantidad < 0) {
            System.out.println("Error: No se permiten cantidades negativas");
            return;
        }

        // Validación de código duplicado
        if (existeCodigo(codigo)) {
            System.out.println("Error: Código duplicado");
            return;
        }

        // Se crea el nuevo nodo (producto)
        Nodo nuevo = new Nodo(codigo, nombre, cantidad, precio);

        // Si la lista está vacía
        if (cabeza == null) {
            cabeza = nuevo; // el nuevo nodo es el primero
        } else {
            Nodo aux = cabeza;

            // Se recorre hasta el último nodo
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }

            // Se enlaza el nuevo nodo al final
            aux.siguiente = nuevo;
        }

        System.out.println("Producto agregado correctamente");
    }

    // ==============================
    // BUSCAR Y EDITAR CANTIDAD
    // ==============================
    /*
     * ¿Qué hace?
     * Busca un producto por su código y modifica su cantidad.
     * 
     * ¿Para qué sirve?
     * Para aumentar o disminuir el stock.
     * 
     * ¿Cómo funciona?
     * - Recorre la lista buscando el código
     * - Suma o resta la cantidad (según el valor de "cambio")
     * - Valida que el resultado no sea negativo
     */
    public void editarCantidad(int codigo, int cambio) {
        Nodo aux = cabeza;

        while (aux != null) {
            if (aux.codigo == codigo) {

                int nuevaCantidad = aux.cantidad + cambio;

                // Validar que no quede negativa
                if (nuevaCantidad < 0) {
                    System.out.println("Error: La cantidad no puede ser negativa");
                } else {
                    aux.cantidad = nuevaCantidad;
                    System.out.println("Cantidad actualizada: " + aux.cantidad);
                }
                return; // termina el método
            }
            aux = aux.siguiente;
        }

        System.out.println("Producto no encontrado");
    }

    // ==============================
    // MOSTRAR INVENTARIO
    // ==============================
    /*
     * ¿Qué hace?
     * Muestra todos los productos y calcula el valor total del inventario.
     * 
     * ¿Para qué sirve?
     * Para visualizar el estado completo del inventario.
     * 
     * ¿Cómo funciona?
     * - Recorre toda la lista
     * - Calcula el valor de cada producto (cantidad * precio)
     * - Va acumulando el total
     */
    public void mostrar() {
        Nodo aux = cabeza;
        double total = 0;

        if (cabeza == null) {
            System.out.println("Inventario vacío");
            return;
        }

        while (aux != null) {

            double valor = aux.cantidad * aux.precio;
            total += valor;

            System.out.println("Código: " + aux.codigo +
                    " | Nombre: " + aux.nombre +
                    " | Cantidad: " + aux.cantidad +
                    " | Precio: " + aux.precio +
                    " | Valor: " + valor);

            aux = aux.siguiente;
        }

        System.out.println("Valor total del inventario: " + total);
    }

    // ==============================
    // ELIMINAR PRODUCTO
    // ==============================
    /*
     * ¿Qué hace?
     * Elimina un producto de la lista según su código.
     * 
     * ¿Para qué sirve?
     * Para borrar productos del inventario.
     * 
     * ¿Cómo funciona?
     * - Caso 1: si la lista está vacía → no hace nada
     * - Caso 2: si el producto es el primero → se mueve la cabeza
     * - Caso 3: si está en medio o final → se conecta el anterior con el siguiente
     */
    public void eliminar(int codigo) {

        if (cabeza == null) {
            System.out.println("Lista vacía");
            return;
        }

        // Caso: eliminar el primero (cabeza)
        if (cabeza.codigo == codigo) {
            cabeza = cabeza.siguiente;
            System.out.println("Producto eliminado");
            return;
        }

        Nodo aux = cabeza;
        Nodo anterior = null;

        // Buscar el nodo a eliminar
        while (aux != null && aux.codigo != codigo) {
            anterior = aux;
            aux = aux.siguiente;
        }

        if (aux == null) {
            System.out.println("Producto no encontrado");
        } else {
            // Se "salta" el nodo a eliminar
            anterior.siguiente = aux.siguiente;
            System.out.println("Producto eliminado");
        }
    }
}