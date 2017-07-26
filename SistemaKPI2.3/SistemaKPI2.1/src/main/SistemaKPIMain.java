package main;

import com.alee.laf.WebLookAndFeel;
import vista.SplashScreen;
import control.SplashScreenControl;
import javax.swing.SwingUtilities;

/**
 * Hecho con <3 por:
 * @author GarciHard
 * @boschUsr GJA5TL
 */
public class SistemaKPIMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                WebLookAndFeel.install();
                new SplashScreenControl(new SplashScreen());
            }
        });
    }
}
