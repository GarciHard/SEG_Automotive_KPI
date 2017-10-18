package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.ConexionBD;
import modelo.UsuariosDAO;

/**
 * Hecho con <3 por:
 * @author GarciHard
 * @boschUsr GJA5TL
 */
public class UsuariosDAOImpl extends ConexionBD implements UsuariosDAO {

    private PreparedStatement ps;
    private ResultSet rs;
    
    private final String PRIVILEGIOS_USUARIO = "SELECT privilegios FROM Usuarios WHERE usuario LIKE ? AND password LIKE ?";
    
    @Override
    public int nivelUsuario(String usuario, String contrasena) throws Exception {
        int privilegio = 0;
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(PRIVILEGIOS_USUARIO);
            ps.setString(1, usuario);
            ps.setString(2, contrasena);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                privilegio = rs.getInt(1);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            ps.close();
            rs.close();
            this.cerrar();
        }
        return privilegio;
    }
}
