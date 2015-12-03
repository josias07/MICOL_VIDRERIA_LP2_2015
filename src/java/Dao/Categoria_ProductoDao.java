
package Dao;

import Beans.Categoria_Producto;
import java.util.List;



public interface Categoria_ProductoDao {
    
    public boolean agregarCategoria_Producto(Categoria_Producto categ_prod);
    public boolean eliminarCategoria_Producto(String id_categoria_producto);
    public boolean actualizarCategoria_Producto(Categoria_Producto categ_prod);
    public List<Categoria_Producto> listaCategoria();
}
