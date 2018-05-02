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
        <h2>Megvásárolt alkatrészek</h2>
            <table>
            <tr>
                <td>Termék neve</td>
                <td>Termék ára</td>
            </tr>
            <% if(current.getAlkatreszek().size() > 0) { 
                for (Alkatresz a : current.getAlkatreszek()) { %>
            <tr>
                <td><%=a.getNev()%></td>
                <td><%=a.getAr()%></td>
            </tr>
            <%}} else {
                out.print("Nincs megjeleníthető termék.");
            } %>
        </table>
        <br>
        <a href="LogOutServlet">Kijelentkezés</a> 
    </body>
</html>
