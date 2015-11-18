

<%@page import="Beans.Productos"%>
<%@page import="DaoImpl.ProductosDaoImpl"%>
<%@page import="Dao.ProductosDao"%>



<%
    ProductosDao dao = new ProductosDaoImpl();
    Productos prod = new Productos();
    String nombre = request.getParameter("nombre");
    String cantidad = request.getParameter("cantidad");
    String precio = request.getParameter("precio");
    String descripcion = request.getParameter("descripcion");
    String categoria = request.getParameter("categoria");
    String um = request.getParameter("um");
    String id_productos = request.getParameter("id_productos");
    String opcion = request.getParameter("opcion");
    
    prod.setNombre(nombre);
    int cant = Integer.parseInt(cantidad);
    prod.setCantidad(cant);
    
    int pre = Integer.parseInt(precio);
    prod.setPrecio(pre);
    
    prod.setDescripcion(descripcion);
    
    int cat = Integer.parseInt(categoria);
    prod.setId_categoria_prod(cat);
    
    int unim = Integer.parseInt(um);
    prod.setId_unidad_medida(unim);
    
    if (dao.agregarproducto(prod)) {
        out.println( nombre + "  " + cantidad + " " + precio + " " + descripcion + " " + categoria + " " + um);
        out.println("SE AGREGO CORRECTAMENTE ");
        response.sendRedirect("registra_producto.jsp");
    } else {
        out.println("<center><h1>ERROR</h1></center> VALOR: ");
        out.println(nombre + "  " + cantidad + " " + precio + " " + descripcion + " " + categoria + " " + um);
    }
    

%>

<%    
    
    if (opcion.equals("actualizar")) {
        Productos pro = new Productos();
        pro.setId_productos(Integer.parseInt(id_productos));
        pro.setCantidad(Integer.parseInt(cantidad));
        pro.setPrecio(Integer.parseInt(precio));
        pro.setDescripcion(descripcion);
        pro.setId_categoria_prod(Integer.parseInt(categoria));
        pro.setId_unidad_medida(Integer.parseInt(um));
        
        ProductosDao produ = new ProductosDaoImpl();
        if (produ.actualizarproducto(pro)) {
            out.print("Actualizado correctamente");
            response.sendRedirect("registra_producto.jsp");
        } else {
            out.print("No se pudo actualizar");
        }
    }
    
    if (opcion.equals("Eliminar")) {
        ProductosDao proeli = new ProductosDaoImpl();
        if (proeli.eliminarproducto(Integer.parseInt(id_productos))) {
            out.print("Eliminado correctamente");
            response.sendRedirect("registra_producto.jsp");
        } else {
            out.print("No se pudo eliminar porque se está usando");
        }
    }
%>
