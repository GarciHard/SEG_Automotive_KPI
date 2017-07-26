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
import java.sql.SQLException;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 *
 * @author GUR5TL
 */
public class Inserciones {

    Conexion con = new Conexion();
    Connection cn = con.getConnection();
    private ResultSet rs;
    private PreparedStatement pstm;
    private JFrame form;

    public void updateLinea(JDialog ven, String[] datosL, String l) {
        try {
            String consulta;
            consulta = "UPDATE Lineas SET linea=?, tipo=?, nombre=? WHERE linea='" + l + "'";
            pstm = cn.prepareStatement(consulta);
            pstm.setString(1, datosL[0]);
            pstm.setString(2, datosL[1]);
            pstm.setString(3, datosL[2]);
            pstm.execute();
            pstm.close();
            consulta = "UPDATE promedioLinea SET linea=? WHERE linea='" + l + "'";
            pstm = cn.prepareStatement(consulta);
            pstm.setString(1, datosL[0]);
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(ven, "Actualizada correcta", "Registro Actualizado", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(form, "No se pudo Actualizar el registro: \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteLinea(String linea) {
        try {
            String consulta;

            consulta = "DELETE from Lineas where Linea='" + linea + "'";
            pstm = cn.prepareStatement(consulta);
            pstm.executeUpdate();
            pstm.close();
            consulta = "DELETE from promedioLinea WHERE linea='" + linea + "'";
            pstm = cn.prepareStatement(consulta);
            pstm.executeUpdate();
            pstm.close();
            JOptionPane.showMessageDialog(form, "Registro eliminado correctamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(form, "Error al eliminar el registro registro: \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void insertaPerdida(Object[] perdida) {
        String consulta = "";
        try {
            consulta = "INSERT INTO perdidas (linea, tema, operacion, area, problema) VALUES";
            pstm = cn.prepareStatement(consulta + "(?,?,?,?,?)");
            pstm.setString(1, perdida[0].toString());
            pstm.setString(2, perdida[1].toString());
            pstm.setString(3, perdida[2].toString());
            pstm.setString(4, perdida[3].toString());
            pstm.setString(5, perdida[4].toString());
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(form, "Registro Guardado", "Registro Guardado", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(form, "No se pudo realizar la consulta insertaPerdida ", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updatePerdida(JDialog ven, Object[] perdida, String perAnteriror) {
        try {
            String consulta;
            consulta = "UPDATE Perdidas SET problema=? WHERE linea='" + perdida[0] + "' "
                    + "and tema='" + perdida[1] + "'and operacion='" + perdida[2] + "'and area='" + perdida[3] + "' and problema='" + perAnteriror + "'";
            pstm = cn.prepareStatement(consulta);
            pstm.setString(1, perdida[4].toString());
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(ven, "Actualizada correcta", "Registro Actualizado", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(form, "No se pudo Actualizar el registro: \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deletePerdida(JDialog ven, Object[] perdida,String linea) {
        try {
            String consulta;

            consulta = "DELETE from Perdidas WHERE linea='" + linea+ "'"
                    + "and tema='" + perdida[0] + "'and operacion='" + perdida[1] + "'and area='" + perdida[2] + "' and problema='" + perdida[3] + "'";
            pstm = cn.prepareStatement(consulta);
            pstm.executeUpdate();
            pstm.close();
            JOptionPane.showMessageDialog(form, "Registro eliminado correctamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(form, "Error al eliminar el registro registro: \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public boolean insertaLineas(JDialog ven, String[] linea) {
        String consulta;
        boolean band = false;
        try {
            consulta = "select linea from Lineas where linea='" + linea[0] + "'";
            pstm = cn.prepareStatement(consulta);
            rs = pstm.executeQuery();
            if (rs.next() == true) {
                JOptionPane.showMessageDialog(ven, "La linea ya existe en la Base de Datos", "Warning", JOptionPane.YES_NO_OPTION);
                band = true;
            } else {
                consulta = "INSERT INTO Lineas (linea, tipo, nombre) VALUES";
                pstm = cn.prepareStatement(consulta + "(?,?,?)");
                pstm.setString(1, linea[0]);
                pstm.setString(2, linea[1]);
                pstm.setString(3, linea[2]);
                pstm.execute();
                pstm.close();
                for (int i = 1; i < 4; i++) {
                    consulta = "INSERT INTO promedioLinea (linea, turno, noPersonas, duracionTurno, tcPromedio)values";
                    pstm = cn.prepareStatement(consulta + "(?,?,?,?,?)");
                    pstm.setString(1, linea[0]);
                    pstm.setInt(2, i);
                    pstm.setInt(3, 0);
                    pstm.setDouble(4, 8.5);
                    pstm.setDouble(5, 0.0);
                    pstm.execute();
                    pstm.close();
                }
                consulta = "UPDATE promedioLinea SET duracionTurno=? WHERE turno='" + 2 + "'";
                pstm = cn.prepareStatement(consulta);
                pstm.setDouble(1, 8);
                pstm.execute();
                pstm.close();
                consulta = "UPDATE promedioLinea SET duracionTurno=? WHERE turno='" + 3 + "'";
                pstm = cn.prepareStatement(consulta);
                pstm.setDouble(1, 6.5);
                pstm.execute();
                pstm.close();
                JOptionPane.showMessageDialog(ven, "Linea agregada correctamente", "Registro Guardado", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(form, "No se pudo insertar el registro: \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return band;
    }

    
    //NO NECESARIO//
    public void insertaFechas(JDialog ven, TableModel modelo, int anio) {
        String consulta;
        int op;
        boolean b = false;
        try {
            for (int i = 0; i < modelo.getRowCount(); i++) {
                if (modelo.getValueAt(i, 1) == null) {
                    b = true;
                } else if (modelo.getValueAt(i, 1).toString().length() > 2) {
                    modelo.setValueAt(null, i, 1);
                    b = true;
                }
            }
            if (b == false) {
                consulta = "select anio from Fechas where anio='" + anio + "'";
                pstm = cn.prepareStatement(consulta);
                rs = pstm.executeQuery();
                if (rs.next() == true) {
                    op = JOptionPane.showConfirmDialog(ven, "El año ya existe en la Base de Datos\n"
                            + "\t\n¿Desea actualizarlo?");
                    if (op == 0) {
                        consulta = "DELETE FROM Fechas where anio='" + anio + "'";
                        pstm = cn.prepareStatement(consulta);
                        pstm.execute();
                        pstm.close();

                        consulta = "INSERT INTO Fechas (mes, diasHabiles, anio) VALUES";
                        for (int i = 0; i < modelo.getRowCount(); i++) {
                            int dias = Integer.parseInt(modelo.getValueAt(i, 1).toString());
                            pstm = cn.prepareStatement(consulta + "(?,?,?)");
                            pstm.setString(1, modelo.getValueAt(i, 0).toString());
                            pstm.setInt(2, dias);
                            pstm.setInt(3, anio);
                            pstm.execute();
                            pstm.close();
                        }
                        JOptionPane.showMessageDialog(ven, "Año Agregado Correctamente", "Registro Guardado", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    consulta = "INSERT INTO Fechas (mes, diasHabiles, anio) VALUES";
                    for (int i = 0; i < modelo.getRowCount(); i++) {
                        int dias = Integer.parseInt(modelo.getValueAt(i, 1).toString());
                        pstm = cn.prepareStatement(consulta + "(?,?,?)");
                        pstm.setString(1, modelo.getValueAt(i, 0).toString());
                        pstm.setInt(2, dias);
                        pstm.setInt(3, anio);
                        pstm.execute();
                        pstm.close();
                    }
                    JOptionPane.showMessageDialog(ven, "Año Agregado Correctamente", "Registro Guardado", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(ven, "Debe ingresar valores para cada mes", "", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(form, "No se pudo insertar el registro: \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void insertaPartes(Object[] datos, String tipo, int op) {
        String consulta = "";
        try {
            if (op == 0) {
                consulta = "INSERT INTO " + tipo + "  (noParte, numero, noParteRotor, noParteEstator, noParteRectificador, cliente, lineaProduce, familia) VALUES";

                pstm = cn.prepareStatement(consulta + "(?,?,?,?,?,?,?,?)");
                pstm.setString(1, datos[0].toString());
                pstm.setString(2, datos[1].toString());
                pstm.setString(3, datos[2].toString());
                pstm.setString(4, datos[3].toString());
                pstm.setString(5, datos[4].toString());
                pstm.setString(6, datos[5].toString());
                pstm.setString(7, datos[6].toString());
                pstm.setString(8, datos[7].toString());
                pstm.execute();
                pstm.close();
            } else if (op == 1) {
                consulta = "INSERT INTO " + tipo + " (noParte, num, lineaProduce, familia) VALUES";

                pstm = cn.prepareStatement(consulta + "(?,?,?,?)");
                pstm.setString(1, datos[0].toString());
                pstm.setString(2, datos[1].toString());
                pstm.setString(3, datos[2].toString());
                pstm.setString(4, datos[3].toString());
                pstm.execute();
                pstm.close();
            }
            consulta = "INSERT INTO ListaNumPartes (noParte,num, lineaProduce, familia) VALUES";

            pstm = cn.prepareStatement(consulta + "(?,?,?,?)");
            pstm.setString(1, datos[0].toString());
            pstm.setString(2, datos[1].toString());
            pstm.setString(3, datos[2].toString());
            pstm.setString(4, datos[3].toString());
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(form, "No se pudo insertar el registro: \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void ActualizaParte(Object[] datos, String tipo, int op) {
        String consulta;
        try {
            if (op == 0) {
                consulta = "UPDATE " + tipo + "  SET noParte=?, noParteRotor=?, noParteEstator=?, noParteRectificador=?, cliente=?, lineaProduce=?, familia=? "
                        + "where noParte='" + datos[0].toString() + "'";
                pstm = cn.prepareStatement(consulta);
                pstm.setString(1, datos[0].toString());
                pstm.setString(2, datos[1].toString());
                pstm.setString(3, datos[2].toString());
                pstm.setString(4, datos[3].toString());
                pstm.setString(5, datos[4].toString());
                pstm.setString(6, datos[5].toString());
                pstm.setString(7, datos[6].toString());
                pstm.execute();
                pstm.close();
            } else if (op == 1) {
                consulta = "UPDATE " + tipo + " SET noParte=?, lineaProduce=?, familia=? where noParte='" + datos[0].toString() + "'";

                pstm = cn.prepareStatement(consulta);
                pstm.setString(1, datos[0].toString());
                pstm.setString(2, datos[1].toString());
                pstm.setString(3, datos[2].toString());
                pstm.execute();
                pstm.close();
            }
            consulta = "UPDATE ListaNumPartes SET noParte=?, lineaProduce=?, familia=? where noParte='" + datos[0].toString() + "'";

            pstm = cn.prepareStatement(consulta);
            pstm.setString(1, datos[0].toString());
            pstm.setString(2, datos[5].toString());
            pstm.setString(3, datos[6].toString());
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(form, "No se pudo actualizar el registro: \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminarRegistro(String reg, String tipo) {
        String consulta;
        try {
            consulta = "DELETE from " + tipo + " where noParte='" + reg + "'";
            pstm = cn.prepareStatement(consulta);
            pstm.executeUpdate();
            pstm.close();

            consulta = "DELETE from ListaNumPartes where noParte='" + reg + "'";
            pstm = cn.prepareStatement(consulta);
            pstm.executeUpdate();
            pstm.close();

            if (tipo.equals("Rotores")) {
                consulta = "UPDATE Alternadores SET noParteRotor=? where noParteRotor='" + reg + "'";
                pstm = cn.prepareStatement(consulta);
                pstm.setString(1, "---------------");
                pstm.execute();
                pstm.close();
            } else if (tipo.equals("Estatores")) {
                consulta = "UPDATE Alternadores SET noParteEstator=? where noParteEstator='" + reg + "'";
                pstm = cn.prepareStatement(consulta);
                pstm.setString(1, "---------------");
                pstm.execute();
                pstm.close();
            } else if (tipo.equals("Rectificadores")) {
                consulta = "UPDATE Alternadores SET noParteRectificador=? where noParteRectificador='" + reg + "'";
                pstm = cn.prepareStatement(consulta);
                pstm.setString(1, "---------------");
                pstm.execute();
                pstm.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(form, "Error al eliminar el registro registro: \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
