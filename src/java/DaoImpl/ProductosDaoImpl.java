package DaoImpl;

import Dao.ProductosDao;
import Beans.Productos;
import conexion.Conexion;
import conexion.Configuracion;
import java.util.ArrayList;
import java.util.List;

public class ProductosDaoImpl implements ProductosDao {

    Conexion cn = Configuracion.Vidreria();

    @Override
    public boolean agregarproducto(Productos productos) {

        String query = "INSERT INTO productos (nombre,cantidad, precio, descripcion,"
                + " id_categoria_prod, id_unidad_medida)"
                + " VALUES ('" + productos.getNombre() + "',"
                + "" + productos.getCantidad() + ","
                + "" + productos.getPrecio() + ","
                + "'" + productos.getDescripcion() + "',"
                + "" + productos.getId_categoria_prod() + ","
                + "" + productos.getId_unidad_medida()+")";

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
    public boolean eliminarproducto(String id_productos) {
        boolean flat = false;
        String query = "DELETE FROM productos WHERE id_productos=" + id_productos + "";
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
    public boolean actualizarproducto(Productos productos) {
        boolean flat = false;
        String query = "UPDATE productos SET nombre='" + productos.getNombre() + "',"
                + "id_categoria_prod='" + productos.getId_categoria_prod() + "',"
                + "cantidad='" + productos.getCantidad() + "',"
                + "precio='" + productos.getPrecio() + "',"
                + "descripcion='" + productos.getDescripcion() + "',"
                + "id_unidad_medida='" + productos.getId_unidad_medida()
                + "' WHERE id_productos =" + productos.getId_productos();

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
    public List<Productos> listarproductos(String buscar, String limit) {
        List<Productos> lista = null;
        String query = "select "
                + " pro.id_productos,"
                + " pro.nombre,"
                + " pro.precio,"
                + " pro.cantidad,"
                + " cat.nombre_categoria nombre_categoria,"
                + " uni.nombre_uni nombre_medida,"
                + " pro.descripcion"
                + " from productos pro,"
                + " categoria_prod cat, "
                + " unidad_medida uni "
                + " where "
                + " cat.id_categoria_prod=pro.id_categoria_prod and "
                + " uni.id_unidad_medida=pro.id_unidad_medida and"
                + " UPPER(pro.nombre) like ('%" + buscar + "%')"
                + " order by pro.id_productos"
                + " limit " + limit;
        System.out.println(query);
        lista = new ArrayList<Productos>();
        cn.execQuery(query);
        while (cn.getNext()) {
            Productos p = new Productos();
            p.setId_productos(cn.getCol("id_productos"));
            p.setNombre(cn.getCol("nombre"));
            p.setPrecio(cn.getCol("precio"));
            p.setCantidad(cn.getCol("cantidad"));
            p.setNombre_categoria(cn.getCol("nombre_categoria"));
            p.setNombre_medida(cn.getCol("nombre_medida"));
            p.setDescripcion(cn.getCol("descripcion"));
            lista.add(p);
        }

        return lista;
    }

    @Override
    public Productos DatosProductos(String id_productos) {

        String query = "select "
                + " id_productos,"
                + " nombre,"
                + " cantidad,"
                + " precio,"
                + " descripcion,"
                + " id_categoria_prod, "
                + " id_unidad_medida "
                + " from productos "
                + " where id_productos=" + id_productos;
        System.out.println(query);
        Productos prod = new Productos();
        cn.execQuery(query);
        cn.getNext();
        prod.setId_productos(cn.getCol("id_productos"));
        prod.setNombre(cn.getCol("nombre"));
        prod.setId_categoria_prod(cn.getCol("id_categoria_prod"));
        prod.setCantidad(cn.getCol("cantidad"));
        prod.setPrecio(cn.getCol("precio"));
        prod.setDescripcion(cn.getCol("descripcion"));
        prod.setId_unidad_medida(cn.getCol("id_unidad_medida"));
            
        return prod;
       }
}

