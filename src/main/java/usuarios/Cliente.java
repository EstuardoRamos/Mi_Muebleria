/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package usuarios;

import conec.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 
 * @author Estuardo Ramos
 */
public class Cliente {
    private int id;
    private String NIT;
    private String nombre;
    private String direccion;
    private String municipio;
    private String departamento;
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    int r;

    public Cliente() {
    }

    public Cliente(int id, String NIT, String nombre, String direccion, String municipio, String departamento, Connection con, PreparedStatement ps, ResultSet rs, int r) {
        this.id = id;
        this.NIT = NIT;
        this.nombre = nombre;
        this.direccion = direccion;
        this.municipio = municipio;
        this.departamento = departamento;
        this.con = con;
        this.ps = ps;
        this.rs = rs;
        this.r = r;
    }

    
    
    

    public Cliente(String NIT, String nombre, String direccion, String municipio, String departamento) {
        this.NIT = NIT;
        this.nombre = nombre;
        this.direccion = direccion;
        this.municipio = municipio;
        this.departamento = departamento;
    }

    public Cliente(String NIT, String nombre, String direccion) {
        this.NIT = NIT;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public Cliente BuscarCliente(String nit){
        Usuario usuario = new Usuario();
        Cliente cliente = new Cliente();
        String consulta = "SELECT * FROM Clientes WHERE NIT= ?";
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(consulta);
            ps.setString(1, nit);
            rs = ps.executeQuery();
            while(rs.next()){
                cliente.setId(rs.getInt("idCliente"));
                cliente.setNombre(rs.getString("Nombre"));
                cliente.setDireccion(rs.getString("Direccion"));
                cliente.setMunicipio(rs.getString("Municipio"));
                cliente.setDepartamento(rs.getString("Departamento"));
                cliente.setNIT(rs.getString("NIT"));
                
                System.err.println(""+cliente.getNombre());
              }
        } catch (Exception e) {
        }
        return cliente;
    }
    
    

}
