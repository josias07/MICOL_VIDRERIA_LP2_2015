<%@page import="Beans.Venta"%>
<%@page import="Dao.VentaDao"%>
<%@page import="DaoImpl.VentaDaoImpl"%>
<%@page import="Beans.Productos"%>

<%@include file="WEB-INF/fragmentos/topadm.jspf"%>

<% VentaDao dao = new VentaDaoImpl();%>
<% Productos prod = new Productos();%>

   <%!
            String buscar,fecha1,fecha2, limite;
   %>
        
        <%
            //List<Compra> listaCompra = new ArrayList<>();
            if(request.getParameter("fecha1")!=null & request.getParameter("fecha2")!=null){
                fecha1 = request.getParameter("fecha1");
                fecha2 = request.getParameter("fecha2");
                //out.print("FECHA1: "+fechaA+" FECHA2: "+fechaB);
                //listaCompra = dao.fechacompra(fecha1, fecha2);
            }
            
            
            buscar = request.getParameter("fecha1 ,fecha2");
            if (buscar == null) {
                buscar = "";
            }
            
        %>
       

<br><table class="container" width="100%" border="0px" id="tabla" border-radius="20px">
    <tbody><tr>
        <td>
            <div>
                <h1><strong class="glyphicon glyphicon-calendar"></strong>Reporte de Ventas</h1>
            </div>
        </td>
    </tr><tr>

    
    </tr><tr>
        <td>
            <div class="container">
                <div class="table-responsive">
                    <table class="table ">
                        <tbody><tr>
                            <td>
                                <form class="form-inline" name="buscar" method="post" action="rventas.jsp">

                                    <div class="form-group">
                                        <label for="exampleInputName2">DESDE</label>
                                        <input type="DATE" name="fecha1" value="2015-12-02 " class="form-control" id="exampleInputName2" placeholder="FECHA">
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputName2">HASTA</label>
                                        <input type="date" name="fecha2" value="2015-12-03 class=" form-control="" id="exampleInputEmail2" placeholder="FECHA">
                                    </div>
                                    <button type="submit" name="" value="Buscar" class="btn btn-info">BUSCAR</button>
                                </form>
                            </td> 
                        </tr>
                    </tbody></table>
                </div>
            </div>
        </td>
    </tr>

 <tr>
        <td>
            <div class="container" >
                <div clsa="row">
                    <div class="col-lg-20"> 
                        <div clsa="row">
                            <div class="col-lg-20">          
                                <div class="table-responsive">
                                    <table class="table table-bordered table-hover">


                                        <tbody> 
                                        <thead> 
                                            <tr class="active info">

                                                <th class="text-center">ID</th>
                                                <th class="text-center">Fecha</th>
                                                <th class="text-center">Cliente</th>
                                                <th class="text-center">Producto</th>
                                                <th class="text-center">Comprobante</th>
                                                <th class="text-center">Cantidad</th>
                                                <th class="text-center">Precio</th>
                                                <th class="text-center">Descuento</th>
                                                <th class="text-center">Total</th>
                                            </tr>
                                            <%
                                                 int count=0;
                                                for (Venta venta : dao.fecha_venta(fecha1, fecha2)) {
                                                    count=count+1;
                                            %>

                                            <tr class="text-center">
                                                <td><%=count%></td>
                                                <td><%=venta .getFecha_venta()%></td>
                                                <td><%=venta .getNombre_cliente()%></td>
                                                <td><%=venta .getNombre_producto()%></td>
                                                <td><%=venta .getComprobante()%></td>
                                                <td><%=venta .getCantidad()%></td>
                                                <td><%=venta .getPrecio()%></td>
                                                <td><%=venta .getDescuento()%></td>
                                                <td><%=venta .getTotal()%></td>

                                                <%}%>
                                        </thead>
                                        </tbody>

                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </td>
    </tr>
</tbody></table>


</body></html>

<%@include file="WEB-INF/fragmentos/bottom.jspf"%>