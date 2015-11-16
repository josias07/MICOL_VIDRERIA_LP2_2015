
package Dao;

import Beans.Categoria_Producto;




public interface Categoria_ProductoDao {
    
    public boolean agregarCategoria_Producto(Categoria_Producto categ_prod);
    public boolean eliminarCategoria_Producto(int id_categoria_producto);
    public boolean actualizarCategoria_Producto(Categoria_Producto categ_prod);
}
