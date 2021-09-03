
package usuarios;


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
public class ManejadorUsuario {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    int r;

    /*public Usuario BuscarCliente(int documento){
        Usuario usuario = new Usuario();
        String consulta = "SELECT * FROM usuarios WHERE NIT = ?";
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(consulta);
            ps.setInt(1, documento);
            rs = ps.executeQuery();
            while(rs.next()){
                usuario.setNombre(rs.getInt("id"));
                usuario.setDocumento(rs.getInt("documento"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setRol(rs.getString("rol"));
                System.err.println(""+usuario.getNombre());
              }
        } catch (Exception e) {
        }
        return usuario;
    }

    
    public Usuario Validar(int documento, String password) {
        Usuario usuario = new Usuario();
        String consulta = "SELECT * FROM usuarios WHERE documento = ? AND password = ?";
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(consulta);
            ps.setInt(1, documento);
            ps.setString(2, password);
            rs = ps.executeQuery();
            rs.next();
            do {
                usuario.setI(rs.getInt("id"));
                usuario.setDocumento(rs.getInt("documento"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setPassword(rs.getString("password"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setEstado(rs.getString("estado"));
            } while (rs.next());
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }*/

    public List Listar() {
        String consulta = "SELECT * FROM user";
        List<Usuario> lista = new ArrayList();

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("Nombre"));
                usuario.setPassword(rs.getString("Contra"));
                usuario.setTipoStr(rs.getString("TipoStr"));
                usuario.setTipoNum(rs.getInt("TipoInt"));
                lista.add(usuario);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;

    }

    public int Agregar(Usuario usuario) {

        String sentencia = "INSERT INTO user (Nombre,Contra,TipoStr,TipoInt) VALUES (?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            System.out.println("llegando a agragar");
            System.out.println(usuario.getNombre());
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getPassword());
            System.out.println(usuario.getTipoNum());
            switch (usuario.getTipoNum()) {
                case 1:
                    usuario.setTipoStr("Fabrica");
                    break;
                case 2:
                    usuario.setTipoStr("Ventas");
                    break;
                case 3:
                    usuario.setTipoStr("Finaciero y administrativo");
                    break;
                default:
                    break;
            }
            ps.setString(3, usuario.getTipoStr());
            ps.setInt(4, usuario.getTipoNum());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public Usuario ListarPorId(int id) {
        Usuario usuario = new Usuario();
        String consulta = "SELECT * FROM user WHERE id=" + id;
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                usuario.setNombre(rs.getString(2));
                usuario.setPassword(rs.getString(3));
                usuario.setTipoStr(rs.getString(4));
                usuario.setTipoNum(rs.getInt(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usuario;

    }

    public int Actualizar(Usuario usuario) {
        String sentencia = "UPDATE user set Nombre=?,Contra=?,TipoStr=?,TipoInt=? WHERE id=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getPassword());
            if (usuario.getTipoNum()==1) {
                usuario.setTipoStr("Fabrica");
            }else if (usuario.getTipoNum()==2) {
                usuario.setTipoStr("Ventas");
            } else if (usuario.getTipoNum()==1) {
                usuario.setTipoStr("Finaciero y administrativo");
            }
            ps.setString(3, usuario.getTipoStr());
            ps.setInt(4, usuario.getTipoNum());
            ps.setInt(5, usuario.getId());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ManejadorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public void Eliminar(int id) {

        String sql = "DELETE FROM user WHERE id=" + id;
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}


