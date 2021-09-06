/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package area.ventas;

import conec.Conexion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Estuardo Ramos
 */
public class PuntoVenta {
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    
    public String ObtenerNumeroDeFactura() {
        String numerodefactura ="";
        String consulta = "SELECT MAX(numerofactura) FROM ventas";
        con = cn.Conexion();

        try {
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                numerodefactura = rs.getString(1);
                System.err.println("numfac"+numerodefactura);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PuntoVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return numerodefactura;

    }

        public void RegistrarVenta(Venta venta){
         String sentencia = "INSERT INTO ventas (idclienteventa,idempleadoventa,numerofactura,fechaventa,totalventa,estado) VALUES(?,?,?,?,?,?)";
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(sentencia);
            ps.setString(2, venta.getNombreEmpleado());
            ps.setInt(3, venta.getIdFactura());
            ps.setString(4, venta.getFecha());
            ps.setDouble(5, venta.getTotal());
            //ps.setString(6, venta.getEstado());
            ps.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(PuntoVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void GuardarDetalleVenta(Venta venta){
          String sentencia = "INSERT INTO detalleventa (idventa,idproducto,cantidadproducto,precioventa) VALUES(?,?,?,?)";
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(sentencia);
            ps.setInt(1,venta.getIdFactura());
            ps.setInt(2, venta.getIdMueble());
            ps.setInt(3, venta.getCantidad());
            ps.setDouble(4, venta.getPrecio());
           
            ps.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(PuntoVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public int ObtenerMaximoIdVentas(){
        int idVenta=0;
        String consulta = "SELECT MAX(idVenta) FROM ventas";
        con = cn.Conexion();
         try {
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
               idVenta=rs.getInt(1);
               System.out.println("max"+idVenta);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PuntoVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return idVenta;
    }

}
