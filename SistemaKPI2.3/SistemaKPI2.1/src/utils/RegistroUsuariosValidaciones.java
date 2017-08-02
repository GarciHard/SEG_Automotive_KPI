package utils;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import javax.swing.event.CaretEvent;
import vista.RegistroUsuarios;

/**
 * Hecho con <3 por:
 * @author GarciHard
 * @boschUsr GJA5TL
 */
public class RegistroUsuariosValidaciones {
    
    public static void validarActionListener(RegistroUsuarios winRegistroUsuarios, ActionEvent e) {
        switch (e.getActionCommand()) {
            case "_btnAceptar":
                new RegistroUsuariosMetodos().guardarUsuario(winRegistroUsuarios.getTxtUsuario().getText(),
                        winRegistroUsuarios.getPwdContraseña().getText(),
                        winRegistroUsuarios.getCmbTipoUsuario().getSelectedItem().toString());
                winRegistroUsuarios.dispose();
                break;
            case "_btnCancelar":
                winRegistroUsuarios.dispose();
                break;
        }
    }

    public static void validarCaretUpdate(RegistroUsuarios winRegistroUsuarios, CaretEvent ce) {
        if (ce.getSource().equals(winRegistroUsuarios.getTxtUsuario())) {
            if ((ce.getDot() + ce.getMark()) == 0) {
                winRegistroUsuarios.getCmbTipoUsuario().setEnabled(false);
            } else if (ce.getDot() == 1 && ce.getMark() == 1) {
                winRegistroUsuarios.getCmbTipoUsuario().setEnabled(true);
            } else if (winRegistroUsuarios.getTxtUsuario().getText().isEmpty()) {
                winRegistroUsuarios.getCmbTipoUsuario().setSelectedIndex(0);
                winRegistroUsuarios.getCmbTipoUsuario().setEnabled(false);
            }
        } else if (ce.getSource().equals(winRegistroUsuarios.getPwdContraseña())) {
            if ((ce.getDot() + ce.getMark()) == 0) {
                winRegistroUsuarios.getBtnAceptar().setEnabled(false);
            } else if (ce.getDot() == 1 && ce.getMark() == 1) {
                winRegistroUsuarios.getBtnAceptar().setEnabled(true);
            } else if (winRegistroUsuarios.getTxtUsuario().getText().isEmpty()) {
                winRegistroUsuarios.getBtnAceptar().setEnabled(false);
            }
        }
    }
    
    public static void validarItemStateChanged(RegistroUsuarios winRegistroUsuarios, ItemEvent ie) {
        if (ie.getSource().equals(winRegistroUsuarios.getCmbTipoUsuario())) {
            if (winRegistroUsuarios.getCmbTipoUsuario().getSelectedIndex() == 0) {
                winRegistroUsuarios.getPwdContraseña().setText("");
                winRegistroUsuarios.getPwdContraseña().setEnabled(false);
            } else {
                winRegistroUsuarios.getPwdContraseña().setEnabled(true);
            }
        }
    }
    
    public static void validarKeyTyped(RegistroUsuarios winRegistroUsuarios, KeyEvent ke) {
        if (ke.getSource().equals(winRegistroUsuarios.getTxtUsuario())) {
            if (winRegistroUsuarios.getTxtUsuario().getText().length() >= 6) {
                ke.consume();
            } else if (winRegistroUsuarios.getTxtUsuario().getText().isEmpty()) {
                winRegistroUsuarios.getCmbTipoUsuario().setSelectedIndex(0);
                winRegistroUsuarios.getCmbTipoUsuario().setEnabled(false);
            }
        } else if (ke.getSource().equals(winRegistroUsuarios.getPwdContraseña())) {
            if (winRegistroUsuarios.getPwdContraseña().getText().length() >= 10) {
                ke.consume();
            } else if (winRegistroUsuarios.getPwdContraseña().getText().isEmpty()) {
                winRegistroUsuarios.getBtnAceptar().setEnabled(false);
            }
        }
    }
}
