<%@page import="Entidad.Usuario"%>
<%@page import="DaoImpl.UsuarioDaoImpl"%>
<%@page import="Dao.UsuarioDao"%>
<%@include file="WEB-INF/fragmentos/topadm.jspf"%>

<style type="text/css">

</style>
<body background="imagen/06.jpg" background-repeat: no-repeat background-size: 100%>
<div  id="usuario" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">

        <div class="modal-header" style="padding:10px 40px;">
            <a href="adm.jsp"><button type="button" class="close" data-dismiss="modal">&times;</button></a>
          <h4><span class="glyphicon glyphicon-lock"></span> Registrar Usuario</h4>
        </div>

<div class="modal-body" style="padding:30px 40px;">    
        <form  action="agregarUsuarioAdd.jsp" action="controlcompra" method="post"> 
            <input type="hidden" name="opcion" value="RegistrarCompra">
                <table class="table table-condensed" >
                    
                    <tbody>

                           <div class="form-group">
                               <label for="exampleInputPassword1">ID USUARIO</label>
                            <input type="text" name="idusuario" class="form-control" id="exampleInputPassword1" placeholder="INGRESE ID USUARIO" >
                          </div>
                    
                          <div class="form-group">
                           <label for="exampleInputPassword1">USUARIO</label>
                           <input type="text" name="username" class="form-control" id="exampleInputPassword1" placeholder="INGRESE USUARIO">
                            </div>

                           <div class="form-group">
                            <label for="exampleInputPassword1">PASSWORD</label>
                            <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="INGRESE PASSWORD">
                          </div>
                          

                    
                            <tr>
                                <td ><label class="col-sm-12 control-label">ROL</label></td>
                                <td >
                                    <select class="form-control" name="ROL" selected="selected">
                                            <option value="1">Seleccionar Rol</option>
                                            <option>Administrador</option>
                                            <option>Secretaria</option>
                                    </select>
                                </td>
                        </tr>
 
                <div class="form-group">
                <ul class="dropdown-menu" role="menu">
                <li><a href="">Administrador</a></li>
                <li><a href="">Secretaria</a></li>
                </ul>
                </div>                       
                    
                    
                   
                        <tr>
                          <td colspan="2" align="center">
                        
                        <input type="submit" class="btn btn-primary" value="Registrar">
                        <input type="reset" class="btn btn-default" value="Cancelar">
                        
                        </td> 
                        </tr>      
                             
                    </tbody>
            </table>
        </form>
      </div>
        </div>
      </div>
      </div>
<%
    String mensaje = request.getParameter("m");
    mensaje = request.getParameter("m")==null?"":mensaje;
    if(mensaje.equals("1")){
        out.print("Se inserto Corretamente.");
    }
    if(mensaje.equals("0")){
        out.print("Ocurrio un Error.");
    }
 
%>
<%@include file="WEB-INF/fragmentos/bottom.jspf"%>



