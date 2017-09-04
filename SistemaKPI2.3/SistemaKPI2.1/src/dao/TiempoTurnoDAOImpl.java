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
    
    private final String EXISTE_BITACORA_HORARIO = "SELECT ";
    private final String REGISTRAR_HORARIO_BITACORA = "INSERT INTO TiempoTurno(Linea, Fecha, Turno, HoraInicio, HoraFin, NoPersonal) VALUES (?, TO_DATE(?, 'DD/MM/YYYY'), ?, ?, ?, ?)";
    private final String EXISTE_HORARIO_BITACORA = "SELECT COUNT(*) FROM TiempoTurno WHERE Linea like ? AND Fecha = TO_DATE(?, 'DD/MM/YYYY') AND Turno LIKE ? AND HoraInicio <= ? AND HoraFin >= ?";
    private final String BORRAR_TURNO_REGISTRADO = "DELETE FROM TiempoTurno WHERE Linea LIKE ? AND Fecha = TO_DATE(?, 'DD/MM/YYYY') AND Turno LIKE ?";
    
    @Override
    public boolean horarioExisteBitacora(String linea, String fecha, String turno, int horaInicio, int horaFin) throws Exception {
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(EXISTE_HORARIO_BITACORA);
            ps.setString(1, linea);
            ps.setString(2, fecha);
            ps.setString(3, turno);
            ps.setInt(4, horaInicio);
            ps.setInt(5, horaFin);
            
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

    @Override
    public void registrarHorarioBitacora(String linea, String fecha, String turno, int horaInicio, int horaFin, int noPersonal) throws Exception {
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(REGISTRAR_HORARIO_BITACORA);
            ps.setString(1, linea);
            ps.setString(2, fecha);
            ps.setString(3, turno);
            ps.setInt(4, horaInicio);
            ps.setInt(5, horaFin);
            ps.setInt(6, noPersonal);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
            ps.close();
        }
    }

    @Override
    public void eliminarTurnoVacio(String linea, String fecha, String turno) throws Exception {
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(BORRAR_TURNO_REGISTRADO);
            ps.setString(1, linea);
            ps.setString(2, fecha);
            ps.setString(3, turno);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
            ps.close();
        }
    }
}