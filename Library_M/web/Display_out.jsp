<%-- 
    Document   : Display_out
    Created on : 15 Nov, 2024, 6:44:13 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Book Id:<i><%=request.getAttribute("BookId")%></i> </h3>
        <h3>Book Name:<i> <%=request.getAttribute("BookName")%></i> </h3>
        <h3>Author Name: <i><%=request.getAttribute("AuthorName")%></i> </h3>
        <h3>Category: <i><%=request.getAttribute("Category")%></i> </h3>
    </body>
</html>
