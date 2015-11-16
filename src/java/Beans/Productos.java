
package Beans;

import java.io.Serializable;

public class Productos implements Serializable{
    
    private int id_productos;
    private String nombre;
    private int id_categoria_prod;
    private int cantidad;
    private double precio;
    private String descripcion;
    private int id_unidad_medida;

    public Productos() {
    }

    public int getId_productos() {
        return id_productos;
    }

    public void setId_productos(int id_productos) {
        this.id_productos = id_productos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_categoria_prod() {
        return id_categoria_prod;
    }

    public void setId_categoria_prod(int id_categoria_prod) {
        this.id_categoria_prod = id_categoria_prod;
    }

//    public int getId_productividad() {
//        return id_productividad;
//    }
//
//    public void setId_productividad(int id_productividad) {
//        this.id_productividad = id_productividad;
//    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_unidad_medida() {
        return id_unidad_medida;
    }

    public void setId_unidad_medida(int id_unidad_medida) {
        this.id_unidad_medida = id_unidad_medida;
    }
    
    
}
