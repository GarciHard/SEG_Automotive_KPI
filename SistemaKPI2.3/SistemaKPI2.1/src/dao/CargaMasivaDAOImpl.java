package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.ConexionBD;
import modelo.CargaMasivaDAO;
import utils.LineasMetodos;

/**
 *
 * @author PRR1TL
 */
public class CargaMasivaDAOImpl extends ConexionBD implements CargaMasivaDAO{
    private PreparedStatement ps;
    private ResultSet rs;
    
    public static String linea = LineasMetodos.lineaLinea;//"";
    
    private final String INSERTAR_PERDIDAS = "INSERT INTO Perdidas (linea, tema, operacion, area, problema) " + "VALUES(?, ?, ?, ?, ?)";
    private final String INSERTAR_CLIENTES = "INSERT INTO Clientes (linea, cliente)" + "VALUES (?,?)";
    private final String INSERTAR_NUMPARTES = "INSERT INTO ListaNumPartes (noParte, LineaProduce, familia, cliente)" + "VALUES (?,?,?,?)";
    private final String INSERTAR_OPERACIONES = "INSERT INTO operaciones (linea, operacion, descripcion)" + "VALUES (?,?,?)";
    
    public void insertarPerdidas(ArrayList registro) throws Exception {
        Object[] reg = new Object[registro.size()];
        try {
            this.conectar();
            for (int i = 0; i < registro.size(); i++) {
                reg[i] = (Object) registro.get(i);
            }
            ps = this.conexion.prepareStatement(INSERTAR_PERDIDAS);
            ps.setString(1, linea);//linea);//reg[4].toString() );//reg[0].toString());
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

    @Override
    public void insertarClientes(ArrayList registro) throws Exception {
        //To change body of generated methods, choose Tools | Templates.
        Object[] reg = new Object[registro.size()];
        try {
            this.conectar();
            for (int i = 0; i < registro.size(); i++) {
                reg[i] = (Object) registro.get(i);
            }
            ps = this.conexion.prepareStatement(INSERTAR_CLIENTES);
            ps.setString(1, linea);//linea
            ps.setString(2, reg[0].toString());//Cliente

            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error en INSERT " + e);
            throw e;
        } finally {
            ps.close();
            this.cerrar();
        }
    }

    @Override
    public void insertarNumPartes(ArrayList registro) throws Exception {
        //To change body of generated methods, choose Tools | Templates.
        Object[] reg = new Object[registro.size()];
        try {
            this.conectar();
            for (int i = 0; i < registro.size(); i++) {
                reg[i] = (Object) registro.get(i);
            }
            ps = this.conexion.prepareStatement(INSERTAR_NUMPARTES);
            ps.setString(1, reg[0].toString());//noParte
            ps.setString(2, linea );//linea
            ps.setString(3, reg[1].toString());//familia
            ps.setString(4, reg[2].toString());//cliente

            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error en INSERT " + e);
            throw e;
        } finally {
            ps.close();
            this.cerrar();
        }
    }

    @Override
    public void insertarOperaciones(ArrayList registro) throws Exception {
        //To change body of generated methods, choose Tools | Templates.
        Object[] reg = new Object[registro.size()];
        try {
            this.conectar();
            for (int i = 0; i < registro.size(); i++) {
                reg[i] = (Object) registro.get(i);
            }
            ps = this.conexion.prepareStatement(INSERTAR_OPERACIONES);
            ps.setString(1, linea);//linea
            ps.setString(2, reg[0].toString() );//operacion
            ps.setString(3, reg[1].toString());//descripcion

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
