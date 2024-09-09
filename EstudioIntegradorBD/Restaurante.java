
package EstudioIntegradorBD;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Restaurante {
    
    private static final List<Producto> productos = new ArrayList<>();

    
     public static void main(String[] args) {
         
         Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Sistema de Supermercado");
            System.out.println("1. Agregar producto");
            System.out.println("2. Modificar datos de producto");
            System.out.println("3. Eliminar producto");
            System.out.println("4. buscar producto");
            System.out.println("5. Mostrar datos productos");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (opcion) {
                case 1:
                    agregarProducto(scanner);
                    break;
                case 2:
                    modificarProducto(scanner);
                    break;
                case 3:
                    eliminarProducto(scanner);
                    break;
                case 4:
                    buscarProducto(scanner);
                    break;
                case 5:
                    mostrarDatosProducto(scanner);
                    break;   
                case 6:
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
         
     }
     
    // Método para agregar un producto
    public static void agregarProducto(Scanner scanner) {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la cantidad del producto: ");
        int cantidad = scanner.nextInt();
        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();
        
        
        Producto producto = new Producto(cantidad, nombre, cantidad, precio);
        
        productos.add(producto);
        
        System.out.println("Producto agregado con exito. Codigo de producto" + producto.getCodigoProducto());
        
    }
    
    public static void modificarProducto(Scanner scanner) {
        
        System.out.print("Ingrese el código del producto a modificar: ");
        int codigoIngresado = Integer.parseInt(scanner.nextLine());
       
        for (Producto p : productos) {
            if (p.getCodigoProducto() == codigoIngresado) {
                double nuevoPrecio = p.getPrecio() * 1.05;
                p.setPrecio(nuevoPrecio);
                System.out.println("Precio incrementado en 5% para el producto con código: " + codigoIngresado);
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    
    }
    
    public static void eliminarProducto(Scanner scanner){
        System.out.print("Ingrese el código del producto a eliminar: ");
        int codigoIngresado = Integer.parseInt(scanner.nextLine());

        for (Producto p : productos) {
            if (p.getCodigoProducto() == codigoIngresado) {
                productos.remove(p); 
                System.out.println("Producto con código " + codigoIngresado + " eliminado.");
                return;
            }
        }
        System.out.println("Producto no encontrado.");
        
    }
    
    public static void buscarProducto(Scanner scanner) {
        System.out.print("Ingrese el código del producto a buscar: ");
        int codigoIngresado = Integer.parseInt(scanner.nextLine());

        for (Producto p : productos) {
            if (p.getCodigoProducto() == codigoIngresado) {
                System.out.println("Producto encontrado: " + p);
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }   
    
    public static void mostrarDatosProducto(Scanner scanner) {
            if (productos.isEmpty()) {
            System.out.println("No hay productos en la lista.");
            return;
        }

        double totalGeneral = 0; 
        double IVA = 0.19;

    
        System.out.println("Código\t\tNombre\t\tCantidad\tPrecio\t\tTotal");
        System.out.println("-----------------------------------------------------------");

        
        for (Producto p : productos) {
            System.out.printf("%d\t\t%s\t\t%d\t\t%.2f\t\t%.2f\n",
                              p.getCodigoProducto(), p.getNombre(), p.getCantidad(), p.getPrecio(), p.getTotal());
            totalGeneral += p.getTotal();
        }

        
        double precioFinalConIVA = totalGeneral * (1 + IVA); 
        System.out.println("-----------------------------------------------------------");
        System.out.printf("Total sin IVA: \t\t\t\t\t\t%.2f\n", totalGeneral);
        System.out.printf("Total con IVA (19%%): \t\t\t\t\t%.2f\n", precioFinalConIVA);


    }

}