package com.uv.bbasket.dao;
//Autor: Omar Alejandro Alonso Lizardi
//Fecha: 17-12-2020
//Sistemas web
//Universidad Veracruzana
//CRUD de los datos de la tabla 'cliente'
//Obtiene los usuarios registrados en la BD
//Es una lista de control muy util

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.uv.bbasket.model.Acceso;
import com.uv.bbasket.util.Conexion;

public class AccesoDAO {
    
    private static final String VISTA="lista_acceso";
    public static List <Acceso> getLista(){
        List<Acceso>lista=new ArrayList<>();
        Statement stmt;
        try {
            stmt=Conexion.conectar().createStatement();
            ResultSet rs=stmt.executeQuery("select * from "+VISTA);
            if(!rs.next()){
                System.out.println("\nSin usuarios registradas en la base de datos.");
            }
            String usuario=rs.getString("usuario");
            String correo=rs.getString("correo");
            Acceso u=new Acceso(usuario, correo);
            System.out.println(u.toString());
            lista.add(u);
            while(rs.next()){
                usuario=rs.getString("producto");
                correo=rs.getString("tamano");
                u=new Acceso(usuario, correo);
                System.out.println(u.toString());
                lista.add(u);                
            }
            
        } catch (SQLException sqlException) {
            System.out.println("Estado SQL: "+sqlException.getSQLState());
            System.out.println("Código de error: "+sqlException.getErrorCode());
            System.out.println(sqlException.getMessage());
        }
        return lista;
    }
}
