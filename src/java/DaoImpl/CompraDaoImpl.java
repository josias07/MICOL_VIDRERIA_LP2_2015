/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImpl;

import Beans.Compra;
import Dao.CompraDao;
import coneccion_mysql.Coneccion_mysql;
import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author josue
 */
public class CompraDaoImpl implements CompraDao{
    
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
    public boolean agregarCompra(Compra compra) {
       boolean flat=false;
        Statement st=null;
        String query="INSERT INTO compra VALUES (0,'"+compra.getFecha()+"','"+compra.getSerie_factura()+"','"+compra.getIgv()+"','"+compra.getDescuento()+"','"+compra.getId_proveedor()+"')";
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
    
}
