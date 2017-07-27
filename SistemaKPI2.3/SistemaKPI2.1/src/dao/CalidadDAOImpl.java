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
    private PreparedStatement ps;
    private ResultSet rs;
    
    private final String LISTA_OPERACIONES = "SELECT operacion FROM operaciones WHERE linea LIKE ? ORDER BY operacion ASC" ;
    private final String LISTA_AREAS = "SELECT area FROM Perdidas WHERE linea LIKE ? AND tema LIKE ? AND operacion LIKE ?";
    
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

}
