
package Dao;

import Beans.Proveedor;
import java.util.List;


public interface ProveedorDao {
    public boolean agregarProveedor (Proveedor proveedor);
    public boolean eliminarproveedor(String id_proveedor);
    public boolean actualizarproveedor(Proveedor proveedor);
    public List<Proveedor> listarProveedor();
    
}
