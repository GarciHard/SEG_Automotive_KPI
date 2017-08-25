package modelo;

/**
 * Hecho con <3 por:
 * @author GarciHard
 * @boschUsr GJA5TL
 */
public interface TiempoTurnoDAO {

    public void registrarHorarioBitacora(String linea, String fecha, String turno, int horaInicio, int horaFin, int noPersonal) throws Exception;
    public boolean horarioExisteBitacora(String linea, String fecha, String turno) throws Exception;
}