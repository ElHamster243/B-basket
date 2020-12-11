package com.uv.bbasket.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.uv.bbasket.model.Producto;
import com.uv.bbasket.util.Conexion;

public class ProductoDAO {
    private Conexion conexion=new Conexion();
    List<Producto>productos=new ArrayList<>();
    private static final String TABLA="producto";
    //Agregar producto a la base de datos
    public void registrarProducto(Producto p){
        try {
            String query =  " insert into "+TABLA+" (nombre, tamano, foto)"
                            + " values (?, ?, ?)";
            PreparedStatement preparedStmt = conexion.conectar().prepareStatement(query);
            preparedStmt.setString(1, p.getNombre());
            preparedStmt.setString(2, p.getTamano());
            preparedStmt.setBlob(3, p.getFoto());
            preparedStmt.execute();
        } catch (SQLException sqlException) {
            System.out.println("Estado SQL: "+sqlException.getSQLState());
            System.out.println("Código de error: "+sqlException.getErrorCode());
            System.out.println(sqlException.getMessage());
        }
    }
    //Eliminar producto de la base de datos mediante el nombre
    public void eliminarProducto(Producto p){
        String query = "delete from "+TABLA+" where nombre = ?;";
        try {
            PreparedStatement preparedStmt = conexion.conectar().prepareStatement(query);
            preparedStmt.setString(1, p.getNombre());
            preparedStmt.execute();
        } catch (SQLException sqlException) {
            System.out.println("Estado SQL: "+sqlException.getSQLState());
            System.out.println("Código de error: "+sqlException.getErrorCode());
            System.out.println(sqlException.getMessage());
        }
    }
    //Cambiar tamano del producto
    public void cambiarTamano(Producto p, String tamano){
        String query = "update "+TABLA+" set tamano = ? where nombre = ?;";
        try {
            PreparedStatement preparedStmt = conexion.conectar().prepareStatement(query);
            preparedStmt.setString(1, tamano);
            preparedStmt.setString(2, p.getNombre());
            preparedStmt.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println("Estado SQL: "+sqlException.getSQLState());
            System.out.println("Código de error: "+sqlException.getErrorCode());
            System.out.println(sqlException.getMessage());
        }
    }
    //Cambiar nombre
    public void cambiarNombre(Producto p, String nombre){
        String query = "update "+TABLA+" set nombre = ? where nombre = ?;";
        try {
            PreparedStatement preparedStmt = conexion.conectar().prepareStatement(query);
            preparedStmt.setString(1, nombre);
            preparedStmt.setString(2, p.getNombre());
            preparedStmt.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println("Estado SQL: "+sqlException.getSQLState());
            System.out.println("Código de error: "+sqlException.getErrorCode());
            System.out.println(sqlException.getMessage());
        }
    }
    //Consulta de todos los productos
    public List <Producto> getProductos(){
        Statement stmt;
        try {
            stmt=conexion.conectar().createStatement();
            ResultSet rs=stmt.executeQuery("select * from "+TABLA);
            if(!rs.next()){
                System.out.println("\nSin productos registrados en la base de datos.");
            }
            while(rs.next()){
                int id=rs.getInt("id");
                String nombre=rs.getString("nombre");
                String tamano=rs.getString("tamano");
                Blob foto=rs.getBlob("foto");
                Producto p=new Producto(id, nombre, tamano, foto);
                this.productos.add(p);
            }
            
        } catch (SQLException sqlException) {
            System.out.println("Estado SQL: "+sqlException.getSQLState());
            System.out.println("Código de error: "+sqlException.getErrorCode());
            System.out.println(sqlException.getMessage());
        }
        return productos;
    }
}
