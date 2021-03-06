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
public class LoginServlet extends HttpServlet {

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
//            out.println("<title>Servlet LoginServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
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
        
        HttpSession session = request.getSession();
        response.setContentType("text/html;charset=UTF-8");
        
        VasarloDB VDB = null; // itt tároljuk majd az eddig létrejött felhasználókat
        
        /* A sessiont arra használjuk, hogy az oldalon való navigálás közben legyen hova tárolni a
        navigáláshoz szükséges dolgokat - hiszen pl. ha itt simán újrapéldányosítom a VásárlóAdatbázist, miután valaki
        regisztrált, a regisztrált felhasználó adatait nem tudnám session nélkül visszanyerni, 
        mert az itt újrapéldányosított adatbázispéldány már nyilván nem ugyanaz az objektum lenne, 
        mint amelyet a regisztrációkor hoztam létre.
        Ezért ezt a sessionben tárolt VásárlóAdatbázis objektumot "előhívom", ha korábban példányosításra került, ha nem,
        akkor pedig példányosítom - de csak első alkalommal.
        */
        if (session.getAttribute("regisztraltVasarlok") == null) {
            // nincs ilyen még, úgyhogy példányosítom
            VDB = new VasarloDB(); 
        } else {
            // van ilyen, úgyhogy előhívom, hogy tudjam használni
            VDB = (VasarloDB)session.getAttribute("regisztraltVasarlok");
        }
        
        // a formküldésből kapott infókat bementem egy Vásárló objektumba, hogy össze tudjam vetni az adatbázisommal
        Vasarlo tempVasarlo = new Vasarlo(request.getParameter("username"),request.getParameter("password"));
        
        // megnézi, hogy a VásárlóAdatbázis Vásárlók listájában talált-e a login adatoknak megfelelő usert
        if (VDB.IsVasarloExist(tempVasarlo)) {

            /* a jelenlegi vásárlót kikeresem az adatbázisból, hogy könnyebb legyen módosítani
            * nem szép, de kisebb szopás (referencia szerinti átadás miatt nem kell mindig felülcsapnom)
            */
            Vasarlo currentVasarlo = VDB.getCurrentVasarlo(tempVasarlo);
            
            /* rendezem a vásárló alkatrészeit abc sorrendben (ehhez az Alkatresz orsztály is
            implementálja a Comparable interfészt, és felülírtam a compareTo metódust hozzá,
            hogy a számomra megfelelő paraméterek (név) alapján hasonlítson össze a sorbarendezésnél
            két Alkatrész objektumot
            */
            Collections.sort(currentVasarlo.getAlkatreszek());
            //V1.setAlkatreszek(VDB.getCurrentAlkatreszek(V1));
            
            // a jelenlegi felhasználó sessiont kap
            session.setAttribute("jelenlegi_vasarlo", currentVasarlo);
            
            // rendezem a Vásárlók listáját név szerint, ugyanaz a módszer, mint az Alkatreszeknél
            Collections.sort(VDB.getVasarlok());
            
            // sessionbe mentem az adatbázist, hogy majd elő tudjam hívni később, mikor módosítani szeretném
            session.setAttribute("regisztraltVasarlok", VDB);
            
            // mivel sikeres a login, elküldi a Vásárlót a bejelentkezett oldalára
            response.sendRedirect(response.encodeRedirectURL("profile.jsp"));
            //RequestDispatcher rd = request.getRequestDispatcher("/profile.jsp");
            //rd.include(request, response);
            
            
        } else {
            // nincs ilyen user, hibaüzenet
            PrintWriter out = response.getWriter();
            response.sendError(404, "Felhasználó nem található!");
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
