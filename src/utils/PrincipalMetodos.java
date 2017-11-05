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
import javax.swing.SwingConstants;
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

    private DefaultComboBoxModel listaFamilias(String linea) {
        try {
            listaCliente = new PiezasProducidasDAOImpl().listaFamilias(linea);
            if (listaCliente.getSize() == 0) {
                JOptionPane.showMessageDialog(form, "PrincipalMetodos.listaFamilias()\n"
                        + "No hay familias para la linea seleccionada", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(form, "PrincipalMetodos.listaFamilias()\n"
                    + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return listaCliente;
    }

    private DefaultComboBoxModel listaFamiliasClientes(String linea, String familia) {
        try {
            listaCliente = new PiezasProducidasDAOImpl().listaFamiliasClientes(linea, familia);
            if (listaCliente.getSize() == 0) {
                JOptionPane.showMessageDialog(form, "PrincipalMetodos.listaFamiliasClientes()\n"
                        + "No hay clientes para la linea seleccionada", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(form, "PrincipalMetodos.listaFamiliasClientes()\n"
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

    private DefaultComboBoxModel listaNoPartesFamilia(String linea, String familia, String cliente) {
        try {
            listaNoParte = new PiezasProducidasDAOImpl().listaNoParteFamilia(linea, familia, cliente);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(form, "PrincipalMetodos.listaNoParteFamilia()\n"
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
        if (PrincipalControl.tipoEnsambleLinea == 3) {
            winPrincipal.getLblClientePzasProd().setText("FAMILIA");
            winPrincipal.getLblFamiliaPzasProd().setVisible(true);
            winPrincipal.getCmbFamiliaPzasProd().setVisible(true);
            winPrincipal.getCmbClientePzasProd().setModel(
                    listaFamilias(
                            winPrincipal.getCmbLinea().getSelectedItem().toString()
                    )
            );
        } else {
            winPrincipal.getLblClientePzasProd().setText("CLIENTE");
            winPrincipal.getLblFamiliaPzasProd().setVisible(false);
            winPrincipal.getCmbFamiliaPzasProd().setVisible(false);
            winPrincipal.getCmbClientePzasProd().setModel(listaClientes(winPrincipal.getCmbLinea().getSelectedItem().toString()));
        }
        winPrincipal.getCmbClientePzasProd().setEnabled(true);
        winPrincipal.getPnlProduccionCollapsible().setContent(winPrincipal.getPnlPiezasProducidas());
        winPrincipal.getPnlProduccionCollapsible().repaint();
        winPrincipal.getCmbClientePzasProd().setSelectedIndex(0);
    }

    public void panelPiezasProducidasFamilias(Principal winPrincipal) {
        winPrincipal.getCmbFamiliaPzasProd().setEnabled(true);
        winPrincipal.getCmbFamiliaPzasProd().setModel(
                listaFamiliasClientes(
                        winPrincipal.getCmbLinea().getSelectedItem().toString(),
                        winPrincipal.getCmbClientePzasProd().getSelectedItem().toString()
                )
        );
        winPrincipal.getCmbFamiliaPzasProd().setSelectedIndex(0);
        //winPrincipal.getCmbNoPartePzasProd().setEnabled(false);
    }

    public void panelPiezasProducidasNoPartes(Principal winPrincipal) {
        if (!winPrincipal.getTxtTC().getText().isEmpty()) {
            winPrincipal.getTxtTC().setText("");
            winPrincipal.getTxtTC().setEnabled(false);
        }
        if (PrincipalControl.tipoEnsambleLinea == 3) {
            winPrincipal.getCmbNoPartePzasProd().setModel(listaNoPartesFamilia(winPrincipal.getCmbLinea().getSelectedItem().toString(),
                    winPrincipal.getCmbClientePzasProd().getSelectedItem().toString(),
                    winPrincipal.getCmbFamiliaPzasProd().getSelectedItem().toString()));
            winPrincipal.getCmbNoPartePzasProd().setEnabled(true);
        } else {
            winPrincipal.getCmbNoPartePzasProd().setModel(listaNoPartes(winPrincipal.getCmbLinea().getSelectedItem().toString(),
                    winPrincipal.getCmbClientePzasProd().getSelectedItem().toString()));
            winPrincipal.getCmbNoPartePzasProd().setEnabled(true);
        }
    }

    public void panelCalidadOperaciones(Principal winPrincipal) {
        PrincipalValidaciones.limpiarTiemposIncidencia(winPrincipal);
        if (PrincipalControl.tipoEnsambleLinea == 3) {
            winPrincipal.getLblFamiliaCalidad().setVisible(true);
            winPrincipal.getCmbFamiliaCalidad().setVisible(true);
        } else {
            winPrincipal.getLblFamiliaCalidad().setVisible(false);
            winPrincipal.getCmbFamiliaCalidad().setVisible(false);
        }
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
                winPrincipal.getCmbAreaCalidad().getSelectedItem().toString())
        );
        winPrincipal.getCmbProblemaCalidad().setSelectedIndex(0);
        if (PrincipalControl.tipoEnsambleLinea == 3) {
            winPrincipal.getCmbFamiliaCalidad().setEnabled(false);
        } else {
            winPrincipal.getCmbClienteCalidad().setEnabled(false);
        }
    }

    public void panelCalidadFamilias(Principal winPrincipal) {
        winPrincipal.getCmbFamiliaCalidad().setEnabled(true);
        winPrincipal.getCmbFamiliaCalidad().setModel(
                listaFamilias(winPrincipal.getCmbLinea().getSelectedItem().toString())
        );
        winPrincipal.getCmbFamiliaCalidad().setSelectedIndex(0);
        winPrincipal.getCmbClienteCalidad().setEnabled(false);
    }

    public void panelCalidadClientes(Principal winPrincipal) {
        winPrincipal.getCmbClienteCalidad().setEnabled(true);
        if (PrincipalControl.tipoEnsambleLinea == 3) {
            winPrincipal.getCmbClienteCalidad().setModel(
                    listaFamiliasClientes(winPrincipal.getCmbLinea().getSelectedItem().toString(),
                            winPrincipal.getCmbFamiliaCalidad().getSelectedItem().toString()
                    )
            );
        } else {
            winPrincipal.getCmbClienteCalidad().setModel(
                    listaClientes(winPrincipal.getCmbLinea().getSelectedItem().toString()));
        }
        winPrincipal.getCmbClienteCalidad().setSelectedIndex(0);
        winPrincipal.getCmbNoParteCalidad().setEnabled(false);
    }

    public void panelCalidadNoPartes(Principal winPrincipal) {
        if (!winPrincipal.getTxtScrapCalidad().getText().isEmpty()) {
            winPrincipal.getTxtScrapCalidad().setText("");
            winPrincipal.getTxtScrapCalidad().setEnabled(false);
        }
        winPrincipal.getCmbNoParteCalidad().setEnabled(true);
        if (PrincipalControl.tipoEnsambleLinea == 3) {
            winPrincipal.getCmbNoParteCalidad().setModel(
                    listaNoPartesFamilia(
                            winPrincipal.getCmbLinea().getSelectedItem().toString(),
                            winPrincipal.getCmbFamiliaCalidad().getSelectedItem().toString(),
                            winPrincipal.getCmbClienteCalidad().getSelectedItem().toString()
                    )
            );
        } else {
            winPrincipal.getCmbNoParteCalidad().setModel(
                    listaNoPartes(winPrincipal.getCmbLinea().getSelectedItem().toString(),
                            winPrincipal.getCmbClienteCalidad().getSelectedItem().toString()
                    )
            );
        }
    }

    public void panelTecnicasOperaciones(Principal winPrincipal) {
        PrincipalValidaciones.limpiarTiemposIncidencia(winPrincipal);
        if (PrincipalControl.tipoEnsambleLinea == 3) {
            winPrincipal.getLblFamiliaTecnicas().setVisible(true);
            winPrincipal.getCmbFamiliaTecnicas().setVisible(true);
        } else {
            winPrincipal.getLblFamiliaTecnicas().setVisible(false);
            winPrincipal.getCmbFamiliaTecnicas().setVisible(false);
        }
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
        winPrincipal.getCmbProblemaTecnicas().setModel(
                listaProblemasCalidad(
                        winPrincipal.getCmbLinea().getSelectedItem().toString(),
                        winPrincipal.getCmbTema().getSelectedItem().toString(),
                        winPrincipal.getCmbOperacionTecnicas().getSelectedItem().toString(),
                        winPrincipal.getCmbAreaTecnicas().getSelectedItem().toString()
                )
        );
        winPrincipal.getCmbProblemaTecnicas().setSelectedIndex(0);
        if (PrincipalControl.tipoEnsambleLinea == 3) {
            winPrincipal.getCmbFamiliaTecnicas().setEnabled(false);
        } else {
            winPrincipal.getCmbClienteTecnicas().setEnabled(false);
        }
    }

    public void panelTecnicasFamilias(Principal winPrincipal) {
        winPrincipal.getCmbFamiliaTecnicas().setEnabled(true);
        winPrincipal.getCmbFamiliaTecnicas().setModel(
                listaFamilias(winPrincipal.getCmbLinea().getSelectedItem().toString())
        );
        winPrincipal.getCmbFamiliaTecnicas().setSelectedIndex(0);
        winPrincipal.getCmbClienteTecnicas().setEnabled(false);
    }

    public void panelTecnicasClientes(Principal winPrincipal) {
        winPrincipal.getCmbClienteTecnicas().setEnabled(true);
        if (PrincipalControl.tipoEnsambleLinea == 3) {
            winPrincipal.getCmbClienteTecnicas().setModel(
                    listaFamiliasClientes(winPrincipal.getCmbLinea().getSelectedItem().toString(),
                            winPrincipal.getCmbFamiliaTecnicas().getSelectedItem().toString()
                    )
            );
        } else {
            winPrincipal.getCmbClienteTecnicas().setModel(
                    listaClientes(winPrincipal.getCmbLinea().getSelectedItem().toString()));
        }
        winPrincipal.getCmbClienteTecnicas().setSelectedIndex(0);
        winPrincipal.getCmbNoParteTecnicas().setEnabled(false);
    }

    public void panelTecnicasNoPartes(Principal winPrincipal) {
        if (!winPrincipal.getTxtScrapTecnicas().getText().isEmpty()) {
            winPrincipal.getTxtScrapTecnicas().setText("");
            winPrincipal.getTxtScrapTecnicas().setEnabled(false);
        }
        winPrincipal.getCmbNoParteTecnicas().setEnabled(true);
        if (PrincipalControl.tipoEnsambleLinea == 3) {
            winPrincipal.getCmbNoParteTecnicas().setModel(
                    listaNoPartesFamilia(
                            winPrincipal.getCmbLinea().getSelectedItem().toString(),
                            winPrincipal.getCmbFamiliaTecnicas().getSelectedItem().toString(),
                            winPrincipal.getCmbClienteTecnicas().getSelectedItem().toString()
                    )
            );
        } else {
            winPrincipal.getCmbNoParteTecnicas().setModel(
                    listaNoPartes(winPrincipal.getCmbLinea().getSelectedItem().toString(),
                            winPrincipal.getCmbClienteTecnicas().getSelectedItem().toString()
                    )
            );
        }
    }

    public void panelOrganizacionalesAreas(Principal winPrincipal) {
        PrincipalValidaciones.limpiarTiemposIncidencia(winPrincipal);
        if (PrincipalControl.tipoEnsambleLinea == 3) {
            winPrincipal.getLblFamiliaOrganizacional().setVisible(true);
            winPrincipal.getCmbFamiliaOrganizacional().setVisible(true);
        } else {
            winPrincipal.getLblFamiliaOrganizacional().setVisible(false);
            winPrincipal.getCmbFamiliaOrganizacional().setVisible(false);
        }
        winPrincipal.getCmbAreaOrganizacional().setEnabled(true);
        winPrincipal.getCmbAreaOrganizacional().setModel(
                listaAreasOrganizacional(
                        winPrincipal.getCmbLinea().getSelectedItem().toString(),
                        winPrincipal.getCmbTema().getSelectedItem().toString()
                )
        );
        winPrincipal.getPnlProduccionCollapsible().setContent(winPrincipal.getPnlOrganizacionales());
        winPrincipal.getPnlProduccionCollapsible().repaint();
        winPrincipal.getCmbAreaOrganizacional().setSelectedIndex(0);
        winPrincipal.getCmbProblemaOrganizacional().setEnabled(false);
    }

    public void panelOrganizacionalesProblemas(Principal winPrincipal) {
        winPrincipal.getCmbProblemaOrganizacional().setEnabled(true);
        winPrincipal.getCmbProblemaOrganizacional().setModel(
                listaProblemasOrganizacional(
                        winPrincipal.getCmbLinea().getSelectedItem().toString(),
                        winPrincipal.getCmbTema().getSelectedItem().toString(),
                        winPrincipal.getCmbAreaOrganizacional().getSelectedItem().toString()
                )
        );
        winPrincipal.getCmbProblemaOrganizacional().setSelectedIndex(0);
        if (PrincipalControl.tipoEnsambleLinea == 3) {
            winPrincipal.getCmbFamiliaOrganizacional().setEnabled(false);
        } else {
            winPrincipal.getCmbClienteOrganizacional().setEnabled(false);
        }
    }

    public void panelOrganizacionalesFamilias(Principal winPrincipal) {
        winPrincipal.getCmbFamiliaOrganizacional().setEnabled(true);
        winPrincipal.getCmbFamiliaOrganizacional().setModel(
                listaFamilias(winPrincipal.getCmbLinea().getSelectedItem().toString())
        );
        winPrincipal.getCmbClienteOrganizacional().setEnabled(true);                
        winPrincipal.getTxtMatFaltante().setEditable(false);
        winPrincipal.getTxtMatFaltante().setEnabled(false);
        winPrincipal.getCmbFamiliaOrganizacional().setSelectedIndex(0);
        winPrincipal.getCmbClienteOrganizacional().setEnabled(false);
    }

    public void panelOrganizacionalesClientes(Principal winPrincipal) {
        if (winPrincipal.getCmbAreaOrganizacional().getSelectedIndex() == 1) {
            if (winPrincipal.getCmbProblemaOrganizacional().getSelectedIndex() >= 2 && 
                    winPrincipal.getCmbProblemaOrganizacional().getSelectedIndex() <= 5) {
                winPrincipal.getLblMatFaltante().setVisible(true);
                winPrincipal.getTxtMatFaltante().setVisible(true);
                winPrincipal.getTxtMatFaltante().setText("");
                winPrincipal.getCmbClienteOrganizacional().setEnabled(true);
                winPrincipal.getCmbClienteOrganizacional().setSelectedIndex(0);
                winPrincipal.getCmbClienteOrganizacional().setEnabled(true);
            } else {
                winPrincipal.getLblMatFaltante().setVisible(false);
                winPrincipal.getTxtMatFaltante().setVisible(false);
                winPrincipal.getTxtMatFaltante().setText("");
                winPrincipal.getCmbClienteOrganizacional().setEnabled(true);
            }
        } else {
            winPrincipal.getLblMatFaltante().setVisible(false);
            winPrincipal.getTxtMatFaltante().setVisible(false);
            winPrincipal.getTxtMatFaltante().setText("");
            winPrincipal.getCmbClienteOrganizacional().setEnabled(true);
        }

        if (PrincipalControl.tipoEnsambleLinea == 3) {
            winPrincipal.getCmbClienteOrganizacional().setModel(
                    listaFamiliasClientes(
                            winPrincipal.getCmbLinea().getSelectedItem().toString(),
                            winPrincipal.getCmbFamiliaOrganizacional().getSelectedItem().toString()
                    )
            );
        } else {
            winPrincipal.getCmbClienteOrganizacional().setModel(
                    listaClientes(
                            winPrincipal.getCmbLinea().getSelectedItem().toString()
                    )
            );
        }
        winPrincipal.getCmbClienteOrganizacional().setSelectedIndex(0);
        winPrincipal.getCmbNoParteOrganizacional().setEnabled(false);
    }

    public void panelOrganizacionalesNoPartes(Principal winPrincipal) {
        if (PrincipalControl.tipoEnsambleLinea == 3) {
            winPrincipal.getCmbNoParteOrganizacional().setModel(
                    listaNoPartesFamilia(
                            winPrincipal.getCmbLinea().getSelectedItem().toString(),
                            winPrincipal.getCmbFamiliaOrganizacional().getSelectedItem().toString(),
                            winPrincipal.getCmbClienteOrganizacional().getSelectedItem().toString()
                    )
            );
        } else {
            winPrincipal.getCmbNoParteOrganizacional().setModel(
                    listaNoPartes(
                            winPrincipal.getCmbLinea().getSelectedItem().toString(),
                            winPrincipal.getCmbClienteOrganizacional().getSelectedItem().toString()
                    )
            );
        }
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
        if (PrincipalControl.tipoEnsambleLinea == 3) {
            winPrincipal.getLblFamiliaCambios().setVisible(true);
            winPrincipal.getCmbFamiliaCambios().setVisible(true);
            winPrincipal.getLblFamiliaNuevaCambios().setVisible(true);
            winPrincipal.getCmbFamiliaNuevaCambios().setVisible(true);
        } else {
            winPrincipal.getLblFamiliaCambios().setVisible(false);
            winPrincipal.getCmbFamiliaCambios().setVisible(false);
            winPrincipal.getLblFamiliaNuevaCambios().setVisible(false);
            winPrincipal.getCmbFamiliaNuevaCambios().setVisible(false);
        }
        winPrincipal.getCmbAreaCambios().setEnabled(true);
        winPrincipal.getCmbAreaCambios().setModel(
                listaAreasOrganizacional(
                        winPrincipal.getCmbLinea().getSelectedItem().toString(),
                        winPrincipal.getCmbTema().getSelectedItem().toString()
                )
        );
        winPrincipal.getPnlProduccionCollapsible().setContent(winPrincipal.getPnlCambios());
        winPrincipal.getPnlProduccionCollapsible().repaint();
        winPrincipal.getCmbAreaCambios().setSelectedIndex(0);
        winPrincipal.getCmbFamiliaCambios().setEnabled(false);
        winPrincipal.getCmbClienteCambios().setEnabled(false);
    }

    public void panelCambiosFamilias(Principal winPrincipal) {
        winPrincipal.getCmbFamiliaCambios().setEnabled(true);
        winPrincipal.getCmbFamiliaCambios().setModel(
                listaFamilias(
                        winPrincipal.getCmbLinea().getSelectedItem().toString()
                )
        );
        winPrincipal.getCmbFamiliaCambios().setSelectedIndex(0);
        winPrincipal.getCmbClienteCambios().setEnabled(false);
    }
    
    public void panelCambiosClientes(Principal winPrincipal) {
        winPrincipal.getCmbClienteCambios().setEnabled(true);
        if (PrincipalControl.tipoEnsambleLinea == 3) {
            winPrincipal.getCmbClienteCambios().setModel(
                    listaFamiliasClientes(
                            winPrincipal.getCmbLinea().getSelectedItem().toString(),
                            winPrincipal.getCmbFamiliaCambios().getSelectedItem().toString()
                    )
            );
        } else {
            winPrincipal.getCmbClienteCambios().setModel(
                    listaClientes(
                            winPrincipal.getCmbLinea().getSelectedItem().toString()
                    )
            );
        }
        winPrincipal.getCmbClienteCambios().setSelectedIndex(0);
        winPrincipal.getCmbNoParteCambios().setEnabled(false);
    }
    
    public void panelCambiosNoPartes(Principal winPrincipal) {
        winPrincipal.getCmbNoParteCambios().setEnabled(true);
        if (PrincipalControl.tipoEnsambleLinea == 3) {
            winPrincipal.getCmbNoParteCambios().setModel(
                    listaNoPartesFamilia(
                            winPrincipal.getCmbLinea().getSelectedItem().toString(),
                            winPrincipal.getCmbFamiliaCambios().getSelectedItem().toString(),
                            winPrincipal.getCmbClienteCambios().getSelectedItem().toString()
                    )
            );
        } else {
            winPrincipal.getCmbNoParteCambios().setModel(
                    listaNoPartes(
                            winPrincipal.getCmbLinea().getSelectedItem().toString(),
                            winPrincipal.getCmbClienteCambios().getSelectedItem().toString()
                    )
            );
        }
        winPrincipal.getCmbNoParteCambios().setSelectedIndex(0);
        winPrincipal.getCmbFamiliaNuevaCambios().setEnabled(false);
        winPrincipal.getCmbClienteNuevoCambios().setEnabled(false);
    }

    public void panelCambiosFamiliaNueva(Principal winPrincipal) {
        winPrincipal.getCmbFamiliaNuevaCambios().setEnabled(true);
        winPrincipal.getCmbFamiliaNuevaCambios().setModel(
                listaFamilias(
                        winPrincipal.getCmbLinea().getSelectedItem().toString()
                )
        );
        winPrincipal.getCmbFamiliaNuevaCambios().setSelectedIndex(0);
        winPrincipal.getCmbClienteNuevoCambios().setEnabled(false);
    }

    public void panelCambiosClienteNuevo(Principal winPrincipal) {
        winPrincipal.getCmbClienteNuevoCambios().setEnabled(true);
        if (PrincipalControl.tipoEnsambleLinea == 3) {
            winPrincipal.getCmbClienteNuevoCambios().setModel(
                    listaFamiliasClientes(
                            winPrincipal.getCmbLinea().getSelectedItem().toString(),
                            winPrincipal.getCmbFamiliaNuevaCambios().getSelectedItem().toString()
                    )
            );
        } else {
            winPrincipal.getCmbClienteNuevoCambios().setModel(
                    listaClientes(
                            winPrincipal.getCmbLinea().getSelectedItem().toString()
                    )
            );
        }
        winPrincipal.getCmbClienteNuevoCambios().setSelectedIndex(0);
        winPrincipal.getCmbNoParteCambioCambios().setEnabled(false);
    }

    public void panelCambiosNoPartesCambios(Principal winPrincipal) {
        winPrincipal.getCmbNoParteCambioCambios().setEnabled(true);
        if (PrincipalControl.tipoEnsambleLinea == 3) {
            winPrincipal.getCmbNoParteCambioCambios().setModel(
                    listaNoPartesFamilia(
                            winPrincipal.getCmbLinea().getSelectedItem().toString(),
                            winPrincipal.getCmbFamiliaNuevaCambios().getSelectedItem().toString(),
                            winPrincipal.getCmbClienteNuevoCambios().getSelectedItem().toString()
                    )
            );
        } else {
            winPrincipal.getCmbNoParteCambioCambios().setModel(
                    listaNoPartes(
                            winPrincipal.getCmbLinea().getSelectedItem().toString(),
                            winPrincipal.getCmbClienteNuevoCambios().getSelectedItem().toString()
                    )
            );
        }
        winPrincipal.getCmbNoParteCambioCambios().setSelectedIndex(0);
        winPrincipal.getTxtScrapCambios().setEnabled(false);
    }

    public void panelPlaneadosAreas(Principal winPrincipal) {
        PrincipalValidaciones.limpiarTiemposIncidencia(winPrincipal);
        if (PrincipalControl.tipoEnsambleLinea == 3) {
            winPrincipal.getLblFamiliaPlaneados().setVisible(true);
            winPrincipal.getCmbFamiliaPlaneados().setVisible(true);
        } else {
            winPrincipal.getLblFamiliaPlaneados().setVisible(false);
            winPrincipal.getCmbFamiliaPlaneados().setVisible(false);
        }
        winPrincipal.getCmbAreaPlaneados().setEnabled(true);
        winPrincipal.getCmbAreaPlaneados().setModel(
                listaAreasOrganizacional(
                        winPrincipal.getCmbLinea().getSelectedItem().toString(),
                        winPrincipal.getCmbTema().getSelectedItem().toString()
                )
        );
        winPrincipal.getPnlProduccionCollapsible().setContent(winPrincipal.getPnlPlaneados());
        winPrincipal.getPnlProduccionCollapsible().repaint();
        winPrincipal.getCmbAreaPlaneados().setSelectedIndex(0);
        winPrincipal.getCmbFamiliaPlaneados().setEnabled(false);
        winPrincipal.getCmbClientePlaneados().setEnabled(false);
    }

    public void panelPlaneadosFamilias(Principal winPrincipal) {
        winPrincipal.getCmbFamiliaPlaneados().setEnabled(true);
        winPrincipal.getCmbFamiliaPlaneados().setModel(
                listaFamilias(
                        winPrincipal.getCmbLinea().getSelectedItem().toString()
                )
        );
        winPrincipal.getCmbFamiliaPlaneados().setSelectedIndex(0);
        winPrincipal.getCmbClientePlaneados().setEnabled(false);
    }

    public void panelPlaneadosClientes(Principal winPrincipal) {
        winPrincipal.getCmbClientePlaneados().setEnabled(true);
        if (PrincipalControl.tipoEnsambleLinea == 3) {
            winPrincipal.getCmbClientePlaneados().setModel(
                    listaFamiliasClientes(
                            winPrincipal.getCmbLinea().getSelectedItem().toString(),
                            winPrincipal.getCmbFamiliaPlaneados().getSelectedItem().toString()
                    )
            );
        } else {
            winPrincipal.getCmbClientePlaneados().setModel(
                    listaClientes(
                            winPrincipal.getCmbLinea().getSelectedItem().toString()
                    )
            );
        }
        winPrincipal.getCmbClientePlaneados().setSelectedIndex(0);
        winPrincipal.getCmbNoPartePlaneados().setEnabled(false);
    }

    public void panelPlaneadosNoPartes(Principal winPrincipal) {
        winPrincipal.getCmbNoPartePlaneados().setEnabled(true);
        if (PrincipalControl.tipoEnsambleLinea == 3) {
            winPrincipal.getCmbNoPartePlaneados().setModel(
                    listaNoPartesFamilia(
                            winPrincipal.getCmbLinea().getSelectedItem().toString(),
                            winPrincipal.getCmbFamiliaPlaneados().getSelectedItem().toString(),
                            winPrincipal.getCmbClientePlaneados().getSelectedItem().toString()
                    )
            );
        } else {
            winPrincipal.getCmbNoPartePlaneados().setModel(
                    listaNoPartes(
                            winPrincipal.getCmbLinea().getSelectedItem().toString(),
                            winPrincipal.getCmbClientePlaneados().getSelectedItem().toString()
                    )
            );
        }
        winPrincipal.getCmbNoPartePlaneados().setSelectedIndex(0);
        winPrincipal.getCmbHora().setEnabled(false);
        winPrincipal.getBtnParoPeriodo().setVisible(false);
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

    public void agregarRegistroBitacora(Principal winPrincipal) {
        int valorTema = winPrincipal.getCmbTema().getSelectedIndex();
        modeloTabla = (DefaultTableModel) winPrincipal.getTblBitacora().getModel();
        registroBitacora = modeloRegistroBitacora(winPrincipal, registroBitacora);

        if (winPrincipal.getTblBitacora().getRowCount() == 0) {
            modeloTabla.addRow(registroBitacora);
            insertarRegistroFilaAccess(winPrincipal);
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
                reg[14] = "0";
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
                reg[10] = winPrincipal.getCmbFamiliaPzasProd().getSelectedItem();
                reg[11] = winPrincipal.getCmbNoPartePzasProd().getSelectedItem();
                reg[12] = winPrincipal.getTxtCantidadProducidaPzasProd().getText();
                reg[13] = "";
                reg[14] = "0";
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
                if (winPrincipal.getCmbClienteOrganizacional()
                        .getSelectedItem().equals(winPrincipal.getCmbClienteOrganizacional().getItemAt(0))) {
                    reg[10] = "";
                } else {
                    reg[10] = winPrincipal.getCmbClienteOrganizacional().getSelectedItem();
                }
                if (winPrincipal.getCmbNoParteOrganizacional()
                        .getSelectedItem().equals(winPrincipal.getCmbNoParteOrganizacional().getItemAt(0))) {
                    reg[11] = "";
                } else {
                    reg[11] = winPrincipal.getCmbNoParteOrganizacional().getSelectedItem();
                }
                reg[12] = 0;
                reg[13] = "";
                reg[14] = "0";
                reg[15] = winPrincipal.getTxtMatFaltante().getText();
                reg[16] = "";
                break;
            case "Cambio de Modelo":
                reg[0] = winPrincipal.getCmbLinea().getSelectedItem();
                reg[1] = winPrincipal.getDteFecha().getText();
                reg[2] = winPrincipal.getCmbHora().getSelectedItem();
                reg[3] = winPrincipal.getTxtTiempoInicio().getText();
                reg[4] = winPrincipal.getTxtTiempoFin().getText();
                reg[5] = winPrincipal.getTxtDuracion().getText();
                reg[6] = winPrincipal.getCmbTema().getSelectedItem();//
                reg[7] = winPrincipal.getCmbLinea().getSelectedItem();
                reg[8] = winPrincipal.getCmbAreaCambios().getSelectedItem();
                reg[9] = winPrincipal.getCmbClienteCambios().getSelectedItem() + "-" + winPrincipal.getCmbNoParteCambios().getSelectedItem() + " a " + winPrincipal.getCmbClienteNuevoCambios().getSelectedItem() + "-" + winPrincipal.getCmbNoParteCambioCambios().getSelectedItem();//winPrincipal.getCmbProblemaCambios().getSelectedItem(); //problema
                reg[10] = winPrincipal.getCmbClienteCambios().getSelectedItem();
                reg[11] = winPrincipal.getCmbNoParteCambios().getSelectedItem();
                reg[12] = 0;
                reg[13] = winPrincipal.getCmbNoParteCambioCambios().getSelectedItem();
                reg[14] = winPrincipal.getTxtScrapCambios().getText();
                reg[15] = "";
                reg[16] = "";
                break;
            case "Paros Planeados":
                reg[0] = winPrincipal.getCmbLinea().getSelectedItem(); //linea
                reg[1] = winPrincipal.getDteFecha().getText(); //fecha
                reg[2] = winPrincipal.getCmbHora().getSelectedItem();//hora
                reg[3] = winPrincipal.getTxtTiempoInicio().getText();//inicio
                reg[4] = winPrincipal.getTxtTiempoFin().getText();//fin
                reg[5] = winPrincipal.getTxtDuracion().getText();//duracion
                reg[6] = winPrincipal.getCmbTema().getSelectedItem();//tema
                reg[7] = winPrincipal.getCmbLinea().getSelectedItem();//operacion
                reg[8] = winPrincipal.getCmbAreaPlaneados().getSelectedItem();//area
                reg[9] = "";//problema
                reg[10] = winPrincipal.getCmbClientePlaneados().getSelectedItem();// cliente
                reg[11] = winPrincipal.getCmbNoPartePlaneados().getSelectedItem();//parte
                reg[12] = 0;//cantidad
                reg[13] = "";//parte nuevo
                reg[14] = "0";//scrap
                reg[15] = "";//detalle material
                reg[16] = ""; //tc
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

                    winPrincipal.getLblTurno().setText("Visualización día / No edición");
                    winPrincipal.getDteFecha().setEnabled(false);
                    winPrincipal.getBtnGuardar().setEnabled(false);
                    winPrincipal.getBtnCambiarLinea().setEnabled(false);
                    Object[] bitacoraObj;
                    try {
                        ArrayList bitacoraArr = new BitacoraDAOImpl().listarBitacorasPorFecha(fecha, linea);

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
            winPrincipal.getLblTurno().setText("Visualización día / No edición");
            winPrincipal.getDteFecha().setEnabled(false);
            winPrincipal.getBtnGuardar().setEnabled(false);
            winPrincipal.getBtnCambiarLinea().setEnabled(false);
            Object[] bitacoraObj;
            try {
                ArrayList bitacoraArr = new BitacoraDAOImpl().listarBitacorasPorFecha(fecha, linea);

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
        
        System.out.println("i: "+inicio+" f: "+fin);
        if (winPrincipal.getTblBitacora().getRowCount() != 0) {
            switch (JOptionPane.showConfirmDialog(winPrincipal, "En caso de tener registros sin guardar, estos se perderán.\n¿Seguro que desea continuar?", "Mensaje",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
                case 0:
                    limpiarTabla((DefaultTableModel) winPrincipal.getTblBitacora().getModel());

                    winPrincipal.getDteFecha().setEnabled(false);
                    winPrincipal.getBtnGuardar().setText("Actualizar Bitacora");
                    Object[] bitacoraObj;
                    try {
                        if (inicio > fin){
                            ArrayList bitacoraArr = new BitacoraDAOImpl().listarBitacorasTurnoNocturno(fecha, linea, inicio, fecha, linea, fin);
                            if (!bitacoraArr.isEmpty()) {
                                modeloTabla = (DefaultTableModel) winPrincipal.getTblBitacora().getModel();
                                for (int i = 0; i < bitacoraArr.size(); i++) {
                                    bitacoraObj = (Object[]) bitacoraArr.get(i);
                                    modeloTabla.addRow(bitacoraObj);
                                }
                            }
                        }else{
                            ArrayList bitacoraArr = new BitacoraDAOImpl().listarBitacorasTurno(fecha, linea, inicio, fin);
                            if (!bitacoraArr.isEmpty()) {
                                modeloTabla = (DefaultTableModel) winPrincipal.getTblBitacora().getModel();
                                for (int i = 0; i < bitacoraArr.size(); i++) {
                                    bitacoraObj = (Object[]) bitacoraArr.get(i);
                                    modeloTabla.addRow(bitacoraObj);
                                }
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
                if (inicio > fin){
                    System.out.println("inicio > fin");
                    ArrayList bitacoraArr = new BitacoraDAOImpl().listarBitacorasTurnoNocturno(fecha, linea, inicio, fecha, linea, fin);
                    System.out.println(fecha+","+ linea+","+ inicio+","+fecha+","+ linea+","+ fin);
                    if (!bitacoraArr.isEmpty()) {
                        modeloTabla = (DefaultTableModel) winPrincipal.getTblBitacora().getModel();
                        for (int i = 0; i < bitacoraArr.size(); i++) {
                            bitacoraObj = (Object[]) bitacoraArr.get(i);
                            modeloTabla.addRow(bitacoraObj);
                        }
                    }
                }else{
                    ArrayList bitacoraArr = new BitacoraDAOImpl().listarBitacorasTurno(fecha, linea, inicio, fin);
                    if (!bitacoraArr.isEmpty()) {
                        modeloTabla = (DefaultTableModel) winPrincipal.getTblBitacora().getModel();
                        for (int i = 0; i < bitacoraArr.size(); i++) {
                            bitacoraObj = (Object[]) bitacoraArr.get(i);
                            modeloTabla.addRow(bitacoraObj);
                        }
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
        winPrincipal.getLblTurno().setText("");
        winPrincipal.getCmbTema().setSelectedIndex(0);
        winPrincipal.getCmbTema().setEnabled(false);
        limpiarTabla((DefaultTableModel) winPrincipal.getTblBitacora().getModel());
        winPrincipal.getBtnGuardar().setText("Guardar Bitacora");
        winPrincipal.getBtnGuardar().setVisible(false);
        winPrincipal.getBtnCancelar().setVisible(false);
        winPrincipal.getBtnCambiarLinea().setEnabled(true);
    }

    public void actualizarRegistroFechaAccess(Principal winPrincipal) {
        try {

            if (winPrincipal.getTblBitacora().getModel().getRowCount() != 0) {
                eliminarRegistroTiempoActualizar(winPrincipal);
                ArrayList reg;
                for (int i = 0; i < winPrincipal.getTblBitacora().getRowCount(); i++) {
                    reg = new ArrayList();
                    for (int j = 0; j < winPrincipal.getTblBitacora().getColumnCount(); j++) {
                        Object ob = winPrincipal.getTblBitacora().getValueAt(i, j);
                        if ((j == 12 || j == 16) && (ob == null || ob.toString().isEmpty())) {
                            winPrincipal.getTblBitacora().setValueAt("0", i, j);
                            reg.add(winPrincipal.getTblBitacora().getValueAt(i, j));
                        } else if (ob == null || ob.toString().isEmpty()) {
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
                winPrincipal.getLblTurno().setText("");
                winPrincipal.getCmbTema().setSelectedIndex(0);
                winPrincipal.getCmbTema().setEnabled(false);
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

    public void eliminarRegistroTiempoActualizar(Principal winPrincipal) throws Exception {

        int horaInicial = Integer.parseInt(winPrincipal.getTblBitacora().getValueAt(0, 2).toString());

        int horaFinal = Integer.parseInt(winPrincipal.getTblBitacora().getValueAt(
                winPrincipal.getTblBitacora().getRowCount() - 1, 2).toString());

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
                        if ((j == 12 || j == 16) && (ob == null || ob.toString().isEmpty())) {
                            winPrincipal.getTblBitacora().setValueAt("0", i, j);
                            reg.add(winPrincipal.getTblBitacora().getValueAt(i, j));
                        } else if (ob == null || ob.toString().isEmpty()) {
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
                    Object ob = winPrincipal.getTblBitacora().getValueAt(contadorFila, j);
                    if ((j == 12 || j == 16) && (ob == null || ob.toString().isEmpty())) {
                        winPrincipal.getTblBitacora().setValueAt("0", contadorFila, j);
                        reg.add(winPrincipal.getTblBitacora().getValueAt(contadorFila, j));
                    } else if (ob == null || ob.toString().isEmpty()) {
                        winPrincipal.getTblBitacora().setValueAt("", contadorFila, j);
                        reg.add(winPrincipal.getTblBitacora().getValueAt(contadorFila, j));
                    } else {
                        reg.add(winPrincipal.getTblBitacora().getValueAt(contadorFila, j));
                    }
                    //reg.add(winPrincipal.getTblBitacora().getValueAt(contadorFila, j));
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
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(1);
            XSSFPivotTable pivot = sheet.getPivotTables().get(0);
            pivot.addReportFilter(1);
            pivot.addRowLabel(1);
            file.close();

            FileOutputStream outFile = new FileOutputStream(new File(EXCEL_LOCATION));
            workbook.write(outFile);
            outFile.close();
            Process p = Runtime.getRuntime().exec("C:\\Program Files (x86)\\Microsoft Office\\Office16\\EXCEL.EXE " + EXCEL_LOCATION);
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

    private ArrayList generarReporteProduccionActual(Principal winPrincipal) {
        ArrayList produccion = new ArrayList();
        try {
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
                            comparaRegistro = (Object[]) bitacoraActual.get(i - 1);
                            System.out.println("productionArrSizeGetiMinus1> " + produccion.size());
                            if (registro[11].equals(comparaRegistro[11])) { //Compara noParte
                                //Agrega primer registro
                                produccion.remove(produccion.size() - 1);
                                System.out.println("productionArrSizeMinusOne> " + produccion.size());
                                registro[12]
                                        = String.valueOf(
                                                Integer.parseInt(registro[12].toString())
                                                + Integer.parseInt(comparaRegistro[12].toString())
                                        );
                                produccion.add(registro);
                                System.out.println("productionArrSizePlusOne> " + produccion.size());
                            } else {
                                //Nuevo noParte
                                for (int j = 0; j < produccion.size(); j++) {
                                    comparaRegistro = (Object[]) produccion.get(j);
                                    if (registro[11].equals(comparaRegistro[11])
                                            && registro[2].equals(comparaRegistro[2])) {
                                        produccion.remove(j);
                                        registro[12]
                                                = String.valueOf(
                                                        Integer.parseInt(registro[12].toString())
                                                        + Integer.parseInt(comparaRegistro[12].toString())
                                                );
                                        break;
                                    }
                                }
                                produccion.add(registro);
                            }
                        } else {
                            //Nueva hora
                            indicadorHora = Integer.parseInt(registro[2].toString());
                            produccion.add(registro);
                        }
                    }
                    //break;
                }
                //}
            }

//            if (!produccion.isEmpty()) { //Listamos el array
//                Object[] produccionReg;
//                System.out.println("<><><><><>PRODUCCION<><><><><>");
//                for (int i = 0; i < produccion.size(); i++) {
//                    produccionReg = (Object[]) produccion.get(i);
//                    for (int j = 0; j < produccionReg.length; j++) {
//                        System.out.println(j + "." + produccionReg[j].toString());
//                    }
//                }
//                System.out.println("<><><><><><><><><><><><><><><>");
//            }
        } catch (Exception e) {
            System.out.println("<><>reporteProduccionActual<><> " + e);
        }
        return produccion;
    }

    private ArrayList hourlyProduccionActual(Principal winPrincipal) {
        ArrayList produccionHourly = new ArrayList();

        try {
            Object[] registro;
            Object[] registroHourly;

            ArrayList produccionActualArr = generarReporteProduccionActual(winPrincipal);

            if (!produccionActualArr.isEmpty()) {
                for (int i = 0; i < produccionActualArr.size(); i++) {
                    registro = (Object[]) produccionActualArr.get(i);

                    registroHourly = new Object[3];
                    registroHourly[0] = registro[2];//hora
                    registroHourly[1] = registro[12];//cantidadProducida
                    registroHourly[2] = registro[11].toString() + "/" + registro[16].toString();//noParte/TC

                    produccionHourly.add(registroHourly);
                }
            }

            if (!produccionHourly.isEmpty()) { //Listamos el array
                Object[] produccionHourlyReg;
                System.out.println("<><><><><>PRODUCCION<><><><><>");
                for (int i = 0; i < produccionHourly.size(); i++) {
                    produccionHourlyReg = (Object[]) produccionHourly.get(i);
                    for (int j = 0; j < produccionHourlyReg.length; j++) {
                        System.out.println(j + "." + produccionHourlyReg[j].toString());
                    }
                }
                System.out.println("<><><><><><><><><><><><><><><>");
            }

        } catch (Exception e) {
            System.out.println("hourlyProduccionActual: " + e);
        }
        return produccionHourly;
    }

    private ArrayList returnHourlyProduccionArray(ArrayList hourlyProduccionActual) {
        ArrayList produccionArr = new ArrayList();
        ArrayList produccionAux = hourlyProduccionActual;

        if (hourlyProduccionActual.isEmpty()) {
            for (int i = 0; i < 24; i++) {
                Object[] produccionReg = new Object[3];
                produccionReg[0] = i;//hora
                produccionReg[1] = "0";//produccion
                produccionReg[2] = "-";//noParte/TC
                produccionArr.add(produccionReg);
            }
        } else {
            Object[] prodAux;
            Object[] prod;
            for (int j = 0; j < 24; j++) {
                Object[] produccionReg = new Object[3];
                produccionReg[0] = j;//hora
                produccionReg[1] = "0";//produccion
                produccionReg[2] = "-";//noParte/TC
                produccionArr.add(produccionReg);
            }
            for (int i = 0; i < produccionArr.size(); i++) {
                prod = (Object[]) produccionArr.get(i);
                for (int j = 0; j < produccionAux.size(); j++) {
                    prodAux = (Object[]) produccionAux.get(j);
                    if (prodAux[0].equals(prod[0])) {
                        prod = prodAux;
                        produccionArr.set(i, prod);
                    }
                }
            }
        }
        return produccionArr;
    }

    private ArrayList generarReporteCalidadActual(Principal winPrincipal) {
        ArrayList calidad = new ArrayList();
        try {
            Object[] registro;
            Object[] comparaRegistro;

            ArrayList bitacoraActual
                    = getBitacoraActual(
                            horarioTurno(winPrincipal.getCmbHora()),
                            winPrincipal
                    );
            //El funcionamiento es similar a produccion, solo varian los datos que se piden        
            int indicadorHora = 0;

            for (int i = 0; i < bitacoraActual.size(); i++) {
                registro = (Object[]) bitacoraActual.get(i);

                if (registro[6].equals("Calidad")) {
                    if (calidad.isEmpty()) { //Agrega primer registro
                        indicadorHora = Integer.parseInt(registro[2].toString());
                        calidad.add(registro);
                    } else {
                        if (Integer.parseInt(registro[2].toString()) == indicadorHora) {
                            comparaRegistro = (Object[]) bitacoraActual.get(i - 1);

                            if (registro[7].equals(comparaRegistro[7])) { //Compara operacion
                                if (registro[8].equals(comparaRegistro[8])) { //Compara area
                                    if (registro[9].equals(comparaRegistro[9])) { //Compara problema
                                        if (registro[11].equals(comparaRegistro[11])) { //Compara noParte
                                            //Agrega registro igual
                                            calidad.remove(calidad.size() - 1);
                                            registro[5]
                                                    = Integer.parseInt(registro[5].toString())
                                                    + Integer.parseInt(comparaRegistro[5].toString());
                                            registro[14]
                                                    = Integer.parseInt(registro[14].toString())
                                                    + Integer.parseInt(comparaRegistro[14].toString());
                                            calidad.add(registro);
                                        } else {
                                            //Nuevo noParte
                                            for (int j = 0; j < calidad.size(); j++) {
                                                comparaRegistro = (Object[]) calidad.get(j);
                                                if (registro[2].equals(comparaRegistro[2])
                                                        && registro[7].equals(comparaRegistro[7])
                                                        && registro[8].equals(comparaRegistro[8])
                                                        && registro[9].equals(comparaRegistro[9])
                                                        && registro[11].equals(comparaRegistro[11])) {
                                                    calidad.remove(j);
                                                    registro[5]
                                                            = Integer.parseInt(registro[5].toString())
                                                            + Integer.parseInt(comparaRegistro[5].toString());
                                                    registro[14]
                                                            = Integer.parseInt(registro[14].toString())
                                                            + Integer.parseInt(comparaRegistro[14].toString());
                                                    break;
                                                }
                                            }
                                            calidad.add(registro);
                                        }
                                    } else {
                                        //Nuevo problema
                                        for (int j = 0; j < calidad.size(); j++) {
                                            comparaRegistro = (Object[]) calidad.get(j);
                                            if (registro[2].equals(comparaRegistro[2])
                                                    && registro[7].equals(comparaRegistro[7])
                                                    && registro[8].equals(comparaRegistro[8])
                                                    && registro[9].equals(comparaRegistro[9])
                                                    && registro[11].equals(comparaRegistro[11])) {
                                                calidad.remove(j);
                                                registro[5]
                                                        = Integer.parseInt(registro[5].toString())
                                                        + Integer.parseInt(comparaRegistro[5].toString());
                                                registro[14]
                                                        = Integer.parseInt(registro[14].toString())
                                                        + Integer.parseInt(comparaRegistro[14].toString());
                                                break;
                                            }
                                        }
                                        calidad.add(registro);
                                    }
                                } else {
                                    //Nueva area
                                    for (int j = 0; j < calidad.size(); j++) {
                                        comparaRegistro = (Object[]) calidad.get(j);
                                        if (registro[2].equals(comparaRegistro[2])
                                                && registro[7].equals(comparaRegistro[7])
                                                && registro[8].equals(comparaRegistro[8])
                                                && registro[9].equals(comparaRegistro[9])
                                                && registro[11].equals(comparaRegistro[11])) {
                                            calidad.remove(j);
                                            registro[5]
                                                    = Integer.parseInt(registro[5].toString())
                                                    + Integer.parseInt(comparaRegistro[5].toString());
                                            registro[14]
                                                    = Integer.parseInt(registro[14].toString())
                                                    + Integer.parseInt(comparaRegistro[14].toString());
                                            break;
                                        }
                                    }
                                    calidad.add(registro);
                                }
                            } else {
                                //Nueva operacion
                                for (int j = 0; j < calidad.size(); j++) {
                                    comparaRegistro = (Object[]) calidad.get(j);
                                    if (registro[2].equals(comparaRegistro[2])
                                            && registro[7].equals(comparaRegistro[7])
                                            && registro[8].equals(comparaRegistro[8])
                                            && registro[9].equals(comparaRegistro[9])
                                            && registro[11].equals(comparaRegistro[11])) {
                                        calidad.remove(j);
                                        registro[5]
                                                = Integer.parseInt(registro[5].toString())
                                                + Integer.parseInt(comparaRegistro[5].toString());
                                        registro[14]
                                                = Integer.parseInt(registro[14].toString())
                                                + Integer.parseInt(comparaRegistro[14].toString());
                                        break;
                                    }
                                }
                                calidad.add(registro);
                            }
                        } else {
                            //Nueva hora
                            indicadorHora = Integer.parseInt(registro[2].toString());
                            calidad.add(registro);
                        }
                    }
                }
            }

            if (!calidad.isEmpty()) { //Listamos el array
                Object[] calidadReg;
                System.out.println("<><><><><>CALIDAD<><><><><>");
                for (int i = 0; i < calidad.size(); i++) {
                    calidadReg = (Object[]) calidad.get(i);
                    for (int j = 0; j < calidadReg.length; j++) {
                        System.out.println(j + "." + calidadReg[j].toString());
                    }
                }
                System.out.println("<><><><><><><><><><><><><><>");
            }
        } catch (Exception e) {
            System.out.println("<><>reporteCalidadActual<><> " + e);
        }
        return calidad;
    }

    private ArrayList hourlyCalidadActual(Principal winPrincipal) {
        ArrayList calidadHourly = new ArrayList();

        try {
            Object[] registro;
            Object[] registroHourly;

            ArrayList calidadActualArr = generarReporteCalidadActual(winPrincipal);

            if (!calidadActualArr.isEmpty()) {
                for (int i = 0; i < calidadActualArr.size(); i++) {
                    registro = (Object[]) calidadActualArr.get(i);

                    registroHourly = new Object[4];
                    registroHourly[0] = registro[2];//hora
                    registroHourly[1] = registro[7];//operacion
                    registroHourly[2] = registro[9];//problema
                    registroHourly[3] = registro[14];//scrapProducido

                    calidadHourly.add(registroHourly);
                }
            }

            if (!calidadHourly.isEmpty()) { //Listamos el array
                Object[] calidadHourlyReg;
                System.out.println("<><><><><>CALIDAD<><><><><>");
                for (int i = 0; i < calidadHourly.size(); i++) {
                    calidadHourlyReg = (Object[]) calidadHourly.get(i);
                    for (int j = 0; j < calidadHourlyReg.length; j++) {
                        System.out.println(j + "." + calidadHourlyReg[j].toString());
                    }
                }
                System.out.println("<><><><><><><><><><><><><><>");
            }

        } catch (Exception e) {
            System.out.println("hourlyProduccionActual: " + e);
        }
        return calidadHourly;
    }

    private ArrayList returnHourlyCalidadArray(ArrayList hourlyCalidadActual) {
        ArrayList calidadArr = new ArrayList();
        ArrayList calidadArrAux = hourlyCalidadActual;

        if (hourlyCalidadActual.isEmpty()) {
            for (int i = 0; i < 24; i++) {
                Object[] calidadReg = new Object[4];
                calidadReg[0] = i;//hora
                calidadReg[1] = "";//operacion
                calidadReg[2] = "";//problema
                calidadReg[3] = 0;//scrap
                calidadArr.add(calidadReg);
            }
        } else {
            Object[] calidadRegAux;
            Object[] calidad;
            for (int j = 0; j < 24; j++) {
                Object[] calidadReg = new Object[4];
                calidadReg[0] = j;//hora
                calidadReg[1] = "";//operacion
                calidadReg[2] = "";//problema
                calidadReg[3] = 0;//scrap
                calidadArr.add(calidadReg);
            }
            for (int k = 0; k < calidadArr.size(); k++) {
                calidad = (Object[]) calidadArr.get(k);
                for (int l = 0; l < calidadArrAux.size(); l++) {
                    calidadRegAux = (Object[]) calidadArrAux.get(l);
                    if (calidadRegAux[0].equals(calidad[0])) {
                        calidad[0] = calidadRegAux[0];
                        if (!(calidad[1] == null)) { //Operacion no esta vacia
                            calidad[1]
                                = calidad[1].toString() + "\n" + calidadRegAux[1].toString();
                        } else {
                            calidad[1] = calidadRegAux[1];
                        }
                        if (!(calidad[2] == null)) { //Problema no esta vacio
                            calidad[2]
                                = calidad[2].toString() + "\n" + calidadRegAux[2].toString();
                        } else {
                            calidad[2] = calidadRegAux[2];
                        }
                        if (!(calidad[3] == null)) {
                            calidad[3] = String.valueOf(
                                    Integer.parseInt(calidad[3].toString())
                                    + Integer.parseInt(calidadRegAux[3].toString())
                            );
                        } else {
                            calidad[3] = calidadRegAux[3];
                        }//realizamos la suma de scrap
                        //calidad = calidadRegAux;
                        calidadArr.set(k, calidad);
                    }
                }
            }
        }
        return calidadArr;
    }

    private ArrayList generarReporteTecnicasActual(Principal winPrincipal) {
        ArrayList tecnicas = new ArrayList();
        try {
            Object[] registro;
            Object[] comparaRegistro;

            ArrayList bitacoraActual
                    = getBitacoraActual(
                            horarioTurno(winPrincipal.getCmbHora()),
                            winPrincipal
                    );

            int indicadorHora = 0;

            for (int i = 0; i < bitacoraActual.size(); i++) {
                registro = (Object[]) bitacoraActual.get(i);

                if (registro[6].equals("Tecnicas")) {
                    if (tecnicas.isEmpty()) { //Agrega primer registro
                        indicadorHora = Integer.parseInt(registro[2].toString());
                        tecnicas.add(registro);
                    } else {
                        if (Integer.parseInt(registro[2].toString()) == indicadorHora) {
                            comparaRegistro = (Object[]) bitacoraActual.get(i - 1);

                            if (registro[7].equals(comparaRegistro[7])) { //Compara operacion
                                if (registro[8].equals(comparaRegistro[8])) { //Compara area
                                    if (registro[9].equals(comparaRegistro[9])) { //Compara problema
                                        if (registro[11].equals(comparaRegistro[11])) { //Compara noParte
                                            //Agrega registro igual
                                            tecnicas.remove(tecnicas.size() - 1);
                                            registro[5]
                                                    = Integer.parseInt(registro[5].toString())
                                                    + Integer.parseInt(comparaRegistro[5].toString());
                                            registro[14]
                                                    = Integer.parseInt(registro[14].toString())
                                                    + Integer.parseInt(comparaRegistro[14].toString());
                                            tecnicas.add(registro);
                                        } else {
                                            //Nuevo noParte
                                            for (int j = 0; j < tecnicas.size(); j++) {
                                                comparaRegistro = (Object[]) tecnicas.get(j);
                                                if (registro[2].equals(comparaRegistro[2])
                                                        && registro[7].equals(comparaRegistro[7])
                                                        && registro[8].equals(comparaRegistro[8])
                                                        && registro[9].equals(comparaRegistro[9])
                                                        && registro[11].equals(comparaRegistro[11])) {
                                                    tecnicas.remove(j);
                                                    registro[5]
                                                            = Integer.parseInt(registro[5].toString())
                                                            + Integer.parseInt(comparaRegistro[5].toString());
                                                    registro[14]
                                                            = Integer.parseInt(registro[14].toString())
                                                            + Integer.parseInt(comparaRegistro[14].toString());
                                                    break;
                                                }
                                            }
                                            tecnicas.add(registro);
                                        }
                                    } else {
                                        //Nuevo problema
                                        for (int j = 0; j < tecnicas.size(); j++) {
                                            comparaRegistro = (Object[]) tecnicas.get(j);
                                            if (registro[2].equals(comparaRegistro[2])
                                                    && registro[7].equals(comparaRegistro[7])
                                                    && registro[8].equals(comparaRegistro[8])
                                                    && registro[9].equals(comparaRegistro[9])
                                                    && registro[11].equals(comparaRegistro[11])) {
                                                tecnicas.remove(j);
                                                registro[5]
                                                        = Integer.parseInt(registro[5].toString())
                                                        + Integer.parseInt(comparaRegistro[5].toString());
                                                registro[14]
                                                        = Integer.parseInt(registro[14].toString())
                                                        + Integer.parseInt(comparaRegistro[14].toString());
                                                break;
                                            }
                                        }
                                        tecnicas.add(registro);
                                    }
                                } else {
                                    //Nueva area
                                    for (int j = 0; j < tecnicas.size(); j++) {
                                        comparaRegistro = (Object[]) tecnicas.get(j);
                                        if (registro[2].equals(comparaRegistro[2])
                                                && registro[7].equals(comparaRegistro[7])
                                                && registro[8].equals(comparaRegistro[8])
                                                && registro[9].equals(comparaRegistro[9])
                                                && registro[11].equals(comparaRegistro[11])) {
                                            tecnicas.remove(j);
                                            registro[5]
                                                    = Integer.parseInt(registro[5].toString())
                                                    + Integer.parseInt(comparaRegistro[5].toString());
                                            registro[14]
                                                    = Integer.parseInt(registro[14].toString())
                                                    + Integer.parseInt(comparaRegistro[14].toString());
                                            break;
                                        }
                                    }
                                    tecnicas.add(registro);
                                }
                            } else {
                                //Nueva operacion
                                for (int j = 0; j < tecnicas.size(); j++) {
                                    comparaRegistro = (Object[]) tecnicas.get(j);
                                    if (registro[2].equals(comparaRegistro[2])
                                            && registro[7].equals(comparaRegistro[7])
                                            && registro[8].equals(comparaRegistro[8])
                                            && registro[9].equals(comparaRegistro[9])
                                            && registro[11].equals(comparaRegistro[11])) {
                                        tecnicas.remove(j);
                                        registro[5]
                                                = Integer.parseInt(registro[5].toString())
                                                + Integer.parseInt(comparaRegistro[5].toString());
                                        registro[14]
                                                = Integer.parseInt(registro[14].toString())
                                                + Integer.parseInt(comparaRegistro[14].toString());
                                        break;
                                    }
                                }
                                tecnicas.add(registro);
                            }
                        } else {
                            //Nueva hora
                            indicadorHora = Integer.parseInt(registro[2].toString());
                            tecnicas.add(registro);
                        }
                    }
                }
            }

//            if (!tecnicas.isEmpty()) { //Listamos el array
//                Object[] tecnicasReg;
//                System.out.println("<><><><><>TECNICAS<><><><><>");
//                for (int i = 0; i < tecnicas.size(); i++) {
//                    tecnicasReg = (Object[]) tecnicas.get(i);
//                    for (int j = 0; j < tecnicasReg.length; j++) {
//                        System.out.println(j + "." + tecnicasReg[j].toString());
//                    }
//                }
//                System.out.println("<><><><><><><><><><><><><><>");
//            }
        } catch (Exception e) {
            System.out.println("<><>reporteTecnicasActual<><> " + e);
        }
        return tecnicas;
    }

    private ArrayList hourlyTecnicasActual(Principal winPrincipal) {
        ArrayList tecnicasHourly = new ArrayList();

        try {
            Object[] registro;
            Object[] registroHourly;

            ArrayList tecnicasActualArr = generarReporteTecnicasActual(winPrincipal);

            if (!tecnicasActualArr.isEmpty()) {
                for (int i = 0; i < tecnicasActualArr.size(); i++) {
                    registro = (Object[]) tecnicasActualArr.get(i);

                    registroHourly = new Object[5];
                    registroHourly[0] = registro[2];//hora
                    registroHourly[1] = registro[5];//duracion
                    registroHourly[2] = registro[7];//operacion
                    registroHourly[3] = registro[9];//problema
                    registroHourly[4] = registro[14];//scrapProducido

                    tecnicasHourly.add(registroHourly);
                }
            }

            if (!tecnicasHourly.isEmpty()) { //Listamos el array
                Object[] tecnicasHourlyReg;
                System.out.println("<><><><><>TECNICAS<><><><><>");
                for (int i = 0; i < tecnicasHourly.size(); i++) {
                    tecnicasHourlyReg = (Object[]) tecnicasHourly.get(i);
                    for (int j = 0; j < tecnicasHourlyReg.length; j++) {
                        System.out.println(j + "." + tecnicasHourlyReg[j].toString());
                    }
                }
                System.out.println("<><><><><><><><><><><><><><>");
            }

        } catch (Exception e) {
            System.out.println("hourlyTecnicasActual: " + e);
        }
        return tecnicasHourly;
    }

    private ArrayList returnHourlyTecnicasArray(ArrayList hourlyTecnicasActual) {
        ArrayList tecnicasArr = new ArrayList();
        ArrayList tecnicasArrAux = hourlyTecnicasActual;

        if (hourlyTecnicasActual.isEmpty()) {
            for (int i = 0; i < 24; i++) {
                Object[] tecnicasReg = new Object[5];
                tecnicasReg[0] = i;//hora
                tecnicasReg[1] = 0;//duracion
                tecnicasReg[2] = "";//operacion
                tecnicasReg[3] = "";//problema
                tecnicasReg[4] = 0;//scrap
                tecnicasArr.add(tecnicasReg);
            }
        } else {
            Object[] tecnicasRegAux;
            Object[] tecnicas;
            for (int j = 0; j < 24; j++) {
                Object[] tecnicasReg = new Object[5];
                tecnicasReg[0] = j;//hora
                tecnicasReg[1] = 0;//duracion
                tecnicasReg[2] = "";//operacion
                tecnicasReg[3] = "";//problema
                tecnicasReg[4] = 0;//scrap
                tecnicasArr.add(tecnicasReg);
            }
            for (int k = 0; k < tecnicasArr.size(); k++) {
                tecnicas = (Object[]) tecnicasArr.get(k);
                for (int l = 0; l < tecnicasArrAux.size(); l++) {
                    tecnicasRegAux = (Object[]) tecnicasArrAux.get(l);
                    if (tecnicasRegAux[0].equals(tecnicas[0])) {
                        tecnicas[0] = tecnicasRegAux[0];
                        if (!(tecnicas[1] == null)) { //duracion no esta vacio
                            tecnicas[1] = String.valueOf(
                                    Integer.parseInt(tecnicas[1].toString())
                                    + Integer.parseInt(tecnicasRegAux[1].toString())
                            );
                        } else {
                            tecnicas[1] = tecnicasRegAux[1];
                        }
                        if (!(tecnicas[2] == null)) { //operacion no esta vacia
                            tecnicas[2]
                                    = tecnicas[2].toString() + "\n" + tecnicasRegAux[2].toString();
                        } else {
                            tecnicas[2] = tecnicasRegAux[2];
                        }
                        if (!(tecnicas[3] == null)) { //problema no esta vacio
                            tecnicas[3]
                                    = tecnicas[3].toString() + "\n" + tecnicasRegAux[3].toString();
                        } else {
                            tecnicas[3] = tecnicasRegAux[3];
                        }
                        if (!(tecnicas[4] == null)) { //scrap no esta vacio
                            tecnicas[4] = String.valueOf(
                                    Integer.parseInt(tecnicas[4].toString())
                                    + Integer.parseInt(tecnicasRegAux[4].toString())
                            );
                        } else {
                            tecnicas[4] = tecnicasRegAux[4];
                        }
                        tecnicasArr.set(k, tecnicas);
                    }
                }
            }
        }
        return tecnicasArr;
    }

    private ArrayList generarReporteOrganizacionalActual(Principal winPrincipal) {
        ArrayList organizacional = new ArrayList();
        try {
            Object[] registro;
            Object[] comparaRegistro;

            ArrayList bitacoraActual
                    = getBitacoraActual(
                            horarioTurno(winPrincipal.getCmbHora()),
                            winPrincipal
                    );

            int indicadorHora = 0;

            for (int i = 0; i < bitacoraActual.size(); i++) {
                registro = (Object[]) bitacoraActual.get(i);

                if (registro[6].equals("Organizacionales")) {
                    if (organizacional.isEmpty()) { //Agrega primer registro
                        indicadorHora = Integer.parseInt(registro[2].toString());
                        organizacional.add(registro);
                    } else {
                        if (Integer.parseInt(registro[2].toString()) == indicadorHora) {
                            comparaRegistro = (Object[]) bitacoraActual.get(i - 1);

                            if (registro[8].equals(comparaRegistro[8])) { //Compara area
                                if (registro[9].equals(comparaRegistro[9])) { //Compara problema
                                    if (registro[11].equals(comparaRegistro[11])) { //Compara noParte
                                        //Agrega registro igual
                                        organizacional.remove(organizacional.size() - 1);
                                        registro[5]
                                                = Integer.parseInt(registro[5].toString())
                                                + Integer.parseInt(comparaRegistro[5].toString());
                                        if (!(registro[15].equals("") && comparaRegistro[15].equals(""))) {
                                            registro[15]
                                                    = Integer.parseInt(registro[15].toString())
                                                    + Integer.parseInt(comparaRegistro[15].toString());
                                        }
                                        organizacional.add(registro);
                                    } else {
                                        //Nuevo noParte
                                        for (int j = 0; j < organizacional.size(); j++) {
                                            comparaRegistro = (Object[]) organizacional.get(j);
                                            if (registro[2].equals(comparaRegistro[2])
                                                    && registro[7].equals(comparaRegistro[7])
                                                    && registro[8].equals(comparaRegistro[8])
                                                    && registro[9].equals(comparaRegistro[9])
                                                    && registro[11].equals(comparaRegistro[11])) {
                                                organizacional.remove(j);
                                                registro[5]
                                                        = Integer.parseInt(registro[5].toString())
                                                        + Integer.parseInt(comparaRegistro[5].toString());
                                                if (!(registro[15].equals("") && comparaRegistro[15].equals(""))) {
                                                    registro[15]
                                                            = Integer.parseInt(registro[15].toString())
                                                            + Integer.parseInt(comparaRegistro[15].toString());
                                                }
                                                break;
                                            }
                                        }
                                        organizacional.add(registro);
                                    }
                                } else {
                                    //Nuevo problema
                                    for (int j = 0; j < organizacional.size(); j++) {
                                        comparaRegistro = (Object[]) organizacional.get(j);
                                        if (registro[2].equals(comparaRegistro[2])
                                                && registro[7].equals(comparaRegistro[7])
                                                && registro[8].equals(comparaRegistro[8])
                                                && registro[9].equals(comparaRegistro[9])
                                                && registro[11].equals(comparaRegistro[11])) {
                                            organizacional.remove(j);
                                            registro[5]
                                                    = Integer.parseInt(registro[5].toString())
                                                    + Integer.parseInt(comparaRegistro[5].toString());
                                            if (!(registro[15].equals("") && comparaRegistro[15].equals(""))) {
                                                registro[15]
                                                        = Integer.parseInt(registro[15].toString())
                                                        + Integer.parseInt(comparaRegistro[15].toString());
                                            }
                                            break;
                                        }
                                    }
                                    organizacional.add(registro);
                                }
                            } else {
                                //Nueva area
                                for (int j = 0; j < organizacional.size(); j++) {
                                    comparaRegistro = (Object[]) organizacional.get(j);
                                    if (registro[2].equals(comparaRegistro[2])
                                            && registro[7].equals(comparaRegistro[7])
                                            && registro[8].equals(comparaRegistro[8])
                                            && registro[9].equals(comparaRegistro[9])
                                            && registro[11].equals(comparaRegistro[11])) {
                                        organizacional.remove(j);
                                        registro[5]
                                                = Integer.parseInt(registro[5].toString())
                                                + Integer.parseInt(comparaRegistro[5].toString());
                                        if (!(registro[15].equals("") && comparaRegistro[15].equals(""))) {
                                            registro[15]
                                                    = Integer.parseInt(registro[15].toString())
                                                    + Integer.parseInt(comparaRegistro[15].toString());
                                        }
                                        break;
                                    }
                                }
                                organizacional.add(registro);
                            }
                        } else {
                            //Nueva hora
                            indicadorHora = Integer.parseInt(registro[2].toString());
                            organizacional.add(registro);
                        }
                    }
                }
            }

//            if (!organizacional.isEmpty()) { //Listamos el array
//                Object[] organizacionalReg;
//                System.out.println("<><><><><>ORGANIZACIONAL<><><><><>");
//                for (int i = 0; i < organizacional.size(); i++) {
//                    organizacionalReg = (Object[]) organizacional.get(i);
//                    for (int j = 0; j < organizacionalReg.length; j++) {
//                        System.out.println(j + "." + organizacionalReg[j].toString());
//                    }
//                }
//                System.out.println("<><><><><><><><><><><><><><><><><>");
//            }
        } catch (Exception e) {
            System.out.println("<><>reporteOrganizacionalActual<><> " + e);
        }
        return organizacional;
    }

    private ArrayList hourlyOrganizacionalActual(Principal winPrincipal) {
        ArrayList organizacionalHourly = new ArrayList();

        try {
            Object[] registro;
            Object[] registroHourly;

            ArrayList organizacionalActualArr = generarReporteOrganizacionalActual(winPrincipal);

            if (!organizacionalActualArr.isEmpty()) {
                for (int i = 0; i < organizacionalActualArr.size(); i++) {
                    registro = (Object[]) organizacionalActualArr.get(i);

                    registroHourly = new Object[5];
                    registroHourly[0] = registro[2];//hora
                    registroHourly[1] = registro[5];//duracion
                    registroHourly[2] = registro[7];//operacion
                    registroHourly[3] = registro[9];//problema
                    registroHourly[4] = registro[14];//scrapProducido

                    organizacionalHourly.add(registroHourly);
                }
            }

            if (!organizacionalHourly.isEmpty()) { //Listamos el array
                Object[] organizacionalHourlyReg;
                System.out.println("<><><><><>ORGANIZACIONAL<><><><><>");
                for (int i = 0; i < organizacionalHourly.size(); i++) {
                    organizacionalHourlyReg = (Object[]) organizacionalHourly.get(i);
                    for (int j = 0; j < organizacionalHourlyReg.length; j++) {
                        System.out.println(j + "." + organizacionalHourlyReg[j].toString());
                    }
                }
                System.out.println("<><><><><><><><><><><><><><><><><>");
            }

        } catch (Exception e) {
            System.out.println("hourlyTecnicasActual: " + e);
        }
        return organizacionalHourly;
    }

    private ArrayList returnHourlyOrganizacionalArray(ArrayList hourlyOrganizacionalActual) {
        ArrayList organizacionalArr = new ArrayList();
        ArrayList organizacionalArrAux = hourlyOrganizacionalActual;

        if (hourlyOrganizacionalActual.isEmpty()) {
            for (int i = 0; i < 24; i++) {
                Object[] organizacionalReg = new Object[5];
                organizacionalReg[0] = i;//hora
                organizacionalReg[1] = 0;//duracion
                organizacionalReg[2] = "";//operacion
                organizacionalReg[3] = "";//problema
                organizacionalReg[4] = 0;//scrap
                organizacionalArr.add(organizacionalReg);
            }
        } else {
            Object[] organizacionalRegAux;
            Object[] organizacional;
            for (int j = 0; j < 24; j++) {
                Object[] organizacionalReg = new Object[5];
                organizacionalReg[0] = j;//hora
                organizacionalReg[1] = 0;//duracion
                organizacionalReg[2] = "";//operacion
                organizacionalReg[3] = "";//problema
                organizacionalReg[4] = 0;//scrap
                organizacionalArr.add(organizacionalReg);
            }
            for (int k = 0; k < organizacionalArr.size(); k++) {
                organizacional = (Object[]) organizacionalArr.get(k);
                for (int l = 0; l < organizacionalArrAux.size(); l++) {
                    organizacionalRegAux = (Object[]) organizacionalArrAux.get(l);
                    if (organizacionalRegAux[0].equals(organizacional[0])) {
                        organizacional[0] = organizacionalRegAux[0];
                        if (!(organizacional[1] == null)) { //duracion no esta vacio
                            organizacional[1] = String.valueOf(
                                    Integer.parseInt(organizacional[1].toString())
                                    + Integer.parseInt(organizacionalRegAux[1].toString())
                            );
                        } else {
                            organizacional[1] = organizacionalRegAux[1];
                        }
                        if (!(organizacional[2] == null)) { //operacion no esta vacia
                            organizacional[2]
                                    = organizacional[2].toString() + "\n" + organizacionalRegAux[2].toString();
                        } else {
                            organizacional[2] = organizacionalRegAux[2];
                        }
                        if (!(organizacional[3] == null)) { //problema no esta vacio
                            organizacional[3]
                                    = organizacional[3].toString() + "\n" + organizacionalRegAux[3].toString();
                        } else {
                            organizacional[3] = organizacionalRegAux[3];
                        }
                        if (!(organizacional[4] == null)) { //scrap no esta vacio
                            organizacional[4] = String.valueOf(
                                    Integer.parseInt(organizacional[4].toString())
                                    + Integer.parseInt(organizacionalRegAux[4].toString())
                            );
                        } else {
                            organizacional[4] = organizacionalRegAux[4];
                        }
                        organizacionalArr.set(k, organizacional);
                    }
                }
            }
        }
        return organizacionalArr;
    }

    private ArrayList generarReporteCambiosActual(Principal winPrincipal) {
        ArrayList cambios = new ArrayList();
        try {
            Object[] registro;
            Object[] comparaRegistro;

            ArrayList bitacoraActual
                    = getBitacoraActual(
                            horarioTurno(winPrincipal.getCmbHora()),
                            winPrincipal
                    );

            int indicadorHora = 0;

            for (int i = 0; i < bitacoraActual.size(); i++) {
                registro = (Object[]) bitacoraActual.get(i);

                if (registro[6].equals("Cambio de Modelo")) {
                    if (cambios.isEmpty()) { //Agrega primer registro
                        indicadorHora = Integer.parseInt(registro[2].toString());
                        cambios.add(registro);
                    } else {
                        if (Integer.parseInt(registro[2].toString()) == indicadorHora) {
                            comparaRegistro = (Object[]) bitacoraActual.get(i - 1);

                            if (registro[7].equals(comparaRegistro[7])) { //Compara operacion
                                if (registro[8].equals(comparaRegistro[8])) { //Compara area
                                    if (registro[9].equals(comparaRegistro[9])) { //Compara problema
                                        //Agrega registro igual
                                        cambios.remove(cambios.size() - 1);
                                        registro[5]
                                                = Integer.parseInt(registro[5].toString())
                                                + Integer.parseInt(comparaRegistro[5].toString());
                                        registro[14]
                                                = Integer.parseInt(registro[14].toString())
                                                + Integer.parseInt(comparaRegistro[14].toString());
                                        cambios.add(registro);
                                    } else {
                                        //Nuevo problema
                                        for (int j = 0; j < cambios.size(); j++) {
                                            comparaRegistro = (Object[]) cambios.get(j);
                                            if (registro[2].equals(comparaRegistro[2])
                                                    && registro[7].equals(comparaRegistro[7])
                                                    && registro[8].equals(comparaRegistro[8])
                                                    && registro[9].equals(comparaRegistro[9])
                                                    && registro[11].equals(comparaRegistro[11])) {
                                                cambios.remove(j);
                                                registro[5]
                                                        = Integer.parseInt(registro[5].toString())
                                                        + Integer.parseInt(comparaRegistro[5].toString());
                                                registro[14]
                                                        = Integer.parseInt(registro[14].toString())
                                                        + Integer.parseInt(comparaRegistro[14].toString());
                                                break;
                                            }
                                        }
                                        cambios.add(registro);
                                    }
                                } else {
                                    //Nueva area
                                    for (int j = 0; j < cambios.size(); j++) {
                                        comparaRegistro = (Object[]) cambios.get(j);
                                        if (registro[2].equals(comparaRegistro[2])
                                                && registro[7].equals(comparaRegistro[7])
                                                && registro[8].equals(comparaRegistro[8])
                                                && registro[9].equals(comparaRegistro[9])
                                                && registro[11].equals(comparaRegistro[11])) {
                                            cambios.remove(j);
                                            registro[5]
                                                    = Integer.parseInt(registro[5].toString())
                                                    + Integer.parseInt(comparaRegistro[5].toString());
                                            registro[14]
                                                    = Integer.parseInt(registro[14].toString())
                                                    + Integer.parseInt(comparaRegistro[14].toString());
                                            break;
                                        }
                                    }
                                    cambios.add(registro);
                                }
                            } else {
                                //Nueva operacion
                                for (int j = 0; j < cambios.size(); j++) {
                                    comparaRegistro = (Object[]) cambios.get(j);
                                    if (registro[2].equals(comparaRegistro[2])
                                            && registro[7].equals(comparaRegistro[7])
                                            && registro[8].equals(comparaRegistro[8])
                                            && registro[9].equals(comparaRegistro[9])
                                            && registro[11].equals(comparaRegistro[11])) {
                                        cambios.remove(j);
                                        registro[5]
                                                = Integer.parseInt(registro[5].toString())
                                                + Integer.parseInt(comparaRegistro[5].toString());
                                        registro[14]
                                                = Integer.parseInt(registro[14].toString())
                                                + Integer.parseInt(comparaRegistro[14].toString());
                                        break;
                                    }
                                }
                                cambios.add(registro);
                            }
                        } else {
                            //Nueva hora
                            indicadorHora = Integer.parseInt(registro[2].toString());
                            cambios.add(registro);
                        }
                    }
                }
            }

//            if (!cambios.isEmpty()) { //Listamos el array
//                Object[] cambiosReg;
//                System.out.println("<><><><><>TECNICAS<><><><><>");
//                for (int i = 0; i < cambios.size(); i++) {
//                    cambiosReg = (Object[]) cambios.get(i);
//                    for (int j = 0; j < cambiosReg.length; j++) {
//                        System.out.println(j + "." + cambiosReg[j].toString());
//                    }
//                }
//                System.out.println("<><><><><><><><><><><><><><>");
//            }
        } catch (Exception e) {
            System.out.println("<><>reporteCambiosActual<><> " + e);
        }
        return cambios;
    }

    private ArrayList hourlyCambiosActual(Principal winPrincipal) {
        ArrayList cambiosHourly = new ArrayList();

        try {
            Object[] registro;
            Object[] registroHourly;

            ArrayList cambiosArr = generarReporteCambiosActual(winPrincipal);

            if (!cambiosArr.isEmpty()) {
                for (int i = 0; i < cambiosArr.size(); i++) {
                    registro = (Object[]) cambiosArr.get(i);

                    registroHourly = new Object[5];
                    registroHourly[0] = registro[2];//hora
                    registroHourly[1] = registro[5];//duracion
                    registroHourly[2] = registro[7];//operacion
                    registroHourly[3] = registro[9];//problema
                    registroHourly[4] = registro[14];//scrapProducido

                    cambiosHourly.add(registroHourly);
                }
            }

            if (!cambiosHourly.isEmpty()) { //Listamos el array
                Object[] cambiosHourlyReg;
                System.out.println("<><><><><>CAMBIOS<><><><><>");
                for (int i = 0; i < cambiosHourly.size(); i++) {
                    cambiosHourlyReg = (Object[]) cambiosHourly.get(i);
                    for (int j = 0; j < cambiosHourlyReg.length; j++) {
                        System.out.println(j + "." + cambiosHourlyReg[j].toString());
                    }
                }
                System.out.println("<><><><><><><><><><><><><><>");
            }

        } catch (Exception e) {
            System.out.println("hourlyCambiosActual: " + e);
        }
        return cambiosHourly;
    }

    private ArrayList returnHourlyCambiosArray(ArrayList hourlyCambiosActual) {
        ArrayList cambiosArr = new ArrayList();
        ArrayList cambiosArrAux = hourlyCambiosActual;

        if (hourlyCambiosActual.isEmpty()) {
            for (int i = 0; i < 24; i++) {
                Object[] cambiosReg = new Object[5];
                cambiosReg[0] = i;//hora
                cambiosReg[1] = 0;//duracion
                cambiosReg[2] = "";//operacion
                cambiosReg[3] = "";//problema
                cambiosReg[4] = 0;//scrap
                cambiosArr.add(cambiosReg);
            }
        } else {
            Object[] cambiosRegAux;
            Object[] cambios;
            for (int j = 0; j < 24; j++) {
                Object[] cambiosReg = new Object[5];
                cambiosReg[0] = j;//hora
                cambiosReg[1] = 0;//duracion
                cambiosReg[2] = "";//operacion
                cambiosReg[3] = "";//problema
                cambiosReg[4] = 0;//scrap
                cambiosArr.add(cambiosReg);
            }
            for (int k = 0; k < cambiosArr.size(); k++) {
                cambios = (Object[]) cambiosArr.get(k);
                for (int l = 0; l < cambiosArrAux.size(); l++) {
                    cambiosRegAux = (Object[]) cambiosArrAux.get(l);
                    if (cambiosRegAux[0].equals(cambios[0])) {
                        cambios[0] = cambiosRegAux[0];
                        if (!(cambios[1] == null)) { //duracion no esta vacio
                            cambios[1] = String.valueOf(
                                    Integer.parseInt(cambios[1].toString())
                                    + Integer.parseInt(cambiosRegAux[1].toString())
                            );
                        } else {
                            cambios[1] = cambiosRegAux[1];
                        }
                        if (!(cambios[2] == null)) { //operacion no esta vacia
                            cambios[2]
                                    = cambios[2].toString() + "\n" + cambiosRegAux[2].toString();
                        } else {
                            cambios[2] = cambiosRegAux[2];
                        }
                        if (!(cambios[3] == null)) { //problema no esta vacio
                            cambios[3]
                                    = cambios[3].toString() + "\n" + cambiosRegAux[3].toString();
                        } else {
                            cambios[3] = cambiosRegAux[3];
                        }
                        if (!(cambios[4] == null)) { //scrap no esta vacio
                            cambios[4] = String.valueOf(
                                    Integer.parseInt(cambios[4].toString())
                                    + Integer.parseInt(cambiosRegAux[4].toString())
                            );
                        } else {
                            cambios[4] = cambiosRegAux[4];
                        }
                        cambiosArr.set(k, cambios);
                    }
                }
            }
        }
        return cambiosArr;
    }

    private ArrayList generarReporteTiempoFaltanteActual(Principal winPrincipal) {
        ArrayList tiempoFaltante = new ArrayList();
        try {
            Object[] registro;

            ArrayList bitacoraActual
                    = getBitacoraActual(
                            horarioTurno(winPrincipal.getCmbHora()),
                            winPrincipal
                    );

            int indicadorHora = 0;

            for (int i = 0; i < bitacoraActual.size(); i++) {
                registro = (Object[]) bitacoraActual.get(i);
                if (registro[6].equals("Tiempo Faltante")) {
                    if (tiempoFaltante.isEmpty()) {
                        indicadorHora = Integer.parseInt(registro[2].toString());
                        tiempoFaltante.add(registro);
                    } else {
                        if (!(Integer.parseInt(registro[2].toString()) == indicadorHora)) {
                            indicadorHora = Integer.parseInt(registro[2].toString());
                            tiempoFaltante.add(registro);
                        }
                    }
                }
            }

            if (!tiempoFaltante.isEmpty()) { //Listamos el array
                Object[] tiempoFaltanteReg;
                System.out.println("<><><><><>TIEMPOFALTANTE<><><><><>");
                for (int i = 0; i < tiempoFaltante.size(); i++) {
                    tiempoFaltanteReg = (Object[]) tiempoFaltante.get(i);
                    for (int j = 0; j < tiempoFaltanteReg.length; j++) {
                        System.out.println(j + "." + tiempoFaltanteReg[j].toString());
                    }
                }
                System.out.println("<><><><><><><><><><><><><><><>");
            }
        } catch (Exception e) {
            System.out.println("<><>reporteTiempoFaltanteActual<><> " + e);
        }
        return tiempoFaltante;
    }

    private ArrayList hourlyTiempoFaltanteActual(Principal winPrincipal) {
        ArrayList tiempoFaltanteHourly = new ArrayList();

        try {
            Object[] registro;
            Object[] registroHourly;

            ArrayList tiempoFaltanteArr = generarReporteTiempoFaltanteActual(winPrincipal);

            if (!tiempoFaltanteArr.isEmpty()) {
                for (int i = 0; i < tiempoFaltanteArr.size(); i++) {
                    registro = (Object[]) tiempoFaltanteArr.get(i);

                    registroHourly = new Object[2];
                    registroHourly[0] = registro[2];//hora
                    registroHourly[1] = registro[5];//duracion
                    tiempoFaltanteHourly.add(registroHourly);
                }
            }

            if (!tiempoFaltanteHourly.isEmpty()) { //Listamos el array
                Object[] tiempoFaltanteHourlyReg;
                System.out.println("<><><><><>TIEMPOFALTANTE<><><><><>");
                for (int i = 0; i < tiempoFaltanteHourly.size(); i++) {
                    tiempoFaltanteHourlyReg = (Object[]) tiempoFaltanteHourly.get(i);
                    for (int j = 0; j < tiempoFaltanteHourlyReg.length; j++) {
                        System.out.println(j + "." + tiempoFaltanteHourlyReg[j].toString());
                    }
                }
                System.out.println("<><><><><><><><><><><><><><><>");
            }

        } catch (Exception e) {
            System.out.println("hourlyTiempoFaltanteActual: " + e);
        }
        return tiempoFaltanteHourly;
    }

    private ArrayList returnHourlyTiempoFaltanteArray(ArrayList hourlyTiempoFaltanteActual) {
        ArrayList tiempoFaltanteArr = new ArrayList();
        ArrayList tiempoFaltanteArrAx = hourlyTiempoFaltanteActual;

        if (hourlyTiempoFaltanteActual.isEmpty()) {
            for (int i = 0; i < 24; i++) {
                Object[] tiempoFaltanteReg = new Object[2];
                tiempoFaltanteReg[0] = i;//hora
                tiempoFaltanteReg[1] = 0;//duracion
                tiempoFaltanteArr.add(tiempoFaltanteReg);
            }
        } else {
            Object[] tiempoFaltanteRegAux;
            Object[] tiempoFaltante;
            for (int j = 0; j < 24; j++) {
                Object[] tiempoFaltanteReg = new Object[2];
                tiempoFaltanteReg[0] = j;//hora
                tiempoFaltanteReg[1] = 0;//duracion
                tiempoFaltanteArr.add(tiempoFaltanteReg);
            }
            for (int k = 0; k < tiempoFaltanteArr.size(); k++) {
                tiempoFaltante = (Object[]) tiempoFaltanteArr.get(k);
                for (int l = 0; l < tiempoFaltanteArrAx.size(); l++) {
                    tiempoFaltanteRegAux = (Object[]) tiempoFaltanteArrAx.get(l);
                    if (tiempoFaltanteRegAux[0].equals(tiempoFaltante[0])) {
                        tiempoFaltante = tiempoFaltanteRegAux;
                        tiempoFaltanteArr.set(k, tiempoFaltante);
                    }
                }
            }
        }
        return tiempoFaltanteArr;
    }

    public void hourlyGeneral(Principal winPrincipal) {
        ArrayList hourlyGral = new ArrayList();
        try {
            ArrayList produccion = returnHourlyProduccionArray(hourlyProduccionActual(winPrincipal));
            ArrayList calidad = returnHourlyCalidadArray(hourlyCalidadActual(winPrincipal));
            ArrayList tecnicas = returnHourlyTecnicasArray(hourlyTecnicasActual(winPrincipal));
            ArrayList organizacional = returnHourlyOrganizacionalArray(hourlyOrganizacionalActual(winPrincipal));
            ArrayList cambios = returnHourlyCambiosArray(hourlyCambiosActual(winPrincipal));
            ArrayList tiempoFaltante = returnHourlyTiempoFaltanteArray(hourlyTiempoFaltanteActual(winPrincipal));

            Object[] registroHourlyGral;
            Object[] registroProduccion;
            Object[] registroCalidad;
            Object[] registroTecnicas;
            Object[] registroOrganizacional;
            Object[] registroCambios;
            Object[] registroTiempoFaltante;

            for (int i = 0; i < 24; i++) {

                registroHourlyGral = new Object[14];

                registroProduccion = (Object[]) produccion.get(i);
                if (registroProduccion[0].equals(i)) {
                    registroHourlyGral[0] = registroProduccion[0];//hora
                    registroHourlyGral[1] = registroProduccion[1];//cantidadProducida
                    registroHourlyGral[2] = registroProduccion[2];//noParte/TC

                    registroCalidad = (Object[]) calidad.get(i);
                    if (registroCalidad[0].equals(i)) {
                        //registroHourlyGral[3] = registroCalidad[3];//scrapCalidad
                        if (!(registroHourlyGral[8] == null)) { //Operacion no esta vacia
                            registroHourlyGral[8]
                                    = registroHourlyGral[8].toString() + "\n" + registroCalidad[1].toString();
                        } else {
                            registroHourlyGral[8] = registroCalidad[1];
                        }
                        if (!(registroHourlyGral[9] == null)) { //Problema no esta vacio
                            registroHourlyGral[9]
                                    = registroHourlyGral[9].toString() + "\n" + registroCalidad[2].toString();
                        } else {
                            registroHourlyGral[9] = registroCalidad[2];
                        }
                        if (!(registroHourlyGral[3] == null)) { //scrap no esta vacio
                            registroHourlyGral[3] = String.valueOf(
                                    Integer.parseInt(registroHourlyGral[3].toString())
                                    + Integer.parseInt(registroCalidad[3].toString())
                            );
                        } else {
                            registroHourlyGral[3] = registroCalidad[3];
                        }
                        
                        registroTecnicas = (Object[]) tecnicas.get(i);
                        if (registroTecnicas[0].equals(i)) {
                            registroHourlyGral[5] = registroTecnicas[1];//duracion
                            if (!(registroHourlyGral[10] == null)) { //Operacion no esta vacia
                                registroHourlyGral[10]
                                        = registroHourlyGral[10].toString() + "\n" + registroTecnicas[2].toString();
                            } else {
                                registroHourlyGral[10] = registroTecnicas[2];
                            }
                            if (!(registroHourlyGral[11] == null)) { //Problema no esta vacio
                                registroHourlyGral[11]
                                        = registroHourlyGral[11].toString() + "\n" + registroTecnicas[3].toString();
                            } else {
                                registroHourlyGral[11] = registroTecnicas[3];
                            }
                            if (!(registroHourlyGral[3] == null)) { //scrap no esta vacio
                                registroHourlyGral[3] = String.valueOf(
                                        Integer.parseInt(registroHourlyGral[3].toString())
                                        + Integer.parseInt(registroTecnicas[4].toString())
                                );
                            } else {
                                registroHourlyGral[3] = registroTecnicas[4];
                            }

                            registroOrganizacional = (Object[]) organizacional.get(i);
                            if (registroOrganizacional[0].equals(i)) {
                                registroHourlyGral[6] = registroOrganizacional[1];//duracion
                                if (!(registroHourlyGral[10] == null)) { //Operacion no esta vacia
                                    registroHourlyGral[10]
                                            = registroHourlyGral[10].toString() + "\n" + registroOrganizacional[2].toString();
                                } else {
                                    registroHourlyGral[10] = registroOrganizacional[2];
                                }
                                if (!(registroHourlyGral[11] == null)) { //Problema no esta vacio
                                    registroHourlyGral[11]
                                            = registroHourlyGral[11].toString() + "\n" + registroOrganizacional[3].toString();
                                } else {
                                    registroHourlyGral[11] = registroOrganizacional[3];
                                }
                                if (!(registroHourlyGral[3] == null)) { //scrap no esta vacio
                                    registroHourlyGral[3] = String.valueOf(
                                            Integer.parseInt(registroHourlyGral[3].toString())
                                            + Integer.parseInt(registroOrganizacional[4].toString())
                                    );
                                } else {
                                    registroHourlyGral[3] = registroOrganizacional[4];
                                }

                                registroCambios = (Object[]) cambios.get(i);
                                if (registroCambios[0].equals(i)) {
                                    registroHourlyGral[4] = registroCambios[1];//duracion
                                    if (!(registroHourlyGral[8] == null)) { //Operacion no esta vacia
                                        registroHourlyGral[8]
                                                = registroHourlyGral[8].toString() + "\n" + registroCambios[2].toString();
                                    } else {
                                        registroHourlyGral[8] = registroCambios[2];
                                    }
                                    if (!(registroHourlyGral[9] == null)) { //Problema no esta vacio
                                        registroHourlyGral[9]
                                                = registroHourlyGral[9].toString() + "\n" + registroCambios[3].toString();
                                    } else {
                                        registroHourlyGral[9] = registroCambios[3];
                                    }
                                    if (!(registroHourlyGral[3] == null)) { //scrap no esta vacio
                                        registroHourlyGral[3] = String.valueOf(
                                                Integer.parseInt(registroHourlyGral[3].toString())
                                                + Integer.parseInt(registroCambios[4].toString())
                                        );
                                    } else {
                                        registroHourlyGral[3] = registroCambios[4];
                                    }

                                    registroTiempoFaltante = (Object[]) tiempoFaltante.get(i);
                                    if (registroTiempoFaltante[0].equals(i)) {
                                        registroHourlyGral[7] = registroTiempoFaltante[1];
                                        registroHourlyGral[12] = winPrincipal.getDteFecha().getText();
                                        registroHourlyGral[13] = winPrincipal.getCmbLinea().getSelectedItem().toString();
                                        hourlyGral.add(registroHourlyGral);
                                    }

                                }

                            }
                        }

                    }

                }

            }

            if (!hourlyGral.isEmpty()) { //Listamos el array
                Object[] organizacionalHourlyReg;
                System.out.println("<><><><><>HOURLYGENERAL<><><><><>");
                for (int i = 0; i < hourlyGral.size(); i++) {
                    organizacionalHourlyReg = (Object[]) hourlyGral.get(i);
                    for (int j = 0; j < organizacionalHourlyReg.length; j++) {
                        System.out.println(j + "." + organizacionalHourlyReg[j].toString() + "[" + organizacionalHourlyReg[j].getClass().getName() + "]");
                    }
                }
                System.out.println("<><><><><><><><><><><><><><><><><>");
                new BitacoraDAOImpl().borrarRegistroHourly(winPrincipal.getCmbLinea().getSelectedItem().toString());
                new BitacoraDAOImpl().insertarRegistroHourly(hourlyGral);

                //BOSCH SERVER
                //String EXCEL_LOCATION = "C:\\Users\\GJA5TL\\Desktop\\Hourly_Count_12hr_Shifts_v1.0.xlsx";
                
                //SEG SERVER
                String EXCEL_LOCATION = "C:\\Users\\GJA5TL.SG\\Desktop\\Hourly_Count_12hr_Shifts_v1.0.xlsx";
                Process p = Runtime.getRuntime().exec("C:\\Program Files (x86)\\Microsoft Office\\Office16\\EXCEL.EXE " + EXCEL_LOCATION);
            }

        } catch (Exception e) {
            System.out.println("hourlyGeneral: " + e);
        }
    }
    
    private ArrayList hourlyDiario(Principal winPrincipal) {
        System.out.println("fecha: " + winPrincipal.getDteFecha().getText());
        int mes = winPrincipal.getDteFecha().getDate().getMonth() + 1;
        System.out.println("mes: " + mes);

        ArrayList registrosDiariosAux = new ArrayList();      
        
        try {
            for (int i = 1; i < 32; i++) {
                String fecha = i + "/" + mes + "/" + 2017;
                registrosDiariosAux.add(
                        new BitacoraDAOImpl().listarBitacorasPorFecha(
                                fecha, winPrincipal.getCmbLinea().getSelectedItem().toString()
                        )
                );
            }                      
            System.out.println("arrayRegistrosDiariosSize: " + registrosDiariosAux.size());
            
        } catch (Exception e) {
            System.out.println("hourlyDiario: " + e);
        }
        return registrosDiariosAux;
    }
    
    public ArrayList generarReporteProduccionActualOEE(Principal winPrincipal) {
        ArrayList produccion = new ArrayList();
        try {
            Object[] registro;
            Object[] comparaRegistro;

            ArrayList hourlyMes = hourlyDiario(winPrincipal);

            int indicadorHora = 0;
            int indicadorDia = 0;
            
            for (int contDia = 0; contDia < 31; contDia++) {
                ArrayList hourlyDia = (ArrayList) hourlyMes.get(contDia);
                
                for (int noRegistroDia = 0; noRegistroDia < hourlyDia.size(); noRegistroDia++) {
                    registro = (Object[]) hourlyDia.get(noRegistroDia);

                    if (registro[6].equals("Piezas Producidas")) {
//                        for (int x = 0; x < registro.length; x++) {
//                            System.out.println("OCTUBRE, DIA: " + a + "; CONTENIDO[" + x + "]: " + registro[x]);
//                        }
                        if (produccion.isEmpty()) { //arrayProduccion está vacio
                            indicadorDia = contDia + 1;
                            indicadorHora = Integer.parseInt(registro[2].toString());
                            produccion.add(registro);
                        } else { //arrayProduccion tiene registros
                            
                        }
                    }
                }
            }
//            if (!produccion.isEmpty()) { //Listamos el array
//                Object[] produccionReg;
//                System.out.println("<><><><><>PRODUCCION<><><><><>");
//                for (int i = 0; i < produccion.size(); i++) {
//                    produccionReg = (Object[]) produccion.get(i);
//                    for (int j = 0; j < produccionReg.length; j++) {
//                        System.out.println(j + "." + produccionReg[j].toString());
//                    }
//                }
//                System.out.println("<><><><><><><><><><><><><><><>");
//            }
        } catch (Exception e) {
            System.out.println("<><>reporteProduccionActual<><> " + e);
        }
        return produccion;
    }

    public void topCalidad(Principal winPrincipal) {
        ArrayList topCalidad = new ArrayList();
        try {
            Object[] registroTopCalidad;
            Object[] registroTopAux;
            Object[] registro;

            ArrayList bitacoraActual
                    = getBitacoraActual(
                            horarioTurno(winPrincipal.getCmbHora()),
                            winPrincipal
                    );

            for (int i = 0; i < bitacoraActual.size(); i++) { //Recorremos la bitacora
                registro = (Object[]) bitacoraActual.get(i); //Obtenemos el primer registro

                if (registro[6].equals("Calidad")) { //Evaluamos y creamos registroTopCalidad
                    registroTopCalidad = new Object[4];
                    registroTopCalidad[0] = registro[7];
                    registroTopCalidad[1] = registro[9];
                    registroTopCalidad[2] = registro[5];
                    registroTopCalidad[3] = 1;

                    if (topCalidad.isEmpty()) { //Creamos el primer registro para el top
                        topCalidad.add(registroTopCalidad);
                    } else { //Existe un registro en el top
                        for (int j = 0; j < topCalidad.size(); j++) {
                            registroTopAux = (Object[]) topCalidad.get(j);
                            if (registroTopCalidad[0].equals(registroTopAux[0])
                                    && registroTopCalidad[1].equals(registroTopAux[1])) {
                                topCalidad.remove(j);
                                registroTopCalidad[2]
                                        = Integer.parseInt(registroTopCalidad[2].toString())
                                        + Integer.parseInt(registroTopAux[2].toString());
                                registroTopCalidad[3]
                                        = Integer.parseInt(registroTopCalidad[3].toString())
                                        + Integer.parseInt(registroTopAux[3].toString());
                                break;
                            }
                            registroTopAux = null;
                        }
                        topCalidad.add(registroTopCalidad);
                    }
                }
            }

            if (!topCalidad.isEmpty()) { //Listamos el array
                Object[] topCalidadReg;
                System.out.println("<><><>CALIDAD<><><>");
                for (int i = 0; i < topCalidad.size(); i++) {
                    topCalidadReg = (Object[]) topCalidad.get(i);
                    for (int j = 0; j < topCalidadReg.length; j++) {
                        System.out.println(j + "." + topCalidadReg[j].toString());
                    }
                }
                System.out.println("<><><><><><><><><><>");
            }

        } catch (Exception e) {
            System.out.println("<><>topCalidad<><> " + e);
        }
    }

    public void topTecnicas(Principal winPrincipal) {
        ArrayList topTecnicas = new ArrayList();
        try {
            Object[] registroTopTecnicas;
            Object[] registroTopAux;
            Object[] registro;

            ArrayList bitacoraActual
                    = getBitacoraActual(
                            horarioTurno(winPrincipal.getCmbHora()),
                            winPrincipal
                    );

            for (int i = 0; i < bitacoraActual.size(); i++) { //Recorremos la bitacora
                registro = (Object[]) bitacoraActual.get(i); //Obtenemos el primer registro

                if (registro[6].equals("Tecnicas")) { //Evaluamos y creamos registroTopCalidad
                    registroTopTecnicas = new Object[4];
                    registroTopTecnicas[0] = registro[7];
                    registroTopTecnicas[1] = registro[9];
                    registroTopTecnicas[2] = registro[5];
                    registroTopTecnicas[3] = 1;

                    if (topTecnicas.isEmpty()) { //Creamos el primer registro para el top
                        topTecnicas.add(registroTopTecnicas);
                    } else { //Existe un registro en el top
                        for (int j = 0; j < topTecnicas.size(); j++) {
                            registroTopAux = (Object[]) topTecnicas.get(j);
                            if (registroTopTecnicas[0].equals(registroTopAux[0])
                                    && registroTopTecnicas[1].equals(registroTopAux[1])) {
                                topTecnicas.remove(j);
                                registroTopTecnicas[2]
                                        = Integer.parseInt(registroTopTecnicas[2].toString())
                                        + Integer.parseInt(registroTopAux[2].toString());
                                registroTopTecnicas[3]
                                        = Integer.parseInt(registroTopTecnicas[3].toString())
                                        + Integer.parseInt(registroTopAux[3].toString());
                                break;
                            }
                            registroTopAux = null;
                        }
                        topTecnicas.add(registroTopTecnicas);
                    }
                }
            }

            if (!topTecnicas.isEmpty()) { //Listamos el array
                Object[] topTecnicasReg;
                System.out.println("<><><>TECNICAS<><><>");
                for (int i = 0; i < topTecnicas.size(); i++) {
                    topTecnicasReg = (Object[]) topTecnicas.get(i);
                    for (int j = 0; j < topTecnicasReg.length; j++) {
                        System.out.println(j + "." + topTecnicasReg[j].toString());
                    }
                }
                System.out.println("<><><><><><><><><><>");
            }

        } catch (Exception e) {
            System.out.println("<><>topTecnicas<><> " + e);
        }
    }

    public void topOrganizacionales(Principal winPrincipal) {
        ArrayList topOrganizacionales = new ArrayList();
        try {
            Object[] registroTopOrganizacionales;
            Object[] registroTopAux;
            Object[] registro;

            ArrayList bitacoraActual
                    = getBitacoraActual(
                            horarioTurno(winPrincipal.getCmbHora()),
                            winPrincipal
                    );

            for (int i = 0; i < bitacoraActual.size(); i++) { //Recorremos la bitacora
                registro = (Object[]) bitacoraActual.get(i); //Obtenemos el primer registro

                if (registro[6].equals("Organizacionales")) { //Evaluamos y creamos registroTopCalidad
                    registroTopOrganizacionales = new Object[4];
                    registroTopOrganizacionales[0] = registro[7];
                    registroTopOrganizacionales[1] = registro[9];
                    registroTopOrganizacionales[2] = registro[5];
                    registroTopOrganizacionales[3] = 1;

                    if (topOrganizacionales.isEmpty()) { //Creamos el primer registro para el top
                        topOrganizacionales.add(registroTopOrganizacionales);
                    } else { //Existe un registro en el top
                        for (int j = 0; j < topOrganizacionales.size(); j++) {
                            registroTopAux = (Object[]) topOrganizacionales.get(j);
                            if (registroTopOrganizacionales[0].equals(registroTopAux[0])
                                    && registroTopOrganizacionales[1].equals(registroTopAux[1])) {
                                topOrganizacionales.remove(j);
                                registroTopOrganizacionales[2]
                                        = Integer.parseInt(registroTopOrganizacionales[2].toString())
                                        + Integer.parseInt(registroTopAux[2].toString());
                                registroTopOrganizacionales[3]
                                        = Integer.parseInt(registroTopOrganizacionales[3].toString())
                                        + Integer.parseInt(registroTopAux[3].toString());
                                break;
                            }
                            registroTopAux = null;
                        }
                        topOrganizacionales.add(registroTopOrganizacionales);
                    }
                }
            }

            if (!topOrganizacionales.isEmpty()) { //Listamos el array
                Object[] topOrganizacionalesReg;
                System.out.println("<><><>ORGANIZACIONALES<><><>");
                for (int i = 0; i < topOrganizacionales.size(); i++) {
                    topOrganizacionalesReg = (Object[]) topOrganizacionales.get(i);
                    for (int j = 0; j < topOrganizacionalesReg.length; j++) {
                        System.out.println(j + "." + topOrganizacionalesReg[j].toString());
                    }
                }
                System.out.println("<><><><><><><><><><><><><><>");
            }

        } catch (Exception e) {
            System.out.println("<><>topTecnicas<><> " + e);
        }
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
