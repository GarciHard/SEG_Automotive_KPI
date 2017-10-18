/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author PRR1TL
 */
public interface ConsultaPorTurno {
     public DefaultComboBoxModel listaTurnos(String fecha, String linea) throws Exception;
    public int consultaInicioTurno(String fecha, String linea, String turno) throws Exception;
    public int consultaFinTurno(String fecha, String linea, String turno) throws Exception;
}
