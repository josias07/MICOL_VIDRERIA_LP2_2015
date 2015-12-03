

package DaoImpl;
import Dao.UsuarioDao;
import Beans.Usuario;
import conexion.Conexion;
import conexion.Configuracion;
import conexion.conexionMYSQL2;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoImpl implements UsuarioDao{

conexionMYSQL2 ms = new conexionMYSQL2();
Conexion cn = Configuracion.Vidreria();
//    Conexion cn = Conexion.getInstance();
    @Override
    public boolean agregarUsuario(Usuario usuario) {
        String query="INSERT INTO usuario VALUES ('"+usuario.getId_usuario()+"','"+usuario.getUsuario()+"','"+usuario.getContraseña()+"','"+usuario.getRol()+"','"+usuario.getEstado()+"')";

        System.out.println(query);
        try {
            cn.execC(query);
            cn.Commit();

            return true;
        } catch (Exception EX) {
            cn.RollBack();

            return false;
        }
    }

    @Override
    public boolean eliminarUsuario(String id_usuario) {
    
    boolean flat=false;
         
       String query="DELETE FROM usuario WHERE id_usuario="+id_usuario+"";
        try {
            cn.execC(query);
            cn.Commit();
            return true;
        } catch (Exception EX) {
            cn.RollBack();
            return false;
        }
    }

    @Override
    public boolean actualizarUsuario(Usuario usuario) {
    
      boolean flat=false;
      String query="UPDATE usuario SET usuario='"+usuario.getUsuario()+"',"
              + "                      contraseña='"+usuario.getContraseña()+"',"
              + "                      rol='"+usuario.getRol()+"',"
              + "                      estado='"+usuario.getEstado()+"' "
              + "                             WHERE id_usuario ="+usuario.getId_usuario()+"";

        try {
            cn.execC(query);
            cn.Commit();

            return true;
        } catch (Exception EX) {
            cn.RollBack();

            return false;
        }
    }

    @Override
    public List<Usuario> listarUsuario() {
    
      List<Usuario> lista=null;
        Statement st=null;
        ResultSet rs=null;
        Usuario usuario=null;
        String query="select * from usuario";
        System.out.println(query);
        lista = new ArrayList<Usuario>();
        cn.execQuery(query);
        while (cn.getNext()) {
                usuario =new Usuario();
                 usuario.setId_usuario(cn.getCol("id_usuario"));
                 usuario.setUsuario(cn.getCol("usuario"));
                 usuario.setContraseña(cn.getCol("contraseña"));
                 usuario.setRol(cn.getCol("rol"));
                 usuario.setEstado(cn.getCol("estado"));
                 lista.add(usuario);

     }
        return lista;
  }

    @Override
    public Usuario validarUsuario(String usuario, String contraseña) {
        conexionMYSQL2 ms = new conexionMYSQL2();
     Usuario u = null;
     String query = "select  * from usuario where usuario='"+usuario+"' and contraseña= '"+contraseña+"'";
     Statement st;
     ResultSet rs;
        try {
            st= ms.conexion().createStatement();
            rs=st.executeQuery(query);
            u = new Usuario();
            while (rs.next()) {
                u.setId_usuario(rs.getString("id_usuario"));
                u.setUsuario(rs.getString("usuario"));
                u.setContraseña(rs.getString("contraseña"));
                u.setRol(rs.getString("rol"));
                u.setEstado(rs.getString("estado"));
            }
            ms.cerrar();
        } catch (Exception e) {
            System.out.println("ERRROR: "+e.getMessage());
            ms.cerrar();
        } finally{
            if (ms.conexion() != null) {
                ms.cerrar();
            }
        }
    
    return u;
    }    
}

