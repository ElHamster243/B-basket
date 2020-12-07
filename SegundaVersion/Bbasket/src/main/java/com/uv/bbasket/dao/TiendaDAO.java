package com.uv.bbasket.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.uv.bbasket.model.Tienda;
import com.uv.bbasket.util.Conexion;
public class TiendaDAO {
    private Conexion conexion=new Conexion();
    List<Tienda>tiendas=new ArrayList<>();
    private static final String TABLA="tienda";
    //Agregar oferta a la base de datos
    public void registrarTienda(Tienda t){
        try {
            String query =  " insert into "+TABLA+" (id, nombre, tipo, contraseña, id_comprador) values (0, ?, ?, ?, ?);";
            PreparedStatement preparedStmt = conexion.conectar().prepareStatement(query);
            preparedStmt.setString(1, t.getNombre());
            preparedStmt.setInt(2, t.getTipo());
            preparedStmt.setString(3, t.getPasswd());
            preparedStmt.setInt(4, t.getComprador());
            preparedStmt.execute();
        } catch (SQLException sqlException) {
            System.out.println("Estado SQL: "+sqlException.getSQLState());
            System.out.println("Código de error: "+sqlException.getErrorCode());
            System.out.println(sqlException.getMessage());
            System.out.println(sqlException.getSQLState());
        }
    }
    public void bajaTiendaById(Tienda c){
        String query = "delete from "+TABLA+" where id = ?;";
        try {
            PreparedStatement preparedStmt = conexion.conectar().prepareStatement(query);
            preparedStmt.setInt(1, c.getId());
            preparedStmt.execute();
        } catch (SQLException sqlException) {
            System.out.println("Estado SQL: "+sqlException.getSQLState());
            System.out.println("Código de error: "+sqlException.getErrorCode());
            System.out.println(sqlException.getMessage());
        }
    }
    public void cambiarNombre(Tienda t, String nombre){
        String query = "update "+TABLA+" set nombre = ? where id = ?;";
        try {
            PreparedStatement preparedStmt = conexion.conectar().prepareStatement(query);
            preparedStmt.setString(1, nombre);
            preparedStmt.setInt(2, t.getId());
            preparedStmt.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println("Estado SQL: "+sqlException.getSQLState());
            System.out.println("Código de error: "+sqlException.getErrorCode());
            System.out.println(sqlException.getMessage());
        }
    }
    public void cambiarTipo(Tienda t){
        String query = "update "+TABLA+" set tipo = ? where id = ?;";
        try {
            PreparedStatement preparedStmt = conexion.conectar().prepareStatement(query);
            preparedStmt.setInt(1, t.getTipo());
            preparedStmt.setInt(2, t.getId());
            preparedStmt.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println("Estado SQL: "+sqlException.getSQLState());
            System.out.println("Código de error: "+sqlException.getErrorCode());
            System.out.println(sqlException.getMessage());
        }
    }
    public void cambiarPasswd(Tienda t){
        String query = "update "+TABLA+" set contraseña = ? where id = ?;";
        try {
            PreparedStatement preparedStmt = conexion.conectar().prepareStatement(query);
            preparedStmt.setString(1, t.getPasswd());
            preparedStmt.setInt(2, t.getId());
            preparedStmt.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println("Estado SQL: "+sqlException.getSQLState());
            System.out.println("Código de error: "+sqlException.getErrorCode());
            System.out.println(sqlException.getMessage());
        }
    }
    public Tienda loggeoTienda(int id, String passwd){
        Tienda aux=null;

        String select = "select * from tienda where tienda.id='"+id+"' and comprador.contraseña='"+passwd+"';";
        Statement stmt;
        try {
            stmt=conexion.conectar().createStatement();
            ResultSet rs=stmt.executeQuery(select);
            if(!rs.next()){
                System.out.println("\nSin coincidencias registradas en la base de datos.");
                System.out.println("\nVerificar contraseña o usuario.");
            }
                
                String nombre=rs.getString("nombre");
                int tipo=rs.getInt("tipo");
                String usuario=rs.getString("contraseña");
                int comprador=rs.getInt("id_comprador");
                aux=new Tienda(id, nombre, tipo, usuario, comprador);
                System.out.println(aux.toString());
            
        } catch (Exception sqlException) {
            System.out.println(sqlException.getMessage());
        }
        
        return aux;
    }
}
