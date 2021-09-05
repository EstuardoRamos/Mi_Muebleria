<%-- 
    Document   : Crear-piezas
    Created on : 29 ago. 2021, 3:46:22
    Author     : Estuardo Ramos
--%>

<%@page import="fabricaj.UsuarioFabrica"%>
<%@page import="usuarios.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear</title>
    </head>
    <body>
        <form  action="fabrica/Aviso-crear.jsp">
            <%
                out.print(request.getAttribute("name"));
                String name=request.getParameter("name");
                request.setAttribute("name",name);
            %>
            <h1>Crear pieza</h1>
            Para crear una pieza debera ingresar su nombre y el precio:
            <br>
            <label for="namePieza">Nombre de la pieza: </label>
            <input type="text" name="nomPieza" id="txtPieza" required/>
            <br>
            <label for="precioP">Precio la pieza: </label>
            <input type="number" step="any" name="precioPieza"  id="precioP" required/>
            <br>
            <br>
            <a "><button type="submit">Crear pieza</button></a>
            <a href="fabrica/Ventana-fabrica.jsp"><button type="button">Regresar a menu fabrica</button></a>
            <br>
            <br>
            <br>
            <br>
        </form>
    </body>
</html>
