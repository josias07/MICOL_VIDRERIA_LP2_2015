
package DaoImpl;

import Dao.ProductosDao;
import Beans.Productos;
import Conexion.Conexion;
import conexion.conexionMYSQL2;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ProductosDaoImpl implements ProductosDao{
//conexionMYSQL2 cn = new conexionMYSQL2();
    
    Conexion cn = Conexion.getInstance();
    @Override
    public boolean agregarproducto(Productos productos) {
    boolean flat=false;
    Statement st=null;
    String query="INSERT INTO productos VALUES (null,'"+productos.getNombre()+"','"+productos.getId_categoria_prod()+"','"+productos.getCantidad()+"','"+productos.getPrecio()+"','"+productos.getDescripcion()+"','"+productos.getId_unidad_medida()+"')";
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
    public boolean eliminarproducto(int id_productos) {  
    boolean flat=false;
    String query="DELETE FROM productos WHERE id_productos="+id_productos+"";
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
    public boolean actualizarproducto(Productos productos) {
    boolean flat=false;
    String query="UPDATE productos SET nombre='"+productos.getNombre()+"',id_categoria_prod='"+productos.getId_categoria_prod()+"',cantidad='"+productos.getCantidad()+"',precio='"+productos.getPrecio()+"',descripcion='"+productos.getDescripcion()+"',id_unidad_medida='"+productos.getId_unidad_medida()+"' WHERE id_productos ="+productos.getId_productos()+"";
        
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

    @Override
    public List<Productos> listarproductos() {
    List<Productos> lista=null;
    Statement st=null;
    ResultSet rs=null;
    Productos prod=null;
        String query="select * from productos";
        try {
            lista = new ArrayList<>();
            st= cn.conexion().createStatement();
            rs=st.executeQuery(query);
            while (rs.next()) {
                
            prod =new Productos();
            prod.setId_productos(rs.getInt("id_productos"));
            prod.setNombre(rs.getString("nombre"));
            prod.setId_categoria_prod(rs.getInt("id_categoria_prod"));
            prod.setCantidad(rs.getInt("cantidad"));
            prod.setPrecio(rs.getDouble("precio"));
            prod.setDescripcion(rs.getNString("descripcion"));
            prod.setId_unidad_medida(rs.getInt("id_unidad_medida"));
            lista.add(prod);
            }
//            cn.cerrar();
        } catch (Exception e) {
            System.out.println("ERROR:"+e.getMessage());
            e.printStackTrace();
//           cn.cerrar();
        }
        return lista;
    }
    
    
}
