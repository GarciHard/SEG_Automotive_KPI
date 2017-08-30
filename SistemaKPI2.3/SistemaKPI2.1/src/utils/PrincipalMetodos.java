package utils;

import control.LoginControl;
import control.PrincipalControl;
import dao.BitacoraDAOImpl;
import dao.CalidadDAOImpl;
import dao.LineasDAOImpl;
import dao.OrganizacionalesDAOImpl;
import dao.PiezasProducidasDAOImpl;
import java.awt.Dimension;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vista.Login;
import vista.Principal;
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
    private JFrame form;
    private List tablaObj = new ArrayList();
    private Object[] registroBitacora = new Object[16];
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
                JOptionPane.showMessageDialog(form, "PrincipalMetodos.listaClientes()\n" +
                        "No hay clientes para la linea seleccionada", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(form, "PrincipalMetodos.listaClientes()\n" +
                    e, "Error", JOptionPane.ERROR_MESSAGE);
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
            winPrincipal.getTxtCantidadProducidaPzasProd().setEnabled(false);
        }
        winPrincipal.getCmbNoPartePzasProd().setEnabled(true);
        winPrincipal.getCmbNoPartePzasProd().setModel(listaNoPartes(winPrincipal.getCmbLinea().getSelectedItem().toString(),
        winPrincipal.getCmbClientePzasProd().getSelectedItem().toString()));
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
        if (winPrincipal.getCmbAreaOrganizacional().getSelectedIndex() == 1 ){
            if (winPrincipal.getCmbProblemaOrganizacional().getSelectedIndex() >= 2 && winPrincipal.getCmbProblemaOrganizacional().getSelectedIndex() <=5) {
                //System.out.println("entra "+winPrincipal.getCmbProblemaOrganizacional().getSelectedIndex());
                winPrincipal.getLblMatFaltante().setVisible(true);
                winPrincipal.getTxtMatFaltante().setVisible(true);
                winPrincipal.getTxtMatFaltante().setText("");
                winPrincipal.getTxtMatFaltante().setEnabled(true);
                winPrincipal.getCmbClienteOrganizacional().setSelectedIndex(0);
                winPrincipal.getCmbClienteOrganizacional().setEnabled(false);
                //winPrincipal.getCmbNoParteOrganizacional().setEnabled(false);
            }else {
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
        
        if(winPrincipal.getCmbClienteOrganizacional().getSelectedIndex() != 0 ){
            winPrincipal.getCmbNoParteOrganizacional().setEnabled(true);
            winPrincipal.getCmbHora().setEnabled(false);
            winPrincipal.getBtnParoPeriodo().setVisible(false);
        }   else {
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
        PrincipalValidaciones.limpiarTiemposIncidencia(winPrincipal);
        winPrincipal.getPnlProduccionCollapsible().setContent(winPrincipal.getPnlTiempoFaltante());
        winPrincipal.getPnlProduccionCollapsible().repaint();
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
                            break;
                        } else if (Integer.parseInt(registroBitacora[3].toString()) > Integer.parseInt(registroBitacoraTmp[2].toString())) {
                            if (registroBitacoraTmpAux != null) {
                                if (Integer.parseInt(registroBitacora[4].toString()) < Integer.parseInt(registroBitacoraTmpAux[1].toString())) {
                                    modeloTabla.addRow(modeloRegistroBitacora(winPrincipal, registroBitacora));
                                    ordenarTabla(modeloTabla);
                                    winPrincipal.getCmbTema().setSelectedIndex(0);
                                    winPrincipal.getCmbTema().setSelectedIndex(valorTema);
                                    break;
                                }
                            } else {
                                modeloTabla.addRow(modeloRegistroBitacora(winPrincipal, registroBitacora));
                                ordenarTabla(modeloTabla);
                                winPrincipal.getCmbTema().setSelectedIndex(0);
                                winPrincipal.getCmbTema().setSelectedIndex(valorTema);
                                break;
                            }
                        }
                    } else if (Integer.parseInt(registroBitacora[4].toString()) < Integer.parseInt(registroBitacoraTmp[1].toString())) {
                        modeloTabla.addRow(modeloRegistroBitacora(winPrincipal, registroBitacora));
                        ordenarTabla(modeloTabla);
                        winPrincipal.getCmbTema().setSelectedIndex(0);
                        winPrincipal.getCmbTema().setSelectedIndex(valorTema);
                        break;
                    }
                }
            } else {
                modeloTabla.addRow(modeloRegistroBitacora(winPrincipal, registroBitacora));
                ordenarTabla(modeloTabla);
                winPrincipal.getCmbTema().setSelectedIndex(0);
                winPrincipal.getCmbTema().setSelectedIndex(valorTema);
            }
        }
    }

    private void ordenarTabla(DefaultTableModel modeloTabla) {
        for (int i = modeloTabla.getRowCount() - 1; i >= 0; i--) {
            registroBitacoraAux = new Object[15];
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
                break;
        }
        return reg;
    }

    public void eliminarRegistroBitacora(Principal winPrincipal) {
        DefaultTableModel reg = (DefaultTableModel) winPrincipal.getTblBitacora().getModel();
        if (winPrincipal.getTblBitacora().getSelectedRow() >= 0) {
            reg.removeRow(winPrincipal.getTblBitacora().getSelectedRow());
        } else {
            JOptionPane.showMessageDialog(winPrincipal, "Selecciona registro", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void revisarTiemposFaltentes(Principal winPrincipal, int opcion) {
        switch (opcion) {
            case 1:
                DefaultTableModel bitacoraModelo,
                tablaHoras = new DefaultTableModel();
                tablaHoras.addColumn("Hora");
                tablaHoras.addColumn("Tiempo Faltante");
                Object[] r = new Object[2];
                bitacoraModelo = (DefaultTableModel) winPrincipal.getTblBitacora().getModel();
                DefaultComboBoxModel horasModelo = (DefaultComboBoxModel) winPrincipal.getCmbHora().getModel();
                int hora, sum, faltante;
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
                Object[] datos;
                dao.BitacoraDAOImpl bitacoraObj = new dao.BitacoraDAOImpl();
                try {
                    if (!bitacoraObj.existeFechaBitacora(winPrincipal.getDteFecha().getText(),
                            (DefaultTableModel) winPrincipal.getTblBitacora().getModel()).isEmpty()) {
                        ArrayList h = bitacoraObj.existeFechaBitacora(winPrincipal.getDteFecha().getText(), (DefaultTableModel) winPrincipal.getTblBitacora().getModel());
                        for (int i = 0; i < h.size(); i++) {
                            datos = (Object[]) h.get(i);
                            JOptionPane.showMessageDialog(winPrincipal, "Hora " + datos[0] + " y minuto: " + datos[2] + " Registrados en bitacora: ",
                                    "Advertencia", JOptionPane.WARNING_MESSAGE
                            );
                        }
                    } else {                       
                        
                        revisarTiemposFaltentes(winPrincipal, 2);
                        int tiempoCero = 0;
                        for (int i = 0; i < tablaHorasCero.getRowCount(); i++) {
                            if (Integer.parseInt(tablaHorasCero.getValueAt(i, 1).toString()) != 0) {
                                tiempoCero++;
                            }
                        }
                        
                        switch (tiempoCero) {
                            case 0:
                                int columnas = winPrincipal.getTblBitacora().getColumnCount();
                                ArrayList reg;
                                for (int i = 0; i < winPrincipal.getTblBitacora().getRowCount(); i++) {
                                    reg = new ArrayList();
                                    for (int j = 0; j < columnas; j++) {
                                        reg.add(winPrincipal.getTblBitacora().getValueAt(i, j));
                                    }
                                    bitacoraObj.insertarRegistroAccess(reg);
                                }
                                limpiarTabla((DefaultTableModel) winPrincipal.getTblBitacora().getModel());
                                JOptionPane.showMessageDialog(winPrincipal, "Bitacora Guardada Correctamente",
                                        "Guardar", JOptionPane.INFORMATION_MESSAGE);
                                break;
                            default:
                                JOptionPane.showMessageDialog(winPrincipal, "Verifique que el total de sus horas de trabajo sean CERO",
                                        "Advertencia", JOptionPane.WARNING_MESSAGE);
                                break;
                        }
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
        if (winPrincipal.getTblBitacora().getRowCount() != 0) {
            switch (JOptionPane.showConfirmDialog(winPrincipal, "En caso de tener registros sin guardar, estos se perderán.\n¿Seguro que desea continuar?", "Mensaje",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
                case 0:
                    limpiarTabla((DefaultTableModel) winPrincipal.getTblBitacora().getModel());

                    winPrincipal.getDteFecha().setEnabled(false);
                    winPrincipal.getBtnGuardar().setText("Actualizar Bitacora");
                    Object[] bitacoraObj;
                    try {
                        ArrayList bitacoraArr = new BitacoraDAOImpl().listarBitacoras(winPrincipal.getDteFecha().getText(),
                                winPrincipal.getCmbLinea().getSelectedItem().toString());
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
                ArrayList bitacoraArr = new BitacoraDAOImpl().listarBitacoras(winPrincipal.getDteFecha().getText(),
                        winPrincipal.getCmbLinea().getSelectedItem().toString());
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
        dao.BitacoraDAOImpl bitacoraObj = new dao.BitacoraDAOImpl();
        try {
            bitacoraObj.borrarRegistroFechaAccess(winPrincipal.getDteFecha().getText());
            if (winPrincipal.getTblBitacora().getModel().getRowCount() != 0) {
                int columnas = winPrincipal.getTblBitacora().getColumnCount();
                ArrayList reg;
                for (int i = 0; i < winPrincipal.getTblBitacora().getRowCount(); i++) {
                    reg = new ArrayList();
                    for (int j = 0; j < columnas; j++) {
                        reg.add(winPrincipal.getTblBitacora().getValueAt(i, j));
                    }
                    bitacoraObj.insertarRegistroAccess(reg);
                }
                cancelarEdicion(winPrincipal);
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
    
    public void guardaTemporalTXT (Principal winPrincipal ){
        try{
            String sucursalesCSVFile = "tmp/"+winPrincipal.getCmbLinea().getSelectedItem()+".txt";
            BufferedWriter bfw = new BufferedWriter(new FileWriter(sucursalesCSVFile));
            
            for (int i = 0; i < modeloTabla.getRowCount(); i++ ){
                for (int j = 0; j < modeloTabla.getColumnCount(); j++ ){
                    bfw.write((String) (modeloTabla.getValueAt(i,j)));
                    if(j < modeloTabla.getColumnCount() -1){
                        bfw.write(",");
                    }
                }
                bfw.newLine();
            }
            bfw.close();
            JOptionPane.showMessageDialog(null, "Archivo salvador salio al recate");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"El archivo salvador no pudo asistir");
        }
    }
    
}
