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
import modelo.ConsultaPorTurno;

/**
 *
 * @author PRR1TL
 */
public class ConsultaPorTurnoDAOImpl extends ConexionBD implements ConsultaPorTurno {
    private PreparedStatement ps;
    private ResultSet rs;
    
    private ArrayList<String> turnoArr;
    
    private final String LISTA_TURNOS = "SELECT Turno FROM tiempoTurno WHERE fecha = TO_DATE(?, 'DD/MM/YYYY') AND linea like ?";
    private final String CONSULTA_INICIO_TURNO = "SELECT horaInicio FROM tiempoTurno WHERE fecha = TO_DATE(?, 'DD/MM/YYYY') AND linea LIKE ? AND turno LIKE ?";
    private final String CONSULTA_FIN_TURNO = "SELECT horaFin FROM tiempoTurno WHERE fecha = TO_DATE(?, 'DD/MM/YYYY') AND linea LIKE ? AND turno LIKE ?";
    
    @Override
    public DefaultComboBoxModel listaTurnos(String fecha, String linea) throws Exception {
        turnoArr = new ArrayList<>();
        turnoArr.add("Seleccione Turno");
        
        try{
            this.conectar();
            ps = this.conexion.prepareStatement(LISTA_TURNOS);
            ps.setString(1, fecha);
            ps.setString(2, linea);
            
            rs = ps.executeQuery();
            while(rs.next()){
                turnoArr.add(rs.getString(1));
            }
        }catch (Exception e){
            throw e;
        } finally {
            this.cerrar();
        }
        
        return new DefaultComboBoxModel(turnoArr.toArray());     
    }
    
    @Override
    public int consultaInicioTurno(String fecha, String linea, String turno) throws Exception {
        int inicio = 0;        
        
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(CONSULTA_INICIO_TURNO);
            ps.setString(1, fecha);
            ps.setString(2, linea);
            ps.setString(3, turno);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                inicio = rs.getInt(1);
            }else {
                inicio = 0;
            }
        }catch(Exception e){
            throw e;
        } finally {
            this.cerrar();
        }
        return inicio;
    }

    @Override
    public int consultaFinTurno(String fecha, String linea, String turno) throws Exception {
        int fin = 0;
        
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(CONSULTA_FIN_TURNO);
            ps.setString(1, fecha);
            ps.setString(2, linea);
            ps.setString(3, turno);
            
            rs = ps.executeQuery();
            if(rs.next()){
                fin = rs.getInt(1);
            }else {
                fin = 0;
            }
        }catch(Exception e){
            throw e;
        } finally {
            this.cerrar();
        }
        return fin;
    }
}
