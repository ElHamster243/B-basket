package com.uv.bbasket.dao;

import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.uv.bbasket.model.Comprador;
import com.uv.bbasket.util.Conexion;

public class CompradorDAO {
    private Conexion conexion=new Conexion();
    List<Comprador>compradores=new ArrayList<>();
    private static final String TABLA="comprador";
    //Agregar comprador a la base de datos
    public void registrarComprador(Comprador c){
        try {
            String query =  " insert into "+TABLA+" (nombres, apellidos, usuario, correo, foto, contraseña)"
                            + " values (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = conexion.conectar().prepareStatement(query);
            preparedStmt.setString(1, c.getNombres());
            preparedStmt.setString(2, c.getApellidos());
            preparedStmt.setString(3, c.getUsuario());
            preparedStmt.setString(4, c.getEmail());
            preparedStmt.setBlob(5, c.getFoto());
            preparedStmt.setString(6, c.getPassword());
            preparedStmt.execute();
        } catch (SQLException sqlException) {
            System.out.println("Estado SQL: "+sqlException.getSQLState());
            System.out.println("Código de error: "+sqlException.getErrorCode());
            System.out.println(sqlException.getMessage());
        }
    }
    //Eliminar cuenta de la base de datos mediante el nombre de usuario
    public void eliminarComprador(Comprador c){
        String query = "delete from "+TABLA+" where usuario = ?;";
        try {
            PreparedStatement preparedStmt = conexion.conectar().prepareStatement(query);
            preparedStmt.setString(1, c.getUsuario());
            preparedStmt.execute();
        } catch (SQLException sqlException) {
            System.out.println("Estado SQL: "+sqlException.getSQLState());
            System.out.println("Código de error: "+sqlException.getErrorCode());
            System.out.println(sqlException.getMessage());
        }
    }
    //Cambiar contraseña de usuario
    public void cambiarPasswd(Comprador c, String passwd){
        String query = "update "+TABLA+" set contraseña = ? where usuario = ?;";
        try {
            PreparedStatement preparedStmt = conexion.conectar().prepareStatement(query);
            preparedStmt.setString(1, passwd);
            preparedStmt.setString(2, c.getUsuario());
            preparedStmt.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println("Estado SQL: "+sqlException.getSQLState());
            System.out.println("Código de error: "+sqlException.getErrorCode());
            System.out.println(sqlException.getMessage());
        }
    }
    //Cambiar nombres de comprador
    public void cambiarNombres(Comprador c, String nombres){
        String query = "update "+TABLA+" set nombres = ? where usuario = ?;";
        try {
            PreparedStatement preparedStmt = conexion.conectar().prepareStatement(query);
            preparedStmt.setString(1, nombres);
            preparedStmt.setString(2, c.getUsuario());
            preparedStmt.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println("Estado SQL: "+sqlException.getSQLState());
            System.out.println("Código de error: "+sqlException.getErrorCode());
            System.out.println(sqlException.getMessage());
        }
    }
    //Cambiar apellidos de comprador
    public void cambiarApellidos(Comprador c, String apellidos){
        String query = "update "+TABLA+" set apellidos = ? where usuario = ?;";
        try {
            PreparedStatement preparedStmt = conexion.conectar().prepareStatement(query);
            preparedStmt.setString(1, apellidos);
            preparedStmt.setString(2, c.getUsuario());
            preparedStmt.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println("Estado SQL: "+sqlException.getSQLState());
            System.out.println("Código de error: "+sqlException.getErrorCode());
            System.out.println(sqlException.getMessage());
        }
    }
    //Cambiar foto de comprador
    public void actualizarFoto(String ruta, Comprador c){
        String insert = "UPDATE `bbasket_bd`.`comprador` SET `foto` = ? WHERE `usuario` = ?;";
        FileInputStream fis = null;
        PreparedStatement ps = null;
        try {
            File file = new File(ruta);
            fis = new FileInputStream(file);
            ps = conexion.conectar().prepareStatement(insert);
            ps.setBinaryStream(1,fis,(int)file.length());
            ps.setString(2, c.getUsuario());
            ps.executeUpdate();
        } catch (Exception sqlException) {
            System.out.println(sqlException.getMessage());
        }
    }
    //Cambiar foto de comprador
    public void eliminarFoto(Comprador c){
        String insert = "UPDATE `bbasket_bd`.`comprador` SET `foto` = null WHERE `usuario` = ?;";
        PreparedStatement ps = null;
        try {
            ps = conexion.conectar().prepareStatement(insert);
            ps.setString(1, c.getUsuario());
            ps.executeUpdate();
        } catch (Exception sqlException) {
            System.out.println(sqlException.getMessage());
        }
    }
    //Verificar usuario->contraseña 
    public Comprador usuarioPasswd(String u, String passwd){
        Comprador aux=null;

        String select = "select * from comprador where comprador.usuario='"+u+"' and comprador.contraseña='"+passwd+"';";
        Statement stmt;
        try {
            stmt=conexion.conectar().createStatement();
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
                Blob foto=rs.getBlob("foto");
                String passsword=rs.getString("contraseña");
                aux=new Comprador(id, nombres, apellidos, usuario, correo, foto, passsword);
                System.out.println(aux.toString());
            
        } catch (Exception sqlException) {
            System.out.println(sqlException.getMessage());
        }
        
        return aux;
    }
    //Consulta de todos los compradores
    public List <Comprador> getCompradores(){
        Statement stmt;
        try {
            stmt=conexion.conectar().createStatement();
            ResultSet rs=stmt.executeQuery("select * from "+TABLA);
            if(!rs.next()){
                System.out.println("\nSin compradores registrados en la base de datos.");
            }
            while(rs.next()){
                int id=rs.getInt("id");
                String nombres=rs.getString("nombres");
                String apellidos=rs.getString("apellidos");
                String usuario=rs.getString("usuario");
                String correo=rs.getString("correo");
                Blob foto=rs.getBlob("foto");
                String passsword=rs.getString("contraseña");
                Comprador c=new Comprador(id, nombres, apellidos, usuario, correo, foto, passsword);
                this.compradores.add(c);
                System.out.println(c.toString());
            }
            
        } catch (SQLException sqlException) {
            System.out.println("Estado SQL: "+sqlException.getSQLState());
            System.out.println("Código de error: "+sqlException.getErrorCode());
            System.out.println(sqlException.getMessage());
        }
        return compradores;
    }
}
