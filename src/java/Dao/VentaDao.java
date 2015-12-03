
package Dao;


import Beans.Detalle_venta;
import Beans.Venta;
import java.util.List;

public interface VentaDao {

    public boolean agregarventa(Venta venta);
    public boolean agregardeta_venta(Detalle_venta deta_venta);
    public boolean eliminarventa(String id_venta);
    public boolean actualizarventa(Venta venta);
    public List<Venta> listarventa(String buscar, String limit);
    public List<Venta> fecha_venta(String fecha1, String fecha2);
    public boolean agregar_detalleventa(Detalle_venta deta_venta); 
    public List<Venta> terminaventa();
    public List<Venta> list_venta();
    public String REGISTRAR_VENTA(Venta venta, Detalle_venta deta);
    public Venta Datos_entrada(String id_venta);
} 

