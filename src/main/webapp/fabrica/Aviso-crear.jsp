<%-- 
    Document   : Aviso-crear
    Created on : 30 ago. 2021, 3:51:17
    Author     : Estuardo Ramos
--%>

<%@page import="fabricaj.UsuarioFabrica"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear</title>
    </head>
    <body>
        <%
                out.print(request.getAttribute("name"));
                String name=request.getParameter("name");
                request.setAttribute("name",name);
            %>
        <%
            try {
                UsuarioFabrica usuario = new UsuarioFabrica("estuar");
                String nombrePieza = request.getParameter("nomPieza");
                String precioP = request.getParameter("precioPieza");
                float precioPieza = Float.parseFloat(precioP);
                UsuarioFabrica.crearPieza(nombrePieza,precioPieza);
                out.print("La Pieza "+nombrePieza+ " fue ingresada con exito con un precio de Q. "+precioP+ " ");   
                } catch (Exception e) {
                    e.printStackTrace();
                    out.print("Error al ingresar La pieza");
                } 
            %>
            <button><a href="Ventana-fabrica.jsp">Regresar</a></button>
    </body>
</html>
