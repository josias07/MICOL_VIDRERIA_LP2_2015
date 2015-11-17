
package DaoImpl;
import Dao.UsuarioDao;
import Beans.Usuario;
import Conexion.Conexion;
import conexion.conexionMYSQL2;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoImpl implements UsuarioDao{

//conexionMYSQL2 cn = new conexionMYSQL2();
    
    Conexion cn = Conexion.getInstance();
    @Override
    public boolean agregarUsuario(Usuario usuario) {
    boolean flat=false;
        Statement st=null;
        String query="INSERT INTO usuario VALUES (0,'"+usuario.getUsuario()+"','"+usuario.getContraseña()+"','"+usuario.getRol()+"','"+usuario.getEstado()+"')";
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
{
                
            }
                }
                 return flat;
    }

    @Override
    public boolean eliminarUsuario(int id_usuario) {
    
    boolean flat=false;
         
       String query="DELETE FROM usuario WHERE id_usuario="+id_usuario+"";
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
    public boolean actualizarUsuario(Usuario usuario) {
    
      boolean flat=false;
      String query="UPDATE usuario SET usuario='"+usuario.getUsuario()+"',"
              + "                      contraseña='"+usuario.getContraseña()+"',"
              + "                      rol='"+usuario.getRol()+"',"
              + "                      estado='"+usuario.getEstado()+"' "
              + "                             WHERE id_usuario ="+usuario.getId_usuario()+"";
        
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
    public List<Usuario> listarUsuario() {
    
      List<Usuario> lista=null;
        Statement st=null;
        ResultSet rs=null;
        Usuario usuario=null;
        String query="select * from usuario";
        try {
            lista = new ArrayList<>();
            st= cn.conexion().createStatement();
            rs=st.executeQuery(query);
            while (rs.next()) {
                
                usuario =new Usuario();
                 usuario.setId_usuario(rs.getInt("id_usuario"));
                 usuario.setUsuario(rs.getString("usuario"));
                 usuario.setContraseña(rs.getString("contraseña"));
                 usuario.setRol(rs.getString("rol"));
                 usuario.setEstado(rs.getString("estado"));
                 lista.add(usuario);
            }
//            cn.cerrar();
        } catch (Exception e) {
            System.out.println("ERROR:"+e.getMessage());
            e.printStackTrace();
//           cn.cerrar();
        }
        return lista;
    }

    @Override
    public Usuario validarUsuario(String usuario, String contraseña) {
     Usuario u = null;
     String query = "select  * from usuario where usuario='"+usuario+"' and contraseña= '"+contraseña+"'";
     Statement st;
     ResultSet rs;
        try {
            st= cn.conexion().createStatement();
            rs=st.executeQuery(query);
            u = new Usuario();
            while (rs.next()) {
                u.setId_usuario(rs.getInt("id_usuario"));
                u.setUsuario(rs.getString("usuario"));
                u.setContraseña(rs.getString("contraseña"));
                u.setRol(rs.getString("rol"));
                u.setEstado(rs.getString("estado"));
            }
//            cn.cerrar();
        } catch (Exception e) {
            System.out.println("ERRROR: "+e.getMessage());
//            cn.cerrar();
        } finally{
            if (cn.conexion() != null) {
//                cn.cerrar();
            }
        }
    
    return u;
    }
    
}
