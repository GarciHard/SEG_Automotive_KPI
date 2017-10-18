package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import utils.RegistroUsuariosValidaciones;
import utils.RegistroUsuariosMetodos;
import vista.RegistroUsuarios;

/**
 * Hecho con <3 por:
 * @author GarciHard
 * @boschUsr GJA5TL
 */
public class RegistroUsuariosControl implements ActionListener, CaretListener, ItemListener, KeyListener {

    private final RegistroUsuarios winRegistroUsuarios;
    private final RegistroUsuariosMetodos registroUsuariosMetodos = new RegistroUsuariosMetodos();
    
    public RegistroUsuariosControl(RegistroUsuarios winRegistroUsuarios) {
        this.winRegistroUsuarios = winRegistroUsuarios;
        initFrame();
    }
    
    private void initFrame() {
        winRegistroUsuarios.getTxtUsuario().addCaretListener(this);
        winRegistroUsuarios.getTxtUsuario().addKeyListener(this);
        winRegistroUsuarios.getCmbTipoUsuario().addItemListener(this);
        winRegistroUsuarios.getPwdContraseña().addCaretListener(this);
        winRegistroUsuarios.getPwdContraseña().addKeyListener(this);
        winRegistroUsuarios.getPwdVerificar().addCaretListener(this);
        winRegistroUsuarios.getPwdVerificar().addKeyListener(this);
        winRegistroUsuarios.getBtnAceptar().addActionListener(this);
        winRegistroUsuarios.getBtnCancelar().addActionListener(this);
        
        winRegistroUsuarios.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        RegistroUsuariosValidaciones.validarActionListener(winRegistroUsuarios, e);
    }

    @Override
    public void caretUpdate(CaretEvent ce) {
        RegistroUsuariosValidaciones.validarCaretUpdate(winRegistroUsuarios, ce);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        RegistroUsuariosValidaciones.validarKeyTyped(winRegistroUsuarios, ke);
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        RegistroUsuariosValidaciones.validarItemStateChanged(winRegistroUsuarios, ie);
    }
  
    @Override
    public void keyPressed(KeyEvent ke) {}

    @Override
    public void keyReleased(KeyEvent ke) {}
}