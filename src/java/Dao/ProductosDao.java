
package Dao;


import Beans.Productos;
import java.util.List;



public interface ProductosDao {
    public boolean agregarproducto(Productos productos);
    public boolean eliminarproducto(int id_productos);
    public boolean actualizarproducto(Productos productos);
    public List<Productos> listarproductos();
    public List<Productos> repor_producto(String buscar);
}
