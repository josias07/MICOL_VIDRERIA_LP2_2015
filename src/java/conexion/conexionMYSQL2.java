
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;


public class conexionMYSQL2 {
    
    public static Connection getConection(){
        Connection cn=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/vidreria","root","dba123456");
                    
        } catch (Exception e) {
            System.out.println("ERROR: "+e.getMessage());
        }
        return cn;
    }
    
   public Connection conexion (){
    Connection cn=conexionMYSQL2.getConection();
    return cn;
   }
   public void cerrar(){
       try {
           conexionMYSQL2.getConection().close();
       } catch (Exception e) {
       }
   
   }
   public void  restaurar(){
       try {
           conexionMYSQL2.getConection().rollback();
       } catch (Exception e) {
       }
   }
   public void guardar(){
       try {
           conexionMYSQL2.getConection().commit();
       } catch (Exception e) {
       }
  }
}
