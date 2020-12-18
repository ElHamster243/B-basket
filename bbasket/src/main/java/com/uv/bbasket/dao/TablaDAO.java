package com.uv.bbasket.dao;
//Autor: Omar Alejandro Alonso Lizardi
//Fecha: 17-12-2020
//Sistemas web
//Universidad Veracruzana
//DAO de la vista creada consultar los datos de la vista en MySQL 'tabla'
//Obtiene las ofertas disponibles en el sistema

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.uv.bbasket.model.Tabla;
import com.uv.bbasket.util.Conexion;

public class TablaDAO {
    private static final String VISTA="tabla";
    public static List <Tabla> getTabla(){
        List<Tabla>tabla=new ArrayList<>();
        Statement stmt;
        try {
            stmt=Conexion.conectar().createStatement();
            ResultSet rs=stmt.executeQuery("select * from "+VISTA);
            if(!rs.next()){
                System.out.println("\nSin ofertas registradas en la base de datos.");
            }            
            String producto=rs.getString("producto");
            String tamano=rs.getString("tamano");
            String marca=rs.getString("marca");
            double precio=rs.getDouble("precio");
            String oferta=rs.getString("oferta");
            String tienda=rs.getString("tienda");
            String colonia=rs.getString("colonia");
            String calle=rs.getString("calle");
            String numero=rs.getString("numero");
            Tabla row=new Tabla(producto, tamano, marca, precio, oferta, tienda, colonia, calle, numero);
            System.out.println(row.toString());
            tabla.add(row);
            while(rs.next()){
                producto=rs.getString("producto");
                tamano=rs.getString("tamano");
                marca=rs.getString("marca");
                precio=rs.getDouble("precio");
                oferta=rs.getString("oferta");
                tienda=rs.getString("tienda");
                colonia=rs.getString("colonia");
                calle=rs.getString("calle");
                numero=rs.getString("numero");
                row=new Tabla(producto, tamano, marca, precio, oferta, tienda, colonia, calle, numero);
                System.out.println(row.toString());
                tabla.add(row);               
            }
            
        } catch (SQLException sqlException) {
            System.out.println("Estado SQL: "+sqlException.getSQLState());
            System.out.println("Código de error: "+sqlException.getErrorCode());
            System.out.println(sqlException.getMessage());
        }
        return tabla;
    }
}
