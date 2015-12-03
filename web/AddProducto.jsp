
<%@page import="Beans.Productos"%>
<%@page import="DaoImpl.ProductosDaoImpl"%>
<%@page import="Dao.ProductosDao"%>
<%@page import="Beans.Productos"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
                      <title>Formulario Producto</title>
        <%!
            String id_productos, nombre, cantidad, precio, descripcion, id_categoria, id_unidad_medida, opcion;
        %>

        <%
            id_productos = request.getParameter("id_productos");
            if (id_productos == null) {
                id_productos = "";
            }

            nombre = request.getParameter("nombre");
            if (nombre == null) {
                nombre = "";
            }

            cantidad = request.getParameter("cantidad");
            if (cantidad == null) {
                cantidad = "";
            }

            precio = request.getParameter("precio");
            if (precio == null) {
                precio = "";
            }

            descripcion = request.getParameter("descripcion");
            if (descripcion == null) {
                descripcion = "";
            }

            id_categoria = request.getParameter("id_categoria");
            if (id_categoria == null) {
                id_categoria = "";
            }
            id_unidad_medida = request.getParameter("id_unidad_medida");
            if (id_unidad_medida == null) {
                id_unidad_medida = "";
            }
            opcion = request.getParameter("opcion");
            if (opcion == null) {
                opcion = "";
            }


        %>
    </head>
            <%@include file="registra_producto.jsp" %>
        <%     
        if (opcion.equals("Actualizar")) {
                Productos pro = new Productos();
                pro.setId_productos(id_productos);
                pro.setNombre(nombre);
                pro.setCantidad(cantidad);
                pro.setPrecio(precio);
                pro.setDescripcion(descripcion);
                pro.setId_categoria_prod(id_categoria);
                pro.setId_unidad_medida(id_unidad_medida);
                ProductosDao ac=new ProductosDaoImpl();
                if (ac.actualizarproducto(pro)) {
                   response.sendRedirect("producto_result.jsp?mensaje=Actualizo correctamente");
                } else {
                    out.print("No se pudo actualizar");
                }
            }
            if (opcion.equals("Registrar")) {
                Productos pro = new Productos();
                pro.setId_productos(id_productos);
                pro.setNombre(nombre);
                pro.setCantidad(cantidad);
                pro.setPrecio(precio);
                pro.setDescripcion(descripcion);
                pro.setId_categoria_prod(id_categoria);
                pro.setId_unidad_medida(id_unidad_medida);
                ProductosDao reg= new ProductosDaoImpl();
                if (reg.agregarproducto(pro)) {
                    response.sendRedirect("producto_result.jsp?mensaje=Registro correctamente");
                } else {
                    out.print("No se pudo registrar");
                }
            }
            
            if (opcion.equals("Eliminar")) {
                ProductosDao eli= new ProductosDaoImpl();
                Productos pro = new Productos();
                if (eli.eliminarproducto(id_productos)) {
                    response.sendRedirect("producto_result.jsp?mensaje=Eliminado correctamente");
                } else {
                    out.print("No se pudo eliminar porque se está usando");
                }
            }
        %>
    
        
   

