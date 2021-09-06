

package fabricaj;

/**
 * 
 * @author Estuardo Ramos
 */
public class MuebleTMp {
    
    private int id;
    private String nombre;
    private float precioCosto;
    private float precioVenta;

    public MuebleTMp(int id, String nombre, float precioCosto, float precioVenta) {
        this.id = id;
        this.nombre = nombre;
        this.precioCosto = precioCosto;
        this.precioVenta = precioVenta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(float precioCosto) {
        this.precioCosto = precioCosto;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }
    
    

}
