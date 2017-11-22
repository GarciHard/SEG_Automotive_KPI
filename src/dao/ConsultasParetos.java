package dao;

import modelo.CalidadDAO;
import modelo.ConexionBD;

/**
 *
 * @author PRR1TL
 */
public class ConsultasParetos extends ConexionBD {
    
    //CONSULTAS PARA PIEZAS PRODUCIDAS
    private final String PZAS_ANIO = "SELECT Anio, SUM(cantPzas) FROM Bitacora WHERE linea LIKE ?  AND anio LIKE ? GROUP BY anio";
    private final String PZAS_MES = "SELECT mes, SUM (cantPzas) FROM Bitacora WHERE linea LIKE ? AND anio LIKE ? AND Mes <= ? GROUP BY mes";
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
    
    
    
    
}
