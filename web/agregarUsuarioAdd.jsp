

<%@page import="Beans.Usuario"%>
<%@page import="DaoImpl.UsuarioDaoImpl"%>
<%@page import="Dao.UsuarioDao"%>
<%
    int idusuario = Integer.parseInt(request.getParameter("idusuario"));
    String usuario = request.getParameter("username");
    String contrase�a = request.getParameter("password");
    String rol = request.getParameter("rol");
    String mensaje = "";
    
    UsuarioDao dao = new UsuarioDaoImpl();
    Usuario u = new Usuario();
    u.setId_usuario(idusuario);
    u.setUsuario(usuario);
    u.setContrase�a(contrase�a);
    u.setRol(rol);
    
    if(dao.agregarUsuario(u)){
        mensaje = "1";
    }else{
        mensaje = "0";
    }
    response.sendRedirect("agregarUsuario.jsp?m="+mensaje);
%>