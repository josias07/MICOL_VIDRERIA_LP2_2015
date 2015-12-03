<%@page import="DaoImpl.Unidad_medidaDaoImpl"%>
<%@page import="Beans.Unidad_medida"%>
<%@page import="Dao.Unidad_medidaDao"%>
<%@page import="DaoImpl.Categoria_ProductoDaoImpl"%>
<%@page import="Beans.Categoria_Producto"%>
<%@page import="Dao.Categoria_ProductoDao"%>
<%@page import="DaoImpl.ProductosDaoImpl"%>
<%@page import="Beans.Productos"%>
<%@page import="Dao.ProductosDao"%>

<%!
    String id_productos;
%>
<%
    id_productos = request.getParameter("id_productos");
    if (id_productos == null) {
        id_productos = "";
    }
    if (!id_productos.equals("")) {
        ProductosDao dao = new ProductosDaoImpl();
        Productos pro = dao.DatosProductos(id_productos);
%>       



<form method="post" action="AddProducto.jsp" autocomplete="off" name="producto_edit">
    <input type="hidden" name="id_productos" value="<%=id_productos%>"/>
    <table class="table table-condensed">
        <tbody>


        <div class="form-group">
            <label for="exampleInputPassword1" size="30">NOMBRE PRODUCTO</label>
            <input type="text" class="form-control" placeholder="INGRESE NOMBRE" name="nombre" value="<%=pro.getNombre()%>">
        </div>
        <tr>
        <div class="form-group">
            <label for="exampleInputPassword1">CANTIDAD</label>
            <input type="number" class="form-control" id="exampleInputPassword1" placeholder="INGRESE CANTIDAD" name="cantidad" value="<%=pro.getCantidad()%>">
        </div>
        </tr>

        <tr>
        <div class="form-group">
            <label for="exampleInputPassword1">PRECIO</label>
            <input type="decimal" class="form-control" id="exampleInputPassword1" placeholder="INGRESE PRECIO" name="precio" value="<%=pro.getPrecio()%>">
        </div>
        </tr>

        <tr>
        <div class="form-group">
            <label for="exampleInputPassword1">DESCRIPCION</label>
            <input type="text" class="form-control" id="exampleInputPassword1" placeholder="INGRESE DESCRIPCION" name="descripcion" value="<%=pro.getDescripcion()%>">
        </div>
        </tr>

        <tr>
            <td><label class="col-sm-12 control-label">CATEGORIA:</label></td>
            <td>
                <select class="form-control" name="id_categoria" value="<%=pro.getId_categoria_prod()%>">
                    <option value="1">Selecciona</option>

                    <% Categoria_ProductoDao ca = new Categoria_ProductoDaoImpl();
                        for (Categoria_Producto cat : ca.listaCategoria()) {

                    %>

                    <option value="<%=cat.getId_categoria_producto()%>" > <%=cat.getNombre_categoria()%></option>
                    <%}%> 

                </select>
            </td>
        </tr> 


        <tr>
            <td><label class="col-sm-12 control-label">UNIDAD MEDIDA:</label></td>
            <td>
                <select class="form-control" name="id_unidad_medida" value="<%=pro.getId_unidad_medida()%>">
                    <option value="">Selecciona</option>

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
                <input type="submit" class="btn btn-primary" name="opcion" value="Actualizar">
                <button type="button" class="btn btn-default" data-dismiss="modal">CERRAR</button> 
            </td> 
        </tr>     

        </tbody>
    </table>
</form>    

<script type="text/javascript">
    document.producto_edit.id_unidad_medida.value = '<%=pro.getId_unidad_medida()%>';
    document.producto_edit.id_categoria.value = '<%=pro.getId_categoria_prod()%>';
</script>

<%}%>