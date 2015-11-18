<%@page import="Beans.Usuario"%>
<%@page import="DaoImpl.UsuarioDaoImpl"%>
<%@page import="Dao.UsuarioDao"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximun-scale=1.0, minimum-scale=1.0">
	<title>Logeo</title>
  <link rel="shortcut icon" href="imagen/001.jpg">
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="estilos/menu.css">

</head>
<style type="text/css"></style>
    <body background="imagen/12.jpg" background-repeat: no-repeat background-size: 100%>
           
        
   
   
    <header >
        
    </header>

        <div class="container">
    		<p><br/></p>
  		<div class="row">
  			<div class="col-md-4"></div>
  			<div class="col-md-4">
  				<div class="panel panel-default">
  				<div class="panel-body">
    				<div class="page-header">
                                    <h3 align="center" >Iniciar Secion</h3>
				</div>
                                <form role="form" method="post" action="logeo.jsp">
  					<div class="form-group">
    					<label for="exampleInputEmail1">Correo o Usuario</label>
    					<div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                                            <input type="text" name="usuario" class="form-control" placeholder="Usuario">                                             
  					</div>
  					<div class="form-group">
                                        <label for="exampleInputPassword1">Contrase&ntilde;a</label>
    					<div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-star"></span></span>
                                            <input type="password" name="contraseña" class="form-control" id="exampleInputPassword1" placeholder="Password">
					</div>
  					</div>
  				<div class="form-group">
  								
  				<div class="checkbox">
                                    <label>
                                        <input type="checkbox">Recordar Contrase&ntilde;a
                                    </label>
                                </div>
                                    <br>
                                <button  type="submit" class="btn btn-lg btn-primary btn-block" role="toolbar">Sign in</button>
                                <br/>
                            <%
         String usuario = request.getParameter("usuario");
         String contraseña = request.getParameter("contraseña");
         String salir = request.getParameter("salir");
         salir = request.getParameter("salir")== null ? salir="":salir;
                 
         
         if(usuario != null & contraseña != null){
             UsuarioDao dao = new UsuarioDaoImpl();
             Usuario u = new Usuario();
             u = dao.validarUsuario(usuario, contraseña);
             if (u.getUsuario() != null){
                 session.setAttribute("usuario", u.getUsuario());
                 
                 if(u.getRol().equals("administrador")){
                     response.sendRedirect("adm.jsp");
                 }
                 if(u.getRol().equals("secretaria")){
                     response.sendRedirect("sec.jsp");
                 }
                 
             }else{
                 out.print("<div class='alert-danger'>No existe en la bd</div>");
             }
         }
         
         if(salir.equals("cerrar")){
             session.removeAttribute("usuario");
         }
     %>     
  				</div> 							
				</form>
                                </div>
				</div>
  			</div>
		</div>
    </div>
</div>  
<script type="text/javascript" src="jquery/jquery-2.1.4.min.js"></script>

	<script type="text/javascript" src="bootstrap/js/bootstrap.min.jsjavascript"></script>
</body>
</html>