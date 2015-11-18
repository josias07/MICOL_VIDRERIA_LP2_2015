
package DaoImpl;

import Beans.Cliente;
import conexion.Conexion;
import Dao.ClienteDao;
import java.sql.Statement;




/**
 *
 * @author GISS
 */
public class ClienteDaoImpl implements ClienteDao{
    
    Conexion cn = Conexion.getInstance();

    @Override
    public boolean agregarCliente(Cliente cliente) {
        boolean flat=false;
        Statement st =null;
        String query="INSERT INTO `vidreria`.`cliente` (`id_cliente`, `id_persona`, `estado`) VALUES ('002', '2', '0');";
        try {
            st=cn.conexion().createStatement();
            
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
    public boolean actualizarCliente(Cliente cliente) {
        boolean flat =false;
        
        String query="UPDATE cliente SET id_ciente='"+cliente.getId_cliente()+
                     "',id_persona='"+cliente.getId_persona()+"',estado='"+cliente.getEstado();
        
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

    
