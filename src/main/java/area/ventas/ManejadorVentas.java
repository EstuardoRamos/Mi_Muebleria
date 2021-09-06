/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package area.ventas;

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
import usuarios.Cliente;
/**
 *
 * @author Estuardo Ramos
 */
@WebServlet(name = "ManejadorVentas", urlPatterns = {"/ManejadorVentas"})
public class ManejadorVentas extends HttpServlet {
    Venta venta = new Venta();
    Cliente cliente = new Cliente();
    int numfac = 0;

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

        if (menu.equals("Ventas")) {
            switch (accion) {
                case "BuscarCliente":
                    String nit = (request.getParameter("nit"));
                    
                    cliente = cliente.BuscarCliente(nit);
                    request.setAttribute("cliente", cliente);
                    break;

               /* case "BuscarProducto":
                    int codigoProducto = Integer.parseInt(request.getParameter("codigoproducto"));
                    producto = productoDAO.ConsultaPorCodigo(codigoProducto);
                    request.setAttribute("productoseleccionado", producto);
                    request.setAttribute("cliente", usuario);
                    for (int i = 0; i < listaVentas.size(); i++) {
                        totalapagar += listaVentas.get(i).getSubtotal();
                    }
                    formatoNumero1 = NumberFormat.getNumberInstance();
                    total1 = formatoNumero1.format(totalapagar);
                    request.setAttribute("totalapagar", total1);
                    request.setAttribute("listaventas", listaVentas);
                    break;

                case "AgregarProducto":
                    totalapagar = 0;
                    venta = new Venta();
                    item++;
                    codProducto = Integer.parseInt(request.getParameter("codigoproducto"));
                    descripcion = request.getParameter("nombreproducto");
                    precio = Integer.parseInt(request.getParameter("precioproducto"));
                    cantidad = Integer.parseInt(request.getParameter("cantidadproducto"));
                    subtotal = precio * cantidad;
                    venta.setItem(item);
                    venta.setDescripcionProducto(descripcion);
                    venta.setCantidad(cantidad);
                    venta.setPrecio(precio);
                    venta.setSubtotal(subtotal);
                    venta.setIdProducto(codProducto);
                    listaVentas.add(venta);
                    System.err.println("error venta");
                    request.setAttribute("listaventas", listaVentas);
                    for (int i = 0; i < listaVentas.size(); i++) {
                        totalapagar += listaVentas.get(i).getSubtotal();
                    }
                    formatoNumero1 = NumberFormat.getNumberInstance();
                    total1 = formatoNumero1.format(totalapagar);
                    request.setAttribute("totalapagar", total1);
                    break;

                case "GenerarVenta":
                    venta.setIdCliente(usuario.getId());
                    venta.setIdEmpleado(1);
                    venta.setNumeroComprobante("" + numfac);
                    venta.setFecha("2020-10-21");
                    venta.setMonto(totalapagar);
                    venta.setEstado("1");
                    ventaDAO.RegistrarVenta(venta);
                    int idv = ventaDAO.ObtenerMaximoIdVentas();
                    for (int i = 0; i < listaVentas.size(); i++) {
                        venta = new Venta();
                        venta.setIdVenta(idv);
                        venta.setIdProducto(listaVentas.get(i).getIdProducto());
                        venta.setCantidad(listaVentas.get(i).getCantidad());
                        venta.setPrecio(listaVentas.get(i).getPrecio());
                        ventaDAO.GuardarDetalleVenta(venta);
                    }

                    break;

                default:
                    String factura = ventaDAO.ObtenerNumeroDeFactura();
                    System.err.println("nume factura" + factura);
                    if (factura == null) {
                        factura = "1";
                    } else {
                        numfac = Integer.parseInt(factura) + 1;
                    }

                    request.setAttribute("numerofactura", numfac); */

            }
            request.getRequestDispatcher("Ventas.jsp").forward(request, response);
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
