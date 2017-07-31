package control;

import dao.TemasDAOImpl;
import vista.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import utils.PrincipalMetodos;
import utils.PrincipalValidaciones;
import vista.Login;
import vista.RegistroUsuarios;

/**
 * Hecho con <3 por:
 * @author GarciHard
 * @boschUsr GJA5TL
 */
public class PrincipalControl implements ActionListener, CaretListener, ItemListener, KeyListener, TableModelListener {
    
    public static int auxiliarPrincipal;
    //private final Date fechaActual = new Date(System.currentTimeMillis());
    private final SimpleDateFormat fechaFormato = new SimpleDateFormat("dd/MM/yyyy");
    protected static Principal winPrincipal;
    private final PrincipalMetodos principalMetodos = new PrincipalMetodos();
    
    
    public PrincipalControl(Principal principal) {
        PrincipalControl.winPrincipal = principal;
        initFrame();
    }

    private void initFrame() {
        winPrincipal.getDteFecha().setText(fechaFormato.format(new Date(System.currentTimeMillis())));
        winPrincipal.getDteFecha().addActionListener(this);
        winPrincipal.getCmbLinea().setModel(principalMetodos.listaLineas());
        winPrincipal.getCmbLinea().addActionListener(this);
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
        
        //Panel Piezas Producias
        winPrincipal.getCmbClientePzasProd().addActionListener(this);
        winPrincipal.getCmbNoPartePzasProd().addActionListener(this);
        winPrincipal.getCmbNoPartePzasProd().addItemListener(this);
        winPrincipal.getTxtCantidadProducidaPzasProd().addCaretListener(this);
        winPrincipal.getTxtCantidadProducidaPzasProd().addKeyListener(this);
        
        //Panel Calidad
        winPrincipal.getCmbOperacionCalidad().addActionListener(this);
        winPrincipal.getCmbAreaCalidad().addActionListener(this);
        winPrincipal.getCmbProblemaCalidad().addActionListener(this);
        winPrincipal.getCmbClienteCalidad().addActionListener(this);
        winPrincipal.getCmbNoParteCalidad().addActionListener(this);
        winPrincipal.getCmbNoParteCalidad().addItemListener(this);
        winPrincipal.getTxtCantidadProducidaCalidad().addCaretListener(this);
        winPrincipal.getTxtCantidadProducidaCalidad().addKeyListener(this);
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
        
        //Panel Cambios
        winPrincipal.getCmbAreaCambios().addActionListener(this);
        winPrincipal.getCmbProblemaCambios().addActionListener(this);
        winPrincipal.getCmbClienteCambios().addActionListener(this);
        winPrincipal.getCmbNoParteCambios().addActionListener(this);
        winPrincipal.getCmbNoParteCambioCambios().addActionListener(this);
        winPrincipal.getCmbNoParteCambioCambios().addItemListener(this);
        winPrincipal.getTxtScrapCambios().addCaretListener(this);
        winPrincipal.getTxtScrapCambios().addKeyListener(this);
        
        //Panel Planeados
        winPrincipal.getCmbAreaPlaneados().addActionListener(this);
        winPrincipal.getCmbClientePlaneados().addActionListener(this);
        winPrincipal.getCmbNoPartePlaneados().addActionListener(this);
        
        //Menu Editar
        winPrincipal.getMniEditarPorDia().addActionListener(this);
        
        //MenuEliminarBitacora
        winPrincipal.getMniEliminar().addActionListener(this);
        
        //MenuCrearUsuario
        winPrincipal.getMniCrearUsuario().addActionListener(this);
        
        //Tabla Bitacora
        winPrincipal.getTblBitacora().getModel().addTableModelListener(this);
        winPrincipal.getTblBitacora().setRowHeight(35);
        
        winPrincipal.setVisible(true);
    }   
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        switch (evt.getActionCommand()) {
            //***** Barra de Menu *****
            case "_mniEditarPorDia":
                auxiliarPrincipal = 2;
                new LoginControl(new Login(winPrincipal, true));
                break;
            case "_mniEliminar":
                principalMetodos.eliminarRegistroBitacora(winPrincipal);
                break;
            case "_mniCrearUsuario":
                new CrearUsuarioControl(new RegistroUsuarios(winPrincipal, true));
                break;
            //***** Panel Superior *****
            case "_btnCambiarLinea":
                winPrincipal.getCmbTema().setEnabled(false);
                switch (winPrincipal.getBtnCambiarLinea().getText()) {
                    case "Cambiar Linea":
                        auxiliarPrincipal = 1;
                        winPrincipal.getCmbTema().setSelectedIndex(0);
                        new LoginControl(new Login(winPrincipal, true));
                        break;
                    case "Aceptar":
                        winPrincipal.getCmbLinea().setEnabled(false);
                        winPrincipal.getCmbTema().setEnabled(true);
                        winPrincipal.getBtnCambiarLinea().setText("Cambiar Linea");
                        break;
                }
                break;
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
                winPrincipal.getTxtCantidadProducidaPzasProd().setText("");
                winPrincipal.getTxtCantidadProducidaPzasProd().setEnabled(true);
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
                winPrincipal.getTxtCantidadProducidaCalidad().setText("");
                winPrincipal.getTxtCantidadProducidaCalidad().setEnabled(true);
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
                principalMetodos.panelCambiosProblemas(winPrincipal);
                break;
            case "_cmbProblemaCambios":
                principalMetodos.panelCambiosClientes(winPrincipal);
                break;
            case "_cmbClienteCambios":
                principalMetodos.panelCambiosNoPartes(winPrincipal);
                break;
            case "_cmbNoParteCambios":
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
                principalMetodos.revisarTiemposFaltentes(winPrincipal);
                break;
            case "_btnGuardar":
                principalMetodos.guardarRegistroAccess(winPrincipal);
                break;
        }
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