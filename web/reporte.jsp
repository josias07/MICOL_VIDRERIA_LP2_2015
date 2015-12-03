
<%@page import="DaoImpl.CompraDaoImpl"%>
<%@page import="Beans.Productos"%>
<%@page import="Dao.CompraDao"%>
<%@page import="Beans.Compra"%>
<%@include file="WEB-INF/fragmentos/topadm.jspf"%>

<% CompraDao dao = new CompraDaoImpl();%>
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
                <h1><strong class="glyphicon glyphicon-calendar"></strong>Reporte de Compras</h1>
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
                                <form class="form-inline" name="buscar" method="post" action="reporte.jsp">

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
                                                <th class="text-center">Comprobante</th>
                                                <th class="text-center">Serie</th>
                                                <th class="text-center">Id_proveedor</th>
                                            </tr>
                                            <%
                                                 int count=0;
                                                for (Compra compra : dao.fechacompra( fecha1, fecha2)) {
                                                    count=count+1;
                                            %>

                                            <tr class="text-center">
                                                <td><%=count%></td>
                                                <td><%=compra.getFecha()%></td>
                                                <td><%=compra.getComprobante()%></td>
                                                <td><%=compra.getSerie()%></td>
                                                <td><%=compra.getNombre_proveedor()%></td>

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