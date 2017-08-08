/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import control.PrincipalControl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.ConexionBD;
import modelo.CargaMPerdidasDAO;

/**
 *
 * @author PRR1TL
 */
public class CargaMPerdidasDAOImpl extends ConexionBD implements CargaMPerdidasDAO{
    private PreparedStatement ps;
    private ResultSet rs;
    
    public static String linea = PrincipalControl.linea;//"";
    
    private final String INSERTAR_PERDIDAS = "INSERT INTO Perdidas (linea, tema, operacion, area, problema) " + "VALUES(?, ?, ?, ?, ?)";
    

    public void insertarRegistroAccess(ArrayList registro) throws Exception {
            Object[] reg = new Object[registro.size()];
            try {
                this.conectar();
                for (int i = 0; i < registro.size(); i++) {
                    reg[i] = (Object) registro.get(i);
                }
                ps = this.conexion.prepareStatement(INSERTAR_PERDIDAS);
                ps.setString(1, "PRUEBA");//linea);//reg[4].toString() );//reg[0].toString());
                ps.setString(2, reg[0].toString());//tema
                ps.setString(3, reg[1].toString());//operacion
                ps.setString(4, reg[2].toString());//area
                ps.setString(5, reg[3].toString());//descripcion
                
                ps.executeUpdate();
            } catch (Exception e) {
                System.err.println("Error en INSERT " + e);
                throw e;
            } finally {
                ps.close();
                this.cerrar();
            }
    }
   
}
