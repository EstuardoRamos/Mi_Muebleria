

package usuarios;

public class Usuario {

    private String nombre;
    private String password;
    private String tipoStr;
    private int tipoNum;

    public Usuario() {
    }

    public Usuario(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
    }

    public Usuario(String nombre, String password, String tipoStr, int tipoNum) {
        this.nombre = nombre;
        this.password = password;
        this.tipoStr = tipoStr;
        this.tipoNum = tipoNum;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipoStr() {
        return tipoStr;
    }

    public void setTipoStr(String tipoStr) {
        this.tipoStr = tipoStr;
    }

    public int getTipoNum() {
        return tipoNum;
    }

    public void setTipoNum(int tipoNum) {
        this.tipoNum = tipoNum;
    }
    
    
    public void buscarUsuario() {

    }

    public void clasificarUsuario(int tipoUs) {
        switch (tipoUs) {
            case 1:
                //agrregar a fabrica
                break;
            case 2:
                //agrregar a Area de ventas
                break;
            case 3:
                //agrregar a finazas
                break;
        }

    }
}
