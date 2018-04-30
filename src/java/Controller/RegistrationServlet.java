/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Vasarlo;
import Model.VasarloDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Cressida
 */
public class RegistrationServlet extends HttpServlet {

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
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet RegistrationServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet RegistrationServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
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
         
                // létrehozom a sessiont, amelyben az oldal navigálásához tárolok adatokat majd
                HttpSession session = request.getSession();
                response.setContentType("text/html;charset=UTF-8");
                
                VasarloDB VDB = null;
                
                // megnézem, hogy van-e korábban létrehozott adatbázis
                if (session.getAttribute("regisztraltVasarlok") == null) {
                    // nincs -> itt hozom létre
                    VDB = new VasarloDB();
                }else{
                    // van -> előhívom sessionből
                    VDB = (VasarloDB) session.getAttribute("regisztraltVasarlok");
                }
                
                // lekérem a formról kapott infókat, mentem egy Vásárló objektumba
                Vasarlo V1 = new Vasarlo(request.getParameter("username"),request.getParameter("password"));
                
                // az új Vásárló objektumom összevetem az adatbázis tartalmával
                if (!VDB.IsVasarloExist(V1)) {
                    // korábban nem volt ilyen felhasználó, ezért sessiont kap, és
                    // elmentem az adatbázisban
                    session.setAttribute("jelenlegi_vasarlo", V1);
                    VDB.AddVasarlo(V1);
                    // rendezem a vásárlók listáját
                    Collections.sort(VDB.getVasarlok());
                    // frissítem a sessionben tárolt adatbázist, mivel abban változás történt
                    session.setAttribute("regisztraltVasarlok", VDB);
                    // megfelelő jsp aloldalra navigál
                    response.sendRedirect(response.encodeRedirectURL("profile.jsp"));
                }else{
                    
                    PrintWriter out = response.getWriter();
                    response.sendError(417, "Ilyen felhasználó már létezik!");
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

}
