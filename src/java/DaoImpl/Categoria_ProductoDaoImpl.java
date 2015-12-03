package DaoImpl;

import Dao.Categoria_ProductoDao;
import Beans.Categoria_Producto;
import conexion.Conexion;
import conexion.Configuracion;
import java.util.ArrayList;
import java.util.List;

public class Categoria_ProductoDaoImpl implements Categoria_ProductoDao {

    Conexion cn = Configuracion.Vidreria();

    @Override
    public boolean agregarCategoria_Producto(Categoria_Producto categ_prod) {

        String query = "INSERT INTO categoria_producto (nombre_categoria)"
                + "VALUES ('" + categ_prod.getNombre_categoria() + "')";

        System.out.println(query);
        try {
            cn.execC(query);
            cn.Commit();

            return true;
        } catch (Exception EX) {
            cn.RollBack();

            return false;
        }

    }

    @Override
    public boolean eliminarCategoria_Producto(String id_categoria_producto) {
        boolean flat = false;
        String query = "DELETE FROM categoria_producto "
                + "WHERE id_categoria_producto=" + id_categoria_producto + "";
        try {
            cn.execC(query);
            cn.Commit();
            return true;
        } catch (Exception EX) {
            cn.RollBack();
            return false;
        }

    }

    @Override
    public boolean actualizarCategoria_Producto(Categoria_Producto categ_prod) {
        boolean flat = false;
        String query = "UPDATE categoria_producto SET nombre_categoria='" + categ_prod.getNombre_categoria()
                + "' WHERE id_categoria_producto =" + categ_prod.getId_categoria_producto();

        try {
            cn.execC(query);
            cn.Commit();

            return true;
        } catch (Exception EX) {
            cn.RollBack();

            return false;
        }
    }

    @Override
    public List<Categoria_Producto> listaCategoria() {
        List<Categoria_Producto> lista = null;
        String query = "select * from categoria_prod";
        System.out.println(query);
        lista = new ArrayList<Categoria_Producto>();
        cn.execQuery(query);
        while (cn.getNext()) {
            Categoria_Producto cp = new Categoria_Producto();
            cp.setId_categoria_producto(cn.getCol("id_categoria_prod"));
            cp.setNombre_categoria(cn.getCol("nombre_categoria"));
            lista.add(cp);
        }
//
    return lista ;

    }
}
