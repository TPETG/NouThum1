<%-- 
    Document   : Intranet
    Created on : 22-03-2021, 11:55:55
    Author     : NT
--%>
<%@page  import="" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>INTRANET</title>
    </head>
    <body>
        <h1>BIENVENIDO
        
        <% if(session.getAttribute("Usuario")!= null){
             Usuario u = (Usuario) session.getAttribute("Usuario");
        %>
        
        <h2><%= u.getNombre()+""+u.getApellido() %></h2>
        <%}else{response.sendRedirect("Index.jsp?mjs=accseso denegado");%>
    </h1>
    <a href="Salir"><input type="button" value="Cerrar Session"/></a>
        
    </body>
</html>
