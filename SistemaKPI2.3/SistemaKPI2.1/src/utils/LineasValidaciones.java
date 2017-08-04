package utils;

import java.awt.event.KeyEvent;
import javax.swing.event.CaretEvent;
import vista.Lineas;

/**
 * Hecho con <3 por:
 * @author GarciHard
 * @boschUsr GJA5TL
 */
public class LineasValidaciones {

    public static void validarCaretUpdate(Lineas winLineas, CaretEvent ce) {
        if (ce.getSource().equals(winLineas.getTxtLinea())) {
            if ((ce.getDot() + ce.getMark()) == 0) {
                winLineas.getTxtNombre().setEnabled(false);
                winLineas.getTxtNombre().setText("");
            } else if (ce.getDot() >= 1 && ce.getMark() >= 1) {
                winLineas.getTxtNombre().setEnabled(true);
            } else if (winLineas.getTxtLinea().getText().isEmpty()) {
                winLineas.getTxtNombre().setEnabled(false);
            }
        } else if (ce.getSource().equals(winLineas.getTxtNombre())) {
            if ((ce.getDot() + ce.getMark()) == 0) {
                winLineas.getBtnAgregar().setEnabled(false);
            } else if (ce.getDot() >= 1 && ce.getMark() >= 1) {
                winLineas.getBtnAgregar().setEnabled(true);
            } else if (winLineas.getTxtNombre().getText().isEmpty()) {
                winLineas.getBtnAgregar().setEnabled(false);
            }
        }
    }
    public static void validarItemStateChanged(Lineas winLineas) {
        if (winLineas.getCmbTipoEnsamble().getSelectedIndex() == 0) {
            winLineas.getTxtLinea().setText("");
            winLineas.getTxtLinea().setEnabled(false);
        } else 
            winLineas.getTxtLinea().setEnabled(true);
    }
    public static void validarKeyTyped(Lineas winLineas, KeyEvent ke) {
        if (ke.getSource().equals(winLineas.getTxtLinea())) {
            if (winLineas.getTxtLinea().getText().isEmpty()) {
                winLineas.getTxtNombre().setText("");
            }
        } else if (ke.getSource().equals(winLineas.getTxtNombre())) {
            if (winLineas.getTxtNombre().getText().isEmpty()) {
                winLineas.getBtnAgregar().setEnabled(false);
            }
        }
    }
}
