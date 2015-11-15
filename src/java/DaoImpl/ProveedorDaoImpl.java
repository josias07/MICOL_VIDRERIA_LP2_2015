
package DaoImpl;

import Beans.Proveedor;
import Dao.ProveedorDao;
import coneccion_mysql.Coneccion_mysql;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDaoImpl implements ProveedorDao{
    
       
    public Connection conexion (){
   Connection cn=Coneccion_mysql.conexion();
    return cn;
   }
      public void cerrar(){
       try {
           Coneccion_mysql.conexion().close();
       } catch (Exception e) {
       }
   
   }
   public void  restaurar(){
       try {
           Coneccion_mysql.conexion().rollback();
       } catch (Exception e) {
       }
}
   public void guardar(){
       try {
           Coneccion_mysql.conexion().commit();
       } catch (Exception e) {
       }
}
   
   
   
     
       
    

    @Override
    public boolean agregarProveedor(Proveedor proveedor) {
      boolean flat=false;
        Statement st=null;
        String query="INSERT INTO persona VALUES (0,'"+proveedor.getNombre()+"','"+proveedor.getRuc()+"','"+proveedor.getTelefono()+"','"+proveedor.getRazon_social()+"','"+proveedor.getDireccion()+"')";
        try {
            st=conexion().createStatement();
            st.executeUpdate(query);
            
            conexion().getAutoCommit();
            conexion().close();
            flat=true;
             } catch (Exception e) {
                 System.out.println("ERROR:"+e.getMessage());
                 try {
                     conexion().rollback();
                     conexion().close();
            } catch (Exception ex) {
            }
        }finally{
            if (conexion() !=null) 
                try {
                    conexion().rollback();
                    conexion().close();
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
            st= conexion().createStatement();
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
            cerrar();
        } catch (Exception e) {
            System.out.println("ERROR:"+e.getMessage());
            e.printStackTrace();
           cerrar();
        }
        return lista;
    
    }
   

}
