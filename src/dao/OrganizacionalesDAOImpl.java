package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import modelo.ConexionBD;
import modelo.OrganizacionalesDAO;

/**
 * Hecho con <3 por:
 * @author garcihard
 */
public class OrganizacionalesDAOImpl extends ConexionBD implements OrganizacionalesDAO {
    
    private ArrayList<String> areaArr;
    private ArrayList<String> problemaArr;
    private PreparedStatement ps;
    private ResultSet rs;
    
    private final String LISTA_AREAS = "SELECT area FROM Perdidas WHERE linea LIKE ? AND tema LIKE ? GROUP BY area ORDER BY area ASC";
    private final String LISTA_PROBLEMAS = "SELECT problema FROM Perdidas WHERE linea LIKE ? AND tema LIKE ? AND area LIKE ? GROUP BY problema ORDER BY problema ASC";
        
    @Override
    public DefaultComboBoxModel listaAreasOrganizacional(String linea, String tema) throws Exception {
        areaArr = new ArrayList<>();
        areaArr.add("Seleccione un área");
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(LISTA_AREAS);
            ps.setString(1, linea);
            ps.setString(2, tema);
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
    public DefaultComboBoxModel listaProblemasOrganizacional(String linea, String tema, String area) throws Exception {
        problemaArr = new ArrayList<>();
        problemaArr.add("Seleccione un problema");
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(LISTA_PROBLEMAS);
            ps.setString(1, linea);
            ps.setString(2, tema);
            ps.setString(3, area);
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