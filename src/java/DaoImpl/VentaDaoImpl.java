
package DaoImpl;

import Dao.VentaDao;
import Beans.Venta;
import conexion.conexionMYSQL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class VentaDaoImpl implements VentaDao{

conexionMYSQL cn = new conexionMYSQL();
 
    @Override
    public boolean agregarventa(Venta venta) {
    boolean flat=false;
    Statement st=null;
    String query="INSERT INTO venta VALUES (null,'"+venta.getFecha_venta()+"','"+venta.getSerie_factura()+"','"+venta.getSubtotal()+"','"+venta.getIgv()+"','"+venta.getDescuento()+"','"+venta.getTotal()+"','"+venta.getId_usuario()+"','"+venta.getId_cliente()+"','"+venta.getHora()+"')";
        try {
            st=cn.conexion().createStatement();
            st.executeUpdate(query);
            
            cn.conexion().getAutoCommit();
            cn.conexion().close();
            flat=true;
             } catch (Exception e) {
                 System.out.println("ERROR:"+e.getMessage());
                 try {
                     cn.conexion().rollback();
                     cn.conexion().close();
            } catch (Exception ex) {
            }
        }finally{
            if (cn.conexion() !=null) 
                try {
                    cn.conexion().rollback();
                    cn.conexion().close();
                } catch (Exception e) {
                }

                }
                 return flat;      
    }    

    @Override
    public boolean eliminarventa(int id_venta) {
    boolean flat=false;
    String query="DELETE FROM venta WHERE id_venta="+id_venta+"";
    Statement st=null;
        try {
            st=cn.conexion().createStatement();
            st.executeUpdate(query);
            cn.guardar();
            cn.cerrar();
            flat=true;
        } catch (Exception e) {
            cn.restaurar();
            cn.cerrar();
            System.out.println("ERROR"+e.getMessage());
        }finally{
            if (cn.conexion()!=null) {
              
            cn.cerrar();
               
            }
        } 
       
    return  flat;     
    }

    @Override
    public boolean actualizarventa(Venta venta) {
    boolean flat=false;
    String query="UPDATE venta SET fecha_venta='"+venta.getFecha_venta()+"',serie_factura='"+venta.getSerie_factura()+"',subtotal='"+venta.getSubtotal()+"',igv='"+venta.getIgv()+"',descuento='"+venta.getDescuento()+"',total='"+venta.getTotal()+"',id_proveedor='"+venta.getId_usuario()+"',id_productos='"+venta.getId_cliente()+"',hora='"+venta.getHora()+"' WHERE id_venta ="+venta.getId_venta()+"";
        
        Statement st=null;
        try {
            st=cn.conexion().createStatement();
            st.executeUpdate(query);
            cn.guardar();
            cn.cerrar();
            flat=true;
        } catch (Exception e) {
            cn.restaurar();
            cn.cerrar();
            System.out.println("ERROR"+e.getMessage());
        }finally{
            if (cn.conexion()!=null) {
                cn.cerrar();
            }
        }
        
         return flat;    
    }
    @Override
    public List<Venta> listarventa() {
    List<Venta> lista=null;
    Statement st=null;
    ResultSet rs=null;
    Venta venta=null;
        String query="select * from venta";
        try {
            lista = new ArrayList<>();
            st= cn.conexion().createStatement();
            rs=st.executeQuery(query);
            while (rs.next()) {
                
            venta = new Venta();
            venta.setId_venta(rs.getInt("id_venta"));
            venta.setFecha_venta(rs.getString("fecha_venta"));
            venta.setSubtotal(rs.getDouble("subtotal"));
            venta.setSerie_factura(rs.getNString("serie_factura"));
            venta.setIgv(rs.getDouble("igv"));
            venta.setDescuento(rs.getDouble("descuento"));
            venta.setTotal(rs.getDouble("total"));
            venta.setId_cliente(rs.getInt("id_cliente"));
            venta.setId_usuario(rs.getInt("id_usuario"));
            venta.setHora(rs.getNString("hora"));
            lista.add(venta);
            }
            cn.cerrar();
        } catch (Exception e) {
            System.out.println("ERROR:"+e.getMessage());
            e.printStackTrace();
           cn.cerrar();
        }
        return lista;
    } }
