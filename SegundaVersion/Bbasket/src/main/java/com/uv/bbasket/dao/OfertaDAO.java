package com.uv.bbasket.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.uv.bbasket.model.Oferta;
import com.uv.bbasket.util.Conexion;
public class OfertaDAO {
    private Conexion conexion=new Conexion();
    List<Oferta>ofertas=new ArrayList<>();
    private static final String TABLA="oferta";
    //Agregar oferta a la base de datos
    public void registrarOferta(Oferta o){
        try {
            String query =  " insert into "+TABLA+" (cantidad, precio, tienda)"
                            + " values (?, ?, ?)";
            PreparedStatement preparedStmt = conexion.conectar().prepareStatement(query);
            preparedStmt.setInt(1, 1);
            preparedStmt.setDouble(2, (o.getPrecio()/o.getCantidad()));
            preparedStmt.setInt(3, o.getTienda());
            preparedStmt.execute();
        } catch (SQLException sqlException) {
            System.out.println("Estado SQL: "+sqlException.getSQLState());
            System.out.println("Código de error: "+sqlException.getErrorCode());
            System.out.println(sqlException.getMessage());
        }
    }
    //Eliminar oferta de la base de datos mediante id
    public void eliminarOferta(int id){
        String query = "delete from "+TABLA+" where id = ?;";
        try {
            PreparedStatement preparedStmt = conexion.conectar().prepareStatement(query);
            preparedStmt.setInt(1, id);
            preparedStmt.execute();
        } catch (SQLException sqlException) {
            System.out.println("Estado SQL: "+sqlException.getSQLState());
            System.out.println("Código de error: "+sqlException.getErrorCode());
            System.out.println(sqlException.getMessage());
        }
    }
    //Cambiar oferta mediante id
    public void cambiarOferta(int id, Oferta o){
        String query = "update "+TABLA+" set cantidad=?, precio=? where id=?;";
        try {
            PreparedStatement preparedStmt = conexion.conectar().prepareStatement(query);
            preparedStmt.setInt(1, 1);
            preparedStmt.setDouble(2, (o.getPrecio()/o.getCantidad()));
            preparedStmt.setInt(3, id);
            preparedStmt.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println("Estado SQL: "+sqlException.getSQLState());
            System.out.println("Código de error: "+sqlException.getErrorCode());
            System.out.println(sqlException.getMessage());
        }
    }
    //Consulta de todas las ofertas
    public List <Oferta> getOfertas(int idTienda){
        Statement stmt;
        try {
            stmt=conexion.conectar().createStatement();
            ResultSet rs=stmt.executeQuery("select * from "+TABLA+" where id=`"+idTienda+"`");
            if(!rs.next()){
                System.out.println("\nSin ofertas registradas en la base de datos.");
            }
            while(rs.next()){
                int id=rs.getInt("id");
                int cantidad=rs.getInt("cantidad");
                double precio=rs.getDouble("precio");
                int tienda=rs.getInt("tienda");
                Oferta o=new Oferta(id, cantidad, precio, tienda);
                this.ofertas.add(o);
                System.out.println(o.toString());
            }
            
        } catch (SQLException sqlException) {
            System.out.println("Estado SQL: "+sqlException.getSQLState());
            System.out.println("Código de error: "+sqlException.getErrorCode());
            System.out.println(sqlException.getMessage());
        }
        return ofertas;
    }
}
