
package DaoImpl;

import Dao.PersonaDao;
import Beans.Persona;
import Conexion.Conexion;
import conexion.conexionMYSQL2;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonaDaoImpl implements PersonaDao{
   
//conexionMYSQL2 cn = new conexionMYSQL2();

    Conexion cn = Conexion.getInstance();
    @Override
    public boolean agregarpersona(Persona persona) {
         boolean flat=false;
        Statement st=null;
        String query="INSERT INTO persona VALUES (0,'"+persona.getNombre()+"','"+persona.getApepat()+"','"+persona.getApemat()+"','"+persona.getFecha_nac()+"','"+persona.getSexo()+"','"+persona.getDni()+"','"+persona.getCelular()+"','"+persona.getTelefono()+"','"+persona.getDireccion()+"')";
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
    public boolean eliminarpersona(int id_persona) {
        boolean flat=false;
         
       String query="DELETE FROM persona WHERE id_persona="+id_persona+"";
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
    public boolean actualizarpersona(Persona persona) {
               boolean flat=false;
      String query="UPDATE persona SET nombre='"+persona.getNombre()+"',apepat='"+persona.getApepat()+"',apemat='"+persona.getApemat()+"',fecha_nac='"+persona.getFecha_nac()+"',sexo='"+persona.getSexo()+"',dni="+persona.getDni()+",celular='"+persona.getCelular()+"',telefono='"+persona.getTelefono()+"',direccion ='"+persona.getDireccion()+"' WHERE id_persona ="+persona.getId_persona()+"";
        
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
    public List<Persona> listarpersona() {
        List<Persona> lista=null;
        Statement st=null;
        ResultSet rs=null;
        Persona per=null;
        String query="select * from persona";
        try {
            lista = new ArrayList<>();
            st= cn.conexion().createStatement();
            rs=st.executeQuery(query);
            while (rs.next()) {
                
                per =new Persona();
                per.setId_persona(rs.getInt("id_persona"));
                per.setNombre(rs.getString("nombre"));
                per.setApepat(rs.getString("apepat"));
                per.setApemat(rs.getNString("apemat"));
//                per.setFecha_nac(rs.getNString("yyyy-mm-dd"));
                per.setSexo(rs.getNString("sexo"));
                per.setDni(rs.getInt("dni"));
                per.setCelular(rs.getInt("celular"));
                per.setTelefono(rs.getInt("telefono"));
                per.setDireccion(rs.getString("direccion"));
                lista.add(per);
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
