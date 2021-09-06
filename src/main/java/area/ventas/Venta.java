/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package area.ventas;

/**
 * 
 * @author Estuardo Ramos
 */
public class Venta {
     
    
    private int idFactura;
    private int items;
    private int idMueble;
    private String nombreEmpleado;
    private int cantidad;
    private double precio;
    private String fecha;
    private double total;
    private double subTotal;
    

    public Venta() {
    }

    public Venta(int idFactura, int items, int idMueble, String nombreEmpleado, int cantidad, double precio, String fecha, double total, double subTotal) {
        this.idFactura = idFactura;
        this.items = items;
        this.idMueble = idMueble;
        this.nombreEmpleado = nombreEmpleado;
        this.cantidad = cantidad;
        this.precio = precio;
        this.fecha = fecha;
        this.total = total;
        this.subTotal = subTotal;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }

    public int getIdMueble() {
        return idMueble;
    }

    public void setIdMueble(int idMueble) {
        this.idMueble = idMueble;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
    
    
    
}
