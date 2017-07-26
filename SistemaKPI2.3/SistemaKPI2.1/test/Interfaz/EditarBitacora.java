/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Clases.*;
//import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.util.Date;

/**
 *
 * @author zgm_e
 */
public class EditarBitacora extends javax.swing.JFrame {

    static Consultas cls;
    public static Modelos ms;
    static Reportes rp;
    static Inserciones in;
    Date now = new Date(System.currentTimeMillis());
    Time hora = new Time(System.currentTimeMillis());
    SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
    static int mod;
    DefaultComboBoxModel listaVacia = new DefaultComboBoxModel();

    /**
     * Creates new form PrincipalOne
     */
    public EditarBitacora() {
        cls = new Consultas();
        ms = new Modelos();
        rp = new Reportes();
        in = new Inserciones();
        initComponents();
        cls = new Consultas();
        this.setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/bs.png")).getImage());
        cmbArea.setEnabled(false);
        cmbCliente.setEnabled(false);
        cmbProblema.setEnabled(false);
        cmbNoParte.setEnabled(false);
        cmbOperacion.setEnabled(false);
        txtCantidad.setEnabled(false);
        txtTiempoInicio.setEnabled(false);
        cmbLinea.setEnabled(false);
        txtTiempoFin.setEnabled(false);
        txtDuracion.setEditable(false);
        cmbParteCambio.setVisible(false);
        labelPartecambio.setVisible(false);
        cmbTema.setModel(cls.ListaTemas());
        cmbLinea.setModel(cls.lineas());
        tablaBitacora.setModel(ms.columnasModelos(1, 0, (DefaultTableModel) tablaBitacora.getModel()));
        for (int i = 0; i < tablaBitacora.getColumnCount(); i++) {
            tablaBitacora.getColumnModel().getColumn(i).setPreferredWidth(80);
        }
        tablaBitacora.getColumnModel().getColumn(3).setPreferredWidth(120);
        tablaBitacora.getColumnModel().getColumn(4).setPreferredWidth(120);
        tablaBitacora.getColumnModel().getColumn(7).setPreferredWidth(120);
        tablaBitacora.getColumnModel().getColumn(13).setPreferredWidth(120);
        tablaBitacora.setAutoResizeMode(tablaBitacora.AUTO_RESIZE_OFF);
        TableRowSorter<TableModel> elQueOrdena = new TableRowSorter<TableModel>(tablaBitacora.getModel());
        tablaBitacora.setRowSorter(elQueOrdena);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JPopupMenu();
        menuEliminar = new javax.swing.JMenuItem();
        jLabel3 = new javax.swing.JLabel();
        paneltiempoIncidencia = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDuracion = new javax.swing.JTextField();
        txtTiempoInicio = new javax.swing.JTextField();
        txtTiempoFin = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmbHora = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbLinea = new javax.swing.JComboBox();
        cmbTema = new javax.swing.JComboBox();
        btnAgregar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        cmbProblema = new javax.swing.JComboBox();
        cmbArea = new javax.swing.JComboBox();
        cmbOperacion = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cmbCliente = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        labelPartecambio = new javax.swing.JLabel();
        cmbParteCambio = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        cmbNoParte = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaBitacora = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        tablaBitacora = new javax.swing.JTable();
        btnCambiarLinea = new javax.swing.JButton();
        btnRevisar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        cmbDia = new javax.swing.JComboBox();
        txtAnio = new javax.swing.JTextField();
        cmbMes = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        menuEliminar.setText("Eliminar");
        menuEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEliminarActionPerformed(evt);
            }
        });
        menu.add(menuEliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Edición de bitacora por día");
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        jLabel3.setText("FECHA:");

        paneltiempoIncidencia.setBorder(javax.swing.BorderFactory.createTitledBorder("TIEMPO INCIDENCIA"));

        jLabel2.setText("FIN:");

        jLabel1.setText("INICIO:");

        jLabel5.setText("DURACION:");

        txtDuracion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDuracionKeyReleased(evt);
            }
        });

        txtTiempoInicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTiempoInicioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTiempoInicioKeyTyped(evt);
            }
        });

        txtTiempoFin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTiempoFinKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTiempoFinKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTiempoFinKeyTyped(evt);
            }
        });

        jLabel4.setText("HORA:");

        cmbHora.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecciona Hora", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        cmbHora.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbHoraItemStateChanged(evt);
            }
        });
        cmbHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbHoraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneltiempoIncidenciaLayout = new javax.swing.GroupLayout(paneltiempoIncidencia);
        paneltiempoIncidencia.setLayout(paneltiempoIncidenciaLayout);
        paneltiempoIncidenciaLayout.setHorizontalGroup(
            paneltiempoIncidenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneltiempoIncidenciaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addComponent(cmbHora, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTiempoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTiempoFin, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
        );
        paneltiempoIncidenciaLayout.setVerticalGroup(
            paneltiempoIncidenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneltiempoIncidenciaLayout.createSequentialGroup()
                .addGroup(paneltiempoIncidenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtTiempoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtTiempoFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setText("TEMA:");

        jLabel7.setText("LINEA:");

        cmbLinea.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbLineaItemStateChanged(evt);
            }
        });

        cmbTema.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTemaItemStateChanged(evt);
            }
        });
        cmbTema.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                cmbTemaCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                cmbTemaInputMethodTextChanged(evt);
            }
        });
        cmbTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTemaActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar a Bitacora");
        btnAgregar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnAgregarMouseMoved(evt);
            }
        });
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Producción:"));

        cmbProblema.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbProblemaItemStateChanged(evt);
            }
        });

        cmbArea.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbAreaItemStateChanged(evt);
            }
        });
        cmbArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAreaActionPerformed(evt);
            }
        });

        cmbOperacion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbOperacionItemStateChanged(evt);
            }
        });

        jLabel11.setText("OPERACION:");

        jLabel13.setText("AREA:");

        jLabel14.setText("PROBLEMA:");

        jLabel9.setText("CLIENTE:");

        cmbCliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbClienteItemStateChanged(evt);
            }
        });
        cmbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbClienteActionPerformed(evt);
            }
        });

        jLabel12.setText("CANTIDAD PRODUCIDA:");

        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        labelPartecambio.setText("NO. PARTE DE CAMBIO:");

        jLabel10.setText("NO. PARTE:");

        cmbNoParte.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbNoParteItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbOperacion, 0, 193, Short.MAX_VALUE)
                            .addComponent(cmbArea, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbProblema, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(73, 73, 73)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(labelPartecambio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbParteCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbNoParte, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cmbOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(cmbNoParte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cmbArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(cmbProblema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPartecambio)
                    .addComponent(cmbParteCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Bítacora:"));

        tablaBitacora.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaBitacora.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablaBitacora.setComponentPopupMenu(menu);
        tablaBitacora.getTableHeader().setReorderingAllowed(false);
        tablaBitacora.setUpdateSelectionOnSort(false);
        jScrollPane1.setViewportView(tablaBitacora);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 23, Short.MAX_VALUE))
        );

        btnCambiarLinea.setText("Cambiar Linea");
        btnCambiarLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarLineaActionPerformed(evt);
            }
        });

        btnRevisar.setText("Revisar Horas");
        btnRevisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRevisarActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnGuardar.setText("Guardar Bitacora");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cmbDia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        txtAnio.setEditable(false);

        cmbMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        cmbMes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMesItemStateChanged(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Dia:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Mes:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Año:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbTema, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(cmbLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCambiarLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbDia, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(paneltiempoIncidencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregar)
                        .addGap(18, 18, 18)
                        .addComponent(btnRevisar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(49, 49, 49)
                .addComponent(jLabel15)
                .addGap(54, 54, 54)
                .addComponent(jLabel16)
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbLinea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(btnCambiarLinea)
                    .addComponent(jLabel3)
                    .addComponent(cmbDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(paneltiempoIncidencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRevisar)
                            .addComponent(btnAgregar))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

    }//GEN-LAST:event_formWindowActivated

    private void cmbTemaCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_cmbTemaCaretPositionChanged

    }//GEN-LAST:event_cmbTemaCaretPositionChanged

    private void cmbTemaInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_cmbTemaInputMethodTextChanged

    }//GEN-LAST:event_cmbTemaInputMethodTextChanged

    private void cmbTemaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTemaItemStateChanged
        cmbArea.setEnabled(false);
        cmbArea.setModel(listaVacia);
        cmbCliente.setEnabled(false);
        cmbCliente.setModel(listaVacia);
        cmbProblema.setEnabled(false);
        cmbProblema.setModel(listaVacia);
        cmbNoParte.setEnabled(false);
        cmbNoParte.setModel(listaVacia);
        cmbOperacion.setEnabled(false);
        cmbOperacion.setModel(listaVacia);
        txtCantidad.setEnabled(false);
        txtTiempoInicio.setEnabled(false);
        txtTiempoFin.setEnabled(false);
        labelPartecambio.setVisible(false);
        cmbParteCambio.setVisible(false);
        txtTiempoInicio.setText("");
        txtTiempoFin.setText("");
        txtDuracion.setText("");
        txtCantidad.setText("");
        if (cmbTema.getSelectedIndex() != 0) {
            if (cmbTema.getSelectedIndex() == 2 || cmbTema.getSelectedIndex() == 3) {
                cmbArea.setModel(listaVacia);
                cmbCliente.setModel(listaVacia);
                cmbProblema.setModel(listaVacia);
                cmbNoParte.setModel(listaVacia);
                cmbOperacion.setModel(listaVacia);
                txtCantidad.setText("");
                cmbOperacion.setEnabled(true);
                cmbOperacion.setModel(cls.ListaOperaciones(cmbTema.getSelectedItem().toString(), cmbLinea.getSelectedItem().toString()));
            } else if (cmbTema.getSelectedIndex() == 4) {
                cmbArea.setModel(listaVacia);
                cmbCliente.setModel(listaVacia);
                cmbProblema.setModel(listaVacia);
                cmbNoParte.setModel(listaVacia);
                cmbOperacion.setModel(listaVacia);
                txtCantidad.setText("");
                cmbOperacion.setModel(cls.ListaOperaciones(cmbTema.getSelectedItem().toString(), cmbLinea.getSelectedItem().toString()));
                cmbOperacion.setSelectedIndex(1);
                cmbArea.setEnabled(true);
                cmbArea.setModel(cls.ListaAreasPorOperacion(cmbLinea.getSelectedItem().toString(), cmbTema.getSelectedItem().toString(), cmbOperacion.getSelectedItem().toString()));
            } else if (cmbTema.getSelectedIndex() == 5 || cmbTema.getSelectedIndex() == 6) {
                cmbOperacion.setModel(cls.ListaOperaciones(cmbTema.getSelectedItem().toString(), cmbLinea.getSelectedItem().toString()));
                cmbOperacion.setSelectedIndex(1);
                cmbArea.setEnabled(true);
                txtCantidad.setText("");
            } else {
                cmbOperacion.setModel(cls.ListaOperaciones(cmbTema.getSelectedItem().toString(), cmbLinea.getSelectedItem().toString()));
                cmbOperacion.setSelectedIndex(1);
                cmbCliente.setEnabled(true);
                cmbCliente.setModel(cls.ListaClientes(cmbLinea.getSelectedItem().toString()));
                txtCantidad.setText("");
            }
        } else {
            cmbArea.setEnabled(false);
            cmbArea.setModel(listaVacia);
            cmbCliente.setEnabled(false);
            cmbCliente.setModel(listaVacia);
            cmbProblema.setEnabled(false);
            cmbProblema.setModel(listaVacia);
            cmbNoParte.setEnabled(false);
            cmbNoParte.setModel(listaVacia);
            cmbOperacion.setEnabled(false);
            cmbOperacion.setModel(listaVacia);
            txtCantidad.setEnabled(false);
            txtTiempoInicio.setEnabled(false);
            txtTiempoFin.setEnabled(false);
            txtTiempoInicio.setText("");
            txtTiempoFin.setText("");
            txtDuracion.setText("");
            txtCantidad.setText("");
        }
    }//GEN-LAST:event_cmbTemaItemStateChanged

    private void cmbClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbClienteItemStateChanged
        if (cmbOperacion.getSelectedIndex() > 0) {
            if (cmbCliente.getSelectedIndex() != 0) {
                cmbNoParte.setEnabled(true);
                cmbNoParte.setModel(cls.ListaPartes(cmbCliente.getSelectedItem().toString()));
            }
        } else {
            cmbCliente.setEnabled(false);
            cmbCliente.setSelectedIndex(0);
        }
    }//GEN-LAST:event_cmbClienteItemStateChanged

    private void cmbNoParteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbNoParteItemStateChanged
        if (cmbCliente.getSelectedIndex() != 0) {
            if (cmbTema.getSelectedIndex() == 1 || cmbTema.getSelectedIndex() == 2) {
                txtCantidad.setEnabled(true);
            }
        }
    }//GEN-LAST:event_cmbNoParteItemStateChanged

    private void cmbOperacionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbOperacionItemStateChanged
        if (cmbOperacion.getSelectedIndex() > 0) {
            if (cmbCliente.getModel().getSize() > 0 || cmbProblema.getModel().getSize() > 0) {
                cmbProblema.setEnabled(true);
                String area = cmbArea.getSelectedItem().toString();
                cmbArea.setEnabled(true);
                cmbArea.setModel(cls.ListaAreasPorOperacion(cmbLinea.getSelectedItem().toString(), cmbTema.getSelectedItem().toString(), cmbOperacion.getSelectedItem().toString()));
                cmbProblema.setModel(cls.ListaProblemas(cmbOperacion.getSelectedItem().toString(),
                        cmbTema.getSelectedItem().toString(), area, cmbLinea.getSelectedItem().toString()));
                cmbCliente.setEnabled(false);

            } else {
                if (cmbTema.getSelectedIndex() != 1 && cmbTema.getSelectedIndex() != 0) {
                    cmbArea.setEnabled(true);
                    cmbArea.setModel(cls.ListaAreasPorOperacion(cmbLinea.getSelectedItem().toString(), cmbTema.getSelectedItem().toString(), cmbOperacion.getSelectedItem().toString()));
                }
            }
        } else {
            cmbArea.setSelectedIndex(0);
            cmbArea.setEnabled(false);
            cmbProblema.setEnabled(false);
            cmbCliente.setEnabled(false);
        }

    }//GEN-LAST:event_cmbOperacionItemStateChanged

    private void cmbAreaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbAreaItemStateChanged
        if (cmbOperacion.getSelectedIndex() > 0) {
            if (cmbArea.getSelectedIndex() != 0) {
                if (cmbTema.getSelectedIndex() != 6) {
                    cmbProblema.setEnabled(true);
                    String area = cmbArea.getSelectedItem().toString();
                    cmbProblema.setModel(cls.ListaProblemas(cmbOperacion.getSelectedItem().toString(),
                            cmbTema.getSelectedItem().toString(), area, cmbLinea.getSelectedItem().toString()));
                } else {
                    cmbCliente.setModel(cls.ListaClientes(cmbLinea.getSelectedItem().toString()));
                    cmbCliente.setEnabled(true);
                    cmbProblema.setEnabled(false);
                }
            } else {
                cmbProblema.setSelectedIndex(0);
                cmbProblema.setEnabled(false);

                cmbCliente.setEnabled(false);
            }
        }

    }//GEN-LAST:event_cmbAreaItemStateChanged

    private void cmbProblemaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbProblemaItemStateChanged
        if (cmbProblema.getSelectedIndex() > 0) {
            cmbCliente.setEnabled(true);
            cmbCliente.setModel(cls.ListaClientes(cmbLinea.getSelectedItem().toString()));
            if (cmbTema.getSelectedIndex() == 5) {
                cmbParteCambio.setVisible(true);
                labelPartecambio.setVisible(true);
                cmbParteCambio.setModel(cls.ListaPartes(cmbProblema.getSelectedItem().toString()));
            }
        } else {
            cmbCliente.setEnabled(false);
            labelPartecambio.setVisible(false);
            cmbParteCambio.setVisible(false);

        }
    }//GEN-LAST:event_cmbProblemaItemStateChanged

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9')) {
            evt.consume();
        }
        if (txtCantidad.getText().length() >= 3) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void cmbHoraItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbHoraItemStateChanged
        if (cmbHora.getSelectedIndex() != 0) {
            txtTiempoFin.setEnabled(true);
            txtTiempoInicio.setEnabled(true);
        }
    }//GEN-LAST:event_cmbHoraItemStateChanged

    private void txtTiempoInicioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTiempoInicioKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9')) {
            evt.consume();
        }
        if (txtTiempoInicio.getText().length() >= 2) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTiempoInicioKeyTyped

    private void txtTiempoFinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTiempoFinKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9')) {
            evt.consume();
        }
        if (txtTiempoFin.getText().length() >= 2) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTiempoFinKeyTyped

    private void txtTiempoFinKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTiempoFinKeyReleased
        int fin, inicio = 0, duracion = 0;
        if (!txtTiempoInicio.getText().equals("")) {
            if (!txtTiempoFin.getText().equals("")) {
                fin = Integer.parseInt(txtTiempoFin.getText());

                if (!txtTiempoInicio.getText().equals("")) {
                    inicio = Integer.parseInt(txtTiempoInicio.getText());
                }
                if (fin < inicio || fin > 59) {
                    txtTiempoFin.setText("");
                }
                if (!txtTiempoInicio.getText().equals("") && !txtTiempoFin.getText().equals("")) {
                    duracion = fin - inicio + 1;
                    txtDuracion.setText(String.valueOf(duracion));
                } else {
                    txtDuracion.setText("");
                }
            }
        } else {
            txtTiempoFin.setText("");
        }
    }//GEN-LAST:event_txtTiempoFinKeyReleased

    private void txtTiempoFinKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTiempoFinKeyPressed

    }//GEN-LAST:event_txtTiempoFinKeyPressed

    private void txtTiempoInicioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTiempoInicioKeyReleased
        int inicio = 0;
        if (!txtTiempoInicio.getText().equals("") && txtTiempoFin.getText().equals("")) {
            inicio = Integer.parseInt(txtTiempoInicio.getText());
            if (inicio > 59 || inicio < 0) {
                txtTiempoInicio.setText("");
            }
        } else {
            txtTiempoInicio.setText("");
            txtTiempoFin.setText("");
            txtDuracion.setText("");
        }
    }//GEN-LAST:event_txtTiempoInicioKeyReleased

    private void txtDuracionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDuracionKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDuracionKeyReleased

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased

    }//GEN-LAST:event_formKeyReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cmbHora.setModel(cls.ListaHoras());
        String anio, mes;
        anio = date.format(now).substring(6);
        mes = date.format(now).substring(3, 5);
        txtAnio.setText(anio);
        for (int i = 0; i < cmbMes.getItemCount(); i++) {
            if (mes.equals(cmbMes.getItemAt(i))) {
                cmbMes.setSelectedIndex(i);
            }
        }
    }//GEN-LAST:event_formWindowOpened

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

    }//GEN-LAST:event_formMouseClicked

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased

    }//GEN-LAST:event_formMouseReleased

    private void btnAgregarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseMoved

    }//GEN-LAST:event_btnAgregarMouseMoved

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        Object[] reg = new Object[16];
        Object[] tiempos = new Object[4];
        ArrayList tiempoHora = new ArrayList();
        boolean b = false;
        DefaultTableModel mod = (DefaultTableModel) tablaBitacora.getModel();
        reg = insertaRegBitacora(reg);
        if (!validaDatos()) {
            if (tablaBitacora.getRowCount() == 0) {
                tiempos[0] = reg[4];
                tiempos[1] = reg[5];
                tiempos[2] = reg[6];
                tiempos[3] = reg[7];
                tiempoHora.add(tiempos);
                mod.addRow(reg);
                limpiar();
            } else {
                for (int c = 0; c < mod.getRowCount(); c++) {
                    if (mod.getValueAt(c, 1).toString().equals(reg[1].toString())) {
                        if (mod.getValueAt(c, 2).toString().equals(reg[2].toString())) {
                            tiempos[0] = mod.getValueAt(c, 2);
                            tiempos[1] = mod.getValueAt(c, 3);
                            tiempos[2] = mod.getValueAt(c, 4);
                            tiempos[3] = mod.getValueAt(c, 5);
                            tiempoHora.add(tiempos);
                        }
                    }
                }
                if (tiempoHora.size() > 0) {
                    Object[] tmp = (Object[]) tiempoHora.get(tiempoHora.size() - 1);
                    if (Integer.parseInt(reg[3].toString()) >= Integer.parseInt(tmp[2].toString())) {
                        mod.addRow(insertaRegBitacora(reg));
                        limpiar();
                    } else {
                        JOptionPane.showMessageDialog(this, "lapso de periodo invalido");
                    }
                } else {
                    mod.addRow(reg);
                    limpiar();
                }
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void cmbLineaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbLineaItemStateChanged
        if (cmbLinea.getSelectedIndex() != 0) {
            if (cmbLinea.getSelectedIndex() == 1) {
            }
        }
    }//GEN-LAST:event_cmbLineaItemStateChanged

    private void cmbHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbHoraActionPerformed

    private void cmbTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTemaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTemaActionPerformed

    private void btnCambiarLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarLineaActionPerformed
        limpiar();
        cmbTema.setEnabled(false);
        if (btnCambiarLinea.getText().equals("Cambiar Linea")) {
            mod = 1;
            Login lo = new Login(new javax.swing.JDialog(), true);
            lo.setVisible(true);

        } else if (btnCambiarLinea.getText().equals("Aceptar")) {
            cmbLinea.setEnabled(false);
            cmbTema.setEnabled(true);
            btnCambiarLinea.setText("Cambiar Linea");
        }

    }//GEN-LAST:event_btnCambiarLineaActionPerformed

    private void cmbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbClienteActionPerformed

    private void btnRevisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRevisarActionPerformed
        DefaultTableModel mod, tablaHoras = new DefaultTableModel();
        tablaHoras.addColumn("Hora");
        tablaHoras.addColumn("Tiempo Faltante");
        Object[] r = new Object[2];
        mod = (DefaultTableModel) tablaBitacora.getModel();
        DefaultComboBoxModel hor = (DefaultComboBoxModel) cmbHora.getModel();
        int hora, sum, faltante;
        for (int i = 1; i < cmbHora.getItemCount(); i++) {
            hora = Integer.parseInt(cmbHora.getItemAt(i).toString());
            r[0] = hora;
            r[1] = 60;
            tablaHoras.addRow(r);
        }
        for (int i = 1; i < hor.getSize(); i++) {
            hora = Integer.parseInt(cmbHora.getItemAt(i).toString());
            sum = 0;
            for (int c = 0; c < mod.getRowCount(); c++) {
                if (Integer.parseInt(mod.getValueAt(c, 2).toString()) == hora) {
                    sum = sum + Integer.parseInt(mod.getValueAt(c, 5).toString());
                    faltante = 60 - sum;
                    tablaHoras.setValueAt(faltante, i - 1, 1);
                }
            }

        }

        TiemposFaltantes tf = new TiemposFaltantes(new javax.swing.JDialog(), true);
        TiemposFaltantes.tablaTiempoFaltante.setModel(tablaHoras);
        tf.setVisible(true);

    }//GEN-LAST:event_btnRevisarActionPerformed

    private void menuEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEliminarActionPerformed
        DefaultTableModel reg = (DefaultTableModel) tablaBitacora.getModel();
        reg.removeRow(tablaBitacora.getSelectedRow());
    }//GEN-LAST:event_menuEliminarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Object fecha;
        if (tablaBitacora.getRowCount() > 0) {
            mod = 2;
            Login lo = new Login(new javax.swing.JDialog(), true);
            lo.setVisible(true);
            if (Login.resp == 1) {
                String txtFecha = cmbDia.getSelectedItem().toString().concat("/").concat(cmbMes.getSelectedItem().toString().concat("/").concat(txtAnio.getText()));
                Date revF = null;
                DateFormat df1 = date;
                try {
                    revF = df1.parse(txtFecha);
                } catch (ParseException ex) {
                    Logger.getLogger(EditarBitacora.class.getName()).log(Level.SEVERE, null, ex);
                }
                Object[] datos = new Object[3];
                if (!cls.ExisteFechaEdicionBitacora(txtFecha, (DefaultTableModel) tablaBitacora.getModel()).isEmpty()) {
                    ArrayList h = cls.ExisteFechaEdicionBitacora(txtFecha, (DefaultTableModel) tablaBitacora.getModel());
                    String cad = "";
                    for (int i = 0; i < h.size(); i++) {
                        datos = (Object[]) h.get(i);
                        JOptionPane.showMessageDialog(this, "Hora " + datos[0] + " y minuto: " + datos[2] + " Registrados en bitacora: ", "Error", JOptionPane.ERROR_MESSAGE
                        );
                    }
                } else {
                    int columnas = tablaBitacora.getColumnCount();
                    ArrayList reg;
                    for (int i = 0; i < tablaBitacora.getRowCount(); i++) {
                        reg = new ArrayList();
                        for (int j = 0; j < columnas; j++) {
                            reg.add(tablaBitacora.getModel().getValueAt(i, j));
                        }
                        cls.InsertarRegistro(reg);
                    }
                    ms.ClearTable((DefaultTableModel) tablaBitacora.getModel());
                    JOptionPane.showMessageDialog(this, "Bitacora Guardada Correctamente", "Guardar", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Bitacora vacia", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cmbAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbAreaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        new PrincipalOne().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmbMesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMesItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMesItemStateChanged

    public Object[] insertaRegBitacora(Object[] reg) {
        String f = cmbDia.getSelectedItem().toString().concat("/").concat(cmbMes.getSelectedItem().toString().concat("/").concat(txtAnio.getText()));
        if (cmbTema.getSelectedIndex() == 1) {
            reg[0] = cmbLinea.getSelectedItem();
            reg[1] = f;
            reg[2] = cmbHora.getSelectedItem();
            reg[3] = txtTiempoInicio.getText();
            reg[4] = txtTiempoFin.getText();
            reg[5] = txtDuracion.getText();
            reg[6] = cmbTema.getSelectedItem();
            reg[7] = cmbOperacion.getSelectedItem();
            reg[8] = "";
            reg[9] = "";
            reg[10] = cmbCliente.getSelectedItem();
            reg[11] = cmbNoParte.getSelectedItem();
            reg[12] = txtCantidad.getText();
            reg[13] = "";
        } else if (cmbTema.getSelectedIndex() == 2) {
            reg[0] = cmbLinea.getSelectedItem();
            reg[1] = f;
            reg[2] = cmbHora.getSelectedItem();
            reg[3] = txtTiempoInicio.getText();
            reg[4] = txtTiempoFin.getText();
            reg[5] = txtDuracion.getText();
            reg[6] = cmbTema.getSelectedItem();
            reg[7] = cmbOperacion.getSelectedItem();
            reg[8] = cmbArea.getSelectedItem();
            reg[9] = cmbProblema.getSelectedItem();
            reg[10] = cmbCliente.getSelectedItem();
            reg[11] = cmbNoParte.getSelectedItem();
            reg[12] = txtCantidad.getText();
            reg[13] = "";
        } else if (cmbTema.getSelectedIndex() == 3) {
            reg[0] = cmbLinea.getSelectedItem();
            reg[1] = f;
            reg[2] = cmbHora.getSelectedItem();
            reg[3] = txtTiempoInicio.getText();
            reg[4] = txtTiempoFin.getText();
            reg[5] = txtDuracion.getText();
            reg[6] = cmbTema.getSelectedItem();
            reg[7] = cmbOperacion.getSelectedItem();
            reg[8] = cmbArea.getSelectedItem();
            reg[9] = cmbProblema.getSelectedItem();
            reg[10] = cmbCliente.getSelectedItem();
            reg[11] = cmbNoParte.getSelectedItem();
            reg[12] = 0;
            reg[13] = "";
        } else if (cmbTema.getSelectedIndex() == 4) {
            reg[0] = cmbLinea.getSelectedItem();
            reg[1] = f;
            reg[2] = cmbHora.getSelectedItem();
            reg[3] = txtTiempoInicio.getText();
            reg[4] = txtTiempoFin.getText();
            reg[5] = txtDuracion.getText();
            reg[6] = cmbTema.getSelectedItem();
            reg[7] = cmbOperacion.getSelectedItem();
            reg[8] = cmbArea.getSelectedItem();
            reg[9] = cmbProblema.getSelectedItem();
            reg[10] = cmbCliente.getSelectedItem();
            reg[11] = cmbNoParte.getSelectedItem();
            reg[12] = 0;
            reg[13] = "";

        } else if (cmbTema.getSelectedIndex() == 5) {
            reg[0] = cmbLinea.getSelectedItem();
            reg[1] = f;
            reg[2] = cmbHora.getSelectedItem();
            reg[3] = txtTiempoInicio.getText();
            reg[4] = txtTiempoFin.getText();
            reg[5] = txtDuracion.getText();
            reg[6] = cmbTema.getSelectedItem();
            reg[7] = cmbOperacion.getSelectedItem();
            reg[8] = cmbArea.getSelectedItem();
            reg[9] = cmbProblema.getSelectedItem();
            reg[10] = cmbCliente.getSelectedItem();
            reg[11] = cmbNoParte.getSelectedItem();
            reg[12] = 0;
            reg[13] = cmbParteCambio.getSelectedItem();
        } else if (cmbTema.getSelectedIndex() == 6) {
            reg[0] = cmbLinea.getSelectedItem();
            reg[1] = f;
            reg[2] = cmbHora.getSelectedItem();
            reg[3] = txtTiempoInicio.getText();
            reg[4] = txtTiempoFin.getText();
            reg[5] = txtDuracion.getText();
            reg[6] = cmbTema.getSelectedItem();
            reg[7] = cmbOperacion.getSelectedItem();
            reg[8] = cmbArea.getSelectedItem();
            reg[9] = "";
            reg[10] = cmbCliente.getSelectedItem();
            reg[11] = cmbNoParte.getSelectedItem();
            reg[12] = 0;
            reg[13] = "";
        }

        return reg;
    }

    public boolean validaDatos() {
        boolean band = false;
        if (cmbTema.getSelectedIndex() == 1) {
            if (cmbHora.getSelectedIndex() > 0
                    && !txtTiempoInicio.getText().equals("") && !txtTiempoFin.getText().equals("") && !txtDuracion.getText().equals("")
                    && cmbTema.getSelectedIndex() > 0 && cmbOperacion.getSelectedIndex() > 0 && cmbCliente.getSelectedIndex() > 0
                    && cmbNoParte.getSelectedIndex() > 0 && !txtCantidad.getText().equals("")) {
                band = false;
            } else {
                band = true;
                JOptionPane.showMessageDialog(this, "Debes llenar los campos necesarios del registro", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (cmbTema.getSelectedIndex() == 2) {
            if (cmbHora.getSelectedIndex() > 0 && !txtTiempoInicio.getText().equals("") && !txtTiempoFin.getText().equals("") && !txtDuracion.getText().equals("")
                    && cmbTema.getSelectedIndex() > 0 && cmbOperacion.getSelectedIndex() > 0 && cmbArea.getSelectedIndex() > 0
                    && cmbProblema.getSelectedIndex() > 0 && cmbCliente.getSelectedIndex() > 0 && cmbNoParte.getSelectedIndex() > 0 && !txtCantidad.getText().equals("")) {
                band = false;
            } else {
                band = true;
                JOptionPane.showMessageDialog(this, "Debes llenar los campos necesarios del registro", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else if (cmbTema.getSelectedIndex() == 3) {
            if (cmbHora.getSelectedIndex() > 0 && !txtTiempoInicio.getText().equals("") && !txtTiempoFin.getText().equals("") && !txtDuracion.getText().equals("")
                    && cmbTema.getSelectedIndex() > 0 && cmbOperacion.getSelectedIndex() > 0 && cmbArea.getSelectedIndex() > 0
                    && cmbProblema.getSelectedIndex() > 0 && cmbCliente.getSelectedIndex() > 0 && cmbNoParte.getSelectedIndex() > 0) {
                band = false;
            } else {
                band = true;
                JOptionPane.showMessageDialog(this, "Debes llenar los campos necesarios del registro", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else if (cmbTema.getSelectedIndex() == 4) {
            if (cmbHora.getSelectedIndex() > 0
                    && !txtTiempoInicio.getText().equals("") && !txtTiempoFin.getText().equals("") && !txtDuracion.getText().equals("")
                    && cmbTema.getSelectedIndex() > 0 && cmbOperacion.getSelectedIndex() > 0 && cmbArea.getSelectedIndex() > 0
                    && cmbProblema.getSelectedIndex() > 0 && cmbCliente.getSelectedIndex() > 0 && cmbNoParte.getSelectedIndex() > 0) {
                band = false;
            } else {
                band = true;
                JOptionPane.showMessageDialog(this, "Debes llenar los campos necesarios del registro", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (cmbTema.getSelectedIndex() == 5) {
            if (cmbHora.getSelectedIndex() > 0
                    && !txtTiempoInicio.getText().equals("") && !txtTiempoFin.getText().equals("") && !txtDuracion.getText().equals("")
                    && cmbTema.getSelectedIndex() > 0 && cmbOperacion.getSelectedIndex() > 0 && cmbArea.getSelectedIndex() > 0
                    && cmbProblema.getSelectedIndex() > 0 && cmbCliente.getSelectedIndex() > 0 && cmbNoParte.getSelectedIndex() > 0 && cmbParteCambio.getSelectedIndex() > 0) {
                band = false;
            } else {
                band = true;
                JOptionPane.showMessageDialog(this, "Debes llenar los campos necesarios del registro", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (cmbTema.getSelectedIndex() == 6) {
            if (cmbHora.getSelectedIndex() > 0
                    && !txtTiempoInicio.getText().equals("") && !txtTiempoFin.getText().equals("") && !txtDuracion.getText().equals("")
                    && cmbTema.getSelectedIndex() > 0 && cmbOperacion.getSelectedIndex() > 0 && cmbArea.getSelectedIndex() > 0
                    && cmbCliente.getSelectedIndex() > 0 && cmbNoParte.getSelectedIndex() > 0) {
                band = false;
            } else {
                band = true;
                JOptionPane.showMessageDialog(this, "Debes llenar los campos necesarios del registro", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            band = true;
            JOptionPane.showMessageDialog(this, "Debes llenar los campos necesarios del registro", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return band;
    }

    public void limpiar() {
        cmbTema.setSelectedIndex(0);
        cmbArea.setEnabled(false);
        cmbArea.setModel(listaVacia);
        cmbCliente.setEnabled(false);
        cmbCliente.setModel(listaVacia);
        cmbProblema.setEnabled(false);
        cmbProblema.setModel(listaVacia);
        cmbNoParte.setEnabled(false);
        cmbNoParte.setModel(listaVacia);
        cmbOperacion.setEnabled(false);
        cmbOperacion.setModel(listaVacia);
        txtCantidad.setEnabled(false);
        cmbHora.setSelectedIndex(0);
        txtTiempoInicio.setEnabled(false);
        txtTiempoFin.setEnabled(false);
        txtTiempoInicio.setText("");
        txtTiempoFin.setText("");
        txtDuracion.setText("");
        txtCantidad.setText("");
    }

    public boolean isCellEditable(int row, int column) {
        return false;
    }

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(EditarBitacora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(EditarBitacora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(EditarBitacora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(EditarBitacora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new EditarBitacora().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    public static javax.swing.JButton btnCambiarLinea;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRevisar;
    private javax.swing.JComboBox cmbArea;
    private javax.swing.JComboBox cmbCliente;
    private javax.swing.JComboBox cmbDia;
    private javax.swing.JComboBox cmbHora;
    public static javax.swing.JComboBox cmbLinea;
    private javax.swing.JComboBox cmbMes;
    private javax.swing.JComboBox cmbNoParte;
    private javax.swing.JComboBox cmbOperacion;
    private javax.swing.JComboBox cmbParteCambio;
    private javax.swing.JComboBox cmbProblema;
    public static javax.swing.JComboBox cmbTema;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelPartecambio;
    private javax.swing.JPopupMenu menu;
    private javax.swing.JMenuItem menuEliminar;
    private javax.swing.JPanel paneltiempoIncidencia;
    private javax.swing.JTable tablaBitacora;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDuracion;
    private javax.swing.JTextField txtTiempoFin;
    private javax.swing.JTextField txtTiempoInicio;
    // End of variables declaration//GEN-END:variables
}
