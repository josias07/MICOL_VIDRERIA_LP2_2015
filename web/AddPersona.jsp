<%@page import="Beans.Persona"%>
<%@page import="DaoImpl.PersonaDaoImpl"%>
<%@page import="Dao.PersonaDao"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
                      <title>Formulario Persona</title>
        <%!
            String id_persona, nombre, apepat, apemat, sexo, dni, direccion, celular, opcion;
        %>

        <%
            id_persona = request.getParameter("id_persona");
            if (id_persona == null) {
                id_persona = "";
            }

            nombre = request.getParameter("nombre");
            if (nombre == null) {
                nombre = "";
            }

            apepat = request.getParameter("apepat");
            if (apepat == null) {
                apepat = "";
            }

            apemat = request.getParameter("apemat");
            if (apemat == null) {
                apemat = "";
            }

            sexo = request.getParameter("sexo");
            if (sexo == null) {
                sexo = "";
            }

            dni = request.getParameter("dni");
            if (dni == null) {
                dni = "";
            }
            direccion = request.getParameter("direccion");
            if (direccion == null) {
                direccion = "";
            }
            celular = request.getParameter("celular");
            if (celular == null) {
                celular = "";
            }
            opcion = request.getParameter("opcion");
            if (opcion == null) {
                opcion = "";
            }


        %>
    </head>
            <%@include file="agregarUsuario.jsp" %>
        <%     
            if (opcion.equals("Registrar")) {
                Persona per = new Persona();
                per.setId_persona(id_persona);
                per.setNombre(nombre);
                per.setApepat(apepat);
                per.setApemat(apemat);
                per.setSexo(sexo);
                per.setDni(dni);
                per.setCelular(celular);
                per.setDireccion(direccion);
                PersonaDao reg= new PersonaDaoImpl();
                if (reg.agregarpersona(per)) {
                    response.sendRedirect("agregarUsuario.jsp");
                } else {
                    out.print("No se pudo registrar");
                }
            }
            if (opcion.equals("Eliminar")) {
                PersonaDao eli= new PersonaDaoImpl();
                Persona per = new Persona();
                if (eli.eliminarpersona(id_persona)) {
                    response.sendRedirect("agregarUsuario.jsp");
                } else {
                    out.print("No se pudo eliminar porque se está usando");
                }
            }
        %>
    