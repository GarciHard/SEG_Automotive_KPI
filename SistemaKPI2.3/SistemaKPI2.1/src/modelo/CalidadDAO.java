package modelo;

import javax.swing.DefaultComboBoxModel;

/**
 * Hecho con <3 por:
 * @author garcihard
 */
public interface CalidadDAO {
    
    public DefaultComboBoxModel listaOperacionCalidad(String linea) throws Exception;
    public DefaultComboBoxModel listaAreaCalidad(String linea, String tema, String operacion) throws Exception;
}
