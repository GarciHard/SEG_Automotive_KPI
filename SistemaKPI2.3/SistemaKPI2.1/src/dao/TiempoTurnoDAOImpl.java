package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.ConexionBD;
import modelo.TiempoTurnoDAO;

/**
 * Hecho con <3 por:
 * @author GarciHard
 * @boschUsr GJA5TL
 */
public class TiempoTurnoDAOImpl extends ConexionBD implements TiempoTurnoDAO {

    private boolean existeHorario;
    private PreparedStatement ps;
    private ResultSet rs;
    
    private final String EXISTE_HORARIO_BITACORA = "SELECT COUNT(*) FROM Bitacora WHERE linea like ? AND fecha = TO_DATE(?, 'DD/MM/YYYY') AND hora BETWEEN ? AND ?";
    
    @Override
    public boolean horarioExisteBitacora(String linea, String fecha, int horaInicio, int horaFin) throws Exception {
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(EXISTE_HORARIO_BITACORA);
            ps.setString(1, linea);
            ps.setString(2, fecha);
            ps.setInt(3, horaInicio);
            ps.setInt(4, horaFin);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                int valorHorario = rs.getInt(1);
                if (valorHorario > 0) {
                    existeHorario = true;
                }
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ps.close();
            rs.close();
            this.cerrar();
        }
        return existeHorario;
    }

}