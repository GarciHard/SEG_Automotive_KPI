package modelo;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 * Hecho con <3 por:
 * @author GarciHard
 * @boschUsr GJA5TL
 */
public interface LineasDAO {

    public boolean existeLinea(String linea) throws Exception;
    public void crearNvaLinea(String linea, String tipo, String nombre) throws Exception;
    public DefaultComboBoxModel listaLineas() throws Exception;
    public void actualizarLinea(String lineaAct, Object[] lineaNva) throws Exception;
    public void eliminarLinea(String linea) throws Exception;
    public DefaultTableModel listaLineasDesc(DefaultTableModel tablaModel) throws Exception;
    public String[] buscarRegistro(String linea) throws Exception;
    public int tipoEnsambleLinea(String linea) throws Exception;
    
}
