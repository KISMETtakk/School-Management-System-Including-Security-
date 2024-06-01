<%-- 
    Document   : add_outcome
    Created on : 24 May 2024, 5:56:02 PM
    Author     : Student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Outcome Page</title>
    </head>
    <body>
        <h1>Add Outcome</h1>
        <p>
            Student has been successfully added to the database.
            
            <%
             String name = request.getParameter("name");
             
            %>
        <table>
            <tr>
                <td>
                    <b>Name: </b>
                </td>
                <td>
                    <%=name%>
                </td>
            </tr>
            
           
        </table>
        </p>
        <p><a href="index.html">BACK</a></p>
            <p><a href="add.html">ADD NEW CUSTOMER</a></p>
       <p>
            Click <a href="LogOutServlet.do">here </a> to go logout.
      </p>
    </body>
</html>
