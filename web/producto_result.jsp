<%-- 
    Document   : producto_result
    Created on : 25-nov-2015, 19:58:24
    Author     : George Manya
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Productos</title>
        <%!
            String mensaje;
        %>
        <%
            mensaje = request.getParameter("mensaje");
            if (mensaje == null) {
                mensaje = "";
            }

        %>
    </head>
    <body>
     <%@include file="WEB-INF/fragmentos/topadm.jspf"%>
    <center>Resultado</center>
    <META HTTP-EQUIV="Refresh" CONTENT="2;URL=registra_producto.jsp"/>
    <table align="center">
        <tr>
            <td align="center">
                <img src="img/bien.png"/>
            </td>
        </tr>
        <tr>
            <td align="center"><%=mensaje%></td>
        </tr>
    </table>
</body>
</html>
