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
public class Pieza {
    private int id;
    private String nombrePieza;
    private float precioPieza;

    public Pieza() {
    }

    public Pieza(int id, String nombrePieza, float precioPieza) {
        this.id = id;
        this.nombrePieza = nombrePieza;
        this.precioPieza = precioPieza;
    }

    public Pieza(String nombrePieza, float precioPieza) {
        this.nombrePieza = nombrePieza;
        this.precioPieza = precioPieza;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrePieza() {
        return nombrePieza;
    }

    public void setNombrePieza(String nombrePieza) {
        this.nombrePieza = nombrePieza;
    }

    public float getPrecioPieza() {
        return precioPieza;
    }

    public void setPrecioPieza(float precioPieza) {
        this.precioPieza = precioPieza;
    }
    
    

}
