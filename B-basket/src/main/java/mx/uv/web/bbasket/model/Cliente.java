package mx.uv.web.bbasket.model;
//Autor: Omar Alejandro Alonso Lizardi
//Fecha: 17-12-2020
//Sistemas web
//Universidad Veracruzana
//Modelo de la tabla cliente
public class Cliente {
    //Atributos
    private int id;
    private String nombres;
    private String apellidos;
    private String usuario;
    private String email;
    private String password;
    //Getters
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
    public String getPassword(){
        return this.password;
    }
    //Setters
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
    public void setPassword (String password){
        this.password=password;    
    }
    //Constructor
    public Cliente (int id, String nombres, String apellidos, String usuario, String email, String password){
        this.setId(id);
        this.setNombres(nombres);
        this.setApellidos(apellidos);
        this.setUsuario(usuario);
        this.setEmail(email);
        this.setPassword(password);
    }
    //Metodo toString
    @Override
    public String toString() {
        return 
            "\nID: "+getId()+" || NOMBRE: "+getNombres()+" "+getApellidos()
        +   "\nUSUARIO: "+getUsuario()+" || EMAIL: "+getEmail();
    }
}
