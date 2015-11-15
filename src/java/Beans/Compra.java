
package Beans;




public class Compra {
    
    private int id_compra;
    private String fecha;
    private String serie_factura;
    private double igv;
    private double descuento;
    private int id_proveedor;

    public Compra() {
    }

    

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getSerie_factura() {
        return serie_factura;
    }

    public void setSerie_factura(String serie_factura) {
        this.serie_factura = serie_factura;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }


    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

   
   
   
    
    
    
}
