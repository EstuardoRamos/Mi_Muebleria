package fabricaj;

import area.ventas.ManejadorVentas;
import conec.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Estuardo Ramos
 */
public class MuebleVenta {

    private int id;
    private String nombreMueble;
    private float precioVenta;

    public MuebleVenta() {
    }

    public MuebleVenta(int id, String nombreMueble, float precioVenta) {
        this.id = id;
        this.nombreMueble = nombreMueble;
        this.precioVenta = precioVenta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreMueble() {
        return nombreMueble;
    }

    public void setNombreMueble(String nombreMueble) {
        this.nombreMueble = nombreMueble;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public MuebleVenta ConsultaPorId(int idMueble) {
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        Conexion cn = new Conexion();
        int r;

        //Producto producto = new Producto();
        MuebleVenta muebleV = new MuebleVenta();
        con = cn.Conexion();
        String consulta = "SELECT * FROM muebles_venta WHERE id_mueble = " + idMueble;

        try {
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                muebleV.setId(rs.getInt("id_mueble"));
                muebleV.setNombreMueble(rs.getString("nombre_mueble"));
                muebleV.setPrecioVenta(rs.getFloat("precio_mueble"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return muebleV;
    }

}
