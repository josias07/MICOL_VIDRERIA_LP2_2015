
<%@page import="DaoImpl.VentaDaoImpl"%>
<%@page import="Dao.VentaDao"%>
<%@page import="Beans.Detalle_venta"%>
<%@page import="Beans.Venta"%>
<%@page import="Beans.Detalle_venta"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Formulario Producto</title>
        <%!            
            String id_ventaa, fecha_venta, comprobante, serie, igv, descuento, id_cliente, id_usuario, id_detalle_venta,
                    descripcion, cantidad, precio_unitario, importe, id_productos, opcion;
        %>

        <%
            id_ventaa = request.getParameter("id_ventaa");
            if (id_ventaa == null) {
                id_ventaa = "";
            }
            
            fecha_venta = request.getParameter("fecha_venta");
            if (fecha_venta == null) {
                fecha_venta = "";
            }
            
            cantidad = request.getParameter("cantidad");
            if (cantidad == null) {
                cantidad = "";
            }
            
            comprobante = request.getParameter("comprobante");
            if (comprobante == null) {
                comprobante = "";
            }
            
            serie = request.getParameter("serie");
            if (serie == null) {
                serie = "";
            }
            
            igv = request.getParameter("igv");
            if (igv == null) {
                igv = "";
            }
            
            descuento = request.getParameter("descuento");
            if (descuento == null) {
                descuento = "";
            }
            
            id_cliente = request.getParameter("id_cliente");
            if (id_cliente == null) {
                id_cliente = "";
            }
            
            id_usuario = request.getParameter("id_usuario");
            if (id_usuario == null) {
                id_usuario = "";
            }
            
            id_detalle_venta = request.getParameter("id_detalle_venta");
            if (id_detalle_venta == null) {
                id_detalle_venta = "";
            }
            
            descripcion = request.getParameter(" descripcion");
            if (descripcion == null) {
                descripcion = "";
            }
            
            precio_unitario = request.getParameter("precio_unitario");
            if (precio_unitario == null) {
                precio_unitario = "";
            }
            
            importe = request.getParameter("serie");
            if (importe == null) {
                importe = "";
            }
            
            id_productos = request.getParameter("id_producto_stock");
            if (id_productos == null) {
                id_productos = "";
            }
            
            opcion = request.getParameter("opcion");
            if (opcion == null) {
                opcion = "";
            }
            

        %>
    </head>
    <body>
        <%@include file="Venta_2.jsp" %>
        <%      if (opcion.equals("Actualizar")) {
                Venta venta = new Venta();
                Detalle_venta deve = new Detalle_venta();
                venta.setId_venta(id_venta);
                venta.setFecha_venta(fecha_venta);
                venta.setComprobante(comprobante);
                venta.setSerie(serie);
                venta.setIgv(igv);
                venta.setDescuento(descuento);
                venta.setId_cliente(id_cliente);
                venta.setId_usuario(id_usuario);
                deve.setId_detalle_venta(id_detalle_venta);
                deve.setDescripcion(descripcion);
                deve.setCantidad(cantidad);
                deve.setPrecio_unitario(precio_unitario);
                deve.setImporte(importe);
                deve.setId_productos(id_productos);
                
                VentaDao ven = new VentaDaoImpl();
                if (ven.actualizarventa(venta)) {
                    out.print("Actualizado correctamente");
                    response.sendRedirect("registra_producto.jsp");
                } else {
                    out.print("No se pudo actualizar");
                }
            }
            if (opcion.equals("Registrar")) {
                Detalle_venta venta = new Detalle_venta();
                venta.setId_venta(id_ventaa);
                venta.setDescripcion(descripcion);
                venta.setCantidad(cantidad);
                venta.setPrecio_unitario(precio_unitario);
                venta.setImporte(importe);
                venta.setId_productos(descuento);
                VentaDao ven = new VentaDaoImpl();
                if (ven.agregar_detalleventa(venta)) {
                    out.print("Registrado correctamente");
                    response.sendRedirect("Venta_1.jsp");
                } else {
                    out.print("No se pudo registrar");
                }
            }
            if (opcion.equals("Eliminar")) {
                VentaDao ven = new VentaDaoImpl();
                Venta venta = new Venta();
                Detalle_venta deve = new Detalle_venta();
                if (ven.eliminarventa(id_venta)) {
                    out.print("Eliminado correctamente");
                    response.sendRedirect("registra_producto.jsp");
                } else {
                    out.print("No se pudo eliminar porque se está usando");
                }
            }
        %>

</body>
</html>