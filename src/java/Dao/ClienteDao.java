/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Beans.Cliente;
import java.util.List;


/**
 *
 * @author GISS
 */
public interface ClienteDao {
    
    public boolean registrarCliente(Cliente cliente);
    public List<Cliente> listarCliente();
    public boolean eliminarCliente(int id);
    public boolean actualizarCliente(Cliente cliente);
    }
    

