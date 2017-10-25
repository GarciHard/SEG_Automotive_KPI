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
    private static int bn = 0;
    public static void validarCaretUpdate(Principal winPrincipal, CaretEvent e) {
        //JTextField Cantidad Producida -> Panel Piezas Producidas
        if (winPrincipal.getTxtCantidadProducidaPzasProd().equals(e.getSource())) {
            if ((e.getDot() + e.getMark()) == 0) {
                winPrincipal.getCmbHora().setEnabled(false);
                winPrincipal.getBtnParoPeriodo().setVisible(false);
            }
            if (e.getDot() == 1 && e.getMark() == 1) {
                winPrincipal.getCmbHora().setEnabled(true);
                winPrincipal.getBtnParoPeriodo().setVisible(false);
            }
            if (winPrincipal.getTxtCantidadProducidaPzasProd().getText().isEmpty()) {
                winPrincipal.getCmbHora().setSelectedIndex(0);
                winPrincipal.getCmbHora().setEnabled(false);
                winPrincipal.getBtnParoPeriodo().setVisible(false);
            }
        } else if (winPrincipal.getTxtScrapCalidad().equals(e.getSource())) { //JTextField Scrap -> Panel Calidad
            if ((e.getDot() + e.getMark()) == 0) {
                winPrincipal.getCmbHora().setEnabled(false);
                winPrincipal.getBtnParoPeriodo().setVisible(false);
            }
            if (e.getDot() == 1 && e.getMark() == 1) {
                winPrincipal.getCmbHora().setEnabled(true);
                winPrincipal.getBtnParoPeriodo().setVisible(true);
            }
            if (winPrincipal.getTxtScrapCalidad().getText().isEmpty()) {
                winPrincipal.getCmbHora().setSelectedIndex(0);
                winPrincipal.getCmbHora().setEnabled(false);
                winPrincipal.getBtnParoPeriodo().setVisible(false);
            }
        } else if (winPrincipal.getTxtScrapTecnicas().equals(e.getSource())) { //JTextField Scrap -> Panel Tecnicas
            if ((e.getDot() + e.getMark()) == 0) {
                winPrincipal.getCmbHora().setEnabled(false);
                winPrincipal.getBtnParoPeriodo().setVisible(false);
            }
            if (e.getDot() == 1 && e.getMark() == 1) {
                winPrincipal.getCmbHora().setEnabled(true);
                winPrincipal.getBtnParoPeriodo().setVisible(true);
            }
            if (winPrincipal.getTxtScrapTecnicas().getText().isEmpty()) {
                winPrincipal.getCmbHora().setSelectedIndex(0);
                winPrincipal.getCmbHora().setEnabled(false);
                winPrincipal.getBtnParoPeriodo().setVisible(false);
            }
        } else if (winPrincipal.getTxtScrapCambios().equals(e.getSource())) { //JTextField Scrap -> Panel Cambios
            if ((e.getDot() + e.getMark()) == 0) {
                winPrincipal.getCmbHora().setEnabled(false);
                winPrincipal.getBtnParoPeriodo().setVisible(false);
            }
            if (e.getDot() == 1 && e.getMark() == 1) {
                winPrincipal.getCmbHora().setEnabled(true);
                winPrincipal.getBtnParoPeriodo().setVisible(false);
            }
            if (winPrincipal.getTxtScrapCambios().getText().isEmpty()) {
                winPrincipal.getCmbHora().setSelectedIndex(0);
                winPrincipal.getCmbHora().setEnabled(false);
                winPrincipal.getBtnParoPeriodo().setVisible(false);
            }
        } else if (winPrincipal.getTxtTiempoInicio().equals(e.getSource())) { //JTextField TiempoInicio
            if ((e.getDot() + e.getMark()) == 0 || winPrincipal.getTxtTiempoInicio().getText().isEmpty()) {
                winPrincipal.getTxtTiempoFin().setText("");
                winPrincipal.getTxtTiempoFin().setEnabled(false);                
            }
            if (e.getDot() == 1 && e.getMark() == 1) {
                winPrincipal.getTxtTiempoFin().setEnabled(true);
            }
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
        } else if (winPrincipal.getTxtTC().equals(e.getSource())){
            if (winPrincipal.getTxtTC().getText().isEmpty()) {
                winPrincipal.getTxtCantidadProducidaPzasProd().setText("");
                winPrincipal.getTxtCantidadProducidaPzasProd().setEnabled(false);
            }else {
                winPrincipal.getTxtCantidadProducidaPzasProd().setEnabled(true);
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
                winPrincipal.getTxtTC().setText("");
                winPrincipal.getTxtTC().setEnabled(false);
            }
        } else if (winPrincipal.getCmbNoParteCalidad().equals(e.getSource())) { //Panel Calidad
            if (winPrincipal.getCmbNoParteCalidad().getSelectedIndex() != 0) {
                winPrincipal.getTxtScrapCalidad().setText("");
                winPrincipal.getTxtScrapCalidad().setEnabled(true);
            } else {
                winPrincipal.getTxtScrapCalidad().setText("");
                winPrincipal.getTxtScrapCalidad().setEnabled(false);
            }
        } else if (winPrincipal.getCmbNoParteTecnicas().equals(e.getSource())) { //Panel Tecnica
            if (winPrincipal.getCmbNoParteTecnicas().getSelectedIndex() == 0) {
                winPrincipal.getTxtScrapTecnicas().setText("");
                winPrincipal.getTxtScrapTecnicas().setEnabled(false);
            }
        } else if (winPrincipal.getCmbHora().equals(e.getSource())) { //ComboBox Hora
            if (winPrincipal.getCmbHora().getSelectedIndex() == 0
                    || !winPrincipal.getTxtTiempoInicio().getText().isEmpty()) {
                winPrincipal.getTxtTiempoInicio().setText("");
                winPrincipal.getTxtTiempoInicio().setEnabled(false);
            }
        } else if (winPrincipal.getCmbClienteOrganizacional().equals(e.getSource())){
            if (winPrincipal.getCmbClienteOrganizacional().getSelectedIndex() == 0){
                winPrincipal.getCmbNoParteOrganizacional().setSelectedIndex(0);
                winPrincipal.getCmbNoParteOrganizacional().setEnabled(false);
            } 
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
        if(winPrincipal.getTxtTC().equals(ke.getSource())) {
            if ((ke.getKeyChar() < '0' || ke.getKeyChar() > '9')) {
                ke.consume();
            }
            if(winPrincipal.getTxtTC().getText().length()>=2){
                ke.consume();
            }
            if (winPrincipal.getTxtTC().getText().isEmpty()){
                winPrincipal.getTxtCantidadProducidaPzasProd().setEnabled(false);
                winPrincipal.getTxtCantidadProducidaPzasProd().setText("");
            }else {
                winPrincipal.getTxtCantidadProducidaPzasProd().setText("");
                winPrincipal.getTxtCantidadProducidaPzasProd().setEnabled(true);
            }
        }else if (winPrincipal.getTxtCantidadProducidaPzasProd().equals(ke.getSource())) {
            if ((ke.getKeyChar() < '0' || ke.getKeyChar() > '9')) {
                ke.consume();
            }
            if (winPrincipal.getTxtCantidadProducidaPzasProd().getText().length() >= 3) {
                ke.consume();
            }
            if (winPrincipal.getTxtCantidadProducidaPzasProd().getText().isEmpty()) {
                winPrincipal.getCmbHora().setSelectedIndex(0);
                winPrincipal.getCmbHora().setEnabled(false);
                winPrincipal.getBtnParoPeriodo().setVisible(false);
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
                winPrincipal.getBtnParoPeriodo().setVisible(false);
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
                winPrincipal.getBtnParoPeriodo().setVisible(false);
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
                winPrincipal.getBtnParoPeriodo().setVisible(false);
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
        } else if (winPrincipal.getTxtMatFaltante().equals(ke.getSource())){ /**** aqui me quede ***/
            int dig = winPrincipal.getTxtMatFaltante().getText().length();
            System.out.println(dig+" - "+ke.getKeyChar()+" , "+bn);
            if(((ke.getKeyChar() < '0' || ke.getKeyChar() > '9') && (ke.getKeyChar() != 'F' && ke.getKeyChar() != 'M' && ke.getKeyChar() != 'B' && ke.getKeyChar() != 'A' && 
                 ke.getKeyChar() != 'C' && ke.getKeyChar() != 'E' && ke.getKeyChar() != 'L')  && (ke.getKeyChar() != '.'))) {
                ke.consume();
            } else {
                if (ke.getKeyChar() == '.'){
                    if( dig <= 3 || dig == 5 || dig == 6 || dig == 7 || dig >= 9 ){
                        ke.consume();
                        bn = 0;
                    }else {
                        bn = 1;
                        System.out.println(bn);
                    }
                }else {
                    if ( bn == 1){
                        if (dig == 4 || dig == 8 && bn == 0){
                            ke.consume();
                            bn = 0;
                        }
                        if (bn == 1 && dig > 10){
                            if (dig == 11){
                                winPrincipal.getCmbHora().setEnabled(true);
                            }else {
                                ke.consume();
                            }
                        }
                    } else if(bn == 0 && dig > 8){
                        if (dig == 9){
                            winPrincipal.getCmbHora().setEnabled(true);
                        }else {
                            ke.consume();
                        }
                    }
                }
            }
            if (winPrincipal.getTxtMatFaltante().getText().isEmpty() || dig < 9 ) {
                winPrincipal.getCmbHora().setSelectedIndex(0);
                winPrincipal.getCmbHora().setEnabled(false);
                //bn = 0;
            }
        }
    }

    public static void limpiarTiemposIncidencia(Principal winPrincipal) {
        winPrincipal.getCmbHora().setSelectedIndex(0);
        winPrincipal.getCmbHora().setEnabled(false);
        winPrincipal.getBtnParoPeriodo().setVisible(false);
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
