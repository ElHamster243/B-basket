package com.uv.bbasket.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.uv.bbasket.model.AccesosPublico;
import com.uv.bbasket.util.Conexion;

public class AccesosPublicoDAO {
    private Conexion conexion=new Conexion();
    List<AccesosPublico>accesos=new ArrayList<>();
    private static final String TABLA="accesos_publico";
    public List <AccesosPublico> getAccesos(){
        Statement stmt;
        try {
            stmt=conexion.conectar().createStatement();
            ResultSet rs=stmt.executeQuery("select * from "+TABLA);
            if(!rs.next()){
                System.out.println("\nSin compradores registrados en la base de datos.");
            }
            String usuario=rs.getString("usuario");
            String correo=rs.getString("correo");
            String passsword=rs.getString("contraseña");
            AccesosPublico acceso=new AccesosPublico(usuario, correo, passsword);
            this.accesos.add(acceso);
            System.out.println(acceso.getUsuario());
            while(rs.next()){
                usuario=rs.getString("usuario");
                correo=rs.getString("correo");
                passsword=rs.getString("contraseña");
                acceso=new AccesosPublico(usuario, correo, passsword);
                this.accesos.add(acceso);
                System.out.println(acceso.getUsuario());
            }
            
        } catch (SQLException sqlException) {
            System.out.println("Estado SQL: "+sqlException.getSQLState());
            System.out.println("Código de error: "+sqlException.getErrorCode());
            System.out.println(sqlException.getMessage());
        }
        return accesos;
    }
}
