/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fabricaj;

import conec.Conexion;
import java.sql.Connection;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Estuardo Ramos
 */
public class ManejadorPieza {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    int r;
    
    
    public int agregar(Pieza pieza) {

        String sentencia = "INSERT INTO PIEZA (nombre_pieza,precio_pieza) VALUES (?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            ps.setString(1, pieza.getNombrePieza());
            ps.setFloat(2, pieza.getPrecioPieza());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorPieza.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    
    public List Listar() {
        String consulta = "SELECT * FROM PIEZA";
        List<Pieza> lista = new ArrayList();

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                Pieza pieza  = new Pieza();
                pieza.setId(rs.getInt("id_pieza"));
                pieza.setNombrePieza(rs.getString("nombre_pieza"));
                pieza.setPrecioPieza(rs.getFloat("precio_pieza"));
                lista.add(pieza);
                System.out.println("conected");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorPieza.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return lista;

    }
    
    
    public int modificar(Pieza pieza) {
        String sentencia = "UPDATE PIEZA set nombre_pieza=?,precio_pieza=? WHERE id_pieza=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            ps.setString(1, pieza.getNombrePieza());
            ps.setFloat(2, pieza.getPrecioPieza());
            ps.setInt(3, pieza.getId());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ManejadorPieza.class.getName()).log(Level.SEVERE, null, ex);
        }
       return r; 
    }
    
    public Pieza ListarPorId(int id) {
        Pieza pieza = new Pieza();
        String consulta = "SELECT * FROM PIEZA WHERE id_pieza=" + id;
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                pieza.setNombrePieza(rs.getString(2));
                pieza.setPrecioPieza(rs.getFloat(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorPieza.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pieza;

    }
    
    
    public void Eliminar(int id) {

        String sql = "DELETE FROM PIEZA WHERE id_pieza=" + id;
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
         } catch (SQLException ex) {
            Logger.getLogger(ManejadorPieza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
