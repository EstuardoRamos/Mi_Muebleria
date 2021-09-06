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

/**
 * 
 * @author Estuardo Ramos
 */
public class AdministradorMuebles {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    int r;
    Mueble mueble = new Mueble();
    private final String table = "Mueble";
    
    
    public int agregar(Mueble mueble) {

        String sentencia = "INSERT INTO "+table+" (Nombre,Precio) VALUES (?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            ps.setString(1, mueble.getNombre());
            ps.setFloat(2, mueble.getPrecio());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorMuebles.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    
    public List Listar() {
        String consulta = "SELECT * FROM Mueble";
        List<Mueble> lista = new ArrayList();
        System.out.println(lista);

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                Mueble mueble = new Mueble();
                mueble.setNombre(rs.getString("Nombre"));
                mueble.setPrecio(rs.getFloat("Precio"));
                lista.add(mueble);
                System.out.println("conected");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorMuebles.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return lista;

    }
    
    
    public int modificar(Mueble mueble, String nombreAntiguo) {
        String sentencia = "UPDATE "+table+" set Nombre=?,Precio=? WHERE Nombre=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            ps.setString(1, mueble.getNombre());
            ps.setFloat(2, mueble.getPrecio());
            ps.setString(3, nombreAntiguo);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AdministradorMuebles.class.getName()).log(Level.SEVERE, null, ex);
        }
       return r; 
    }
    
    public Mueble ListarPorName(String nombre) {
        Mueble mueble = new Mueble();
        String consulta = "SELECT * FROM Mueble WHERE Nombre=?";
        
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(consulta);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                mueble.setNombre(rs.getString(1));
                mueble.setPrecio(rs.getFloat(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorMuebles.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mueble;

    }
    
    
    public int Eliminar(String nombre) {
        String sql = "DELETE FROM Mueble WHERE Nombre=?";
        System.out.println(sql);
        System.out.println("lll"+nombre);
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.executeUpdate();
         } catch (SQLException ex) {
            Logger.getLogger(AdministradorMuebles.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

}
