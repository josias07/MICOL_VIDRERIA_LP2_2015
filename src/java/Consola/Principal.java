
package Consola;

import Beans.Categoria_Producto;
import Beans.Cliente;
import Beans.Compra;
import Beans.Detalle_venta;
import Dao.PersonaDao;
import Dao.UsuarioDao;
import DaoImpl.PersonaDaoImpl;
import DaoImpl.UsuarioDaoImpl;

import Beans.Persona;
import Beans.Productos;
import Beans.Unidad_medida;
import Beans.Usuario;
import Beans.Venta;
import Dao.Categoria_ProductoDao;
import Dao.ClienteDao;
import Dao.CompraDao;
import Dao.ProductosDao;
import Dao.Unidad_medidaDao;
import Dao.VentaDao;
import DaoImpl.Categoria_ProductoDaoImpl;
import DaoImpl.ClienteDaoImpl;
import DaoImpl.CompraDaoImpl;
import DaoImpl.ProductosDaoImpl;
import DaoImpl.Unidad_medidaDaoImpl;
import DaoImpl.VentaDaoImpl;

public class Principal {

   
    public static void main(String[] args) {
     
        Principal p=new Principal();
        //***********PERSONA*********//
//        p.agregarPersona();
//        p.eliminarPersona();
//        p.actualizarPersona();
//        p.litarPersona();
//         p.agregarProducto();
//        p.fechaCompra();
 //       p.actualizarProducto();
//        p.listarProductos();
//        p.listar_categoria_Producto();
        //***********USUARIO*************//
//        p.agregarUsuario();
//        p.eliminarUsuario();
//        p.actualizarUsuario();
//        p.listarUsuario();
//          p.validarUsuario();
//        p.agregarCategoria_Producto();
//        p.eliminarCategoria_Producto();
//        p.actualizarCategoria_Producto();
//          p.listarCompra();
         
          //***********cliente********
//          p.agregarCliente();
//          p.AgregarVenta();
//        p.detalleVenta();
//        p.listarVenta();
//        p.litarPersonaaa();
//        p.agregardeta_venta();
//        p.reven();
        p.listarunidad();
    }

    
    //************PERSONA**************//
//    public void agregarPersona(){
//        PersonaDao dao=new PersonaDaoImpl();
//        Persona persona=new Persona();
//        
//            persona.setNombre("josue ");
//            persona.setApepat("Alcantara");
//            persona.setApemat("Garcia");
//            persona.setFecha_nac("1996-10-25");
//            persona.setSexo("M");
//            persona.setDni(71553114);
//            persona.setCelular(949630192);
//            persona.setTelefono(949630192);
//            persona.setDireccion("Av Peru #468");
//            
//            if (dao.agregarpersona(persona)) {
//                System.out.println("Se Agrego Correctamente.");
//            } else {
//                System.out.println("Ocurrio un error al agregar.");
//            }
//        
//    }
    
     public void reven(){
         
         VentaDao dao = new VentaDaoImpl();
         Venta v = new Venta();
         Detalle_venta dt = new Detalle_venta();
         
         v.getId_venta();
         dt.getId_productos();
         dt.getCantidad();
         dt.getPrecio_unitario();
         dt.getId_usuario();
         
         dao.REGISTRAR_VENTA(v, dt);
     }
    
    
        public void agregardeta_venta(){
        VentaDao dao=new VentaDaoImpl();
        Detalle_venta deta_ven=new Detalle_venta();
            deta_ven.setDescripcion("dddd");
            deta_ven.setCantidad("2");
            deta_ven.setPrecio_unitario("10");
            deta_ven.setImporte("100");
            deta_ven.setId_venta("13");
            deta_ven.setId_productos("7");
          
            if (dao.agregardeta_venta(deta_ven)) {
                System.out.println("Se Agrego Correctamente.");
            } else {
                System.out.println("Ocurrio un error al agregar.");
            }
        
    }
//    
//    public void eliminarPersona(){
//        PersonaDao dao=new PersonaDaoImpl();
//        if(dao.eliminarpersona(1)){
//            System.out.println("Elimino Correctamente");
//        }else{
//            System.out.println("Error al eliminar");
//        }
//    }
//    
//    public void actualizarPersona(){
//        PersonaDao dao=new PersonaDaoImpl();
//        Persona persona=new Persona();
//        persona.setId_persona(2);
//        persona.setNombre("Pancho");
//        persona.setApepat("Pizarro");
//        persona.setApemat("Perez");
//        persona.setFecha_nac("2015-12-05");
//        persona.setSexo("F");
//        persona.setDni(45678914);
//        persona.setCelular(94242114);
//        persona.setTelefono(445444465);
//        persona.setDireccion("aaagfafafaf");
//        
//        if (dao.actualizarpersona(persona)) {
//             System.out.println("Se Actualizo Correctamente");
//        } else {
//            System.out.println("Error al Actualizar");
//        }
//    }
//    
//    public void litarPersona(){
//        PersonaDao dao=new PersonaDaoImpl();
//        for (Persona per : dao.listarpersona()) {
//        System.out.println("\n########################################");
//        System.out.println("\nID:"+per.getId_persona()+
//                               "\nNOMBRES:"+per.getNombre()+
//                               "\nAPELLIDOS:"+per.getApepat()+ per.getApemat()+
////                               "\nFECHA_NAC:"+per.getFecha_nac()+
//                               "\nAPELLIDOS:"+per.getSexo()+
//                               "\nDNI:"+per.getDni()+
//                               "\nCELULAR:"+per.getCelular()+
//                               "\nTELEFONO:"+per.getTelefono()+
//                               "\nDIRECCION:"+per.getDireccion());
//                               
//        System.out.println("\n########################################");
//            
//        }
//    }
        
        public void listarunidad(){
            Unidad_medidaDao dao =new Unidad_medidaDaoImpl();
        for (Unidad_medida per : dao.lista_unidad_medidad()) {
        System.out.println("\n########################################");
        System.out.println("\nID:"+per.getAbreviatura()+
                               "\nNOMBRES:"+per.getDescripcion()+
                               "\nDIRECCION:"+per.getNombre_uni());
                               
        System.out.println("\n########################################");
            
        }
    }
    
        public void litarPersonaaa(){
        PersonaDao dao=new PersonaDaoImpl();
        for (Persona per : dao.listarpersona("71553114")) {
        System.out.println("\n########################################");
        System.out.println("\nID:"+per.getId_persona()+
                               "\nNOMBRES:"+per.getNombre()+
                               "\nAPELLIDOS:"+per.getApepat()+ per.getApemat()+
//                               "\nFECHA_NAC:"+per.getFecha_nac()+
                               "\nDNI:"+per.getDni());
                               
        System.out.println("\n########################################");
            
        }
    }
//    
//    
//    //***************USUARIO*****************//
//    
//    public void agregarUsuario(){
//        UsuarioDao dao = new UsuarioDaoImpl();
//        Usuario usuario =  new Usuario();
//            usuario.setId_usuario(2);
//            usuario.setUsuario("jos");
//            usuario.setContraseña("123");
//            usuario.setRol("administrador");
//            usuario.setEstado("1");
//            
//            
//            if (dao.agregarUsuario(usuario)) {
//                System.out.println("Se Agrego Correctamente.");
//            } else {
//                System.out.println("Ocurrio un error al agregar.");
//            }
//        
//    }
//    
//    public void eliminarUsuario(){
//         UsuarioDao dao = new UsuarioDaoImpl();
//        if(dao.eliminarUsuario(2)){
//            System.out.println("Elimino Correctamente");
//        }else{
//            System.out.println("Error al eliminar");
//        }
//    }
//    
//    public void actualizarUsuario(){
//        UsuarioDao dao = new UsuarioDaoImpl();
//        Usuario usuario =  new Usuario();
//        usuario.setId_usuario(2);
//        usuario.setUsuario("alcantara");
//        usuario.setContraseña("123");
//        usuario.setRol("administrador");
//        usuario.setEstado("1");
//        
//        if (dao.actualizarUsuario(usuario)) {
//             System.out.println("Se Actualizo Correctamente");
//        } else {
//            System.out.println("Error al Actualizar");
//        }
//    }
//    
//    public void listarUsuario(){
//        UsuarioDao dao = new UsuarioDaoImpl();
//        for (Usuario usuario : dao.listarUsuario()) {
//        System.out.println("\n------------------------");
//        System.out.println("\n Id:"+usuario.getId_usuario()+
//                               "\n nombre:"+usuario.getUsuario()+
//                               "\n contraseña:"+usuario.getContraseña()+
//                               "\n rol:"+usuario.getRol()+
//                               "\n estado:"+usuario.getEstado());
//        System.out.println("------------------------");
//            
//        }
//    }
//    
//    
//    public void validarUsuario(){
//         UsuarioDao dao = new UsuarioDaoImpl();
//        Usuario usuario =  new Usuario();
//        usuario = dao.validarUsuario("josias", "123");
//        
//        System.out.println("Usuario: "+usuario.getUsuario());
//        
//    }
////    CATEGORIA_PRODUCTO
//    
//    public void agregarCategoria_Producto(){
//        Categoria_ProductoDao dao=new Categoria_ProductoDaoImpl();
//        Categoria_Producto catprod=new Categoria_Producto(); 
//            
//        catprod.setNombre_categoria("Ventanas");
//            
//        if (dao.agregarCategoria_Producto(catprod)) {
//            System.out.println("Se Agrego Correctamente.");
//            } else {
//            System.out.println("Ocurrio un error al agregar.");
//            }
//        
//    }
//    
//    public void eliminarCategoria_Producto(){
//        Categoria_ProductoDao dao=new Categoria_ProductoDaoImpl();
//        if(dao.eliminarCategoria_Producto(4)){
//            System.out.println("Elimino Correctamente");
//        }else{
//            System.out.println("Error al eliminar");
//        }
//    }
//    
//    public void actualizarCategoria_Producto(){
//    Categoria_ProductoDao dao=new Categoria_ProductoDaoImpl();
//    Categoria_Producto catprod=new Categoria_Producto();
//    catprod.setId_categoria_producto(1);
//    catprod.setNombre_categoria("Puertas");
//        if (dao.actualizarCategoria_Producto(catprod)) {
//             System.out.println("Se Actualizo Correctamente");
//        } else {
//            System.out.println("Error al Actualizar");
//        }
//    }
//    
//    
//    public void listar_categoria_Producto(){
//    Categoria_ProductoDao dao=new Categoria_ProductoDaoImpl();
//    for (Categoria_Producto categoria:dao.listaCategoria()) {
//        System.out.println("\n########################################");
//        System.out.println("\nID:"+categoria.getId_categoria_producto()+
//                               "\nNOMBRE:"+categoria.getNombre_categoria());
//                               
//        System.out.println("\n########################################");  
//        }
//
//    }
//    
////    PRODUCTOS
//    
//    public void agregarProducto(){
//        ProductosDao dao=new ProductosDaoImpl();
//        Productos prod=new Productos(); 
//        prod.setNombre("George");
//        prod.setCantidad("40");
//        prod.setPrecio("100");
//        prod.setDescripcion("gdhdhfhjf");
//        prod.setId_categoria_prod("4");
//        prod.setId_unidad_medida("1");
//            
//        if (dao.agregarproducto(prod)) {
//            System.out.println("Se Agrego Correctamente.");
//        } else {
//            System.out.println("Ocurrio un error al agregar.");
//            }
//        
//    }
//    
//    public void eliminarProducto(){
//    ProductosDao dao=new ProductosDaoImpl();
//    if(dao.eliminarproducto("26")){
//        System.out.println("Elimino Correctamente");
//        }else{
//        System.out.println("Error al eliminar");
//        }
//    }
//    
//    public void actualizarProducto(){
//    ProductosDao dao=new ProductosDaoImpl();
//    Productos prod=new Productos();
//    prod.setId_productos("26");
//    prod.setNombre("Ventana");
//    prod.setId_categoria_prod("5");
//    prod.setCantidad("20");
//    prod.setPrecio("211");
//    prod.setDescripcion("dfgsdfhhjb");
//    prod.setId_unidad_medida("1");
//        if (dao.actualizarproducto(prod)) {
//             System.out.println("Se Actualizo Correctamente");
//        } else {
//            System.out.println("Error al Actualizar");
//        }
//    }
//    
//    public void listarProductos(){
//    ProductosDao dao=new ProductosDaoImpl();
//    for (Productos prod : dao.listarproductos(null, null)) {
//        System.out.println("\n########################################");
//        System.out.println("\nID:"+prod.getId_productos()+
//                               "\nNOMBRE:"+prod.getNombre()+
//                               "\nCATEGORIA_PRODUCTO:"+prod.getNombre_categoria()+
//                               "\nCANTIDAD:"+prod.getCantidad()+
//                               "\nPRECIO:"+prod.getPrecio()+
//                               "\nDESCRIPCION:"+prod.getDescripcion()+
//                               "\nUNIDAD_MEDIDDA:"+prod.getNombre_medida());
//                               
//        System.out.println("\n########################################");  
//        }
//
//    }
//    
////    COMPRA
//    public void agregarCompra(){
//    CompraDao dao=new CompraDaoImpl();
//    Compra compra=new Compra();
//    compra.setFecha("01/11/15");
//    compra.setComprobante(null);
//    compra.setIgv(41.00);
//    compra.setDescuento(17.00);
//    compra.setId_proveedor(1);
//        
//            
//        if (dao.agregarCompra(compra)) {
//            System.out.println("Se Agrego Correctamente.");
//        } else {
//            System.out.println("Ocurrio un error al agregar.");
//            }
//        
//    }
//    
//    public void eliminarCompra(){
//    CompraDao dao=new CompraDaoImpl();
//    if(dao.eliminarcompra(1)){
//        System.out.println("Elimino Correctamente");
//        }else{
//        System.out.println("Error al eliminar");
//        }
//    }
//    
//    public void actualizarCompra(){
//    CompraDao dao=new CompraDaoImpl();
//    Compra compra=new Compra();
//    compra.setFecha("01/11/15");
//    compra.setComprobante(null);
//    compra.setIgv(41.00);
//    compra.setDescuento(17.00);
//    compra.setId_proveedor(1);
//        if (dao.actualizarcompra(compra)) {
//             System.out.println("Se Actualizo Correctamente");
//        } else {
//            System.out.println("Error al Actualizar");
//        }
//    }
//    
//    public void listarCompra(){
//    CompraDao dao=new CompraDaoImpl();
//    for (Compra compra: dao.listarcompra()) {
//        System.out.println("\n########################################");
//        System.out.println("\nID:"+compra.getId_compra()+
//                               "\nFECHA:"+compra.getFecha()+
//                               "\nSERIE_FCATURA:"+compra.getComprobante()+
//                               "\nIGV:"+compra.getIgv()+
//                               "\nDESCUENTO:"+compra.getDescuento()+
//                               "\nPROVEEDOR:"+compra.getId_proveedor());
//                               
//        System.out.println("\n########################################");  
//        }
//
//    } 
//    
//    public void fechaCompra(){
//    CompraDao dao=new CompraDaoImpl();
//    for (Compra compra: dao.fechacompra("2015-11-20", "2015-02-01")) {
//        System.out.println("\n########################################");
//        System.out.println("\nID:"+compra.getId_compra()+
//                               "\nFECHA:"+compra.getFecha()+
//                               "\nSERIE_FCATURA:"+compra.getComprobante()+
//                               "\nPROVEEDOR:"+compra.getNombre_proveedor());
//                               
//        System.out.println("\n########################################");  
//        }
//
//    }
//    
    public void AgregarVenta(){
        VentaDao dao=new VentaDaoImpl();
        Venta venta= new Venta();
    venta.setFecha_venta("2015/10/20");
    venta.setComprobante("factura");
    venta.setSerie("12345");
    venta.setIgv("12");
    venta.setDescuento("1");
    venta.setId_cliente("2");
    venta.setId_usuario("1");
                
        if (dao.agregarventa(venta)) {
            System.out.println("Se Agrego Correctamente.");
        } else {
            System.out.println("Ocurrio un error al agregar.");
            }
    }
    
        public void detalleVenta(){
      VentaDao dao=new VentaDaoImpl();
      Detalle_venta deta_venta=new Detalle_venta();
    deta_venta.setDescripcion("dddddd");
    deta_venta.setCantidad("15");
    deta_venta.setPrecio_unitario("20");
    deta_venta.setImporte("100");
    deta_venta.setId_venta("10");
    deta_venta.setId_productos("7");
                
        if (dao.agregar_detalleventa(deta_venta)) {
            System.out.println("Se Agrego Correctamente.");
        } else {
            System.out.println("Ocurrio un error al agregar.");
            }
    }
//    
        public void listarVenta(){
    VentaDao dao=new VentaDaoImpl();
    for (Venta venta: dao.terminaventa() ) {
        System.out.println("\n########################################");
        System.out.println("\nID:"+venta.getId_detalle_venta()+
                            ("\nID:"+venta.getId_venta())+
                               "\nFECHA:"+venta.getSerie()+
                               "\nSERIE_FCATURA:"+venta.getNombre_cliente()+
                               "\nSUBTOTAL:"+venta.getNombre_producto()+
                               "\nIGV:"+venta.getCantidad()+
                               "\nDESCUENTO:"+venta.getPrecio()+
                               "\nTOTAL:"+venta.getDescuento()+
                               "\nPROVEEDOR:"+venta.getIgv()+
                               "\nPRODUCTO:"+venta.getComprobante()+
                               "\nHORA:"+venta.getTotal());
                               
        System.out.println("\n########################################");  
        }

    }
//      
////*********************cliente**************
        
        public void agregarCliente(){
            ClienteDao dao= new ClienteDaoImpl();
            Cliente cliente =new Cliente();
             cliente.setId_persona("1");
            cliente.setEstado("1");
            
            if(dao.agregarCliente(cliente)){
                System.out.println("se registro correctamente");
            }else{
                System.out.println("ocurrio un error al registarse");
            }
        }
//        
//        public void actualizarCliente(){
//            ClienteDao dao = new ClienteDaoImpl();
//            Cliente cliente =new Cliente();
//            
//         
//            }
//        
        }


