<%-- 
    Document   : Pestaña-Ventas
    Created on : 23 ago. 2021, 4:47:43
    Author     : Estuardo Ramos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*,usuarios.*"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <% 
     Usuario us = (Usuario) request.getAttribute("usuario");
    %>
    <body>
        <h1>Hola tu eres un vendedor</h1>
        <%= us.toString() %>
        hola
    </body>
</html>
