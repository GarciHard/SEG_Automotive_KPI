package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import utils.LoginMetodos;
import vista.Login;

/**
 * Hecho con <3 por:
 * @author GarciHard
 * @boschUsr GJA5TL
 */
public class LoginControl implements ActionListener, KeyListener {

    private final Login winLogin;
    private LoginMetodos loginMetodos = new LoginMetodos();
        
    public LoginControl(Login login) {
        this.winLogin = login;
        initFrame();
    }
    
    private void initFrame() {
        winLogin.getTxtUsuario().addKeyListener(this);
        winLogin.getPwdContrasena().addKeyListener(this);
        winLogin.getBtnAceptar().addActionListener(this);
        winLogin.getBtnCancelar().addActionListener(this);
        
        winLogin.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        switch (evt.getActionCommand()) {
            case "_btnAceptar":
                switch (PrincipalControl.auxiliar) {
                    case 1:
                        if (loginMetodos.cambiarLinea(winLogin.getTxtUsuario(), winLogin.getPwdContrasena())) {
                            PrincipalControl.winPrincipal.getBtnCambiarLinea().setText("Aceptar");
                            PrincipalControl.winPrincipal.getCmbLinea().setEnabled(true);
                            winLogin.dispose();
                        }
                        break;
                }
                break;
            case "_btnCancelar":
                winLogin.dispose();
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 10 && !winLogin.getTxtUsuario().getText().isEmpty()) {
            winLogin.getTxtUsuario().transferFocus();
        }
        if (e.getKeyCode() == 10 && !winLogin.getPwdContrasena().getText().isEmpty()) {
            winLogin.getPwdContrasena().transferFocus();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
    
}
