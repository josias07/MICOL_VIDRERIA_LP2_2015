
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;


public class conexionMYSQL {
    
    public static Connection getConection(){
        Connection cn=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/vidreria_clases","root","dba123456");
                    
        } catch (Exception e) {
            System.out.println("ERROR: "+e.getMessage());
        }
        return cn;
    }
    
   public Connection conexion (){
    Connection cn=conexionMYSQL.getConection();
    return cn;
   }
   public void cerrar(){
       try {
           conexionMYSQL.getConection().close();
       } catch (Exception e) {
       }
   
   }
   public void  restaurar(){
       try {
           conexionMYSQL.getConection().rollback();
       } catch (Exception e) {
       }
   }
   public void guardar(){
       try {
           conexionMYSQL.getConection().commit();
       } catch (Exception e) {
       }
  }
}
