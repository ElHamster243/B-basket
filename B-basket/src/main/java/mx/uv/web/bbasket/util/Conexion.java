package mx.uv.web.bbasket.util;
//Autor: Omar Alejandro Alonso Lizardi
//Fecha: 17-12-2020
//Sistemas web
//Universidad Veracruzana
//Conexion a la base de datos

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexion {
    //Atributos privados de la conexión
    private static Connection c = null;
    private static String direccion = "jdbc:mysql://db4free.net/bbasket_db?user=bbasketadmin&password=sist3m4sW3bzozo";
    //Método estatico (que no requiere instancia) de la conexion a la base de datos
    public static Connection conectar(){
        try {
            //Conexion con el servidor en la nube. Se especifica el driver, host, base de datos, usuario y contraseña
            c = DriverManager.getConnection(direccion);
        }catch(SQLException ex){
            //Se maneja la excepción y se envia el mensaje a consola.
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        if(c==null){
            //Mensaje de conexion nula
            System.out.println("Conexión fallida.");
        }else{
            //Mensaje de conexion exitosa
            System.out.println("Conexión establecida (db4free.net)");
        }
        return c;
    }
}
