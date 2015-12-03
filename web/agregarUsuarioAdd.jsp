

<%@page import="Beans.Usuario"%>
<%@page import="DaoImpl.UsuarioDaoImpl"%>
<%@page import="Dao.UsuarioDao"%>

       <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
                      <title>Formulario Producto</title>
        <%!
            String id_usuario, usuario, contraseña, rol, estado, opcion;
        %>

        <%
            id_usuario = request.getParameter("id_usuario");
            if (id_usuario == null) {
                id_usuario = "";
            }

            usuario = request.getParameter("usuario");
            if (usuario == null) {
                usuario = "";
            }

            contraseña = request.getParameter("contraseña");
            if (contraseña == null) {
                contraseña = "";
            }

            rol = request.getParameter("rol");
            if (rol == null) {
                rol = "";
            }

            estado = request.getParameter("estado");
            if (estado == null) {
                estado = "";
            }

            opcion = request.getParameter("opcion");
            if (opcion == null) {
                opcion = "";
            }


        %>
    </head>
            <%@include file="agregarUsuario.jsp" %>
        <%     
        if (opcion.equals("Actualizar")) {
                Usuario us = new Usuario();
                us.setId_usuario(id_usuario);
                us.setUsuario(usuario);
                us.setContraseña(contraseña);
                us.setEstado(estado);
                UsuarioDao dao = new UsuarioDaoImpl();
                if (dao.actualizarUsuario(us)) {
                   response.sendRedirect("producto_result.jsp?mensaje=Actualizo correctamente");
                } else {
                    out.print("No se pudo actualizar");
                }
            }
            if (opcion.equals("Registrar")) {
                Usuario us = new Usuario();
                us.setId_usuario(id_usuario);
                us.setUsuario(usuario);
                us.setContraseña(contraseña);
                us.setRol(rol);
                us.setEstado("1");
                UsuarioDao da = new UsuarioDaoImpl();
                if (da.agregarUsuario(us)) {
                    response.sendRedirect("agregarUsuario.jsp");
                } else {
                    out.print("No se pudo registrar");
                }
            }
            
            if (opcion.equals("Eliminar")) {
                UsuarioDao eli = new UsuarioDaoImpl();
                 Usuario us = new Usuario();
                if (eli.eliminarUsuario(id_usuario)) {
                    response.sendRedirect("producto_result.jsp?mensaje=Eliminado correctamente");
                } else {
                    out.print("No se pudo eliminar porque se está usando");
                }
            }
        %>
%>