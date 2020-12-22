package mx.uv.web.bbasket.dao;
//Autor: Omar Alejandro Alonso Lizardi

//Fecha: 17-12-2020
//Sistemas web
//Universidad Veracruzana
//CRUD de los datos de la tabla 'cliente'
//Obtiene los clientes disponibles en el sistema
//Agrega, Elimina, Modifica, Consulta usuario por user y password

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import mx.uv.web.bbasket.model.Cliente;
import mx.uv.web.bbasket.util.Conexion;

public class ClienteDAO {
	//
    private List<Cliente>compradores=new ArrayList<>();
	//
    private static final String TABLA="cliente";
	//Autentificación
    public static boolean authenticate(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            return false;
        }
        Cliente c = ClienteDAO.userPasswd(username, password);
        if (c == null) {
            return false;
        }
        return true;
    }
	//Registrar cliente de tipo booleano
    public static boolean registrarCliente(Cliente c){
        boolean resultado=false;
        try {
		
            String query =  " insert into "+TABLA+" (nombres, apellidos, usuario, correo, contrasena)"
                            + " values (?, ?, ?, ?, ?)";
		
            PreparedStatement preparedStmt = Conexion.conectar().prepareStatement(query);
            preparedStmt.setString(1, c.getNombres());
            preparedStmt.setString(2, c.getApellidos());
            preparedStmt.setString(3, c.getUsuario());
            preparedStmt.setString(4, c.getEmail());
            preparedStmt.setString(5, c.getPassword());
            preparedStmt.execute();
            System.out.println("Cliente creado.");
            resultado=true;
        } catch (SQLException sqlException) {
		//
            System.out.println("Estado SQL: "+sqlException.getSQLState());
            System.out.println("Código de error: "+sqlException.getErrorCode());
            System.out.println(sqlException.getMessage());
        }
        return resultado;
    }
    	//Eliminar cuenta de la base de datos mediante el nombre de usuario
    public static boolean eliminarCliente(String u){
        boolean resultado=false;
        String query = "delete from "+TABLA+" where usuario = ?;";
        try {
            PreparedStatement preparedStmt = Conexion.conectar().prepareStatement(query);
            preparedStmt.setString(1, u);
            preparedStmt.execute();
            resultado=true;
        } catch (SQLException sqlException) {
            System.out.println("Estado SQL: "+sqlException.getSQLState());
            System.out.println("Código de error: "+sqlException.getErrorCode());
            System.out.println(sqlException.getMessage());
        }
        return resultado;
    }
	//Obtener el usuario mediante el username y la contraseña (verifica)
    public static Cliente userPasswd(String user, String passwd){
        Cliente aux=null;

        String select = "select * from cliente where cliente.usuario='"+user+"' and cliente.contrasena='"+passwd+"';";
        Statement stmt;
        try {
            stmt=Conexion.conectar().createStatement();
            ResultSet rs=stmt.executeQuery(select);
            if(!rs.next()){
                System.out.println("\nSin coincidencias registradas en la base de datos.");
                System.out.println("\nVerificar contraseña o usuario.");
            }else{
                int id=rs.getInt("id");
                String nombres=rs.getString("nombres");
                String apellidos=rs.getString("apellidos");
                String usuario=rs.getString("usuario");
                String correo=rs.getString("correo");
                String passsword=rs.getString("contrasena");
                aux=new Cliente(id, nombres, apellidos, usuario, correo, passsword);
                System.out.println(aux.toString());
            }
                
            
        } catch (Exception sqlException) {
            System.out.println(sqlException.getMessage());
        }
        
        return aux;
    }

    public static Cliente userById(String id){
        Cliente aux=null;

        String select = "select * from cliente where cliente.usuario='"+id+"'";
        Statement stmt;
        try {
            stmt=Conexion.conectar().createStatement();
            ResultSet rs=stmt.executeQuery(select);
            if(!rs.next()){
                System.out.println("\nSin coincidencias registradas en la base de datos.");
                System.out.println("\nVerificar contraseña o usuario.");
            }else{
                int ids=rs.getInt("id");
                String nombres=rs.getString("nombres");
                String apellidos=rs.getString("apellidos");
                String usuario=rs.getString("usuario");
                String correo=rs.getString("correo");
                String passsword=rs.getString("contrasena");
                aux=new Cliente(ids, nombres, apellidos, usuario, correo, passsword);
                System.out.println(aux.toString());
            }
                
            
        } catch (Exception sqlException) {
            System.out.println(sqlException.getMessage());
        }
        
        return aux;
    }
    public static Cliente byUser(String user){
        Cliente aux=null;

        String select = "select * from cliente where cliente.usuario='"+user+"'";
        Statement stmt;
        try {
            stmt=Conexion.conectar().createStatement();
            ResultSet rs=stmt.executeQuery(select);
            if(!rs.next()){
                System.out.println("\nSin coincidencias registradas en la base de datos.");
                System.out.println("\nVerificar contraseña o usuario.");
            }else{
                int id=rs.getInt("id");
                String nombres=rs.getString("nombres");
                String apellidos=rs.getString("apellidos");
                String usuario=rs.getString("usuario");
                String correo=rs.getString("correo");
                String passsword=rs.getString("contrasena");
                aux=new Cliente(id, nombres, apellidos, usuario, correo, passsword);
                System.out.println(aux.toString());
            }
                
            
        } catch (Exception sqlException) {
            System.out.println(sqlException.getMessage());
        }
        
        return aux;
    }
	
    
}
