

<%@include file="WEB-INF/fragmentos/topadm.jspf"%>
<%@page import="Beans.Proveedor"%>
<%@page import="DaoImpl.ProveedorDaoImpl"%>
<%@page import="Dao.ProveedorDao"%>
<%@page import="Beans.Productos"%>
<%@page import="DaoImpl.ProductosDaoImpl"%>
<%@page import="Dao.ProductosDao"%>
<%@page import="Beans.Compra"%>
<%@page import="DaoImpl.CompraDaoImpl"%>
<%@page import="Dao.CompraDao"%>

<jsp:useBean id="mensaje" scope="request" class="java.lang.String" />
<jsp:useBean id="serie_factura" scope="request" class="java.lang.String" />
<jsp:useBean id="fecha" scope="request" class="java.lang.String" />
<jsp:useBean id="subtotal" scope="request" class="java.lang.String" />
<jsp:useBean id="igv" scope="request" class="java.lang.String" />
<jsp:useBean id="descuento" scope="request" class="java.lang.String" />
<jsp:useBean id="total" scope="request" class="java.lang.String" />
<jsp:useBean id="alert" scope="request" class="java.lang.String" />
<jsp:useBean id="hora" scope="request" class="java.lang.String" />
<jsp:useBean id="Compra" scope="request" class="Beans.Compra" />
<jsp:useBean id="registrar" scope="request" class="java.lang.String" />
<%
   if (registrar==null ||registrar.equals("")){registrar="Registrar";}
    
%>
<div class="botonMenu">
            <a href="#" class="btn btn-info btn-sm" data-toggle="modal" data-target="#compra">
            <span class="" aria-hidden=true></span>
             Realizar Compra</a>

</div>

<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-10" id="aler">
        <br>
        <%
            if(!mensaje.equals("")){
        %>
        <div class="alert alert-<%=alert%>"><%=mensaje%></div> 
        <%}%>
    </div>
    <div class="col-md-1"></div>
</div>


<div class="modal fade" id="compra" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">

        <div class="modal-header" style="padding:35px 50px;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4><span class="glyphicon glyphicon-lock"></span> Registrar Compra</h4>
        </div>
        
        <div class="modal-body" style="padding:40px 50px;">    
        <form action="Detalle_Compra.jsp" method="post"> 
            <input type="hidden" name="opcion" value="Registrar">
                <table class="table table-condensed">
                    <tbody>
                        <tr>
                            <div class="form-group">
                           <label for="exampleInputPassword1">FECHA</label>
                           <input type="date" class="form-control" placeholder="INGRESE FECHA"value="<%=fecha%>">
                           
                          <tr>
                          <div class="form-group">
                           <label for="exampleInputPassword1">SERIE FACTUURA</label>
                           <input type="text" class="form-control" id="exampleInputPassword1" placeholder="INGRESE SERIE" value="<%=serie_factura%>">
                            </div>
                         </tr>
                       
                           <div class="form-group">
                           <label for="exampleInputPassword1">DESCUENTO</label>
                           <input type="text" class="form-control" id="exampleInputPassword1" placeholder="INGRESE DESCUENTO" value="<%=descuento%>">
                            </div>
                        </tr>
                        <tr>
                           <div class="form-group">
                            <label for="exampleInputPassword1">IGV</label>
                            <input type="text" class="form-control" id="exampleInputPassword1" placeholder="INGRESE IGV" value="<%=igv%>">
                          </div>
                        </tr> 
                     

                        <tr>
                                <td><label class="col-sm-12 control-label">Proveedor:</label></td>
                                <td>
                                    <select class="form-control" name="proveedor" selected="selected">
                                        <option value="1">Selecciona Proveedor</option>

                                        <% ProveedorDao dao = new ProveedorDaoImpl();
                                           for(Proveedor proveedor: dao.listarProveedor()){ 
                                               
                                        %>
                                        
                                      <option value="<%=proveedor.getId_proveedor()%>" > <%=proveedor.getNombre()%></option>
                                         <%}%> 

                                    </select>
                                </td>
                        </tr>           
 
                        <tr></tr> 
                        <tr></tr>
                                    
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" class="btn btn-primary" value="Registrar"  data-toggle="modal">
                        <input type="reset" class="btn btn-default" value="Limpiar">
                        <button type="button" class="btn btn-default" data-dismiss="modal">CERRAR</button> 
                    </td> 
                </tr>     
                
         
                             
                         </tbody>
            </table>
        </form>
      </div>
  

     </div>
      </div>
      </div>

      <div class="container">
  <div class="table-responsive">
    <table class="table table-bordered table-hover">
      <tr class="active info">
        <th class="text-center">#ID</th>
        <th class="text-center">Nombre</th>
        <th class="text-center">Producto</th>
        <th class="text-center">Cantidad</th>
        <th class="text-center">Fecha</th>
        <th class="text-center">Precio Total</th>
        <th class="text-center">Acciones</th>
        
      </tr>
      <tr class="text-center">
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td><a><button class="btn-danger">Eliminar</button></a> <a><button class="btn-primary">Actualizar</button></a></td>
      </tr>
      <tr class="text-center">
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td><a><button class="btn-danger">Eliminar</button></a> <a><button class="btn-primary">Actualizar</button></a></td>
      </tr>

        </table>
  </div>
  
</div>
       
        

<%@include file="WEB-INF/fragmentos/bottom.jspf"%>