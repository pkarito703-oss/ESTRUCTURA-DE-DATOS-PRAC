import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        ListaEnlazada lista = new ListaEnlazada();
        boolean continuar = true;
        
        System.out.println("========================================");
        System.out.println("     RETO 2: Contar los Nodos");
        System.out.println("========================================\n");
        
        while (continuar) {
            mostrarMenu();
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    System.out.print("¿Dónde deseas insertar el elemento?\n");
                    System.out.print("  1. Al inicio\n  2. Al final\nOpción: ");
                    int ubicacion = scanner.nextInt();
                    System.out.print("Ingresa el valor del elemento: ");
                    int valor = scanner.nextInt();
                    
                    if (ubicacion == 1) {
                        lista.insertarAlInicio(valor);
                        System.out.println("Elemento " + valor + " insertado al INICIO\n");
                    } else if (ubicacion == 2) {
                        lista.insertarAlFinal(valor);
                        System.out.println("Elemento " + valor + " insertado al FINAL\n");
                    } else {
                        System.out.println("Opción no valida\n");
                    }
                    break;
                    
                case 2:
                    int cantidad = lista.contarNodos();
                    System.out.println("\n========================================");
                    System.out.println("Total de nodos en la lista: " + cantidad);
                    System.out.println("========================================\n");
                    break;
                    
                case 3:
                    System.out.println();
                    lista.imprimir();
                    System.out.println();
                    break;
                    
                case 4:
                    System.out.println("\nSaliendo");
                    continuar = false;
                    break;
                    
                default:
                    System.out.println("Opcion no valida. Intenta de nuevo.\n");
            }
        }
        
        scanner.close();
    }
    
    public static void mostrarMenu() {
        System.out.println("========================================");
        System.out.println("           MENÚ PRINCIPAL");
        System.out.println("========================================");
        System.out.println("1. Insertar un elemento");
        System.out.println("2. Contar nodos");
        System.out.println("3. Ver lista completa");
        System.out.println("4. Salir");
        System.out.println("========================================");
    }
}


