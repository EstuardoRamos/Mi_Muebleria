/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fabricaj;

import java.sql.SQLException;
import usuarios.Usuario;

/**
 * 
 * @author Estuardo Ramos
 */
public class UsuarioFabrica extends Usuario{

    
    
    
    
    public static void crearPieza(String namePieza, float precio) throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection miConexion = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/usuario", "root2", "root12345");
            java.sql.Statement miStatement = miConexion.createStatement();
            String instruccionSql = "INSERT INTO PIEZA (nombre_pieza, precio_pieza) VALUES ('" + namePieza + "','" + precio + "')";
            miStatement.executeUpdate(instruccionSql);

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

}
