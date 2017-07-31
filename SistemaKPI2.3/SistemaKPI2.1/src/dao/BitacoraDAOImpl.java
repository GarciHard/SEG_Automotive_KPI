package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.BitacoraDAO;
import modelo.ConexionBD;

/**
 * Hecho con <3 por:
 * @author GarciHard
 * @boschUsr GJA5TL
 */
public class BitacoraDAOImpl extends ConexionBD implements BitacoraDAO {

    private PreparedStatement ps;
    private ResultSet rs;
    
    private final String INSERTA_REGISTRO = "INSERT INTO Bitacora (linea, fecha, hora, tiempoIni, tiempoFin, duracion, tema, operacion, area, problema, cliente, noParte, cantPzas, noParteCambio, scrap) "
            + "VALUES(?, TO_DATE(?, 'DD/MM/YYYY'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String CONSULTA_FECHA = "SELECT hora, tiempoIni, tiempoFin FROM Bitacora WHERE fecha = TO_DATE(?, 'DD/MM/YYYY') AND hora = ?";
    
    @Override
    public void insertarRegistroAccess(ArrayList registro) throws Exception {
        Object[] reg = new Object[registro.size()];
        try {
            this.conectar();
            for (int i = 0; i < registro.size(); i++) {
                reg[i] = (Object) registro.get(i);
            }
            ps = this.conexion.prepareStatement(INSERTA_REGISTRO);
            ps.setString(1, reg[0].toString());
            ps.setString(2, reg[1].toString());
            ps.setInt(3, Integer.parseInt(reg[2].toString()));
            ps.setInt(4, Integer.parseInt(reg[3].toString()));
            ps.setInt(5, Integer.parseInt(reg[4].toString()));
            ps.setInt(6, Integer.parseInt(reg[5].toString()));
            ps.setString(7, reg[6].toString());
            ps.setString(8, reg[7].toString());
            ps.setString(9, reg[8].toString());
            ps.setString(10, reg[9].toString());
            ps.setString(11, reg[10].toString());
            ps.setString(12, reg[11].toString());
            ps.setInt(13, Integer.parseInt(reg[12].toString()));
            ps.setString(14, reg[13].toString());
            ps.setString(15, reg[14].toString());
            
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error en INSERT " + e);
            throw e;
        } finally {
            ps.close();
            rs.close();
            this.cerrar();
        }
    }

    @Override
    public ArrayList existeFechaBitacora(String fecha, DefaultTableModel bitacora) throws Exception {
        ArrayList horas = new ArrayList();
        Object[] dat = new Object[3];
        try {
            this.conectar();
            for (int i = 0; i < bitacora.getRowCount(); i++) {
                ps = this.conexion.prepareStatement(CONSULTA_FECHA);
                ps.setString(1, fecha);
                ps.setInt(2, Integer.parseInt(bitacora.getValueAt(i, 2).toString()));
                rs = ps.executeQuery();
                
                while (rs.next()) {
                    if (rs.getInt(3) > Integer.parseInt(bitacora.getValueAt(i, 3).toString())) {
                        dat[0] = bitacora.getValueAt(i, 2);
                        dat[1] = bitacora.getValueAt(i, 3);
                        dat[2] = bitacora.getValueAt(i, 4);
                        horas.add(dat);
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error en BUSCAR_FECHA " + e);
            throw e;
        } finally {
            ps.close();
            rs.close();
            this.cerrar();
        }
        return horas;
    }

}
