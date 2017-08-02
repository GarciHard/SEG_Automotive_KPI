package utils;

import control.PrincipalControl;
import dao.SplashScreenDAOImpl;
import vista.Principal;
import vista.SplashScreen;
import javax.swing.JOptionPane;
import modelo.SplashScreenDAO;

/**
 * Hecho con <3 por:
 * @author GarciHard
 * @boschUsr GJA5TL
 */
public class SplashScreenMetodos {

    private boolean threadFlag;
    private String error;
    private SplashScreenDAOImpl splashScreenDAO;
    
    public void threadProgress(SplashScreen winSplashScreen) {
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i <= 100; i++) {
                    if (!threadFlag) {
                        try {
                            sleep(60);
                        } catch (InterruptedException e) {
                            JOptionPane.showMessageDialog(winSplashScreen, e, "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        interrupt();
                        JOptionPane.showMessageDialog(winSplashScreen, error, "Error", JOptionPane.ERROR_MESSAGE);
                        System.exit(0);
                    }
                }
                new PrincipalControl(new Principal());
                winSplashScreen.dispose();
            }
        }.start();
    }
    
     public void threadQuery() {
         splashScreenDAO = new SplashScreenDAOImpl();
        new Thread() {
            @Override
            public void run() {
                try {
                    sleep(695);
                    splashScreenDAO.testConexion();
                    sleep(695);
                    splashScreenDAO.testAreas();
                    sleep(695);
                    splashScreenDAO.testClientes();
                    sleep(695);
                    splashScreenDAO.testLineas();
                    sleep(695);
                    splashScreenDAO.testListaNoPartes();
                    sleep(695);
                    splashScreenDAO.testOperaciones();
                    sleep(695);
                    splashScreenDAO.testPerdidas();
                    sleep(695);
                    splashScreenDAO.testPromedioLinea();
                    sleep(695);
                    splashScreenDAO.testUsuarios();
                } catch (Exception ex) {
                    error = ex.toString();
                    threadFlag = true;
                }
            }
        }.start();
    }
    
}
