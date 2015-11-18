/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImpl;

import Beans.Unidad_medida;
import Dao.Unidad_medidaDao;
import conexion.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josue
 */
public class Unidad_medidaDaoImpl implements Unidad_medidaDao{
Conexion cn = Conexion.getInstance();
    
    @Override
    public List<Unidad_medida> lista_Unidad_medidad() {
    
    List<Unidad_medida> lista = null;
        Statement st = null;
        ResultSet rs = null;
        Unidad_medida um = null;
        String query = "select * from unidad_medida";
        try {
            lista = new ArrayList<>();
            st = cn.conexion().createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {

                um = new Unidad_medida();
                um.setId_unidad_medida(rs.getInt("id_unidad_medida"));
                um.setNombre_uni(rs.getString("nombre_uni"));
                um.setDescripcion(rs.getString("descripcion"));
                um.setAbreviatura(rs.getString("abreviatura"));
                lista.add(um);
            }
//            cn.cerrar();
        } catch (Exception e) {
            System.out.println("ERROR:" + e.getMessage());
            e.printStackTrace();
//            cn.cerrar();
        }
        return lista;
    
    
    
    }
    
}
