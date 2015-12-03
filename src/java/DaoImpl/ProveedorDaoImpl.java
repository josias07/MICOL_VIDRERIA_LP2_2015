
package DaoImpl;

import Beans.Proveedor;
import conexion.Conexion;
import Dao.ProveedorDao;
import conexion.Configuracion;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDaoImpl implements ProveedorDao{
    
    Conexion cn = Configuracion.Vidreria();
    @Override
    public boolean agregarProveedor(Proveedor proveedor) {

        String query="INSERT INTO proveedor (id_proveedor,nombre,ruc,telefono,razon_social,direccion)"
                + "VALUES ('" + proveedor.getNombre()
                + "," + proveedor.getRuc()
                + "," + proveedor.getTelefono()
                + "," + proveedor.getRazon_social()
                + "," + proveedor.getDireccion()+"')";
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
    public boolean eliminarproveedor(String id_proveedor) {
        boolean flat = false;
        String query = "DELETE FROM proveedor WHERE id_proveedor=" + id_proveedor + "";
        try {
            cn.execC(query);
            cn.Commit();
            return true;
        } catch (Exception EX) {
            cn.RollBack();
            return false;
        }    }

    @Override
    public boolean actualizarproveedor(Proveedor proveedor) {
        boolean flat = false;
        String query = "UPDATE productos SET nombre='" + proveedor.getNombre() + "',"
                + "ruc='" + proveedor.getRuc()+ "',"
                + "telefono='" + proveedor.getTelefono() + "',"
                + "razon_social='" + proveedor.getRazon_social()+ "',"
                + "direccion='" + proveedor.getDireccion()
                + "' WHERE id_proveedor =" + proveedor.getId_proveedor();

        try {
            cn.execC(query);
            cn.Commit();

            return true;
        } catch (Exception EX) {
            cn.RollBack();

            return false;
        }    }

    @Override
    public List<Proveedor> listarProveedor() {
    List<Proveedor> lista=null;
        String query = "select * from categoria_prod";
        System.out.println(query);
        lista = new ArrayList<Proveedor>();
        cn.execQuery(query);
        while (cn.getNext()) {
            Proveedor prove = new Proveedor();
            prove.setId_proveedor(cn.getCol("id_proveedor"));
            prove.setRuc(cn.getCol("ruc"));
            prove.setTelefono(cn.getCol("telefono"));
            prove.setRazon_social(cn.getCol("razon_social"));
            prove.setDireccion(cn.getCol("direccion"));
            lista.add(prove);
        }
//
    return lista ;

    }
}
