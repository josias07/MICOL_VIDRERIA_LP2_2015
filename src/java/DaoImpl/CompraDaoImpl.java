package DaoImpl;

import Beans.Compra;
import conexion.Conexion;
import Dao.CompraDao;
import conexion.Configuracion;
import java.util.ArrayList;
import java.util.List;

public class CompraDaoImpl implements CompraDao {

    Conexion cn = Configuracion.Vidreria();

    @Override
    public boolean agregarCompra(Compra compra) {
        boolean flat = false;
//        Statement st = null;
//        String query = "INSERT INTO compra(fecha, comprobante, igv, descuento, id_proveedor, serie)"
//                + " VALUES ('" + compra.getFecha() + "','" + compra.getComprobante() + "','" + compra.getIgv() + "','" + compra.getDescuento() + "','" + compra.getId_proveedor() + "','" + compra.getSerie() + "')";
//        try {
//            st = cn.conexion().createStatement();
//            st.executeUpdate(query);
//
//            cn.conexion().getAutoCommit();
////            cn.conexion().close();
//            flat = true;
//        } catch (Exception e) {
//            System.out.println("ERROR:" + e.getMessage());
//            try {
//                cn.conexion().rollback();
////                cn.conexion().close();
//            } catch (Exception ex) {
//            }
//        } finally {
//            if (cn.conexion() != null) {
//                try {
//                    cn.conexion().rollback();
////                    cn.conexion().close();
//                } catch (Exception e) {
//                }
//            }
//
//        }
        return flat;
    }

    @Override
    public boolean eliminarcompra(int id_compra) {
        boolean flat = false;
        String query = "DELETE FROM compra WHERE id_compra=" + id_compra + "";
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
    public boolean actualizarcompra(Compra compra) {
        boolean flat = false;
        String query = "UPDATE compra SET fecha='" + compra.getFecha()
                + "',comprobante='" + compra.getComprobante()
                + "',igv='" + compra.getIgv()
                + "',descuento='" + compra.getDescuento()
                + "',id_proveedor='" + compra.getId_proveedor()
                + "',serie='" + compra.getSerie()
                + "' WHERE id_productos =" + compra.getId_compra() + "";

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
    public List<Compra> listarcompra() {
        List<Compra> lista = null;
        String query = "select "
                + " com.id_compra,"
                + " com.fecha,,"
                + " com.comprobante,"
                + " com.serie,"
                + " pro.nombre,"
                + " prod.nombre,"
                + " deco.cantidad,"
                + " deco.precio_unitario,"
                + " deco.importe,"
                + " from compra com,"
                + " proveedor pro, "
                + " detalle_compra deco"
                + " productos prod"
                + " where "
                + " com.id_proveedor=pro.id_proveedor and "
                + " deco.id_compra=com.id_compra and"
                + " deco.id_productos=prod.id_productos and";
        System.out.println(query);
        lista = new ArrayList<Compra>();
        cn.execQuery(query);
        while (cn.getNext()) {
            Compra co = new Compra();
            Compra com = new Compra();
            co.setId_compra(cn.getCol("id_compra"));
            co.setFecha(cn.getCol("fecha"));
            co.setSerie(cn.getCol("serie"));
            co.setComprobante(cn.getCol("comprobante"));
            co.setNombre_proveedor(cn.getCol("nombre_proveedor"));
            lista.add(co);
        }

        return lista;
    }

    @Override
    public List<Compra> fechacompra(String fecha1, String fecha2) {
        List<Compra> lista = null;
        String query = "select "
                + " con.id_compra,"
                + " con.fecha,"
                + " con.serie,"
                + " con.comprobante,"
                + " prov.nombre nombre_proveedor"
                + " from compra con,"
                + " proveedor prov "
                + " where "
                + " con.fecha BETWEEN ('" + fecha1+ "') AND ('" + fecha2+ "')"
                + " order by con.fecha";
        System.out.println(query);
        lista = new ArrayList<Compra>();
        cn.execQuery(query);
        while (cn.getNext()) {
            Compra com = new Compra();
            com.setId_compra(cn.getCol("id_compra"));
            com.setFecha(cn.getCol("fecha"));
            com.setSerie(cn.getCol("serie"));
            com.setComprobante(cn.getCol("comprobante"));
            com.setNombre_proveedor(cn.getCol("nombre_proveedor"));
            lista.add(com);
        }

        return lista;
    }
}
