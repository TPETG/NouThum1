/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class ControladorUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
         String accion = request.getParameter("accion");
        
        switch(accion){
        
            case "1" -> IniciarSesion(request,response);
            case "2" -> Registrar(request,response);
            default -> response.sendRedirect("Index.jsp?mjs= WARNING-ALERT");
        
        }
        
      
    }
    
    
    
    @SuppressWarnings("UseSpecificCatch")
    private void IniciarSesion(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try{
      String Id = request.getParameter("Id");
        String Password = request.getParameter("Password");
        Usuario UsuarioNuevo = new Usuario(Id,Password);
        UsuarioNuevo = validar(UsuarioNuevo);
        if(UsuarioNuevo!=null){
            HttpSession sesion = request.getSession();
            sesion.setAttribute("Usuario", UsuarioNuevo);
            response.sendRedirect("Intrant.jsp");
        }else{
            response.sendRedirect("Index.jsp?mjs=Datos  incorrectas");
        }
    
        }catch(Exception e){
            response.sendRedirect(e.getMessage()+"Index.jsp?mjs=");
        }
        }
    
    
    
    private void Registrar(HttpServletRequest request, HttpServletResponse response) throws IOException{
    
        String Id= request.getParameter("Id").trim();
        String Nombre = request.getParameter("Nombre").trim();
        String Apellido = request.getParameter("Apellido").trim();
        String Password = request.getParameter("Password").trim();
        if(Id.equals("")|| Nombre.isEmpty()|| Apellido.length()==0 ||Password.isEmpty()){
        response.sendRedirect("Registro.jsp?mjs= Campos Incompletos");
    }else{
            Usuario UsuarioNuevo = new Usuario(Id,Nombre,Apellido,Password);
             if(validarRegistro(UsuarioNuevo)==null){
                 Usuario.Usuarios.add(UsuarioNuevo);
                 response.sendRedirect("Index.jsp?mjs= Usuario Registrado Inicio Sesion");
     
             }else{
                 response.sendRedirect("Registro.jsp?mjs= Usuario ya existe");
             
             }
    }
    }
    
    

    
 private Usuario validar(Usuario UsuarioNuevo){
            Usuario validado = null;
            for(Usuario UsuarioRegistrado:Usuario.Usuarios){
                if(UsuarioRegistrado.getId().equals(UsuarioNuevo.getId())&&
                    UsuarioRegistrado.getPassword().equals(UsuarioNuevo.getPassword())){
                    validado = UsuarioRegistrado;
                }       
            }
                    return validado;
 }
private Usuario validarRegistro(Usuario UsuarioNuevo){

            Usuario validado = null;
        for(Usuario UsuarioRegistrado:Usuario.Usuarios){
            if(UsuarioRegistrado.getId().equals(UsuarioNuevo.getId())){
            validado = UsuarioRegistrado;
        }
        }
            return validado;
}


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
