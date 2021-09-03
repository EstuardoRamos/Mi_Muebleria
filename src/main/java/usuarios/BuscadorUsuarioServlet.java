/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;

import conec.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import usuarios.Usuario;
/**
 *
 * @author Estuardo Ramos
 */
@WebServlet(name = "BuscadorUsuarioServlet", urlPatterns = {"/BuscadorUsuarioServlet"})
public class BuscadorUsuarioServlet extends HttpServlet {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

        //processRequest(request, response);

    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        Usuario usuario = new Usuario();
        String nombre = request.getParameter("nombre");
        String txtContra = request.getParameter("txtContra");
        String tipo = request.getParameter("tipo");
        int tipoInt = Integer.valueOf(tipo);
        usuario.setNombre(nombre);
        usuario.setPassword(txtContra);
        usuario.setTipoNum(tipoInt);
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String tipoLetras = null;
        RequestDispatcher rd;

        try {
            con = cn.Conexion(); 
            ps = con.prepareStatement("SELECT * FROM Usuarios WHERE Nombre=? AND Contra=? AND Tipo=?");
            ps.setString(1, nombre);
            ps.setString(2, txtContra);
            ps.setString(3, tipo);
            rs = ps.executeQuery();
            if (rs.next()) {
                out.print("Usuario Encontrado");
                if (tipo.equals("1")) {
                    rd = request.getRequestDispatcher("fabrica/PrincipalFabr.jsp");
                    rd.forward(request, response);
                }
                if (tipo.equals("2")) {
                    rd = request.getRequestDispatcher("areaVentas/Area-ventas.jsp");
                    rd.forward(request, response);

                }
                if (tipo.equals("3")) {
                    rd = request.getRequestDispatcher("area.administrativa/PrincipalAdmin.jsp");
                    rd.forward(request, response);
                }
            } else {
                out.print("Usuario no encontrado");
                String msjError = "Error los datos ingresados son incorrectos";
                rd = request.getRequestDispatcher("Login-Inicio.jsp");
                rd.forward(request, response);
                request.setAttribute("msj", msjError);
            }

        } catch (SQLException e) {
            out.println("error");

            e.printStackTrace();
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    
    public static void  buscarUsuario(boolean user, String tipo) throws ClassNotFoundException{
    }
    
    public void asignarPagina(){
        
    }

}
