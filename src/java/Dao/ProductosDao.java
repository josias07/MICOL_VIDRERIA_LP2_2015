
package Dao;


import Beans.Productos;
import java.util.List;



public interface ProductosDao {
    public boolean agregarproducto(Productos productos);
    public boolean eliminarproducto(String id_productos);
    public boolean actualizarproducto(Productos productos);
    public List<Productos> listarproductos(String buscar, String limit);
     public Productos DatosProductos(String id_productos); 
}
