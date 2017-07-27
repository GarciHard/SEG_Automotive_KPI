package utils;

import dao.UsuariosDAOImpl;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Hecho con <3 por:
 * @author GarciHard
 * @boschUsr GJA5TL
 */
public class LoginMetodos {

    private JFrame form;
    
    public boolean cambiarLinea(JTextField usuario, JPasswordField contrasena) {
        boolean respuesta = false;
        int privilegio;
        try {
            privilegio = new UsuariosDAOImpl().nivelUsuario(usuario.getText(), contrasena.getText());
            if (privilegio == 3) {
                respuesta = true;
            } else {
                JOptionPane.showMessageDialog(form, "Usuario inválido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(form, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return respuesta;
    }
    
    public boolean validaSupervisor(JTextField usuario, JPasswordField contrasena) {
        boolean respuesta = false;
        int privilegio;
        try {
            privilegio = new UsuariosDAOImpl().nivelUsuario(usuario.getText(), contrasena.getText());
            if (privilegio == 3) {
                respuesta = true;
            } else {
                JOptionPane.showMessageDialog(form, "Usuario inválido:\nProbablemente no tienes Permisos para esta acción", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(form, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return respuesta;
    }
    
    public boolean validaTeamLider(JTextField usuario, JPasswordField contrasena) {
        boolean respuesta = false;
        int privilegio;
        try {
            privilegio = new UsuariosDAOImpl().nivelUsuario(usuario.getText(), contrasena.getText());
            if (privilegio == 2) {
                respuesta = true;
            } else {
                JOptionPane.showMessageDialog(form, "Usuario inválido:\nProbablemente no tienes Permisos para esta acción", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(form, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return respuesta;
    }
    
    public boolean validaAjustador(JTextField usuario, JPasswordField contrasena) {
        boolean respuesta = false;
        int privilegio;
        try {
            privilegio = new UsuariosDAOImpl().nivelUsuario(usuario.getText(), contrasena.getText());
            if (privilegio == 2) {
                System.out.println(privilegio);
                respuesta = true;
            } else {
                JOptionPane.showMessageDialog(form, "Usuario inválido:\nProbablemente no tienes Permisos para esta acción", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(form, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return respuesta;
    }
}
