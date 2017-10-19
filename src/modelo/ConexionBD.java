package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Hecho con <3 por:
 * @author GarciHard
 * @boschUsr GJA5TL
 */
public class ConexionBD {
    
    protected Connection conexion;

    public Connection getConexion() {
        return conexion;
    }
    
    private final String driverJDBC = "net.ucanaccess.jdbc.UcanaccessDriver";
    
    //URL PRODUCCION
    //private final String urlDB = "jdbc:ucanaccess://" + "I:/Dept/MOE1/Shared/Informacion_general/proyectos  SG/Proyecto OEE/BD/SystemKPI.accdb";
    
    //URL PRUEBA GITHUB
    //private final String urlDB = "jdbc:ucanaccess://" + "src/db/SystemKPI.accdb";
    
    //URL PRUEBA MAC
    //private final String urlDB = "jdbc:ucanaccess://" + "/Users/garcihard/Desktop/SystemKPI.accdb";
    
    //URL PRUEBA GJA5TL
    //private final String urlDB = "jdbc:ucanaccess://" + "C:/Users/GJA5TL/Desktop/SystemKPI.accdb";
    
    //URL PRUEBA PRR1TL
    private final String urlDB = "jdbc:ucanaccess://" + "C:/Users/PRR1TL/Desktop/SystemKPI.accdb";
    
    public void conectar() throws Exception {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            conexion = DriverManager.getConnection(urlDB);
            Class.forName(driverJDBC);
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }

    public void cerrar() throws Exception {
        try {
            if (conexion != null) {
                if (!conexion.isClosed()) {
                    conexion.close();
                }
            }
        } catch (SQLException e) {
            throw e;
        }
    }   
    
}
