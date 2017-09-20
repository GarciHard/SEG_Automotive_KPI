/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import modelo.ConexionBD;
import modelo.ReportesDAO;

/**
 *
 * @author PRR1TL
 */
public class ReportesDAOImpl extends ConexionBD implements ReportesDAO {
    
    private ArrayList<String> listaLineas; 
            
    private PreparedStatement ps;
    private ResultSet rs;
    
    /*********QUERYS*************/
    String LINEAS_REGISTRADAS = "SELECT Linea FROM Bitacora Group By Linea Order BY Linea ASC";
    String PRODUCCION = "SELECT COUNT(*) AS [NOT NULL] FROM Bitacora WHERE Linea = ? AND Tema = Piezas Producidas AND ";
    String PPRODUCCION_MODELO = "";
    
    @Override
    public DefaultComboBoxModel listaLineasBitacora() throws Exception {
        listaLineas = new ArrayList<>();
        listaLineas.add("Selecciona una linea");
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(LINEAS_REGISTRADAS);
            rs = ps.executeQuery();

            while (rs.next()) {
                listaLineas.add(rs.getString(1));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ps.close();
            rs.close();
            this.cerrar();
        }
        return new DefaultComboBoxModel(listaLineas.toArray());         
    }

    @Override
    public int CantidadTotalProducida(String Linea, String FechaInicial, String FechaFinal) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int CantidadTotalPerdidas(String Linea, String FechaInicial, String FechaFinal) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int cantidadTotalPerdidasPorTema(String Linea, String Tema, String FechaInicial, String FechaFinal) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int cantidadTotalPerdidadPorTemaYArea(String Linea, String Tema, String Area, String FechaInicial, String FechaFinal) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int CantidadProdudccionModelo(String lines, String Inicial, String fechaFinal) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList listaTotalPerdidas(String linea, String fechaInicial, String fechaFinal) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList listaTotalerdidasPorTema(String linea, String tema, String fechaInicial, String fechaFinal) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
