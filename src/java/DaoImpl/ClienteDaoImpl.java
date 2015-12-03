package DaoImpl;

import Beans.Cliente;
import conexion.Conexion;
import Dao.ClienteDao;
import conexion.Configuracion;

public class ClienteDaoImpl implements ClienteDao {

    Conexion cn = Configuracion.Vidreria();

    @Override
    public boolean agregarCliente(Cliente cliente) {

        String query = "INSERT INTO cliente (id_persona,estado) "
                        + "VALUES ('"+cliente.getId_persona()+"',"
                        + "'" + cliente.getEstado() + "')";
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
    public boolean actualizarCliente(Cliente cliente) {
        boolean flat = false;

        String query = "UPDATE cliente SET id_persona='" + cliente.getId_persona()+ "',"
                + "estado='" + cliente.getEstado()
                + "' WHERE id_productos =" + cliente.getId_cliente();
        try {
            cn.execC(query);
            cn.Commit();

            return true;
        } catch (Exception EX) {
            cn.RollBack();

            return false;
        }
    }
}
