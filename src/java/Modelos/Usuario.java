/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.ArrayList;

/**
 *
 * @ NT
 */
public class Usuario {
    
    private String Id;
    private String Nombre;
    private String Apellido;
    private String Password;
    

    
    public static ArrayList<Usuario> Usuarios = new ArrayList();
    
    
    public Usuario(String Id, String Nombre, String Apellido, String Password) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Password = Password;
    }

    public Usuario(String Id, String Password) {
        this.Id = Id;
        this.Password = Password;
    }
 
    
      public Usuario() {
    }

   
    

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

  

}
