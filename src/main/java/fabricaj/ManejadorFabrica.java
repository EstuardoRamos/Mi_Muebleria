/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabricaj;

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

/**
 *
 * @author Estuardo Ramos
 */
@WebServlet(name = "ManejadorFabrica", urlPatterns = {"/ManejadorFabrica"})
public class ManejadorFabrica extends HttpServlet {

    ManejadorPieza manejadorPieza = new ManejadorPieza();
    int idPieza;
    Pieza piezaG = new Pieza();
    ManejadorMuebleFr muebleF = new ManejadorMuebleFr();

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
        String menu = request.getParameter("menuFabrica");
        String accion = request.getParameter("accion");

        if (menu.equals("Piezas")) {

            switch (accion) {
                case "Agregar":
                    String nombrePieza = request.getParameter("txtnombre");
                    float precioPieza = Float.parseFloat(request.getParameter("precio"));
                    piezaG.setNombrePieza(nombrePieza);
                    piezaG.setPrecioPieza(precioPieza);
                    manejadorPieza.agregar(piezaG);
                    request.getRequestDispatcher("ManejadorFabrica?menuFabrica=Piezas&accion=Listar").forward(request, response);

                    break;

                case "Listar":
                    List lista = manejadorPieza.Listar();
                    //List lista = ManejadorPieza.Listar();
                    request.setAttribute("piezas", lista);
                    break;

                case "Actualizar":

                    Pieza piezaM = new Pieza();
                    String nombreModificar = request.getParameter("txtnombre");
                    float precioModificar = Float.parseFloat(request.getParameter("precio"));
                    piezaM.setNombrePieza(nombreModificar);
                    piezaM.setPrecioPieza(precioModificar);
                    piezaM.setId(idPieza);
                    manejadorPieza.modificar(piezaM);
                    request.getRequestDispatcher("ManejadorFabrica?menuFabrica=Piezas&accion=Listar").forward(request, response);

                    break;

                case "Cargar":

                    idPieza = Integer.parseInt(request.getParameter("id"));
                    Pieza pieza = manejadorPieza.ListarPorId(idPieza);
                    request.setAttribute("piezaSeleccionado", pieza);
                    request.getRequestDispatcher("ManejadorFabrica?menuFabrica=Piezas&accion=Listar").forward(request, response);

                    break;

                case "Eliminar":

                    idPieza = Integer.parseInt(request.getParameter("id"));
                    manejadorPieza.Eliminar(idPieza);
                    request.getRequestDispatcher("ManejadorFabrica?menuFabrica=Piezas&accion=Listar").forward(request, response);

                    break;

                case "sumar":

                    String nombreP = request.getParameter("nombrePieza");
                    System.out.println(request.getParameter("precioPieza"));
                    System.out.println(request.getParameter("nombrePieza"));
                    float precioP = Float.parseFloat(request.getParameter("precioPieza"));
                    piezaG.setNombrePieza(nombreP);
                    piezaG.setPrecioPieza(precioP);
                    manejadorPieza.agregar(piezaG);
                    request.getRequestDispatcher("ManejadorFabrica?menuFabrica=Piezas&accion=Listar").forward(request, response);

                    break;

            }

            RequestDispatcher rd = request.getRequestDispatcher("fabrica/Pieza.jsp");
            try {
                rd.forward(request, response);
                return;
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        if (menu.equals("Ensamble")) {
            switch (accion) {

                case "ListarP":
                    List lista = muebleF.Listar();
                    request.setAttribute("muebleFr", lista);
                    break;

                case "Ensamblar":
                    String nombreMueble = request.getParameter("nombreMueble");
                    //Pieza pieza = manejadorPieza.ListarPorId(idPieza);
                    System.out.println("hey "+nombreMueble);
                    //List listaM = muebleF.ConsultCantDisp(nombreMueble);
                    List listaM = muebleF.ConsultCantPiezas(nombreMueble);
                    request.setAttribute("muebleT", listaM);
                    request.getRequestDispatcher("ManejadorFabrica?menuFabrica=Ensamble&accion=ListarP").forward(request, response);

                    break;
            }
            RequestDispatcher rd = request.getRequestDispatcher("fabrica/Ensamble.jsp");
            try {
                rd.forward(request, response);
                return;
            } catch (Exception e) {
                e.printStackTrace();
            }
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
