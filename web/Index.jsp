<%-- 
    Document   : Index
    Created on : 22-03-2021, 11:23:18
    Author     : NT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>INICIO</title>
    </head>
    <body>
        <h1>Inicio Session</h1>
         <form action="Controlador" method="get">
        <div center>
           
           <tr>
                <td>Id</td>
                Nombre<input type="text" name="Id"/></td>
            </tr>

            <tr>
                <td>password</td>
                passsword<input type="password" name="Id"/></td> 
            </tr>

            <tr>
                <td> <input type="submit" name="Iniciar Session"/></td>
                <td> <input type="reset" value="Limpiar"></td>  
            </tr>    
        </div>
             <% if(request.getParameter("mjs")!= null){ %>
             <h1> <%= request.getParameter("mjs") %></h1>
             <%} %>
    </body>
</html>
