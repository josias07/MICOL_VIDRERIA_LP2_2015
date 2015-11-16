
package DaoImpl;

import Beans.Proveedor;
import Dao.ProveedorDao;
import conexion.conexionMYSQL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDaoImpl implements ProveedorDao{
    
conexionMYSQL cn = new conexionMYSQL();
    @Override
    public boolean agregarProveedor(Proveedor proveedor) {
      boolean flat=false;
        Statement st=null;
        String query="INSERT INTO persona VALUES (0,'"+proveedor.getNombre()+"','"+proveedor.getRuc()+"','"+proveedor.getTelefono()+"','"+proveedor.getRazon_social()+"','"+proveedor.getDireccion()+"')";
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
{
                
            }
                }
                 return flat;
    
    }

    @Override
    public List<Proveedor> listarProveedor() {
    List<Proveedor> lista=null;
        Statement st=null;
        ResultSet rs=null;
        Proveedor proveedor=null;
        String query="select * from proveedor";
        try {
            lista = new ArrayList<>();
            st= cn.conexion().createStatement();
            rs=st.executeQuery(query);
            while (rs.next()) {
                
                proveedor =new Proveedor();
                 proveedor.setId_proveedor(rs.getInt("id_proveedor"));
                 proveedor.setNombre(rs.getString("nombre"));
                 proveedor.setRuc(rs.getInt("ruc"));
                 proveedor.setTelefono(rs.getInt("telefono"));
                 proveedor.setRazon_social(rs.getString("razon_social"));
                 proveedor.setDireccion(rs.getString("direccion"));
                 lista.add(proveedor);
            }
            cn.cerrar();
        } catch (Exception e) {
            System.out.println("ERROR:"+e.getMessage());
            e.printStackTrace();
           cn.cerrar();
        }
        return lista;
    
    }
   

}
