package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.CalidadDAO;
import modelo.ConexionBD;
import vista.Reportes;

/**
 *
 * @author PRR1TL
 */
public class ConsultasParetos extends ConexionBD {
    
    private ArrayList lisPzasAnio;
    private ArrayList lisPzasMes;
    private ArrayList lisPzasDia;
    private ArrayList lisPzasDesglos;
    
    private PreparedStatement ps;
    private ResultSet rs;
    
    //CONSULTAS PARA PIEZAS PRODUCIDAS
    private final String PZAS_ANIO = "SELECT Anio FROM Bitacora WHERE linea LIKE ?  AND anio LIKE ? GROUP BY anio";
    private final String PZAS_MES = "SELECT mes, SUM (cantPzas) FROM Bitacora WHERE linea LIKE ? AND anio LIKE ? GROUP BY mes";
    private final String PZAS_DIA = "SELECT dia, SUM (cantPzas) FROM Bitacora WHERE linea LIKE ? AND anio LIKE ? AND mes LIKE ? GROUP BY dia";
    private final String PZAS_DESGLOS = "SELECT dia, cliente, noParte, SUM (cantPzas) FROM Bitacora WHERE linea LIKE ? AND anio LIKE ? AND mes LIKE ? GROUP BY dia, cliente";
    
    //CONSULTA PARA PAROS TECNICOS
    private final String TECNICOS_ANIO = "SELECT anio, SUM (duracion) FROM Bitacora WHERE tema = 'Tecnizas' AND linea LIKE ? AND anio LIKE ? GROUP BY anio";
    private final String TECNICOS_MES = "SELECT mes, SUM (duracion) FROM Bitacora WHERE tema = 'Tecnizas' AND linea LIKE ? AND anio LIKE ? AND mes <= ? GROUP BY mes";
    private final String TECNICOS_DIA = "SELECT dia, SUM (duracion) FROM Bitacora WHERE tema = 'Tecnizas' AND linea LIKE ? AND anio LIKE ? AND mes LIKE ? GROUP BY dia";
    private final String TECNICOS_DESGLOS = "SELECT area, problema, SUM (duracion) FROM Bitacora WHERE tema = 'Tecnizas' AND LIKE ? AND anio LIKE ? AND mes LIKE ? GROUP BY problema";
    
    //CONSULTA PARA PAROS ORGANIZACIONALES 
    private final String ORG_ANIO = "SELECT anio, SUM (duracion) FROM Bitacora WHERE tema = 'Tecnizas' AND linea LIKE ? AND anio LIKE ? GROUP BY anio";
    private final String ORG_MES = "SELECT mes, SUM (duracion) FROM Bitacora WHERE tema = 'Tecnizas' AND linea LIKE ? AND anio LIKE ? AND mes <= ? GROUP BY mes";
    private final String ORG_DIA = "SELECT dia, SUM (duracion) FROM Bitacora WHERE tema = 'Tecnizas' AND linea LIKE ? AND anio LIKE ? AND mes LIKE ? GROUP BY dia";
    private final String ORG_DESGLOS = "SELECT area, problema, SUM (duracion) FROM Bitacora WHERE tema = 'Tecnizas' AND LIKE ? AND anio LIKE ? AND mes LIKE ? GROUP BY problema";
    
    public ArrayList conPzasAnio (String linea, String anio) throws Exception{
        Object[] bitacoraObj;
        lisPzasAnio = new ArrayList();  
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(PZAS_MES);
            ps.setString(1, linea);
            ps.setString(2, anio);
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                bitacoraObj = new Object[3];
                bitacoraObj[0] = rs.getString(1);
                bitacoraObj[1] = rs.getString(2);
                
            }
            
        } catch (Exception e) {
            throw e;
        } finally {
            ps.close();
            rs.close();
            this.cerrar();
        }
        return lisPzasAnio;
    }    
    
}
