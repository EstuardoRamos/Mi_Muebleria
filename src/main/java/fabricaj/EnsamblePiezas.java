/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fabricaj;

import conec.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import usuarios.Usuario;

/**
 * 
 * @author Estuardo Ramos
 */
public class EnsamblePiezas {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    private final String table="Pieza_ensamble";
    int r;
    
    public List Listar() {
        String consulta = "SELECT * FROM "+table+"";
        List<PiezaEnsamble> lista = new ArrayList();

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                PiezaEnsamble piezaE = new PiezaEnsamble();
                piezaE.setNombreMueble(rs.getString("Nombre_mueble"));
                piezaE.setNombrePieza(rs.getString("Nombre_pieza"));
                piezaE.setCantidad(rs.getInt("Cantidad_pieza"));
                lista.add(piezaE);

            }
        } catch (SQLException ex) {
            Logger.getLogger(EnsamblePiezas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;

    }

    public int Agregar(PiezaEnsamble piezaE) {

        String sentencia = "INSERT INTO "+table+" (Nombre_mueble, Nombre_pieza, Cantidad_pieza) VALUES (?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            ps.setString(1, piezaE.getNombreMueble());
            ps.setString(2, piezaE.getNombrePieza());
            ps.setInt(3, piezaE.getCantidad());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EnsamblePiezas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

     public PiezaEnsamble ListarPorName(String nombre) {
       
        PiezaEnsamble piezaE = new PiezaEnsamble();
        String consulta = "SELECT * FROM "+table+" WHERE Nombre_Mueble=?";
        
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(consulta);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            while (rs.next()) {
                piezaE.setNombreMueble(rs.getString(1));
                piezaE.setNombrePieza(rs.getString(2));
                piezaE.setCantidad(rs.getInt(3));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorMuebles.class.getName()).log(Level.SEVERE, null, ex);
        }

        return piezaE;

    }

    public int modificar(PiezaEnsamble piezaE, String nombreAntiguoM, String nombreAntPieza) {
        String sentencia = "UPDATE "+table+" set Nombre_mueble=?,Nombre_pieza=?, Cantidad_piezas WHERE Nombre_mueble=? AND Nombre_pieza=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            ps.setString(1, piezaE.getNombreMueble());
            ps.setString(2, piezaE.getNombrePieza());
            ps.setInt(3, piezaE.getCantidad());
            ps.setString(4, nombreAntiguoM);
            ps.setString(5, nombreAntPieza);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(EnsamblePiezas.class.getName()).log(Level.SEVERE, null, ex);
        }
       return r; 
    }

    public int Eliminar(String nombreMueble, String nombrePieza) {
        String sql = "DELETE FROM "+table+" WHERE Nombre_mueble=? AND Nombre_pieza=?";
        System.out.println(sql);
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombreMueble);
            ps.setString(2, nombrePieza);
            ps.executeUpdate();
         } catch (SQLException ex) {
            Logger.getLogger(EnsamblePiezas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

}
