
package Dao;


import Beans.Venta;
import java.util.List;

public interface VentaDao {

    public boolean agregarventa(Venta venta);
    public boolean eliminarventa(int id_venta);
    public boolean actualizarventa(Venta venta);
    public List<Venta> listarventa();
} 

