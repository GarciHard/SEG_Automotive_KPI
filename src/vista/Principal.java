package vista;

import com.alee.extended.date.WebDateField;
import com.alee.extended.panel.WebCollapsiblePane;
import control.PrincipalControl;
import dao.BitacoraDAOImpl;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.JTextField;
import org.jdesktop.swingx.prompt.PromptSupport;
import utils.PrincipalMetodos;

/**
 * Hecho con <3 por:
 * @author GarciHard
 * @boschUsr GJA5TL
 */
public class Principal extends javax.swing.JFrame {
    
    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        PromptSupport.setPrompt("Minuto Inicio",txtTiempoInicio);
        PromptSupport.setPrompt("Minuto Fin",txtTiempoFin);
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/bs.png")).getImage());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pmnClickMenu = new javax.swing.JPopupMenu();
        mniEliminar = new javax.swing.JMenuItem();
        btnGuardarBitacora = new javax.swing.JButton();
        pnlPiezasProducidas = new javax.swing.JPanel();
        lblClientePzasProd = new javax.swing.JLabel();
        cmbClientePzasProd = new javax.swing.JComboBox();
        lblNoPartePzasProd = new javax.swing.JLabel();
        cmbNoPartePzasProd = new javax.swing.JComboBox();
        lblCantidadProducidaPzasProd = new javax.swing.JLabel();
        txtCantidadProducidaPzasProd = new javax.swing.JTextField();
        txtTC = new javax.swing.JTextField();
        lblTC = new javax.swing.JLabel();
        lblFamiliaPzasProd = new javax.swing.JLabel();
        cmbFamiliaPzasProd = new javax.swing.JComboBox<>();
        pnlOrganizacionales = new javax.swing.JPanel();
        lblAreaOrganizacional = new javax.swing.JLabel();
        cmbAreaOrganizacional = new javax.swing.JComboBox();
        lblProblemaOrganizacional = new javax.swing.JLabel();
        cmbProblemaOrganizacional = new javax.swing.JComboBox();
        lblClienteOrganizacional = new javax.swing.JLabel();
        cmbClienteOrganizacional = new javax.swing.JComboBox();
        lblNoParteOrganizacional = new javax.swing.JLabel();
        cmbNoParteOrganizacional = new javax.swing.JComboBox();
        txtMatFaltante = new javax.swing.JTextField();
        lblMatFaltante = new javax.swing.JLabel();
        lblFamiliaOrganizacional = new javax.swing.JLabel();
        cmbFamiliaOrganizacional = new javax.swing.JComboBox<>();
        pnlCambios = new javax.swing.JPanel();
        lblAreaCambios = new javax.swing.JLabel();
        cmbAreaCambios = new javax.swing.JComboBox();
        lblNoParteCambios = new javax.swing.JLabel();
        cmbNoParteCambios = new javax.swing.JComboBox();
        lblClienteCambios = new javax.swing.JLabel();
        cmbClienteCambios = new javax.swing.JComboBox();
        lblParteCambioCambios = new javax.swing.JLabel();
        cmbNoParteCambioCambios = new javax.swing.JComboBox();
        lblScrapCambios = new javax.swing.JLabel();
        txtScrapCambios = new javax.swing.JTextField();
        cmbClienteNuevoCambios = new javax.swing.JComboBox();
        lblClienteCambios1 = new javax.swing.JLabel();
        lblFamiliaCambios = new javax.swing.JLabel();
        cmbFamiliaCambios = new javax.swing.JComboBox<>();
        lblFamiliaNuevaCambios = new javax.swing.JLabel();
        cmbFamiliaNuevaCambios = new javax.swing.JComboBox<>();
        pnlPlaneados = new javax.swing.JPanel();
        lblAreaPlaneados = new javax.swing.JLabel();
        cmbAreaPlaneados = new javax.swing.JComboBox();
        lblClientePlaneados = new javax.swing.JLabel();
        cmbClientePlaneados = new javax.swing.JComboBox();
        lblNoPartePlaneados = new javax.swing.JLabel();
        cmbNoPartePlaneados = new javax.swing.JComboBox();
        lblFamiliaPlaneados = new javax.swing.JLabel();
        cmbFamiliaPlaneados = new javax.swing.JComboBox<>();
        pnlTecnicas = new javax.swing.JPanel();
        lblOperacionTecnicas = new javax.swing.JLabel();
        cmbOperacionTecnicas = new javax.swing.JComboBox();
        lblAreaTecnicas = new javax.swing.JLabel();
        cmbAreaTecnicas = new javax.swing.JComboBox();
        lblProblemaTecnicas = new javax.swing.JLabel();
        cmbProblemaTecnicas = new javax.swing.JComboBox();
        lblClienteTecnicas = new javax.swing.JLabel();
        cmbClienteTecnicas = new javax.swing.JComboBox();
        lblNoParteTecnicas = new javax.swing.JLabel();
        cmbNoParteTecnicas = new javax.swing.JComboBox();
        lblScrapTecnicas = new javax.swing.JLabel();
        txtScrapTecnicas = new javax.swing.JTextField();
        lblFamiliaTecnicas = new javax.swing.JLabel();
        cmbFamiliaTecnicas = new javax.swing.JComboBox<>();
        pnlCalidad = new javax.swing.JPanel();
        lblOperacionCalidad = new javax.swing.JLabel();
        cmbOperacionCalidad = new javax.swing.JComboBox();
        lblAreaCalidad = new javax.swing.JLabel();
        cmbAreaCalidad = new javax.swing.JComboBox();
        lblProblemaCalidad = new javax.swing.JLabel();
        cmbProblemaCalidad = new javax.swing.JComboBox();
        lblClienteCalidad = new javax.swing.JLabel();
        cmbClienteCalidad = new javax.swing.JComboBox();
        lblNoParteCalidad = new javax.swing.JLabel();
        cmbNoParteCalidad = new javax.swing.JComboBox();
        lblScrapCalidad = new javax.swing.JLabel();
        txtScrapCalidad = new javax.swing.JTextField();
        lblFamiliaCalidad = new javax.swing.JLabel();
        cmbFamiliaCalidad = new javax.swing.JComboBox<>();
        pnlTiempoFaltante = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        mniListarBitacoras = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        mniBitacora = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        mniTiemposCiclo = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        mniClientes = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        pnlBackground = new javax.swing.JPanel();
        pnlBorderNorth = new javax.swing.JPanel();
        lblTema = new javax.swing.JLabel();
        cmbTema = new javax.swing.JComboBox();
        lblLinea = new javax.swing.JLabel();
        cmbLinea = new javax.swing.JComboBox();
        lblFecha = new javax.swing.JLabel();
        dteFecha = new com.alee.extended.date.WebDateField();
        btnCambiarLinea = new javax.swing.JButton();
        lblTurno = new javax.swing.JLabel();
        pnlBorder = new javax.swing.JPanel();
        pnlProduccionCollapsible = new com.alee.extended.panel.WebCollapsiblePane();
        pnlBorderTiempoBitacora = new javax.swing.JPanel();
        pnlTiempoIncidencia = new javax.swing.JPanel();
        pnlTiempoIncidenciaHora = new javax.swing.JPanel();
        lblHora = new javax.swing.JLabel();
        cmbHora = new javax.swing.JComboBox();
        lblInicio = new javax.swing.JLabel();
        txtTiempoInicio = new javax.swing.JTextField();
        lblFin = new javax.swing.JLabel();
        txtTiempoFin = new javax.swing.JTextField();
        lblDuracion = new javax.swing.JLabel();
        txtDuracion = new javax.swing.JTextField();
        btnAgregarBitacora = new javax.swing.JButton();
        btnRevisarHoras = new javax.swing.JButton();
        btnParoPeriodo = new javax.swing.JButton();
        pnlBitacora = new javax.swing.JPanel();
        scrBitacora = new javax.swing.JScrollPane();
        tblBitacora = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        tblBitacora = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        mnuBarra = new javax.swing.JMenuBar();
        mnuAdministrar = new javax.swing.JMenu();
        mniLineas = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mniOperaciones = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mnuOtros = new javax.swing.JMenu();
        mniCrearUsuario = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        mniCargaMasiva = new javax.swing.JMenuItem();
        mnuEditar = new javax.swing.JMenu();
        mniEditarPorDia = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        mniEditarPorTurno = new javax.swing.JMenuItem();
        mnuGraficas = new javax.swing.JMenu();
        mniHourlyCount = new javax.swing.JMenuItem();

        mniEliminar.setText("Eliminar");
        mniEliminar.setActionCommand("_mniEliminar");
        pmnClickMenu.add(mniEliminar);

        btnGuardarBitacora.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnGuardarBitacora.setText("Guardar Bitacora");
        btnGuardarBitacora.setFocusable(false);

        pnlPiezasProducidas.setFocusable(false);

        lblClientePzasProd.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblClientePzasProd.setText("FAMILIA");

        cmbClientePzasProd.setActionCommand("_cmbClientePzasProd");
        cmbClientePzasProd.setEnabled(false);
        cmbClientePzasProd.setNextFocusableComponent(cmbFamiliaPzasProd);

        lblNoPartePzasProd.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNoPartePzasProd.setText("No. PARTE");

        cmbNoPartePzasProd.setActionCommand("_cmbNoPartePzasProd");
        cmbNoPartePzasProd.setEnabled(false);
        cmbNoPartePzasProd.setNextFocusableComponent(txtTC);

        lblCantidadProducidaPzasProd.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCantidadProducidaPzasProd.setText("CANTIDAD PRODUCIDA");

        txtCantidadProducidaPzasProd.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtCantidadProducidaPzasProd.setEnabled(false);
        txtCantidadProducidaPzasProd.setNextFocusableComponent(cmbHora);

        txtTC.setEnabled(false);
        txtTC.setNextFocusableComponent(txtCantidadProducidaPzasProd);

        lblTC.setText("TC");

        lblFamiliaPzasProd.setText("CLIENTE");

        cmbFamiliaPzasProd.setActionCommand("_cmbFamiliaPzasProd");
        cmbFamiliaPzasProd.setEnabled(false);
        cmbFamiliaPzasProd.setNextFocusableComponent(cmbNoPartePzasProd);

        javax.swing.GroupLayout pnlPiezasProducidasLayout = new javax.swing.GroupLayout(pnlPiezasProducidas);
        pnlPiezasProducidas.setLayout(pnlPiezasProducidasLayout);
        pnlPiezasProducidasLayout.setHorizontalGroup(
            pnlPiezasProducidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPiezasProducidasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblClientePzasProd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbClientePzasProd, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(lblFamiliaPzasProd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbFamiliaPzasProd, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(lblNoPartePzasProd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbNoPartePzasProd, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(lblTC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTC, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(lblCantidadProducidaPzasProd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCantidadProducidaPzasProd, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlPiezasProducidasLayout.setVerticalGroup(
            pnlPiezasProducidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPiezasProducidasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPiezasProducidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClientePzasProd)
                    .addComponent(cmbClientePzasProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNoPartePzasProd)
                    .addComponent(cmbNoPartePzasProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCantidadProducidaPzasProd)
                    .addComponent(txtCantidadProducidaPzasProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTC)
                    .addComponent(cmbFamiliaPzasProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFamiliaPzasProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlOrganizacionales.setFocusable(false);

        lblAreaOrganizacional.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAreaOrganizacional.setText("ÁREA");

        cmbAreaOrganizacional.setActionCommand("_cmbAreaOrganizacional");
        cmbAreaOrganizacional.setEnabled(false);
        cmbAreaOrganizacional.setFocusable(false);
        cmbAreaOrganizacional.setNextFocusableComponent(cmbProblemaOrganizacional);

        lblProblemaOrganizacional.setText("PROBLEMA");

        cmbProblemaOrganizacional.setActionCommand("_cmbProblemaOrganizacional");
        cmbProblemaOrganizacional.setEnabled(false);
        cmbProblemaOrganizacional.setFocusable(false);
        cmbProblemaOrganizacional.setNextFocusableComponent(cmbProblemaOrganizacional);

        lblClienteOrganizacional.setText("CLIENTE");

        cmbClienteOrganizacional.setActionCommand("_cmbClienteOrganizacional");
        cmbClienteOrganizacional.setEnabled(false);
        cmbClienteOrganizacional.setFocusable(false);
        cmbClienteOrganizacional.setNextFocusableComponent(cmbNoParteOrganizacional);

        lblNoParteOrganizacional.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNoParteOrganizacional.setText("No. PARTE");

        cmbNoParteOrganizacional.setActionCommand("_cmbNoParteOrganizacional");
        cmbNoParteOrganizacional.setEnabled(false);
        cmbNoParteOrganizacional.setFocusable(false);
        cmbNoParteOrganizacional.setNextFocusableComponent(txtMatFaltante);

        txtMatFaltante.setEnabled(false);
        txtMatFaltante.setNextFocusableComponent(cmbHora);

        lblMatFaltante.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMatFaltante.setText("MATERIAL FALTANTE");

        lblFamiliaOrganizacional.setText("FAMILIA");

        cmbFamiliaOrganizacional.setActionCommand("_cmbFamiliaOrganizacional");
        cmbFamiliaOrganizacional.setEnabled(false);
        cmbFamiliaOrganizacional.setNextFocusableComponent(cmbClienteOrganizacional);

        javax.swing.GroupLayout pnlOrganizacionalesLayout = new javax.swing.GroupLayout(pnlOrganizacionales);
        pnlOrganizacionales.setLayout(pnlOrganizacionalesLayout);
        pnlOrganizacionalesLayout.setHorizontalGroup(
            pnlOrganizacionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOrganizacionalesLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnlOrganizacionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblAreaOrganizacional, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblProblemaOrganizacional, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(pnlOrganizacionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlOrganizacionalesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbProblemaOrganizacional, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlOrganizacionalesLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(cmbAreaOrganizacional, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(pnlOrganizacionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFamiliaOrganizacional, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblClienteOrganizacional, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlOrganizacionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbFamiliaOrganizacional, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbClienteOrganizacional, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(pnlOrganizacionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlOrganizacionalesLayout.createSequentialGroup()
                        .addComponent(lblMatFaltante)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMatFaltante, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOrganizacionalesLayout.createSequentialGroup()
                        .addComponent(lblNoParteOrganizacional, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbNoParteOrganizacional, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlOrganizacionalesLayout.setVerticalGroup(
            pnlOrganizacionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOrganizacionalesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlOrganizacionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlOrganizacionalesLayout.createSequentialGroup()
                        .addGroup(pnlOrganizacionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbAreaOrganizacional)
                            .addComponent(lblAreaOrganizacional, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlOrganizacionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbProblemaOrganizacional)
                            .addComponent(lblProblemaOrganizacional, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnlOrganizacionalesLayout.createSequentialGroup()
                        .addGroup(pnlOrganizacionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlOrganizacionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmbNoParteOrganizacional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblNoParteOrganizacional, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlOrganizacionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmbFamiliaOrganizacional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblFamiliaOrganizacional, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlOrganizacionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbClienteOrganizacional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblClienteOrganizacional, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMatFaltante)
                            .addComponent(txtMatFaltante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        pnlCambios.setFocusable(false);

        lblAreaCambios.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAreaCambios.setText("ÁREA");

        cmbAreaCambios.setActionCommand("_cmbAreaCambios");
        cmbAreaCambios.setEnabled(false);
        cmbAreaCambios.setNextFocusableComponent(cmbFamiliaCambios);

        lblNoParteCambios.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNoParteCambios.setText("No. PARTE ACTUAL");

        cmbNoParteCambios.setActionCommand("_cmbNoParteCambios");
        cmbNoParteCambios.setEnabled(false);
        cmbNoParteCambios.setNextFocusableComponent(cmbFamiliaNuevaCambios);

        lblClienteCambios.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblClienteCambios.setText("CLIENTE ACTUAL");

        cmbClienteCambios.setActionCommand("_cmbClienteCambios");
        cmbClienteCambios.setEnabled(false);
        cmbClienteCambios.setNextFocusableComponent(cmbNoParteCambios);

        lblParteCambioCambios.setText("No. PARTE CAMBIO");

        cmbNoParteCambioCambios.setActionCommand("_cmbNoParteCambioCambios");
        cmbNoParteCambioCambios.setEnabled(false);
        cmbNoParteCambioCambios.setNextFocusableComponent(txtScrapCambios);

        lblScrapCambios.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblScrapCambios.setText("SCRAP");

        txtScrapCambios.setEnabled(false);
        txtScrapCambios.setNextFocusableComponent(cmbHora);

        cmbClienteNuevoCambios.setActionCommand("_cmbClienteNuevoCambios");
        cmbClienteNuevoCambios.setEnabled(false);
        cmbClienteNuevoCambios.setNextFocusableComponent(cmbNoParteCambioCambios);

        lblClienteCambios1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblClienteCambios1.setText("NUEVO CLIENTE");

        lblFamiliaCambios.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFamiliaCambios.setText("FAMILIA ACTUAL");

        cmbFamiliaCambios.setActionCommand("_cmbFamiliaCambios");
        cmbFamiliaCambios.setEnabled(false);
        cmbFamiliaCambios.setNextFocusableComponent(cmbClienteCambios);

        lblFamiliaNuevaCambios.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFamiliaNuevaCambios.setText("NUEVA FAMILIA");

        cmbFamiliaNuevaCambios.setActionCommand("_cmbFamiliaNuevaCambios");
        cmbFamiliaNuevaCambios.setEnabled(false);
        cmbFamiliaNuevaCambios.setNextFocusableComponent(cmbClienteNuevoCambios);

        javax.swing.GroupLayout pnlCambiosLayout = new javax.swing.GroupLayout(pnlCambios);
        pnlCambios.setLayout(pnlCambiosLayout);
        pnlCambiosLayout.setHorizontalGroup(
            pnlCambiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCambiosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAreaCambios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbAreaCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlCambiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnlCambiosLayout.createSequentialGroup()
                        .addComponent(lblNoParteCambios)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbNoParteCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCambiosLayout.createSequentialGroup()
                        .addGroup(pnlCambiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblClienteCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFamiliaCambios, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCambiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbClienteCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbFamiliaCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlCambiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlCambiosLayout.createSequentialGroup()
                        .addComponent(lblParteCambioCambios)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbNoParteCambioCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCambiosLayout.createSequentialGroup()
                        .addGroup(pnlCambiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblClienteCambios1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFamiliaNuevaCambios, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCambiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbClienteNuevoCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbFamiliaNuevaCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblScrapCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtScrapCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlCambiosLayout.setVerticalGroup(
            pnlCambiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCambiosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCambiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbFamiliaCambios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFamiliaCambios)
                    .addComponent(lblFamiliaNuevaCambios)
                    .addComponent(cmbFamiliaNuevaCambios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlCambiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCambiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblClienteCambios)
                        .addComponent(cmbClienteCambios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbAreaCambios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblAreaCambios))
                    .addGroup(pnlCambiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblClienteCambios1)
                        .addComponent(cmbClienteNuevoCambios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlCambiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNoParteCambios)
                    .addComponent(cmbNoParteCambios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblParteCambioCambios)
                    .addComponent(cmbNoParteCambioCambios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblScrapCambios)
                    .addComponent(txtScrapCambios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnlPlaneados.setFocusable(false);

        lblAreaPlaneados.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAreaPlaneados.setText("ÁREA");

        cmbAreaPlaneados.setActionCommand("_cmbAreaPlaneados");
        cmbAreaPlaneados.setFocusable(false);
        cmbAreaPlaneados.setNextFocusableComponent(cmbFamiliaPlaneados);

        lblClientePlaneados.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblClientePlaneados.setText("CLIENTE");

        cmbClientePlaneados.setActionCommand("_cmbClientePlaneados");
        cmbClientePlaneados.setFocusable(false);
        cmbClientePlaneados.setNextFocusableComponent(cmbNoPartePlaneados);

        lblNoPartePlaneados.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNoPartePlaneados.setText("No. PARTE");

        cmbNoPartePlaneados.setActionCommand("_cmbNoPartePlaneados");
        cmbNoPartePlaneados.setFocusable(false);
        cmbNoPartePlaneados.setNextFocusableComponent(cmbHora);

        lblFamiliaPlaneados.setText("FAMILIA");

        cmbFamiliaPlaneados.setActionCommand("_cmbFamiliaPlaneados");
        cmbFamiliaPlaneados.setNextFocusableComponent(cmbClientePlaneados);

        javax.swing.GroupLayout pnlPlaneadosLayout = new javax.swing.GroupLayout(pnlPlaneados);
        pnlPlaneados.setLayout(pnlPlaneadosLayout);
        pnlPlaneadosLayout.setHorizontalGroup(
            pnlPlaneadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPlaneadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAreaPlaneados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbAreaPlaneados, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(lblFamiliaPlaneados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbFamiliaPlaneados, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(lblClientePlaneados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbClientePlaneados, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(lblNoPartePlaneados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbNoPartePlaneados, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlPlaneadosLayout.setVerticalGroup(
            pnlPlaneadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPlaneadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPlaneadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPlaneadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbAreaPlaneados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbClientePlaneados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbNoPartePlaneados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPlaneadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblFamiliaPlaneados)
                        .addComponent(cmbFamiliaPlaneados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPlaneadosLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(pnlPlaneadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAreaPlaneados)
                            .addComponent(lblClientePlaneados)
                            .addComponent(lblNoPartePlaneados))))
                .addContainerGap())
        );

        pnlTecnicas.setFocusable(false);
        pnlTecnicas.setMaximumSize(new java.awt.Dimension(1041, 147));

        lblOperacionTecnicas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblOperacionTecnicas.setText("OPERACIÓN");

        cmbOperacionTecnicas.setActionCommand("_cmbOperacionTecnicas");
        cmbOperacionTecnicas.setEnabled(false);
        cmbOperacionTecnicas.setNextFocusableComponent(cmbAreaTecnicas);

        lblAreaTecnicas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAreaTecnicas.setText("ÁREA");

        cmbAreaTecnicas.setActionCommand("_cmbAreaTecnicas");
        cmbAreaTecnicas.setEnabled(false);
        cmbAreaTecnicas.setNextFocusableComponent(cmbProblemaTecnicas);

        lblProblemaTecnicas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblProblemaTecnicas.setText("PROBLEMA");

        cmbProblemaTecnicas.setActionCommand("_cmbProblemaTecnicas");
        cmbProblemaTecnicas.setEnabled(false);
        cmbProblemaTecnicas.setNextFocusableComponent(cmbFamiliaTecnicas);

        lblClienteTecnicas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblClienteTecnicas.setText("CLIENTE");

        cmbClienteTecnicas.setActionCommand("_cmbClienteTecnicas");
        cmbClienteTecnicas.setEnabled(false);
        cmbClienteTecnicas.setNextFocusableComponent(cmbNoParteTecnicas);

        lblNoParteTecnicas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNoParteTecnicas.setText("No. PARTE");

        cmbNoParteTecnicas.setActionCommand("_cmbNoParteTecnicas");
        cmbNoParteTecnicas.setEnabled(false);
        cmbNoParteTecnicas.setNextFocusableComponent(txtScrapTecnicas);

        lblScrapTecnicas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblScrapTecnicas.setText("SCRAP");

        txtScrapTecnicas.setEnabled(false);
        txtScrapTecnicas.setNextFocusableComponent(cmbHora);

        lblFamiliaTecnicas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFamiliaTecnicas.setText("FAMILIA");

        cmbFamiliaTecnicas.setActionCommand("_cmbFamiliaTecnicas");
        cmbFamiliaTecnicas.setEnabled(false);
        cmbFamiliaTecnicas.setNextFocusableComponent(cmbClienteTecnicas);

        javax.swing.GroupLayout pnlTecnicasLayout = new javax.swing.GroupLayout(pnlTecnicas);
        pnlTecnicas.setLayout(pnlTecnicasLayout);
        pnlTecnicasLayout.setHorizontalGroup(
            pnlTecnicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTecnicasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTecnicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblOperacionTecnicas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAreaTecnicas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTecnicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbAreaTecnicas, 0, 200, Short.MAX_VALUE)
                    .addComponent(cmbOperacionTecnicas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlTecnicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblProblemaTecnicas, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                    .addComponent(lblFamiliaTecnicas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTecnicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbProblemaTecnicas, 0, 300, Short.MAX_VALUE)
                    .addComponent(cmbFamiliaTecnicas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlTecnicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblClienteTecnicas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNoParteTecnicas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTecnicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbNoParteTecnicas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbClienteTecnicas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblScrapTecnicas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtScrapTecnicas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlTecnicasLayout.setVerticalGroup(
            pnlTecnicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTecnicasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTecnicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTecnicasLayout.createSequentialGroup()
                        .addGroup(pnlTecnicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblOperacionTecnicas)
                            .addComponent(cmbOperacionTecnicas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlTecnicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAreaTecnicas)
                            .addComponent(cmbAreaTecnicas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFamiliaTecnicas)
                            .addComponent(cmbFamiliaTecnicas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlTecnicasLayout.createSequentialGroup()
                        .addGroup(pnlTecnicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlTecnicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmbClienteTecnicas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblClienteTecnicas))
                            .addGroup(pnlTecnicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblProblemaTecnicas)
                                .addComponent(cmbProblemaTecnicas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(pnlTecnicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlTecnicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblNoParteTecnicas)
                                .addComponent(cmbNoParteTecnicas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlTecnicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblScrapTecnicas)
                                .addComponent(txtScrapTecnicas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );

        pnlCalidad.setFocusable(false);
        pnlCalidad.setMaximumSize(new java.awt.Dimension(1041, 147));

        lblOperacionCalidad.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblOperacionCalidad.setText("OPERACIÓN");

        cmbOperacionCalidad.setActionCommand("_cmbOperacionCalidad");
        cmbOperacionCalidad.setEnabled(false);
        cmbOperacionCalidad.setNextFocusableComponent(cmbAreaCalidad);

        lblAreaCalidad.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAreaCalidad.setText("ÁREA");

        cmbAreaCalidad.setActionCommand("_cmbAreaCalidad");
        cmbAreaCalidad.setEnabled(false);
        cmbAreaCalidad.setNextFocusableComponent(cmbProblemaCalidad);

        lblProblemaCalidad.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblProblemaCalidad.setText("PROBLEMA");

        cmbProblemaCalidad.setActionCommand("_cmbProblemaCalidad");
        cmbProblemaCalidad.setEnabled(false);
        cmbProblemaCalidad.setNextFocusableComponent(cmbFamiliaCalidad);

        lblClienteCalidad.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblClienteCalidad.setText("CLIENTE");

        cmbClienteCalidad.setActionCommand("_cmbClienteCalidad");
        cmbClienteCalidad.setEnabled(false);
        cmbClienteCalidad.setNextFocusableComponent(cmbNoParteCalidad);

        lblNoParteCalidad.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNoParteCalidad.setText("No. PARTE");

        cmbNoParteCalidad.setActionCommand("_cmbNoParteCalidad");
        cmbNoParteCalidad.setEnabled(false);
        cmbNoParteCalidad.setNextFocusableComponent(txtScrapCalidad);

        lblScrapCalidad.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblScrapCalidad.setText("SCRAP");

        txtScrapCalidad.setEnabled(false);
        txtScrapCalidad.setNextFocusableComponent(cmbHora);

        lblFamiliaCalidad.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFamiliaCalidad.setText("FAMILIA");

        cmbFamiliaCalidad.setActionCommand("_cmbFamiliaCalidad");
        cmbFamiliaCalidad.setEnabled(false);
        cmbFamiliaCalidad.setNextFocusableComponent(cmbClienteCalidad);

        javax.swing.GroupLayout pnlCalidadLayout = new javax.swing.GroupLayout(pnlCalidad);
        pnlCalidad.setLayout(pnlCalidadLayout);
        pnlCalidadLayout.setHorizontalGroup(
            pnlCalidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCalidadLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCalidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblOperacionCalidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAreaCalidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCalidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbOperacionCalidad, 0, 200, Short.MAX_VALUE)
                    .addComponent(cmbAreaCalidad, 0, 200, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlCalidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblProblemaCalidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblFamiliaCalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCalidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbProblemaCalidad, 0, 300, Short.MAX_VALUE)
                    .addComponent(cmbFamiliaCalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlCalidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCalidadLayout.createSequentialGroup()
                        .addComponent(lblClienteCalidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbClienteCalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCalidadLayout.createSequentialGroup()
                        .addComponent(lblNoParteCalidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbNoParteCalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(lblScrapCalidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtScrapCalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlCalidadLayout.setVerticalGroup(
            pnlCalidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCalidadLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCalidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlCalidadLayout.createSequentialGroup()
                        .addGroup(pnlCalidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbClienteCalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblClienteCalidad))
                        .addGap(18, 18, 18)
                        .addGroup(pnlCalidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCalidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblScrapCalidad)
                                .addComponent(txtScrapCalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlCalidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblNoParteCalidad)
                                .addComponent(cmbNoParteCalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlCalidadLayout.createSequentialGroup()
                        .addGroup(pnlCalidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblProblemaCalidad)
                            .addComponent(cmbProblemaCalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlCalidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFamiliaCalidad)
                            .addComponent(cmbFamiliaCalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlCalidadLayout.createSequentialGroup()
                        .addGroup(pnlCalidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblOperacionCalidad)
                            .addComponent(cmbOperacionCalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlCalidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAreaCalidad)
                            .addComponent(cmbAreaCalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jLabel2.setText("Tiempo Faltante :");

        javax.swing.GroupLayout pnlTiempoFaltanteLayout = new javax.swing.GroupLayout(pnlTiempoFaltante);
        pnlTiempoFaltante.setLayout(pnlTiempoFaltanteLayout);
        pnlTiempoFaltanteLayout.setHorizontalGroup(
            pnlTiempoFaltanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTiempoFaltanteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlTiempoFaltanteLayout.setVerticalGroup(
            pnlTiempoFaltanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTiempoFaltanteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTiempoFaltanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        mniListarBitacoras.setText("Listar Bítacoras");
        mniListarBitacoras.setFocusable(true);

        mniBitacora.setText("Bítacora");
        mniBitacora.setFocusable(true);

        mniTiemposCiclo.setText("Tiempos Ciclo");
        mniTiemposCiclo.setFocusable(true);

        mniClientes.setText("Clientes");
        mniClientes.setFocusable(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Programa para Bítacora y reportes de producción");
        setIconImage(getIconImage());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pnlBackground.setFocusable(false);
        pnlBackground.setLayout(new java.awt.BorderLayout(0, 5));

        pnlBorderNorth.setFocusable(false);

        lblTema.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTema.setText("TEMA");

        cmbTema.setActionCommand("_cmbTema");
        cmbTema.setEnabled(false);
        cmbTema.setFocusable(false);

        lblLinea.setText("LINEA");

        cmbLinea.setEditable(true);
        cmbLinea.setActionCommand("_cmbLinea");
        cmbLinea.setEnabled(false);
        cmbLinea.setFocusable(false);

        lblFecha.setText("FECHA");

        dteFecha.setEnabled(false);

        btnCambiarLinea.setText("Elegir turno");
        btnCambiarLinea.setActionCommand("_btnCambiarLinea");
        btnCambiarLinea.setFocusable(false);
        btnCambiarLinea.setNextFocusableComponent(cmbLinea);

        javax.swing.GroupLayout pnlBorderNorthLayout = new javax.swing.GroupLayout(pnlBorderNorth);
        pnlBorderNorth.setLayout(pnlBorderNorthLayout);
        pnlBorderNorthLayout.setHorizontalGroup(
            pnlBorderNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBorderNorthLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTema, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbTema, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 225, Short.MAX_VALUE)
                .addComponent(lblLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTurno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCambiarLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 225, Short.MAX_VALUE)
                .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dteFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlBorderNorthLayout.setVerticalGroup(
            pnlBorderNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBorderNorthLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBorderNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBorderNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblLinea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbLinea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblFecha)
                        .addComponent(dteFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCambiarLinea)
                        .addComponent(lblTurno))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBorderNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTema, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbTema)))
                .addContainerGap())
        );

        pnlBackground.add(pnlBorderNorth, java.awt.BorderLayout.NORTH);

        pnlBorder.setFocusable(false);
        pnlBorder.setLayout(new java.awt.BorderLayout(0, 5));

        pnlProduccionCollapsible.setFocusable(false);
        pnlProduccionCollapsible.setTitle("Datos de producción");
        pnlBorder.add(pnlProduccionCollapsible, java.awt.BorderLayout.NORTH);

        pnlBorderTiempoBitacora.setFocusable(false);
        pnlBorderTiempoBitacora.setLayout(new java.awt.BorderLayout(0, 5));

        pnlTiempoIncidencia.setFocusable(false);

        pnlTiempoIncidenciaHora.setBorder(javax.swing.BorderFactory.createTitledBorder("Tiempo de Incidencia:"));
        pnlTiempoIncidenciaHora.setFocusable(false);

        lblHora.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblHora.setText("HORA");

        cmbHora.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecciona Hora", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        cmbHora.setActionCommand("_cmbHora");
        cmbHora.setEnabled(false);

        lblInicio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblInicio.setText("INICIO");

        txtTiempoInicio.setEnabled(false);

        lblFin.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFin.setText("FIN");

        txtTiempoFin.setEnabled(false);

        lblDuracion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDuracion.setText("DURACIÓN");

        txtDuracion.setEditable(false);
        txtDuracion.setEnabled(false);

        javax.swing.GroupLayout pnlTiempoIncidenciaHoraLayout = new javax.swing.GroupLayout(pnlTiempoIncidenciaHora);
        pnlTiempoIncidenciaHora.setLayout(pnlTiempoIncidenciaHoraLayout);
        pnlTiempoIncidenciaHoraLayout.setHorizontalGroup(
            pnlTiempoIncidenciaHoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTiempoIncidenciaHoraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHora)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblInicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTiempoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblFin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTiempoFin, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDuracion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlTiempoIncidenciaHoraLayout.setVerticalGroup(
            pnlTiempoIncidenciaHoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTiempoIncidenciaHoraLayout.createSequentialGroup()
                .addGroup(pnlTiempoIncidenciaHoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHora)
                    .addComponent(cmbHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInicio)
                    .addComponent(txtTiempoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFin)
                    .addComponent(txtTiempoFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDuracion)
                    .addComponent(txtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAgregarBitacora.setText("Agregar a Bitacora");
        btnAgregarBitacora.setActionCommand("_btnAgregarBitacora");
        btnAgregarBitacora.setEnabled(false);

        btnRevisarHoras.setText("Revisar Horas");
        btnRevisarHoras.setActionCommand("_btnRevisarHoras");
        btnRevisarHoras.setEnabled(false);
        btnRevisarHoras.setFocusable(false);

        btnParoPeriodo.setText("Paro por Periodo");
        btnParoPeriodo.setActionCommand("cmbParoPeriodo");

        javax.swing.GroupLayout pnlTiempoIncidenciaLayout = new javax.swing.GroupLayout(pnlTiempoIncidencia);
        pnlTiempoIncidencia.setLayout(pnlTiempoIncidenciaLayout);
        pnlTiempoIncidenciaLayout.setHorizontalGroup(
            pnlTiempoIncidenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTiempoIncidenciaLayout.createSequentialGroup()
                .addComponent(pnlTiempoIncidenciaHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(btnParoPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(btnAgregarBitacora, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 33, Short.MAX_VALUE)
                .addComponent(btnRevisarHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        pnlTiempoIncidenciaLayout.setVerticalGroup(
            pnlTiempoIncidenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTiempoIncidenciaLayout.createSequentialGroup()
                .addGroup(pnlTiempoIncidenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTiempoIncidenciaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlTiempoIncidenciaHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlTiempoIncidenciaLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(pnlTiempoIncidenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregarBitacora)
                            .addComponent(btnRevisarHoras)
                            .addComponent(btnParoPeriodo))))
                .addContainerGap())
        );

        pnlBorderTiempoBitacora.add(pnlTiempoIncidencia, java.awt.BorderLayout.NORTH);

        pnlBitacora.setBorder(javax.swing.BorderFactory.createTitledBorder("Bítacora:"));
        pnlBitacora.setFocusable(false);

        scrBitacora.setFocusable(false);

        tblBitacora.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "<html><center>LINEA</center></html>",
                "<html><center>FECHA</center></html>",
                "<html><center>HORA</center></html>",
                "<html><center>INICIO<br>INCIDENCIA</center></html>",
                "<html><center>FIN<br>INCIDENCIA</center></html>",
                "<html><center>DURACION</center></html>",
                "<html><center>TEMA</center></html>",
                "<html><center>OPERACION</center></html>",
                "<html><center>AREA</center></html>",
                "<html><center>PROBLEMA</center></html>",
                "<html><center>CLIENTE</center></html>",
                "<html><center>NUMERO<br>PARTE</center></html>",
                "<html><center>CANTIDAD</center></html>",
                "<html><center>NUMERO<br>PARTE CAMBIO</center></html>",
                "<html><center>SCRAP</center></html>",
                "<html><center>DETALLE<br>MATERIAL</center></html>",
                "<html><center>TC</center></html>"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTableHeader header = tblBitacora.getTableHeader();
        header.setPreferredSize(new Dimension(
            header.getPreferredSize().width, header.getPreferredSize().height * 2
        )
    );
    tblBitacora.setComponentPopupMenu(pmnClickMenu);
    tblBitacora.setFocusable(false);
    tblBitacora.setIntercellSpacing(new java.awt.Dimension(10, 10));
    tblBitacora.getTableHeader().setReorderingAllowed(false);
    tblBitacora.setUpdateSelectionOnSort(false);
    scrBitacora.setViewportView(tblBitacora);

    btnGuardar.setText("Guardar Bitacora");
    btnGuardar.setActionCommand("_btnGuardar");
    btnGuardar.setFocusable(false);
    btnGuardar.setNextFocusableComponent(cmbLinea);

    btnCancelar.setText("Cancelar");
    btnCancelar.setActionCommand("_btnCancelar");
    btnCancelar.setFocusable(false);
    btnCancelar.setNextFocusableComponent(cmbLinea);

    javax.swing.GroupLayout pnlBitacoraLayout = new javax.swing.GroupLayout(pnlBitacora);
    pnlBitacora.setLayout(pnlBitacoraLayout);
    pnlBitacoraLayout.setHorizontalGroup(
        pnlBitacoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnlBitacoraLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(pnlBitacoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(scrBitacora, javax.swing.GroupLayout.DEFAULT_SIZE, 1265, Short.MAX_VALUE)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBitacoraLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap())
    );
    pnlBitacoraLayout.setVerticalGroup(
        pnlBitacoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBitacoraLayout.createSequentialGroup()
            .addComponent(scrBitacora, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(pnlBitacoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnGuardar)
                .addComponent(btnCancelar)))
    );

    pnlBorderTiempoBitacora.add(pnlBitacora, java.awt.BorderLayout.CENTER);

    pnlBorder.add(pnlBorderTiempoBitacora, java.awt.BorderLayout.CENTER);

    pnlBackground.add(pnlBorder, java.awt.BorderLayout.CENTER);

    mnuAdministrar.setText("Administar");

    mniLineas.setText("Lineas");
    mniLineas.setActionCommand("_mniLineas");
    mniLineas.setFocusable(true);
    mnuAdministrar.add(mniLineas);
    mnuAdministrar.add(jSeparator1);

    mniOperaciones.setText("Operaciones");
    mniOperaciones.setActionCommand("_mniOperaciones");
    mniOperaciones.setEnabled(false);
    mniOperaciones.setFocusable(true);
    mnuAdministrar.add(mniOperaciones);
    mnuAdministrar.add(jSeparator2);

    mnuOtros.setText("Otros");

    mniCrearUsuario.setText("Crear Usuario");
    mniCrearUsuario.setActionCommand("_mniCrearUsuario");
    mniCrearUsuario.setFocusable(true);
    mnuOtros.add(mniCrearUsuario);
    mnuOtros.add(jSeparator7);

    mniCargaMasiva.setText("Carga Masiva");
    mniCargaMasiva.setActionCommand("_mniCargaMasiva");
    mnuOtros.add(mniCargaMasiva);

    mnuAdministrar.add(mnuOtros);

    mnuBarra.add(mnuAdministrar);

    mnuEditar.setText("Editar");
    mnuEditar.setFocusable(false);

    mniEditarPorDia.setText("Bítacora por día");
    mniEditarPorDia.setActionCommand("_mniEditarPorDia");
    mniEditarPorDia.setFocusable(true);
    mnuEditar.add(mniEditarPorDia);
    mnuEditar.add(jSeparator8);

    mniEditarPorTurno.setText("Bítacora por turno");
    mniEditarPorTurno.setActionCommand("_mniEditarPorTurno");
    mnuEditar.add(mniEditarPorTurno);

    mnuBarra.add(mnuEditar);

    mnuGraficas.setText("Gráficas");

    mniHourlyCount.setText("Hourly Count");
    mniHourlyCount.setActionCommand("_mniHourlyCount");
    mnuGraficas.add(mniHourlyCount);

    mnuBarra.add(mnuGraficas);

    setJMenuBar(mnuBarra);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 1300, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 721, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        new SeleccionLinea(this, true).setVisible(true);
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (getTblBitacora().getRowCount() != 0) {
            if (JOptionPane.showConfirmDialog(this, "Existe(n) " + getTblBitacora().getRowCount()
                    + " registro(s) en la bitacora que se perderán si continua\n¿Seguro que desea salir?", "Advertencia",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                try {
                    new PrincipalMetodos().eliminarTurnoVacio(this);
                    new PrincipalMetodos().eliminarRegistroTiempo(this);
                    new BitacoraDAOImpl().borrarRegistroHourly(this.getCmbLinea().getSelectedItem().toString());
                } catch (Exception ex) {
                    System.out.println("Problema closing " + ex);
                }
                System.exit(0);
            }
        } else if (lblTurno.getText().isEmpty()) {
            try {
                new BitacoraDAOImpl().borrarRegistroHourly(this.getCmbLinea().getSelectedItem().toString());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Principal.eliminarHourlyCount()\n" + e,"Error", JOptionPane.ERROR_MESSAGE);
            }
            System.exit(0);
        } else {
            if (PrincipalControl.insercionesAccess == 0) {
                try {
                    new PrincipalMetodos().eliminarTurnoVacio(this);
                    new PrincipalMetodos().eliminarRegistroTiempo(this);
                    new BitacoraDAOImpl().borrarRegistroHourly(this.getCmbLinea().getSelectedItem().toString());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "PrincipalMetodos.eliminarTurnoVacio()\n" + e,"Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    public JMenuItem getMniHourlyCount() {
        return mniHourlyCount;
    }
    
    public JMenuItem getMniEditarPorTurno() {
        return mniEditarPorTurno;
    }

    public JButton getBtnParoPeriodo() {
        return btnParoPeriodo;
    }
    
    public JLabel getLblTurno() {
        return lblTurno;
    }
    
    public JTextField getTxtTC() {
        return txtTC;
    }

    public JLabel getLblMatFaltante() {
        return lblMatFaltante;
    }
    
    public JTextField getTxtMatFaltante() {
        return txtMatFaltante;
    }
    
    public JButton getBtnGuardar(){
        return btnGuardar;
    }
    
    public JButton getBtnCancelar() {
        return btnCancelar;
    }
    
    public JMenuItem getMniEditarPorDia() {
        return mniEditarPorDia;
    }
    
    public JPanel getPnlBitacora() {
        return pnlBitacora;
    }
    
    public JPanel getPnlBorder() {
        return pnlBorder;
    }
    
    public JPanel getPnlCalidad() {
        return pnlCalidad;
    }
    
    public JPanel getPnlCambios() {
        return pnlCambios;
    }
    
    public JPanel getPnlOrganizacionales() {
        return pnlOrganizacionales;
    }
    
    public JPanel getPnlPiezasProducidas() {
        return pnlPiezasProducidas;
    }
    
    public JPanel getPnlPlaneados() {
        return pnlPlaneados;
    }
        
    public WebCollapsiblePane getPnlProduccionCollapsible() {
        return pnlProduccionCollapsible;
    }

    public JPanel getPnlTecnicas() {
        return pnlTecnicas;
    }

    public JComboBox getCmbTema() {
        return cmbTema;
    }

    public JComboBox getCmbLinea() {
        return cmbLinea;
    }

    public JButton getBtnCambiarLinea() {
        return btnCambiarLinea;
    }
    
    public WebDateField getDteFecha(){
        return dteFecha;
    }

    public JComboBox getCmbHora() {
        return cmbHora;
    }

    public JTextField getTxtDuracion() {
        return txtDuracion;
    }

    public JTextField getTxtTiempoInicio() {
        return txtTiempoInicio;
    }

    public JTextField getTxtTiempoFin() {
        return txtTiempoFin;
    }

    public JButton getBtnAgregarBitacora() {
        return btnAgregarBitacora;
    }

    public JButton getBtnRevisarHoras() {
        return btnRevisarHoras;
    }

    public JButton getBtnGuardarBitacora() {
        return btnGuardarBitacora;
    }
    //PANEL PIEZAS PRODUCIDAS
    public JComboBox getCmbClientePzasProd() {
        return cmbClientePzasProd;
    }

    public JComboBox getCmbNoPartePzasProd() {
        return cmbNoPartePzasProd;
    }

    public JTextField getTxtCantidadProducidaPzasProd() {
        return txtCantidadProducidaPzasProd;
    }
    
    public JLabel getLblClientePzasProd(){
        return lblClientePzasProd;
    }
    
    public JLabel getLblFamiliaPzasProd() {
        return lblFamiliaPzasProd;
    }
    
    public JComboBox getCmbFamiliaPzasProd() {
        return cmbFamiliaPzasProd;
    }
    //PANEL CALIDAD
    public JComboBox getCmbAreaCalidad() {
        return cmbAreaCalidad;
    }

    public JComboBox getCmbClienteCalidad() {
        return cmbClienteCalidad;
    }

    public JComboBox getCmbNoParteCalidad() {
        return cmbNoParteCalidad;
    }

    public JComboBox getCmbOperacionCalidad() {
        return cmbOperacionCalidad;
    }

    public JComboBox getCmbProblemaCalidad() {
        return cmbProblemaCalidad;
    }

    public JTextField getTxtScrapCalidad() {
        return txtScrapCalidad;
    }
    
    public JLabel getLblFamiliaCalidad () {
        return lblFamiliaCalidad;
    }
    
    public JComboBox getCmbFamiliaCalidad () {
        return cmbFamiliaCalidad;
    }
    //PANEL TECNICAS
    public JComboBox getCmbAreaTecnicas() {
        return cmbAreaTecnicas;
    }

    public JComboBox getCmbClienteTecnicas() {
        return cmbClienteTecnicas;
    }

    public JComboBox getCmbNoParteTecnicas() {
        return cmbNoParteTecnicas;
    }

    public JComboBox getCmbOperacionTecnicas() {
        return cmbOperacionTecnicas;
    }

    public JComboBox getCmbProblemaTecnicas() {
        return cmbProblemaTecnicas;
    }

    public JTextField getTxtScrapTecnicas() {
        return txtScrapTecnicas;
    }

    public JLabel getLblFamiliaTecnicas() {
        return lblFamiliaTecnicas;
    }

    public JComboBox getCmbFamiliaTecnicas() {
        return cmbFamiliaTecnicas;
    }
    //PANEL ORGANIZACIONALES
    public JComboBox getCmbAreaOrganizacional() {
        return cmbAreaOrganizacional;
    }

    public JComboBox getCmbClienteOrganizacional() {
        return cmbClienteOrganizacional;
    }

    public JComboBox getCmbNoParteOrganizacional() {
        return cmbNoParteOrganizacional;
    }

    public JComboBox getCmbProblemaOrganizacional() {
        return cmbProblemaOrganizacional;
    }
    
    public JLabel getLblFamiliaOrganizacional() {
        return lblFamiliaOrganizacional;
    }
    
    public JComboBox getCmbFamiliaOrganizacional() {
        return cmbFamiliaOrganizacional;
    }
    //PANEL CAMBIOS
    public JComboBox getCmbAreaCambios() {
        return cmbAreaCambios;
    }

    public JComboBox getCmbClienteCambios() {
        return cmbClienteCambios;
    }

    public JComboBox getCmbClienteNuevoCambios() {
        return cmbClienteNuevoCambios;
    }
    
    public JComboBox getCmbNoParteCambioCambios() {
        return cmbNoParteCambioCambios;
    }

    public JComboBox getCmbNoParteCambios() {
        return cmbNoParteCambios;
    }

    public JTextField getTxtScrapCambios() {
        return txtScrapCambios;
    }
    
    public JLabel getLblFamiliaCambios() {
        return lblFamiliaCambios;
    }
    
    public JComboBox getCmbFamiliaCambios() {
        return cmbFamiliaCambios;
    }
    
    public JLabel getLblFamiliaNuevaCambios() {
        return lblFamiliaNuevaCambios;
    }
    
    public JComboBox getCmbFamiliaNuevaCambios() {
        return cmbFamiliaNuevaCambios;
    }
    //PANEL PLANEADOS    
    public JComboBox getCmbAreaPlaneados() {
        return cmbAreaPlaneados;
    }

    public JComboBox getCmbClientePlaneados() {
        return cmbClientePlaneados;
    }

    public JComboBox getCmbNoPartePlaneados() {
        return cmbNoPartePlaneados;
    }
    
    public JLabel getLblFamiliaPlaneados () {
        return lblFamiliaPlaneados;
    }
    
    public JComboBox getCmbFamiliaPlaneados() {
        return cmbFamiliaPlaneados;
    }
    //PANEL BITACORA
    public JScrollPane getScrBitacora() {
        return scrBitacora;
    }
    public JTable getTblBitacora() {
        return tblBitacora;
    }

    public JMenuItem getMniEliminar() {
        return mniEliminar;
    }
    
    public JMenuItem getMniCrearUsuario() {
        return mniCrearUsuario;
    }

    public JMenuItem getMniCargaMasiva() {
        return mniCargaMasiva;
    }
    
    //OPERACIONES
    
    public JMenuItem getMniOperaciones() {
        return mniOperaciones;
    }

    public JMenuItem getMniLineas() {
        return mniLineas;
    }
    
    public JPanel getPnlTiempoFaltante() {
        return pnlTiempoFaltante;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarBitacora;
    private javax.swing.JButton btnCambiarLinea;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarBitacora;
    private javax.swing.JButton btnParoPeriodo;
    private javax.swing.JButton btnRevisarHoras;
    private javax.swing.JComboBox cmbAreaCalidad;
    private javax.swing.JComboBox cmbAreaCambios;
    private javax.swing.JComboBox cmbAreaOrganizacional;
    private javax.swing.JComboBox cmbAreaPlaneados;
    private javax.swing.JComboBox cmbAreaTecnicas;
    private javax.swing.JComboBox cmbClienteCalidad;
    private javax.swing.JComboBox cmbClienteCambios;
    private javax.swing.JComboBox cmbClienteNuevoCambios;
    private javax.swing.JComboBox cmbClienteOrganizacional;
    private javax.swing.JComboBox cmbClientePlaneados;
    private javax.swing.JComboBox cmbClientePzasProd;
    private javax.swing.JComboBox cmbClienteTecnicas;
    private javax.swing.JComboBox<String> cmbFamiliaCalidad;
    private javax.swing.JComboBox<String> cmbFamiliaCambios;
    private javax.swing.JComboBox<String> cmbFamiliaNuevaCambios;
    private javax.swing.JComboBox<String> cmbFamiliaOrganizacional;
    private javax.swing.JComboBox<String> cmbFamiliaPlaneados;
    private javax.swing.JComboBox<String> cmbFamiliaPzasProd;
    private javax.swing.JComboBox<String> cmbFamiliaTecnicas;
    private javax.swing.JComboBox cmbHora;
    private javax.swing.JComboBox cmbLinea;
    private javax.swing.JComboBox cmbNoParteCalidad;
    private javax.swing.JComboBox cmbNoParteCambioCambios;
    private javax.swing.JComboBox cmbNoParteCambios;
    private javax.swing.JComboBox cmbNoParteOrganizacional;
    private javax.swing.JComboBox cmbNoPartePlaneados;
    private javax.swing.JComboBox cmbNoPartePzasProd;
    private javax.swing.JComboBox cmbNoParteTecnicas;
    private javax.swing.JComboBox cmbOperacionCalidad;
    private javax.swing.JComboBox cmbOperacionTecnicas;
    private javax.swing.JComboBox cmbProblemaCalidad;
    private javax.swing.JComboBox cmbProblemaOrganizacional;
    private javax.swing.JComboBox cmbProblemaTecnicas;
    private javax.swing.JComboBox cmbTema;
    private com.alee.extended.date.WebDateField dteFecha;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblAreaCalidad;
    private javax.swing.JLabel lblAreaCambios;
    private javax.swing.JLabel lblAreaOrganizacional;
    private javax.swing.JLabel lblAreaPlaneados;
    private javax.swing.JLabel lblAreaTecnicas;
    private javax.swing.JLabel lblCantidadProducidaPzasProd;
    private javax.swing.JLabel lblClienteCalidad;
    private javax.swing.JLabel lblClienteCambios;
    private javax.swing.JLabel lblClienteCambios1;
    private javax.swing.JLabel lblClienteOrganizacional;
    private javax.swing.JLabel lblClientePlaneados;
    private javax.swing.JLabel lblClientePzasProd;
    private javax.swing.JLabel lblClienteTecnicas;
    private javax.swing.JLabel lblDuracion;
    private javax.swing.JLabel lblFamiliaCalidad;
    private javax.swing.JLabel lblFamiliaCambios;
    private javax.swing.JLabel lblFamiliaNuevaCambios;
    private javax.swing.JLabel lblFamiliaOrganizacional;
    private javax.swing.JLabel lblFamiliaPlaneados;
    private javax.swing.JLabel lblFamiliaPzasProd;
    private javax.swing.JLabel lblFamiliaTecnicas;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFin;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JLabel lblLinea;
    private javax.swing.JLabel lblMatFaltante;
    private javax.swing.JLabel lblNoParteCalidad;
    private javax.swing.JLabel lblNoParteCambios;
    private javax.swing.JLabel lblNoParteOrganizacional;
    private javax.swing.JLabel lblNoPartePlaneados;
    private javax.swing.JLabel lblNoPartePzasProd;
    private javax.swing.JLabel lblNoParteTecnicas;
    private javax.swing.JLabel lblOperacionCalidad;
    private javax.swing.JLabel lblOperacionTecnicas;
    private javax.swing.JLabel lblParteCambioCambios;
    private javax.swing.JLabel lblProblemaCalidad;
    private javax.swing.JLabel lblProblemaOrganizacional;
    private javax.swing.JLabel lblProblemaTecnicas;
    private javax.swing.JLabel lblScrapCalidad;
    private javax.swing.JLabel lblScrapCambios;
    private javax.swing.JLabel lblScrapTecnicas;
    private javax.swing.JLabel lblTC;
    private javax.swing.JLabel lblTema;
    private javax.swing.JLabel lblTurno;
    private javax.swing.JMenuItem mniBitacora;
    private javax.swing.JMenuItem mniCargaMasiva;
    private javax.swing.JMenuItem mniClientes;
    private javax.swing.JMenuItem mniCrearUsuario;
    private javax.swing.JMenuItem mniEditarPorDia;
    private javax.swing.JMenuItem mniEditarPorTurno;
    private javax.swing.JMenuItem mniEliminar;
    private javax.swing.JMenuItem mniHourlyCount;
    private javax.swing.JMenuItem mniLineas;
    private javax.swing.JMenuItem mniListarBitacoras;
    private javax.swing.JMenuItem mniOperaciones;
    private javax.swing.JMenuItem mniTiemposCiclo;
    private javax.swing.JMenu mnuAdministrar;
    private javax.swing.JMenuBar mnuBarra;
    private javax.swing.JMenu mnuEditar;
    private javax.swing.JMenu mnuGraficas;
    private javax.swing.JMenu mnuOtros;
    private javax.swing.JPopupMenu pmnClickMenu;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlBitacora;
    private javax.swing.JPanel pnlBorder;
    private javax.swing.JPanel pnlBorderNorth;
    private javax.swing.JPanel pnlBorderTiempoBitacora;
    private javax.swing.JPanel pnlCalidad;
    private javax.swing.JPanel pnlCambios;
    private javax.swing.JPanel pnlOrganizacionales;
    private javax.swing.JPanel pnlPiezasProducidas;
    private javax.swing.JPanel pnlPlaneados;
    private com.alee.extended.panel.WebCollapsiblePane pnlProduccionCollapsible;
    private javax.swing.JPanel pnlTecnicas;
    private javax.swing.JPanel pnlTiempoFaltante;
    private javax.swing.JPanel pnlTiempoIncidencia;
    private javax.swing.JPanel pnlTiempoIncidenciaHora;
    private javax.swing.JScrollPane scrBitacora;
    private javax.swing.JTable tblBitacora;
    private javax.swing.JTextField txtCantidadProducidaPzasProd;
    private javax.swing.JTextField txtDuracion;
    private javax.swing.JTextField txtMatFaltante;
    private javax.swing.JTextField txtScrapCalidad;
    private javax.swing.JTextField txtScrapCambios;
    private javax.swing.JTextField txtScrapTecnicas;
    private javax.swing.JTextField txtTC;
    private javax.swing.JTextField txtTiempoFin;
    private javax.swing.JTextField txtTiempoInicio;
    // End of variables declaration//GEN-END:variables
}
