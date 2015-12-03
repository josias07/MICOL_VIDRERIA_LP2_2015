package DaoImpl;

import Dao.PersonaDao;
import Beans.Persona;
import conexion.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonaDaoImpl implements PersonaDao {

//conexionMYSQL2 cn = new conexionMYSQL2();
    Conexion cn = Conexion.getInstance();

    @Override
    public boolean agregarpersona(Persona persona) {
        boolean flat = false;
        Statement st = null;
        String query = "INSERT INTO persona (nombre,apepat,apemat,sexo,dni,celular,direccion)"
                + " VALUES('" + persona.getNombre() + "',"
                + "'" + persona.getApepat() + "',"
                + "'" + persona.getApemat() + "',"
                + "'" + persona.getSexo() + "',"
                + "" + persona.getDni() + ","
                + "" + persona.getCelular() + ","
                + "'" + persona.getDireccion() + "')";
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
    public boolean eliminarpersona(String id_persona) {
        boolean flat = false;
        String query = "DELETE FROM persona WHERE id_persona=" + id_persona + "";
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
    public boolean actualizarpersona(Persona persona) {
        boolean flat = false;
        String query = "UPDATE persona SET nombre='" + persona.getNombre()
                + "',apepat='" + persona.getApepat()
                + "',apemat='" + persona.getApemat()
                + "',sexo='" + persona.getSexo()
                + "',dni='" + persona.getDni()
                + "',celular='" + persona.getCelular()
                + "',direccion='" + persona.getDireccion()
                + "' WHERE id_persona =" + persona.getId_persona() + "";

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
    public List<Persona> listarpersona(String buscar) {
        List<Persona> lista = null;
        String query = "select per.nombre, per.dni from persona per where "
                + " UPPER(per.dni) like ('%" + buscar + "%')";
        System.out.println(query);
        lista = new ArrayList<Persona>();
        cn.execQuery(query);
        while (cn.getNext()) {
            Persona per= new Persona();
            per.setId_persona(cn.getCol("id_persona"));
            per.setNombre(cn.getCol("nombre"));
            per.setApepat(cn.getCol("apepat"));
            per.setApemat(cn.getCol("apemat"));
            per.setSexo(cn.getCol("sexo"));
            per.setDni(cn.getCol("dni"));
            per.setCelular(cn.getCol("celular"));
            per.setDireccion(cn.getCol("direccion"));
            lista.add(per);
        }
    return lista ;
    }
}

