<%-- 
    Document   : Atrapa-Datos
    Created on : 23 ago. 2021, 3:44:29
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
        <%
            String nombre = request.getParameter("nombre");
                String txtContra = request.getParameter("txtContra");
                String tipo = request.getParameter("tipo");
                
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    java.sql.Connection miConexion = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/usuario", "root2", "root12345");
                    java.sql.Statement miStatement = miConexion.createStatement();
                    String instruccionSql = "INSERT INTO Usuarios (Nombre, Contra, Tipo) VALUES ('" + nombre + "','" + txtContra + "','" + tipo + "')";
                    miStatement.executeUpdate(instruccionSql);
                    out.println("Registrado");
                    if (tipo.equalsIgnoreCase("finaciero")) {

                    } else if (tipo.equalsIgnoreCase("Punto de venta")) {

                    }

                } catch (Exception e) {
                    out.println("Error base ");
                }
            
        %>
    </body>
</html>
