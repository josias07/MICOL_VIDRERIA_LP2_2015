///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package DaoImpl;
//
//import Beans.Cliente;
//import Dao.ClienteDao;
//import java.sql.Statement;
//import java.util.List;
//
///**
// *
// * @author GISS
// */
//public class ClienteDaoImpl implements ClienteDao{
//
//    @Override
//    public boolean registrarCliente(Cliente cliente) {
//        boolean flat=false;
//        Statement st =null;
////        String query="INSERT INTO cliente (idcliente, idpersona, estado);
//        try {
//            st=cn.conexion().createStatement();
//            
//            cn.conexion().getAutoCommit();
//            cn.conexion().close();
//            flat=true;
//             } catch (Exception e) {
//                 System.out.println("ERROR:"+e.getMessage());
//                 try {
//                     cn.conexion().rollback();
//                     cn.conexion().close();
//            } catch (Exception ex) {
//            }
//        }finally{
//            if (cn.conexion() !=null) 
//                try {
//                   cn.conexion().rollback();
//                    cn.conexion().close();
//                } catch (Exception e) {
//                }
//
//                }
//                 return flat;
//    }
//    @Override
//    public List<Cliente> listarCliente() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public boolean eliminarCliente(int id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public boolean actualizarCliente(Cliente cliente) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    
//    
//}
