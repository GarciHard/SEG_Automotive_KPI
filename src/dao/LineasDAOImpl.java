package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import modelo.ConexionBD;
import modelo.LineasDAO;

/**
 * Hecho con <3 por:
 * @author GarciHard
 * @boschUsr GJA5TL
 */
public class LineasDAOImpl extends ConexionBD implements LineasDAO {

    private ArrayList<String> lineaArr;
    private boolean existeLinea;
    private Object[] filaTabla;
    private PreparedStatement ps;
    private ResultSet rs;
    private String[] lineaObj;
    
    private final String EXISTE_LINEA = "SELECT linea from Lineas WHERE linea LIKE ?";
    private final String CREAR_LINEA = "INSERT INTO Lineas(linea, tipo, nombre) VALUES(?, ?, ?)";
    private final String LISTA_LINEAS = "SELECT linea FROM Lineas ORDER BY linea ASC";
    private final String LISTA_LINEAS_DESC = "SELECT linea, nombre FROM Lineas ORDER BY linea ASC";
    private final String ACTUALIZA_LINEA = "UPDATE Lineas set linea = ?, tipo = ?, nombre = ? WHERE linea LIKE ?";
    private final String ELIMINA_LINEA = "DELETE FROM Lineas WHERE linea LIKE ?";
    private final String BUSCAR_REGISTRO = "SELECT linea, tipo, nombre FROM Lineas WHERE linea like ?";
    private final String TIPO_ENSAMBLE_LINEA = "SELECT nombre FROM Lineas WHERE linea LIKE ? AND nombre LIKE '%Ensamble Final%'";
    
    @Override
    public DefaultComboBoxModel listaLineas() throws Exception {
        lineaArr = new ArrayList<>();
        lineaArr.add("Selecciona una linea");
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(LISTA_LINEAS);
            rs = ps.executeQuery();

            while (rs.next()) {
                lineaArr.add(rs.getString(1));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ps.close();
            rs.close();
            this.cerrar();
        }
        return new DefaultComboBoxModel(lineaArr.toArray());
    }

    @Override
    public boolean existeLinea(String linea) throws Exception {
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(EXISTE_LINEA);
            ps.setString(1, linea);
            rs = ps.executeQuery();
            
            if (rs.next())
                existeLinea = true;
        } catch (Exception e) {
            throw e;
        } finally {
            ps.close();
            rs.close();
            this.cerrar();
        }
        return existeLinea;
    }

    @Override
    public void crearNvaLinea(String linea, String tipo, String nombre) throws Exception {
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(CREAR_LINEA);
            ps.setString(1, linea);
            ps.setString(2, tipo);
            ps.setString(3, nombre);
            ps.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        } finally {
            ps.close();
            this.cerrar();
        }
    }

    @Override
    public void actualizarLinea(String lineaAct, Object[] lineaNva) throws Exception {
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(ACTUALIZA_LINEA);
            ps.setString(1, String.valueOf(lineaNva[0]));
            ps.setString(2, String.valueOf(lineaNva[1]));
            ps.setString(3, String.valueOf(lineaNva[2]));
            ps.setString(4, lineaAct);
            ps.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        } finally {
            ps.close();
            this.cerrar();
        }
    }

    @Override
    public void eliminarLinea(String linea) throws Exception {
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(ELIMINA_LINEA);
            ps.setString(1, linea);
            ps.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        } finally {
            ps.close();
            this.cerrar();
        }
    }

    @Override
    public DefaultTableModel listaLineasDesc(DefaultTableModel tablaModel) throws Exception {
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(LISTA_LINEAS_DESC);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                filaTabla = new Object[2];
                filaTabla[0] = rs.getString(1);
                filaTabla[1] = rs.getString(2);
                tablaModel.addRow(filaTabla);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ps.close();
            rs.close();
            this.cerrar();
        }
        return tablaModel;
    }

    @Override
    public String[] buscarRegistro(String linea) throws Exception {
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(BUSCAR_REGISTRO);
            ps.setString(1, linea);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                lineaObj = new String[3];
                lineaObj[0] = rs.getString(1);
                lineaObj[1] = rs.getString(2);
                lineaObj[2] = rs.getString(3);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ps.close();
            rs.close();
            this.cerrar();
        }
        return lineaObj;
    }

    @Override
    public int tipoEnsambleLinea(String linea) throws Exception {
        int tipoEnsamble = 0;
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(TIPO_ENSAMBLE_LINEA);
            ps.setString(1, linea);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                tipoEnsamble = 3;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ps.close();
            rs.close();
            this.cerrar();
        }
        return tipoEnsamble;
    }   
}
