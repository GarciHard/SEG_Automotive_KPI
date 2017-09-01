package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vista.Operaciones;
import vista.Principal;

/**
 *
 * @author PRR1TL
 */
public abstract class ModeloValidacionesOperaciones  {
    String per;
    public static String linea = "";
    Principal winPrincipal;
    Operaciones winOperaciones;
    
    static ConexionBD con = new ConexionBD();
    //Connection cn = con.getConnection();
    private static ResultSet rs;
    private static PreparedStatement pstm;
    private static JFrame form;
    
    
    public static DefaultTableModel llenaTablaPerdidas(String linea, DefaultTableModel model) throws Exception {
        String consulta;
        Object[] operacion = new Object[4];
        clearTable(model);
        try {
            con.conectar();
            consulta = "select tema, operacion, area, problema from perdidas where linea='" + linea + "'";
            pstm = con.conexion.prepareStatement(consulta);
            rs = pstm.executeQuery();
            while (rs.next()) {
                operacion[0] = rs.getString(1);
                operacion[1] = rs.getString(2);
                operacion[2] = rs.getString(3);
                operacion[3] = rs.getString(4);
                model.addRow(operacion);

            }
            pstm.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(form, "Error al hacer la consulta Operaciones :\n" + ex.getMessage());
        } finally {
            pstm.close();
            rs.close();
            con.cerrar();
        }
        return model;
    }
    
    public static DefaultComboBoxModel listaOperacionesPorLinea(String linea) throws Exception {
        DefaultComboBoxModel listaOP = new DefaultComboBoxModel();
        String consulta, valor = null;
        listaOP.addElement("Elije OPERACION");
        try {
            con.conectar();
            consulta = "select operacion from Operaciones WHERE linea='" + linea + "' ORDER BY operacion DESC";
            pstm = con.conexion.prepareStatement(consulta);
            rs = pstm.executeQuery();
            while (rs.next()) {
                valor = rs.getString(1);
                listaOP.addElement(valor);
            }
            pstm.close();
            rs.close();
            con.cerrar();
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(form, "Error al hacer la consulta :\n" + ex.getMessage());
        }

        return listaOP;
    }
    
    public static void updatePerdida(JDialog ven, Object[] perdida, String perAnteriror) throws Exception {
        try {
            con.conectar();
            String consulta;
            consulta = "UPDATE Perdidas SET problema=? WHERE linea='" + perdida[0] + "' "
                    + "and tema='" + perdida[1] + "'and operacion='" + perdida[2] + "'and area='" + perdida[3] + "' and problema='" + perAnteriror + "'";
            pstm = con.conexion.prepareStatement(consulta);
            pstm.setString(1, perdida[4].toString());
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(ven, "Actualizada correcta", "Registro Actualizado", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(form, "No se pudo Actualizar el registro: \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }finally{
            pstm.close();
            rs.close();
            con.cerrar();
        }
    }
    
    public static String descripcionOperacion(String linea, String op) throws Exception {
        DefaultComboBoxModel listaOP = new DefaultComboBoxModel();
        String consulta, valor = null;
        String desc = "";
        try {
            con.conectar();
            consulta = "select descripcion from Operaciones WHERE linea='" + linea + "' and operacion='" + op + "'";
            pstm = con.conexion.prepareStatement(consulta);
            rs = pstm.executeQuery();
            if (rs.next()) {
                desc = rs.getString(1);
            }
            pstm.close();
            rs.close();
            con.cerrar();
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(form, "Error al hacer la consulta DescOp:\n" + ex.getMessage());
        }

        return desc;
    }
    
    public static void insertaPerdida(Object[] perdida) throws Exception {
        String consulta = "";
        try {
            con.conectar();
            consulta = "INSERT INTO perdidas (linea, tema, operacion, area, problema) VALUES";
            pstm = con.conexion.prepareStatement(consulta + "(?,?,?,?,?)");
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
        } finally{
            pstm.close();
            rs.close();
            con.cerrar();
        }
    }
    
    public static void deletePerdida(JDialog ven, Object[] perdida,String linea) throws Exception {
        try {
            con.conectar();
            String consulta;

            consulta = "DELETE from Perdidas WHERE linea='" + linea+ "'"
                    + "and tema='" + perdida[0] + "'and operacion='" + perdida[1] + "'and area='" + perdida[2] + "' and problema='" + perdida[3] + "'";
            pstm = con.conexion.prepareStatement(consulta);
            pstm.executeUpdate();
            pstm.close();
            JOptionPane.showMessageDialog(form, "Registro eliminado correctamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(form, "Error al eliminar el registro registro: \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }finally{
            pstm.close();
            rs.close();
            con.cerrar();
        }
    }
    
    public static DefaultTableModel busqueda(String linea, String tipo, String txtBuscado, DefaultTableModel model) throws Exception {
        String consulta;
        Object[] operacion = new Object[4];
        //Principal.ms.ClearTable(model);
        clearTable(model);
        try {
            con.conectar();
            consulta = "select tema, operacion, area, problema from perdidas "
                    + "where linea='" + linea + "' and " + tipo + " LIKE '%" + txtBuscado + "%'";
            pstm = con.conexion.prepareStatement(consulta);
            rs = pstm.executeQuery();

            while (rs.next()) {
                operacion[0] = rs.getString(1);
                operacion[1] = rs.getString(2);
                operacion[2] = rs.getString(3);
                operacion[3] = rs.getString(4);
                model.addRow(operacion);
            }
            pstm.close();
            rs.close();
            con.cerrar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(form, "Error al hacer la consulta busqueda:\n" + ex.getMessage());
        }
        return model;
    }
    
    public static void clearTable(DefaultTableModel model) {
        for (int i = 0; i < model.getRowCount(); i++) {
            model.removeRow(i);
            i -= 1;
        }
    }
    
}
