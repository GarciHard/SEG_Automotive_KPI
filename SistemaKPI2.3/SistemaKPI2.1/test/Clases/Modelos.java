/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GUR5TL
 */
public class Modelos {

    Conexion con = new Conexion();
    Connection cn = con.getConnection();
    private ResultSet rs;
    private PreparedStatement pstm;
    private JFrame form;
    Consultas cls;

    public Modelos() {
        cls = new Consultas();
    }

    public DefaultTableModel llenaTablaPerdidas(String linea, DefaultTableModel model) {
        String consulta;
        Object[] operacion = new Object[4];
        ClearTable(model);
        try {
            consulta = "select tema, operacion, area, problema from perdidas where linea='" + linea + "'";
            pstm = cn.prepareStatement(consulta);
            rs = pstm.executeQuery();
            while (rs.next()) {
                operacion[0] = rs.getString(1);
                operacion[1] = rs.getString(2);
                operacion[2] = rs.getString(3);
                operacion[3] = rs.getString(4);
                model.addRow(operacion);

            }
            pstm.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(form, "Error al hacer la consulta Operaciones :\n" + ex.getMessage());
        }
        return model;
    }


    public DefaultTableModel llenaTabla(DefaultTableModel model) {
        String consulta;
        String[] linea = new String[3];
        try {
            ClearTable(model);
            consulta = "select linea,nombre,tipo from Lineas";
            pstm = cn.prepareStatement(consulta);
            rs = pstm.executeQuery();
            while (rs.next()) {
                linea[0] = rs.getString(1);
                linea[1] = rs.getString(2);
                linea[2] = rs.getString(3);
                model.addRow(linea);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Modelos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }

    public String[] BuscaDato(String linea) {
        String consulta;
        String[] datosL = new String[3];
        try {
            consulta = "select linea,nombre,tipo from Lineas where linea='" + linea + "'";
            pstm = cn.prepareStatement(consulta);
            rs = pstm.executeQuery();
            if (rs.next()) {
                datosL[0] = rs.getString(1);
                datosL[1] = rs.getString(2);
                datosL[2] = rs.getString(3);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Modelos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datosL;
    }

    public void ClearTable(DefaultTableModel model) {
        for (int i = 0; i < model.getRowCount(); i++) {
            model.removeRow(i);
            i -= 1;
        }
    }

    public DefaultTableModel columnasModelos(int caso, int tam, DefaultTableModel tb) {
        DefaultTableModel tabla = new DefaultTableModel(){
        public boolean isCellEditable(int rowIndex, int vColIndex) {
            return false;
        }};;
        switch (caso) {
            case 1:
                tabla.addColumn("LINEA");
                tabla.addColumn("FECHA");
                tabla.addColumn("HORA");
                tabla.addColumn("INICIO INCIDENCIA");
                tabla.addColumn("FIN INCIDENCIA");
                tabla.addColumn("DURACION");
                tabla.addColumn("TEMA");
                tabla.addColumn("OPERACION");
                tabla.addColumn("AREA");
                tabla.addColumn("PROBLEMA");
                tabla.addColumn("CLIENTE");
                tabla.addColumn("NO PARTE");
                tabla.addColumn("CANTIDAD");
                tabla.addColumn("NoPARTE CAMBIO");
                break;
        }
        return tabla;
    }
}
