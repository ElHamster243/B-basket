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
    public void registrarOferta(Tienda t){
        try {
            String query =  " insert into "+TABLA+
            " (nombre, entidad_federativa, ciudad, "+
            "colonia, calle, numero, codigo_postal, tipo, "+
            "contraseña, id_comprador) values (?, ?, ?, ?, ?, ?, ?, ? ,?, ?, ?)";
            PreparedStatement preparedStmt = conexion.conectar().prepareStatement(query);
            preparedStmt.setString(1, t.getNombre());
            preparedStmt.setInt(2, t.getEntidad());
            preparedStmt.setString(3, t.getCiudad());
            preparedStmt.setString(4, t.getColonia());
            preparedStmt.setString(5, t.getCalle());
            preparedStmt.setString(6, t.getNumero());
            preparedStmt.setString(7, t.getCoPo());
            preparedStmt.setInt(8, t.getTipo());
            preparedStmt.setString(9, t.getPasswd());
            preparedStmt.setInt(10, t.getComprador());
            preparedStmt.execute();
        } catch (SQLException sqlException) {
            System.out.println("Estado SQL: "+sqlException.getSQLState());
            System.out.println("Código de error: "+sqlException.getErrorCode());
            System.out.println(sqlException.getMessage());
        }
    }
}
