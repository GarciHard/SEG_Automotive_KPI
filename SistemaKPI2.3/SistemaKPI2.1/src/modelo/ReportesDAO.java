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
    
    public int CantidadTotalProducida (String linea, String fechaInicial, String fechaFinal) throws Exception;
    public int CantidadProdudccionModelo(String lines, String Inicial, String fechaFinal) throws Exception;
    public int CantidadTotalPerdidas (String linea, String fechaInicial, String fechaFinal) throws Exception;
    public ArrayList listaTotalPerdidas (String linea, String fechaInicial, String fechaFinal) throws Exception;
    public int cantidadTotalPerdidasPorTema(String linea, String tema, String fechaInicial, String fechaFinal)throws Exception;
    public ArrayList listaTotalerdidasPorTema (String linea, String tema, String fechaInicial, String fechaFinal) throws Exception;
    public int cantidadTotalPerdidadPorTemaYArea(String linea, String tema, String area, String fechaInicial, String fechaFinal) throws Exception;
    
    //Select COUNT(*) AS [NOT NULL] FROM Bitacora WHERE Tema = "Tecnicas"  AND fecha>=#8/15/2017# AND fecha<#9/4/2017#  AND linea="L003";
    
    /*
    public DefaultComboBoxModel listaOperacionCalidad(String linea) throws Exception;
    public DefaultComboBoxModel listaAreaCalidad(String linea, String tema, String operacion) throws Exception;
    public DefaultComboBoxModel listaProblemaCalidad(String linea, String tema, String operacion, String area) throws Exception;
    */
}
