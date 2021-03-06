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
    private PreparedStatement ps, ps2, ps3, ps4;
    private ResultSet rs, rs2, rs3, rs4;
    
    private final String INSERTA_REGISTRO_HOURLY = "INSERT INTO HourlyCount (Fecha, NombreLinea, Hora, CantProducida, NoParteTC, Scrap, CambioDuracion, TecnicaDuracion, OrganizacionalDuracion, TiempoPDuracion, OperacionX, ProblemaX, OperacionY, ProblemaY) "
            + "VALUES(CAST(CONVERT(DATETIME, ?, 103) as DATETIME), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String BORRA_REGISTRO_HOURLY = "DELETE FROM HourlyCount WHERE NombreLinea LIKE ?";
    private final String INSERTA_REGISTRO = "INSERT INTO Bitacora (dia, mes, anio, linea, fecha, hora, tiempoIni, tiempoFin, duracion, tema, operacion, area, problema, cliente, noParte, cantPzas, noParteCambio, scrap, detalleMaterial, tiempoCiclo) "
            + "VALUES(DATEPART(DAY, CAST(CONVERT(DATETIME, ?, 103) as DATETIME)), DATEPART(MONTH, CAST(CONVERT(DATETIME, ?, 103) as DATETIME)), DATEPART(YEAR, CAST(CONVERT(DATETIME, ?, 103) as DATETIME)), ?, CAST(CONVERT(DATETIME, ?, 103) as DATETIME), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";   
    private final String BORRA_REGISTRO_TIEMPO = "DELETE FROM Bitacora WHERE hora BETWEEN ? AND ? AND linea LIKE ? AND fecha = CONVERT(DATETIME, ?, 103)";
    private final String BORRA_REGISTRO_FILA = "DELETE FROM Bitacora WHERE linea LIKE ? AND fecha = CONVERT(DATETIME, ?, 103) AND hora = ? AND tiempoIni = ? AND tiempoFin = ?";
    private final String BORRA_REGISTRO_FECHA = "DELETE FROM Bitacora WHERE fecha = CONVERT(DATETIME, ?, 103) AND linea LIKE ?";
    private final String CONSULTA_FECHA = "SELECT hora, tiempoIni, tiempoFin FROM Bitacora WHERE fecha = CONVERT(DATETIME, ?, 103) AND hora = ? AND tiempoIni = ? AND tiempoFin = ? ORDER BY hora";
    private final String LISTAR_REGISTROS_FECHA = "SELECT linea, format(fecha, 'dd/MM/yyyy'), hora, tiempoIni, tiempoFin, duracion, tema, operacion, area, problema, cliente, noParte, cantPzas, noParteCambio, scrap, detalleMaterial, tiempoCiclo"
            +" FROM Bitacora WHERE fecha = CONVERT(DATETIME, ?, 103) AND linea like ? ORDER BY hora";
    private final String LISTAR_REGISTROS_TURNO = "SELECT linea, format(fecha, 'dd/MM/yyyy'), hora, tiempoIni, tiempoFin, duracion, tema, operacion, area, problema, cliente, noParte, cantPzas, noParteCambio, scrap, detalleMaterial, tiempoCiclo"
            +" FROM Bitacora WHERE fecha = CONVERT(DATETIME, ?, 103) AND linea like ? AND hora >= ? AND hora <= ? ORDER BY hora,tiempoIni ASC";
    private final String LISTAR_TURNO_NOCTURNO = "SELECT linea, format(fecha, 'dd/MM/yyyy'), hora, tiempoIni, tiempoFin, duracion, tema, operacion, area, problema, cliente, noParte, cantPzas, noParteCambio, scrap, detalleMaterial, tiempoCiclo"
            +" FROM Bitacora WHERE (fecha = CONVERT(DATETIME, ?, 103) AND linea like ? AND hora >= ?) OR (fecha = CONVERT(DATETIME, ?, 103) AND linea like ? AND hora < ?) ORDER BY hora,tiempoIni ASC";   
    private final String EXISTEN_TURNOS_DIA = "SELECT COUNT(turno) FROM TiempoTurno WHERE fecha = CONVERT(DATETIME, ?, 103) AND linea like ?";
    private final String LISTAR_REGISTROS_OEE_DIARIO = "SELECT * FROM Bitacora WHERE fecha = CONVERT(DATETIME, ?, 103) AND linea like ?"; 
    
    @Override
    public void insertarRegistroAccess(ArrayList registro) throws Exception {
        Object[] reg = new Object[registro.size()];
        try {
            this.conectar();
            for (int i = 0; i < registro.size(); i++) {
                reg[i] = (Object) registro.get(i);
            }
            ps = this.conexion.prepareStatement(INSERTA_REGISTRO);
            ps.setString(1, reg[1].toString());//dia
            ps.setString(2, reg[1].toString());//mes
            ps.setString(3, reg[1].toString());//anio
            ps.setString(4, reg[0].toString());
            ps.setString(5, reg[1].toString());
            ps.setInt(6, Integer.parseInt(reg[2].toString()));
            ps.setInt(7, Integer.parseInt(reg[3].toString()));
            ps.setInt(8, Integer.parseInt(reg[4].toString()));
            ps.setInt(9, Integer.parseInt(reg[5].toString()));
            ps.setString(10, reg[6].toString());
            ps.setString(11, reg[7].toString());
            ps.setString(12, reg[8].toString());
            ps.setString(13, reg[9].toString());
            ps.setString(14, reg[10].toString());
            ps.setString(15, reg[11].toString());
            ps.setInt(16, Integer.parseInt(reg[12].toString()));
            ps.setString(17, reg[13].toString());
            ps.setString(18, reg[14].toString());
            ps.setString(19, reg[15].toString());
            ps.setString(20, reg[16].toString());
            
            ps.executeUpdate();
        } catch (Exception e) {
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
    public ArrayList listarBitacorasTurno(String fecha, String linea, int horaInicia, int horaFin) throws Exception {
        Object[] bitacoraObj;
        listaRegistros = new ArrayList();
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(LISTAR_REGISTROS_TURNO);
            ps.setString(1, fecha);
            ps.setString(2, linea);
            ps.setInt(3, horaInicia);
            ps.setInt(4, horaFin);
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                bitacoraObj = new Object[17];
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
                bitacoraObj[15] = rs.getString(16);
                bitacoraObj[16] = rs.getString(17);
                
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
    
    public ArrayList listarBitacorasTurnoNocturno(String fecha, String linea, int horaInicia, String fecha2, String linea2, int horaFin) throws Exception {
        Object[] bitacoraObj;
        listaRegistros = new ArrayList();
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(LISTAR_TURNO_NOCTURNO);
            ps.setString(1, fecha);
            ps.setString(2, linea);
            ps.setInt(3, horaInicia);
            ps.setString(4, fecha2);
            ps.setString(5, linea2);
            ps.setInt(6, horaFin);
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                bitacoraObj = new Object[17];
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
                bitacoraObj[15] = rs.getString(16);
                bitacoraObj[16] = rs.getString(17);
                
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

//    @Override
//    public void borrarRegistroFechaAccess(int horaInicial, int horaFinal, String linea, String fecha) throws Exception {
//        try {
//            this.conectar();
//            ps = this.conexion.prepareStatement(BORRA_REGISTRO_TIEMPO);
//            ps.setInt(1, horaInicial);
//            ps.setInt(2, horaFinal);
//            ps.setString(3, linea);
//            ps.setString(4, fecha);
//            ps.executeUpdate();
//            
//        } catch (Exception e) {
//            throw e;
//        } finally {
//            ps.close();
//            this.cerrar();
//        }
//    }

    @Override
    public void insertarFilaRegistro(ArrayList registroFila) throws Exception {
        Object[] reg = new Object[registroFila.size()];
        try {
            this.conectar();
            for (int i = 0; i < registroFila.size(); i++) {
                reg[i] = (Object) registroFila.get(i);
            }
            ps = this.conexion.prepareStatement(INSERTA_REGISTRO);
            ps.setString(1, reg[1].toString());//dia
            ps.setString(2, reg[1].toString());//mes
            ps.setString(3, reg[1].toString());//anio
            ps.setString(4, reg[0].toString());
            ps.setString(5, reg[1].toString());
            ps.setInt(6, Integer.parseInt(reg[2].toString()));
            ps.setInt(7, Integer.parseInt(reg[3].toString()));
            ps.setInt(8, Integer.parseInt(reg[4].toString()));
            ps.setInt(9, Integer.parseInt(reg[5].toString()));
            ps.setString(10, reg[6].toString());
            ps.setString(11, reg[7].toString());
            ps.setString(12, reg[8].toString());
            ps.setString(13, reg[9].toString());
            ps.setString(14, reg[10].toString());
            ps.setString(15, reg[11].toString());
            ps.setInt(16, Integer.parseInt(reg[12].toString()));
            ps.setString(17, reg[13].toString());
            ps.setString(18, reg[14].toString());
            ps.setString(19, reg[15].toString());
            ps.setString(20, reg[16].toString());

            ps.executeUpdate();
        } catch (Exception e) {
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
            ps.setInt(1, horaInicio);
            ps.setInt(2, horaFin);
            ps.setString(3, linea);
            ps.setString(4, fecha);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
            ps.close();
        }
    }

    @Override
    public ArrayList listarBitacorasPorFecha(String fecha, String linea) throws Exception {
        Object[] bitacoraObj;
        listaRegistros = new ArrayList();
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(LISTAR_REGISTROS_FECHA);
            ps.setString(1, fecha);
            ps.setString(2, linea);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                bitacoraObj = new Object[17];
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
                bitacoraObj[15] = rs.getString(16);
                bitacoraObj[16] = rs.getString(17);

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
    public void insertarRegistroHourly(ArrayList registroHourly) throws Exception {
        Object[] hourlyReg;
        try {
            this.conectar();
            for (int i = 0; i < registroHourly.size(); i++) {
                
            hourlyReg = (Object[]) registroHourly.get(i);
            ps = this.conexion.prepareStatement(INSERTA_REGISTRO_HOURLY);
            ps.setString(1, hourlyReg[12].toString());//fecha
            ps.setString(2, hourlyReg[13].toString());//linea
            ps.setInt(3, Integer.parseInt(hourlyReg[0].toString()));//hora
            ps.setString(4, hourlyReg[1].toString());//cantProd
            ps.setString(5, hourlyReg[2].toString());//noParteTC
            ps.setString(6, hourlyReg[3].toString());//scrap
            ps.setInt(7, Integer.parseInt(hourlyReg[4].toString()));//cambioDuracion
            ps.setInt(8, Integer.parseInt(hourlyReg[5].toString()));//tecnicaDuracion
            ps.setInt(9, Integer.parseInt(hourlyReg[6].toString()));//organizacionalDuracion
            ps.setInt(10, Integer.parseInt(hourlyReg[7].toString()));//tiempoPDuracion
            ps.setString(11, hourlyReg[8].toString());//operacion
            ps.setString(12, hourlyReg[9].toString());//problema
            ps.setString(13, hourlyReg[10].toString());//operacion
            ps.setString(14, hourlyReg[11].toString());//problema

            ps.executeUpdate();
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ps.close();
            this.cerrar();
        }
    }

    @Override
    public void borrarRegistroHourly(String linea) throws Exception {
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(BORRA_REGISTRO_HOURLY);
            ps.setString(1, linea);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
            ps.close();
        }
    }
    
    public int edicionPorDia(String fecha, String linea) throws Exception {
        int registros = 0;
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(EXISTEN_TURNOS_DIA);
            ps.setString(1, fecha);
            ps.setString(2, linea);
            rs = ps.executeQuery();

            if (rs.next()) {
                registros = rs.getInt(1);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ps.close();
            this.cerrar();
        }
        return registros;
    }

    @Override
    public void numeroTurnoLinea(String fecha, String linea) throws Exception {
        int numTurno = 0;
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(EXISTEN_TURNOS_DIA);
            ps.setString(1, fecha);
            ps.setString(2, linea);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                numTurno = Integer.parseInt(rs.getString(1));
                System.out.println("NUMERO DE TURNO: " + numTurno);
                
                ps2 = this.conexion.prepareStatement("SELECT NumTurnoLinea FROM TurnoLinea WHERE Linea LIKE ? AND Fecha = CONVERT(DATETIME, ?, 103)");
                ps2.setString(1, linea);
                ps2.setString(2, fecha);
                rs2 = ps2.executeQuery();
                //ps2.close();
                
                if (rs2.next()) {
                    
                    ps3 = this.conexion.prepareStatement("UPDATE TurnoLinea SET NumTurnoLinea = ? WHERE Linea like ? AND Fecha = CONVERT(DATETIME, ?, 103) AND Dia = DATEPART(DAY, CAST(CONVERT(DATETIME, ?, 103) as DATETIME)) AND Mes = DATEPART(MONTH, CAST(CONVERT(DATETIME, ?, 103) as DATETIME)) AND Anio = DATEPART(YEAR, CAST(CONVERT(DATETIME, ?, 103) as DATETIME))");
                    ps3.setInt(1, numTurno);
                    ps3.setString(2, linea);
                    ps3.setString(3, fecha);
                    ps3.setString(4, fecha);//MES
                    ps3.setString(5, fecha);//DIA
                    ps3.setString(6, fecha);//ANIO
                    ps3.executeUpdate();
                    //ps3.close();
                } else {
                    ps4 = this.conexion.prepareStatement("INSERT INTO TurnoLinea(NumTurnoLinea, Linea, Fecha, Dia, Mes, Anio) VALUES(?, ?, CONVERT(DATETIME, ?, 103), DATEPART(DAY, CAST(CONVERT(DATETIME, ?, 103) as DATETIME)), DATEPART(MONTH, CAST(CONVERT(DATETIME, ?, 103) as DATETIME)), DATEPART(YEAR, CAST(CONVERT(DATETIME, ?, 103) as DATETIME)) )");
                    ps4.setInt(1, numTurno);
                    ps4.setString(2, linea);
                    ps4.setString(3, fecha);
                    ps4.setString(4, fecha);//dia
                    ps4.setString(5, fecha);//mes
                    ps4.setString(6, fecha);//anio
                    ps4.executeUpdate();
                    //ps4.close();
                }
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ps.close();
            rs.close();
            this.cerrar();
        }
    }
}
