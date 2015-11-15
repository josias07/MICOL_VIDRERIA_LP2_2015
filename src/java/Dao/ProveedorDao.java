/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Beans.Proveedor;
import java.util.List;

/**
 *
 * @author josue
 */
public interface ProveedorDao {
    public boolean agregarProveedor (Proveedor proveedor);
    public List<Proveedor> listarProveedor();
    
}
