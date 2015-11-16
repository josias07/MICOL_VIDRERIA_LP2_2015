

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

<div class="modal fade" id="reee" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">

        
        <div class="modal-header" style="padding:35px 50px;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4><span class="glyphicon glyphicon-lock"></span> Registrar Compra</h4>
        </div>
        
        <div class="modal-body" style="padding:40px 50px;">    
        <form action="#" method="post"> 
            <input type="hidden" name="opcion" value="RegistrarCompra">
                <table class="table table-condensed">
                    <tbody>
                        
                            <tr>
                                <td><label class="col-sm-12 control-label">NOMBRE PRODUCTO:</label></td>
                                <td>
                                    <select  class="form-control" name="producto" selected="selected">
                                        <option value="2"> Selecciona producto </option>

                                        <% ProductosDao pro = new ProductosDaoImpl();
                                           for(Productos productos: pro.listarproductos()){ 
                                           
                                        %>
                                        
                                         <option value="<%=productos.getId_productos()%>"> <%=productos.getNombre()%></option>
                                         <%}%> 

                                    </select>
                                </td>
                            </tr>           
           

                          <tr>
                          <div class="form-group">
                           <label for="exampleInputPassword1">PRECIO UNITARIO</label>
                           <input type="text" class="form-control" id="exampleInputPassword1" placeholder="INGRESE PRECIO" value="">
                            </div>
                         </tr>
                        <tr>
                           <div class="form-group">
                            <label for="exampleInputPassword1">CANTIDAD</label>
                            <input type="text" class="form-control" id="exampleInputPassword1" placeholder="INGRESE CANTIDAD"  value="">
                          </div>
                        </tr>
                        
                        
                         <tr>
                           <div class="form-group">
                            <label for="exampleInputPassword1">IMPORTE</label>
                            <input type="text" class="form-control" id="exampleInputPassword1" placeholder="IMPORTE" value="">
                          </div>
                        </tr> 

                        <tr>
                    <td><label class="col-sm-12 control-label" >Descripcion:</label></td>
                    <td colspan="3">
                        <div class="col-sm-15">
                            <textarea rows="3" class="form-control" placeholder="Descripcción" name="descripcion" value="" maxlength="200"></textarea>
                        </div>
                    </td>
                </tr>

                          

                        <tr></tr> 
                        <tr></tr>
                                    
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" class="btn btn-primary" value="Registrar">
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

        

<%@include file="WEB-INF/fragmentos/bottom.jspf"%>