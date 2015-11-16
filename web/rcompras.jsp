<%@page import="Entidad.Compra"%>
<%@page import="Dao.CompraDao"%>
<%@page import="DaoImpl.CompraDaoImpl"%>
<%@page import="Entidad.Productos"%>

<%@include file="WEB-INF/fragmentos/topadm.jspf"%>
<style type="text/css">

</style>
<body background="imagen/06.jpg" background-repeat: no-repeat background-size: 100%>
        <% CompraDao dao = new CompraDaoImpl();%>
        <% Productos prod = new Productos();%>
        
<div  id="usuario" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  
    <div class="modal-content">

        <div class="modal-header" style="padding:10px 40px;">
            <a href="adm.jsp"><button type="button" class="close" data-dismiss="modal">&times;</button></a>
          <h4><span class="glyphicon glyphicon-lock"></span> Reporte de Coompras</h4>
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
				<th class="text-center">Nombre</th>
				<th class="text-center">Fecha</th>
				<th class="text-center">Serie_factura</th>
				<th class="text-center">Id_proveedor</th>
                                <th class="text-center">Igv</th>
                                <th class="text-center">Descuento</th>
                                <th class="text-center">Subtotal</th>
                                <th class="text-center">Total</th>
                                <th class="text-center">Hora</th>
                        </tr>
                            <% 
                             for (Compra compra : dao.listarcompra()) {  
                            %>

                        <tr class="text-center">
                                <td><%=compra.getId_compra()%></td>
                                <td><%=compra.getId_productos()%></td>
				<td><%=compra.getFecha()%></td>
				<td><%=compra.getSerie_factura()%></td>
                                <td><%=compra.getId_proveedor()%></td>
                                <td><%=compra.getIgv()%></td>
                                <td><%=compra.getDescuento()%></td>
				<td><%=compra.getSubtotal()%></td>
                                <td><%=compra.getTotal()%></td>
				<td><%=compra.getHora()%></td>
                                
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