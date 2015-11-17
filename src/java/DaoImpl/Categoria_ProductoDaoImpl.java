
package DaoImpl;

import Dao.Categoria_ProductoDao;
import Beans.Categoria_Producto;
import Conexion.Conexion;
import conexion.conexionMYSQL2;
import java.sql.Statement;


public class Categoria_ProductoDaoImpl implements Categoria_ProductoDao{
//    conexionMYSQL2 cn = new conexionMYSQL2();
    Conexion cn = Conexion.getInstance();

    @Override
    public boolean agregarCategoria_Producto(Categoria_Producto categ_prod) {
        boolean flat=false;
        Statement st=null;
        String query="INSERT INTO categoria_producto VALUES (null,'"+categ_prod.getNombre_categoria()+"')";
        try {
            st=cn.conexion().createStatement();
            st.executeUpdate(query);
            
            cn.conexion().getAutoCommit();
//            cn.conexion().close();
            flat=true;
             } catch (Exception e) {
                 System.out.println("ERROR:"+e.getMessage());
                 try {
                     cn.conexion().rollback();
//                     cn.conexion().close();
            } catch (Exception ex) {
            }
        }finally{
            if (cn.conexion() !=null) 
                try {
                    cn.conexion().rollback();
//                    cn.conexion().close();
                } catch (Exception e) {
                }

                }
                 return flat;
    }

    @Override
    public boolean eliminarCategoria_Producto(int id_categoria_producto) {
            boolean flat=false;
         
       String query="DELETE FROM categoria_producto WHERE id_categoria_producto="+id_categoria_producto+"";
       Statement st=null;
        try {
            st=cn.conexion().createStatement();
            st.executeUpdate(query);
            cn.guardar();
//            cn.cerrar();
            flat=true;
        } catch (Exception e) {
            cn.restaurar();
//            cn.cerrar();
            System.out.println("ERROR"+e.getMessage());
        }finally{
            if (cn.conexion()!=null) {
                
             
//            cn.cerrar();
                
            }
        }
       
    return  flat;
    }
    

    @Override
    public boolean actualizarCategoria_Producto(Categoria_Producto categ_prod) {
      boolean flat=false;
      String query="UPDATE categoria_producto SET nombre_categoria='"+categ_prod.getNombre_categoria()+"' WHERE id_categoria_producto ="+categ_prod.getId_categoria_producto()+"";
        
        Statement st=null;
        try {
            st=cn.conexion().createStatement();
            st.executeUpdate(query);
            cn.guardar();
//            cn.cerrar();
            flat=true;
        } catch (Exception e) {
            cn.restaurar();
//            cn.cerrar();
            System.out.println("ERROR"+e.getMessage());
        }finally{
            if (cn.conexion()!=null) {
//                cn.cerrar();
            }
        }
        
         return flat;
    }
    
}
