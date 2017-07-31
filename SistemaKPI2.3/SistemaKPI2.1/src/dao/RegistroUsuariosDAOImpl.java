package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.ConexionBD;
import modelo.RegistroUsuariosDAO;
import modelo.UsuarioDTO;

/**
 * Hecho con <3 por:
 * @author GarciHard
 * @boschUsr GJA5TL
 */
public class RegistroUsuariosDAOImpl extends ConexionBD implements RegistroUsuariosDAO {

    private PreparedStatement ps;
    private ResultSet rs;
    
    private final String CREAR_USUARIO = "INSERT INTO Usuarios (usuario, password, puesto, privilegios) VALUES (?, ?, ?, ?)";
    
    @Override
    public void registrarUsuarios(UsuarioDTO usuario) throws Exception {        
        try {
            this.conectar();
            ps = this.conexion.prepareStatement(CREAR_USUARIO);
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getPassword());
            ps.setString(3, usuario.getPuesto());
            ps.setInt(4, usuario.getPrivilegio());
            
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            ps.close();
            this.cerrar();
        }
    }
}
