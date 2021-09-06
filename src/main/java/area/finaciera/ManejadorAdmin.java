package area.finaciera;

import fabricaj.AdministradorMuebles;
import fabricaj.EnsamblePiezas;
import fabricaj.Mueble;
import fabricaj.Pieza;
import fabricaj.PiezaEnsamble;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
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
    ManejadorUsuario manejadorUsuario = new ManejadorUsuario();
    Mueble mueble = new Mueble();
    AdministradorMuebles adminMuebles = new AdministradorMuebles();
    PiezaEnsamble piezaEnsamble = new PiezaEnsamble();
    EnsamblePiezas ensamblePiezas = new EnsamblePiezas();

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
                    int tipoIntUp = Integer.parseInt(request.getParameter("txttipo"));
                    usuario1.setNombre(nombreUpdate);
                    usuario1.setPassword(passwordUpdate);
                    usuario1.setTipoNum(tipoIntUp);
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
        if (menu.equals("Muebles")) {
            String get = "ManejadorAdmin?menu=Muebles&accion=Listar";
            switch (accion) {
                case "Agregar":
                    String nombreMueble = request.getParameter("txtnombre");
                    float precioMueble = Float.parseFloat(request.getParameter("precio"));
                    mueble.setNombre(nombreMueble);
                    mueble.setPrecio(precioMueble);
                    adminMuebles.agregar(mueble);
                    request.getRequestDispatcher(get).forward(request, response);

                    break;

                case "Listar":
                    List lista = adminMuebles.Listar();
                    //List lista = ManejadorPieza.Listar();
                    request.setAttribute("muebles", lista);
                    break;

                case "Actualizar":

                
                    String nombreModificar = request.getParameter("txtnombre");
                    String nombreAntiguo = request.getParameter("nombreAntiguo");
                    float precioModificar = Float.parseFloat(request.getParameter("precio"));
                    mueble.setNombre(nombreModificar);
                    mueble.setPrecio(precioModificar);
                    adminMuebles.modificar(mueble, nombreAntiguo);
                    request.getRequestDispatcher(get).forward(request, response);

                    break;

                case "Cargar":

                    //idPieza = Integer.parseInt(request.getParameter("id"));
                    //Pieza pieza = manejadorPieza.ListarPorId(idPieza);
                    String name = request.getParameter("nombre");
                    Mueble mueble = adminMuebles.ListarPorName(name);
                    request.setAttribute("muebleSeleccionado", mueble);
                    request.getRequestDispatcher(get).forward(request, response);

                    break;

                case "Eliminar":
                    name = request.getParameter("nombre");
                    System.out.println(name+" este nombre se borra");
                    adminMuebles.Eliminar(name);
                    request.getRequestDispatcher(get).forward(request, response);
                    break;

            }

            request.getRequestDispatcher("area.administrativa/Mueble.jsp").forward(request, response);

        }
        if (menu.equals("piezasEnsamble")) {
            String get = "ManejadorAdmin?menu=piezasEnsamble&accion=Listar";
            switch (accion) {
                case "Agregar":
                    String nombreMue = request.getParameter("txtnombreM");
                    String nombrePie = request.getParameter("txtnombreP");
                    int cant = Integer.parseInt(request.getParameter("cantidad"));
                    piezaEnsamble.setNombreMueble(nombreMue);
                    piezaEnsamble.setNombrePieza(nombrePie);
                    piezaEnsamble.setCantidad(cant);
                    ensamblePiezas.Agregar(piezaEnsamble);
                    request.getRequestDispatcher(get).forward(request, response);

                    break;

                case "Listar":
                    List lista = ensamblePiezas.Listar();
                    //List lista = ManejadorPieza.Listar();
                    request.setAttribute("piezasEnsamble", lista);
                    break;

                case "Actualizar":
                    String nombreModificarM = request.getParameter("txtnombreM");
                    String nombreAntiguoM = request.getParameter("nombreAntiguoM");
                    String nombreModificarP = request.getParameter("txtnombreP");
                    String nombreAntiguoP = request.getParameter("nombreAntiguoP");
                    int cantidadModificar = Integer.valueOf(request.getParameter("cantidad"));
                    piezaEnsamble.setNombreMueble(nombreModificarM);
                    piezaEnsamble.setNombrePieza(nombreModificarP);
                    piezaEnsamble.setCantidad(cantidadModificar);
                    ensamblePiezas.modificar(piezaEnsamble, nombreAntiguoM, nombreAntiguoP);
                    request.getRequestDispatcher(get).forward(request, response);

                    break;

                case "Cargar":

                    //idPieza = Integer.parseInt(request.getParameter("id"));
                    //Pieza pieza = manejadorPieza.ListarPorId(idPieza);
                    String nameM = request.getParameter("nombrem");
                    String nameP = request.getParameter("nombrep");
                    PiezaEnsamble piezaE  = ensamblePiezas.ListarPorName(nameM);
                    request.setAttribute("ensamblePieza", piezaE);
                    request.getRequestDispatcher(get).forward(request, response);

                    break;

                case "Eliminar":
                    nameM = request.getParameter("nombrem");
                    nameP = request.getParameter("nombrep");
                    ensamblePiezas.Eliminar(nameM,nameP);
                    request.getRequestDispatcher(get).forward(request, response);
                    break;

            }

            request.getRequestDispatcher("area.administrativa/PiezasEnsamble.jsp").forward(request, response);

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
