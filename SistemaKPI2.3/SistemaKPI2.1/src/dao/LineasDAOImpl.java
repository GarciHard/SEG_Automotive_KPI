package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import modelo.ConexionBD;
import modelo.LineasDAO;

/**
 * Hecho con <3 por:
 * @author GarciHard
 * @boschUsr GJA5TL
 */
public class LineasDAOImpl extends ConexionBD implements LineasDAO {

    private ArrayList<String> lineaArr;
    private PreparedStatement ps;
    private ResultSet rs;
    
    private final String LISTA_LINEAS = "SELECT linea FROM Lineas ORDER BY linea ASC";
    
    @Override
    public DefaultComboBoxModel listaLineas() throws Exception {
        lineaArr = new ArrayList<>();
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(LISTA_LINEAS);
            rs = ps.executeQuery();

            while (rs.next()) {
                lineaArr.add(rs.getString(1));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ps.close();
            rs.close();
            this.cerrar();
        }
        return new DefaultComboBoxModel(lineaArr.toArray());
    }
}
