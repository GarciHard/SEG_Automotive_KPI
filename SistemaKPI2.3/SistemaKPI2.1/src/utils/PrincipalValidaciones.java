package utils;

import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.CaretEvent;
import vista.Principal;

/**
 * Hecho con <3 por:
 * @author GarciHard
 * @boschUsr GJA5TL
 */
public class PrincipalValidaciones {

    public static void validaKeyTyped(Principal winPrincipal, KeyEvent ke) {
        /********** Panel Piezas Producidas **********/
        //JTextField Cantidad Producida
        if (winPrincipal.getTxtCantidadProducidaPzasProd().equals(ke.getSource())) {
            if ((ke.getKeyChar() < '0' || ke.getKeyChar() > '9')) {
                ke.consume();
            }
            if (winPrincipal.getTxtCantidadProducidaPzasProd().getText().length() >= 3) {
                ke.consume();
            }
            if (winPrincipal.getTxtCantidadProducidaPzasProd().getText().isEmpty()) {
                winPrincipal.getCmbHora().setSelectedIndex(0);
                winPrincipal.getCmbHora().setEnabled(false);
            }
        }
        /********** Panel Calidad **********/
        //JTextField Cantidad Producida
        if (winPrincipal.getTxtCantidadProducidaCalidad().equals(ke.getSource())) {
            if ((ke.getKeyChar() < '0' || ke.getKeyChar() > '9')) {
                ke.consume();
            }
            if (winPrincipal.getTxtCantidadProducidaCalidad().getText().length() >= 3) {
                ke.consume();
            }
            if (winPrincipal.getTxtCantidadProducidaCalidad().getText().isEmpty()) {
                winPrincipal.getTxtScrapCalidad().setText("");
                winPrincipal.getTxtScrapCalidad().setEnabled(false);
            }
        }
        //JTextField Scrap
        if (winPrincipal.getTxtScrapCalidad().equals(ke.getSource())) {
            if ((ke.getKeyChar() < '0' || ke.getKeyChar() > '9')) {
                ke.consume();
            }
            if (winPrincipal.getTxtScrapCalidad().getText().length() >= 3) {
                ke.consume();
            }
            if (winPrincipal.getTxtScrapCalidad().getText().isEmpty()) {
                winPrincipal.getCmbHora().setSelectedIndex(0);
                winPrincipal.getCmbHora().setEnabled(false);
            }
        }
        /********** Panel Tecnicas **********/
        //JTextField Scrap
        if (winPrincipal.getTxtScrapTecnicas().equals(ke.getSource())) {
            if ((ke.getKeyChar() < '0' || ke.getKeyChar() > '9')) {
                ke.consume();
            }
            if (winPrincipal.getTxtScrapTecnicas().getText().length() >= 3) {
                ke.consume();
            }
            if (winPrincipal.getTxtScrapTecnicas().getText().isEmpty()) {
                winPrincipal.getCmbHora().setSelectedIndex(0);
                winPrincipal.getCmbHora().setEnabled(false);
            }
        }
        /********** Panel Organizacionales **********/
        //NA
        /********** Panel Cambios **********/
        //JTextField Scrap
        if (winPrincipal.getTxtScrapCambios().equals(ke.getSource())) {
            if ((ke.getKeyChar() < '0' || ke.getKeyChar() > '9')) {
                ke.consume();
            }
            if (winPrincipal.getTxtScrapCambios().getText().length() >= 3) {
                ke.consume();
            }
            if (winPrincipal.getTxtScrapCambios().getText().isEmpty()) {
                winPrincipal.getCmbHora().setSelectedIndex(0);
                winPrincipal.getCmbHora().setEnabled(false);
            }
        }
        /********** Panel Planeados **********/
        //NA
        /********** EXTRAS **********/
        //JTextField Tiempo Inicio
        if (winPrincipal.getTxtTiempoInicio().equals(ke.getSource())) {
            if ((ke.getKeyChar() < '0' || ke.getKeyChar() > '9')) {
                ke.consume();
            }
            if (winPrincipal.getTxtTiempoInicio().getText().length() >= 2) {
                ke.consume();
            }
            if (winPrincipal.getTxtTiempoInicio().getText().isEmpty()) {
                winPrincipal.getTxtTiempoFin().setText("");
                winPrincipal.getTxtTiempoFin().setEnabled(false);
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
            if (winPrincipal.getTxtDuracion().getText().isEmpty()) {
                winPrincipal.getTxtDuracion().setText("");
                winPrincipal.getTxtDuracion().setEnabled(false);
            }
        }
    }
    
    public static void validaKeyReleased(Principal winPrincipal, KeyEvent ke) {
        //JTextField Tiempo Inicio
        if (winPrincipal.getTxtTiempoInicio().equals(ke.getSource())) {
            if (!winPrincipal.getTxtTiempoInicio().getText().isEmpty()) {
                if (Integer.parseInt(winPrincipal.getTxtTiempoInicio().getText()) > 59
                        || Integer.parseInt(winPrincipal.getTxtTiempoInicio().getText()) < 0) {
                    winPrincipal.getTxtTiempoInicio().setText("");
                }
            }
        }
        //JTextField Tiempo Fin
        if (winPrincipal.getTxtTiempoFin().equals(ke.getSource())) {
            if (!winPrincipal.getTxtTiempoFin().getText().isEmpty()) {
                if (Integer.parseInt(winPrincipal.getTxtTiempoFin().getText()) > 59
                        || Integer.parseInt(winPrincipal.getTxtTiempoFin().getText()) < 0) {
                    winPrincipal.getTxtTiempoFin().setText("");
                } else {
                    if (winPrincipal.getTxtTiempoFin().getText().length() == winPrincipal.getTxtTiempoInicio().getText().length()
                            && Integer.parseInt(winPrincipal.getTxtTiempoInicio().getText()) > Integer.parseInt(winPrincipal.getTxtTiempoFin().getText())) {
                        winPrincipal.getTxtTiempoFin().setText("");
                    } else {
                        int duracion = Integer.parseInt(winPrincipal.getTxtTiempoFin().getText())
                                - Integer.parseInt(winPrincipal.getTxtTiempoInicio().getText())+1;
                        if (!(duracion < 0)) {
                            winPrincipal.getTxtDuracion().setText(String.valueOf(duracion));
                        }                        
                    }
                }
            }
        }
    }
    
    public static void validarCaretUpdate(Principal winPrincipal, CaretEvent e) {
        //JTextField Cantidad Producida -> Panel Piezas Producidas
        if (winPrincipal.getTxtCantidadProducidaPzasProd().equals(e.getSource())) {
            if ((e.getDot() + e.getMark()) == 0) {
                winPrincipal.getCmbHora().setEnabled(false);
            }
            if (e.getDot() == 1 && e.getMark() == 1) {
                winPrincipal.getCmbHora().setEnabled(true);
            }
            if (winPrincipal.getTxtCantidadProducidaPzasProd().getText().isEmpty()) {
                winPrincipal.getCmbHora().setSelectedIndex(0);
                winPrincipal.getCmbHora().setEnabled(false);
            }
        }
        //JTextField Cantidad Producida -> Panel Calidad
        if (winPrincipal.getTxtCantidadProducidaCalidad().equals(e.getSource())) {
            if ((e.getDot() + e.getMark()) == 0) {
                winPrincipal.getTxtScrapCalidad().setEnabled(false);
            }
            if (e.getDot() == 1 && e.getMark() == 1) {
                winPrincipal.getTxtScrapCalidad().setEnabled(true);
            }
            if (winPrincipal.getTxtCantidadProducidaCalidad().getText().isEmpty()) {
                winPrincipal.getTxtScrapCalidad().setText("");
                winPrincipal.getTxtScrapCalidad().setEnabled(false);
            }
        }
        //JTextField Scrap -> Panel Calidad
        if (winPrincipal.getTxtScrapCalidad().equals(e.getSource())) {
            if ((e.getDot() + e.getMark()) == 0) {
                winPrincipal.getCmbHora().setEnabled(false);
            }
            if (e.getDot() == 1 && e.getMark() == 1) {
                winPrincipal.getCmbHora().setEnabled(true);
            }
            if (winPrincipal.getTxtScrapCalidad().getText().isEmpty()) {
                winPrincipal.getCmbHora().setSelectedIndex(0);
                winPrincipal.getCmbHora().setEnabled(false);
            }
        }
        //JTextField Scrap -> Panel Tecnicas
        if (winPrincipal.getTxtScrapTecnicas().equals(e.getSource())) {
            if ((e.getDot() + e.getMark()) == 0) {
                winPrincipal.getCmbHora().setEnabled(false);
            }
            if (e.getDot() == 1 && e.getMark() == 1) {
                winPrincipal.getCmbHora().setEnabled(true);
            }
            if (winPrincipal.getTxtScrapTecnicas().getText().isEmpty()) {
                winPrincipal.getCmbHora().setSelectedIndex(0);
                winPrincipal.getCmbHora().setEnabled(false);
            }
        }
        //JTextField Scrap -> Panel Cambios
        if (winPrincipal.getTxtScrapCambios().equals(e.getSource())) {
            if ((e.getDot() + e.getMark()) == 0) {
                winPrincipal.getCmbHora().setEnabled(false);
            }
            if (e.getDot() == 1 && e.getMark() == 1) {
                winPrincipal.getCmbHora().setEnabled(true);
            }
            if (winPrincipal.getTxtScrapCambios().getText().isEmpty()) {
                winPrincipal.getCmbHora().setSelectedIndex(0);
                winPrincipal.getCmbHora().setEnabled(false);
            }
        }
        //JTextField TiempoInicio
        if (winPrincipal.getTxtTiempoInicio().equals(e.getSource())) {
            if ((e.getDot() + e.getMark()) == 0) {
                winPrincipal.getTxtTiempoFin().setText("");
                winPrincipal.getTxtTiempoFin().setEnabled(false);
            }
            if (e.getDot() == 1 && e.getMark() == 1) {
                winPrincipal.getTxtTiempoFin().setEnabled(true);
            }
            if (winPrincipal.getTxtTiempoInicio().getText().isEmpty()) {
                winPrincipal.getTxtTiempoFin().setText("");
                winPrincipal.getTxtTiempoFin().setEnabled(false);
            }
        }
        //JTextField TiempoFin
        if (winPrincipal.getTxtTiempoFin().equals(e.getSource())) {
            if ((e.getDot() + e.getMark()) == 0) {
                winPrincipal.getTxtDuracion().setText("");
            }
            if (winPrincipal.getTxtTiempoFin().getText().isEmpty()) {
                winPrincipal.getTxtDuracion().setText("");
            }
        }
        //JTextField Duracion
        if (winPrincipal.getTxtDuracion().equals(e.getSource())) {
            if ((e.getDot() + e.getMark()) == 0) {
                winPrincipal.getTxtDuracion().setText("");
                winPrincipal.getBtnAgregarBitacora().setEnabled(false);
            }
            if (e.getDot() == 1 && e.getMark() == 1) {
                winPrincipal.getBtnAgregarBitacora().setEnabled(true);
            }
            if (winPrincipal.getTxtDuracion().getText().isEmpty()) {
                winPrincipal.getBtnAgregarBitacora().setEnabled(false);
            }
            if (!winPrincipal.getTxtDuracion().getText().isEmpty()) {
                winPrincipal.getBtnAgregarBitacora().setEnabled(true);
            }
        }
    }
    
    public static void validarItemStateChanged(Principal winPrincipal, ItemEvent e) {
        //Panel Piezas Producidas
        if (winPrincipal.getCmbNoPartePzasProd().equals(e.getSource())) {
            if (winPrincipal.getCmbNoPartePzasProd().getSelectedIndex() == 0) {
                winPrincipal.getTxtCantidadProducidaPzasProd().setText("");
                winPrincipal.getTxtCantidadProducidaPzasProd().setEnabled(false);
            }
        }
        //Panel Calidad
        if (winPrincipal.getCmbNoParteCalidad().equals(e.getSource())) {
            if (winPrincipal.getCmbNoParteCalidad().getSelectedIndex() == 0) {
                winPrincipal.getTxtCantidadProducidaCalidad().setText("");
                winPrincipal.getTxtCantidadProducidaCalidad().setEnabled(false);
            }
        }
        //Panel Tecnica
        if (winPrincipal.getCmbNoParteTecnicas().equals(e.getSource())) {
            if (winPrincipal.getCmbNoParteTecnicas().getSelectedIndex() == 0) {
                winPrincipal.getTxtScrapTecnicas().setText("");
                winPrincipal.getTxtScrapTecnicas().setEnabled(false);
            }
        }
        //ComboBox Hora
        if (winPrincipal.getCmbHora().equals(e.getSource())) {
            if (winPrincipal.getCmbHora().getSelectedIndex() == 0
                    || !winPrincipal.getTxtTiempoInicio().getText().isEmpty()) {
                winPrincipal.getTxtTiempoInicio().setText("");
                winPrincipal.getTxtTiempoInicio().setEnabled(false);
            }
            if (!winPrincipal.getTxtTiempoInicio().getText().isEmpty())  {
                winPrincipal.getTxtTiempoInicio().setText("");
            }
        }
    }
    
    public static void limpiarTiemposIncidencia(Principal winPrincipal) {
        winPrincipal.getCmbHora().setSelectedIndex(0);
        winPrincipal.getCmbHora().setEnabled(false);
    }
}
