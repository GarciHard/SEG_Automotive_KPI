package modelo;

/**
 * Hecho con <3 por:
 * @author GarciHard
 * @boschUsr GJA5TL
 */
public interface TiempoTurnoDAO {

    public boolean horarioExisteBitacora(String linea, String fecha, int horaInicio, int horaFin) throws Exception;
}