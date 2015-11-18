
package DaoImpl;

import Dao.ProductosDao;
import Beans.Productos;
import conexion.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ProductosDaoImpl implements ProductosDao{
//conexionMYSQL cn = new conexionMYSQL();
    Conexion cn = Conexion.getInstance();
    @Override
    public boolean agregarproducto(Productos productos) {
    boolean flat=false;
    Statement st=null;
    String query="INSERT INTO productos (nombre,cantidad, precio, descripcion, id_categoria_prod, id_unidad_medida)"
            + " VALUES ('"+productos.getNombre()+"','"+productos.getCantidad()+"','"+productos.getPrecio()+"','"+productos.getDescripcion()+"','"+productos.getId_categoria_prod()+"','"+productos.getId_unidad_medida()+"')";
        try {
            st=cn.conexion().createStatement();
            st.executeUpdate(query);
            
            cn.conexion().getAutoCommit();
//            cn.conexion().close();
            flat=true;
             } catch (Exception e) {
                 System.out.println("ERROR:"+e.getMessage());
                 System.out.println("query"+query);
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

//    @Override
//    public List<Productos> repor_producto(String buscar) {
//    List<Productos> lista = null;
//        String query = "select "
//                + " pr.id_producto,"
//                + " pr.codigo,"
//                + " pr.nombre,"
//                + " cat.nombre nombre_categoria,"
//                + " pr.presentacion,"
//                + " pr.marca,"
//                + " pr.modelo,"
//                + " um.nombre nombre_unidad_medida,"
//                + " pr.precio_compra,"
//                + " case pr.estado "
//                + " when '1' then 'Activo' "
//                + " else 'Desactivo' "
//                + " end estado "
//                + " from producto pr,"
//                + " categoria cat, "
//                + " unidad_medida um "
//                + " where "
//                + " pr.id_categoria=cat.id_categoria and "
//                + " pr.id_unidad_medida=um.id_unidad_medida and "
//                + " UPPER(pr.nombre) like ('%" + buscar + "%')"
//                + " order by pr.nombre"
//                + " limit "+limit;
//        System.out.println(query);
//        lista = new ArrayList<Productos>();
//        cn.execQuery(query);
//        while (cn.getNext()) {
//
//            Productos p = new Productos();
//            p.setId_producto(cn.getCol("id_producto"));
//            p.setCodigo(cn.getCol("codigo"));
//            p.setNombre(cn.getCol("nombre"));
//            p.setNombre_categoria(cn.getCol("nombre_categoria"));
//            p.setPresentacion(cn.getCol("presentacion"));
//            p.setMarca(cn.getCol("marca"));
//            p.setModelo(cx.getCol("modelo"));
//            p.setNombre_unidad_medida(cx.getCol("nombre_unidad_medida"));
//            p.setPrecio_compra(cx.getCol("precio_compra"));
//            p.setEstado(cx.getCol("estado"));
//            lista.add(p);
//        }
//        return lista;
//    
    
//    }
//    

    @Override
    public List<Productos> repor_producto(String buscar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
    
    
}
