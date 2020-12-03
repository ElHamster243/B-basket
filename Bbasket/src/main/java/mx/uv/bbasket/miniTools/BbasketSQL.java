package mx.uv.bbasket.miniTools;
import java.awt.Image;
import java.io.IOException;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BbasketSQL {
    public String selectAll(String tabla){
        return "select * from "+tabla+";";
    } 
    public Image abrirImagen(Blob imagen) throws SQLException, IOException
    {
        Image rpta=null;
        rpta= javax.imageio.ImageIO.read(imagen.getBinaryStream());
        return rpta;
    }
}
