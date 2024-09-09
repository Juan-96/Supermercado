
package EstudioIntegradorBD;


class Producto {
    
    private static int contadorProducto = 0;
    
    private int codigo;
    private String nombre;
    private int cantidad;
    private double precio;
    private double total;
    
    public Producto(int codigo, String nombre, int cantidad, double precio) {
        this.codigo = ++contadorProducto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = cantidad * precio;
    }
    
    // Getters y Setters
    public int getCodigoProducto() {
        return codigo;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        this.total = cantidad * precio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
        this.total = cantidad * precio;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return String.format("%s\t\t%d\t\t%.2f\t\t%.2f", codigo, cantidad, precio, total);
    }

}
