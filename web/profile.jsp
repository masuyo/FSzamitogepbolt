<%-- 
    Document   : profile.jsp
    Created on : 28-Apr-2018, 10:56:17
    Author     : Cressida
--%>

<%@page import="java.util.Collections"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Webáruház</title>
        <style>
            table, tr, td{
                border: 1px solid black;
                border-collapse: collapse;
            }
        </style>
    </head>
    <body>
        
        <%
            VasarloDB VDB = (VasarloDB) session.getAttribute("regisztraltVasarlok");
            Vasarlo current = (Vasarlo) session.getAttribute("jelenlegi_vasarlo");
        %>
        <h1>Szia <%=current.getNev()%>!</h1>
        <h2>Vásárlók listája</h2>
        <h3><%=VDB.getVasarlok().size()%> vásárló van</h3>
        <table>

            <% for (Vasarlo v : VDB.getVasarlok()) { %>
            <tr>
                <td><%=v.getNev()%></td>
            </tr>
            <%}%>
        </table>
        <h2>Vásárlólista</h2>
        <table>
            <tr>
                <td>Termék neve</td>
                <td>Termék ára</td>
            </tr>
            <% if(current.getAlkatreszek().size() > 0) { 
                for (Alkatresz aresz : current.getAlkatreszek()) { %>
            <tr>
                <td><%=aresz.getNev()%></td>
                <td><%=aresz.getAr()%></td>
                <td><a href="DeleteAlkatreszServlet?alkatresz=<%= aresz.getNev()%>">Törlés</a></td>
            </tr>
            <%}} else {
                out.print("Nincs megjeleníthető termék.");
            } %>
        </table>
        <br>
        <h2>Termékek listája (Raktár)</h2>
        <table>
            <tr>
                <td>Termék neve</td>
                <td>Termék ára</td>
            </tr>
            <% if(Raktar.getAlkatreszValasztek().size() > 0) { 
                for (Alkatresz alkatresz : Raktar.getAlkatreszValasztek()) { %>
            <tr>
                <td><%=alkatresz.getNev()%></td>
                <td><%=alkatresz.getAr()%></td>
            </tr>
            <%}} else {
                out.print("Nincs megjeleníthető termék.");
            } %>
        </table>
        <h2>Új alkatrész felvitele a raktárba</h2>
        <form action="AddAlkatreszToRaktarServlet" method="POST">
            <label for="alkatreszNev">Név:</label> <input type="text" name="nev" id="alkatreszNev"><br>
            <label for="alkatreszAr">Ár: </label> <input type="text" name="ar" id="alkatreszAr"><br>
            <input type="submit" value="Feltölt">
        </form>
        <form action="LogOutServlet" >
            <input type="submit" value="Kijelentkezés">
        </form>
    </body>
</html>
