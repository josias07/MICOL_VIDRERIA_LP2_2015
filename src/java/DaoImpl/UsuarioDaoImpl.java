/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImpl;

import Dao.UsuarioDao;
import Beans.Usuario;
import coneccion_mysql.Coneccion_mysql;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josue
 */
public class UsuarioDaoImpl implements UsuarioDao{

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
    public boolean agregarUsuario(Usuario usuario) {
    boolean flat=false;
        Statement st=null;
        String query="INSERT INTO usuario VALUES (0,'"+usuario.getUsuario()+"','"+usuario.getContraseña()+"','"+usuario.getRol()+"','"+usuario.getEstado()+"')";
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
    public boolean eliminarUsuario(int id_usuario) {
    
    boolean flat=false;
         
       String query="DELETE FROM usuario WHERE id_usuario="+id_usuario+"";
       Statement st=null;
        try {
            st=conexion().createStatement();
            st.executeUpdate(query);
            guardar();
            cerrar();
            flat=true;
        } catch (Exception e) {
            restaurar();
            cerrar();
            System.out.println("ERROR"+e.getMessage());
        }finally{
            if (conexion()!=null) {
                
             
            cerrar();
                
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
            st=conexion().createStatement();
            st.executeUpdate(query);
            guardar();
            cerrar();
            flat=true;
        } catch (Exception e) {
            restaurar();
            cerrar();
            System.out.println("ERROR"+e.getMessage());
        }finally{
            if (conexion()!=null) {
                cerrar();
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
            st= conexion().createStatement();
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
            cerrar();
        } catch (Exception e) {
            System.out.println("ERROR:"+e.getMessage());
            e.printStackTrace();
           cerrar();
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
            st= conexion().createStatement();
            rs=st.executeQuery(query);
            u = new Usuario();
            while (rs.next()) {
                u.setId_usuario(rs.getInt("id_usuario"));
                u.setUsuario(rs.getString("usuario"));
                u.setContraseña(rs.getString("contraseña"));
                u.setRol(rs.getString("rol"));
                u.setEstado(rs.getString("estado"));
            }
            cerrar();
        } catch (Exception e) {
            System.out.println("ERRROR: "+e.getMessage());
            cerrar();
        } finally{
            if (conexion() != null) {
                cerrar();
            }
        }
    
    return u;
    }
    
}
