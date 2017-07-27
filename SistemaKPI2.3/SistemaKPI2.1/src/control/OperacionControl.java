/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import static control.PrincipalControl.auxiliar;
import static control.PrincipalControl.winPrincipal;
import dao.CalidadDAOImpl;
import dao.TemasDAOImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import modelo.CalidadDAO;
import utils.PrincipalMetodos;
import vista.Login;
import vista.Operaciones;
import vista.Principal;

/**
 *
 * @author PRR1TL
 */
public class OperacionControl implements ActionListener, CaretListener, KeyListener {
    
    protected static Operaciones winOperaciones;
    private final PrincipalMetodos principalMetodos = new PrincipalMetodos();
    
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
        winOperaciones.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent evt) {
        switch (evt.getActionCommand()) {
            case "Tema":
                switch (winOperaciones.getCmbTema().getSelectedIndex()) {
                    case 1:
                        
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
