package control;

import static control.PrincipalControl.winPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import utils.LoginMetodos;
import vista.Login;
import vista.TiempoTurno;

/**
 * Hecho con <3 por:
 * @author GarciHard
 * @boschUsr GJA5TL
 */
public class LoginControl implements ActionListener, KeyListener {

    public static int auxiliarLogin = 0;
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
            case "_btnAceptar": // validaciones para aceptar de Login
                switch (TiempoTurno.auxiliarTiempoTurno) {
                    case 1:
                        if (loginMetodos.cambiarLinea(winLogin.getTxtUsuario(), winLogin.getPwdContrasena())) {
                            TiempoTurno.auxiliarTiempoTurno = 2;
                            winLogin.dispose();
                        }
                        break;
                }
                switch (PrincipalControl.auxiliarPrincipal) {
                    case 1:
                        if (loginMetodos.cambiarLinea(winLogin.getTxtUsuario(), winLogin.getPwdContrasena())) {
                            PrincipalControl.winPrincipal.getBtnCambiarLinea().setText("Aceptar");
                            PrincipalControl.winPrincipal.getCmbLinea().setEnabled(true);
                            winLogin.dispose();
                        }
                        break;
                    case 2:
                        if (loginMetodos.validaSupervisor(winLogin.getTxtUsuario(), winLogin.getPwdContrasena())) {
                            auxiliarLogin = 1;
                            winLogin.dispose();
                        }
                        break;
                    case 3:
                        if (loginMetodos.validaAjustador(winLogin.getTxtUsuario(), winLogin.getPwdContrasena())) {
                            auxiliarLogin = 1;
                            winLogin.dispose();
                        }
                        break;
                    case 4:
                        if (loginMetodos.validaSupervisor(winLogin.getTxtUsuario(), winLogin.getPwdContrasena())) {
                            System.err.println("entro");
                            auxiliarLogin = 1;
                            winLogin.dispose();
                        }
                        break;
                }
                break;
            case "_btnCancelar":
                if (winPrincipal.getCmbLinea().getSelectedIndex() != 0) {
                    winPrincipal.getCmbTema().setEnabled(true);
                }
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
