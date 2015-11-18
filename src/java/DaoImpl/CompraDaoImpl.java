
package DaoImpl;
import Beans.Compra;
import Conexion.Conexion;
import Dao.CompraDao;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CompraDaoImpl implements CompraDao{
    
//conexionMYSQL2 cn = new conexionMYSQL2();
    Conexion cn = Conexion.getInstance();
    @Override
    public boolean agregarCompra(Compra compra) {
       boolean flat=false;
        Statement st=null;
        String query="INSERT INTO compra VALUES (0,'"+compra.getFecha()+"','"+compra.getSerie_factura()+
                     "','"+compra.getIgv()+"','"+compra.getDescuento()+"','"+compra.getId_proveedor()+"')";
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
    public boolean eliminarcompra(int id_compra) {
    boolean flat=false;
    String query="DELETE FROM compra WHERE id_compra="+id_compra+"";
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
    public boolean actualizarcompra(Compra compra) {
    boolean flat=false;
    String query="UPDATE compra SET fecha='"+compra.getFecha()+"',serie_factura='"+compra.getSerie_factura()+"',igv='"+compra.getIgv()+"',descuento='"+compra.getDescuento()+"',id_proveedor='"+compra.getId_proveedor()+"' WHERE id_productos ="+compra.getId_compra()+"";
        
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
    public List<Compra> listarcompra() {
    List<Compra> lista=null;
    Statement st=null;
    ResultSet rs=null;
    Compra compra=null;
        String query="select * from compra";
        try {
            lista = new ArrayList<>();
            st= cn.conexion().createStatement();
            rs=st.executeQuery(query);
            while (rs.next()) {
                
            compra = new Compra();
            compra.setId_compra(rs.getInt("id_compra"));
            compra.setFecha(rs.getString("fecha"));
            compra.setSerie_factura(rs.getNString("serie_factura"));
            compra.setIgv(rs.getDouble("igv"));
            compra.setDescuento(rs.getDouble("descuento"));
            compra.setId_proveedor(rs.getInt("id_proveedor"));
            lista.add(compra);
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
