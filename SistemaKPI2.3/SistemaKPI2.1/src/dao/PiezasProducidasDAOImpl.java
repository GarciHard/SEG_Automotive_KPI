package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import modelo.BitacoraDTO;
import modelo.ConexionBD;
import modelo.PiezasProducidasDAO;

/**
 * Hecho con <3 por:
 * @author GarciHard
 * @boschUsr GJA5TL
 */
public class PiezasProducidasDAOImpl extends ConexionBD implements PiezasProducidasDAO {

    private ArrayList<String> clienteArr;
    private ArrayList<String> noParteArr;
    private PreparedStatement ps;
    private ResultSet rs;
    
    private final String LISTA_FAMILIA = "SELECT familia FROM ListaNumPartes WHERE LineaProduce LIKE ? GROUP BY familia ORDER BY familia ASC";
    private final String LISTA_CLIENTES = "SELECT cliente FROM Clientes WHERE linea LIKE ? ORDER BY cliente ASC";
    private final String LISTA_FAMILIA_CLIENTES = "SELECT Cliente FROM ListaNumPartes WHERE LineaProduce LIKE ? AND familia LIKE ? GROUP BY Cliente ORDER BY Cliente ASC";
    private final String LISTA_NO_PARTES_CLIENTE = "SELECT noParte FROM ListaNumPartes WHERE LineaProduce LIKE ? AND cliente LIKE ? ORDER BY noParte ASC";
    private final String LISTA_NO_PARTES_FAMILIA = "SELECT noParte FROM ListaNumPartes WHERE LineaProduce LIKE ? AND familia LIKE ? AND Cliente LIKE ? ORDER BY noParte ASC";
    
    @Override
    public DefaultComboBoxModel listaClientes(String linea) throws Exception {
        clienteArr = new ArrayList<>();
        clienteArr.add("Seleccione un cliente");
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(LISTA_CLIENTES);
            ps.setString(1, linea);
            rs = ps.executeQuery();

            while (rs.next()) {
                clienteArr.add(rs.getString(1));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ps.close();
            rs.close();
            this.cerrar();
        }
        return new DefaultComboBoxModel(clienteArr.toArray());
    }

    @Override
    public DefaultComboBoxModel listaNoParte(String linea, String cliente) throws Exception {
        noParteArr = new ArrayList<>();
        noParteArr.add("Seleccione un No. de parte");
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(LISTA_NO_PARTES_CLIENTE);
            ps.setString(1, linea);
            ps.setString(2, cliente);
            rs = ps.executeQuery();
            while (rs.next()) {
                noParteArr.add(rs.getString(1));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ps.close();
            rs.close();
            this.cerrar();
        }
        return new DefaultComboBoxModel(noParteArr.toArray());
    }

    @Override
    public void agregarPiezasProducidasBitacora(BitacoraDTO piezasProducidasObj) {

    }

    @Override
    public DefaultComboBoxModel listaFamilias(String linea) throws Exception {
        clienteArr = new ArrayList<>();
        clienteArr.add("Seleccione una familia");
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(LISTA_FAMILIA);
            ps.setString(1, linea);
            rs = ps.executeQuery();

            while (rs.next()) {
                clienteArr.add(rs.getString(1));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ps.close();
            rs.close();
            this.cerrar();
        }
        return new DefaultComboBoxModel(clienteArr.toArray());
    }

    @Override
    public DefaultComboBoxModel listaFamiliasClientes(String linea, String familia) throws Exception {
        clienteArr = new ArrayList<>();
        clienteArr.add("Seleccione un cliente");
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(LISTA_FAMILIA_CLIENTES);
            ps.setString(1, linea);
            ps.setString(2, familia);
            rs = ps.executeQuery();

            while (rs.next()) {
                clienteArr.add(rs.getString(1));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ps.close();
            rs.close();
            this.cerrar();
        }
        return new DefaultComboBoxModel(clienteArr.toArray());
    }

    @Override
    public DefaultComboBoxModel listaNoParteFamilia(String linea, String familia, String cliente) throws Exception {
        noParteArr = new ArrayList<>();
        noParteArr.add("Seleccione un No. de parte");
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(LISTA_NO_PARTES_FAMILIA);
            ps.setString(1, linea);
            ps.setString(2, familia);
            ps.setString(3, cliente);
            rs = ps.executeQuery();
            while (rs.next()) {
                noParteArr.add(rs.getString(1));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ps.close();
            rs.close();
            this.cerrar();
        }
        return new DefaultComboBoxModel(noParteArr.toArray());
    }
}
