package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.ConexionBD;

/**
 *
 * @author PRR1TL
 */
public class CargaTargetEntregas extends ConexionBD {
    private PreparedStatement ps;
    private ResultSet rs;
    
    private final String INSERTAR_DIA_MES_ANIO = "INSERT INTO targetEntregas(linea, anio, mes, noMes, dia, tek, programado) " + "VALUES(?, ?, ?, ?, ?, ? , ?)";
    private final String INSERTAR_TEK = "UPDATE targetEntregas SET tek = ? WHERE linea LIKE ? AND anio LIKE ? AND mes LIKE ? and noMes LIKE ? and dia LIKE ?";
    private final String INSERTAR_PROGRAMADO = "UPDATE targetEntregas SET programado = ? WHERE linea LIKE ? AND anio LIKE ? AND mes LIKE ? and noMes LIKE ? and dia LIKE ?";
    private final String CONSULTA_FECHA_REGISTRO = "SELECT COUNT (dia) FROM targetEntregas WHERE linea LIKE ? AND anio LIKE ? AND mes LIKE ? and noMes LIKE ? and dia LIKE ?";
    
    public void insertarFechaYLinea(String linea, String anio, String mes, String noMes, String dia, String trek, String programado) throws Exception {
        try {
            this.conectar();            
            ps = this.conexion.prepareStatement(INSERTAR_DIA_MES_ANIO);
            ps.setString(1, linea);//linea)
            ps.setString(2, anio);//anio
            ps.setString(3, mes);//mes
            ps.setString(4, noMes); 
            ps.setString(5, dia);//dia
            ps.setString(6, trek); 
            ps.setString(7, programado);//dia

            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error en INSERT " + e);
            throw e;
        } finally {
            ps.close();
            this.cerrar();
        }
    }   
    
    public void insertarTEK(String tek, String linea, String anio, String mes, String noMes, String dia) throws Exception {
        try {
            this.conectar();     
            ps = this.conexion.prepareStatement("UPDATE targetEntregas SET tek = ? WHERE linea='"+ linea +"' and anio='"+ anio +"' and mes='"+ mes + "' and dia='" + dia + "'");
            //ps = this.conexion.prepareStatement(INSERTAR_TEK);
            ps.setString(1, tek);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("update" + e);
            throw e;
        } finally {
            ps.close();
            this.cerrar();
        }
    }   
    
    public void insertarProgramado(String programado, String linea, String anio, String mes, String noMes, String dia) throws Exception {
        try {
            this.conectar();            
            ps = this.conexion.prepareStatement(INSERTAR_PROGRAMADO);
            ps.setString(1, programado);
            ps.setString(2, linea);
            ps.setString(3, anio);
            ps.setString(4, mes);
            ps.setString(5, noMes);
            ps.setString(6, dia);
            
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error en INSERT " + e);
            throw e;
        } finally {
            ps.close();
            this.cerrar();
        }
    }   
    
    public int consultaFechaExistente(String linea, String anio, String mes, String noMes, String dia) throws Exception{
        int bn = 0;
        try {   
            this.conectar();
            
            ps = this.conexion.prepareStatement(CONSULTA_FECHA_REGISTRO);
            ps.setString(1, linea);
            ps.setString(2, anio);
            ps.setString(3, mes);
            ps.setString(4, noMes);
            ps.setString(5, dia);
            
            rs = ps.executeQuery();  
            if (rs.next()){  
                bn = rs.getInt(1);
            } else {
                bn = rs.getInt(1); ;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return bn;
    }
}
