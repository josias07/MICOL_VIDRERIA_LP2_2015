
<%@page import="DaoImpl.VentaDaoImpl"%>
<%@page import="Dao.VentaDao"%>
<%@page import="Beans.Detalle_venta"%>
<%@page import="Beans.Venta"%>
<html>
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>Formulario Persona</title>

<%!
    String id_venta, fecha_venta, comprobante, serie, igv, descuento, id_cliente, id_usuario, id_detalle_venta,
            descripcion, cantidad, precio_unitario, importe, id_productos, opcion;
%>

<%
    id_venta = request.getParameter("id_venta");
    if (id_venta == null) {
        id_venta = "";
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
    <%@include file="ventas.jsp" %>
    
    <%      if (opcion.equals("Actualizar")) {
            Venta ta = new Venta();
            Detalle_venta deve = new Detalle_venta();
            ta.setId_venta(id_venta);
            ta.setFecha_venta(fecha_venta);
            ta.setComprobante(comprobante);
            ta.setSerie(serie);
            ta.setIgv(igv);
            ta.setDescuento(descuento);
            ta.setId_cliente(id_cliente);
            ta.setId_usuario(id_usuario);
            deve.setId_detalle_venta(id_detalle_venta);
            deve.setDescripcion(descripcion);
            deve.setCantidad(cantidad);
            deve.setPrecio_unitario(precio_unitario);
            deve.setImporte(importe);
            deve.setId_productos(id_productos);

            VentaDao v = new VentaDaoImpl();

            if (v.actualizarventa(venta)) {
                out.print("Actualizado correctamente");
                response.sendRedirect("ventas.jsp");
            } else {
                out.print("No se pudo actualizar");
            }
        }
        if (opcion.equals("Registrar")) {
            Venta vent = new Venta();
            Detalle_venta det = new Detalle_venta();
            vent.setId_usuario(id_usuario);
            det.setCantidad(cantidad);
            det.setId_productos(id_productos);
            det.setPrecio_unitario(precio_unitario);

            VentaDao ve = new VentaDaoImpl();
            String id_venta_resul = ve.REGISTRAR_VENTA(venta, deta);
            if (!id_venta_resul.equals("")) {
                out.print("Registrado correctamente");
                response.sendRedirect("ventas.jsp?id_venta=" + id_venta_resul);
            } else {
                out.print("No se pudo registrar");
            }
        }
        if (opcion.equals("Eliminar")) {
            VentaDao eli = new VentaDaoImpl();
            Venta ve = new Venta();
            Detalle_venta deve = new Detalle_venta();
            if (eli.eliminarventa(id_venta)) {
                out.print("Eliminado correctamente");
                response.sendRedirect("registra_producto.jsp");
            } else {
                out.print("No se pudo eliminar porque se está usando");
            }
        }
    %>
</body>
</html>

