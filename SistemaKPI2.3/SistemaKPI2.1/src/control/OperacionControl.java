package control;

import dao.CalidadDAOImpl;
import dao.TemasDAOImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import utils.OperacionesMetodos;
import utils.PrincipalMetodos;
import vista.Operaciones;
import vista.Principal;

/*
import dao.TemasDAOImpl;
import vista.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import utils.PrincipalMetodos;
import vista.Login;
*/

/**
 *
 * @author PRR1TL
 */
public class OperacionControl implements ActionListener, CaretListener, KeyListener {
    
    private final Operaciones winOperaciones;
    protected static Principal  winPrincipal;
    private final OperacionesMetodos operacionesMetodos = new OperacionesMetodos();
    
    
    public OperacionControl(Operaciones operaciones) {
        this.winOperaciones = operaciones;
        initFrame();        
    }
    
    private void initFrame() {
            winOperaciones.getCmbTema().addActionListener(this);
            winOperaciones.getCmbOperacion().addActionListener(this);
            winOperaciones.getCmbArea().addActionListener(this);
            winOperaciones.getTxtDescOpe().addActionListener(this);
            winOperaciones.getTxtDescProblema().addActionListener(this);
            winOperaciones.getCmbBuscar().addActionListener(this);
            winOperaciones.getBtnGuardar().addActionListener(this);
            //CONSULTAS
            winOperaciones.getCmbTema().setModel(TemasDAOImpl.listaTema());
            
            //winOperaciones.getCmbOperacion().setModel(new CalidadDAOImpl().listaOperacionCalidad(winPrincipal.getCmbLinea().getSelectedItem().toString()));
            winOperaciones.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent evt) {
        switch (evt.getActionCommand()) {
            case "Tema":
                switch (winOperaciones.getCmbTema().getSelectedIndex()) {
                    case 1:
                        System.err.println("Entraaaaaaaaaaaaaaaaaaaaaaaa");
                        try {
                            System.out.println("Entraaaaaaaaaaaaaaaaaaaaaaaa 222222222222222222222");
                            winOperaciones.getCmbOperacion().setModel(new CalidadDAOImpl().listaOperacionCalidad(winPrincipal.getCmbLinea().getSelectedItem().toString()));
                        } catch (Exception ex) {
                            Logger.getLogger(OperacionControl.class.getName()).log(Level.SEVERE, null, ex);
                        }
                       // winOperaciones.getCmbTema().setModel(operacionesMetodos.listaOperacionesCalidad(winPrincipal.getCmbLinea().getSelectedItem().toString()));
                        //winOperaciones.getCmbOperacion().setModel(new OperacionesMetodos().listaOperacionCalidad(winPrincipal.getCmbLinea().getSelectedItem().toString()));
                        break;
                    case 2:
                        
                        break;
                    case 3:
                        
                        break;
                    case 4:
                       
                        break;
                    case 5:
                        
                        break;
                    case 6:
                       
                        break;
                    default:
                        
                        break;
                }
                break;
            case "Operacion":
                break;
            case "Area":
                break;
            case "DescOpe":
                break;
            case "DescProblema":
                break;
            case "Buscar":
                break;
            case "Guardar":
                break;
        }
    }

    @Override
    public void caretUpdate(CaretEvent ce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
