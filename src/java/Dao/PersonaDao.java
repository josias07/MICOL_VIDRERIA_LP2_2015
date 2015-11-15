/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Beans.Persona;
import java.util.List;

/**
 *
 * @author George Manya
 */
public interface PersonaDao {
    public boolean agregarpersona(Persona persona);
    public boolean eliminarpersona(int id_persona);
    public boolean actualizarpersona(Persona persona);
    public List<Persona> listarpersona();
    
}
