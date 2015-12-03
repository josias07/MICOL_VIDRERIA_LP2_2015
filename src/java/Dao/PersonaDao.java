
package Dao;

import Beans.Persona;
import java.util.List;

public interface PersonaDao {
    public boolean agregarpersona(Persona persona);
    public boolean eliminarpersona(String id_persona);
    public boolean actualizarpersona(Persona persona);
    public List<Persona> listarpersona(String buscar);
    
}
