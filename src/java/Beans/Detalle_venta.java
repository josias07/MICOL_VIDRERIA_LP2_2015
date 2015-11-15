
package Beans;


public class Detalle_venta {
    private int id_detalle_venta;
    private String descripcion;
    private int cantidad;
    private double precio_unitario;
    private double importe;
    private int id_venta;
    private int id_producto_stock;

    public Detalle_venta() {
    }

    public int getId_detalle_venta() {
        return id_detalle_venta;
    }

    public void setId_detalle_venta(int id_detalle_venta) {
        this.id_detalle_venta = id_detalle_venta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_producto_stock() {
        return id_producto_stock;
    }

    public void setId_producto_stock(int id_producto_stock) {
        this.id_producto_stock = id_producto_stock;
    }
    
    
    
}
