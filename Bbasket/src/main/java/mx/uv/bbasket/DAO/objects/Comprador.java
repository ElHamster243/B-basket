package mx.uv.bbasket.DAO.objects;

import java.sql.Blob;

public class Comprador {
    private int id;
    private String nombres;
    private String apellidos;
    private String usuario;
    private String email;
    private Blob foto;
    private String password;
    public int getId(){
        return this.id;
    }
    public String getNombres(){
        return this.nombres;
    }
    public String getApellidos(){
        return this.apellidos;
    }
    public String getUsuario(){
        return this.usuario;
    }
    public String getEmail(){
        return this.email;
    }
    public Blob getFoto(){
        return this.foto;
    }
    public void setId (int id){
        this.id=id;
    }
    public void setNombres (String nombres){
        this.nombres=nombres;    
    }
    public void setApellidos (String apellidos){
        this.apellidos=apellidos;    
    }
    public void setUsuario (String usuario){
        this.usuario=usuario;    
    }
    public void setEmail (String email){
        this.email=email;    
    }
    public void setFoto (Blob foto){
        this.foto=foto;
    }
    public void setPassword (String password){
        this.password=password;    
    }
    public Comprador (int id, String nombres, String apellidos, String usuario, String email, Blob foto, String password){
        this.setId(id);
        this.setNombres(nombres);
        this.setApellidos(apellidos);
        this.setUsuario(usuario);
        this.setEmail(email);
        this.setFoto(foto);
        this.setPassword(password);
    }
}
