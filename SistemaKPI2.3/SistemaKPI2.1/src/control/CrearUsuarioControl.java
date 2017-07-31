package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import utils.RegistroUsuariosMetodos;
import vista.RegistroUsuarios;

/**
 * Hecho con <3 por:
 * @author GarciHard
 * @boschUsr GJA5TL
 */
public class CrearUsuarioControl implements ActionListener {

    private final RegistroUsuarios winRegistroUsuarios;
    private final RegistroUsuariosMetodos registroUsuariosMetodos = new RegistroUsuariosMetodos();
    
    public CrearUsuarioControl(RegistroUsuarios winRegistroUsuarios) {
        this.winRegistroUsuarios = winRegistroUsuarios;
        initFrame();
    }
    
    private void initFrame() {
        winRegistroUsuarios.getBtnAceptar().addActionListener(this);
        winRegistroUsuarios.getBtnCancelar().addActionListener(this);
        
        winRegistroUsuarios.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "_btnAceptar":
                registroUsuariosMetodos.guardarUsuario(winRegistroUsuarios.getTxtUsuario().getText(),
                        winRegistroUsuarios.getPwdContraseña().getText(),
                        winRegistroUsuarios.getCmbTipoUsuario().getSelectedItem().toString());
                winRegistroUsuarios.dispose();
                break;
        }
    
    }
    
}