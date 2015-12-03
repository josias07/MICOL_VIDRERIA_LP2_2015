
package Dao;

import Beans.Unidad_medida;
import java.util.List;


    public interface Unidad_medidaDao {
    public boolean agregar_unidad_medida(Unidad_medida unidad_med);
    public boolean eliminar_unidad_medida(String id_unidad_medida);
    public boolean actualizar_unidad_medida(Unidad_medida unidad_med);
    public List<Unidad_medida> lista_unidad_medidad();
}
