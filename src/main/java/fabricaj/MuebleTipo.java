/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fabricaj;

/**
 * 
 * @author Estuardo Ramos
 */
public class MuebleTipo {
    private String nombreMT;
    private String nombrePieza;
    private int cantidadPieza;

    public MuebleTipo() {
    }
    
    
    

    public MuebleTipo(String nombreMT, String nombrePieza, int cantidadPieza) {
        this.nombreMT = nombreMT;
        this.nombrePieza = nombrePieza;
        this.cantidadPieza = cantidadPieza;
    }
    

    public MuebleTipo(String nombreMT, int cantidadPieza) {
        this.nombreMT = nombreMT;
        this.cantidadPieza = cantidadPieza;
    }
    

    public String getNombreMT() {
        return nombreMT;
    }

    public void setNombreMT(String nombreMT) {
        this.nombreMT = nombreMT;
    }

    public String getNombrePieza() {
        return nombrePieza;
    }

    public void setNombrePieza(String nombrePieza) {
        this.nombrePieza = nombrePieza;
    }

    public int getCantidadPieza() {
        return cantidadPieza;
    }

    public void setCantidadPieza(int cantidadPieza) {
        this.cantidadPieza = cantidadPieza;
    }
    
    
    
    
    
    

}
