import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventario inv = new Inventario();

        int opcion;

        do {
            System.out.println("\nMENU INVENTARIO");
            System.out.println("1. Registrar producto");
            System.out.println("2. Buscar y editar cantidad");
            System.out.println("3. Mostrar inventario y valor total");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Código: ");
                    int cod = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nombre: ");
                    String nom = sc.nextLine();

                    System.out.print("Cantidad: ");
                    int cant = sc.nextInt();

                    System.out.print("Precio: ");
                    double precio = sc.nextDouble();

                    inv.agregar(cod, nom, cant, precio);
                    break;

                case 2:
                    System.out.print("Código a buscar: ");
                    int codigo = sc.nextInt();

                    System.out.print("Cantidad a sumar o restar: ");
                    int cambio = sc.nextInt();

                    inv.editarCantidad(codigo, cambio);
                    break;

                case 3:
                    inv.mostrar();
                    break;

                case 4:
                    System.out.print("Código a eliminar: ");
                    int eliminar = sc.nextInt();
                    inv.eliminar(eliminar);
                    break;

                case 5:
                    System.out.println("Saliendo del sistema");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 5);

        sc.close();
    }
}
