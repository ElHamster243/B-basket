package com.uv.bbasket.model;

public class AccesosPublico {
    private String usuario;
    private String correo;
    private String passwd;
    public String getUsuario (){
        return this.usuario;
    }
    public String getCorreo (){
        return this.correo;
    }
    public String getPasswd (){
        return this.passwd;
    }
    public void setUsuario (String usuario){
        this.usuario=usuario;
    }
    public void setCorreo (String correo){
        this.correo=correo;
    }
    public void setPasswd (String passwd){
        this.passwd=passwd;
    }
    public AccesosPublico (String usuario, String correo, String passwd){
        this.setUsuario(usuario);
        this.setCorreo(correo);
        this.setPasswd(passwd);
    }
}
