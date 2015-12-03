<%@page import="Beans.Productos"%>
<%@page import="Beans.Categoria_Producto"%>
<%@page import="Beans.Unidad_medida"%>
<%@page import="Dao.ProductosDao"%>
<%@page import="Dao.Unidad_medidaDao"%>
<%@page import="Dao.Categoria_ProductoDao"%>
<%@page import="DaoImpl.ProductosDaoImpl"%>
<%@page import="DaoImpl.Unidad_medidaDaoImpl"%>
<%@page import="DaoImpl.Categoria_ProductoDaoImpl"%>

<%@include file="WEB-INF/fragmentos/topadm.jspf"%>
<script type="text/javascript" src="js_ajaxper/funcionajax.js"></script>
<script type="text/javascript" src="js_ajaxper/jquery-1.2.1.pack.js"></script>
<script type="text/javascript" src="js_ajaxper/eventos.js"></script>
<script type="text/javascript" src="js_ajaxper/funciones.js"></script>

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

                <form action="AddProducto.jsp" method="post"> 
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
                                <select class="form-control" name="id_categoria" selected="selected">
                                    <option value="1">Selecciona</option>

                                    <% Categoria_ProductoDao cap = new Categoria_ProductoDaoImpl();
                                        for (Categoria_Producto cat : cap.listaCategoria()) {

                                    %>

                                    <option value="<%=cat.getId_categoria_producto()%>" > <%=cat.getNombre_categoria()%></option>
                                    <%}%> 

                                </select>
                            </td>
                        </tr> 


                        <tr>
                            <td><label class="col-sm-12 control-label">UNIDAD MEDIDA:</label></td>
                            <td>
                                <select class="form-control" name="id_unidad_medida" selected="selected">
                                    <option value="1">Selecciona</option>

                                    <% Unidad_medidaDao um = new Unidad_medidaDaoImpl();
                                        for (Unidad_medida unime : um.lista_unidad_medidad()) {

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
<div class="modal fade" id="editar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">     

    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header" style="padding:35px 50px;">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4><span class="glyphicon glyphicon-lock"></span>Actualizar Producto</h4>
            </div>

            <div class="modal-body" style="padding:40px 50px;">  
                <div id="producto_resul"></div>
            </div>
        </div>
    </div>
</div>

<%!
    String buscar, limit;
%>
<%            buscar = request.getParameter("buscar");
    if (buscar == null) {
        buscar = "";
    }
    limit = request.getParameter("limit");
    if (limit == null) {
        limit = "";
    }
    if (limit.equals("")) {
        limit = "10";
    }

%>

<form name="buscar" method="post" action="registra_producto.jsp">
    <table align="center" width="100%">
        <tr>
            <td align="right">
                <input type="text" name="buscar" value="<%=buscar%>" placeholder="Buscar" size="15"/>
                <select name="limit" onchange="document.buscar.submit()">
                    <option value="10">10</option>
                    <option value="25">25</option>
                    <option value="50">50</option>
                    <option value="100">100</option>
                    <option value="200">200</option>
                    <option value="500">500</option>
                </select>
                <input type="submit" name="" value="Buscar" class="btn btn-default"/>
            </td>
        </tr>
    </table>
</form>

<form action="AddProducto.jsp" method="post">
    <body background="imagen/06.jpg" background-repeat: no-repeat background-size: 100%>
          <% ProductosDao dao = new ProductosDaoImpl();%>
          <% Productos prod = new Productos();%>

          <div  id="usuario" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">

            <div class="container"  style="padding:10px 40px;">

                <section class="table">

                </section>

                <input type="hidden" name="opcion" value="">
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
                            <th colspan="2" class="text-center" name="opcon">Opcion</th>
                        </tr>
                        <%
                            int count=0;
                            for (Productos pro : dao.listarproductos(buscar, limit)) {
                             count=count+1;
                        %>

                        <tr class="text-center">
                            <td><%=count%></td>
                            <td><%=pro.getNombre()%></td>
                            <td><%=pro.getPrecio()%></td>
                            <td><%=pro.getCantidad()%></td>
                            <td><%=pro.getNombre_categoria()%></td> 
                            <td><%=pro.getNombre_medida()%></td>
                            <td><%=pro.getDescripcion()%></td>
                            <td><a href="javascript:void(0)" onclick="javascript:editar_producto('<%=pro.getId_productos()%>')"
                                   class="btn btn-info btn-sm" data-toggle="modal"
                                   data-target="#editar">EDITAR</a></td>

                            <td><a href="AddProducto.jsp?id_productos=<%=pro.getId_productos()%>&opcion=Eliminar">ELIMINAR</a></td>

                        </tr>    
                        <%}%>

                    </thead>
                    </tbody>

                </table>


            </div>
        </div>

</form> 
    <script type="text/javascript">
        document.buscar.limit.value='<%=limit%>';
        </script>
<script type="text/javascript">
    function editar_producto(id_producto)
    {
        $("#producto_resul").hide("slow");
        $("#producto_resul").load("form_producto.jsp?id_productos=" + id_producto, "", function () {
            $("#producto_resul").show("slow");
        });
    }
</script>

<script type="text/javascript">
    /* Buscar reporte - informe....
     $(document).ready(function () {
     $("#producto_resul").load("hola.jsp", "", function () {
     $("#producto_resul").show("slow");
     });
     });*/
</script>
<%@include file="WEB-INF/fragmentos/bottom.jspf"%>