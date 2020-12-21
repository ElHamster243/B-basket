package mx.uv.web.bbasket.util;
//Autor: Omar Alejandro Alonso Lizardi
//Fecha: 17-12-2020
//Sistemas web
//Universidad Veracruzana
//Aqui se definen las rutas mediante la dependencia lombok.*


import lombok.*;

public class Path {
    //Rutas http
    public static class Web {
        //Deben de declararse en el mismo orden para que funcione
        //get index
        @Getter public static final String INDEX = "";
        //get acceso
        @Getter public static final String ACCESO = "/acceso";
        //post acceder
        @Getter public static final String ACCEDER = "/acceder";
        //get crear cuenta
        @Getter public static final String REGISTRO = "/registro";
        //get crear cuenta
        @Getter public static final String REGISTRAR = "/registrar";
        //get bienvenida
        @Getter public static final String BIENVENIDA = "/:usuario/:password/bienvenida";
        //get perfil
        @Getter public static final String PERFIL = "/:usuario/:password/perfil";
    }
    //Rutas de los Templates
    public static class Template {
        //Deben de declararse en el mismo orden para que funcione
        //Velocity index
        public static final String INDEX = "spark/velocity/index.vm";
        //Velocity acceso
        public static final String ACCESO = "spark/velocity/acceso.vm";
        //Velocity acceder
        public static final String ACCEDER = "spark/velocity/acceder.vm";
        //Velocity registro
        public static final String REGISTRO = "spark/velocity/registro.vm";
        //Velocity registro
        public static final String REGISTRAR = "spark/velocity/registro.vm";
        //Velocity bienvenida
        public static final String BIENVENIDA = "spark/velocity/bienvenida.vm";  
        //Velocity perfil
        public static final String PERFIL = "spark/velocity/perfil.vm";        
    }
}