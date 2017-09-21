/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author PRR1TL
 */
public interface ReportesDAO {
    
    public DefaultComboBoxModel listaLineasBitacora() throws Exception;    
    public DefaultComboBoxModel listaClientesProduccion (String linea, String tema, String fechaInicial, String fechaFinal) throws Exception;
    public DefaultComboBoxModel listaClientesScrap(String linea, String tema, String fechaInicial, String fechaFinal) throws Exception;
    public DefaultComboBoxModel listaNoParteProduccion (String linea, String tema, String cliente, String fechaInicial, String fechaFinal) throws Exception;
    public DefaultComboBoxModel listaNoParteScrap (String linea, String tema, String cliente, String fechaInicial, String fechaFinal) throws Exception;
    
    public int produccionTotal (String linea, String fechaInicial, String fechaFinal) throws Exception;
    public int scrapTotal (String linea, String fechaInicial, String fechaFinal) throws Exception;
    
    
    public ArrayList produccionPorModelo (String linea, String tema, String fechaInicial, String fechaFinal) throws Exception;
       
    public ArrayList perdidasPorTema (String linea, String fechaInicial, String fechaFinal) throws Exception;
    public ArrayList listaPerdidasPorTemaYArea (String linea, String fechaInicial, String fechaFinal)throws Exception;
}
