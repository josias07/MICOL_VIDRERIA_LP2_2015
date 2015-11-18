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
    
    public boolean agregarCliente(Cliente cliente);
    public boolean actualizarCliente(Cliente cliente);
    }
    

