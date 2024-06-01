<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>ERROR</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Student Holder Not Found</h1>
        
        <p>The following student holder was not found:</p>
        
        <%
            String idNoStr = (String) request.getAttribute("idNo");
            Long idNo = Long.parseLong(idNoStr);
        %>
        
        <p>ID NUMBER: <b><%=idNo%></b></p>
        <p><a href="index.html">BACK</a></p>
        <p><a href="add.html">ADD NEW STUDENT</a></p>
    </body>
</html>

