package mx.uv.bbasket;

import java.util.List;

import mx.uv.bbasket.DAO.CompradorDAO;
import mx.uv.bbasket.DAO.objects.Comprador;
 
public class App 
{
    public static void main(String[] args){
        System.out.println("B-BASKET");
        CompradorDAO compradorDAO=new CompradorDAO();
        List<Comprador>compradoresBD=compradorDAO.getCompradores();
        
    }
}