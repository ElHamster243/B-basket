package com.uv.bbasket.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexion {
    public Connection conectar(){
        Connection connection=null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://db4free.net/bbasket_db?user=bbasketadmin&password=sist3m4sW3bzozo");
        }catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        if(connection==null){
            System.out.println("Conexión fallida.");
        }else{
            System.out.println("Conexión establecida.");
        }
        return connection;
    }
}
