package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import modelo.CalidadDAO;
import modelo.ConexionBD;

/**
 * Hecho con <3 por:
 * @author garcihard
 */
public class CalidadDAOImpl extends ConexionBD implements CalidadDAO{

    private ArrayList<String> areaArr;
    private ArrayList<String> operacionArr;
    private ArrayList<String> problemaArr;
    private PreparedStatement ps;
    private ResultSet rs;
    
    private final String LISTA_OPERACIONES = "SELECT operacion FROM operaciones WHERE linea LIKE ? ORDER BY operacion ASC" ;
    private final String LISTA_AREAS = "SELECT area FROM Perdidas WHERE linea LIKE ? AND tema LIKE ? AND operacion LIKE ? GROUP BY area";
    private final String LISTA_PROBLEMAS = "SELECT problema FROM Perdidas WHERE linea LIKE ? AND tema LIKE ? AND operacion LIKE ? AND area LIKE ? ORDER BY problema ASC";
    
    @Override
    public DefaultComboBoxModel listaAreaCalidad(String linea, String tema, String operacion) throws Exception {
        areaArr = new ArrayList<>();
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(LISTA_AREAS);
            ps.setString(1, linea);
            ps.setString(2, tema);
            ps.setString(3, operacion);
            rs = ps.executeQuery();

            while (rs.next()) {
                areaArr.add(rs.getString(1));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ps.close();
            rs.close();
            this.cerrar();
        }
        return new DefaultComboBoxModel(areaArr.toArray());
    }
            
    @Override
    public DefaultComboBoxModel listaOperacionCalidad(String linea) throws Exception {
        operacionArr = new ArrayList<>();
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(LISTA_OPERACIONES);
            ps.setString(1, linea);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                operacionArr.add(rs.getString(1));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ps.close();
            rs.close();
            this.cerrar();
        }
        return new DefaultComboBoxModel(operacionArr.toArray());
    }

    @Override
    public DefaultComboBoxModel listaProblemaCalidad(String linea, String tema, String operacion, String area) throws Exception {
        problemaArr = new ArrayList<>();
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(LISTA_PROBLEMAS);
            ps.setString(1, linea);
            ps.setString(2, tema);
            ps.setString(3, operacion);
            ps.setString(4, area);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                problemaArr.add(rs.getString(1));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ps.close();
            rs.close();
            this.cerrar();
        }
        return new DefaultComboBoxModel(problemaArr.toArray());
    }    
}
