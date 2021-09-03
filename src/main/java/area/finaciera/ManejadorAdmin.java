
package area.finaciera;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import usuarios.ManejadorUsuario;
import usuarios.Usuario;

/**
 *
 * @author Estuardo Ramos
 */
@WebServlet(name = "ManejadorAdmin", urlPatterns = {"/ManejadorAdmin"})
public class ManejadorAdmin extends HttpServlet {
    Usuario usuario = new Usuario();
    ManejadorUsuario manejadorUsuario= new ManejadorUsuario();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Empleados")) {

            switch (accion) {
                case "Listar":
                    List lista = manejadorUsuario.Listar();
                    request.setAttribute("usuarios", lista);

                    break;
                case "Agregar":
                    String nombre = request.getParameter("txtnombre");
                    String password = request.getParameter("txtpassword");
                    System.out.print("id");
                    System.out.println(request.getParameter("txttipo"));
                    int tipoInt = Integer.parseInt(request.getParameter("txttipo"));
                    usuario.setNombre(nombre);
                    usuario.setPassword(password);
                    usuario.setTipoNum(tipoInt);
                    //System.out.println(nombre);
                    manejadorUsuario.Agregar(usuario);
                    request.getRequestDispatcher("ManejadorAdmin?menu=Empleados&accion=Listar").forward(request, response);

                    break;
                case "Actualizar":

                    Usuario usuario1 = new Usuario();
                    String nombreUpdate = request.getParameter("txtnombre");
                    String passwordUpdate = request.getParameter("txtpassword");
                    int tipoIntUp = Integer.parseInt(request.getParameter("txtipo"));
                    usuario1.setNombre(nombreUpdate);
                    usuario1.setPassword(passwordUpdate);
                    manejadorUsuario.Actualizar(usuario1);
                    request.getRequestDispatcher("ManejadorAdmin?menu=Empleados&accion=Listar").forward(request, response);

                    break;
                case "Cargar":

                int idUsuario = Integer.parseInt(request.getParameter("id"));
                    Usuario usuario = manejadorUsuario.ListarPorId(idUsuario);
                    request.setAttribute("usuarioSeleccionado", usuario);
                    request.getRequestDispatcher("ManejadorAdmin?menu=Empleados&accion=Listar").forward(request, response);

                    break;

                case "Eliminar":

                    idUsuario = Integer.parseInt(request.getParameter("id"));
                    manejadorUsuario.Eliminar(idUsuario);
                    request.getRequestDispatcher("ManejadorAdmin?menu=Empleados&accion=Listar").forward(request, response);

                    break;
            }

            request.getRequestDispatcher("usuarioPage.jsp").forward(request, response);
        }
    }

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
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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

}
