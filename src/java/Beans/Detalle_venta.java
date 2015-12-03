
package Beans;


public class Detalle_venta {
    private String id_detalle_venta;
    private String descripcion;
    private String cantidad;
    private String precio_unitario;
    private String importe;
    private String id_venta;
    private String id_productos, id_usuario;

    public Detalle_venta() {
    }

    public String getId_detalle_venta() {
        return id_detalle_venta;
    }

    public void setId_detalle_venta(String id_detalle_venta) {
        this.id_detalle_venta = id_detalle_venta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(String precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public String getImporte() {
        return importe;
    }

    public void setImporte(String importe) {
        this.importe = importe;
    }

    public String getId_venta() {
        return id_venta;
    }

    public void setId_venta(String id_venta) {
        this.id_venta = id_venta;
    }

    public String getId_productos() {
        return id_productos;
    }

    public void setId_productos(String id_productos) {
        this.id_productos = id_productos;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

   
    
    
}
