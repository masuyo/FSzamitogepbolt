/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Alkatresz;
import Model.Raktar;
import Model.Vasarlo;
import Model.VasarloDB;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Cressida
 */
public class AddAlkatreszToKosarServlet extends HttpServlet {

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
                HttpSession session = request.getSession();
                VasarloDB VDB = (VasarloDB)session.getAttribute("regisztraltVasarlok");
                Vasarlo currentVasarlo = (Vasarlo)session.getAttribute("jelenlegi_vasarlo");
        
                /* csak név alapján csekkolom az adott alkatrészt, mivel ID-t nem kaptak
                 *  <form action="AddAlkatreszToKosarServlet?alkatresz=<%= alkatresz.getNev()%>" method="POST">
                 * a profile.jsp-n ebből itt adom meg, hogy az alkatresz parameter mit tartalmazzon (az alkatrész nevét)
                 */
                Alkatresz tempAlkatresz = new Alkatresz(request.getParameter("alkatresz"),0);
                
                // kinyerem a Raktárból az eredeti objektumot
                Alkatresz A1 = Raktar.getAlkatresz(tempAlkatresz);

                // request.getParameter(db) az input type neve a profile.jsp-n db, így kérem be az értékét
                // <td><input type="number" name="db" value="1"></td>
                int db = parseInt(request.getParameter("db"));

                for (int i = 0; i < db; i++) {

                    currentVasarlo.Vasarol(A1);

                }

                response.sendRedirect(response.encodeRedirectURL("profile.jsp"));
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
