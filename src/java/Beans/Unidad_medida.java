
package Beans;


public class Unidad_medida {
   
    private int id_unidad_medida;
    private String nombre_uni;
    private String descripcion;
    private String abreviatura;

    public Unidad_medida() {
    }

    public int getId_unidad_medida() {
        return id_unidad_medida;
    }

    public void setId_unidad_medida(int id_unidad_medida) {
        this.id_unidad_medida = id_unidad_medida;
    }

    public String getNombre_uni() {
        return nombre_uni;
    }

    public void setNombre_uni(String nombre_uni) {
        this.nombre_uni = nombre_uni;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }
    
    
}
