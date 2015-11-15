/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Beans.Usuario;
import java.util.List;

/**
 *
 * @author josue
 */
public interface UsuarioDao {
    
    public boolean agregarUsuario(Usuario usuario);
     public boolean eliminarUsuario(int id_usuario);
    public boolean actualizarUsuario(Usuario usuario);
    public List<Usuario> listarUsuario();
    
    public Usuario validarUsuario(String usuario, String contraseña);
    
}
