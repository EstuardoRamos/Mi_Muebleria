<%-- 
    Document   : Login-inicio-sesion
    Created on : 24 ago. 2021, 1:17:07
    Author     : Estuardo Ramos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@page import="java.sql.*" %>
        <%
            String nombre = request.getParameter("nombre");
            String txtContra = request.getParameter("txtContra");
            String tipo = request.getParameter("tipo");
            Class.forName("com.mysql.jdbc.Driver");
            try {
                Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuario", "root2", "root12345");
                PreparedStatement c_preparada = miConexion.prepareStatement("SELECT * FROM Usuarios WHERE Nombre=? AND Contra=? AND Tipo=?");
                c_preparada.setString(1, nombre);
                c_preparada.setString(2, txtContra);
                c_preparada.setString(3, tipo);
                ResultSet miResult = c_preparada.executeQuery();
                
                
                //if(miResult.absolute(1)) out.println("encontrado");
                //else out.println("no encuentra");
                

            } catch (Exception e) {
                out.println("error");

                e.printStackTrace();
            }

        %>
    </body>
</html>
