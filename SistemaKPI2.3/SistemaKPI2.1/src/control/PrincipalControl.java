package control;

import dao.TemasDAOImpl;
import vista.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import utils.PrincipalMetodos;
import utils.PrincipalValidaciones;
import vista.Cargas;
import vista.Lineas;
import vista.Login;
import vista.Operaciones;
import vista.RegistroUsuarios;
import vista.TiempoTurno;
import vista.TiemposFaltantes;

/**
 * Hecho con <3 por:
 * @author GarciHard
 * @boschUsr GJA5TL
 */
public class PrincipalControl implements ActionListener, CaretListener, ItemListener, KeyListener, TableModelListener {
    
    public static int auxiliarPrincipal;
    private final SimpleDateFormat fechaFormato = new SimpleDateFormat("dd/MM/yyyy");
    protected static Principal winPrincipal;
    private final PrincipalMetodos principalMetodos = new PrincipalMetodos();
    public static String linea;
    protected static Operaciones winOperaciones;
    public static int bndLinea = 0;
    
    
    public PrincipalControl(Principal principal) {
        PrincipalControl.winPrincipal = principal;
        initFrame();
    }

    private void initFrame() {
        winPrincipal.getDteFecha().setDateFormat(fechaFormato);
        winPrincipal.getDteFecha().setDate(new Date(System.currentTimeMillis()));
        winPrincipal.getDteFecha().addActionListener(this);
        //winPrincipal.getCmbLinea().setModel(principalMetodos.listaLineas());
        winPrincipal.getCmbLinea().addActionListener(this);
        winPrincipal.getCmbLinea().addItemListener(this);
        winPrincipal.getCmbTema().setModel(TemasDAOImpl.listaTema());
        winPrincipal.getCmbTema().addActionListener(this);
        
        winPrincipal.getCmbHora().addActionListener(this);
        winPrincipal.getCmbHora().addItemListener(this);
        winPrincipal.getTxtTiempoInicio().addCaretListener(this);
        winPrincipal.getTxtTiempoInicio().addKeyListener(this);
        winPrincipal.getTxtTiempoFin().addCaretListener(this);
        winPrincipal.getTxtTiempoFin().addKeyListener(this);
        winPrincipal.getTxtDuracion().addCaretListener(this);
              
        winPrincipal.getBtnCambiarLinea().addActionListener(this);
        winPrincipal.getBtnAgregarBitacora().addActionListener(this);
        winPrincipal.getBtnRevisarHoras().addActionListener(this);
        winPrincipal.getBtnGuardar().addActionListener(this);
        winPrincipal.getBtnGuardar().setVisible(false);
        winPrincipal.getBtnCancelar().addActionListener(this);
        winPrincipal.getBtnCancelar().setVisible(false);
        
        //Panel Piezas Producias
        winPrincipal.getCmbClientePzasProd().addActionListener(this);
        winPrincipal.getCmbNoPartePzasProd().addActionListener(this);
        winPrincipal.getCmbNoPartePzasProd().addItemListener(this);
        winPrincipal.getTxtTC().addCaretListener(this);
        winPrincipal.getTxtTC().addKeyListener(this);
        winPrincipal.getTxtCantidadProducidaPzasProd().addCaretListener(this);
        winPrincipal.getTxtCantidadProducidaPzasProd().addKeyListener(this);
        
        
        //Panel Calidad
        winPrincipal.getCmbOperacionCalidad().addActionListener(this);
        winPrincipal.getCmbAreaCalidad().addActionListener(this);
        winPrincipal.getCmbProblemaCalidad().addActionListener(this);
        winPrincipal.getCmbClienteCalidad().addActionListener(this);
        winPrincipal.getCmbNoParteCalidad().addActionListener(this);
        winPrincipal.getCmbNoParteCalidad().addItemListener(this);
        //winPrincipal.getTxtCantidadProducidaCalidad().addCaretListener(this);
        //winPrincipal.getTxtCantidadProducidaCalidad().addKeyListener(this);
        winPrincipal.getTxtScrapCalidad().addCaretListener(this);
        winPrincipal.getTxtScrapCalidad().addKeyListener(this);
        
        //Panel Tecnicas
        winPrincipal.getCmbOperacionTecnicas().addActionListener(this);
        winPrincipal.getCmbAreaTecnicas().addActionListener(this);
        winPrincipal.getCmbProblemaTecnicas().addActionListener(this);
        winPrincipal.getCmbClienteTecnicas().addActionListener(this);
        winPrincipal.getCmbNoParteTecnicas().addActionListener(this);
        winPrincipal.getCmbNoParteTecnicas().addItemListener(this);
        winPrincipal.getTxtScrapTecnicas().addCaretListener(this);
        winPrincipal.getTxtScrapTecnicas().addKeyListener(this);
        
        //Panel Organizacionales
        winPrincipal.getCmbAreaOrganizacional().addActionListener(this);
        winPrincipal.getCmbProblemaOrganizacional().addActionListener(this);
        winPrincipal.getCmbClienteOrganizacional().addActionListener(this);
        winPrincipal.getCmbNoParteOrganizacional().addActionListener(this);
        winPrincipal.getTxtMatFaltante().addKeyListener(this);
        
        //Panel Cambios
        winPrincipal.getCmbAreaCambios().addActionListener(this);
//        winPrincipal.getCmbProblemaCambios().addActionListener(this);
        winPrincipal.getCmbClienteCambios().addActionListener(this);
        winPrincipal.getCmbNoParteCambios().addActionListener(this);
        winPrincipal.getCmbNoParteCambioCambios().addActionListener(this);
        winPrincipal.getCmbClienteNuevoCambios().addActionListener(this);
        winPrincipal.getCmbNoParteCambioCambios().addItemListener(this);
        winPrincipal.getTxtScrapCambios().addCaretListener(this);
        winPrincipal.getTxtScrapCambios().addKeyListener(this);
        
        //Panel Planeados
        winPrincipal.getCmbAreaPlaneados().addActionListener(this);
        winPrincipal.getCmbClientePlaneados().addActionListener(this);
        winPrincipal.getCmbNoPartePlaneados().addActionListener(this);
        
        //Menu Lineas
        winPrincipal.getMniLineas().addActionListener(this);
        //Menu EditarBitacora
        winPrincipal.getMniEditarPorDia().addActionListener(this);
        
        //MenuEliminarBitacora
        winPrincipal.getMniEliminar().addActionListener(this);
        
        //MenuCrearUsuario
        winPrincipal.getMniCrearUsuario().addActionListener(this);
        
        //Menu Operaciones
        winPrincipal.getMniOperaciones().addActionListener(this);
        
        //Carga Masiva
        winPrincipal.getMniCargaMasiva().addActionListener(this);
        
        //Tabla Bitacora
        winPrincipal.getTblBitacora().getModel().addTableModelListener(this);
        winPrincipal.getTblBitacora().setRowHeight(35);
        
        winPrincipal.setVisible(true);
    }   
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        switch (evt.getActionCommand()) {
            //***** Barra de Menu *****
            case "_mniCargaMasiva":
                linea = winPrincipal.getCmbLinea().getSelectedItem().toString();
                bndLinea = 1;
                try {
                    new Cargas(winPrincipal, true).setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(PrincipalControl.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "_mniLineas":
                new Lineas(winPrincipal, true).setVisible(true);
                break;
            case "_mniEditarPorDia":
                principalMetodos.editarBitacoraPorDia(winPrincipal);
                break;
            case "_mniEliminar":
                principalMetodos.eliminarRegistroBitacora(winPrincipal);
                break;
            case "_mniCrearUsuario":
                new RegistroUsuariosControl(new RegistroUsuarios(winPrincipal, true));
                break;
            //***** Panel Superior *****
            case "_btnCambiarLinea":
                new TiempoTurno(winPrincipal, true).setVisible(true);
//                switch (winPrincipal.getBtnCambiarLinea().getText()) {
//                    case "Elegir turno":
//                        auxiliarPrincipal = 1;
//                        winPrincipal.getCmbTema().setSelectedIndex(0);
//                        new LoginControl(new Login(winPrincipal, true));
//                        new TiempoTurno(winPrincipal, true).setVisible(true);
//                        break;
//                    case "Aceptar":
//                        winPrincipal.getCmbTema().setEnabled(true);
//                        winPrincipal.getMniOperaciones().setEnabled(true);
//                        winPrincipal.getMniCargaMasiva().setEnabled(true);
//                        winPrincipal.getBtnCambiarLinea().setText("Elegir turno");
//                        break;
//                }         
                break;
//            case "_btnCambiarLinea":
//                winPrincipal.getCmbTema().setEnabled(false);
//                switch (winPrincipal.getBtnCambiarLinea().getText()) {
//                    case "Cambiar Linea":
//                        auxiliarPrincipal = 1;
//                        winPrincipal.getCmbTema().setSelectedIndex(0);
//                        new LoginControl(new Login(winPrincipal, true));
//                        break;
//                    case "Aceptar":
//                        winPrincipal.getCmbLinea().setEnabled(false);
//                        winPrincipal.getCmbTema().setEnabled(true);
//                        winPrincipal.getMniOperaciones().setEnabled(true);
//                        winPrincipal.getMniCargaMasiva().setEnabled(true);
//                        winPrincipal.getBtnCambiarLinea().setText("Cambiar Linea");
//                        break;
//                }
//                break;
            case "_cmbTema":
                switch (winPrincipal.getCmbTema().getSelectedIndex()) {
                    case 1:
                        principalMetodos.panelPiezasProducidasClientes(winPrincipal);
                        break;
                    case 2:
                        principalMetodos.panelCalidadOperaciones(winPrincipal);
                        break;
                    case 3:
                        principalMetodos.panelTecnicasOperaciones(winPrincipal);
                        break;
                    case 4:
                        principalMetodos.panelOrganizacionalesAreas(winPrincipal);
                        break;
                    case 5:
                        principalMetodos.panelCambiosAreas(winPrincipal);
                        break;
                    case 6:
                        principalMetodos.panelPlaneadosAreas(winPrincipal);
                        break;
                    case 7:
                        principalMetodos.panelTiempoFaltante(winPrincipal);
                        break;
                    default:
                        PrincipalValidaciones.limpiarTiemposIncidencia(winPrincipal);
                        winPrincipal.getPnlProduccionCollapsible().setContent(new javax.swing.JLabel());
                        winPrincipal.getPnlProduccionCollapsible().repaint();
                        break;
                }
                break;        
            //***** Panel Piezas Producidas *****
            case "_cmbClientePzasProd":
                principalMetodos.panelPiezasProducidasNoPartes(winPrincipal);
                break;
            case "_cmbNoPartePzasProd":
                winPrincipal.getTxtTC().setText("");
                winPrincipal.getTxtTC().setEnabled(true);
                //winPrincipal.getTxtCantidadProducidaPzasProd().setText("");
                //winPrincipal.getTxtCantidadProducidaPzasProd().setEnabled(true);
                break;
            //***** Panel Calidad *****
            case "_cmbOperacionCalidad":
                principalMetodos.panelCalidadAreas(winPrincipal);
                break;
            case "_cmbAreaCalidad":
                principalMetodos.panelCalidadProblemas(winPrincipal);
                break;
            case "_cmbProblemaCalidad":
                principalMetodos.panelCalidadClientes(winPrincipal);
                break;
            case "_cmbClienteCalidad":
                principalMetodos.panelCalidadNoPartes(winPrincipal);
                break;
            case "_cmbNoParteCalidad":
                //winPrincipal.getTxtScrapCalidad().setText("");
                //winPrincipal.getTxtScrapCalidad().setEnabled(true);
                //winPrincipal.getTxtCantidadProducidaCalidad().setText("");
                //winPrincipal.getTxtCantidadProducidaCalidad().setEnabled(true);
                break;
            //***** Panel Tecnicas *****
            case "_cmbOperacionTecnicas":
                principalMetodos.panelTecnicasAreas(winPrincipal);
                break;
            case "_cmbAreaTecnicas":
                principalMetodos.panelTecnicasProblemas(winPrincipal);
                break;
            case "_cmbProblemaTecnicas":
                principalMetodos.panelTecnicasClientes(winPrincipal);
                break;
            case "_cmbClienteTecnicas":
                principalMetodos.panelTecnicasNoPartes(winPrincipal);
                break;
            case "_cmbNoParteTecnicas":
                winPrincipal.getTxtScrapTecnicas().setText("");
                winPrincipal.getTxtScrapTecnicas().setEnabled(true);
                break;
            //***** Panel Organizacionales *****
            case "_cmbAreaOrganizacional":
                principalMetodos.panelOrganizacionalesProblemas(winPrincipal);
                break;
            case "_cmbProblemaOrganizacional":
                principalMetodos.panelOrganizacionalesClientes(winPrincipal);
                break;
            case "_cmbClienteOrganizacional":
                principalMetodos.panelOrganizacionalesNoPartes(winPrincipal);
                break;
            case "_cmbNoParteOrganizacional":
                winPrincipal.getCmbHora().setSelectedIndex(0);
                winPrincipal.getCmbHora().setEnabled(true);
                break;
            //***** Panel Cambios*****
            case "_cmbAreaCambios":
                //principalMetodos.panelCambiosProblemas(winPrincipal);
                principalMetodos.panelCambiosClientes(winPrincipal);
                break;
            case "_cmbProblemaCambios":
                principalMetodos.panelCambiosClientes(winPrincipal);
                break;
            case "_cmbClienteCambios":
                principalMetodos.panelCambiosNoPartes(winPrincipal);
                break;
            case "_cmbNoParteCambios":
                //principalMetodos.panelCambiosNoPartesCambios(winPrincipal);
                principalMetodos.panelCambiosClienteNuevo(winPrincipal);
                break;
            case "_cmbClienteNuevoCambios":
                principalMetodos.panelCambiosNoPartesCambios(winPrincipal);
                break;    
            case "_cmbNoParteCambioCambios":
                winPrincipal.getTxtScrapCambios().setText("");
                winPrincipal.getTxtScrapCambios().setEnabled(true);
                break;
            //***** Panel Planeados *****
            case "_cmbAreaPlaneados":
                principalMetodos.panelPlaneadosClientes(winPrincipal);
                break;
            case "_cmbClientePlaneados":
                principalMetodos.panelPlaneadosNoPartes(winPrincipal);
                break;
            case "_cmbNoPartePlaneados":
                winPrincipal.getCmbHora().setSelectedIndex(0);
                winPrincipal.getCmbHora().setEnabled(true);
                break;
            //***** Panel Tiempo de Incidencia *****
            case "_cmbHora":
                if (winPrincipal.getCmbHora().getSelectedIndex() != 0) {
                    winPrincipal.getTxtTiempoInicio().setEnabled(true);
                }
                break;
            case "_btnAgregarBitacora":
                principalMetodos.agregarRegistroBitacora(winPrincipal);
                break;
            case "_btnRevisarHoras":
                principalMetodos.revisarTiemposFaltentes(winPrincipal, 1);
                break;
            case "_btnGuardar":
                switch (winPrincipal.getBtnGuardar().getText()) {
                    case "Guardar Bitacora":
                        principalMetodos.guardarRegistroAccess(winPrincipal);
                        break;
                    case "Actualizar Bitacora":
                        principalMetodos.actualizarRegistroFechaAccess(winPrincipal);
                        break;
                }
                break;
                
            case "_btnCancelar":
                principalMetodos.cancelarEdicion(winPrincipal);
                break;
                
            case "_mniOperaciones"://ARELI
                linea = winPrincipal.getCmbLinea().getSelectedItem().toString();
                System.err.println("linea Prin: "+linea);
                Operaciones op = new Operaciones(winOperaciones, true);
                op.setVisible(true);
                break;
        }
        if (evt.getSource().equals(winPrincipal.getDteFecha()))
            principalMetodos.consultarBitacoraPorDia(winPrincipal);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        PrincipalValidaciones.validarKeyTyped(winPrincipal, ke);
    }

    @Override
    public void keyPressed(KeyEvent ke) {}

    @Override
    public void keyReleased(KeyEvent ke) {
        PrincipalValidaciones.validarKeyReleased(winPrincipal, ke);
    }

    @Override
    public void caretUpdate(CaretEvent e) {
        PrincipalValidaciones.validarCaretUpdate(winPrincipal, e);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        PrincipalValidaciones.validarItemStateChanged(winPrincipal, e);
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        PrincipalValidaciones.validarTableModelListener(winPrincipal, e);
    }
}
