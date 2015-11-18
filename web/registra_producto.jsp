<%@page import="Beans.Unidad_medida"%>
<%@page import="DaoImpl.Unidad_medidaDaoImpl"%>
<%@page import="Dao.Unidad_medidaDao"%>
<%@page import="Beans.Categoria_Producto"%>
<%@page import="DaoImpl.Categoria_ProductoDaoImpl"%>
<%@page import="Dao.Categoria_ProductoDao"%>
<%@page import="Beans.Productos"%>
<%@page import="DaoImpl.ProductosDaoImpl"%>
<%@page import="Dao.ProductosDao"%>
<%@include file="WEB-INF/fragmentos/topadm.jspf"%>



<div class="botonMenu">
    <a href="#" class="btn btn-info btn-sm" data-toggle="modal" data-target="#producto">
        <span class="" aria-hidden=true></span>
        Registrar Producto</a>

</div>

<div class="modal fade" id="producto" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">

            <div class="modal-header" style="padding:35px 50px;">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4><span class="glyphicon glyphicon-lock"></span>Registrar Producto</h4>
            </div>

            <div class="modal-body" style="padding:40px 50px;">    

                <form action="ProductoAdd.jsp" method="post"> 
                    <input type="hidden" name="opcion" value="Registrar">
                    <table class="table table-condensed">
                        <tbody>


                        <div class="form-group">
                            <label for="exampleInputPassword1" size="30">NOMBRE PRODUCTO</label>
                            <input type="text" class="form-control" placeholder="INGRESE NOMBRE" name="nombre">
                        </div>
                        <tr>
                        <div class="form-group">
                            <label for="exampleInputPassword1">CANTIDAD</label>
                            <input type="number" class="form-control" id="exampleInputPassword1" placeholder="INGRESE CANTIDAD" name="cantidad">
                        </div>
                        </tr>

                        <tr>
                        <div class="form-group">
                            <label for="exampleInputPassword1">PRECIO</label>
                            <input type="number" class="form-control" id="exampleInputPassword1" placeholder="INGRESE PRECIO" name="precio">
                        </div>
                        </tr>
                        
                         <tr>
                        <div class="form-group">
                            <label for="exampleInputPassword1">DESCRIPCION</label>
                            <input type="text" class="form-control" id="exampleInputPassword1" placeholder="INGRESE DESCRIPCION" name="descripcion">
                        </div>
                        </tr>
                        
                        <tr>
                            <td><label class="col-sm-12 control-label">CATEGORIA:</label></td>
                            <td>
                                <select class="form-control" name="categoria" selected="selected">
                                    <option value="1">Selecciona</option>
                                        
                                    <% Categoria_ProductoDao cap = new Categoria_ProductoDaoImpl();
                                           for(Categoria_Producto cat: cap.listaCategoria()){ 
                                               
                                        %>
                                        
                                      <option value="<%=cat.getId_categoria_producto()%>" > <%=cat.getNombre_categoria()%></option>
                                         <%}%> 

                                </select>
                            </td>
                        </tr> 


                        <tr>
                            <td><label class="col-sm-12 control-label">UNIDAD MEDIDA:</label></td>
                            <td>
                                <select class="form-control" name="um" selected="selected">
                                    <option value="1">Selecciona</option>

                                    <% Unidad_medidaDao um = new Unidad_medidaDaoImpl();
                                           for(Unidad_medida unime: um.lista_Unidad_medidad()){ 
                                               
                                        %>
                                        
                                      <option value="<%=unime.getId_unidad_medida()%>" > <%=unime.getNombre_uni()%></option>
                                         <%}%> 

                                </select>
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


<style type="text/css">
</style>
<body background="imagen/06.jpg" background-repeat: no-repeat background-size: 100%>
      <% ProductosDao dao = new ProductosDaoImpl();%>
      <% Productos prod = new Productos();%>

      <div  id="usuario" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">

        <div class="container"  style="padding:10px 40px;">

                <section class="table">

                </section>

                <input type="hidden" name="opcion" value="Registrar">
                <table class="table table-bordered table-hover modal-content">


                    <tbody> 
                    <thead> 
                        <tr class="active info">

                            <th class="text-center">ID</th>
                            <th class="text-center">Nombre</th>
                            <th class="text-center">Precio</th>
                            <th class="text-center">Cantidad</th>
                            <th class="text-center">Categoria</th>
                            <th class="text-center">Unidad_Medida</th>
                            <th class="text-center">Descripcion</th>
                            <th colspan="2" class="text-center" name="opcion">Opcion</th>
                        </tr>
                        <%
                            for (Productos pro : dao.listarproductos()) {
                                
                        %>

                        <tr class="text-center">
                            <td><%=pro.getId_productos()%></td>
                            <td><%=pro.getNombre()%></td>
                            <td><%=pro.getPrecio()%></td>
                            <td><%=pro.getCantidad()%></td>
                            <td><%=pro.getId_categoria_prod()%></td>
                            <td><%=pro.getId_unidad_medida()%></td>
                            <td><%=pro.getDescripcion()%></td>
                            <td><a href="ProductoAdd.jsp?id_productos=<%=prod.getId_productos()%>&opcion=Actualizar">EDITAR</a></td>
                            <td><a href="ProductoAdd.jsp?id_productos=<%=prod.getId_productos()%>&opcion=Eliminar">ELIMINAR</a></td>
                            <%}%>
                    </thead>
                    </tbody>

                </table>


        </div>
    </div>
    <nav align="center">
        <ul  class= "pagination" > 
            <li> 
                <a  href= "#"  aria-label= "Previous" > 
                    <span  aria-hidden= "true" > « </span> 
                </a> 
            </li> 
            <li><a  href= "#" > 1 </a></li> 
            <li><a  href= "#" > 2 </a></li> 
            <li><a  href= "#" > 3 </a></li> 
            <li><a  href= "#" > 4 </a></li> 
            <li><a  href= "#" > 5 </a></li> 
            <li> 
                <a  href= "#"  aria-label= "Next" > 
                    <span  aria-hidden= "true" > » </span> 
                </a> 
            </li> 
        </ul>
    </nav>



    <%@include file="WEB-INF/fragmentos/bottom.jspf"%>