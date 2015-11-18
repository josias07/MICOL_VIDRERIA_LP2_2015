

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
<jsp:useBean id="igv" scope="request" class="java.lang.String" />
<jsp:useBean id="descuento" scope="request" class="java.lang.String" />
<jsp:useBean id="alert" scope="request" class="java.lang.String" />
<jsp:useBean id="Compra" scope="request" class="Beans.Compra" />
<jsp:useBean id="registrar" scope="request" class="java.lang.String" />
<%
   if (registrar==null ||registrar.equals("")){registrar="Registrar";}
    
%>


  <form action="Detalle_Compra.jsp" method="post"> 
 <div class="container">
  <div class="table-responsive">
    <table class="table table-bordered">
     <tbody>
          
   
                            <div class="form-group">
                           <label for="exampleInputPassword1" size="30">FECHA</label>
                           <input type="date" class="form-control" placeholder="INGRESE FECHA"value="<%=fecha%>">
                            </div>
                          <tr>
                          <div class="form-group">
                           <label for="exampleInputPassword1">COMPROBANTE</label>
                           <select class="form-control" name="ROL" selected="selected">   
                           <option value="1">Selecciona Comprobante</option>
                               <option value="1">Factura</option>
                                <option value="1">Boleta</option>
                                 </select>
                           </div>
                           
                         </tr>
                         
                          <tr>
                          <div class="form-group">
                           <label for="exampleInputPassword1">SERIE</label>
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
                        <input type="submit" class="btn btn-primary" value="Continuar"  data-toggle="modal">
                        <input type="reset" class="btn btn-default" value="Limpiar">
                        <button type="button" class="btn btn-default" data-dismiss="modal">CERRAR</button> 
                    </td> 
                </tr>     
                
       
                        </div>      
                         </tbody>

        </table>
  </div>
  
</div>
   </form>      
      

<%@include file="WEB-INF/fragmentos/bottom.jspf"%>