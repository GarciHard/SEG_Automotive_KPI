package control;

import utils.SplashScreenMetodos;
import vista.SplashScreen;
import java.awt.event.WindowAdapter;


/**
 * Hecho con <3 por:
 * @author GarciHard
 * @boschUsr GJA5TL
 */
public class SplashScreenControl {

    private final SplashScreen winSplashScreen;
    private final SplashScreenMetodos splashScreenObj = new SplashScreenMetodos();
        
    public SplashScreenControl(SplashScreen splashScreen) {
        this.winSplashScreen = splashScreen;
        initFrame();
    }
    
    private void initFrame() {
        this.winSplashScreen.setVisible(true);
        
        winSplashScreen.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(java.awt.event.WindowEvent evt) {
                splashScreenObj.threadProgress(winSplashScreen);
                splashScreenObj.threadQuery();
            }
        });
           
    }
    
}
