package dao;

import javax.swing.DefaultComboBoxModel;

/**
 * Hecho con <3 por:
 * @author GarciHard
 * @boschUsr GJA5TL
 */
public class TemasDAOImpl {

    private static final String[] temas = {"Selecciona Tema", "Piezas Producidas", "Calidad",
        "Técnicas", "Organizacionales", "Cambio", "Planeados"};

    public static DefaultComboBoxModel listaTema() {
        return new DefaultComboBoxModel(temas);
    }

}
