package mx.uv.bbasket;

 import mx.uv.bbasket.DAO.Conexion;
 
public class App 
{
    public static void main(String[] args){
        System.out.println("B-BASKET");
        Conexion conexion=new Conexion();
        conexion.conectar();
    }
}