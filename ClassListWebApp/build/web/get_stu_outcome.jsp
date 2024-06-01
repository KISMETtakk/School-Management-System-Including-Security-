<%@page import="java.util.Base64"%>
<%@page import="za.ac.tut.model.entity.Student"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Our Clients</title>
    </head>
    <body>
        <h1>Below Is A List Of All Our Students</h1>
        
        <table>
            <%
                List<Student> stu = (List<Student>) request.getAttribute("stu");
                
                for(int i= 0; i < stu.size(); i++)
                {                                      
                    String name = stu.get(i).getName();
                    String surname = stu.get(i).getSurname();
                    Long idNo = stu.get(i).getId();
                    byte[] photo = stu.get(i).getImage();
                    Integer age = stu.get(i).getAge();
                    Character gender = stu.get(i).getGender();
                    String[] subjects = stu.get(i).getSubjects();
            %>
                <tr>
                    <td> 
                        <img src="data:image/jpeg;base64, <%= new String(Base64.getEncoder().encode(photo)) %>" alt="Student Photo" width="200" height="200">
                    </td>
                </tr>
                <tr>
                    <td><b>Name:</b></td>
                    <td><%=name%></td>
                </tr>
                <tr>
                    <td><b>Surname:</b></td>
                    <td><%=surname%></td>
                </tr>
                <tr>
                    <td><b>Age:</b></td>
                    <td><%=age%></td>
                </tr>
                <tr>
                    <td><b>Gender:</b></td>
                    <td><%=gender%></td>
                </tr>
                <tr>
                    <td><b>Student No:</b></td>
                    <td><%=idNo%></td>
                </tr>
                <%
                    for(int z = 0; z < subjects.length; z++)
                    {
                %>
                <tr>
                    <td><b>Subject <%=z +1%>:</b></td>
                    <td><%=subjects[z]%></td>
                </tr>
                <%
                    }
                %>
                <tr>
                    <td>==================================================================<br></td>
                </tr>
            <%
                }
            %>  
        </table>
        <p><a href="index.html">BACK</a></p>
        <p><a href="add.html">ADD NEW CUSTOMER</a></p>
        <p>
            Click <a href="LogOutServlet.do">here </a> to go logout.
      </p>
    </body>
</html>
