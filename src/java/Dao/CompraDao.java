
package Dao;

import Beans.Compra;    
import java.util.List;

public interface CompraDao {
    
    public boolean agregarCompra(Compra compra);
    public boolean eliminarcompra(int id_compra);
    public boolean actualizarcompra(Compra compra);
    public List<Compra> listarcompra();
   public List<Compra>fechacompra(String fecha1, String fecha2);
}
