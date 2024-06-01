
<%@page import="java.util.Base64"%>
<%@page import="za.ac.tut.model.entity.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Found</title>
    </head>
    <body>
        <h1>Found Account Details</h1>
        
        <%
            Student stu = (Student) request.getAttribute("stu");
            String name = stu.getName();
            String surname = stu.getSurname();
            Long idNo = stu.getId();
            byte[] photo = stu.getImage();
            Integer age = stu.getAge();
            Character gender = stu.getGender();
            String[] subjects = stu.getSubjects();
        %>
        
        <table>
            <tr>
                <td> 
                    <img src="data:image/jpeg;base64, <%= new String(Base64.getEncoder().encode(photo)) %>" alt="Student Photo" width="200" height="200">
                </td>

            </tr>
            <tr>
                <td>
                    <b>Name:</b>
                    
                </td>
                <td>
                    <%=name%>
                </td>
            </tr>
            <tr>
                <td>
                    <b>Surname:</b>              
                </td>
                <td>
                        <%=surname%>
                </td>
            </tr>
            <tr>
                <td>
                    <b>Age:</b>
                    
                </td>
                <td>
                    <%=age%>
                </td>
            </tr>
            <tr>
                <td>
                    <b>Gender:</b>                    
                </td>
                <td>
                    <%=gender%>
                </td>
            </tr>
            <tr>
                <td>
                    <b>Student No:</b>                    
                </td>
                <td>
                    <%=idNo%>
                </td>
            </tr>
            
            <%
                for(int i = 0; i < subjects.length; i++)
                {
            %>
            
            <tr>
                <td>
                    <p><b>Subject <%=i +1%>:</b></p>
                </td>
                <td>
                    <%=subjects[i]%>
                </td>
            </tr>
            
            <%
                }
            %>
            
            
        </table>
            <p><a href="menu.html">MENU</a></p>
            <p><a href="add.html">ADD NEW CUSTOMER</a></p>
            <p>
            Click <a href="LogOutServlet.do">here </a> to go logout.
      </p>
    </body>
</html>
