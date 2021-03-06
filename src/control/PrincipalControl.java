package control;

import dao.BitacoraDAOImpl;
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
import vista.CargaTargets;
import vista.Cargas;
import vista.Lineas;
import vista.Operaciones;
import vista.ParoRango;
import vista.RegistroUsuarios;
import vista.SelecTurno;
import static vista.SelecTurno.finTurno;
import static vista.SelecTurno.inicioTurno;
import static vista.SelecTurno.turno;
import vista.TiempoTurno;

/**
 * Hecho con <3 por:
 * @author GarciHard
 * @boschUsr GJA5TL
 */
public class PrincipalControl implements ActionListener, CaretListener, ItemListener, KeyListener, TableModelListener {
    
    public static int insercionesAccess = 0;
    public static String fecha;
    public static int auxiliarPrincipal;
    private final SimpleDateFormat fechaFormato = new SimpleDateFormat("dd/MM/yyyy");
    protected static Principal winPrincipal;
    private final PrincipalMetodos principalMetodos = new PrincipalMetodos();
    public static String linea;
    protected static Operaciones winOperaciones;
    public static int bnEdicion = 0;
    public static int tipoEnsambleLinea;
    
    public PrincipalControl(Principal principal) {
        PrincipalControl.winPrincipal = principal;
        initFrame();        
    }

    private void initFrame() {
        winPrincipal.getDteFecha().setDateFormat(fechaFormato);
        winPrincipal.getDteFecha().setDate(new Date(System.currentTimeMillis()));
        winPrincipal.getDteFecha().addActionListener(this);
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
        winPrincipal.getCmbFamiliaPzasProd().addActionListener(this);
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
        winPrincipal.getCmbFamiliaCalidad().addActionListener(this);
        winPrincipal.getCmbClienteCalidad().addActionListener(this);
        winPrincipal.getCmbNoParteCalidad().addActionListener(this);
        winPrincipal.getCmbNoParteCalidad().addItemListener(this);
        winPrincipal.getTxtScrapCalidad().addCaretListener(this);
        winPrincipal.getTxtScrapCalidad().addKeyListener(this);
        
        //Panel Tecnicas
        winPrincipal.getCmbOperacionTecnicas().addActionListener(this);
        winPrincipal.getCmbAreaTecnicas().addActionListener(this);
        winPrincipal.getCmbProblemaTecnicas().addActionListener(this);
        winPrincipal.getCmbClienteTecnicas().addActionListener(this);
        winPrincipal.getCmbFamiliaTecnicas().addActionListener(this);
        winPrincipal.getCmbNoParteTecnicas().addActionListener(this);
        winPrincipal.getCmbNoParteTecnicas().addItemListener(this);
        winPrincipal.getTxtScrapTecnicas().addCaretListener(this);
        winPrincipal.getTxtScrapTecnicas().addKeyListener(this);
        
        //Panel Organizacionales
        winPrincipal.getCmbAreaOrganizacional().addActionListener(this);
        winPrincipal.getCmbProblemaOrganizacional().addActionListener(this);
        winPrincipal.getCmbClienteOrganizacional().addActionListener(this);
        winPrincipal.getCmbFamiliaOrganizacional().addActionListener(this);
        winPrincipal.getCmbNoParteOrganizacional().addActionListener(this);
        winPrincipal.getTxtMatFaltante().addKeyListener(this);
        winPrincipal.getTxtMatFaltante().addCaretListener(this);
        
        //Panel Cambios
        winPrincipal.getCmbAreaCambios().addActionListener(this);
        winPrincipal.getCmbClienteCambios().addActionListener(this);
        winPrincipal.getCmbFamiliaCambios().addActionListener(this);
        winPrincipal.getCmbNoParteCambios().addActionListener(this);
        winPrincipal.getCmbNoParteCambioCambios().addActionListener(this);
        winPrincipal.getCmbClienteNuevoCambios().addActionListener(this);
        winPrincipal.getCmbFamiliaNuevaCambios().addActionListener(this);
        winPrincipal.getCmbNoParteCambioCambios().addItemListener(this);
        winPrincipal.getTxtScrapCambios().addCaretListener(this);
        winPrincipal.getTxtScrapCambios().addKeyListener(this);
        
        //Panel Planeados
        winPrincipal.getCmbAreaPlaneados().addActionListener(this);
        winPrincipal.getCmbClientePlaneados().addActionListener(this);
        winPrincipal.getCmbFamiliaPlaneados().addActionListener(this);
        winPrincipal.getCmbNoPartePlaneados().addActionListener(this);
        
        //Menu Lineas
        winPrincipal.getMniLineas().addActionListener(this);
        
        //Menu EditarBitacora
        winPrincipal.getMniListarDia().addActionListener(this);
        winPrincipal.getMniEditarPorDia().addActionListener(this);
        winPrincipal.getMniEditarPorTurno().addActionListener(this);
        
        //MenuEliminarBitacora
        winPrincipal.getMniEliminar().addActionListener(this);
        
        //MenuCrearUsuario
        winPrincipal.getMniCrearUsuario().addActionListener(this);
        
        //Menu Operaciones
        winPrincipal.getMniOperaciones().addActionListener(this);
        
        //Carga Masiva
        winPrincipal.getMniCargaMasiva().addActionListener(this);
        
        //Menu Graficas
        winPrincipal.getMniHourlyCount().addActionListener(this);
        
        //Tabla Bitacora
        winPrincipal.getTblBitacora().getModel().addTableModelListener(this);
        winPrincipal.getTblBitacora().setRowHeight(35);
                
        //Boton Paro por Rangos 
        winPrincipal.getBtnParoPeriodo().addActionListener(this);
        winPrincipal.getBtnParoPeriodo().setVisible(false);
        
        winPrincipal.setVisible(true);
        
    }   
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        switch (evt.getActionCommand()) {
            //***** Barra de Menu *****
            case "_mniCargaMasiva":
                linea = winPrincipal.getCmbLinea().getSelectedItem().toString();
                try {
                    new Cargas(winPrincipal, true).setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(PrincipalControl.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "_mniLineas":
                new Lineas(winPrincipal, true).setVisible(true);
                break;
            case "_mniListarDia":
                bnEdicion = 0;
                winPrincipal.getDteFecha().setEnabled(true);
                winPrincipal.getBtnCancelar().setVisible(true);
                break;
            case "_mniEditarPorDia":
                bnEdicion = 1;
                winPrincipal.getBtnCambiarLinea().setEnabled(true);
                winPrincipal.getDteFecha().setEnabled(true);
                winPrincipal.getBtnCancelar().setVisible(true);                
                break;
            case "_mniEditarPorTurno":
                bnEdicion = 2;
                winPrincipal.getDteFecha().setEnabled(true);
                winPrincipal.getBtnCancelar().setVisible(true);
                break;
            case "_mniEliminar":
                principalMetodos.eliminarRegistroBitacora(winPrincipal);
                break;
            case "_mniCrearUsuario":
                new RegistroUsuariosControl(new RegistroUsuarios(winPrincipal, true));
                break;
            case "_mniHourlyCount":
                principalMetodos.hourlyGeneral(winPrincipal);
                principalMetodos.generarReporteProduccionActualOEE(winPrincipal);
                break;
            //***** Panel Superior *****
            case "_btnCambiarLinea":
                new TiempoTurno(winPrincipal, true).setVisible(true);
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
                if (tipoEnsambleLinea == 3) {
                    principalMetodos.panelPiezasProducidasFamilias(winPrincipal);
                } else {
                    principalMetodos.panelPiezasProducidasNoPartes(winPrincipal);
                }
                break;
            case "_cmbFamiliaPzasProd":
                principalMetodos.panelPiezasProducidasNoPartes(winPrincipal);
                break;
            case "_cmbNoPartePzasProd":
                winPrincipal.getTxtTC().setText("");
                if(winPrincipal.getCmbNoPartePzasProd().getSelectedIndex() != 0 ){
                    winPrincipal.getTxtTC().setEnabled(true);
                }else {
                    winPrincipal.getTxtTC().setEnabled(false);
                }                
                break;
            //***** Panel Calidad *****
            case "_cmbOperacionCalidad":
                principalMetodos.panelCalidadAreas(winPrincipal);
                break;
            case "_cmbAreaCalidad":
                principalMetodos.panelCalidadProblemas(winPrincipal);
                break;
            case "_cmbProblemaCalidad":
                if (tipoEnsambleLinea == 3) {
                    principalMetodos.panelCalidadFamilias(winPrincipal);
                } else {
                    principalMetodos.panelCalidadClientes(winPrincipal);
                }
                break;
            case  "_cmbFamiliaCalidad":
                principalMetodos.panelCalidadClientes(winPrincipal);
                break;
            case "_cmbClienteCalidad":
                principalMetodos.panelCalidadNoPartes(winPrincipal);
                break;
            //***** Panel Tecnicas *****
            case "_cmbOperacionTecnicas":
                principalMetodos.panelTecnicasAreas(winPrincipal);
                break;
            case "_cmbAreaTecnicas":
                principalMetodos.panelTecnicasProblemas(winPrincipal);
                break;
            case "_cmbProblemaTecnicas":
                if (tipoEnsambleLinea == 3) {
                    principalMetodos.panelTecnicasFamilias(winPrincipal);
                } else {
                    principalMetodos.panelTecnicasClientes(winPrincipal);
                }
                break;
            case "_cmbFamiliaTecnicas":
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
                if (tipoEnsambleLinea == 3) {
                    principalMetodos.panelOrganizacionalesFamilias(winPrincipal);
                } else {
                    principalMetodos.panelOrganizacionalesClientes(winPrincipal);
                }                
                break;
            case "_cmbFamiliaOrganizacional":
                principalMetodos.panelOrganizacionalesClientes(winPrincipal);
                break;
            case "_cmbClienteOrganizacional":
                principalMetodos.panelOrganizacionalesNoPartes(winPrincipal);
                break;
            case "_cmbNoParteOrganizacional":              
                if (!winPrincipal.getTxtMatFaltante().isVisible()) {
                    winPrincipal.getCmbHora().setSelectedIndex(0);
                    winPrincipal.getCmbHora().setEnabled(true);
                } else if (winPrincipal.getCmbNoParteOrganizacional().getSelectedIndex() != 0) {
                    winPrincipal.getTxtMatFaltante().setEnabled(true);
                    winPrincipal.getTxtMatFaltante().setEditable(true);
                } else {
                    winPrincipal.getTxtMatFaltante().setEnabled(false);
                    winPrincipal.getTxtMatFaltante().setEditable(false);
                }
                break;
            //***** Panel Cambios*****
            case "_cmbAreaCambios":
                if (tipoEnsambleLinea == 3) {
                    principalMetodos.panelCambiosFamilias(winPrincipal);
                } else {
                    principalMetodos.panelCambiosClientes(winPrincipal);
                }
                break;
            case "_cmbFamiliaCambios":
                principalMetodos.panelCambiosClientes(winPrincipal);
                break;
            case "_cmbClienteCambios":
                principalMetodos.panelCambiosNoPartes(winPrincipal);
                break;
            case "_cmbNoParteCambios":
                if (tipoEnsambleLinea == 3) {
                    principalMetodos.panelCambiosFamiliaNueva(winPrincipal);
                } else {
                    principalMetodos.panelCambiosClienteNuevo(winPrincipal);
                }
                break;
            case "_cmbFamiliaNuevaCambios":
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
                if (tipoEnsambleLinea == 3) {
                    principalMetodos.panelPlaneadosFamilias(winPrincipal);
                } else {
                    principalMetodos.panelPlaneadosClientes(winPrincipal);
                }
                break;
            case "_cmbFamiliaPlaneados":
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
                    winPrincipal.getBtnParoPeriodo().setVisible(false);
                }else if (winPrincipal.getCmbTema().getSelectedIndex() != 1 &&  winPrincipal.getCmbTema().getSelectedIndex() != 5 && winPrincipal.getCmbTema().getSelectedIndex() != 7){
                    winPrincipal.getBtnParoPeriodo().setVisible(true);
                }
                break;
            case "_btnAgregarBitacora":
                principalMetodos.agregarRegistroBitacora(winPrincipal);
                break;
            case "_btnRevisarHoras":
                principalMetodos.revisarTiemposFaltantes(winPrincipal, 1);
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
                
            case "_mniOperaciones":
                linea = winPrincipal.getCmbLinea().getSelectedItem().toString();
                System.err.println("linea Prin: "+linea);
                Operaciones op = new Operaciones(winOperaciones, true);
                op.setVisible(true);
                break;
                
            case "cmbParoPeriodo":
                new ParoRango(winPrincipal, true).setVisible(true);
                break;
        }
        if (evt.getSource().equals(winPrincipal.getDteFecha())) {
            linea = winPrincipal.getCmbLinea().getSelectedItem().toString();
            fecha = winPrincipal.getDteFecha().getText();
            
            switch (bnEdicion) {
                case 0:
                    principalMetodos.consultarBitacoraPorDia(winPrincipal);
                    break;
                case 2:
                    new SelecTurno(winPrincipal, true).setVisible(true);
                    break;
                default:
                    try {
                        int registros = new BitacoraDAOImpl().edicionPorDia(fecha, linea);
                        if(registros == 0 ){
                            winPrincipal.getLblTurno().setText("  ");
                            new TiempoTurno(winPrincipal, true).setVisible(true);
                        } else {
                            winPrincipal.getLblTurno().setText("  ");
                            new SelecTurno(winPrincipal, true).setVisible(true);
                            winPrincipal.getDteFecha().setEditable(false);
                            winPrincipal.getDteFecha().setEnabled(false);
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(PrincipalControl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
            }
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
