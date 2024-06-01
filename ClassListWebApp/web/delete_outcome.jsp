<%@page import="za.ac.tut.model.entity.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Found</title>
    </head>
    <body>
        <h1>Found Student Details</h1>
        
        <%
            Student stu = (Student) request.getAttribute("stu");
            String name = stu.getName();
            Long idNo = stu.getId();            
            
        %>
        
        <p>The following student has been removed: </p>
        <table>
            <tr>
                <td>
                    <b>Name:</b>
                    <%=name%>
                </td>
            </tr>
            <tr>
                <td>
                    <b>Student Number:</b>
                    <%=idNo%>
                </td>
            </tr>
            
            
           
            <p><a href="add.html">ADD NEW CUSTOMER</a></p>
             <p>
                Click <a href="LogOutServlet.do">here </a> to go logout.
            </p>
        </table>
    </body>
</html>
