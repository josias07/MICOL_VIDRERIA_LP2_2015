
package Beans;


public class crono_pago {
    private int id_crono_pago;
    private double monto;
    private double interes;
    private String fecha_pago;
    private String nro_cuota;

    public crono_pago() {
    }

    public int getId_crono_pago() {
        return id_crono_pago;
    }

    public void setId_crono_pago(int id_crono_pago) {
        this.id_crono_pago = id_crono_pago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public String getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(String fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public String getNro_cuota() {
        return nro_cuota;
    }

    public void setNro_cuota(String nro_cuota) {
        this.nro_cuota = nro_cuota;
    }

    
}
