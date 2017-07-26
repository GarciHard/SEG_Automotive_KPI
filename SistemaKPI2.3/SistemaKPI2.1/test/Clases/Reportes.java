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
import javax.swing.JFrame;


/**
 *
 * @author GUR5TL
 */
public class Reportes {

    Conexion con = new Conexion();
    Connection cn = con.getConnection();
    private ResultSet rs;
    private PreparedStatement pstm;
    private JFrame form;
    Consultas cls;

    public Reportes() {
        cls = new Consultas();
    }
 
}
