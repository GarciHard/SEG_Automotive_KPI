package dao;

import modelo.ConexionBD;
import utils.ErrorTablaException;
import modelo.SplashScreenDAO;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Hecho con <3 por:
 * @author GarciHard
 * @boschUsr GJA5TL
 */
public class SplashScreenDAOImpl extends ConexionBD implements SplashScreenDAO {

    private final String TEST_TABLA_AREAS = "SELECT COUNT(*) FROM areas";
    private final String TEST_TABLA_CLIENTES = "SELECT COUNT(*) FROM Clientes";
    private final String TEST_TABLA_LINEAS = "SELECT COUNT(*) FROM Lineas";
    private final String TEST_TABLA_LISTA_NO_PARTES = "SELECT COUNT(*) FROM ListaNumPartes";
    private final String TEST_TABLA_OPERACIONES = "SELECT COUNT(*) FROM operaciones";
    private final String TEST_TABLA_PERDIDAS = "SELECT COUNT(*) FROM Perdidas";
    private final String TEST_TABLA_PROMEDIO_LINEA = "SELECT COUNT(*) FROM promedioLinea";
    private final String TEST_TABLA_USUARIOS = "SELECT COUNT(*) FROM Usuarios";
    
    private Statement st = null;
    private ResultSet rs = null;
    
    @Override
    public void testConexion() throws Exception {
        try {
            this.conectar();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void testAreas() throws Exception {
        try {
            this.conectar();
            st = this.conexion.createStatement();
            rs = st.executeQuery(TEST_TABLA_AREAS);

            if (!rs.next()) {
                throw new ErrorTablaException("Error tabla Clientes");
            }

        } catch (Exception e) {
            throw e;
        } finally {
            st.close();
            rs.close();
            this.cerrar();
        }
    }
    
    @Override
    public void testClientes() throws Exception {
        try {
            this.conectar();
            st = this.conexion.createStatement();
            rs = st.executeQuery(TEST_TABLA_CLIENTES);
            
            if (!rs.next()) {
                throw new ErrorTablaException("Error tabla Clientes");
            }
            
        } catch (Exception e) {
            throw e;
        } finally {
            st.close();
            rs.close();
            this.cerrar();
        }
    }

    @Override
    public void testLineas() throws Exception {
        try {
            this.conectar();
            st = this.conexion.createStatement();
            rs = st.executeQuery(TEST_TABLA_LINEAS);
            
            if (!rs.next()) {
                throw new ErrorTablaException("Error tabla Lineas");
            }
            
        } catch (Exception e) {
            throw e;
        } finally {
            st.close();
            rs.close();
            this.cerrar();
        }
    }

    @Override
    public void testListaNoPartes() throws Exception {
        try {
            this.conectar();
            st = this.conexion.createStatement();
            rs = st.executeQuery(TEST_TABLA_LISTA_NO_PARTES);
            
            if (!rs.next()) {
                throw new ErrorTablaException("Error tabla ListaNoPartes");
            }
            
        } catch (Exception e) {
            throw e;
        } finally {
            st.close();
            rs.close();
            this.cerrar();
        }
    }

    @Override
    public void testOperaciones() throws Exception {
        try {
            this.conectar();
            st = this.conexion.createStatement();
            rs = st.executeQuery(TEST_TABLA_OPERACIONES);
            
            if (!rs.next()) {
                throw new ErrorTablaException("Error tabla Operaciones");
            }
            
        } catch (Exception e) {
            throw e;
        } finally {
            st.close();
            rs.close();
            this.cerrar();
        }
    }

    @Override
    public void testPerdidas() throws Exception {
        try {
            this.conectar();
            st = this.conexion.createStatement();
            rs = st.executeQuery(TEST_TABLA_PERDIDAS);
            
            if (!rs.next()) {
                throw new ErrorTablaException("Error tabla Perdidas");
            }
            
        } catch (Exception e) {
            throw e;
        } finally {
            st.close();
            rs.close();
            this.cerrar();
        }
    }

    @Override
    public void testPromedioLinea() throws Exception {
        try {
            this.conectar();
            st = this.conexion.createStatement();
            rs = st.executeQuery(TEST_TABLA_PROMEDIO_LINEA);
            
            if (!rs.next()) {
                throw new ErrorTablaException("Error tabla Promedio Linea");
            }
            
        } catch (Exception e) {
            throw e;
        } finally {
            st.close();
            rs.close();
            this.cerrar();
        }
    }

    @Override
    public void testUsuarios() throws Exception {
        try {
            this.conectar();
            st = this.conexion.createStatement();
            rs = st.executeQuery(TEST_TABLA_USUARIOS);
            
            if (!rs.next()) {
                throw new ErrorTablaException("Error tabla Usuarios");
            }
            
        } catch (Exception e) {
            throw e;
        } finally {
            st.close();
            rs.close();
            this.cerrar();
        }
    }
}