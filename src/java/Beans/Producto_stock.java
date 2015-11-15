
package Beans;


public class Producto_stock {
    private int id_producto_stock;
    private int cantidad;
    private int cantidad_minima;
    private int cantidad_maxima;
    private String fecha;
    private int id_producto_almacen;

    public Producto_stock() {
    }

    public int getId_producto_stock() {
        return id_producto_stock;
    }

    public void setId_producto_stock(int id_producto_stock) {
        this.id_producto_stock = id_producto_stock;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad_minima() {
        return cantidad_minima;
    }

    public void setCantidad_minima(int cantidad_minima) {
        this.cantidad_minima = cantidad_minima;
    }

    public int getCantidad_maxima() {
        return cantidad_maxima;
    }

    public void setCantidad_maxima(int cantidad_maxima) {
        this.cantidad_maxima = cantidad_maxima;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId_producto_almacen() {
        return id_producto_almacen;
    }

    public void setId_producto_almacen(int id_producto_almacen) {
        this.id_producto_almacen = id_producto_almacen;
    }
    
    
    
}
