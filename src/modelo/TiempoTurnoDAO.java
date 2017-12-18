package modelo;

import java.sql.Date;

/**
 * Hecho con <3 por:
 * @author GarciHard
 * @boschUsr GJA5TL
 */
public interface TiempoTurnoDAO {

    public void eliminarTurnoVacio(String linea, String fecha, String turno) throws Exception;
    public void registrarHorarioBitacora(String linea, Date fecha, String turno, int horaInicio, int horaFin, int noPersonal) throws Exception;
    public boolean horarioExisteBitacora(String linea, String fecha, String turno, int horaInicio, int horaFin) throws Exception;
}