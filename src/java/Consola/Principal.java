
package Consola;

import Beans.Categoria_Producto;
import Beans.Compra;
import Dao.PersonaDao;
import Dao.UsuarioDao;
import DaoImpl.PersonaDaoImpl;
import DaoImpl.UsuarioDaoImpl;

import Beans.Persona;
import Beans.Productos;
import Beans.Usuario;
import Beans.Venta;
import Dao.Categoria_ProductoDao;
import Dao.CompraDao;
import Dao.ProductosDao;
import Dao.VentaDao;
import DaoImpl.Categoria_ProductoDaoImpl;
import DaoImpl.CompraDaoImpl;
import DaoImpl.ProductosDaoImpl;
import DaoImpl.VentaDaoImpl;

public class Principal {

   
    public static void main(String[] args) {
     
        Principal p=new Principal();
        //***********PERSONA*********//
//        p.agregarPersona();
//        p.eliminarPersona();
//        p.actualizarPersona();
//        p.litarPersona();
        
        
        //***********USUARIO*************//
//        p.agregarUsuario();
//        p.eliminarUsuario();
//        p.actualizarUsuario();
//        p.listarUsuario();
          p.validarUsuario();
//        p.agregarCategoria_Producto();
//        p.eliminarCategoria_Producto();
//        p.actualizarCategoria_Producto();
//          p.listarCompra();
         
    }
    
    
    
    
    
    //************PERSONA**************//
    public void agregarPersona(){
        PersonaDao dao=new PersonaDaoImpl();
        Persona persona=new Persona();
        
            persona.setNombre("josue ");
            persona.setApepat("Alcantara");
            persona.setApemat("Garcia");
            persona.setFecha_nac("1996-10-25");
            persona.setSexo("M");
            persona.setDni(71553114);
            persona.setCelular(949630192);
            persona.setTelefono(949630192);
            persona.setDireccion("Av Peru #468");
            
            if (dao.agregarpersona(persona)) {
                System.out.println("Se Agrego Correctamente.");
            } else {
                System.out.println("Ocurrio un error al agregar.");
            }
        
    }
    
    public void eliminarPersona(){
        PersonaDao dao=new PersonaDaoImpl();
        if(dao.eliminarpersona(1)){
            System.out.println("Elimino Correctamente");
        }else{
            System.out.println("Error al eliminar");
        }
    }
    
    public void actualizarPersona(){
        PersonaDao dao=new PersonaDaoImpl();
        Persona persona=new Persona();
        persona.setId_persona(2);
        persona.setNombre("Pancho");
        persona.setApepat("Pizarro");
        persona.setApemat("Perez");
        persona.setFecha_nac("2015-12-05");
        persona.setSexo("F");
        persona.setDni(45678914);
        persona.setCelular(94242114);
        persona.setTelefono(445444465);
        persona.setDireccion("aaagfafafaf");
        
        if (dao.actualizarpersona(persona)) {
             System.out.println("Se Actualizo Correctamente");
        } else {
            System.out.println("Error al Actualizar");
        }
    }
    
    public void litarPersona(){
        PersonaDao dao=new PersonaDaoImpl();
        for (Persona per : dao.listarpersona()) {
        System.out.println("\n########################################");
        System.out.println("\nID:"+per.getId_persona()+
                               "\nNOMBRES:"+per.getNombre()+
                               "\nAPELLIDOS:"+per.getApepat()+ per.getApemat()+
//                               "\nFECHA_NAC:"+per.getFecha_nac()+
                               "\nAPELLIDOS:"+per.getSexo()+
                               "\nDNI:"+per.getDni()+
                               "\nCELULAR:"+per.getCelular()+
                               "\nTELEFONO:"+per.getTelefono()+
                               "\nDIRECCION:"+per.getDireccion());
                               
        System.out.println("\n########################################");
            
        }
    }
    
    
    //***************USUARIO*****************//
    
    public void agregarUsuario(){
        UsuarioDao dao = new UsuarioDaoImpl();
        Usuario usuario =  new Usuario();
            usuario.setId_usuario(2);
            usuario.setUsuario("jos");
            usuario.setContraseña("123");
            usuario.setRol("administrador");
            usuario.setEstado("1");
            
            
            if (dao.agregarUsuario(usuario)) {
                System.out.println("Se Agrego Correctamente.");
            } else {
                System.out.println("Ocurrio un error al agregar.");
            }
        
    }
    
    public void eliminarUsuario(){
         UsuarioDao dao = new UsuarioDaoImpl();
        if(dao.eliminarUsuario(2)){
            System.out.println("Elimino Correctamente");
        }else{
            System.out.println("Error al eliminar");
        }
    }
    
    public void actualizarUsuario(){
        UsuarioDao dao = new UsuarioDaoImpl();
        Usuario usuario =  new Usuario();
        usuario.setId_usuario(2);
        usuario.setUsuario("alcantara");
        usuario.setContraseña("123");
        usuario.setRol("administrador");
        usuario.setEstado("1");
        
        if (dao.actualizarUsuario(usuario)) {
             System.out.println("Se Actualizo Correctamente");
        } else {
            System.out.println("Error al Actualizar");
        }
    }
    
    public void listarUsuario(){
        UsuarioDao dao = new UsuarioDaoImpl();
        for (Usuario usuario : dao.listarUsuario()) {
        System.out.println("\n------------------------");
        System.out.println("\n Id:"+usuario.getId_usuario()+
                               "\n nombre:"+usuario.getUsuario()+
                               "\n contraseña:"+usuario.getContraseña()+
                               "\n rol:"+usuario.getRol()+
                               "\n estado:"+usuario.getEstado());
        System.out.println("------------------------");
            
        }
    }
    
    
    public void validarUsuario(){
         UsuarioDao dao = new UsuarioDaoImpl();
        Usuario usuario =  new Usuario();
        usuario = dao.validarUsuario("josias", "123");
        
        System.out.println("Usuario: "+usuario.getUsuario());
        
    }
//    CATEGORIA_PRODUCTO
    
    public void agregarCategoria_Producto(){
        Categoria_ProductoDao dao=new Categoria_ProductoDaoImpl();
        Categoria_Producto catprod=new Categoria_Producto(); 
            
        catprod.setNombre_categoria("Ventanas");
            
        if (dao.agregarCategoria_Producto(catprod)) {
            System.out.println("Se Agrego Correctamente.");
            } else {
            System.out.println("Ocurrio un error al agregar.");
            }
        
    }
    
    public void eliminarCategoria_Producto(){
        Categoria_ProductoDao dao=new Categoria_ProductoDaoImpl();
        if(dao.eliminarCategoria_Producto(4)){
            System.out.println("Elimino Correctamente");
        }else{
            System.out.println("Error al eliminar");
        }
    }
    
    public void actualizarCategoria_Producto(){
    Categoria_ProductoDao dao=new Categoria_ProductoDaoImpl();
    Categoria_Producto catprod=new Categoria_Producto();
    catprod.setId_categoria_producto(1);
    catprod.setNombre_categoria("Puertas");
        if (dao.actualizarCategoria_Producto(catprod)) {
             System.out.println("Se Actualizo Correctamente");
        } else {
            System.out.println("Error al Actualizar");
        }
    }
    
//    PRODUCTOS
    
    public void agregarProducto(){
        ProductosDao dao=new ProductosDaoImpl();
        Productos prod=new Productos(); 
        prod.setNombre("Vitrina");
        prod.setId_categoria_prod(3);
        prod.setCantidad(40);
        prod.setPrecio(111.00);
        prod.setDescripcion("gdhdhfhjf");
        prod.setId_unidad_medida(1);
            
        if (dao.agregarproducto(prod)) {
            System.out.println("Se Agrego Correctamente.");
        } else {
            System.out.println("Ocurrio un error al agregar.");
            }
        
    }
    
    public void eliminarProducto(){
    ProductosDao dao=new ProductosDaoImpl();
    if(dao.eliminarproducto(3)){
        System.out.println("Elimino Correctamente");
        }else{
        System.out.println("Error al eliminar");
        }
    }
    
    public void actualizarProducto(){
    ProductosDao dao=new ProductosDaoImpl();
    Productos prod=new Productos();
    prod.setId_productos(2);
    prod.setNombre("Ventana");
    prod.setId_categoria_prod(2);
    prod.setCantidad(50);
    prod.setPrecio(44.00);
    prod.setDescripcion("dfgsdfhhjb");
    prod.setId_unidad_medida(2);
        if (dao.actualizarproducto(prod)) {
             System.out.println("Se Actualizo Correctamente");
        } else {
            System.out.println("Error al Actualizar");
        }
    }
    
    public void listarProductos(){
    ProductosDao dao=new ProductosDaoImpl();
    for (Productos prod : dao.listarproductos()) {
        System.out.println("\n########################################");
        System.out.println("\nID:"+prod.getId_productos()+
                               "\nNOMBRE:"+prod.getNombre()+
                               "\nCATEGORIA_PRODUCTO:"+prod.getId_categoria_prod()+
                               "\nCANTIDAD:"+prod.getCantidad()+
                               "\nPRECIO:"+prod.getPrecio()+
                               "\nDESCRIPCION:"+prod.getDescripcion()+
                               "\nUNIDAD_MEDIDDA:"+prod.getId_unidad_medida());
                               
        System.out.println("\n########################################");  
        }

    }
    
//    COMPRA
    public void agregarCompra(){
    CompraDao dao=new CompraDaoImpl();
    Compra compra=new Compra();
    compra.setFecha("01/11/15");
    compra.setSerie_factura(null);
    compra.setIgv(41.00);
    compra.setDescuento(17.00);
    compra.setId_proveedor(1);
        
            
        if (dao.agregarCompra(compra)) {
            System.out.println("Se Agrego Correctamente.");
        } else {
            System.out.println("Ocurrio un error al agregar.");
            }
        
    }
    
    public void eliminarCompra(){
    CompraDao dao=new CompraDaoImpl();
    if(dao.eliminarcompra(1)){
        System.out.println("Elimino Correctamente");
        }else{
        System.out.println("Error al eliminar");
        }
    }
    
    public void actualizarCompra(){
    CompraDao dao=new CompraDaoImpl();
    Compra compra=new Compra();
    compra.setFecha("01/11/15");
    compra.setSerie_factura(null);
    compra.setIgv(41.00);
    compra.setDescuento(17.00);
    compra.setId_proveedor(1);
        if (dao.actualizarcompra(compra)) {
             System.out.println("Se Actualizo Correctamente");
        } else {
            System.out.println("Error al Actualizar");
        }
    }
    
    public void listarCompra(){
    CompraDao dao=new CompraDaoImpl();
    for (Compra compra: dao.listarcompra()) {
        System.out.println("\n########################################");
        System.out.println("\nID:"+compra.getId_compra()+
                               "\nFECHA:"+compra.getFecha()+
                               "\nSERIE_FCATURA:"+compra.getSerie_factura()+
                               "\nIGV:"+compra.getIgv()+
                               "\nDESCUENTO:"+compra.getDescuento()+
                               "\nPROVEEDOR:"+compra.getId_proveedor());
                               
        System.out.println("\n########################################");  
        }

    }    
    
    public void AgregarVenta(){
        VentaDao dao=new VentaDaoImpl();
        Venta venta= new Venta();
  
    venta.setFecha_venta("01/11/15");
    venta.setSerie_factura(null);
    venta.setSubtotal(456.00);
    venta.setIgv(41.00);
    venta.setDescuento(17.00);
    venta.setTotal(1201.00);
    venta.setId_usuario(1);
    venta.setId_cliente(1);
    venta.setHora("5:00");
                
        if (dao.agregarventa(venta)) {
            System.out.println("Se Agrego Correctamente.");
        } else {
            System.out.println("Ocurrio un error al agregar.");
            }
    }
    
        public void listarVenta(){
    VentaDao dao=new VentaDaoImpl();
    for (Venta venta: dao.listarventa() ) {
        System.out.println("\n########################################");
        System.out.println("\nID:"+venta.getId_venta()+
                               "\nFECHA:"+venta.getFecha_venta()+
                               "\nSERIE_FCATURA:"+venta.getSerie_factura()+
                               "\nSUBTOTAL:"+venta.getSubtotal()+
                               "\nIGV:"+venta.getIgv()+
                               "\nDESCUENTO:"+venta.getDescuento()+
                               "\nTOTAL:"+venta.getTotal()+
                               "\nPROVEEDOR:"+venta.getId_usuario()+
                               "\nPRODUCTO:"+venta.getId_cliente()+
                               "\nHORA:"+venta.getHora());
                               
        System.out.println("\n########################################");  
        }

    }  
}

