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
    private String dbName = "DB_SystemKPI_SQL";
    private String serverName = "SGLERSQL01";
    private String serverPort = "1433";
    private String userName = "USRKPI";
    private String password = "nZQI5NZZN8smsSsc";

    public Connection getConexion() {
        return conexion;
    }
    
    //DRIVER JDBC ACCESS
    //private final String driverJDBC = "net.ucanaccess.jdbc.UcanaccessDriver";
    
    //DRIVER JDBC SQLSERVER
    private final String driverJDBCSQLServer = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    
    //URL PRODUCCION
    //private final String urlDB = "jdbc:ucanaccess://" + "I:/Dept/MOE1/Shared/Informacion_general/proyectos  SG/Proyecto OEE/BD/SystemKPI.accdb";
    
    //URL PRUEBA GITHUB
    //private final String urlDB = "jdbc:ucanaccess://" + "src/db/SystemKPI.accdb";
    
    //URL PRUEBA MAC
    //private final String urlDB = "jdbc:ucanaccess://" + "/Users/garcihard/Desktop/SystemKPI.accdb";
    
    //URL PRUEBA GJA5TL - BOSCH SERVER
    //private final String urlDB = "jdbc:ucanaccess://" + "C:/Users/GJA5TL/Desktop/SystemKPI.accdb";
    
    //URL PRUEBA GJASTL - SEG SERVER
    //private final String urlDB = "jdbc:ucanaccess://" + "C:/Users/GJA5TL.SG/Desktop/SystemKPI.accdb";

    //URL PRUEBA PRR1TL
    //private final String urlDB = "jdbc:ucanaccess://" + "C:/Users/PRR1TL.SG/Desktop/SystemKPI.accdb";
    
    //URL SERVIDOR SQLSERVER - SEG
    private final String urlDB = "jdbc:sqlserver://"+serverName+"\\SQLEXPRESS:"+serverPort+";databaseName="+dbName+";user="+userName+";password="+password+";";
    
    public void conectar() throws Exception {
        try {
            Class.forName(driverJDBCSQLServer);
            conexion = DriverManager.getConnection(urlDB);
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
