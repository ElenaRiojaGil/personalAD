package sqlite;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class EjemploPrepareStatementSQlite {
    public static void main(String[] args) {
        try {
        	// CARGAR EL CONTROLADOR JDBC de la base de datos
        	Class.forName("org.sqlite.JDBC");
        	
        	// ESTABLECER LA CONEXI�N con la base de datos
            Connection conexion = DriverManager.getConnection("jdbc:sqlite:src\\sqlite\\biblioteca.db");
            // parametro 1 = Driver que utilizamos y ruta y nombre de la base de datos
            //				jdbc:sqlite:C:\\Users\\Eva Royo\\Documents\\BBDD\\sqlite\\biblioteca.db
            // parametro 2 = nombre del usuario
            // parametro 3 = contrase�a del usuario

            
            // PREPARAMOS LA SENTENCIA SQL
            //Statement sentencia = (Statement) conexion.createStatement();
            String sql = "INSERT INTO prestamo VALUES (?,?,?,?)";
            PreparedStatement pstm = conexion.prepareStatement(sql);
            pstm.setInt(1, 2);
            pstm.setInt(2, 2);
            pstm.setString(3, "2023-11-09");
            pstm.setString(4, "2023-11-19");
            //3,5,'2021-11-09','2021-11-19'
            int cantidad = pstm.executeUpdate();
            //int cantidad = sentencia.executeUpdate(sql);
            
            
            // recorro el resultado
            System.out.println("se han insertado " + cantidad + " prestamos");
            
            // LIBRERAR LOS RECURSOS
            //resultado.close();
            //sentencia.close();
            conexion.close();
            
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error en la conexión de la base de datos");
            ex.printStackTrace();
        }
    }
}