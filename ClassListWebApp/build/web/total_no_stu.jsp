<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Total Number Of Students</title>
    </head>
    <body>
        <h1>Total Number Of Students</h1>
        <%
            Integer totNoStu = (Integer) request.getAttribute("totNumStu");
        %>
        
        <p>
            There is a <b>total</b> of <b><%=totNoStu%></b> students
        </p>
        
             <p><a href="add.html">ADD NEW CUSTOMER</a></p>
       <p>
            Click <a href="LogOutServlet.do">here </a> to go logout.
      </p>
    </body>
</html>
