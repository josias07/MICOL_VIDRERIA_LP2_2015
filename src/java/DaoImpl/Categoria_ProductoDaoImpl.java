
package DaoImpl;

import Dao.Categoria_ProductoDao;
import Beans.Categoria_Producto;
import conexion.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Categoria_ProductoDaoImpl implements Categoria_ProductoDao{

//    conexionMYSQL cn = new conexionMYSQL();
        Conexion cn = Conexion.getInstance();

    @Override
    public boolean agregarCategoria_Producto(Categoria_Producto categ_prod) {
        boolean flat = false;
        Statement st = null;
        String query = "INSERT INTO categoria_producto VALUES (null,'" + categ_prod.getNombre_categoria() + "')";
        try {
            st = cn.conexion().createStatement();
            st.executeUpdate(query);

            cn.conexion().getAutoCommit();
//            cn.conexion().close();
            flat = true;
        } catch (Exception e) {
            System.out.println("ERROR:" + e.getMessage());
            try {
                cn.conexion().rollback();
//                cn.conexion().close();
            } catch (Exception ex) {
            }
        } finally {
            if (cn.conexion() != null) {
                try {
                    cn.conexion().rollback();
//                    cn.conexion().close();
                } catch (Exception e) {
                }
            }

        }
        return flat;
    }

    @Override
    public boolean eliminarCategoria_Producto(int id_categoria_producto) {
        boolean flat = false;

        String query = "DELETE FROM categoria_producto WHERE id_categoria_producto=" + id_categoria_producto + "";
        Statement st = null;
        try {
            st = cn.conexion().createStatement();
            st.executeUpdate(query);
            cn.guardar();
//            cn.cerrar();
            flat = true;
        } catch (Exception e) {
            cn.restaurar();
//            cn.cerrar();
            System.out.println("ERROR" + e.getMessage());
        } finally {
            if (cn.conexion() != null) {

//                cn.cerrar();

            }
        }

        return flat;
    }

    @Override
    public boolean actualizarCategoria_Producto(Categoria_Producto categ_prod) {
        boolean flat = false;
        String query = "UPDATE categoria_producto SET nombre_categoria='" + categ_prod.getNombre_categoria() + "' WHERE id_categoria_producto =" + categ_prod.getId_categoria_producto() + "";

        Statement st = null;
        try {
            st = cn.conexion().createStatement();
            st.executeUpdate(query);
            cn.guardar();
//            cn.cerrar();
            flat = true;
        } catch (Exception e) {
            cn.restaurar();
//            cn.cerrar();
            System.out.println("ERROR" + e.getMessage());
        } finally {
            if (cn.conexion() != null) {
//                cn.cerrar();
            }
        }

        return flat;
    }

    @Override
    public List<Categoria_Producto> listaCategoria() {
    List<Categoria_Producto> lista = null;
        Statement st = null;
        ResultSet rs = null;
        Categoria_Producto cp = null;
        String query = "select * from categoria_prod";
        try {
            lista = new ArrayList<>();
            st = cn.conexion().createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {

                cp = new Categoria_Producto();
                cp.setId_categoria_producto(rs.getInt("id_categoria_prod"));
                cp.setNombre_categoria(rs.getString("nombre_categoria"));
                lista.add(cp);
            }
//            cn.cerrar();
        } catch (Exception e) {
            System.out.println("ERROR:" + e.getMessage());
            e.printStackTrace();
//            cn.cerrar();
        }
        return lista;
    
    }
}
