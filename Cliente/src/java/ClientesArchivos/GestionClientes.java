/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ClientesArchivos;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.FileWriter;

/**
 *
 * @author Ana Dominguez
 */
@WebServlet(name = "GestionClientes", urlPatterns = {"/GestionClientes"})
public class GestionClientes extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        
       
        String id = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String categoria = request.getParameter("categoria");
        String direccion = request.getParameter("direccion");
        
        Clientes cliente = new Clientes(id, nombre, categoria, direccion);
        
      
        String rutaArchivo = "C:\\Users\\Personal\\Desktop\\datos_cliente.txt";
        
        try (PrintWriter out = response.getWriter()) {
            try {
                FileWriter fileWriter = new FileWriter(rutaArchivo, true);
                try (PrintWriter printWriter = new PrintWriter(fileWriter)) {
                    printWriter.println("=== Registro de Cliente ===");
                    printWriter.println("ID: " + cliente.getId()); 
                    printWriter.println("Nombre: " + cliente.getNombre());
                    printWriter.println("Categoría: " + cliente.getCategoria());
                    printWriter.println("Dirección: " + cliente.getDireccion());
                    printWriter.println("------");
                }
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Registro Exitoso</title>");
                out.println("<meta charset='UTF-8'>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>¡Datos guardados con éxito!</h1>");
                out.println("<p><strong>ID:</strong> " + id + "</p>");
                out.println("<p><strong>Nombre:</strong> " + nombre + "</p>");
                out.println("<p><strong>Categoría:</strong> " + categoria + "</p>");
                out.println("<p><strong>Dirección:</strong> " + direccion + "</p>");
                out.println("</body>");
                out.println("</html>");
                
            } catch (IOException e) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Error</title>");
                out.println("<meta charset='UTF-8'>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1 style='color:red;'>¡Error al guardar los datos!</h1>");
                out.println("<p>" + e.getMessage() + "</p>");
                out.println("</body>");
                out.println("</html>");
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
    }
    // </editor-fold>
}