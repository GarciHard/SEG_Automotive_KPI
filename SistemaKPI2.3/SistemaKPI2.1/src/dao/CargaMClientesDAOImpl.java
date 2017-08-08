/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.CargaMClientesDAO;
import modelo.ConexionBD;
import vista.CargaMClientes;

/**
 *
 * @author PRR1TL
 */
public class CargaMClientesDAOImpl extends ConexionBD implements CargaMClientesDAO {
    private PreparedStatement ps;
    private ResultSet rs;
    
    
    private final String INSERTAR_CLIENTES = "INSERT INTO Clientes (linea, clientes) "+" VALUES (?, ?)";
    
     public void insertarCliente(ArrayList registro) throws Exception {
         //To change body of generated methods, choose Tools | Templates.
        Object[] reg = new Object[registro.size()];
            try {
                this.conectar();
                for (int i = 0; i < registro.size(); i++) {
                    reg[i] = (Object) registro.get(i);
                }
                ps = this.conexion.prepareStatement(INSERTAR_CLIENTES);
                ps.setString(1, "Prueba");//linea);//reg[4].toString() );//reg[0].toString());
                ps.setString(2, reg[0].toString());//cliente
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
