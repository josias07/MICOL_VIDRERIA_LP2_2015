package DaoImpl;

import Beans.Detalle_venta;
import Dao.VentaDao;
import Beans.Venta;
import conexion.Conexion;
import conexion.Configuracion;
import java.util.ArrayList;
import java.util.List;

public class VentaDaoImpl implements VentaDao {

    Conexion cn = Configuracion.Vidreria();

    @Override
    public boolean agregarventa(Venta venta) {
        String query = "INSERT INTO venta (fecha_venta, comprobante,serie,igv,descuento, id_cliente)"
                + "VALUES ('" + venta.getFecha_venta() + "',"
                + "'" + venta.getComprobante() + "',"
                + "'" + venta.getSerie() + "',"
                + "'" + venta.getIgv() + "',"
                + "'" + venta.getDescuento() + "',"
                + "'" + venta.getId_cliente()+ "')";
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
    public boolean agregardeta_venta(Detalle_venta deta_venta) {
        String query = "INSERT INTO detalle_venta (descripcion,cantidad,precio_unitario,importe,id_venta,id_productos)"
                + "VALUES ('" + deta_venta.getDescripcion()+ "',"
                + "'" + deta_venta.getCantidad()+ "',"
                + "'" + deta_venta.getPrecio_unitario() + "',"
                + "'" + deta_venta.getImporte() + "',"
                + "'" + deta_venta.getId_venta() + "',"
                + "'" + deta_venta.getId_productos()+ "')";
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
    public boolean eliminarventa(String id_venta) {
        boolean flat = false;
        String query = "DELETE FROM venta WHERE id_venta=" + id_venta + "";
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
    public boolean actualizarventa(Venta venta) {
        boolean flat = false;
        String query = "UPDATE venta SET fecha_venta='" + venta.getFecha_venta() + "',"
                + "comprobante='" + venta.getComprobante()+ "'," 
                + "serie='" + venta.getSerie()+ "'," 
                + "igv='" + venta.getIgv()+ "'," 
                + "descuento='" + venta.getDescuento()+ "'," 
                + "id_proveedor='" + venta.getId_usuario()+ "'," 
                + "id_productos='" + venta.getId_cliente() 
                + "' WHERE id_venta =" + venta.getId_venta() + "";
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
    public List<Venta> listarventa(String buscar, String limit) {
        List<Venta> lista = null;
        String query = "select "
                + " ven.id_venta,"
                + " ven.fecha_venta,"
                + " ven.serie,"
                + " us.usuario nombre_usuario,"
                + " pro.nombre nombre_producto,"
                + " per.nombre nombre_cliente,"
                + " ven.comprobante,"
                + " det.cantidad cantidad,"
                + " det.precio_unitario precio,"
                + " ven.igv,"
                + " ven.descuento,"
                + " (det.cantidad*det.precio_unitario)-ven.descuento total"
                + " from "
                + " detalle_venta det,"
                + " venta ven,"
                + " cliente cli,"
                + " persona per,"
                + " usuario us,"
                + " productos pro"
                + " where "
                + " ven.id_venta=det.id_venta and "
                + " ven.id_cliente=cli.id_cliente and "
                + " cli.id_persona=per.id_persona and "
                + " per.id_persona=us.id_usuario and "
                + " det.id_productos=pro.id_productos and "
                + " UPPER(pro.nombre) like ('%" + buscar + "%')"
                + " order by ven.id_venta"
                + " limit " + limit;
        System.out.println(query);
        lista = new ArrayList<Venta>();
        cn.execQuery(query);
        while (cn.getNext()) {
            Venta venta = new Venta();
            venta.setId_venta(cn.getCol("id_venta"));
            venta.setFecha_venta(cn.getCol("fecha_venta"));
            venta.setSerie(cn.getCol("serie"));
            venta.setNombre_usuario(cn.getCol("nombre_usuario"));
            venta.setNombre_producto(cn.getCol("nombre_producto"));
            venta.setNombre_cliente(cn.getCol("nombre_cliente"));
            venta.setComprobante(cn.getCol("comprobante"));
            venta.setCantidad(cn.getCol("cantidad"));
            venta.setPrecio(cn.getCol("precio"));
            venta.setIgv(cn.getCol("igv"));
            venta.setDescuento(cn.getCol("descuento"));
            venta.setTotal(cn.getCol("total"));
            lista.add(venta);
        }

        return lista;
    }

    @Override
    public List<Venta> fecha_venta(String fecha1, String fecha2) {
    List<Venta> lista = null;
        String query = "select "
                + " ven.id_venta,"
                + " ven.fecha_venta,"
                + " ven.serie,"
                + " us.usuario nombre_usuario,"
                + " pro.nombre nombre_producto,"
                + " per.nombre nombre_cliente,"
                + " ven.comprobante,"
                + " det.cantidad cantidad,"
                + " det.precio_unitario precio,"
                + " ven.igv,"
                + " ven.descuento,"
                + " (det.cantidad*det.precio_unitario)-ven.descuento total"
                + " from "
                + " detalle_venta det,"
                + " venta ven,"
                + " cliente cli,"
                + " persona per,"
                + " usuario us,"
                + " productos pro"
                + " where "
                + " ven.id_venta=det.id_venta and "
                + " ven.id_cliente=cli.id_cliente and "
                + " per.id_persona=us.id_usuario and "
                + " det.id_productos=pro.id_productos and "
                + " ven.fecha_venta BETWEEN ('"+ fecha1+ "') AND ('"+ fecha2+ "')"
                + " order by ven.fecha_venta";
        System.out.println(query);
        lista = new ArrayList<Venta>();
        cn.execQuery(query);
        while (cn.getNext()) {
             Venta venta = new Venta();
            venta.setId_venta(cn.getCol("id_venta"));
            venta.setFecha_venta(cn.getCol("fecha_venta"));
            venta.setSerie(cn.getCol("serie"));
            venta.setNombre_usuario(cn.getCol("nombre_usuario"));
            venta.setNombre_producto(cn.getCol("nombre_producto"));
            venta.setNombre_cliente(cn.getCol("nombre_cliente"));
            venta.setComprobante(cn.getCol("comprobante"));
            venta.setCantidad(cn.getCol("cantidad"));
            venta.setPrecio(cn.getCol("precio"));
            venta.setIgv(cn.getCol("igv"));
            venta.setDescuento(cn.getCol("descuento"));
            venta.setTotal(cn.getCol("total"));
            lista.add(venta);
        }

        return lista;
    
    }

    @Override
    public boolean agregar_detalleventa(Detalle_venta deta_venta) {
        String query = "INSERT INTO detalle_venta (descripcion,cantidad,precio_unitario,importe,id_venta,"
                + " id_productos)"
                + "VALUES ('" + deta_venta.getDescripcion() + "',"
                + " " + deta_venta.getCantidad() + ","
                + " " + deta_venta.getPrecio_unitario() + ","
                + " 0,"
                + " " + deta_venta.getId_venta()+ ","
                + " " + deta_venta.getId_productos()+ ")";
        System.out.println(query);
        try {
            cn.execC(query);
            cn.Commit();

            return true;
        } catch (Exception EX) {
            cn.RollBack();

            return false;
        }    }

    @Override
    public List<Venta> terminaventa() {
        List<Venta> lista = null;
        String query = "select "
                + " max(det.id_detalle_venta)id_detalle_venta,"
                + " ven.id_venta,"
                + " ven.serie,"
                + " per.nombre nombre_cliente,"
                + " pro.nombre nombre_producto,"
                + " det.cantidad cantidad,"
                + " det.precio_unitario precio,"
                + " ven.descuento,"
                + " ven.igv,"
                + " ven.comprobante,"
                + " (det.cantidad*det.precio_unitario)-ven.descuento total"
                + " from "
                + " detalle_venta det,"
                + " venta ven,"
                + " cliente cli,"
                + " persona per,"
                + " usuario us,"
                + " productos pro"
                + " where "
                + " ven.id_venta=det.id_venta and "
                + " ven.id_cliente=cli.id_cliente and "
                + " cli.id_persona=per.id_persona and "
                + " det.id_productos=pro.id_productos"
                + " order by det.id_detalle_venta desc;";
        System.out.println(query);
        lista = new ArrayList<Venta>();
        cn.execQuery(query);
        while (cn.getNext()) {
            Venta venta = new Venta();
            venta.setId_detalle_venta(cn.getCol("id_detalle_venta"));
            venta.setId_venta(cn.getCol("id_venta"));
            venta.setSerie(cn.getCol("serie"));
            venta.setNombre_cliente(cn.getCol("nombre_cliente"));
            venta.setNombre_producto(cn.getCol("nombre_producto"));
            venta.setCantidad(cn.getCol("cantidad"));
            venta.setPrecio(cn.getCol("precio"));
            venta.setDescuento(cn.getCol("descuento"));
            venta.setIgv(cn.getCol("igv"));
            venta.setComprobante(cn.getCol("comprobante"));
            venta.setTotal(cn.getCol("total"));
            lista.add(venta);
        }

        return lista;    
    }

    @Override
    public List<Venta> list_venta() {
        List<Venta> lista = null;
        String query = "select max(ven.id_venta)id_venta "
                + "from venta ven"
                + " order by ven.id_venta desc;";
        System.out.println(query);
        lista = new ArrayList<Venta>();
        cn.execQuery(query);
        while (cn.getNext()) {
            Venta venta = new Venta();
            venta.setId_venta(cn.getCol("id_venta"));
            lista.add(venta);
        }

        return lista;   
    }
//pid_productos INT(11), pcantidad DOUBLE, pprecio_unitario DOUBLE, pid_usuario INT(11)) 

    @Override
    public String REGISTRAR_VENTA(Venta venta, Detalle_venta deta) {
        String id_venta="";
    String query = "SELECT registro_venta(" + deta.getId_productos()+ ","
                + " " + deta.getCantidad()+ ","
                + " " + deta.getPrecio_unitario()+ ","
                + " " + venta.getId_usuario()+ ") id_venta";
        System.out.println(query);
        try {
            cn.execQuery(query);
            cn.Commit();
            cn.getNext();
            id_venta=cn.getCol("id_venta");

        } catch (Exception EX) {
            cn.RollBack();
            System.out.println(EX.getMessage());
        }
        return id_venta;
    }

    @Override
    public Venta Datos_entrada(String id_venta) {
        List<Venta> lista = null;
        Venta venta=null;
        String query = "select "
                + " ven.id_venta,"
                + " DATE_FORMAT(ven.fecha_venta,'%d/%m/%y') fecha_venta,"
                + " ven.comprobante,"
                + " ven.serie,"
                + " us.usuario nombre_usuario,"
                + " pro.nombre nombre_producto,"
                + " per.nombre nombre_cliente,"
                + " det.cantidad cantidad,"
                + " det.precio_unitario precio,"
                + " ven.igv,"
                + " ven.descuento"
                + " from "
                + " detalle_venta det,"
                + " venta ven,"
                + " cliente cli,"
                + " persona per,"
                + " usuario us,"
                + " productos pro"
                + " where "
                + " ven.id_venta=det.id_venta and "
                + " ven.id_cliente=cli.id_cliente and "
                + " cli.id_persona=per.id_persona and "
                + " per.id_persona=us.id_usuario and "
                + " det.id_productos=pro.id_productos;";
        System.out.println(query);
        lista = new ArrayList<Venta>();
        cn.execQuery(query);
        while (cn.getNext()) {
            venta = new Venta();
            venta.setId_venta(cn.getCol("id_venta"));
            venta.setFecha_venta(cn.getCol("fecha_venta"));
            venta.setSerie(cn.getCol("serie"));
            venta.setNombre_usuario(cn.getCol("nombre_usuario"));
            venta.setNombre_producto(cn.getCol("nombre_producto"));
            venta.setNombre_cliente(cn.getCol("nombre_cliente"));
            venta.setComprobante(cn.getCol("comprobante"));
            venta.setCantidad(cn.getCol("cantidad"));
            venta.setPrecio(cn.getCol("precio"));
            venta.setIgv(cn.getCol("igv"));
            venta.setDescuento(cn.getCol("descuento"));
            venta.setTotal(cn.getCol("total"));
            lista.add(venta);
        }
        

        return venta;    
    }

}

