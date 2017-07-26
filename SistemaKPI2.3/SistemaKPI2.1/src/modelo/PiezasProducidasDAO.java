package modelo;

import javax.swing.DefaultComboBoxModel;

/**
 * Hecho con <3 por:
 * @author GarciHard
 * @boschUsr GJA5TL
 */
public interface PiezasProducidasDAO {

    public DefaultComboBoxModel listaClientes(String linea) throws Exception;
    public DefaultComboBoxModel listaNoParte(String linea, String cliente) throws Exception;
    public void agregarPiezasProducidasBitacora(BitacoraDTO piezasProducidasObj);
    
}
