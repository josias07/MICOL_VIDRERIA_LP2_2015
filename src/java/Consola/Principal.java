
package Consola;

import Dao.PersonaDao;
import Dao.UsuarioDao;
import DaoImpl.PersonaDaoImpl;
import DaoImpl.UsuarioDaoImpl;

import Beans.Persona;
import Beans.Usuario;

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
}

