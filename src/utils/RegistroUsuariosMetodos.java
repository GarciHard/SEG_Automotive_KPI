package utils;

import dao.RegistroUsuariosDAOImpl;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.UsuarioDTO;

/**
 * Hecho con <3 por:
 * @author GarciHard
 * @boschUsr GJA5TL
 */
public class RegistroUsuariosMetodos {

    private JFrame form;
    
    public void guardarUsuario(String usr, String pwd, String puesto) {
        try {
            new RegistroUsuariosDAOImpl().registrarUsuarios(new UsuarioDTO(
                    usr, pwd, puesto, asignarPrivilegio(puesto)
            ));
            JOptionPane.showMessageDialog(form, "Usuario "+usr+" creado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(form, "RegistroUsuarioMetodos.guardarUsuario()\n"
                    + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private int asignarPrivilegio(String puesto) {
        int privilegio = 0;
        switch (puesto) {
            case "Supervisor":
                privilegio = 3;
                break;
            case "Team Lider":
                privilegio = 2;
                break;
            case "Ajustador":
                privilegio = 1;
                break;
        }
        return privilegio;
    }    
}
