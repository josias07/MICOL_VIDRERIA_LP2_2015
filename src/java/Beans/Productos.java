
package Beans;

import java.io.Serializable;

public class Productos implements Serializable{
    
    private String id_productos;
    private String nombre;
    private String cantidad;
    private String precio;
    private String descripcion;
    private String id_categoria_prod, nombre_categoria;
    private String id_unidad_medida, nombre_medida;

    public Productos() {
    }

    public String getId_productos() {
        return id_productos;
    }

    public void setId_productos(String id_productos) {
        this.id_productos = id_productos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getId_categoria_prod() {
        return id_categoria_prod;
    }

    public void setId_categoria_prod(String id_categoria_prod) {
        this.id_categoria_prod = id_categoria_prod;
    }

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    public String getId_unidad_medida() {
        return id_unidad_medida;
    }

    public void setId_unidad_medida(String id_unidad_medida) {
        this.id_unidad_medida = id_unidad_medida;
    }

    public String getNombre_medida() {
        return nombre_medida;
    }

    public void setNombre_medida(String nombre_medida) {
        this.nombre_medida = nombre_medida;
    }

}
