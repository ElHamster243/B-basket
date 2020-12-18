package com.uv.bbasket.dao;
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

import com.uv.bbasket.model.Cliente;
import com.uv.bbasket.util.Conexion;

public class ClienteDAO {
    List<Cliente>compradores=new ArrayList<>();
    private static final String TABLA="cliente";
    public static void registrarCliente(Cliente c){
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
        } catch (SQLException sqlException) {
            System.out.println("Estado SQL: "+sqlException.getSQLState());
            System.out.println("Código de error: "+sqlException.getErrorCode());
            System.out.println(sqlException.getMessage());
        }
    }
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
            }
                int id=rs.getInt("id");
                String nombres=rs.getString("nombres");
                String apellidos=rs.getString("apellidos");
                String usuario=rs.getString("usuario");
                String correo=rs.getString("correo");
                String passsword=rs.getString("contrasena");
                aux=new Cliente(id, nombres, apellidos, usuario, correo, passsword);
                System.out.println(aux.toString());
            
        } catch (Exception sqlException) {
            System.out.println(sqlException.getMessage());
        }
        
        return aux;
    }
    
}
