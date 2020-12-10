package com.uv.bbasket.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.uv.bbasket.model.TablaIndex;
import com.uv.bbasket.util.Conexion;
public class TablaIndexDAO {
   
    private Conexion conexion=new Conexion();
    List<TablaIndex>tabla=new ArrayList<>();
    private static final String VISTA="tabla_index";
    public List <TablaIndex> getTabla(){
        Statement stmt;
        try {
            stmt=conexion.conectar().createStatement();
            ResultSet rs=stmt.executeQuery("select * from "+VISTA);
            if(!rs.next()){
                System.out.println("\nSin ofertas registradas en la base de datos.");
            }
            int id=rs.getInt("id");
            String producto=rs.getString("producto");
            String tamano=rs.getString("tamano");
            Double precio=rs.getDouble("precio");
            String colonia=rs.getString("colonia");
            String tiendaNombre=rs.getString("nombre_tienda");
            TablaIndex ti=new TablaIndex(id, producto, tamano, precio, colonia, tiendaNombre);
            System.out.println(id+producto);
            tabla.add(ti);
            while(rs.next()){
                id=rs.getInt("id");
                producto=rs.getString("producto");
                tamano=rs.getString("tamano");
                precio=rs.getDouble("precio");
                colonia=rs.getString("colonia");
                tiendaNombre=rs.getString("nombre_tienda");
                ti=new TablaIndex(id, producto, tamano, precio, colonia, tiendaNombre);
                System.out.println(id+producto);
                tabla.add(ti);                
            }
            
        } catch (SQLException sqlException) {
            System.out.println("Estado SQL: "+sqlException.getSQLState());
            System.out.println("Código de error: "+sqlException.getErrorCode());
            System.out.println(sqlException.getMessage());
        }
        return tabla;
    }
}
