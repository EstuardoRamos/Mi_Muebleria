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

public class ManejadorMuebleFr {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    MuebleFr muebleFr = new MuebleFr();

    /*public void agregar(Pieza pieza) {

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
    }*/
    public List Listar() {
        String consulta = "SELECT * FROM tipo_mueble";
        List<MuebleFr> lista = new ArrayList();

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                MuebleFr muebleFr = new MuebleFr();
                muebleFr.setId(rs.getInt("id_tm"));
                muebleFr.setNombre(rs.getString("nombre_mueble"));
                muebleFr.setPrecio(rs.getFloat("precio_costo"));
                lista.add(muebleFr);
                System.out.println("conected");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorMuebleFr.class.getName()).log(Level.SEVERE, null, ex);

        }
        return lista;

    }

    /*public void modificar(Pieza pieza) {
        String sentencia = "UPDATE PIEZA set nombre_pieza=?,precio_pieza=? WHERE id_pieza=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            ps.setString(1, pieza.getNombrePieza());
            ps.setFloat(2, pieza.getPrecioPieza());
            ps.setInt(3, pieza.getId());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ManejadorMuebleFr.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }*/
 /* public Pieza ListarPorId(int id) {
        MuebleFr muebleFr = new MuebleFr();
        Pieza pieza = new Pieza();
        String consulta = "SELECT * FROM PIEZA WHERE tipo_mueble=" + id;
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                muebleFr.setNombre(rs.getString(2));
                muebleFr.setPrecio(rs.getFloat(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorMuebleFr.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManejadorMuebleFr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    //consultar cantidad de piezas para el mueble
    public List ConsultCantPiezas(String nombre) {
        System.out.println("hola " + nombre);
        String consulta = "SELECT * FROM piezas_mueble WHERE tipo_mueble="+"'"+nombre+"'";
        List<MuebleTipo> lista1 = new ArrayList();
        //con = cn.Conexion();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                MuebleTipo muebleT = new MuebleTipo();
                muebleT.setNombrePieza(rs.getString("nombre_pieza"));
                muebleT.setNombreMT(rs.getString("tipo_mueble"));
                muebleT.setCantidadPieza(rs.getInt("cantidad_necesaria"));
                System.out.println(muebleT.getNombrePieza());
                lista1.add(muebleT);
                System.out.println("conected");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorMuebleFr.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista1;
    }

    public List ConsultCantDisp(String nombre) {
        System.out.println("hola " + nombre);
        String consulta = "SELECT nombre_pieza, COUNT( nombre_pieza ) AS total FROM  PIEZA GROUP BY nombre_pieza ORDER BY\n"
                + "total DESC";
        List<MuebleTipo> lista1 = new ArrayList();
        //con = cn.Conexion();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                MuebleTipo muebleT = new MuebleTipo();
                muebleT.setNombrePieza(rs.getString("nombre_pieza"));
               //muebleT.setNombreMT(rs.getString("tipo_mueble"));
                muebleT.setCantidadPieza(rs.getInt("total"));
                System.out.println(muebleT.getNombrePieza());
                lista1.add(muebleT);
                System.out.println("conected");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorMuebleFr.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista1;
    }

}
