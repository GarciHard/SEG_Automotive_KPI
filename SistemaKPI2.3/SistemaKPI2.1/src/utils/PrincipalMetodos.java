package utils;

import dao.CalidadDAOImpl;
import dao.LineasDAOImpl;
import dao.OrganizacionalesDAOImpl;
import dao.PiezasProducidasDAOImpl;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vista.Principal;

/**
 * Hecho con <3 por:
 * @author GarciHard
 * @boschUsr GJA5TL
 */
public class PrincipalMetodos {

    private DefaultComboBoxModel listaArea;
    private DefaultComboBoxModel listaAreaC;
    private DefaultComboBoxModel listaCliente;
    private DefaultComboBoxModel listaLinea;
    private DefaultComboBoxModel listaNoParte;
    private DefaultComboBoxModel listaOperacion;
    private DefaultComboBoxModel listaProblema;
    private DefaultComboBoxModel listaProblemaC;
    private JFrame form;

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
        winPrincipal.getCmbClienteOrganizacional().setEnabled(true);
        winPrincipal.getCmbClienteOrganizacional().setModel(listaClientes(winPrincipal.getCmbLinea().getSelectedItem().toString()));
        winPrincipal.getCmbClienteOrganizacional().setSelectedIndex(0);
        winPrincipal.getCmbNoParteOrganizacional().setEnabled(false);
    }
    
    public void panelOrganizacionalesNoPartes(Principal winPrincipal) {
        winPrincipal.getCmbNoParteOrganizacional().setEnabled(true);
        winPrincipal.getCmbNoParteOrganizacional().setModel(listaNoPartes(winPrincipal.getCmbLinea().getSelectedItem().toString(),
                winPrincipal.getCmbClienteOrganizacional().getSelectedItem().toString()));
        winPrincipal.getCmbNoParteOrganizacional().setSelectedIndex(0);
        winPrincipal.getCmbHora().setEnabled(false);
    }
    
    public void panelCambiosAreas(Principal winPrincipal) {
        PrincipalValidaciones.limpiarTiemposIncidencia(winPrincipal);
        winPrincipal.getCmbAreaCambios().setEnabled(true);
        winPrincipal.getCmbAreaCambios().setModel(listaAreasOrganizacional(winPrincipal.getCmbLinea().getSelectedItem().toString(),
                winPrincipal.getCmbTema().getSelectedItem().toString()));
        winPrincipal.getPnlProduccionCollapsible().setContent(winPrincipal.getPnlCambios());
        winPrincipal.getPnlProduccionCollapsible().repaint();
        winPrincipal.getCmbAreaCambios().setSelectedIndex(0);
        winPrincipal.getCmbProblemaCambios().setEnabled(false);
    }
    
    public void panelCambiosProblemas(Principal winPrincipal) {
        winPrincipal.getCmbProblemaCambios().setEnabled(true);
        winPrincipal.getCmbProblemaCambios().setModel(listaProblemasOrganizacional(
                winPrincipal.getCmbLinea().getSelectedItem().toString(),
                winPrincipal.getCmbTema().getSelectedItem().toString(),
                winPrincipal.getCmbAreaCambios().getSelectedItem().toString()));
        winPrincipal.getCmbProblemaCambios().setSelectedIndex(0);
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
        winPrincipal.getCmbNoParteCambioCambios().setEnabled(false);
    }
    
    public void panelCambiosNoPartesCambios(Principal winPrincipal) {
        winPrincipal.getCmbNoParteCambioCambios().setEnabled(true);
        winPrincipal.getCmbNoParteCambioCambios().setModel(listaNoPartes(winPrincipal.getCmbLinea().getSelectedItem().toString(),
                winPrincipal.getCmbClienteCambios().getSelectedItem().toString()));
        winPrincipal.getCmbNoParteCambioCambios().setSelectedIndex(0);
        winPrincipal.getTxtScrapCambios().setEnabled(false);
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
        if (!winPrincipal.getTxtCantidadProducidaCalidad().getText().isEmpty()) {
            winPrincipal.getTxtCantidadProducidaCalidad().setText("");
            winPrincipal.getTxtCantidadProducidaCalidad().setEnabled(false);
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
        Object[] reg = new Object[17];
        Object[] tiempos = new Object[4];
        ArrayList tiempoHora = new ArrayList();
        DefaultTableModel tableModel = (DefaultTableModel) winPrincipal.getTblBitacora().getModel();
        reg = insertaRegBitacora(winPrincipal, reg);

        if (winPrincipal.getTblBitacora().getRowCount() == 0) {
            tiempos[0] = reg[4];
            tiempos[1] = reg[5];
            tiempos[2] = reg[6];
            tiempos[3] = reg[7];
            tiempoHora.add(tiempos);
            tableModel.addRow(reg);
            winPrincipal.getCmbTema().setSelectedIndex(0);
        } else {
            for (int c = 0; c < tableModel.getRowCount(); c++) {
                if (tableModel.getValueAt(c, 2).toString().equals(reg[2].toString())) {
                    tiempos[0] = tableModel.getValueAt(c, 2);
                    tiempos[1] = tableModel.getValueAt(c, 3);
                    tiempos[2] = tableModel.getValueAt(c, 4);
                    tiempos[3] = tableModel.getValueAt(c, 5);
                    tiempoHora.add(tiempos);
                }
            }
            if (tiempoHora.size() > 0) {
                Object[] tmp = (Object[]) tiempoHora.get(tiempoHora.size() - 1);
                if (Integer.parseInt(reg[3].toString()) > Integer.parseInt(tmp[2].toString())) {
                    tableModel.addRow(insertaRegBitacora(winPrincipal, reg));
                    winPrincipal.getCmbTema().setSelectedIndex(0);
                } else {
                    JOptionPane.showMessageDialog(winPrincipal, "lapso de periodo invalido");
                }
            } else {
                tableModel.addRow(reg);
                winPrincipal.getCmbTema().setSelectedIndex(0);
            }
        }
    }
    
    private Object[] insertaRegBitacora(Principal winPrincipal, Object[] reg) {
        switch (winPrincipal.getCmbTema().getSelectedItem().toString()) {
            case "Piezas Producidas":
                reg[0] = winPrincipal.getCmbLinea().getSelectedItem();
                reg[1] = winPrincipal.getDteFecha().getText();
                reg[2] = winPrincipal.getCmbHora().getSelectedItem();
                reg[3] = winPrincipal.getTxtTiempoInicio().getText();
                reg[4] = winPrincipal.getTxtTiempoFin().getText();
                reg[5] = winPrincipal.getTxtDuracion().getText();
                reg[6] = winPrincipal.getCmbTema().getSelectedItem();
                reg[7] = "";//cmbOperacion.getSelectedItem();
                reg[8] = "";
                reg[9] = "";
                reg[10] = winPrincipal.getCmbClientePzasProd().getSelectedItem();
                reg[11] = winPrincipal.getCmbNoPartePzasProd().getSelectedItem();
                reg[12] = winPrincipal.getTxtCantidadProducidaPzasProd().getText();
                reg[13] = "";
                reg[14] = "";
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
                reg[12] = winPrincipal.getTxtCantidadProducidaCalidad().getText();
                reg[13] = "";
                reg[14] = winPrincipal.getTxtScrapCalidad().getText();
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
                break;
            case "Organizacionales":
                reg[0] = winPrincipal.getCmbLinea().getSelectedItem();
                reg[1] = winPrincipal.getDteFecha().getText();
                reg[2] = winPrincipal.getCmbHora().getSelectedItem();
                reg[3] = winPrincipal.getTxtTiempoInicio().getText();
                reg[4] = winPrincipal.getTxtTiempoFin().getText();
                reg[5] = winPrincipal.getTxtDuracion().getText();
                reg[6] = winPrincipal.getCmbTema().getSelectedItem();//
                reg[7] = "";
                reg[8] = winPrincipal.getCmbAreaOrganizacional().getSelectedItem();
                reg[9] = winPrincipal.getCmbProblemaOrganizacional().getSelectedItem();
                reg[10] = winPrincipal.getCmbClienteOrganizacional().getSelectedItem();
                reg[11] = winPrincipal.getCmbNoParteOrganizacional().getSelectedItem();
                reg[12] = 0;
                reg[13] = "";
                reg[14] = "";
                break;
            case "Cambio":
                reg[0] = winPrincipal.getCmbLinea().getSelectedItem();
                reg[1] = winPrincipal.getDteFecha().getText();
                reg[2] = winPrincipal.getCmbHora().getSelectedItem();
                reg[3] = winPrincipal.getTxtTiempoInicio().getText();
                reg[4] = winPrincipal.getTxtTiempoFin().getText();
                reg[5] = winPrincipal.getTxtDuracion().getText();
                reg[6] = winPrincipal.getCmbTema().getSelectedItem();//
                reg[7] = "";
                reg[8] = winPrincipal.getCmbAreaCambios().getSelectedItem();
                reg[9] = winPrincipal.getCmbProblemaCambios().getSelectedItem();
                reg[10] = winPrincipal.getCmbClienteCambios().getSelectedItem();
                reg[11] = winPrincipal.getCmbNoParteCambios().getSelectedItem();
                reg[12] = 0;
                reg[13] = winPrincipal.getCmbNoParteCambioCambios().getSelectedItem();
                reg[14] = winPrincipal.getTxtScrapCambios().getText();
                break;
            case "Planeados":
                reg[0] = winPrincipal.getCmbLinea().getSelectedItem();
                reg[1] = winPrincipal.getDteFecha().getText();
                reg[2] = winPrincipal.getCmbHora().getSelectedItem();
                reg[3] = winPrincipal.getTxtTiempoInicio().getText();
                reg[4] = winPrincipal.getTxtTiempoFin().getText();
                reg[5] = winPrincipal.getTxtDuracion().getText();
                reg[6] = winPrincipal.getCmbTema().getSelectedItem();//
                reg[7] = "";
                reg[8] = winPrincipal.getCmbAreaPlaneados().getSelectedItem();
                reg[9] = "";
                reg[10] = winPrincipal.getCmbClientePlaneados().getSelectedItem();
                reg[11] = winPrincipal.getCmbNoPartePlaneados().getSelectedItem();
                reg[12] = 0;
                reg[13] = "";
                reg[14] = "";
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
    
}