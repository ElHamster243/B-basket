package com.uv.bbasket.dao;

import com.uv.bbasket.util.Conexion;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.uv.bbasket.model.Direccion;
    public class DireccionDAO {
        private Conexion conexion=new Conexion();
        List<Direccion>direcciones=new ArrayList<>();
        private static final String TABLA="direccion";
        public void cambiarDireccionById(int id, Direccion d){
            String query = "update "+TABLA+" set ciudad = ?, colonia=?, calle=?, numero=?, codigo_postal=? where id = ?;";
            try {
                PreparedStatement preparedStmt = conexion.conectar().prepareStatement(query);
                preparedStmt.setString(1, d.getCiudad());
                preparedStmt.setString(2, d.getColonia());
                preparedStmt.setString(3, d.getCalle());
                preparedStmt.setString(4, d.getNumero());
                preparedStmt.setString(5, d.getCP());
                preparedStmt.setInt(6, id);
                preparedStmt.executeUpdate();
            } catch (SQLException sqlException) {
                System.out.println("Estado SQL: "+sqlException.getSQLState());
                System.out.println("Código de error: "+sqlException.getErrorCode());
                System.out.println(sqlException.getMessage());
            }
        } 
        public void agregarDireccion(Direccion d){
            try {
                String query =  " insert into "+TABLA+" (id, entidad, tienda, ciudad, colonia, calle, numero, codigo_postal)"
                                + " values (0, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStmt = conexion.conectar().prepareStatement(query);
                preparedStmt.setInt(1, d.getEntidad());
                preparedStmt.setInt(2, d.getTienda());
                preparedStmt.setString(3, d.getCiudad());
                preparedStmt.setString(4, d.getColonia());
                preparedStmt.setString(5, d.getCalle());
                preparedStmt.setString(6, d.getNumero());
                preparedStmt.setString(7, d.getCP());
                preparedStmt.execute();
            } catch (SQLException sqlException) {
                System.out.println("Estado SQL: "+sqlException.getSQLState());
                System.out.println("Código de error: "+sqlException.getErrorCode());
                System.out.println(sqlException.getMessage());
            }
        }
}
