package modelo;

import java.util.ArrayList;

/**
 *
 * @author PRR1TL
 */
public interface CargaMasivaDAO {
    
    public void insertarClientes(ArrayList registro) throws Exception;
    public void insertarNumPartes(ArrayList registro) throws Exception;
    public void insertarOperaciones(ArrayList registro) throws Exception;
    public void insertarPerdidas(ArrayList registro) throws Exception;
    
}
