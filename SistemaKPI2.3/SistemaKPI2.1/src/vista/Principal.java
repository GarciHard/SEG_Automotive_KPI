package vista;

import com.alee.extended.date.WebDateField;
import com.alee.extended.panel.WebCollapsiblePane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

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
    }

    public Principal(Principal principal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pmnClickMenu = new javax.swing.JPopupMenu();
        mniEliminar = new javax.swing.JMenuItem();
        btnGuardarBitacora = new javax.swing.JButton();
        pnlProduccion = new javax.swing.JPanel();
        lblOperacion = new javax.swing.JLabel();
        cmbOperacion = new javax.swing.JComboBox();
        lblArea = new javax.swing.JLabel();
        cmbArea = new javax.swing.JComboBox();
        lblProblema = new javax.swing.JLabel();
        cmbProblema = new javax.swing.JComboBox();
        lblCliente = new javax.swing.JLabel();
        cmbCliente = new javax.swing.JComboBox();
        lblCantidadProducida = new javax.swing.JLabel();
        txtCantidadProducida = new javax.swing.JTextField();
        lblParteCambio = new javax.swing.JLabel();
        cmbParteCambio = new javax.swing.JComboBox();
        lblNoParte = new javax.swing.JLabel();
        cmbNoParte = new javax.swing.JComboBox();
        lblScrap = new javax.swing.JLabel();
        txtScrap = new javax.swing.JTextField();
        pnlPiezasProducidas = new javax.swing.JPanel();
        lblClientePzasProd = new javax.swing.JLabel();
        cmbClientePzasProd = new javax.swing.JComboBox();
        lblNoPartePzasProd = new javax.swing.JLabel();
        cmbNoPartePzasProd = new javax.swing.JComboBox();
        lblCantidadProducidaPzasProd = new javax.swing.JLabel();
        txtCantidadProducidaPzasProd = new javax.swing.JTextField();
        pnlOrganizacionales = new javax.swing.JPanel();
        lblAreaOrganizacional = new javax.swing.JLabel();
        cmbAreaOrganizacional = new javax.swing.JComboBox();
        lblProblemaOrganizacional = new javax.swing.JLabel();
        cmbProblemaOrganizacional = new javax.swing.JComboBox();
        lblClienteOrganizacional = new javax.swing.JLabel();
        cmbClienteOrganizacional = new javax.swing.JComboBox();
        lblNoParteOrganizacional = new javax.swing.JLabel();
        cmbNoParteOrganizacional = new javax.swing.JComboBox();
        pnlCambios = new javax.swing.JPanel();
        lblAreaCambios = new javax.swing.JLabel();
        cmbAreaCambios = new javax.swing.JComboBox();
        lblProblemaCambios = new javax.swing.JLabel();
        cmbProblemaCambios = new javax.swing.JComboBox();
        lblNoParteCambios = new javax.swing.JLabel();
        cmbNoParteCambios = new javax.swing.JComboBox();
        lblClienteCambios = new javax.swing.JLabel();
        cmbClienteCambios = new javax.swing.JComboBox();
        lblParteCambioCambios = new javax.swing.JLabel();
        cmbNoParteCambioCambios = new javax.swing.JComboBox();
        lblScrapCambios = new javax.swing.JLabel();
        txtScrapCambios = new javax.swing.JTextField();
        pnlPlaneados = new javax.swing.JPanel();
        lblAreaPlaneados = new javax.swing.JLabel();
        cmbAreaPlaneados = new javax.swing.JComboBox();
        lblClientePlaneados = new javax.swing.JLabel();
        cmbClientePlaneados = new javax.swing.JComboBox();
        lblNoPartePlaneados = new javax.swing.JLabel();
        cmbNoPartePlaneados = new javax.swing.JComboBox();
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
        pnlCalidad = new javax.swing.JPanel();
        lblOperacionCalidad = new javax.swing.JLabel();
        cmbOperacionCalidad = new javax.swing.JComboBox();
        lblAreaCalidad = new javax.swing.JLabel();
        cmbAreaCalidad = new javax.swing.JComboBox();
        lblProblemaCalidad = new javax.swing.JLabel();
        cmbProblemaCalidad = new javax.swing.JComboBox();
        lblClienteCalidad = new javax.swing.JLabel();
        cmbClienteCalidad = new javax.swing.JComboBox();
        lblCantidadProducidaCalidad = new javax.swing.JLabel();
        txtCantidadProducidaCalidad = new javax.swing.JTextField();
        lblNoParteCalidad = new javax.swing.JLabel();
        cmbNoParteCalidad = new javax.swing.JComboBox();
        lblScrapCalidad = new javax.swing.JLabel();
        txtScrapCalidad = new javax.swing.JTextField();
        pnlBackground = new javax.swing.JPanel();
        pnlBorderNorth = new javax.swing.JPanel();
        lblTema = new javax.swing.JLabel();
        cmbTema = new javax.swing.JComboBox();
        lblLinea = new javax.swing.JLabel();
        cmbLinea = new javax.swing.JComboBox();
        lblFecha = new javax.swing.JLabel();
        dteFecha = new com.alee.extended.date.WebDateField();
        btnCambiarLinea = new javax.swing.JButton();
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
        pnlBitacora = new javax.swing.JPanel();
        scrBitacora = new javax.swing.JScrollPane();
        tblBitacora = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        tblBitacora = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        mnuBarra = new javax.swing.JMenuBar();
        mnuAdministrar = new javax.swing.JMenu();
        mniBitacora = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mniOperaciones = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mniLineas = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        mniTiemposCiclo = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        mnuOtros = new javax.swing.JMenu();
        mniClientes = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        mniUsuarios = new javax.swing.JMenuItem();
        mnuEditar = new javax.swing.JMenu();
        mniEditarPorDia = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        mniListarBitacoras = new javax.swing.JMenuItem();

        mniEliminar.setText("Eliminar");
        mniEliminar.setActionCommand("_mniEliminar");
        pmnClickMenu.add(mniEliminar);

        btnGuardarBitacora.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnGuardarBitacora.setText("Guardar Bitacora");
        btnGuardarBitacora.setFocusable(false);

        pnlProduccion.setFocusable(false);
        pnlProduccion.setMaximumSize(new java.awt.Dimension(1041, 147));

        lblOperacion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblOperacion.setText("OPERACIÓN");

        cmbOperacion.setActionCommand("_cmbOperacion");
        cmbOperacion.setFocusable(false);

        lblArea.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblArea.setText("ÁREA");

        cmbArea.setActionCommand("_cmbArea");
        cmbArea.setFocusable(false);

        lblProblema.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblProblema.setText("PROBLEMA");

        cmbProblema.setActionCommand("_cmbProblema");
        cmbProblema.setFocusable(false);

        lblCliente.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCliente.setText("CLIENTE");

        cmbCliente.setActionCommand("_cmbCliente");
        cmbCliente.setFocusable(false);

        lblCantidadProducida.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCantidadProducida.setText("CANTIDAD PRODUCIDA");

        txtCantidadProducida.setFocusable(false);

        lblParteCambio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblParteCambio.setText("No. PARTE DE CAMBIO");

        cmbParteCambio.setActionCommand("_cmbParteCambio");
        cmbParteCambio.setFocusable(false);

        lblNoParte.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNoParte.setText("No. PARTE");

        cmbNoParte.setActionCommand("_cmbNoParte");
        cmbNoParte.setFocusable(false);

        lblScrap.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblScrap.setText("SCRAP");

        txtScrap.setFocusable(false);

        javax.swing.GroupLayout pnlProduccionLayout = new javax.swing.GroupLayout(pnlProduccion);
        pnlProduccion.setLayout(pnlProduccionLayout);
        pnlProduccionLayout.setHorizontalGroup(
            pnlProduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProduccionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlProduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblOperacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblProblema, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlProduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbProblema, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbOperacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbArea, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(pnlProduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlProduccionLayout.createSequentialGroup()
                        .addGroup(pnlProduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblCantidadProducida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNoParte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlProduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbNoParte, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCantidadProducida, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlProduccionLayout.createSequentialGroup()
                        .addComponent(lblCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(pnlProduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblParteCambio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblScrap, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlProduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbParteCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtScrap, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnlProduccionLayout.setVerticalGroup(
            pnlProduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProduccionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlProduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlProduccionLayout.createSequentialGroup()
                        .addGroup(pnlProduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlProduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblOperacion)
                                .addComponent(cmbOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlProduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCliente)))
                        .addGap(18, 18, 18)
                        .addGroup(pnlProduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlProduccionLayout.createSequentialGroup()
                                .addGroup(pnlProduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblArea)
                                    .addComponent(cmbArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlProduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblProblema)
                                    .addComponent(cmbProblema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlProduccionLayout.createSequentialGroup()
                                .addGroup(pnlProduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblNoParte)
                                    .addComponent(cmbNoParte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlProduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblCantidadProducida)
                                    .addComponent(txtCantidadProducida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(pnlProduccionLayout.createSequentialGroup()
                        .addGroup(pnlProduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblParteCambio)
                            .addComponent(cmbParteCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlProduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblScrap)
                            .addComponent(txtScrap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        pnlPiezasProducidas.setFocusable(false);

        lblClientePzasProd.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblClientePzasProd.setText("CLIENTE");

        cmbClientePzasProd.setActionCommand("_cmbClientePzasProd");
        cmbClientePzasProd.setEnabled(false);

        lblNoPartePzasProd.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNoPartePzasProd.setText("No. PARTE");

        cmbNoPartePzasProd.setActionCommand("_cmbNoPartePzasProd");
        cmbNoPartePzasProd.setEnabled(false);

        lblCantidadProducidaPzasProd.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCantidadProducidaPzasProd.setText("CANTIDAD PRODUCIDA");

        txtCantidadProducidaPzasProd.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtCantidadProducidaPzasProd.setEnabled(false);

        javax.swing.GroupLayout pnlPiezasProducidasLayout = new javax.swing.GroupLayout(pnlPiezasProducidas);
        pnlPiezasProducidas.setLayout(pnlPiezasProducidasLayout);
        pnlPiezasProducidasLayout.setHorizontalGroup(
            pnlPiezasProducidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPiezasProducidasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblClientePzasProd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbClientePzasProd, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblNoPartePzasProd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbNoPartePzasProd, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCantidadProducidaPzasProd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCantidadProducidaPzasProd, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(txtCantidadProducidaPzasProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnlOrganizacionales.setFocusable(false);

        lblAreaOrganizacional.setText("ÁREA");

        cmbAreaOrganizacional.setActionCommand("_cmbAreaOrganizacional");
        cmbAreaOrganizacional.setEnabled(false);
        cmbAreaOrganizacional.setFocusable(false);

        lblProblemaOrganizacional.setText("PROBLEMA");

        cmbProblemaOrganizacional.setActionCommand("_cmbProblemaOrganizacional");
        cmbProblemaOrganizacional.setEnabled(false);
        cmbProblemaOrganizacional.setFocusable(false);

        lblClienteOrganizacional.setText("CLIENTE");

        cmbClienteOrganizacional.setActionCommand("_cmbClienteOrganizacional");
        cmbClienteOrganizacional.setEnabled(false);
        cmbClienteOrganizacional.setFocusable(false);

        lblNoParteOrganizacional.setText("No. PARTE");

        cmbNoParteOrganizacional.setActionCommand("_cmbNoParteOrganizacional");
        cmbNoParteOrganizacional.setEnabled(false);
        cmbNoParteOrganizacional.setFocusable(false);

        javax.swing.GroupLayout pnlOrganizacionalesLayout = new javax.swing.GroupLayout(pnlOrganizacionales);
        pnlOrganizacionales.setLayout(pnlOrganizacionalesLayout);
        pnlOrganizacionalesLayout.setHorizontalGroup(
            pnlOrganizacionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOrganizacionalesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAreaOrganizacional)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbAreaOrganizacional, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblProblemaOrganizacional)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbProblemaOrganizacional, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblClienteOrganizacional)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbClienteOrganizacional, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblNoParteOrganizacional)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbNoParteOrganizacional, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlOrganizacionalesLayout.setVerticalGroup(
            pnlOrganizacionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOrganizacionalesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlOrganizacionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlOrganizacionalesLayout.createSequentialGroup()
                        .addGroup(pnlOrganizacionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbAreaOrganizacional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbProblemaOrganizacional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbClienteOrganizacional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbNoParteOrganizacional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlOrganizacionalesLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(pnlOrganizacionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNoParteOrganizacional, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblClienteOrganizacional, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblProblemaOrganizacional, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(lblAreaOrganizacional, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlCambios.setFocusable(false);

        lblAreaCambios.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAreaCambios.setText("ÁREA");

        cmbAreaCambios.setActionCommand("_cmbAreaCambios");
        cmbAreaCambios.setEnabled(false);
        cmbAreaCambios.setFocusable(false);

        lblProblemaCambios.setText("PROBLEMA");

        cmbProblemaCambios.setActionCommand("_cmbProblemaCambios");
        cmbProblemaCambios.setEnabled(false);
        cmbProblemaCambios.setFocusable(false);

        lblNoParteCambios.setText("No. PARTE");

        cmbNoParteCambios.setActionCommand("_cmbNoParteCambios");
        cmbNoParteCambios.setEnabled(false);
        cmbNoParteCambios.setFocusable(false);

        lblClienteCambios.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblClienteCambios.setText("CLIENTE");

        cmbClienteCambios.setActionCommand("_cmbClienteCambios");
        cmbClienteCambios.setEnabled(false);
        cmbClienteCambios.setFocusable(false);

        lblParteCambioCambios.setText("No. PARTE CAMBIO");

        cmbNoParteCambioCambios.setActionCommand("_cmbNoParteCambioCambios");
        cmbNoParteCambioCambios.setEnabled(false);
        cmbNoParteCambioCambios.setFocusable(false);

        lblScrapCambios.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblScrapCambios.setText("SCRAP");

        txtScrapCambios.setEnabled(false);

        javax.swing.GroupLayout pnlCambiosLayout = new javax.swing.GroupLayout(pnlCambios);
        pnlCambios.setLayout(pnlCambiosLayout);
        pnlCambiosLayout.setHorizontalGroup(
            pnlCambiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCambiosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCambiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblAreaCambios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblProblemaCambios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCambiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbProblemaCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbAreaCambios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlCambiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCambiosLayout.createSequentialGroup()
                        .addComponent(lblClienteCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbClienteCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCambiosLayout.createSequentialGroup()
                        .addComponent(lblNoParteCambios)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbNoParteCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlCambiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblScrapCambios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblParteCambioCambios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCambiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbNoParteCambioCambios, 0, 200, Short.MAX_VALUE)
                    .addComponent(txtScrapCambios))
                .addContainerGap())
        );
        pnlCambiosLayout.setVerticalGroup(
            pnlCambiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCambiosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCambiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlCambiosLayout.createSequentialGroup()
                        .addGroup(pnlCambiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCambiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblClienteCambios)
                                .addComponent(cmbClienteCambios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlCambiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblParteCambioCambios)
                                .addComponent(cmbNoParteCambioCambios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(pnlCambiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCambiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblNoParteCambios)
                                .addComponent(cmbNoParteCambios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlCambiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblScrapCambios)
                                .addComponent(txtScrapCambios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlCambiosLayout.createSequentialGroup()
                        .addGroup(pnlCambiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAreaCambios)
                            .addComponent(cmbAreaCambios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlCambiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblProblemaCambios)
                            .addComponent(cmbProblemaCambios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        pnlPlaneados.setFocusable(false);

        lblAreaPlaneados.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAreaPlaneados.setText("ÁREA");

        cmbAreaPlaneados.setActionCommand("_cmbAreaPlaneados");
        cmbAreaPlaneados.setFocusable(false);

        lblClientePlaneados.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblClientePlaneados.setText("CLIENTE");

        cmbClientePlaneados.setActionCommand("_cmbClientePlaneados");
        cmbClientePlaneados.setFocusable(false);

        lblNoPartePlaneados.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNoPartePlaneados.setText("No. PARTE");

        cmbNoPartePlaneados.setActionCommand("_cmbNoPartePlaneados");
        cmbNoPartePlaneados.setFocusable(false);

        javax.swing.GroupLayout pnlPlaneadosLayout = new javax.swing.GroupLayout(pnlPlaneados);
        pnlPlaneados.setLayout(pnlPlaneadosLayout);
        pnlPlaneadosLayout.setHorizontalGroup(
            pnlPlaneadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPlaneadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAreaPlaneados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbAreaPlaneados, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblClientePlaneados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbClientePlaneados, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addGroup(pnlPlaneadosLayout.createSequentialGroup()
                        .addGroup(pnlPlaneadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbAreaPlaneados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbClientePlaneados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbNoPartePlaneados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlPlaneadosLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(pnlPlaneadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNoPartePlaneados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblClientePlaneados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAreaPlaneados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        pnlTecnicas.setFocusable(false);
        pnlTecnicas.setMaximumSize(new java.awt.Dimension(1041, 147));

        lblOperacionTecnicas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblOperacionTecnicas.setText("OPERACIÓN");

        cmbOperacionTecnicas.setActionCommand("_cmbOperacionTecnicas");
        cmbOperacionTecnicas.setEnabled(false);
        cmbOperacionTecnicas.setFocusable(false);

        lblAreaTecnicas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAreaTecnicas.setText("ÁREA");

        cmbAreaTecnicas.setActionCommand("_cmbAreaTecnicas");
        cmbAreaTecnicas.setEnabled(false);
        cmbAreaTecnicas.setFocusable(false);

        lblProblemaTecnicas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblProblemaTecnicas.setText("PROBLEMA");

        cmbProblemaTecnicas.setActionCommand("_cmbProblemaTecnicas");
        cmbProblemaTecnicas.setEnabled(false);
        cmbProblemaTecnicas.setFocusable(false);

        lblClienteTecnicas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblClienteTecnicas.setText("CLIENTE");

        cmbClienteTecnicas.setActionCommand("_cmbClienteTecnicas");
        cmbClienteTecnicas.setEnabled(false);
        cmbClienteTecnicas.setFocusable(false);

        lblNoParteTecnicas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNoParteTecnicas.setText("No. PARTE");

        cmbNoParteTecnicas.setActionCommand("_cmbNoParteTecnicas");
        cmbNoParteTecnicas.setEnabled(false);
        cmbNoParteTecnicas.setFocusable(false);

        lblScrapTecnicas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblScrapTecnicas.setText("SCRAP");

        txtScrapTecnicas.setEnabled(false);

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
                    .addComponent(cmbOperacionTecnicas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbAreaTecnicas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlTecnicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblProblemaTecnicas, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                    .addComponent(lblClienteTecnicas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTecnicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbProblemaTecnicas, 0, 200, Short.MAX_VALUE)
                    .addComponent(cmbClienteTecnicas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlTecnicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNoParteTecnicas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblScrapTecnicas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTecnicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbNoParteTecnicas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtScrapTecnicas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnlTecnicasLayout.setVerticalGroup(
            pnlTecnicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTecnicasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTecnicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTecnicasLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(pnlTecnicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblScrapTecnicas)
                            .addComponent(txtScrapTecnicas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlTecnicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNoParteTecnicas)
                        .addComponent(cmbNoParteTecnicas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlTecnicasLayout.createSequentialGroup()
                        .addGroup(pnlTecnicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblOperacionTecnicas)
                            .addComponent(cmbOperacionTecnicas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlTecnicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAreaTecnicas)
                            .addComponent(cmbAreaTecnicas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlTecnicasLayout.createSequentialGroup()
                        .addGroup(pnlTecnicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblProblemaTecnicas)
                            .addComponent(cmbProblemaTecnicas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlTecnicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbClienteTecnicas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblClienteTecnicas))))
                .addContainerGap())
        );

        pnlCalidad.setFocusable(false);
        pnlCalidad.setMaximumSize(new java.awt.Dimension(1041, 147));

        lblOperacionCalidad.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblOperacionCalidad.setText("OPERACIÓN");

        cmbOperacionCalidad.setActionCommand("_cmbOperacionCalidad");
        cmbOperacionCalidad.setEnabled(false);

        lblAreaCalidad.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAreaCalidad.setText("ÁREA");

        cmbAreaCalidad.setActionCommand("_cmbAreaCalidad");
        cmbAreaCalidad.setEnabled(false);

        lblProblemaCalidad.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblProblemaCalidad.setText("PROBLEMA");

        cmbProblemaCalidad.setActionCommand("_cmbProblemaCalidad");
        cmbProblemaCalidad.setEnabled(false);

        lblClienteCalidad.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblClienteCalidad.setText("CLIENTE");

        cmbClienteCalidad.setActionCommand("_cmbClienteCalidad");
        cmbClienteCalidad.setEnabled(false);

        lblCantidadProducidaCalidad.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCantidadProducidaCalidad.setText("CANTIDAD PRODUCIDA");

        txtCantidadProducidaCalidad.setEnabled(false);

        lblNoParteCalidad.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNoParteCalidad.setText("No. PARTE");

        cmbNoParteCalidad.setActionCommand("_cmbNoParteCalidad");
        cmbNoParteCalidad.setEnabled(false);

        lblScrapCalidad.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblScrapCalidad.setText("SCRAP");

        txtScrapCalidad.setEnabled(false);

        javax.swing.GroupLayout pnlCalidadLayout = new javax.swing.GroupLayout(pnlCalidad);
        pnlCalidad.setLayout(pnlCalidadLayout);
        pnlCalidadLayout.setHorizontalGroup(
            pnlCalidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCalidadLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCalidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblOperacionCalidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAreaCalidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblProblemaCalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCalidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbAreaCalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbOperacionCalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbProblemaCalidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlCalidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlCalidadLayout.createSequentialGroup()
                        .addGroup(pnlCalidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblCantidadProducidaCalidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNoParteCalidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCalidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbNoParteCalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCantidadProducidaCalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlCalidadLayout.createSequentialGroup()
                        .addComponent(lblClienteCalidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbClienteCalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblScrapCalidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtScrapCalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlCalidadLayout.setVerticalGroup(
            pnlCalidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCalidadLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCalidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCalidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblOperacionCalidad)
                        .addComponent(cmbOperacionCalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCalidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbClienteCalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblClienteCalidad)))
                .addGap(18, 18, 18)
                .addGroup(pnlCalidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCalidadLayout.createSequentialGroup()
                        .addGroup(pnlCalidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAreaCalidad)
                            .addComponent(cmbAreaCalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlCalidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblProblemaCalidad)
                            .addComponent(cmbProblemaCalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlCalidadLayout.createSequentialGroup()
                        .addGroup(pnlCalidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNoParteCalidad)
                            .addComponent(cmbNoParteCalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlCalidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCalidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblScrapCalidad)
                                .addComponent(txtScrapCalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlCalidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblCantidadProducidaCalidad)
                                .addComponent(txtCantidadProducidaCalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Programa para Bítacora y reportes de producción");

        pnlBackground.setFocusable(false);
        pnlBackground.setLayout(new java.awt.BorderLayout(0, 5));

        pnlBorderNorth.setFocusable(false);

        lblTema.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTema.setText("TEMA");

        cmbTema.setActionCommand("_cmbTema");
        cmbTema.setEnabled(false);
        cmbTema.setFocusable(false);

        lblLinea.setText("LINEA");

        cmbLinea.setActionCommand("_cmbLinea");
        cmbLinea.setEnabled(false);
        cmbLinea.setFocusable(false);

        lblFecha.setText("FECHA");

        dteFecha.setEnabled(false);

        btnCambiarLinea.setText("Cambiar Linea");
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
                .addComponent(lblLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCambiarLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
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
                        .addComponent(btnCambiarLinea))
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

        cmbHora.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecciona Hora", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
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

        javax.swing.GroupLayout pnlTiempoIncidenciaLayout = new javax.swing.GroupLayout(pnlTiempoIncidencia);
        pnlTiempoIncidencia.setLayout(pnlTiempoIncidenciaLayout);
        pnlTiempoIncidenciaLayout.setHorizontalGroup(
            pnlTiempoIncidenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTiempoIncidenciaLayout.createSequentialGroup()
                .addComponent(pnlTiempoIncidenciaHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregarBitacora, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRevisarHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                            .addComponent(btnRevisarHoras))))
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
                "LINEA", "FECHA", "HORA", "INICIO INCIDENCIA", "FIN INCIDENCIA", "DURACION", "TEMA", "OPERACION", "AREA", "PROBLEMA", "CLIENTE", "No. PARTE", "CANTIDAD", "No. PARTE CAMBIO", "SCRAP"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlBitacoraLayout.setVerticalGroup(
            pnlBitacoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBitacoraLayout.createSequentialGroup()
                .addComponent(scrBitacora, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar))
        );

        pnlBorderTiempoBitacora.add(pnlBitacora, java.awt.BorderLayout.CENTER);

        pnlBorder.add(pnlBorderTiempoBitacora, java.awt.BorderLayout.CENTER);

        pnlBackground.add(pnlBorder, java.awt.BorderLayout.CENTER);

        mnuAdministrar.setText("Administar");

        mniBitacora.setText("Bítacora");
        mniBitacora.setFocusable(true);
        mnuAdministrar.add(mniBitacora);
        mnuAdministrar.add(jSeparator1);

        mniOperaciones.setText("Operaciones");
        mniOperaciones.setFocusable(true);
        mnuAdministrar.add(mniOperaciones);
        mnuAdministrar.add(jSeparator2);

        mniLineas.setText("Lineas");
        mniLineas.setFocusable(true);
        mnuAdministrar.add(mniLineas);
        mnuAdministrar.add(jSeparator3);

        mniTiemposCiclo.setText("Tiempos Ciclo");
        mniTiemposCiclo.setFocusable(true);
        mnuAdministrar.add(mniTiemposCiclo);
        mnuAdministrar.add(jSeparator5);

        mnuOtros.setText("Otros");

        mniClientes.setText("Clientes");
        mniClientes.setFocusable(true);
        mnuOtros.add(mniClientes);
        mnuOtros.add(jSeparator4);

        mniUsuarios.setText("Usuarios");
        mniUsuarios.setFocusable(true);
        mnuOtros.add(mniUsuarios);

        mnuAdministrar.add(mnuOtros);

        mnuBarra.add(mnuAdministrar);

        mnuEditar.setText("Editar");
        mnuEditar.setFocusable(false);

        mniEditarPorDia.setText("Bítacora por día");
        mniEditarPorDia.setActionCommand("_mniEditarPorDia");
        mniEditarPorDia.setFocusable(true);
        mnuEditar.add(mniEditarPorDia);
        mnuEditar.add(jSeparator6);

        mniListarBitacoras.setText("Listar Bítacoras");
        mniListarBitacoras.setFocusable(true);
        mnuEditar.add(mniListarBitacoras);

        mnuBarra.add(mnuEditar);

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
            .addGap(0, 719, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public JButton getBtnGuardar(){
        return btnGuardar;
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
    
    public JPanel getPnlProduccion() {
        return pnlProduccion;
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

    public JTextField getTxtCantidadProducidaCalidad() {
        return txtCantidadProducidaCalidad;
    }

    public JTextField getTxtScrapCalidad() {
        return txtScrapCalidad;
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
    //PANEL CAMBIOS
    public JComboBox getCmbAreaCambios() {
        return cmbAreaCambios;
    }

    public JComboBox getCmbClienteCambios() {
        return cmbClienteCambios;
    }

    public JComboBox getCmbNoParteCambioCambios() {
        return cmbNoParteCambioCambios;
    }

    public JComboBox getCmbNoParteCambios() {
        return cmbNoParteCambios;
    }

    public JComboBox getCmbProblemaCambios() {
        return cmbProblemaCambios;
    }

    public JTextField getTxtScrapCambios() {
        return txtScrapCambios;
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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarBitacora;
    private javax.swing.JButton btnCambiarLinea;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarBitacora;
    private javax.swing.JButton btnRevisarHoras;
    private javax.swing.JComboBox cmbArea;
    private javax.swing.JComboBox cmbAreaCalidad;
    private javax.swing.JComboBox cmbAreaCambios;
    private javax.swing.JComboBox cmbAreaOrganizacional;
    private javax.swing.JComboBox cmbAreaPlaneados;
    private javax.swing.JComboBox cmbAreaTecnicas;
    private javax.swing.JComboBox cmbCliente;
    private javax.swing.JComboBox cmbClienteCalidad;
    private javax.swing.JComboBox cmbClienteCambios;
    private javax.swing.JComboBox cmbClienteOrganizacional;
    private javax.swing.JComboBox cmbClientePlaneados;
    private javax.swing.JComboBox cmbClientePzasProd;
    private javax.swing.JComboBox cmbClienteTecnicas;
    private javax.swing.JComboBox cmbHora;
    private javax.swing.JComboBox cmbLinea;
    private javax.swing.JComboBox cmbNoParte;
    private javax.swing.JComboBox cmbNoParteCalidad;
    private javax.swing.JComboBox cmbNoParteCambioCambios;
    private javax.swing.JComboBox cmbNoParteCambios;
    private javax.swing.JComboBox cmbNoParteOrganizacional;
    private javax.swing.JComboBox cmbNoPartePlaneados;
    private javax.swing.JComboBox cmbNoPartePzasProd;
    private javax.swing.JComboBox cmbNoParteTecnicas;
    private javax.swing.JComboBox cmbOperacion;
    private javax.swing.JComboBox cmbOperacionCalidad;
    private javax.swing.JComboBox cmbOperacionTecnicas;
    private javax.swing.JComboBox cmbParteCambio;
    private javax.swing.JComboBox cmbProblema;
    private javax.swing.JComboBox cmbProblemaCalidad;
    private javax.swing.JComboBox cmbProblemaCambios;
    private javax.swing.JComboBox cmbProblemaOrganizacional;
    private javax.swing.JComboBox cmbProblemaTecnicas;
    private javax.swing.JComboBox cmbTema;
    private com.alee.extended.date.WebDateField dteFecha;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JLabel lblArea;
    private javax.swing.JLabel lblAreaCalidad;
    private javax.swing.JLabel lblAreaCambios;
    private javax.swing.JLabel lblAreaOrganizacional;
    private javax.swing.JLabel lblAreaPlaneados;
    private javax.swing.JLabel lblAreaTecnicas;
    private javax.swing.JLabel lblCantidadProducida;
    private javax.swing.JLabel lblCantidadProducidaCalidad;
    private javax.swing.JLabel lblCantidadProducidaPzasProd;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblClienteCalidad;
    private javax.swing.JLabel lblClienteCambios;
    private javax.swing.JLabel lblClienteOrganizacional;
    private javax.swing.JLabel lblClientePlaneados;
    private javax.swing.JLabel lblClientePzasProd;
    private javax.swing.JLabel lblClienteTecnicas;
    private javax.swing.JLabel lblDuracion;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFin;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JLabel lblLinea;
    private javax.swing.JLabel lblNoParte;
    private javax.swing.JLabel lblNoParteCalidad;
    private javax.swing.JLabel lblNoParteCambios;
    private javax.swing.JLabel lblNoParteOrganizacional;
    private javax.swing.JLabel lblNoPartePlaneados;
    private javax.swing.JLabel lblNoPartePzasProd;
    private javax.swing.JLabel lblNoParteTecnicas;
    private javax.swing.JLabel lblOperacion;
    private javax.swing.JLabel lblOperacionCalidad;
    private javax.swing.JLabel lblOperacionTecnicas;
    private javax.swing.JLabel lblParteCambio;
    private javax.swing.JLabel lblParteCambioCambios;
    private javax.swing.JLabel lblProblema;
    private javax.swing.JLabel lblProblemaCalidad;
    private javax.swing.JLabel lblProblemaCambios;
    private javax.swing.JLabel lblProblemaOrganizacional;
    private javax.swing.JLabel lblProblemaTecnicas;
    private javax.swing.JLabel lblScrap;
    private javax.swing.JLabel lblScrapCalidad;
    private javax.swing.JLabel lblScrapCambios;
    private javax.swing.JLabel lblScrapTecnicas;
    private javax.swing.JLabel lblTema;
    private javax.swing.JMenuItem mniBitacora;
    private javax.swing.JMenuItem mniClientes;
    private javax.swing.JMenuItem mniEditarPorDia;
    private javax.swing.JMenuItem mniEliminar;
    private javax.swing.JMenuItem mniLineas;
    private javax.swing.JMenuItem mniListarBitacoras;
    private javax.swing.JMenuItem mniOperaciones;
    private javax.swing.JMenuItem mniTiemposCiclo;
    private javax.swing.JMenuItem mniUsuarios;
    private javax.swing.JMenu mnuAdministrar;
    private javax.swing.JMenuBar mnuBarra;
    private javax.swing.JMenu mnuEditar;
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
    private javax.swing.JPanel pnlProduccion;
    private com.alee.extended.panel.WebCollapsiblePane pnlProduccionCollapsible;
    private javax.swing.JPanel pnlTecnicas;
    private javax.swing.JPanel pnlTiempoIncidencia;
    private javax.swing.JPanel pnlTiempoIncidenciaHora;
    private javax.swing.JScrollPane scrBitacora;
    private javax.swing.JTable tblBitacora;
    private javax.swing.JTextField txtCantidadProducida;
    private javax.swing.JTextField txtCantidadProducidaCalidad;
    private javax.swing.JTextField txtCantidadProducidaPzasProd;
    private javax.swing.JTextField txtDuracion;
    private javax.swing.JTextField txtScrap;
    private javax.swing.JTextField txtScrapCalidad;
    private javax.swing.JTextField txtScrapCambios;
    private javax.swing.JTextField txtScrapTecnicas;
    private javax.swing.JTextField txtTiempoFin;
    private javax.swing.JTextField txtTiempoInicio;
    // End of variables declaration//GEN-END:variables
}
