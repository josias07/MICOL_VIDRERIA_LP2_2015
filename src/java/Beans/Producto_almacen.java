
package Beans;


public class Producto_almacen {
    private int id_producto_almacen;
    private int id_productos;
    private int cantidad_maxima;
    private int cantidad_minima;
    private int cantidad;

    public Producto_almacen() {
    }

    public int getId_producto_almacen() {
        return id_producto_almacen;
    }

    public void setId_producto_almacen(int id_producto_almacen) {
        this.id_producto_almacen = id_producto_almacen;
    }

    public int getId_productos() {
        return id_productos;
    }

    public void setId_productos(int id_productos) {
        this.id_productos = id_productos;
    }

    public int getCantidad_maxima() {
        return cantidad_maxima;
    }

    public void setCantidad_maxima(int cantidad_maxima) {
        this.cantidad_maxima = cantidad_maxima;
    }

    public int getCantidad_minima() {
        return cantidad_minima;
    }

    public void setCantidad_minima(int cantidad_minima) {
        this.cantidad_minima = cantidad_minima;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
}
