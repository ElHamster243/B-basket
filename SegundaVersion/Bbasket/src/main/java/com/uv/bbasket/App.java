package com.uv.bbasket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.uv.bbasket.dao.CompradorDAO;
import com.uv.bbasket.dao.OfertaDAO;
import com.uv.bbasket.dao.ProductoDAO;
import com.uv.bbasket.model.Oferta;
import com.uv.bbasket.model.Producto;
import com.uv.bbasket.model.Vista;
import com.uv.bbasket.util.Conexion;

import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
public class App 
{
    public static void main(String[] args){

        staticFiles.location("public/");
        port(4567);
        List <Vista>vistas=new ArrayList<>();
        Vista v=new Vista(1, "Cocacola", 13.50, "600ml");
        vistas.add(v);

        get("/index", (req, res) ->{
            Map<String, Object> modelo = new HashMap<>();
            modelo.put("vistas", vistas);
            modelo.put("proyecto", "B-basket");
            
            return new ModelAndView(modelo, "spark/velocity/index/index.vm");
        }, new VelocityTemplateEngine());

        get("/vendedor", (req, res) ->{
            Map<String, Object> modelo = new HashMap<>();
            modelo.put("vistas", vistas);
            modelo.put("proyecto", "B-basket");
            
            return new ModelAndView(modelo, "spark/velocity/vendedor/indexVendedor.vm");
        }, new VelocityTemplateEngine());
    }
    
}
