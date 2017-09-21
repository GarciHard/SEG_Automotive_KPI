package utils;

import control.LoginControl;
import control.PrincipalControl;
import dao.BitacoraDAOImpl;
import dao.CalidadDAOImpl;
import dao.LineasDAOImpl;
import dao.OrganizacionalesDAOImpl;
import dao.PiezasProducidasDAOImpl;
import dao.TiempoTurnoDAOImpl;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFPivotTable;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import vista.Login;
import vista.Principal;
import vista.SelecTurno;
import vista.TiemposFaltantes;

/**
 * Hecho con <3 por:
 * @author GarciHard
 * @boschUsr GJA5TL
 */
public class PrincipalMetodos {

    private ArrayList tiempoHora;
    private DefaultComboBoxModel listaArea;
    private DefaultComboBoxModel listaAreaC;
    private DefaultComboBoxModel listaCliente;
    private DefaultComboBoxModel listaLinea;
    private DefaultComboBoxModel listaNoParte;
    private DefaultComboBoxModel listaOperacion;
    private DefaultComboBoxModel listaProblema;
    private DefaultComboBoxModel listaProblemaC;
    private DefaultTableModel modeloTabla;
    private int contadorFila = 0;
    private JFrame form;
    private List tablaObj = new ArrayList();
    private Object[] registroBitacora = new Object[17];
    private Object[] registroBitacoraAux;
    private Object[] registroBitacoraTmp;
    private Object[] registroBitacoraTmpAux;
    private Object[] tiempos;

    private DefaultTableModel bitacoraModeloCero,
            tablaHorasCero = new DefaultTableModel();

    public DefaultComboBoxModel listaLineas() {
        try {
            listaLinea = new LineasDAOImpl().listaLineas();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(form, "PrincipalMetodos.listaLineas()\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        }

        return listaLinea;
    }

    private DefaultComboBoxModel listaClientes(String linea) {
        try {
            listaCliente = new PiezasProducidasDAOImpl().listaClientes(linea);
            if (listaCliente.getSize() == 0) {
                JOptionPane.showMessageDialog(form, "PrincipalMetodos.listaClientes()\n"
                        + "No hay clientes para la linea seleccionada", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(form, "PrincipalMetodos.listaClientes()\n"
                    + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return listaCliente;
    }

    private DefaultComboBoxModel listaNoPartes(String linea, String cliente) {
        try {
            listaNoParte = new PiezasProducidasDAOImpl().listaNoParte(linea, cliente);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(form, "PrincipalMetodos.listaNoParte()\n"
                    + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return listaNoParte;
    }

    private DefaultComboBoxModel listaOperacionesCalidad(String linea) {
        try {
            listaOperacion = new CalidadDAOImpl().listaOperacionCalidad(linea);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(form, "PrincipalMetodos.listaOperacionesCalidad()\n"
                    + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return listaOperacion;
    }

    private DefaultComboBoxModel listaAreasCalidad(String linea, String tema, String operacion) {
        try {
            listaAreaC = new CalidadDAOImpl().listaAreaCalidad(linea, tema, operacion);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(form, "PrincipalMetodos.listaAreasCalidad()\n"
                    + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return listaAreaC;
    }

    private DefaultComboBoxModel listaProblemasCalidad(String linea, String tema, String operacion, String area) {
        try {
            listaProblemaC = new CalidadDAOImpl().listaProblemaCalidad(linea, tema, operacion, area);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(form, "PrincipalMetodos.listaProblemasCalidad()\n"
                    + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return listaProblemaC;
    }

    private DefaultComboBoxModel listaAreasOrganizacional(String linea, String tema) {
        try {
            listaArea = new OrganizacionalesDAOImpl().listaAreasOrganizacional(linea, tema);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(form, "PrincipalMetodos.listaAreaOrganizacional()\n"
                    + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return listaArea;
    }

    private DefaultComboBoxModel listaProblemasOrganizacional(String linea, String tema, String area) {
        try {
            listaProblema = new OrganizacionalesDAOImpl().listaProblemasOrganizacional(linea, tema, area);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(form, "PrincipalMetodos.listaProblemaOrganizacional()\n"
                    + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return listaProblema;
    }

    private void limpiarTabla(DefaultTableModel tablaBitacora) {
        for (int i = 0; i < tablaBitacora.getRowCount(); i++) {
            tablaBitacora.removeRow(i);
            i -= 1;
        }
    }

    public void panelPiezasProducidasClientes(Principal winPrincipal) {
        PrincipalValidaciones.limpiarTiemposIncidencia(winPrincipal);
        winPrincipal.getCmbClientePzasProd().setEnabled(true);
        winPrincipal.getCmbClientePzasProd().setModel(listaClientes(winPrincipal.getCmbLinea().getSelectedItem().toString()));
        winPrincipal.getPnlProduccionCollapsible().setContent(winPrincipal.getPnlPiezasProducidas());
        winPrincipal.getPnlProduccionCollapsible().repaint();
        winPrincipal.getCmbClientePzasProd().setSelectedIndex(0);
        winPrincipal.getCmbNoPartePzasProd().setEnabled(false);
    }

    public void panelPiezasProducidasNoPartes(Principal winPrincipal) {
        if (!winPrincipal.getTxtCantidadProducidaPzasProd().getText().isEmpty()) {
            winPrincipal.getTxtCantidadProducidaPzasProd().setText("");
            winPrincipal.getTxtTC().setText("");
            winPrincipal.getTxtTC().setEnabled(false);
            winPrincipal.getTxtCantidadProducidaPzasProd().setEnabled(false);
        }
        
        winPrincipal.getTxtTC().setEnabled(false);
        winPrincipal.getCmbNoPartePzasProd().setEnabled(true);
        winPrincipal.getCmbNoPartePzasProd().setModel(listaNoPartes(winPrincipal.getCmbLinea().getSelectedItem().toString(),
                winPrincipal.getCmbClientePzasProd().getSelectedItem().toString()));
    }
    
    public void panelPiezasProducidasTC(Principal winPrincipal){
        if(winPrincipal.getCmbNoPartePzasProd().getSelectedIndex() == 0 ){
            
        }
    }

    public void panelOrganizacionalesAreas(Principal winPrincipal) {
        PrincipalValidaciones.limpiarTiemposIncidencia(winPrincipal);
        winPrincipal.getCmbAreaOrganizacional().setEnabled(true);
        winPrincipal.getCmbAreaOrganizacional().setModel(listaAreasOrganizacional(winPrincipal.getCmbLinea().getSelectedItem().toString(),
                winPrincipal.getCmbTema().getSelectedItem().toString()));
        winPrincipal.getPnlProduccionCollapsible().setContent(winPrincipal.getPnlOrganizacionales());
        winPrincipal.getPnlProduccionCollapsible().repaint();
        winPrincipal.getCmbAreaOrganizacional().setSelectedIndex(0);
        winPrincipal.getCmbProblemaOrganizacional().setEnabled(false);
    }

    public void panelOrganizacionalesProblemas(Principal winPrincipal) {
        winPrincipal.getCmbProblemaOrganizacional().setEnabled(true);
        winPrincipal.getCmbProblemaOrganizacional().setModel(listaProblemasOrganizacional(
                winPrincipal.getCmbLinea().getSelectedItem().toString(),
                winPrincipal.getCmbTema().getSelectedItem().toString(),
                winPrincipal.getCmbAreaOrganizacional().getSelectedItem().toString()));
        winPrincipal.getCmbProblemaOrganizacional().setSelectedIndex(0);
        winPrincipal.getCmbClienteOrganizacional().setEnabled(false);
    }

    public void panelOrganizacionalesClientes(Principal winPrincipal) {
        if (winPrincipal.getCmbAreaOrganizacional().getSelectedIndex() == 1) {
            if (winPrincipal.getCmbProblemaOrganizacional().getSelectedIndex() >= 2 && winPrincipal.getCmbProblemaOrganizacional().getSelectedIndex() <= 5) {
                //System.out.println("entra "+winPrincipal.getCmbProblemaOrganizacional().getSelectedIndex());
                winPrincipal.getLblMatFaltante().setVisible(true);
                winPrincipal.getTxtMatFaltante().setVisible(true);
                winPrincipal.getTxtMatFaltante().setText("");
                winPrincipal.getTxtMatFaltante().setEnabled(true);
                winPrincipal.getCmbClienteOrganizacional().setSelectedIndex(0);
                winPrincipal.getCmbClienteOrganizacional().setEnabled(false);
                //winPrincipal.getCmbNoParteOrganizacional().setEnabled(false);
            } else {
                //System.out.println("e");
                winPrincipal.getLblMatFaltante().setVisible(false);
                winPrincipal.getTxtMatFaltante().setText("");
                winPrincipal.getTxtMatFaltante().setVisible(false);
                winPrincipal.getCmbClienteOrganizacional().setEnabled(true);
            }
        } else {
            //System.out.println("etn");
            winPrincipal.getLblMatFaltante().setVisible(false);
            winPrincipal.getTxtMatFaltante().setText("");
            winPrincipal.getTxtMatFaltante().setVisible(false);
            winPrincipal.getCmbClienteOrganizacional().setEnabled(true);
        }

        winPrincipal.getCmbClienteOrganizacional().setModel(listaClientes(winPrincipal.getCmbLinea().getSelectedItem().toString()));
        winPrincipal.getCmbClienteOrganizacional().setSelectedIndex(0);
        winPrincipal.getCmbNoParteOrganizacional().setEnabled(false);
    }

    public void panelOrganizacionalesNoPartes(Principal winPrincipal) {
        winPrincipal.getCmbNoParteOrganizacional().setModel(listaNoPartes(winPrincipal.getCmbLinea().getSelectedItem().toString(),
                winPrincipal.getCmbClienteOrganizacional().getSelectedItem().toString()));
        winPrincipal.getCmbNoParteOrganizacional().setSelectedIndex(0);

        if (winPrincipal.getCmbClienteOrganizacional().getSelectedIndex() != 0) {
            winPrincipal.getCmbNoParteOrganizacional().setEnabled(true);
            winPrincipal.getCmbHora().setEnabled(false);
            winPrincipal.getBtnParoPeriodo().setVisible(false);
        } else {
            winPrincipal.getCmbNoParteOrganizacional().setEnabled(false);
        }
    }

    public void panelCambiosAreas(Principal winPrincipal) {
        PrincipalValidaciones.limpiarTiemposIncidencia(winPrincipal);
        winPrincipal.getCmbAreaCambios().setEnabled(true);
        winPrincipal.getCmbAreaCambios().setModel(listaAreasOrganizacional(winPrincipal.getCmbLinea().getSelectedItem().toString(),
                winPrincipal.getCmbTema().getSelectedItem().toString()));
        winPrincipal.getPnlProduccionCollapsible().setContent(winPrincipal.getPnlCambios());
        winPrincipal.getPnlProduccionCollapsible().repaint();
        winPrincipal.getCmbAreaCambios().setSelectedIndex(0);
        winPrincipal.getCmbClienteCambios().setEnabled(false);
    }

    public void panelCambiosClientes(Principal winPrincipal) {
        winPrincipal.getCmbClienteCambios().setEnabled(true);
        winPrincipal.getCmbClienteCambios().setModel(listaClientes(winPrincipal.getCmbLinea().getSelectedItem().toString()));
        winPrincipal.getCmbClienteCambios().setSelectedIndex(0);
        winPrincipal.getCmbNoParteCambios().setEnabled(false);
    }

    public void panelCambiosNoPartes(Principal winPrincipal) {
        winPrincipal.getCmbNoParteCambios().setEnabled(true);
        winPrincipal.getCmbNoParteCambios().setModel(listaNoPartes(winPrincipal.getCmbLinea().getSelectedItem().toString(),
                winPrincipal.getCmbClienteCambios().getSelectedItem().toString()));
        winPrincipal.getCmbNoParteCambios().setSelectedIndex(0);
        winPrincipal.getCmbClienteNuevoCambios().setEnabled(false);
    }

    public void panelCambiosClienteNuevo(Principal winPrincipal) {
        winPrincipal.getCmbClienteNuevoCambios().setEnabled(true);
        winPrincipal.getCmbClienteNuevoCambios().setModel(listaClientes(winPrincipal.getCmbLinea().getSelectedItem().toString()));
        winPrincipal.getCmbClienteNuevoCambios().setSelectedIndex(0);
        winPrincipal.getCmbNoParteCambioCambios().setEnabled(false);
    }

    public void panelCambiosNoPartesCambios(Principal winPrincipal) {
        winPrincipal.getCmbNoParteCambioCambios().setEnabled(true);
        winPrincipal.getCmbNoParteCambioCambios().setModel(listaNoPartes(winPrincipal.getCmbLinea().getSelectedItem().toString(),
                winPrincipal.getCmbClienteCambios().getSelectedItem().toString()));
        winPrincipal.getCmbNoParteCambioCambios().setSelectedIndex(0);
        winPrincipal.getTxtScrapCambios().setEnabled(false);
    }

    public void panelTiempoFaltante(Principal winPrincipal) {
        if (winPrincipal.getTblBitacora().getRowCount() <= 0) {
            winPrincipal.getCmbTema().setSelectedIndex(0);
            JOptionPane.showMessageDialog(
                    winPrincipal, "No hay horas por justificar", "Mensaje",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            PrincipalValidaciones.limpiarTiemposIncidencia(winPrincipal);
            winPrincipal.getPnlProduccionCollapsible().setContent(new javax.swing.JLabel());
            winPrincipal.getPnlProduccionCollapsible().repaint();
            winPrincipal.getCmbHora().setEnabled(true);
        }
//        winPrincipal.getPnlProduccionCollapsible().setContent(winPrincipal.getPnlTiempoFaltante());
//        winPrincipal.getPnlProduccionCollapsible().repaint();
    }

    public void panelPlaneadosAreas(Principal winPrincipal) {
        PrincipalValidaciones.limpiarTiemposIncidencia(winPrincipal);
        winPrincipal.getCmbAreaPlaneados().setEnabled(true);
        winPrincipal.getCmbAreaPlaneados().setModel(listaAreasOrganizacional(winPrincipal.getCmbLinea().getSelectedItem().toString(),
                winPrincipal.getCmbTema().getSelectedItem().toString()));
        winPrincipal.getPnlProduccionCollapsible().setContent(winPrincipal.getPnlPlaneados());
        winPrincipal.getPnlProduccionCollapsible().repaint();
        winPrincipal.getCmbAreaPlaneados().setSelectedIndex(0);
        winPrincipal.getCmbClientePlaneados().setEnabled(false);
    }

    public void panelPlaneadosClientes(Principal winPrincipal) {
        winPrincipal.getCmbClientePlaneados().setEnabled(true);
        winPrincipal.getCmbClientePlaneados().setModel(listaClientes(winPrincipal.getCmbLinea().getSelectedItem().toString()));
        winPrincipal.getCmbClientePlaneados().setSelectedIndex(0);
        winPrincipal.getCmbNoPartePlaneados().setEnabled(false);
    }

    public void panelPlaneadosNoPartes(Principal winPrincipal) {
        winPrincipal.getCmbNoPartePlaneados().setEnabled(true);
        winPrincipal.getCmbNoPartePlaneados().setModel(listaNoPartes(winPrincipal.getCmbLinea().getSelectedItem().toString(),
                winPrincipal.getCmbClientePlaneados().getSelectedItem().toString()));
        winPrincipal.getCmbNoPartePlaneados().setSelectedIndex(0);
        winPrincipal.getCmbHora().setEnabled(false);
        winPrincipal.getBtnParoPeriodo().setVisible(false);
    }

    public void panelCalidadOperaciones(Principal winPrincipal) {
        PrincipalValidaciones.limpiarTiemposIncidencia(winPrincipal);
        winPrincipal.getCmbOperacionCalidad().setEnabled(true);
        winPrincipal.getCmbOperacionCalidad().setModel(listaOperacionesCalidad(winPrincipal.getCmbLinea().getSelectedItem().toString()));
        winPrincipal.getPnlProduccionCollapsible().setContent(winPrincipal.getPnlCalidad());
        winPrincipal.getPnlProduccionCollapsible().repaint();
        winPrincipal.getCmbOperacionCalidad().setSelectedIndex(0);
        winPrincipal.getCmbAreaCalidad().setEnabled(false);
    }

    public void panelCalidadAreas(Principal winPrincipal) {
        winPrincipal.getCmbAreaCalidad().setEnabled(true);
        winPrincipal.getCmbAreaCalidad().setModel(listaAreasCalidad(winPrincipal.getCmbLinea().getSelectedItem().toString(),
                winPrincipal.getCmbTema().getSelectedItem().toString(),
                winPrincipal.getCmbOperacionCalidad().getSelectedItem().toString())
        );
        winPrincipal.getCmbAreaCalidad().setSelectedIndex(0);
        winPrincipal.getCmbProblemaCalidad().setEnabled(false);
    }

    public void panelCalidadProblemas(Principal winPrincipal) {
        winPrincipal.getCmbProblemaCalidad().setEnabled(true);
        winPrincipal.getCmbProblemaCalidad().setModel(listaProblemasCalidad(
                winPrincipal.getCmbLinea().getSelectedItem().toString(),
                winPrincipal.getCmbTema().getSelectedItem().toString(),
                winPrincipal.getCmbOperacionCalidad().getSelectedItem().toString(),
                winPrincipal.getCmbAreaCalidad().getSelectedItem().toString()));
        winPrincipal.getCmbProblemaCalidad().setSelectedIndex(0);
        winPrincipal.getCmbClienteCalidad().setEnabled(false);
    }

    public void panelCalidadClientes(Principal winPrincipal) {
        winPrincipal.getCmbClienteCalidad().setEnabled(true);
        winPrincipal.getCmbClienteCalidad().setModel(listaClientes(winPrincipal.getCmbLinea().getSelectedItem().toString()));
        winPrincipal.getCmbClienteCalidad().setSelectedIndex(0);
        winPrincipal.getCmbNoParteCalidad().setEnabled(false);
    }

    public void panelCalidadNoPartes(Principal winPrincipal) {
        if (!winPrincipal.getTxtScrapCalidad().getText().isEmpty()) {
            winPrincipal.getTxtScrapCalidad().setText("");
            winPrincipal.getTxtScrapCalidad().setEnabled(false);
        }
        winPrincipal.getCmbNoParteCalidad().setEnabled(true);
        winPrincipal.getCmbNoParteCalidad().setModel(listaNoPartes(winPrincipal.getCmbLinea().getSelectedItem().toString(),
                winPrincipal.getCmbClienteCalidad().getSelectedItem().toString()));
    }

    public void panelTecnicasOperaciones(Principal winPrincipal) {
        PrincipalValidaciones.limpiarTiemposIncidencia(winPrincipal);
        winPrincipal.getCmbOperacionTecnicas().setEnabled(true);
        winPrincipal.getCmbOperacionTecnicas().setModel(listaOperacionesCalidad(winPrincipal.getCmbLinea().getSelectedItem().toString()));
        winPrincipal.getPnlProduccionCollapsible().setContent(winPrincipal.getPnlTecnicas());
        winPrincipal.getPnlProduccionCollapsible().repaint();
        winPrincipal.getCmbOperacionTecnicas().setSelectedIndex(0);
        winPrincipal.getCmbAreaTecnicas().setEnabled(false);
    }

    public void panelTecnicasAreas(Principal winPrincipal) {
        winPrincipal.getCmbAreaTecnicas().setEnabled(true);
        winPrincipal.getCmbAreaTecnicas().setModel(listaAreasCalidad(winPrincipal.getCmbLinea().getSelectedItem().toString(),
                winPrincipal.getCmbTema().getSelectedItem().toString(),
                winPrincipal.getCmbOperacionTecnicas().getSelectedItem().toString())
        );
        winPrincipal.getCmbAreaTecnicas().setSelectedIndex(0);
        winPrincipal.getCmbProblemaTecnicas().setEnabled(false);
    }

    public void panelTecnicasProblemas(Principal winPrincipal) {
        winPrincipal.getCmbProblemaTecnicas().setEnabled(true);
        winPrincipal.getCmbProblemaTecnicas().setModel(listaProblemasCalidad(
                winPrincipal.getCmbLinea().getSelectedItem().toString(),
                winPrincipal.getCmbTema().getSelectedItem().toString(),
                winPrincipal.getCmbOperacionTecnicas().getSelectedItem().toString(),
                winPrincipal.getCmbAreaTecnicas().getSelectedItem().toString()));
        winPrincipal.getCmbProblemaTecnicas().setSelectedIndex(0);
        winPrincipal.getCmbClienteTecnicas().setEnabled(false);
    }

    public void panelTecnicasClientes(Principal winPrincipal) {
        winPrincipal.getCmbClienteTecnicas().setEnabled(true);
        winPrincipal.getCmbClienteTecnicas().setModel(listaClientes(winPrincipal.getCmbLinea().getSelectedItem().toString()));
        winPrincipal.getCmbClienteTecnicas().setSelectedIndex(0);
        winPrincipal.getCmbNoParteTecnicas().setEnabled(false);
    }

    public void panelTecnicasNoPartes(Principal winPrincipal) {
        winPrincipal.getCmbNoParteTecnicas().setEnabled(true);
        winPrincipal.getCmbNoParteTecnicas().setModel(listaNoPartes(winPrincipal.getCmbLinea().getSelectedItem().toString(),
                winPrincipal.getCmbClienteTecnicas().getSelectedItem().toString()));
        winPrincipal.getCmbNoParteTecnicas().setSelectedIndex(0);
        winPrincipal.getTxtScrapTecnicas().setEnabled(false);
    }

    public void agregarRegistroBitacora(Principal winPrincipal) {
        int valorTema = winPrincipal.getCmbTema().getSelectedIndex();
        modeloTabla = (DefaultTableModel) winPrincipal.getTblBitacora().getModel();
        registroBitacora = modeloRegistroBitacora(winPrincipal, registroBitacora);
    
        if (winPrincipal.getTblBitacora().getRowCount() == 0) {
            modeloTabla.addRow(registroBitacora);
            insertarRegistroFilaAccess(winPrincipal);
//            winPrincipal.getCmbHora().setModel(actualizaComboHoras(winPrincipal));
            winPrincipal.getCmbTema().setSelectedIndex(0);
            winPrincipal.getCmbTema().setSelectedIndex(valorTema);
        } else {
            tiempoHora = new ArrayList();
            for (int c = 0; c < modeloTabla.getRowCount(); c++) {
                if (modeloTabla.getValueAt(c, 2).toString().equals(registroBitacora[2].toString())) {
                    tiempos = new Object[4];
                    tiempos[0] = modeloTabla.getValueAt(c, 2);
                    tiempos[1] = modeloTabla.getValueAt(c, 3);
                    tiempos[2] = modeloTabla.getValueAt(c, 4);
                    tiempos[3] = modeloTabla.getValueAt(c, 5);
                    tiempoHora.add(tiempos);
                }
            }
            if (!tiempoHora.isEmpty()) {
                for (int i = 0; i < tiempoHora.size(); i++) {
                    registroBitacoraTmp = (Object[]) tiempoHora.get(i);
                    registroBitacoraTmpAux = null;
                    if (tiempoHora.size() > 1 && i < tiempoHora.size() - 1) {
                        registroBitacoraTmpAux = (Object[]) tiempoHora.get(i + 1);
                    }
                    if (Integer.parseInt(registroBitacora[3].toString()) > Integer.parseInt(registroBitacoraTmp[1].toString())) {
                        if (Integer.parseInt(registroBitacora[3].toString()) < Integer.parseInt(registroBitacoraTmp[2].toString())) {
                            JOptionPane.showMessageDialog(
                                    winPrincipal, "Registro dentro de intervalo no válido",
                                    "Advertencia", JOptionPane.WARNING_MESSAGE
                            );
                            break;
                        } else if (Integer.parseInt(registroBitacora[3].toString()) > Integer.parseInt(registroBitacoraTmp[2].toString())) {
                            if (registroBitacoraTmpAux != null) {
                                if (Integer.parseInt(registroBitacora[4].toString()) < Integer.parseInt(registroBitacoraTmpAux[1].toString())) {

                                    if (winPrincipal.getCmbTema().getSelectedItem().equals("Tiempo Faltante")) {
                                        if ((Integer.parseInt(registroBitacora[5].toString()) + getValueTblBitacoraTiempoFaltante(winPrincipal)) <= 20) {
                                            modeloTabla.addRow(modeloRegistroBitacora(winPrincipal, registroBitacora));
                                            ordenarTabla(modeloTabla);
                                            insertarRegistroFilaAccess(winPrincipal);
//                                            winPrincipal.getCmbHora().setModel(actualizaComboHoras(winPrincipal));
                                            winPrincipal.getCmbTema().setSelectedIndex(0);
                                            winPrincipal.getCmbTema().setSelectedIndex(valorTema);
                                            break;
                                        } else {
                                            JOptionPane.showMessageDialog(
                                                    winPrincipal, "El tiempo faltante ingresado\nexcede el límite permitido",
                                                    "Advertencia", JOptionPane.WARNING_MESSAGE
                                            );
                                        }
                                    } else {
                                        modeloTabla.addRow(modeloRegistroBitacora(winPrincipal, registroBitacora));
                                        ordenarTabla(modeloTabla);
                                        insertarRegistroFilaAccess(winPrincipal);
//                                        winPrincipal.getCmbHora().setModel(actualizaComboHoras(winPrincipal));
                                        winPrincipal.getCmbTema().setSelectedIndex(0);
                                        winPrincipal.getCmbTema().setSelectedIndex(valorTema);
                                        break;
                                    }

                                }
                            } else {

                                if (winPrincipal.getCmbTema().getSelectedItem().equals("Tiempo Faltante")) {
                                    if ((Integer.parseInt(registroBitacora[5].toString()) + getValueTblBitacoraTiempoFaltante(winPrincipal)) <= 20) {
                                        modeloTabla.addRow(modeloRegistroBitacora(winPrincipal, registroBitacora));
                                        ordenarTabla(modeloTabla);
                                        insertarRegistroFilaAccess(winPrincipal);
//                                        winPrincipal.getCmbHora().setModel(actualizaComboHoras(winPrincipal));
                                        winPrincipal.getCmbTema().setSelectedIndex(0);
                                        winPrincipal.getCmbTema().setSelectedIndex(valorTema);
                                        break;
                                    } else {
                                        JOptionPane.showMessageDialog(
                                                winPrincipal, "El tiempo faltante ingresado\nexcede el límite permitido",
                                                "Advertencia", JOptionPane.WARNING_MESSAGE
                                        );
                                    }
                                } else {
                                    modeloTabla.addRow(modeloRegistroBitacora(winPrincipal, registroBitacora));
                                    ordenarTabla(modeloTabla);
                                    insertarRegistroFilaAccess(winPrincipal);
//                                    winPrincipal.getCmbHora().setModel(actualizaComboHoras(winPrincipal));
                                    winPrincipal.getCmbTema().setSelectedIndex(0);
                                    winPrincipal.getCmbTema().setSelectedIndex(valorTema);
                                    break;
                                }

                            }
                        }
                    } else if (Integer.parseInt(registroBitacora[4].toString()) < Integer.parseInt(registroBitacoraTmp[1].toString())) {

                        if (winPrincipal.getCmbTema().getSelectedItem().equals("Tiempo Faltante")) {
                            if ((Integer.parseInt(registroBitacora[5].toString()) + getValueTblBitacoraTiempoFaltante(winPrincipal)) <= 20) {
                                modeloTabla.addRow(modeloRegistroBitacora(winPrincipal, registroBitacora));
                                ordenarTabla(modeloTabla);
                                insertarRegistroFilaAccess(winPrincipal);
//                                winPrincipal.getCmbHora().setModel(actualizaComboHoras(winPrincipal));
                                winPrincipal.getCmbTema().setSelectedIndex(0);
                                winPrincipal.getCmbTema().setSelectedIndex(valorTema);
                                break;
                            } else {
                                JOptionPane.showMessageDialog(
                                        winPrincipal, "El tiempo faltante ingresado\nexcede el límite permitido",
                                        "Advertencia", JOptionPane.WARNING_MESSAGE
                                );
                            }
                        } else {
                            modeloTabla.addRow(modeloRegistroBitacora(winPrincipal, registroBitacora));
                            ordenarTabla(modeloTabla);
                            insertarRegistroFilaAccess(winPrincipal);
//                            winPrincipal.getCmbHora().setModel(actualizaComboHoras(winPrincipal));
                            winPrincipal.getCmbTema().setSelectedIndex(0);
                            winPrincipal.getCmbTema().setSelectedIndex(valorTema);
                            break;
                        }

                    } else {
                        JOptionPane.showMessageDialog(
                                winPrincipal, "Tiempo de registro duplicado",
                                "Advertencia", JOptionPane.WARNING_MESSAGE
                        );
                    }
                }
            } else {

                if (winPrincipal.getCmbTema().getSelectedItem().equals("Tiempo Faltante")) {
                    if ((Integer.parseInt(registroBitacora[5].toString()) + getValueTblBitacoraTiempoFaltante(winPrincipal)) <= 20) {
                        modeloTabla.addRow(modeloRegistroBitacora(winPrincipal, registroBitacora));
                        ordenarTabla(modeloTabla);
                        insertarRegistroFilaAccess(winPrincipal);
//                        winPrincipal.getCmbHora().setModel(actualizaComboHoras(winPrincipal));
                        winPrincipal.getCmbTema().setSelectedIndex(0);
                        winPrincipal.getCmbTema().setSelectedIndex(valorTema);
                    } else {
                        JOptionPane.showMessageDialog(
                                winPrincipal, "El tiempo faltante ingresado\nexcede el límite permitido",
                                "Advertencia", JOptionPane.WARNING_MESSAGE
                        );
                    }
                } else {
                    modeloTabla.addRow(modeloRegistroBitacora(winPrincipal, registroBitacora));
                    ordenarTabla(modeloTabla);
                    insertarRegistroFilaAccess(winPrincipal);
//                    winPrincipal.getCmbHora().setModel(actualizaComboHoras(winPrincipal));
                    winPrincipal.getCmbTema().setSelectedIndex(0);
                    winPrincipal.getCmbTema().setSelectedIndex(valorTema);
                }
            }
        }
    }

    private void ordenarTabla(DefaultTableModel modeloTabla) {
        for (int i = modeloTabla.getRowCount() - 1; i >= 0; i--) {
            registroBitacoraAux = new Object[17];
            for (int j = 0; j < registroBitacoraAux.length; j++) {
                registroBitacoraAux[j] = modeloTabla.getValueAt(i, j);
            }
            tablaObj.add(registroBitacoraAux);
            modeloTabla.removeRow(i);
        }
        Collections.sort(tablaObj, new OrdenaTablaTiempo());

        for (int i = 0; i < tablaObj.size(); i++) {
            modeloTabla.addRow((Object[]) tablaObj.get(i));
        }
        tablaObj.clear();
    }

    private Object[] modeloRegistroBitacora(Principal winPrincipal, Object[] reg) {
        switch (winPrincipal.getCmbTema().getSelectedItem().toString()) {
            case "Tiempo Faltante":
                reg[0] = winPrincipal.getCmbLinea().getSelectedItem();
                reg[1] = winPrincipal.getDteFecha().getText();
                reg[2] = winPrincipal.getCmbHora().getSelectedItem();
                reg[3] = winPrincipal.getTxtTiempoInicio().getText();
                reg[4] = winPrincipal.getTxtTiempoFin().getText();
                reg[5] = winPrincipal.getTxtDuracion().getText();
                reg[6] = winPrincipal.getCmbTema().getSelectedItem();
                reg[7] = "";
                reg[8] = "";
                reg[9] = "";
                reg[10] = "";
                reg[11] = "";
                reg[12] = 0;
                reg[13] = "";
                reg[14] = "";
                reg[15] = "";
                reg[16] = "";
                break;
            case "Piezas Producidas":
                reg[0] = winPrincipal.getCmbLinea().getSelectedItem();
                reg[1] = winPrincipal.getDteFecha().getText();
                reg[2] = winPrincipal.getCmbHora().getSelectedItem();
                reg[3] = winPrincipal.getTxtTiempoInicio().getText();
                reg[4] = winPrincipal.getTxtTiempoFin().getText();
                reg[5] = winPrincipal.getTxtDuracion().getText();
                reg[6] = winPrincipal.getCmbTema().getSelectedItem();
                reg[7] = winPrincipal.getCmbLinea().getSelectedItem();//cmbOperacion.getSelectedItem();
                reg[8] = "";
                reg[9] = "";
                reg[10] = winPrincipal.getCmbClientePzasProd().getSelectedItem();
                reg[11] = winPrincipal.getCmbNoPartePzasProd().getSelectedItem();
                reg[12] = winPrincipal.getTxtCantidadProducidaPzasProd().getText();
                reg[13] = "";
                reg[14] = "";
                reg[15] = "";
                reg[16] = winPrincipal.getTxtTC().getText();
                break;
            case "Calidad":
                reg[0] = winPrincipal.getCmbLinea().getSelectedItem();
                reg[1] = winPrincipal.getDteFecha().getText();
                reg[2] = winPrincipal.getCmbHora().getSelectedItem();
                reg[3] = winPrincipal.getTxtTiempoInicio().getText();
                reg[4] = winPrincipal.getTxtTiempoFin().getText();
                reg[5] = winPrincipal.getTxtDuracion().getText();
                reg[6] = winPrincipal.getCmbTema().getSelectedItem();
                reg[7] = winPrincipal.getCmbOperacionCalidad().getSelectedItem();
                reg[8] = winPrincipal.getCmbAreaCalidad().getSelectedItem();
                reg[9] = winPrincipal.getCmbProblemaCalidad().getSelectedItem();
                reg[10] = winPrincipal.getCmbClienteCalidad().getSelectedItem();
                reg[11] = winPrincipal.getCmbNoParteCalidad().getSelectedItem();
                reg[12] = "";//winPrincipal.getTxtCantidadProducidaCalidad().getText();
                reg[13] = "";
                reg[14] = winPrincipal.getTxtScrapCalidad().getText();
                reg[15] = "";
                reg[16] = "";
                break;
            case "Tecnicas":
                reg[0] = winPrincipal.getCmbLinea().getSelectedItem();
                reg[1] = winPrincipal.getDteFecha().getText();
                reg[2] = winPrincipal.getCmbHora().getSelectedItem();
                reg[3] = winPrincipal.getTxtTiempoInicio().getText();
                reg[4] = winPrincipal.getTxtTiempoFin().getText();
                reg[5] = winPrincipal.getTxtDuracion().getText();
                reg[6] = winPrincipal.getCmbTema().getSelectedItem();//
                reg[7] = winPrincipal.getCmbOperacionTecnicas().getSelectedItem();
                reg[8] = winPrincipal.getCmbAreaTecnicas().getSelectedItem();
                reg[9] = winPrincipal.getCmbProblemaTecnicas().getSelectedItem();
                reg[10] = winPrincipal.getCmbClienteTecnicas().getSelectedItem();
                reg[11] = winPrincipal.getCmbNoParteTecnicas().getSelectedItem();
                reg[12] = 0;
                reg[13] = "";
                reg[14] = winPrincipal.getTxtScrapTecnicas().getText();
                reg[15] = "";
                reg[16] = "";
                break;
            case "Organizacionales":
                reg[0] = winPrincipal.getCmbLinea().getSelectedItem();
                reg[1] = winPrincipal.getDteFecha().getText();
                reg[2] = winPrincipal.getCmbHora().getSelectedItem();
                reg[3] = winPrincipal.getTxtTiempoInicio().getText();
                reg[4] = winPrincipal.getTxtTiempoFin().getText();
                reg[5] = winPrincipal.getTxtDuracion().getText();
                reg[6] = winPrincipal.getCmbTema().getSelectedItem();//
                reg[7] = winPrincipal.getCmbLinea().getSelectedItem();
                reg[8] = winPrincipal.getCmbAreaOrganizacional().getSelectedItem();
                reg[9] = winPrincipal.getCmbProblemaOrganizacional().getSelectedItem();
                reg[10] = winPrincipal.getCmbClienteOrganizacional().getSelectedItem();
                reg[11] = winPrincipal.getCmbNoParteOrganizacional().getSelectedItem();
                reg[12] = 0;
                reg[13] = "";
                reg[14] = "";
                reg[15] = winPrincipal.getTxtMatFaltante().getText();
                reg[16] = "";
                break;
            case "Cambio":
                reg[0] = winPrincipal.getCmbLinea().getSelectedItem();
                reg[1] = winPrincipal.getDteFecha().getText();
                reg[2] = winPrincipal.getCmbHora().getSelectedItem();
                reg[3] = winPrincipal.getTxtTiempoInicio().getText();
                reg[4] = winPrincipal.getTxtTiempoFin().getText();
                reg[5] = winPrincipal.getTxtDuracion().getText();
                reg[6] = winPrincipal.getCmbTema().getSelectedItem();//
                reg[7] = winPrincipal.getCmbLinea().getSelectedItem();
                reg[8] = winPrincipal.getCmbAreaCambios().getSelectedItem();
                reg[9] = "";//winPrincipal.getCmbProblemaCambios().getSelectedItem();
                reg[10] = winPrincipal.getCmbClienteCambios().getSelectedItem();
                reg[11] = winPrincipal.getCmbNoParteCambios().getSelectedItem();
                reg[12] = 0;
                reg[13] = winPrincipal.getCmbNoParteCambioCambios().getSelectedItem();
                reg[14] = winPrincipal.getTxtScrapCambios().getText();
                reg[15] = "";
                reg[16] = "";
                break;
            case "Planeados":
                reg[0] = winPrincipal.getCmbLinea().getSelectedItem();
                reg[1] = winPrincipal.getDteFecha().getText();
                reg[2] = winPrincipal.getCmbHora().getSelectedItem();
                reg[3] = winPrincipal.getTxtTiempoInicio().getText();
                reg[4] = winPrincipal.getTxtTiempoFin().getText();
                reg[5] = winPrincipal.getTxtDuracion().getText();
                reg[6] = winPrincipal.getCmbTema().getSelectedItem();//
                reg[7] = winPrincipal.getCmbLinea().getSelectedItem();
                reg[8] = winPrincipal.getCmbAreaPlaneados().getSelectedItem();
                reg[9] = "";
                reg[10] = winPrincipal.getCmbClientePlaneados().getSelectedItem();
                reg[11] = winPrincipal.getCmbNoPartePlaneados().getSelectedItem();
                reg[12] = 0;
                reg[13] = "";
                reg[14] = "";
                reg[15] = "";
                reg[16] = "";
                break;
        }
        return reg;
    }

    public void eliminarRegistroBitacora(Principal winPrincipal) {
        DefaultTableModel reg = (DefaultTableModel) winPrincipal.getTblBitacora().getModel();
        int posicionFila = winPrincipal.getTblBitacora().getSelectedRow();
        if (posicionFila >= 0) {
            try {

                int columnas = winPrincipal.getTblBitacora().getColumnCount();
                ArrayList obj = new ArrayList();
                for (int j = 0; j < columnas; j++) {
                    obj.add(winPrincipal.getTblBitacora().getValueAt(posicionFila, j));
                }
                new BitacoraDAOImpl().borrarFilaRegistro(obj);
                reg.removeRow(winPrincipal.getTblBitacora().getSelectedRow());
                contadorFila--;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(winPrincipal, "PrincipalMetodos.eliminarRegistroBitacora()\n" + e,
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(winPrincipal, "Selecciona registro", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void revisarTiemposFaltantes(Principal winPrincipal, int opcion) {
        switch (opcion) {
            case 1:
                DefaultTableModel bitacoraModelo,
                 tablaHoras = new DefaultTableModel();
                tablaHoras.addColumn("Hora");
                tablaHoras.addColumn("Tiempo Faltante");
                Object[] r = new Object[2];
                bitacoraModelo = (DefaultTableModel) winPrincipal.getTblBitacora().getModel();
                DefaultComboBoxModel horasModelo = (DefaultComboBoxModel) winPrincipal.getCmbHora().getModel();
                int hora,
                 sum,
                 faltante;
                for (int i = 1; i < winPrincipal.getCmbHora().getItemCount(); i++) {
                    hora = Integer.parseInt(winPrincipal.getCmbHora().getItemAt(i).toString());
                    r[0] = hora;
                    r[1] = 60;
                    tablaHoras.addRow(r);
                }
                for (int i = 1; i < horasModelo.getSize(); i++) {
                    hora = Integer.parseInt(winPrincipal.getCmbHora().getItemAt(i).toString());
                    sum = 0;
                    for (int c = 0; c < bitacoraModelo.getRowCount(); c++) {
                        if (Integer.parseInt(bitacoraModelo.getValueAt(c, 2).toString()) == hora) {
                            sum += Integer.parseInt(bitacoraModelo.getValueAt(c, 5).toString());
                            faltante = 60 - sum;
                            tablaHoras.setValueAt(faltante, i - 1, 1);
                        }
                    }

                }
                TiemposFaltantes tiemposFaltantes = new TiemposFaltantes(winPrincipal, true);
                tiemposFaltantes.getTblTiemposFaltantes().setModel(tablaHoras);
                tiemposFaltantes.setVisible(true);
                break;
            case 2:
                bitacoraModeloCero = new DefaultTableModel();
                tablaHorasCero = new DefaultTableModel();
                tablaHorasCero.addColumn("Hora");
                tablaHorasCero.addColumn("Tiempo Faltante");
                Object[] e = new Object[2];
                bitacoraModeloCero = (DefaultTableModel) winPrincipal.getTblBitacora().getModel();
                DefaultComboBoxModel horasModeloCero = (DefaultComboBoxModel) winPrincipal.getCmbHora().getModel();
                int horaCero,
                 sumCero,
                 faltanteCero;
                for (int i = 1; i < winPrincipal.getCmbHora().getItemCount(); i++) {
                    horaCero = Integer.parseInt(winPrincipal.getCmbHora().getItemAt(i).toString());
                    e[0] = horaCero;
                    e[1] = 60;
                    tablaHorasCero.addRow(e);
                }
                for (int i = 1; i < horasModeloCero.getSize(); i++) {
                    horaCero = Integer.parseInt(winPrincipal.getCmbHora().getItemAt(i).toString());
                    sumCero = 0;
                    for (int c = 0; c < bitacoraModeloCero.getRowCount(); c++) {
                        if (Integer.parseInt(bitacoraModeloCero.getValueAt(c, 2).toString()) == horaCero) {
                            sumCero += Integer.parseInt(bitacoraModeloCero.getValueAt(c, 5).toString());
                            faltanteCero = 60 - sumCero;
                            tablaHorasCero.setValueAt(faltanteCero, i - 1, 1);
                        }
                    }
                }
                break;
        }
    }

     public void guardarRegistroAccess(Principal winPrincipal) {
        PrincipalControl.auxiliarPrincipal = 2;
        new LoginControl(new Login(winPrincipal, true));
        switch (LoginControl.auxiliarLogin) {
            case 1:
                try {
                    revisarTiemposFaltantes(winPrincipal, 2);
                    int tiempoFaltante = 0;
                    for (int i = 0; i < tablaHorasCero.getRowCount(); i++) {
                        if (Integer.parseInt(tablaHorasCero.getValueAt(i, 1).toString()) != 0) {
                            tiempoFaltante += Integer.parseInt(
                                    tablaHorasCero.getValueAt(i, 1).toString()
                            );
                        }
                    }
                    if (tiempoFaltante == 0) {
                        new PrincipalMetodos().eliminarRegistroTiempo(winPrincipal);
                        int columnas = winPrincipal.getTblBitacora().getColumnCount();
                        ArrayList reg;
                        for (int i = 0; i < winPrincipal.getTblBitacora().getRowCount(); i++) {
                            reg = new ArrayList();
                            for (int j = 0; j < columnas; j++) {
                                reg.add(winPrincipal.getTblBitacora().getValueAt(i, j));
                            }
                            new BitacoraDAOImpl().insertarRegistroAccess(reg);
                        }
                        limpiarTabla((DefaultTableModel) winPrincipal.getTblBitacora().getModel());
                        winPrincipal.getCmbTema().setSelectedIndex(0);
                        PrincipalControl.insercionesAccess++;
                        JOptionPane.showMessageDialog(winPrincipal, "Bitacora Guardada Correctamente",
                                "Guardar", JOptionPane.INFORMATION_MESSAGE);
                    } else if (tiempoFaltante < 0 || tiempoFaltante > 0) {
                        JOptionPane.showMessageDialog(winPrincipal, "Verifique que el total de sus horas de trabajo sean CERO"
                                + "\nTiempo faltante: " + getValueTblTiempoFaltante(winPrincipal) + " minutos",
                                "Advertencia", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (Exception e) {
                    guardaTemporalTXT(winPrincipal);
                    JOptionPane.showMessageDialog(winPrincipal, "PrincipalMetodos.guardarRegistroAccess()\n"
                            + "Ocurrio un error : " + e, "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
        }
    }

    public void editarBitacoraPorDia(Principal winPrincipal) {
        if (winPrincipal.getCmbLinea().getSelectedIndex() != 0) {
            winPrincipal.getDteFecha().setEnabled(true);
            winPrincipal.getBtnCancelar().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(winPrincipal, "PrincipalMetodos.editarBitacoraPorDia()\n Debe seleccionar una linea",
                    "Mensaje", JOptionPane.INFORMATION_MESSAGE
            );
        }
    }
    
    public void consultarBitacoraPorDia(Principal winPrincipal) {   
        String fecha = PrincipalControl.fecha;
        String linea = PrincipalControl.linea;
        
        if (winPrincipal.getTblBitacora().getRowCount() != 0) {
            switch (JOptionPane.showConfirmDialog(winPrincipal, "En caso de tener registros sin guardar, estos se perderán.\n¿Seguro que desea continuar?", "Mensaje",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
                case 0:
                    limpiarTabla((DefaultTableModel) winPrincipal.getTblBitacora().getModel());

                    winPrincipal.getDteFecha().setEnabled(false);
                    winPrincipal.getBtnGuardar().setText("Actualizar Bitacora");
                    Object[] bitacoraObj;
                    try {                        
                        ArrayList bitacoraArr = new BitacoraDAOImpl().listarBitacorasPorFecha(fecha,linea);
                        //ArrayList bitacoraArr = new BitacoraDAOImpl().listarBitacoras(winPrincipal.getDteFecha().getText(),
                          //      winPrincipal.getCmbLinea().getSelectedItem().toString());
                        if (!bitacoraArr.isEmpty()) {
                            modeloTabla = (DefaultTableModel) winPrincipal.getTblBitacora().getModel();
                            for (int i = 0; i < bitacoraArr.size(); i++) {
                                bitacoraObj = (Object[]) bitacoraArr.get(i);
                                modeloTabla.addRow(bitacoraObj);
                            }
                        }
                    } catch (Exception e) {
                        guardaTemporalTXT(winPrincipal);
                        JOptionPane.showMessageDialog(winPrincipal, "PrincipalMetodos.consultarBitacoraPorDia()\n" + e,
                                "Error", JOptionPane.ERROR_MESSAGE
                        );
                    }
                    break;
                case 1:
                    cancelarEdicion(winPrincipal);
                    break;
            }
        } else {
            winPrincipal.getDteFecha().setEnabled(false);
            winPrincipal.getBtnGuardar().setText("Actualizar Bitacora");
            Object[] bitacoraObj;
            try {
                ArrayList bitacoraArr = new BitacoraDAOImpl().listarBitacorasPorFecha(fecha,linea);
                //ArrayList bitacoraArr = new BitacoraDAOImpl().listarBitacoras(winPrincipal.getDteFecha().getText(),
                        //winPrincipal.getCmbLinea().getSelectedItem().toString());
                if (!bitacoraArr.isEmpty()) {
                    modeloTabla = (DefaultTableModel) winPrincipal.getTblBitacora().getModel();
                    for (int i = 0; i < bitacoraArr.size(); i++) {
                        bitacoraObj = (Object[]) bitacoraArr.get(i);
                        modeloTabla.addRow(bitacoraObj);
                    }
                } else {
                    JOptionPane.showMessageDialog(
                            winPrincipal, "Bitácora no asignada para el día seleccionado\n"
                            + "Favor de seleccionar un turno & realizar los registros pendientes",
                            "Mensaje", JOptionPane.INFORMATION_MESSAGE
                    );
                }
            } catch (Exception e) {
                guardaTemporalTXT(winPrincipal);
                JOptionPane.showMessageDialog(winPrincipal, "PrincipalMetodos.consultarBitacoraPorDia()\n" + e,
                        "Error", JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    public void consultarBitacoraPorTurno(Principal winPrincipal) {
        int inicio = SelecTurno.inicioTurno;
        int fin = SelecTurno.finTurno;
        String fecha = SelecTurno.fecha;
        String linea = SelecTurno.seleccionTurnoLinea;
        if (winPrincipal.getTblBitacora().getRowCount() != 0) {
            switch (JOptionPane.showConfirmDialog(winPrincipal, "En caso de tener registros sin guardar, estos se perderán.\n¿Seguro que desea continuar?", "Mensaje",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
                case 0:
                    limpiarTabla((DefaultTableModel) winPrincipal.getTblBitacora().getModel());

                    winPrincipal.getDteFecha().setEnabled(false);
                    winPrincipal.getBtnGuardar().setText("Actualizar Bitacora");
                    Object[] bitacoraObj;
                    try {
                        ArrayList bitacoraArr = new BitacoraDAOImpl().listarBitacorasTurno(fecha,linea,inicio,fin);
                        //ArrayList bitacoraArr = new BitacoraDAOImpl().listarBitacoras(winPrincipal.getDteFecha().getText(),
                          //      winPrincipal.getCmbLinea().getSelectedItem().toString());
                        if (!bitacoraArr.isEmpty()) {
                            modeloTabla = (DefaultTableModel) winPrincipal.getTblBitacora().getModel();
                            for (int i = 0; i < bitacoraArr.size(); i++) {
                                bitacoraObj = (Object[]) bitacoraArr.get(i);
                                modeloTabla.addRow(bitacoraObj);
                            }
                        }
                    } catch (Exception e) {
                        guardaTemporalTXT(winPrincipal);
                        JOptionPane.showMessageDialog(winPrincipal, "PrincipalMetodos.consultarBitacoraPorDia()\n" + e,
                                "Error", JOptionPane.ERROR_MESSAGE
                        );
                    }
                    break;
                case 1:
                    cancelarEdicion(winPrincipal);
                    break;
            }
        } else {
            winPrincipal.getDteFecha().setEnabled(false);
            winPrincipal.getBtnGuardar().setText("Actualizar Bitacora");
            Object[] bitacoraObj;
            try {
                ArrayList bitacoraArr = new BitacoraDAOImpl().listarBitacorasTurno(fecha,linea,inicio,fin);
                //ArrayList bitacoraArr = new BitacoraDAOImpl().listarBitacoras(winPrincipal.getDteFecha().getText(),
                        //winPrincipal.getCmbLinea().getSelectedItem().toString());
                if (!bitacoraArr.isEmpty()) {
                    modeloTabla = (DefaultTableModel) winPrincipal.getTblBitacora().getModel();
                    for (int i = 0; i < bitacoraArr.size(); i++) {
                        bitacoraObj = (Object[]) bitacoraArr.get(i);
                        modeloTabla.addRow(bitacoraObj);
                    }
                }
            } catch (Exception e) {
                guardaTemporalTXT(winPrincipal);
                JOptionPane.showMessageDialog(winPrincipal, "PrincipalMetodos.consultarBitacoraPorDia()\n" + e,
                        "Error", JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    public void cancelarEdicion(Principal winPrincipal) {
        winPrincipal.getDteFecha().setEnabled(false);
        winPrincipal.getDteFecha().setDate(new java.util.Date(System.currentTimeMillis()));
        limpiarTabla((DefaultTableModel) winPrincipal.getTblBitacora().getModel());
        winPrincipal.getBtnGuardar().setText("Guardar Bitacora");
        winPrincipal.getBtnGuardar().setVisible(false);
        winPrincipal.getBtnCancelar().setVisible(false);
    }

    public void actualizarRegistroFechaAccess(Principal winPrincipal) {
        try {
            eliminarRegistroTiempo(winPrincipal);
            if (winPrincipal.getTblBitacora().getModel().getRowCount() != 0) {
                ArrayList reg;
                for (int i = 0; i < winPrincipal.getTblBitacora().getRowCount(); i++) {
                    reg = new ArrayList();
                    for (int j = 0; j < winPrincipal.getTblBitacora().getColumnCount(); j++) {
                        Object ob = winPrincipal.getTblBitacora().getValueAt(i, j);
                        if (ob == null || ob.toString().isEmpty()) {
                            winPrincipal.getTblBitacora().setValueAt("", i, j);
                            reg.add(winPrincipal.getTblBitacora().getValueAt(i, j));
                        } else {
                            reg.add(winPrincipal.getTblBitacora().getValueAt(i, j));
                        }
                        System.out.println(j + " . " + reg);
                    }
                    new BitacoraDAOImpl().insertarRegistroAccess(reg);
                }
                cancelarEdicion(winPrincipal);
                PrincipalControl.insercionesAccess = 1;
                JOptionPane.showMessageDialog(winPrincipal, "Bitacora Actualizada Correctamente",
                        "Actualizar", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(winPrincipal, "PrincipalMetodos.actualizarRegistroFechaAccess()\nLa bitacora no puede estar vacia",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            guardaTemporalTXT(winPrincipal);
            JOptionPane.showMessageDialog(winPrincipal, "PrincipalMetodos.actualizarRegistroFechaAccess()\n" + e,
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminarTurnoVacio(Principal winPrincipal) throws Exception {
        try {
            String turno = "";
            for (int i = 1; i != 0; i++) {
                if (!(winPrincipal.getLblTurno().getText().charAt(i - 1) == ' '
                        && winPrincipal.getLblTurno().getText().charAt(i) == '<')) {
                    turno += winPrincipal.getLblTurno().getText().charAt(i - 1);
                } else {
                    break;
                }
            }
            new TiempoTurnoDAOImpl().eliminarTurnoVacio(
                    winPrincipal.getCmbLinea().getSelectedItem().toString(),
                    winPrincipal.getDteFecha().getText(),
                    turno
            );
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarRegistroTiempo(Principal winPrincipal) throws Exception {
        winPrincipal.getCmbHora().setSelectedIndex(1);
        int horaInicial = Integer.parseInt(winPrincipal.getCmbHora().getSelectedItem().toString());
        int finalAux = winPrincipal.getCmbHora().getItemCount();
        winPrincipal.getCmbHora().setSelectedIndex(finalAux - 1);
        int horaFinal = Integer.parseInt(winPrincipal.getCmbHora().getSelectedItem().toString());
        winPrincipal.getCmbHora().setSelectedIndex(0);
        try {
            new BitacoraDAOImpl().borrarRegistroTiempo(
                    horaInicial,
                    horaFinal,
                    winPrincipal.getCmbLinea().getSelectedItem().toString(),
                    winPrincipal.getDteFecha().getText()
            );
        } catch (Exception e) {
            throw e;
        }
    }

    private void insertarRegistroFilaAccess(Principal winPrincipal) {
        try {
            if (PrincipalControl.bnEdicion == 2) {
                //contadorFila = winPrincipal.getTblBitacora().getRowCount() - 1;
                ArrayList reg;
                eliminarRegistroTiempo(winPrincipal);
                for (int i = 0; i < winPrincipal.getTblBitacora().getRowCount(); i++) {
                    reg = new ArrayList();
                    for (int j = 0; j < winPrincipal.getTblBitacora().getColumnCount(); j++) {
                        Object ob = winPrincipal.getTblBitacora().getValueAt(i, j);
                        if (ob == null || ob.toString().isEmpty()) {
                            winPrincipal.getTblBitacora().setValueAt("", i, j);
                            reg.add(winPrincipal.getTblBitacora().getValueAt(i, j));
                        } else {
                            reg.add(winPrincipal.getTblBitacora().getValueAt(i, j));
                        }
                        System.out.println(j + " . " + reg);
                    }
                    new BitacoraDAOImpl().insertarFilaRegistro(reg);
                }
            } else {
                int columnas = winPrincipal.getTblBitacora().getColumnCount();
                ArrayList reg = new ArrayList();
                for (int j = 0; j < columnas; j++) {
                    reg.add(winPrincipal.getTblBitacora().getValueAt(contadorFila, j));
                    System.out.println(j + " . " + reg);
                }
                new BitacoraDAOImpl().insertarFilaRegistro(reg);
                contadorFila++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(winPrincipal, "PrincipalMetodos.insertarRegistroFilaAccess()\n" + e,
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void guardaTemporalTXT(Principal winPrincipal) {
        try {
            String sucursalesCSVFile = "tmp/" + winPrincipal.getCmbLinea().getSelectedItem() + ".txt";
            BufferedWriter bfw = new BufferedWriter(new FileWriter(sucursalesCSVFile));

            for (int i = 0; i < modeloTabla.getRowCount(); i++) {
                for (int j = 0; j < modeloTabla.getColumnCount(); j++) {
                    bfw.write((String) (modeloTabla.getValueAt(i, j)));
                    if (j < modeloTabla.getColumnCount() - 1) {
                        bfw.write(",");
                    }
                }
                bfw.newLine();
            }
            bfw.close();
            JOptionPane.showMessageDialog(null, "Archivo salvador salio al recate");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El archivo salvador no pudo asistir");
        }
    }

    private int getValueTblTiempoFaltante(Principal winPrincipal) {
        revisarTiemposFaltantes(winPrincipal, 2);
        int tiempoFaltante = 0;
        for (int b = 0; b < tablaHorasCero.getRowCount(); b++) {
            if (Integer.parseInt(tablaHorasCero.getValueAt(b, 1).toString()) != 0) {
                tiempoFaltante += Integer.parseInt(
                        tablaHorasCero.getValueAt(b, 1).toString()
                );
            }
        }
        return tiempoFaltante;
    }

    private int getValueTblBitacoraTiempoFaltante(Principal winPrincipal) {
        int tiempoFaltante = 0;
        for (int a = 0; a < winPrincipal.getTblBitacora().getRowCount(); a++) {
            if (winPrincipal.getTblBitacora().getValueAt(a, 6).equals("Tiempo Faltante")) {
                tiempoFaltante += Integer.parseInt(
                        winPrincipal.getTblBitacora().getValueAt(a, 5).toString()
                );
            }
        }
        return tiempoFaltante;
    }
    
    private DefaultComboBoxModel actualizaComboHoras(Principal winPrincipal) {
        revisarTiemposFaltantes(winPrincipal, 2);
        ArrayList listaHorasActualizada = new ArrayList();
        listaHorasActualizada.add("Selecciona Hora");
        for (int i = 0; i < tablaHorasCero.getRowCount(); i++) {
            if (Integer.parseInt(tablaHorasCero.getValueAt(i, 1).toString()) != 0) {
                listaHorasActualizada.add(tablaHorasCero.getValueAt(i, 0).toString());
            }
        }
        return new DefaultComboBoxModel(listaHorasActualizada.toArray());
    }
    
    public void hourlyCounGraph(Principal winPrincipal) {
        
        String EXCEL_LOCATION = "C:\\Users\\GJA5TL\\Desktop\\Hourly_Count_12hr_Shifts_v1.0.xlsx";
        try {
            FileInputStream file = new FileInputStream(new File(EXCEL_LOCATION));
            XSSFWorkbook workbook = new XSSFWorkbook (file);
            XSSFSheet sheet = workbook.getSheetAt(1);
            XSSFPivotTable pivot = sheet.getPivotTables().get(0);
            pivot.addReportFilter(1);
            pivot.addRowLabel(1);
            file.close();
            
            FileOutputStream outFile = new FileOutputStream(new File(EXCEL_LOCATION));
            workbook.write(outFile);
            outFile.close();
            Process p = Runtime.getRuntime().exec ("C:\\Program Files (x86)\\Microsoft Office\\Office16\\EXCEL.EXE " + EXCEL_LOCATION);
        } catch (Exception e) {
            System.out.println("<<< " + e);
        }
        
        /*ESTE DE ABAJO ES EL BUENO*/
//        String EXCEL_LOCATION = "C:\\Users\\GJA5TL\\Desktop\\Hourly_Count_12hr_Shifts_v1.0.xlsx";
//        
//        try {
//            FileInputStream file = new FileInputStream(new File(EXCEL_LOCATION));
//            XSSFWorkbook workbook = new XSSFWorkbook (file);
//            XSSFSheet sheet = workbook.getSheetAt(1);
//            Cell cell = null;
//
//            Actualizamos valor de la celda
//            cell = sheet.getRow(2).getCell(5);
//            cell.setCellValue("LINEA: " + winPrincipal.getCmbLinea().getSelectedItem().toString());
//            
//            cell = sheet.getRow(1).getCell(43);
//            cell.setCellValue(25);
//            
//            cell = sheet.getRow(2).getCell(43);
//            DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
//            Date startDate = (Date)formatter.parse(winPrincipal.getDteFecha().getText()); 
//            cell.setCellValue(winPrincipal.getDteFecha().getText());
//            
//            file.close();
//                                    
//            FileOutputStream outFile = new FileOutputStream(new File(EXCEL_LOCATION));
//            workbook.write(outFile);
//            outFile.close();
//
//            Process p = Runtime.getRuntime().exec ("C:\\Program Files (x86)\\Microsoft Office\\Office16\\EXCEL.EXE " + EXCEL_LOCATION);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        /*TODO ESTO DE ABAJO YA NO*/
//        try {
//            Workbook workbookO = Workbook.getWorkbook(new java.io.File(EXCEL_LOCATION));
//            workbookC = Workbook.createWorkbook(new java.io.File(EXCEL_TEMP), workbookO);
//            
//            jxl.write.WritableSheet sheet = workbookC.getSheet(1);
//            jxl.write.Label linea = new jxl.write.Label(5, 2, winPrincipal.getCmbLinea().getSelectedItem().toString());
//            sheet.addCell(linea);
//            
//            jxl.write.Label fecha = new jxl.write.Label(13, 2, winPrincipal.getDteFecha().getText());
//            sheet.addCell(fecha);
//            
//            workbookC.write();
//            workbookC.close();
//            workbookO.close();
//            Process p = Runtime.getRuntime().exec ("C:\\Program Files (x86)\\Microsoft Office\\Office16\\EXCEL.EXE C:\\Users\\GJA5TL\\Desktop\\tmp.xls"); 
//            jxl.Cell cell1 = sheet.getCell(5,2);
//            System.out.println("CELDA 5,2: " + cell1.getContents());
//        } catch (IOException | IndexOutOfBoundsException | BiffException | WriteException e) {
//            System.err.println("Error: " + e);
//        }
    }
    
    public void generarReporteProduccionActual(Principal winPrincipal) {
        try {
            ArrayList produccion = new ArrayList();
            Object[] registro;
            Object[] comparaRegistro;

            ArrayList bitacoraActual
                    = getBitacoraActual(
                            horarioTurno(winPrincipal.getCmbHora()),
                            winPrincipal
                    );

            int indicadorHora = 0;
            /**
             * Comenzamos el recorrido del array bitacoraActual el cual contiene
             * la informacion de la bitacora de acuerdo al horario del turno
             * actual
             */
            for (int i = 0; i < bitacoraActual.size(); i++) {
                //obtenemos los datos de cada registro en un array de tipo Object
                registro = (Object[]) bitacoraActual.get(i);
                //buscamos el tema del registro
                //for (int j = 0; j < registro.length; j++) {
                if (registro[6].equals("Piezas Producidas")) {
                    /**
                     * Si produccion esta vacio entonces se toma la hora del
                     * primer registro en la bitacora el cual se asigna a
                     * indicadorHora y se guardan los datos. En caso de que
                     * produccion no este vacio, se compara la hora del nuevo
                     * registro contra indicadorHora si son iguales, ahora
                     * compara el numero de parte del cliente y en caso de que
                     * sean iguales se suma la cantidad de piezas. Si los
                     * numeros de partes son diferentes, hace una busqueda en el
                     * array produccion para encontrar un numero de parte y hora
                     * igual en caso de encontrarlo, suma la cantidad de piezas
                     * y elimina el registro anterior para agregar el nuevo
                     * registro. Si indicadorHora y la hora del nuevo registro
                     * no son iguales, el valor de indicadorHora cambia por el
                     * del nuevo registro y se guardan los datos.
                     */
                    if (produccion.isEmpty()) {
                        indicadorHora = Integer.parseInt(registro[2].toString());
                        produccion.add(registro);
                    } else {
                        if (Integer.parseInt(registro[2].toString()) == indicadorHora) {
                            comparaRegistro = (Object[]) produccion.get(i - 1);
                            System.out.println("productionArrSizeGetiMinus1> " + produccion.size());
                            if (registro[11].equals(comparaRegistro[11])) {
                                produccion.remove(i - 1);
                                System.out.println("productionArrSizeMinusOne> " + produccion.size());
                                comparaRegistro[12]
                                        = Integer.parseInt(comparaRegistro[12].toString())
                                        + Integer.parseInt(registro[12].toString());
                                produccion.add(comparaRegistro);
                                System.out.println("productionArrSizePlusOne> " + produccion.size());
                            } else {
                                for (int j = 0; j < produccion.size(); j++) {
                                    comparaRegistro = (Object[]) produccion.get(j);
                                    if (comparaRegistro[11].equals(registro[11])
                                            && comparaRegistro[2].equals(registro[2])) {
                                        produccion.remove(j);
                                        registro[12]
                                                = Integer.parseInt(comparaRegistro[12].toString())
                                                + Integer.parseInt(registro[12].toString());
                                        break;
                                    }
                                }
                                produccion.add(registro);
                            }
                        } else {
                            indicadorHora = Integer.parseInt(registro[2].toString());
                            produccion.add(registro);
                        }
                    }
                    //break;
                }
                //}
            }

            if (!produccion.isEmpty()) {
                Object[] produccionReg;
                for (int i = 0; i < produccion.size(); i++) {
                    produccionReg = (Object[]) produccion.get(i);
                    for (int j = 0; j < produccionReg.length; j++) {

                        System.out.println(j + "." + produccionReg[j].toString());
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("<><><><><> " + e);
        }
    }
    
    public void generarReporteCalidadActual(Principal winPrincipal) {
        
    }
    
    private int[] horarioTurno(JComboBox cmbHora) {
        int[] horario = new int[2];
        cmbHora.setSelectedIndex(1);
        horario[0] = Integer.parseInt(cmbHora.getSelectedItem().toString());
        int finalAux = cmbHora.getItemCount();
        cmbHora.setSelectedIndex(finalAux - 1);
        horario[1] = Integer.parseInt(cmbHora.getSelectedItem().toString());
        cmbHora.setSelectedIndex(0);
        return horario;
    }

    private ArrayList getBitacoraActual(int[] horarioTurno, Principal winPrincipal) throws Exception {
        return new BitacoraDAOImpl().listarBitacorasTurno(
                winPrincipal.getDteFecha().getText(),
                winPrincipal.getCmbLinea().getSelectedItem().toString(),
                horarioTurno[0],
                horarioTurno[1]
        );
    }
}
