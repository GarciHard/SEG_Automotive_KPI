package dao;

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

    private ArrayList listaRegistros;
    private PreparedStatement ps;
    private ResultSet rs;
    
    private final String INSERTA_REGISTRO = "INSERT INTO Bitacora (linea, fecha, hora, tiempoIni, tiempoFin, duracion, tema, operacion, area, problema, cliente, noParte, cantPzas, noParteCambio, scrap, detalleMaterial) "
            + "VALUES(?, TO_DATE(?, 'DD/MM/YYYY'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String BORRA_REGISTRO_TIEMPO = "DELETE FROM Bitacora WHERE hora BETWEEN ? AND ? AND linea LIKE ? AND fecha = TO_DATE(?, 'DD/MM/YYYY')";
    private final String BORRA_REGISTRO_FILA = "DELETE FROM Bitacora WHERE linea LIKE ? AND fecha = TO_DATE(?, 'DD/MM/YYYY') AND hora = ? AND tiempoIni = ? AND tiempoFin = ?";
    private final String BORRA_REGISTRO_FECHA = "DELETE FROM Bitacora WHERE fecha = TO_DATE(?, 'DD/MM/YYYY')";
    private final String CONSULTA_FECHA = "SELECT hora, tiempoIni, tiempoFin FROM Bitacora WHERE fecha = TO_DATE(?, 'DD/MM/YYYY') AND hora = ? AND tiempoIni = ? AND tiempoFin = ?";
    private final String LISTAR_REGISTROS_FECHA = "SELECT linea, format(fecha, \"dd/mm/yyyy\"), hora, tiempoIni, tiempoFin, duracion, tema, operacion, area, problema, cliente, noParte, cantPzas, noParteCambio, scrap"
            + " FROM Bitacora WHERE fecha = TO_DATE(?, 'DD/MM/YYYY') AND linea like ?";
    
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
            ps.setString(16, reg[15].toString());
            
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
    public ArrayList existeFechaBitacora(String fecha, DefaultTableModel bitacora) throws Exception {
        ArrayList horas = new ArrayList();
        Object[] dat = new Object[3];
        try {
            this.conectar();
            for (int i = 0; i < bitacora.getRowCount(); i++) {
                ps = this.conexion.prepareStatement(CONSULTA_FECHA);
                ps.setString(1, fecha);
                ps.setInt(2, Integer.parseInt(bitacora.getValueAt(i, 2).toString()));
                ps.setInt(3, Integer.parseInt(bitacora.getValueAt(i, 3).toString()));
                ps.setInt(4, Integer.parseInt(bitacora.getValueAt(i, 4).toString()));
                rs = ps.executeQuery();
                
                if (rs.next()) {
                    dat[0] = bitacora.getValueAt(i, 2);
                    dat[1] = bitacora.getValueAt(i, 3);
                    dat[2] = bitacora.getValueAt(i, 4);
                    horas.add(dat);
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

    @Override
    public ArrayList listarBitacoras(String fecha, String linea) throws Exception {
        Object[] bitacoraObj;
        listaRegistros = new ArrayList();
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(LISTAR_REGISTROS_FECHA);
            ps.setString(1, fecha);
            ps.setString(2, linea);
            rs = ps.executeQuery();
                
            while (rs.next()) {
                bitacoraObj = new Object[15];
                bitacoraObj[0] = rs.getString(1);
                bitacoraObj[1] = rs.getString(2);
                bitacoraObj[2] = rs.getInt(3);
                bitacoraObj[3] = rs.getInt(4);
                bitacoraObj[4] = rs.getInt(5);
                bitacoraObj[5] = rs.getInt(6);
                bitacoraObj[6] = rs.getString(7);
                bitacoraObj[7] = rs.getString(8);
                bitacoraObj[8] = rs.getString(9);
                bitacoraObj[9] = rs.getString(10);
                bitacoraObj[10] = rs.getString(11);
                bitacoraObj[11] = rs.getString(12);
                bitacoraObj[12] = rs.getInt(13);
                bitacoraObj[13] = rs.getString(14);
                bitacoraObj[14] = rs.getString(15);

                listaRegistros.add(bitacoraObj);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ps.close();
            rs.close();
            this.cerrar();
        }
        return listaRegistros;
    }

    @Override
    public void borrarRegistroFechaAccess(String fecha) throws Exception {
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(BORRA_REGISTRO_FECHA);
            ps.setString(1, fecha);
            ps.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        } finally {
            ps.close();
            this.cerrar();
        }
    }

    @Override
    public void insertarFilaRegistro(ArrayList registroFila) throws Exception {
        Object[] reg = new Object[registroFila.size()];
        try {
            this.conectar();
            for (int i = 0; i < registroFila.size(); i++) {
                reg[i] = (Object) registroFila.get(i);
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
            ps.setString(16, reg[15].toString());

            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error en INSERT FILA" + e);
            throw e;
        } finally {
            ps.close();
            this.cerrar();
        }
    }

    @Override
    public void borrarFilaRegistro(ArrayList bRegistroFila) throws Exception {
        Object[] reg = new Object[bRegistroFila.size()];
        try {
            this.conectar();
            for (int i = 0; i < bRegistroFila.size(); i++) {
                reg[i] = (Object) bRegistroFila.get(i);
            }
            ps = this.conexion.prepareStatement(BORRA_REGISTRO_FILA);
            ps.setString(1, reg[0].toString());
            ps.setString(2, reg[1].toString());
            ps.setInt(3, Integer.parseInt(reg[2].toString()));
            ps.setInt(4, Integer.parseInt(reg[3].toString()));
            ps.setInt(5, Integer.parseInt(reg[4].toString()));
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
            ps.close();
        }
    }

    @Override
    public void borrarRegistroTiempo(int horaInicio, int horaFin, String linea, String fecha) throws Exception {
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(BORRA_REGISTRO_TIEMPO);
            ps.setString(3, linea);
            ps.setString(4, fecha);
            ps.setInt(1, horaInicio);
            ps.setInt(2, horaFin);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
            ps.close();
        }
    }
}