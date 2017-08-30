package modelo;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 * Hecho con <3 por:
 * @author GarciHard
 * @boschUsr GJA5TL
 */
public interface BitacoraDAO {
    
    public void insertarFilaRegistro(ArrayList registroFila) throws Exception;
    public void insertarRegistroAccess(ArrayList registro) throws Exception;
    public void borrarRegistroTiempo(int horaInicio, int horaFin) throws Exception;
    public void borrarFilaRegistro(ArrayList bRegistroFila) throws Exception;
    public void borrarRegistroFechaAccess(String fecha) throws Exception;
    public ArrayList existeFechaBitacora(String fecha, DefaultTableModel bitacora) throws Exception;
    public ArrayList listarBitacoras(String fecha, String linea) throws Exception;
}
