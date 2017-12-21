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
    //metaTec, metaOrg, metaCalidad, metaScrap
    private final String INSERTAR_DIA_MES_ANIO = "INSERT INTO targets(linea, anio, mes, dia, tek, producidas, tecnicas, organizacionales, calidad, scrap, cambio, planeado) " + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    //private final String INSERTAR_TEK = "UPDATE targets SET tek = ? WHERE linea LIKE ? AND anio LIKE ? AND mes LIKE ? and dia LIKE ?";
    //private final String INSERTAR_PROGRAMADO = "UPDATE targets SET programado = ? WHERE linea LIKE ? AND anio LIKE ? AND mes LIKE ? and dia LIKE ?";
    private final String CONSULTA_FECHA_REGISTRO = "SELECT COUNT (dia) FROM targets WHERE linea LIKE ? AND anio LIKE ? AND mes LIKE ? and dia LIKE ?";
    
    public void insertarFechaYLinea(String linea, String anio, String mes, String dia, String trek, String programado, String tecnicas, String organizacionales, String calidad, String scrap, String cambios, String planeados) throws Exception {
        try {
            this.conectar();            
            ps = this.conexion.prepareStatement(INSERTAR_DIA_MES_ANIO);
            ps.setString(1, linea);//linea)
            ps.setString(2, anio);//anio
            ps.setString(3, mes);//mes
            ps.setString(4, dia);//dia
            ps.setString(5, trek); 
            ps.setString(6, programado);
            ps.setString(7, tecnicas); 
            ps.setString(8, organizacionales);
            ps.setString(9, calidad); 
            ps.setString(10, scrap);
            ps.setString(11, cambios); 
            ps.setString(12, planeados);
            
            //System.out.println(linea+anio+mes+dia+trek+programado+tecnicas+organizacionales+calidad+scrap+"\n");

            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error en INSERT " + e);
            throw e;
        } finally {
            ps.close();
            this.cerrar();
        }
    }   
    
//    public void insertarTEK(String tek, String linea, String anio, String mes, String noMes, String dia) throws Exception {
//        try {
//            this.conectar();     
//            ps = this.conexion.prepareStatement("UPDATE targetEntregas SET tek = ? WHERE linea='"+ linea +"' and anio='"+ anio +"' and mes='"+ mes + "' and dia='" + dia + "'");
//            //ps = this.conexion.prepareStatement(INSERTAR_TEK);
//            ps.setString(1, tek);
//            ps.executeUpdate();
//        } catch (Exception e) {
//            System.err.println("update" + e);
//            throw e;
//        } finally {
//            ps.close();
//            this.cerrar();
//        }
//    }   
    
//    public void insertarProgramado(String programado, String linea, String anio, String mes, String dia) throws Exception {
//        try {
//            this.conectar();            
//            ps = this.conexion.prepareStatement(INSERTAR_PROGRAMADO);
//            ps.setString(1, programado);
//            ps.setString(2, linea);
//            ps.setString(3, anio);
//            ps.setString(4, mes);
//            ps.setString(5, dia);
//            
//            ps.executeUpdate();
//        } catch (Exception e) {
//            System.err.println("Error en INSERT " + e);
//            throw e;
//        } finally {
//            ps.close();
//            this.cerrar();
//        }
//    }   
    
    public int consultaFechaExistente(String linea, String anio, String mes, String dia) throws Exception{
        int bn = 0;
        try {   
            this.conectar();
            
            ps = this.conexion.prepareStatement(CONSULTA_FECHA_REGISTRO);
            ps.setString(1, linea);
            ps.setString(2, anio);
            ps.setString(3, mes);
            ps.setString(4, dia);
            
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
