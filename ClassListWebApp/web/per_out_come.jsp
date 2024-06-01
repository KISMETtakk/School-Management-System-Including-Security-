<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Percentage</title>
    </head>
    <body>
        <h1>Percentage Of Students Per Gender</h1>

        <%
            Double num = (Double) request.getAttribute("num");
            String genderStr = (String) request.getAttribute("genderStr");
        %>

        <p> <b>Gender:</b> </p>
        <p><%=genderStr%></p>
        <p> <b>Percentage:</b> </p>
        <p><%=num%>%</p>
        
         </p>
        <p>
            Click <a href="menu.html">here </a> to go to the menu page <br> Click
         <a href="index">here </a> to go to the main page.
        </p>
       <p>
            Click <a href="LogOutServlet.do">here </a> to go logout.
      </p>
    </body>
</html>
