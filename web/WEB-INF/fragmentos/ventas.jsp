<%@page import="Beans.Detalle_venta"%>
<%@page import="Beans.Venta"%>
<%@page import="DaoImpl.VentaDaoImpl"%>
<%@page import="Dao.VentaDao"%>
<%@page import="Beans.Productos"%>
<%@page import="Beans.Proveedor"%>
<%@page import="DaoImpl.ProveedorDaoImpl"%>
<%@page import="Dao.ProveedorDao"%>
<%@page import="Beans.Productos"%>
<%@page import="DaoImpl.ProductosDaoImpl"%>
<%@page import="Dao.ProductosDao"%>
<%@page import="Beans.Compra"%>
<%@page import="DaoImpl.CompraDaoImpl"%>
<%@page import="Dao.CompraDao"%>
<%@include file="WEB-INF/fragmentos/topadm.jspf"%>
<style>
    #table {
        border-collapse: separate;
        border-spacing:  10px;
    }


</style>
<%!
    String id_venta, fecha_venta, comprobante, serie, igv, descuento, id_cliente, id_usuario, id_detalle_venta,
            descripcion, cantidad, precio_unitario, importe, buscar, limit, id_productos, opcion;

    ;
%>

<%    id_venta = request.getParameter("id_venta");
    if (id_venta == null) {
        id_venta = "";
    }

    fecha_venta = request.getParameter("fecha_venta");
    if (fecha_venta == null) {
        fecha_venta = "";
    }

    cantidad = request.getParameter("cantidad");
    if (cantidad == null) {
        cantidad = "";
    }

    comprobante = request.getParameter("comprobante");
    if (comprobante == null) {
        comprobante = "";
    }

    serie = request.getParameter("serie");
    if (serie == null) {
        serie = "";
    }

    igv = request.getParameter("igv");
    if (igv == null) {
        igv = "";
    }

    descuento = request.getParameter("descuento");
    if (descuento == null) {
        descuento = "";
    }

    id_cliente = request.getParameter("id_cliente");
    if (id_cliente == null) {
        id_cliente = "";
    }

    id_usuario = request.getParameter("id_usuario");
    if (id_usuario == null) {
        id_usuario = "";
    }

    id_detalle_venta = request.getParameter("id_detalle_venta");
    if (id_detalle_venta == null) {
        id_detalle_venta = "";
    }

    descripcion = request.getParameter(" descripcion");
    if (descripcion == null) {
        descripcion = "";
    }

    precio_unitario = request.getParameter("precio_unitario");
    if (precio_unitario == null) {
        precio_unitario = "";
    }

    importe = request.getParameter("serie");
    if (importe == null) {
        importe = "";
    }


%>

<%            buscar = request.getParameter("buscar");
    if (buscar == null) {
        buscar = "";
    }
    limit = request.getParameter("limit");
    if (limit == null) {
        limit = "";
    }
    id_venta = request.getParameter("id_venta");
    if (id_venta == null) {
        id_venta = "";
    }
    id_productos = request.getParameter("id_productos");
    if (id_productos == null) {
        id_productos = "";
    }
    opcion = request.getParameter("opcion");
    if (opcion == null) {
        opcion = "";
    }
    if (limit.equals("")) {
        limit = "5";
    }

%>

<%    if (opcion.equals("Registrar")) {
        if (id_venta.equals("")) {
            VentaDao dao = new VentaDaoImpl();
            Venta venta = new Venta();
            Detalle_venta deta = new Detalle_venta();

            venta.setId_venta(id_venta);
            venta.setFecha_venta(fecha_venta);
            venta.setComprobante(comprobante);
            venta.setSerie(serie);
            venta.setIgv(igv);
            venta.setDescuento(descuento);
            venta.setId_cliente(id_cliente);
            venta.setId_usuario("1");
            deta.setId_detalle_venta(id_detalle_venta);
            deta.setDescripcion(descripcion);
            deta.setCantidad(cantidad);
            deta.setPrecio_unitario(precio_unitario);
            deta.setImporte(importe);
            deta.setId_productos(id_productos);
            id_venta = dao.REGISTRAR_VENTA(venta, deta);
            out.println("Registro correctamente"+id_venta);
        } else {
            VentaDao dao = new VentaDaoImpl();
            Detalle_venta deta = new Detalle_venta();
            deta.setId_venta(id_venta);
            deta.setDescripcion(descripcion);
            deta.setCantidad(cantidad);
            deta.setPrecio_unitario(precio_unitario);
            deta.setImporte(importe);
            deta.setId_productos(id_productos);
            dao.agregar_detalleventa(deta);
        }
    }

    VentaDao dao = new VentaDaoImpl();
    Venta venta = new Venta();
    Detalle_venta deta = new Detalle_venta();
    // dao.REGISTRAR_VENTA(venta, deta);
    ProductosDao daoPro = new ProductosDaoImpl();
    Productos prod = daoPro.DatosProductos(id_productos);


%>

<input action="AddVenta" method="post" type="hidden" name="opcion" value="Registrar">

<table border="2px" width="100%" height="350px" id="table"> <!-- Lo cambiaremos por CSS -->
    <tr>
        <td valign="baseline" width="30%" height="300px" style="border: hidden">

            <%

               venta = dao.Datos_entrada(id_venta);
            %>

            <div class="col-lg-5" >
                <div class="form-group">
                    <label for="exampleInputPassword1">FECHA: </label>
                    <%=venta.getFecha_venta()%>
                </div>
            </div>
            <div class="col-lg-5" >
                <div class="form-group">
                    <label for="exampleInputPassword1">SERIE: </label>
                    <%=venta.getSerie()%>
                </div>
            </div>
            <div class="col-lg-6" >
                <div class="form-group">
                    <label for="exampleInputPassword1">COMPROBANTE: </label>
                    <%=venta.getComprobante()%>
                </div>
            </div>
            <div class="col-lg-5" >
                <div class="form-group">
                    <label for="exampleInputPassword1">PRODUCTO: </label> 
                    <%=venta.getNombre_producto()%>
                </div>
            </div>
        </td>

        <td  valign="baseline" width="30%" height="300px" style="border: hidden">
            <form name="detalle_venta" action="ventas.jsp" method="post">
                <input type="hidden" name="id_venta" value="<%=id_venta%>"/>
                <input type="hidden" name="id_productos" value="<%=id_productos%>"/>
                <div class="col-lg-5" >
                    <div class="form-group">
                        <label for="exampleInputPassword1">CANTIDAD: </label>  
                        <input  type="text" name="cantidad" size="10" value="1">
                    </div>
                </div>
                <div class="col-lg-5" >
                    <div class="form-group">
                        <label for="exampleInputPassword1">PRECIO: </label> 
                        <input  type="text" name="precio_unitario" size="10" value="<%=venta.getPrecio()%>">
                    </div>
                </div>
                <div class="col-lg-5" >
                    <div class="form-group">
                        <label for="exampleInputPassword1">DESCUENTO: </label>
                        <input  type="text" name="descuento" size="15" value="<%=venta.getDescuento()%>">
                    </div>
                </div>

                <p align="left"><input  type="submit" name="opcion" value="Registrar" class="btn btn-primary"></p>
            </form>
        </td>
        <td rowspan="3"  valign="baseline" style="border: hidden">
            <form name="buscar" method="post" action="ventas.jsp">
                <div class="input-group">
                    <input type="text" class="form-control" name="buscar" value="<%=buscar%>" placeholder="Buscar">

                    <span class="input-group-btn">
                        <input type="submit" value="Buscar" class="btn btn-primary" >Buscar/>
                    </span>
                </div>
            </form>
            <div class="table-responsive">
                <table class="table table-bordered table-hover table-condensed">
                    <tr class="active info">
                        <th class="text-center">#ID</th>
                        <th class="text-center">NOMBRE</th>
                        <th class="text-center">PRECIO</th>
                        <th class="text-center" colspan="1">ACCIONES</th>
                    </tr>
                    <% int i = 0;
                        ProductosDao da = new ProductosDaoImpl();
                        for (Productos productos : da.listarproductos(buscar, limit)) {
                            i = i + 1;
                    %>
                    <tr class="text-center">
                        <td><%=i%></td>
                        <td><%=productos.getNombre()%></td>
                        <td><%=productos.getPrecio()%></td>
                        <td><a href="ventas.jsp?id_venta=<%=id_venta%>&id_productos=<%=productos.getId_productos()%>&opcion=Nuevo">AGREGAR</a></td>

                    </tr>
                    <%}%>                            
                </table>
            </div>
        </td>
    </tr>

</table>
<!--div class="botonMenu">
    <a href="inicio.jsp" class="btn btn-info btn-sm" data-toggle="modal" data-target="#producto">
        <span class="" aria-hidden=true></span>
        Registrar Producto</a>

</div-->
<!--td colspan="2" align="center">
    <input type="submit" class="btn btn-primary" value="Registrar">
    <input type="reset" class="btn btn-default" value="Limpiar">
    <button type="button" class="btn btn-default" data-dismiss="modal">CERRAR</button> 
</td--> 
<br>
<br>                               

<!--div class="container" >
    <div clsa="row">
        <div class="col-lg-20"> 
            <div clsa="row">
                <div class="col-lg-20">          
                    <div class="table-responsive">
                        <table class="table table-bordered table-hover">
                            <tr class="active info">
                                <th class="text-center">PRODUCTO</th>
                                <th class="text-center">PRECIO</th>
                                <th class="text-center">CANTIDAD</th>
                                <th class="text-center">IGV</th>
                                <th class="text-center">DESCUENTO</th>
                                <th class="text-center">SUBTOTAL</th>
                                <th colspan="2"class="text-center">OPCIONES</th>
                            </tr>

                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div-->            

<script type="text/javascript">
    document.buscar.limit.value = '<%=limit%>';
</script>
</body>

<div class="modal fade" id="reg_persona" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">

            <div class="modal-header" style="padding:35px 50px;">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4><span class="glyphicon glyphicon-lock"></span>Registrar Persona</h4>
            </div>

            <div class="modal-body" style="padding:40px 50px;">    

                <form action="AddPersona.jsp" method="post"> 
                    <input type="hidden" name="opcion" value="Registrar">
                    <table class="table table-condensed">
                        <tbody>


                        <div class="form-group">
                            <label for="exampleInputPassword1" size="30">NOMBRE PERSONA:</label>
                            <input type="text" class="form-control" placeholder="INGRESE NOMBRE" name="nombre">
                        </div>
                        <tr>
                        <div class="form-group">
                            <label for="exampleInputPassword1">APELLIDO PATERNO</label>
                            <input type="text" class="form-control" id="exampleInputPassword1" placeholder="INGRESE APELLIDO" name="apepat">
                        </div>
                        </tr>

                        <tr>
                        <div class="form-group">
                            <label for="exampleInputPassword1">APELLIDO MATERNO:</label>
                            <input type="text" class="form-control" id="exampleInputPassword1" placeholder="INGRESE APELLIDO" name="apemat">
                        </div>
                        </tr>


                        <tr>
                            <td> <label> SEXO </label> </td>
                            <td>
                                <input type="radio" name="sexo" value="M" /> Masculino
                                <input type="radio" name="sexo" value="F" /> Femenino 
                            </td>
                        </tr>



                        <tr>
                        <div class="form-group">
                            <label for="exampleInputPassword1">DNI:</label>
                            <input type="text"  maxlength="10" class="form-control" id="exampleInputPassword1" placeholder="INGRESE DNI" name="dni">
                        </div>
                        </tr>
                        <tr>
                        <div class="form-group">
                            <label for="exampleInputPassword1">CELULAR:</label>
                            <input maxlength="9" type="text" class="form-control" id="exampleInputPassword1" placeholder="INGRESE CELULAR" name="celular">
                        </div>
                        </tr>
                        <tr>
                        <div class="form-group">
                            <label for="exampleInputPassword1">DIRECCION:</label>
                            <input type="text" class="form-control" id="exampleInputPassword1" placeholder="INGRESE DIRECCION" name="direccion">
                        </div>
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