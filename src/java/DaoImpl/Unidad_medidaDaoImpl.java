
package DaoImpl;

import Beans.Unidad_medida;
import Dao.Unidad_medidaDao;
import conexion.Conexion;
import conexion.Configuracion;
import java.util.ArrayList;
import java.util.List;

public class Unidad_medidaDaoImpl implements Unidad_medidaDao {

    Conexion cn = Configuracion.Vidreria();

    @Override
    public boolean agregar_unidad_medida(Unidad_medida unidad_med) {

        String query = "INSERT INTO unidad_medida (nombre_uni, descripcion, abreviatura)"
                + " VALUES ('" + unidad_med.getNombre_uni() + "',"
                + "'" + unidad_med.getDescripcion() + "',"
                + "'" + unidad_med.getAbreviatura() + "')";
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
    public boolean eliminar_unidad_medida(String id_unidad_medida) {
        boolean flat = false;
        String query = "DELETE FROM unidad_medida WHERE id_unidad_medida=" + id_unidad_medida + "";
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
    public boolean actualizar_unidad_medida(Unidad_medida unidad_med) {
        boolean flat = false;
        String query = "UPDATE unidad_medida SET nombre_uni='" + unidad_med.getNombre_uni()+ "',"
                + "descripcion='" + unidad_med.getDescripcion()+ "',"
                + "abreviatura='" + unidad_med.getAbreviatura()
                + "' WHERE id_unidad_medida =" + unidad_med.getId_unidad_medida();

        try {
            cn.execC(query);
            cn.Commit();

            return true;
        } catch (Exception EX) {
            cn.RollBack();

            return false;
        }    }

    @Override
    public List<Unidad_medida> lista_unidad_medidad() {
        List<Unidad_medida> lista = null;
        String query = "select * from unidad_medida";
        System.out.println(query);
        lista = new ArrayList<Unidad_medida>();
        cn.execQuery(query);
        while (cn.getNext()) {
            Unidad_medida um = new Unidad_medida();
            um.setId_unidad_medida(cn.getCol("id_unidad_medida"));
            um.setNombre_uni(cn.getCol("nombre_uni"));
            um.setDescripcion(cn.getCol("descripcion"));
            um.setAbreviatura(cn.getCol("abreviatura"));
            lista.add(um);
        }

    return lista ;

    }

}
