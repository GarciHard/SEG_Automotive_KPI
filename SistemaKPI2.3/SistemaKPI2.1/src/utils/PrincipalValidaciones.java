package utils;

import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import javax.swing.event.CaretEvent;
import javax.swing.event.TableModelEvent;
import vista.Principal;

/**
 * Hecho con <3 por:
 * @author GarciHard
 * @boschUsr GJA5TL
 */
public class PrincipalValidaciones {
    
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
        } else if (winPrincipal.getTxtScrapCalidad().equals(e.getSource())) { //JTextField Scrap -> Panel Calidad
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
        } else if (winPrincipal.getTxtScrapTecnicas().equals(e.getSource())) { //JTextField Scrap -> Panel Tecnicas
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
        } else if (winPrincipal.getTxtScrapCambios().equals(e.getSource())) { //JTextField Scrap -> Panel Cambios
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
        } else if (winPrincipal.getTxtTiempoInicio().equals(e.getSource())) { //JTextField TiempoInicio
            if ((e.getDot() + e.getMark()) == 0 || winPrincipal.getTxtTiempoInicio().getText().isEmpty()) {
                winPrincipal.getTxtTiempoFin().setText("");
                winPrincipal.getTxtTiempoFin().setEnabled(false);
            }
            if (e.getDot() == 1 && e.getMark() == 1) {
                winPrincipal.getTxtTiempoFin().setEnabled(true);
            }
            /*if (winPrincipal.getTxtTiempoInicio().getText().isEmpty()) {
                winPrincipal.getTxtTiempoFin().setText("");
                winPrincipal.getTxtTiempoFin().setEnabled(false);
            }*/
        } else if (winPrincipal.getTxtTiempoFin().equals(e.getSource())) { //JTextField TiempoFin
            if ((e.getDot() + e.getMark()) == 0) {
                winPrincipal.getTxtDuracion().setText("");
            }
            if (winPrincipal.getTxtTiempoFin().getText().isEmpty()) {
                winPrincipal.getTxtDuracion().setText("");
            }
        } else if (winPrincipal.getTxtDuracion().equals(e.getSource())) { //JTextField Duracion
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
        if (winPrincipal.getCmbLinea().equals(e.getSource())) {
            if (winPrincipal.getCmbLinea().getSelectedIndex() == 0) {
                winPrincipal.getCmbTema().setEnabled(false);
            }
        } else if (winPrincipal.getCmbNoPartePzasProd().equals(e.getSource())) { //Panel Piezas Producidas
            if (winPrincipal.getCmbNoPartePzasProd().getSelectedIndex() == 0) {
                winPrincipal.getTxtCantidadProducidaPzasProd().setText("");
                winPrincipal.getTxtCantidadProducidaPzasProd().setEnabled(false);
            }/*else{
                winPrincipal.getTxtCantidadProducidaPzasProd().setText("");
                winPrincipal.getTxtCantidadProducidaPzasProd().setEnabled(true);
            }*/
        } else if (winPrincipal.getCmbNoParteCalidad().equals(e.getSource())) { //Panel Calidad
            if (winPrincipal.getCmbNoParteCalidad().getSelectedIndex() != 0) {
                winPrincipal.getTxtScrapCalidad().setText("");
                winPrincipal.getTxtScrapCalidad().setEnabled(true);
                //winPrincipal.getTxtCantidadProducidaCalidad().setText("");
                //winPrincipal.getTxtCantidadProducidaCalidad().setEnabled(false);
            } else {
                winPrincipal.getTxtScrapCalidad().setText("");
                winPrincipal.getTxtScrapCalidad().setEnabled(false);
            }
        } else if (winPrincipal.getCmbNoParteTecnicas().equals(e.getSource())) { //Panel Tecnica
            if (winPrincipal.getCmbNoParteTecnicas().getSelectedIndex() == 0) {
                winPrincipal.getTxtScrapTecnicas().setText("");
                winPrincipal.getTxtScrapTecnicas().setEnabled(false);
            }/*else{
                winPrincipal.getTxtScrapTecnicas().setText("");
                winPrincipal.getTxtScrapTecnicas().setEnabled(true);
            }
             */
        } else if (winPrincipal.getCmbHora().equals(e.getSource())) { //ComboBox Hora
            if (winPrincipal.getCmbHora().getSelectedIndex() == 0
                    || !winPrincipal.getTxtTiempoInicio().getText().isEmpty()) {
                winPrincipal.getTxtTiempoInicio().setText("");
                winPrincipal.getTxtTiempoInicio().setEnabled(false);
            }/*else {
                winPrincipal.getTxtTiempoInicio().setText("");
                winPrincipal.getTxtTiempoInicio().setEnabled(true);
            }*/

 /*if (!winPrincipal.getTxtTiempoInicio().getText().isEmpty()) {
                winPrincipal.getTxtTiempoInicio().setText("");
            }*/
        }
    }

    public static void validarKeyReleased(Principal winPrincipal, KeyEvent ke) {
        //JTextField Tiempo Inicio
        if (winPrincipal.getTxtTiempoInicio().equals(ke.getSource())) {
            if (!winPrincipal.getTxtTiempoInicio().getText().isEmpty()) {
                if (Integer.parseInt(winPrincipal.getTxtTiempoInicio().getText()) > 58
                        || Integer.parseInt(winPrincipal.getTxtTiempoInicio().getText()) < 0) {
                    winPrincipal.getTxtTiempoInicio().setText("");
                }
            }
        } else if (winPrincipal.getTxtTiempoFin().equals(ke.getSource())) { //JTextField Tiempo Fin
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
                                - Integer.parseInt(winPrincipal.getTxtTiempoInicio().getText());
                        if (!(duracion < 0)) {
                            winPrincipal.getTxtDuracion().setText(String.valueOf(duracion + 1));
                        }
                    }
                }
            }
        }
    }

    public static void validarKeyTyped(Principal winPrincipal, KeyEvent ke) {
        /**
         * ******** Panel Piezas Producidas *********
         */
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
        } else /**
         * ******** Panel Calidad *********
         */
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
        } else /**
         * ******** Panel Tecnicas *********
         */
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
        } else /**
         * ******** Panel Organizacionales *********
         */
        //NA
        /**
         * ******** Panel Cambios *********
         */
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
        } else /**
         * ******** Panel Planeados *********
         */
        //NA
        /**
         * ******** EXTRAS *********
         */
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
        } else //JTextField Tiempo Fin
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

    public static void limpiarTiemposIncidencia(Principal winPrincipal) {
        winPrincipal.getCmbHora().setSelectedIndex(0);
        winPrincipal.getCmbHora().setEnabled(false);
    }

    public static void validarTableModelListener(Principal winPrincipal, TableModelEvent e) {
        if (e.getType() == TableModelEvent.DELETE
                && winPrincipal.getTblBitacora().getRowCount() == 0) {
            winPrincipal.getBtnRevisarHoras().setEnabled(false);
            winPrincipal.getBtnGuardar().setVisible(false);
        } else {
            winPrincipal.getBtnRevisarHoras().setEnabled(true);
            winPrincipal.getBtnGuardar().setVisible(true);
        }
    }
}
