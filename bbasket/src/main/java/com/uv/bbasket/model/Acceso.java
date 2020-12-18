package com.uv.bbasket.model;
//Autor: Omar Alejandro Alonso Lizardi
//Fecha: 17-12-2020
//Sistemas web
//Universidad Veracruzana
//Modelo de la vista lista_acceso para verificar si los usuarios existen
//Así se puede verificar tres puntos en la información:
//El usuario no existe en la base de datos al hacer el registro
//El correo no existe en la base de datos al hacer el registro
//El usuario si existe en la base de datos al hacer el login
public class Acceso {
    //Atributos
    private String usuario;
    private String correo;
    //Getters
    public String getUsuario(){
        return this.usuario;
    }
    public String getCorreo(){
        return this.correo;
    }
    //Setters
    public void setUsuario(String usuario){
        this.usuario=usuario;
    }
    public void setCorreo(String correo){
        this.correo=correo;
    }
    //Constructor
    public Acceso(String usuario, String correo){
        this.setUsuario(usuario);
        this.setCorreo(correo);
    }
    //Metodo toString
    @Override
    public String toString() {
        return "\nUsuario: "+getUsuario()+"\nCorreo: "+getCorreo();
    }
}
