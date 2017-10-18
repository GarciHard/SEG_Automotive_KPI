package utils;

import java.util.Comparator;

/**
 * Hecho con <3 por:
 * @author GarciHard
 * @boschUsr GJA5TL
 */
public class OrdenaTablaTiempo implements Comparator {

    private int compararHora, compararInicial, compararFinal;
    private Object[] tiempo1, tiempo2;

    @Override
    public int compare(Object o1, Object o2) {
        tiempo1 = (Object[]) o1;
        tiempo2 = (Object[]) o2;

        compararHora = new Integer(tiempo1[2].toString()).compareTo(
                new Integer(tiempo2[2].toString()));

        if (compararHora != 0) {
            return compararHora;
        }

        compararInicial = new Integer(tiempo1[3].toString()).compareTo(
                new Integer(tiempo2[3].toString()));

        if (compararInicial != 0) {
            return compararInicial;
        }

        compararFinal = new Integer(tiempo1[4].toString()).compareTo(
                new Integer(tiempo2[4].toString()));

        return compararFinal;
    }
}