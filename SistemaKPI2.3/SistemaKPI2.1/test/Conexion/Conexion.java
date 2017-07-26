/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GUR5TL
 */
public class Conexion {

    private Connection con;
    private ResultSet rs;
    private PreparedStatement pstm;
    private JFrame form;
    DefaultTableModel tabla = null;
    DefaultListModel lista = null;

    public Conexion() {
        conectar();
    }

    public void conectar() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//            con = DriverManager.getConnection("jdbc:ucanaccess://" + "I:/Dept/MOE1/Shared/Informacion_general/proyectos  SG/Proyecto OEE/BD/SystemKPI.accdb");
          con = DriverManager.getConnection("jdbc:ucanaccess://" + "C:/Users/GJA5TL/Desktop/SystemKPI.accdb");
//            con = DriverManager.getConnection("jdbc:ucanaccess://" + "D:/SistemaCapacidades.accdb");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(form, "No se pudo cargar el driver :\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(form, "No se pudo Establecer la conexion :\n" + sqle.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    public Connection getConnection(){
        return con;
    }
}
