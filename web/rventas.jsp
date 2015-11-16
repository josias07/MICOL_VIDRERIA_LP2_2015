<%@page import="Beans.Venta"%>
<%@page import="Dao.VentaDao"%>
<%@page import="DaoImpl.VentaDaoImpl"%>
<%@page import="Beans.Productos"%>


<%@include file="WEB-INF/fragmentos/topadm.jspf"%>
<style type="text/css">

</style>
<body background="imagen/06.jpg" background-repeat: no-repeat background-size: 100%>
        <% VentaDao dao = new VentaDaoImpl();%>
        <% Productos prod = new Productos();%>
        
<div  id="usuario" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  
    <div class="modal-content">

        <div class="modal-header" style="padding:10px 40px;">
            <a href="adm.jsp"><button type="button" class="close" data-dismiss="modal">&times;</button></a>
          <h4><span class="glyphicon glyphicon-lock"></span> Reporte de Ventas</h4>
        </div>

    <div class="modal-body" style="padding:30px 100px;">
                <section class="table">

           </section>
       
            <input type="hidden" name="opcion" value="RegistrarCompra">
                <table class="table table-bordered table-hover">
                    
                   
                    <tbody> 
                    <thead> 
			<tr class="active info">
                            
                                <th class="text-center">ID</th>
				<th class="text-center">Usuario</th>
                                <th class="text-center">Cliente</th>
				<th class="text-center">Fecha</th>
				<th class="text-center">Serie_factura</th>
				<th class="text-center">Igv</th>
                                <th class="text-center">Descuento</th>
                                <th class="text-center">Subtotal</th>
                                <th class="text-center">Total</th>
                                <th class="text-center">Hora</th>
                        </tr>
                            <% 
                             for (Venta venta: dao.listarventa() ) {  
                            %>

                        <tr class="text-center">
                                <td><%=venta.getId_venta()%></td>
                                <td><%=venta.getId_usuario()%></td>
                                <td><%=venta.getId_cliente()%></td>
				<td><%=venta.getFecha_venta()%></td>
				<td><%=venta.getSerie_factura()%></td>
                                <td><%=venta.getIgv()%></td>
                                <td><%=venta.getDescuento()%></td>
				<td><%=venta.getSubtotal()%></td>
                                <td><%=venta.getTotal()%></td>
				<td><%=venta.getHora()%></td>
                                
                                <%}%>
                     </thead>
                    </tbody>
                    
            </table>

   
      </div>
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