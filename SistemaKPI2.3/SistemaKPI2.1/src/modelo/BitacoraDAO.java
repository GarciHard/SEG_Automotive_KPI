package modelo;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 * Hecho con <3 por:
 * @author GarciHard
 * @boschUsr GJA5TL
 */
public interface BitacoraDAO {
    
    public void insertarRegistroAccess(ArrayList registro) throws Exception;
    public ArrayList existeFechaBitacora(String fecha, DefaultTableModel bitacora) throws Exception;

}