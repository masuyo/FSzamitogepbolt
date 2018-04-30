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
        <h1>Vásárlók listája</h1>
        <%
            VasarloDB VDB = (VasarloDB) session.getAttribute("regisztraltVasarlok");
            Vasarlo current = (Vasarlo) session.getAttribute("jelenlegi_vasarlo");
        %>
        
        <h2><%=VDB.getVasarlok().size()%> vásárló van</h2>
        <table>

            <% for (Vasarlo v : VDB.getVasarlok()) { %>
            <tr>
                <td><%=v.getNev()%></td>
            </tr>
            <%}%>
        </table>
    </body>
</html>
