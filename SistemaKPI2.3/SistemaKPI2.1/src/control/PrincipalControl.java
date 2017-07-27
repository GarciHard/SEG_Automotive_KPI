package control;

import dao.TemasDAOImpl;
import vista.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import utils.PrincipalMetodos;
import vista.Login;

/**
 * Hecho con <3 por:
 * @author GarciHard
 * @boschUsr GJA5TL
 */
public class PrincipalControl implements ActionListener, CaretListener,KeyListener {
    
    protected static int auxiliar;
    private final Date fechaActual = new Date(System.currentTimeMillis());
    protected static Principal winPrincipal;
    private final PrincipalMetodos principalMetodos = new PrincipalMetodos();
    
    public PrincipalControl(Principal principal) {
        PrincipalControl.winPrincipal = principal;
        initFrame();
    }

    private void initFrame() {
        winPrincipal.getBtnCambiarLinea().addActionListener(this);
        winPrincipal.getBtnAgregarBitacora().addActionListener(this);
        winPrincipal.getBtnRevisarHoras().addActionListener(this);
        
        winPrincipal.getCmbTema().addActionListener(this);
        winPrincipal.getCmbLinea().addActionListener(this);
        winPrincipal.getCmbHora().addActionListener(this);
        winPrincipal.getTxtTiempoInicio().addKeyListener(this);
        winPrincipal.getTxtTiempoInicio().addCaretListener(this);
        winPrincipal.getTxtTiempoFin().addKeyListener(this);
        winPrincipal.getTxtTiempoFin().addCaretListener(this);
        winPrincipal.getTxtDuracion().addKeyListener(this);
        winPrincipal.getTxtDuracion().addCaretListener(this);
                
        winPrincipal.getCmbTema().setModel(TemasDAOImpl.listaTema());
        winPrincipal.getCmbLinea().setModel(principalMetodos.listaLineas());
        winPrincipal.getDteFecha().setDate(fechaActual);
        winPrincipal.getDteFecha().addActionListener(this);
        
        //Panel Piezas Producias
        winPrincipal.getCmbClientePzasProd().addActionListener(this);
        winPrincipal.getCmbNoPartePzasProd().addActionListener(this);
        winPrincipal.getTxtCantidadProducidaPzasProd().addKeyListener(this);
        winPrincipal.getTxtCantidadProducidaPzasProd().addCaretListener(this);
        
        //Menu Editar
        winPrincipal.getMniEditarPorDia().addActionListener(this);
        
        winPrincipal.setVisible(true);
    }   
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        switch (evt.getActionCommand()) {
            case "_btnCambiarLinea":
                //Aqui va metodo para limpiar todos los campos
                winPrincipal.getCmbTema().setEnabled(false);
                switch (winPrincipal.getBtnCambiarLinea().getText()) {
                    case "Cambiar Linea":
                        auxiliar = 1;
                        new LoginControl(new Login(winPrincipal, true));
                        break;
                    case "Aceptar":
                        winPrincipal.getCmbLinea().setEnabled(false);
                        winPrincipal.getCmbTema().setEnabled(true);
                        winPrincipal.getBtnCambiarLinea().setText("Cambiar Linea");
                        break;
                }
                break;
            case "_cmbTema":
                switch (winPrincipal.getCmbTema().getSelectedIndex()) {
                    case 1:
                        principalMetodos.panelPiezasProducidasCliente(winPrincipal);
                        break;
                    case 2:
                        winPrincipal.getPnlProduccionCollapsible().setContent(winPrincipal.getPnlCalidad());
                        winPrincipal.getPnlProduccionCollapsible().repaint();
                        break;
                    case 3:
                        winPrincipal.getPnlProduccionCollapsible().setContent(winPrincipal.getPnlTecnicas());
                        winPrincipal.getPnlProduccionCollapsible().repaint();
                        break;
                    case 4:
                        winPrincipal.getPnlProduccionCollapsible().setContent(winPrincipal.getPnlOrganizacionales());
                        winPrincipal.getPnlProduccionCollapsible().repaint();
                        break;
                    case 5:
                        winPrincipal.getPnlProduccionCollapsible().setContent(winPrincipal.getPnlCambios());
                        winPrincipal.getPnlProduccionCollapsible().repaint();
                        break;
                    case 6:
                        winPrincipal.getPnlProduccionCollapsible().setContent(winPrincipal.getPnlPlaneados());
                        winPrincipal.getPnlProduccionCollapsible().repaint();
                        break;
                    default:
                        winPrincipal.getPnlProduccionCollapsible().setContent(new javax.swing.JLabel());
                        winPrincipal.getPnlProduccionCollapsible().repaint();
                        break;
                }
                break;
                
            case "_cmbClientePzasProd":
                principalMetodos.panelPiezasProducidasNoParte(winPrincipal);
                break;
            case "_cmbNoPartePzasProd":
                winPrincipal.getTxtCantidadProducidaPzasProd().setEnabled(true);
                break;
            case "_cmbHora":
                winPrincipal.getTxtTiempoInicio().setEnabled(true);
                    break;
            case "_mniEditarPorDia":
                auxiliar = 2;
                new LoginControl(new Login(winPrincipal, true));
                break;
                
            case "btnGuardar":
                System.err.println("YAAAAAAAAAAAAAAAAAAAAAAAAAAAA ENTROOOOOOOOOOOOOOOOOOOOOOOO");
                auxiliar = 3;
                new LoginControl(new Login(winPrincipal, true));
                break;
        }
        if (evt.getSource().equals(winPrincipal.getDteFecha())) {
            System.out.println("<><><><><><><>");
            System.out.println(winPrincipal.getDteFecha().getDate());
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        //JTextField Cantidad Producida -> Panel Piezas Producidas
        if (winPrincipal.getTxtCantidadProducidaPzasProd().equals(ke.getSource())) {
            if ((ke.getKeyChar() < '0' || ke.getKeyChar() > '9')) {
                ke.consume();
            }
            if (winPrincipal.getTxtCantidadProducidaPzasProd().getText().length() >= 3) {
                ke.consume();
            }
            if (winPrincipal.getTxtCantidadProducidaPzasProd().getText().isEmpty()) {
                winPrincipal.getCmbHora().setEnabled(false);
            }
        }
        //JTextField Tiempo Inicio
        if (winPrincipal.getTxtTiempoInicio().equals(ke.getSource())) {
            if ((ke.getKeyChar() < '0' || ke.getKeyChar() > '9')) {
                ke.consume();
            }
            if (winPrincipal.getTxtTiempoInicio().getText().length() >= 2 ) {
                ke.consume();
            }
        }
        //JTextField Tiempo Fin
        if (winPrincipal.getTxtTiempoFin().equals(ke.getSource())) {
            if ((ke.getKeyChar() < '0' || ke.getKeyChar() > '9')) {
                ke.consume();
            }
            if (winPrincipal.getTxtTiempoFin().getText().length() >= 2) {
                ke.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {}

    @Override
    public void keyReleased(KeyEvent ke) {
        if (winPrincipal.getTxtTiempoInicio().equals(ke.getSource())) {
            if (!winPrincipal.getTxtTiempoInicio().getText().isEmpty()) {
                winPrincipal.getTxtTiempoFin().setEnabled(true);
                winPrincipal.getTxtTiempoFin().setText("");
                winPrincipal.getTxtDuracion().setText("");
                winPrincipal.getBtnAgregarBitacora().setEnabled(false);
                if (Integer.parseInt(winPrincipal.getTxtTiempoInicio().getText()) > 59
                        || Integer.parseInt(winPrincipal.getTxtTiempoInicio().getText()) < 0) {
                    winPrincipal.getTxtTiempoInicio().setText("");
                    winPrincipal.getTxtDuracion().setText("");
                    winPrincipal.getBtnAgregarBitacora().setEnabled(false);
                }else{
                    //tiempoInicio=Integer.parseInt(winPrincipal.getTxtTiempoInicio().getText());
                }
            } else{
                winPrincipal.getTxtTiempoFin().setText("");
                winPrincipal.getTxtDuracion().setText("");
                winPrincipal.getBtnAgregarBitacora().setEnabled(false);
            }            
        }
        //Validacion de Tiempo Fin
        if (winPrincipal.getTxtTiempoFin().equals(ke.getSource())) {
            if (!winPrincipal.getTxtTiempoFin().getText().isEmpty()) {
                winPrincipal.getTxtDuracion().setText("");
                winPrincipal.getBtnAgregarBitacora().setEnabled(false);
                if (Integer.parseInt(winPrincipal.getTxtTiempoFin().getText()) > 59 || Integer.parseInt(winPrincipal.getTxtTiempoFin().getText()) < 0) {
                    winPrincipal.getTxtTiempoFin().setText("");
                    winPrincipal.getTxtDuracion().setText("");
                    winPrincipal.getBtnAgregarBitacora().setEnabled(false);
                }else{
                    if (winPrincipal.getTxtTiempoFin().getText().length() == winPrincipal.getTxtTiempoInicio().getText().length() 
                        && Integer.parseInt(winPrincipal.getTxtTiempoInicio().getText()) > Integer.parseInt(winPrincipal.getTxtTiempoFin().getText()) ){
                        winPrincipal.getTxtTiempoFin().setText("");
                        winPrincipal.getTxtDuracion().setText("");
                        winPrincipal.getBtnAgregarBitacora().setEnabled(false);
                    }else if(winPrincipal.getTxtTiempoFin().getText().length() < winPrincipal.getTxtTiempoInicio().getText().length()){
                        winPrincipal.getBtnAgregarBitacora().setEnabled(false);
                    }else{
                        winPrincipal.getTxtDuracion().setText(Integer.toString(Integer.parseInt(winPrincipal.getTxtTiempoFin().getText()) - Integer.parseInt(winPrincipal.getTxtTiempoInicio().getText())+1));
                        winPrincipal.getBtnAgregarBitacora().setEnabled(true);
                    }
                }
            } else{
                winPrincipal.getTxtDuracion().setText("");
                winPrincipal.getBtnAgregarBitacora().setEnabled(false);
            }           
        }
    }

    @Override
    public void caretUpdate(CaretEvent e) {
        if (winPrincipal.getTxtCantidadProducidaPzasProd().equals(e.getSource())) {
            if (e.getDot() == 1 && e.getMark() == 1) {
                winPrincipal.getCmbHora().setEnabled(true);
            }
        }
        if (winPrincipal.getTxtTiempoInicio().equals(e.getSource())) {
            if (e.getDot() == 0 && e.getMark() == 0) {
                winPrincipal.getTxtTiempoFin().setEnabled(false);
            }
        }
    }
}
