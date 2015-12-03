<%@include file="WEB-INF/fragmentos/topadm.jspf"%>

<div class="botonMenu">
    <a href="#" class="btn btn-info btn-sm" data-toggle="modal" data-target="#reg_persona">
        <span class="" aria-hidden=true></span>
        Registrar Producto</a>

</div>

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