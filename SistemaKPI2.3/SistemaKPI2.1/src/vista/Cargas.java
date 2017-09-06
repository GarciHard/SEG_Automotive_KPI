
package vista;

import control.PrincipalControl;
import java.awt.Cursor;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import utils.LineasMetodos;
import utils.PrincipalMetodos;

/**
 *
 * @author PRR1TL
 */
public class Cargas extends javax.swing.JDialog {

    private  static DefaultTableModel modeloClientes;
    private static DefaultTableModel modeloNumPartes;
    private static DefaultTableModel modeloOperaciones;
    private static DefaultTableModel modeloPerdidas;
    
    
    public static String linea = ""; //String linea = "";
    //public static String lineaLinea = LineasMetodos.lineaLinea;
    
    private final PrincipalMetodos principalMetodos = new PrincipalMetodos();
    /**
     * Creates new form Cargas
     */
    public Cargas(java.awt.Frame parent, boolean modal) throws IOException {
        super(parent, modal);
        initComponents();
        //validaEntrada();
        this.setLocationRelativeTo(null);
        cmbLinea.setModel(principalMetodos.listaLineas());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGuardar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblNumPartes = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblOperaciones = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblPerdidas = new javax.swing.JTable();
        btnAceptar = new javax.swing.JButton();
        cmbLinea = new javax.swing.JComboBox<>();
        lblMensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblClientes);

        tblNumPartes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNumPartes.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblNumPartes);
        if (tblNumPartes.getColumnModel().getColumnCount() > 0) {
            tblNumPartes.getColumnModel().getColumn(0).setResizable(false);
            tblNumPartes.getColumnModel().getColumn(1).setResizable(false);
            tblNumPartes.getColumnModel().getColumn(2).setResizable(false);
        }

        tblOperaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblOperaciones.getTableHeader().setResizingAllowed(false);
        tblOperaciones.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblOperaciones);
        if (tblOperaciones.getColumnModel().getColumnCount() > 0) {
            tblOperaciones.getColumnModel().getColumn(0).setResizable(false);
            tblOperaciones.getColumnModel().getColumn(1).setResizable(false);
        }

        tblPerdidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPerdidas.getTableHeader().setResizingAllowed(false);
        tblPerdidas.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tblPerdidas);
        if (tblPerdidas.getColumnModel().getColumnCount() > 0) {
            tblPerdidas.getColumnModel().getColumn(0).setResizable(false);
            tblPerdidas.getColumnModel().getColumn(1).setResizable(false);
            tblPerdidas.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        btnAceptar.setText("Aceptar");
        btnAceptar.setEnabled(false);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        cmbLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLineaActionPerformed(evt);
            }
        });

        lblMensaje.setForeground(new java.awt.Color(238, 14, 14));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(cmbLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(btnAceptar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(cmbLinea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGuardar)
                    .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        btnGuardar.setEnabled(false);
        cargaClientes();
        cargaNumPartes();
        cargaOperaciones();
        cargaPerdidas();
        dispose();
        JOptionPane.showMessageDialog(this, "Datos Cargados Correctamente");
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        linea = cmbLinea.getSelectedItem().toString();
        
        int cargaM = JOptionPane.showConfirmDialog(null, "¿Desea Cargar Datos Masivamente a la linea?\n\t"+ linea,  "Mensaje", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (cargaM == 0) {
            int act = JOptionPane.showConfirmDialog(null, "Debe actualizar el archivo PlantillaCargaDeDatos.xls, esta en: \n I:Dep>MOE1>Shared>Informacion_general>proyectos  SG>Proyecto OEE \n\n Presione YES, cuando este actualizado", "Mensaje", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (act == 0) {
                try {
                    btnAceptar.setVisible(false);
                    cmbLinea.setEnabled(false);
                    btnGuardar.setVisible(true);
                    btnGuardar.setEnabled(true);
                    tablaClientes();
                    tablaNumPartes();
                    tablaOperaciones();
                    tablaPerdidas();
                    importarExcel();
                } catch (IOException ex) {
                    Logger.getLogger(Cargas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void cmbLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLineaActionPerformed
        if(cmbLinea.getSelectedIndex() != 0){
            btnAceptar.setEnabled(true);
        } else {
            btnAceptar.setEnabled(false);
        }
        
    }//GEN-LAST:event_cmbLineaActionPerformed

    public void tablaClientes(){
        modeloClientes = new DefaultTableModel();
        modeloClientes.addColumn("Clientes");
        this.tblClientes.setModel(modeloClientes);
    }
    
    public void tablaNumPartes(){
        modeloNumPartes = new DefaultTableModel();
        modeloNumPartes.addColumn("Numero Parte");
        modeloNumPartes.addColumn("Familia");
        modeloNumPartes.addColumn("Cliente");
        this.tblNumPartes.setModel(modeloNumPartes);
    }
    
    public void tablaOperaciones(){
        modeloOperaciones = new DefaultTableModel();
        modeloOperaciones.addColumn("Operacion");
        modeloOperaciones.addColumn("Descripcion");
        this.tblOperaciones.setModel(modeloOperaciones);
    }
    
    public void tablaPerdidas() {
        modeloPerdidas = new DefaultTableModel();
        modeloPerdidas.addColumn("Tema");
        modeloPerdidas.addColumn("Operacion");
        modeloPerdidas.addColumn("Area");
        modeloPerdidas.addColumn("Problema");
        this.tblPerdidas.setModel(modeloPerdidas);
    }
    
    public void importarExcel () throws IOException{
        File file = new File("I:\\Dept\\MOE1\\Shared\\Informacion_general\\proyectos  SG\\Proyecto OEE\\PlantillaCargaDeDatos.xls");
        if (file.exists()) {
            seleccionaClientes(file);
            seleccionaNPartes(file);
            seleccionaOperaciones(file);
            seleccionaPerdidas(file);
        }else{
            JOptionPane.showMessageDialog(this, "El formato no existe en la ruta por el momento Ö \nDirigete con Raúl Guadarrama (ICO), el tiene la solucion");
            tblClientes.setEnabled(false);
            tblNumPartes.setEnabled(false);
            tblOperaciones.setEnabled(false);
            tblPerdidas.setEnabled(false);
            btnGuardar.setEnabled(false);
        }        
    }
    
    public void seleccionaClientes(File file) throws IOException{
        Workbook workbook = null;
        try {
            workbook = Workbook.getWorkbook(file);
            Sheet sheet = workbook.getSheet(0);
            
            for (int j = 4; j < sheet.getRows(); j++) { //contador para agarrar la primer linea, determina cuantas filas va agarrar
                Vector c = new Vector();
                for (int i = 0; i < 1 ; i++) { //determina cuantas columnas va agarrar 
                    Cell cell = sheet.getCell(i, j);
                    Pattern pat = Pattern.compile("[A-Za-z]");
                    Matcher mat = pat.matcher(cell.getContents());
                    if(mat.find()){
                        c.add(cell.getContents());
                    } else {
                        lblMensaje.setText("No puedes guardar si tus datos tienen errores \n Favor de verificarlos");
                        btnGuardar.setEnabled(false);
                    }
                }
                c.add("\n");
                modeloClientes.addRow(c);
            }
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }
    
    public void seleccionaNPartes(File file) throws IOException{
        Workbook workbook = null;
        int bn = 0;
        try {
            workbook = Workbook.getWorkbook(file);
            Sheet sheet = workbook.getSheet(1);
            
            for (int j = 4; j < sheet.getRows(); j++) { //contador para agarrar la primer linea, determina cuantas filas va agarrar
                Vector np = new Vector();
                for (int i = 0; i < 3 ; i++) { //determina cuantas columnas va agarrar 
                    Cell cell = sheet.getCell(i, j);
                    if (i == 0) { 
                        if( sheet.getColumn(i).length == 10){
                            cell = sheet.getCell(i, j);
                            np.add(cell.getContents());
                        }else{
                            lblMensaje.setText("No puedes guardar si tus datos tienen errores \n Favor de verificarlos");
                            btnGuardar.setEnabled(false);
                        }
                    }else if (i == 1) {
                        Pattern pat = Pattern.compile("[A-Za-z]");
                        Matcher mat = pat.matcher(cell.getContents());
                        if(mat.find()){
                            cell = sheet.getCell(i, j);
                            np.add(cell.getContents());
                        }else {
                            lblMensaje.setText("No puedes guardar si tus datos tienen errores \n Favor de verificarlos");
                            btnGuardar.setEnabled(false);
                        }
                    } else if (i == 2) {
                        Pattern pat = Pattern.compile("[A-Za-z]");
                        Matcher mat = pat.matcher(cell.getContents());
                        if(mat.find()){
                            np.add(cell.getContents());
                        }else {
                            lblMensaje.setText("No puedes guardar si tus datos tienen errores \n Favor de verificarlos");
                            btnGuardar.setEnabled(false);
                        }
                    }                     
                }
                np.add("\n");
                modeloNumPartes.addRow(np);
            }
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }
    
    public void seleccionaOperaciones (File file) throws IOException{
        Workbook workbook = null;
        try {
            workbook = Workbook.getWorkbook(file);
            Sheet sheet = workbook.getSheet(2);
            
            for (int j = 4; j < sheet.getRows(); j++) { //contador para agarrar la primer linea, determina cuantas filas va agarrar
                Vector op = new Vector();
                for (int i = 0; i < 2 ; i++) { //determina cuantas columnas va agarrar 
                    Cell cell = sheet.getCell(i, j);                    
                    if (i == 0) { 
                        Pattern pat = Pattern.compile("[0-9]");
                        Matcher mat = pat.matcher(cell.getContents());
                        if(sheet.getColumn(i).length < 11 && mat.find()){
                            cell = sheet.getCell(i, j);
                            op.add(cell.getContents());
                        } else {
                            lblMensaje.setText("No puedes guardar si tus datos tienen errores \n Favor de verificarlos");
                            btnGuardar.setEnabled(false);
                        }
                    }else if (i == 1) {
                        Pattern pat = Pattern.compile("[A-Za-z]");
                        Matcher mat = pat.matcher(cell.getContents());
                        if(mat.find()){
                            cell = sheet.getCell(i, j);
                            op.add(cell.getContents());
                        } else {
                            lblMensaje.setText("No puedes guardar si tus datos tienen errores \n Favor de verificarlos");
                            btnGuardar.setEnabled(false);
                        }
                    }
                }
                op.add("\n");
                modeloOperaciones.addRow(op);
            }
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }
    
    public void seleccionaPerdidas(File file) throws IOException{
        Workbook workbook = null;
        try {
            workbook = Workbook.getWorkbook(file);
            Sheet sheet = workbook.getSheet(3);
            
            for (int j = 4; j < sheet.getRows(); j++) { //contador para agarrar la primer linea, determina cuantas filas va agarrar
                Vector d = new Vector();
                for (int i = 0; i < 4 ; i++) { //determina cuantas columnas va agarrar 
                    Cell cell = sheet.getCell(i, j);                
                    if (i == 0) { 
                        Pattern pat = Pattern.compile("[A-Za-z]");
                        Matcher mat = pat.matcher(cell.getContents());
                        if(mat.find()){
                            cell = sheet.getCell(i, j);
                            d.add(cell.getContents());
                        } else {
                            lblMensaje.setText("No puedes guardar si tus datos tienen errores \n Favor de verificarlos");
                            btnGuardar.setEnabled(false);
                        }
                    }else if(i == 1){
                        Pattern pat = Pattern.compile("[0-9]");
                        Matcher mat = pat.matcher(cell.getContents());
                        if(mat.find()){
                            cell = sheet.getCell(1, j);
                            d.add(cell.getContents());
                        } else {
                            lblMensaje.setText("No puedes guardar si tus datos tienen errores \n Favor de verificarlos");
                            btnGuardar.setEnabled(false);
                        }
                    }else if(i == 2){
                        Pattern pat = Pattern.compile("[A-Za-z]");
                        Matcher mat = pat.matcher(cell.getContents());
                        if(mat.find()){
                            cell = sheet.getCell(2, j);
                            d.add(cell.getContents());
                        } else {
                            lblMensaje.setText("No puedes guardar si tus datos tienen errores \n Favor de verificarlos");
                            btnGuardar.setEnabled(false);
                        }
                    }else if(i == 3){
                        Pattern pat = Pattern.compile("[A-Za-z]");
                        Matcher mat = pat.matcher(cell.getContents());
                        if(mat.find()){
                            cell = sheet.getCell(3, j);
                            d.add(cell.getContents());
                        } 
                    }
                }
                d.add("\n");
                modeloPerdidas.addRow(d);
            }
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }
    /****************** Cargas a BD *********************/
    
    public void cargaClientes(){
        dao.CargaMasivaDAOImpl cargaObj = new dao.CargaMasivaDAOImpl();
        int columnas = tblClientes.getColumnCount();
        ArrayList reg;
        for (int i = 0; i < tblClientes.getRowCount(); i++) {
            try {
                reg = new ArrayList();
                for (int j = 0; j < columnas; j++) {
                    reg.add(tblClientes.getValueAt(i, j));
                }
                cargaObj.insertarClientes(reg);
            } catch (Exception ex) {
                Logger.getLogger(Cargas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //JOptionPane.showMessageDialog(null,"CLIENTE");
        limpiarTabla((DefaultTableModel) tblClientes.getModel());
    }
    
    public void cargaNumPartes(){
        dao.CargaMasivaDAOImpl cargaObj = new dao.CargaMasivaDAOImpl();
        int columnas = tblNumPartes.getColumnCount();
        ArrayList reg;
        for (int i = 0; i < tblNumPartes.getRowCount(); i++) {
            try {
                reg = new ArrayList();
                for (int j = 0; j < columnas; j++) {
                    reg.add(tblNumPartes.getValueAt(i, j));
                }
                cargaObj.insertarNumPartes(reg);
            } catch (Exception ex) {
                Logger.getLogger(Cargas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
        //JOptionPane.showMessageDialog(null,"Partes");
        limpiarTabla((DefaultTableModel) tblNumPartes.getModel());
    }
    
    public void cargaOperaciones(){
        dao.CargaMasivaDAOImpl cargaObj = new dao.CargaMasivaDAOImpl();
        int columnas = tblOperaciones.getColumnCount();
        ArrayList reg;
        for (int i = 0; i < tblOperaciones.getRowCount(); i++) {
            try {
                reg = new ArrayList();
                for (int j = 0; j < columnas; j++) {
                    reg.add(tblOperaciones.getValueAt(i, j));
                }
                cargaObj.insertarOperaciones(reg);
            } catch (Exception ex) {
                Logger.getLogger(Cargas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //JOptionPane.showMessageDialog(null,"operaciones");
        limpiarTabla((DefaultTableModel) tblOperaciones.getModel());       
    }
    
    public void cargaPerdidas (){
        dao.CargaMasivaDAOImpl cargaObj = new dao.CargaMasivaDAOImpl();
        int columnas = tblPerdidas.getColumnCount();
        ArrayList reg;
        for (int i = 0; i < tblPerdidas.getRowCount(); i++) {
            try {
                reg = new ArrayList();
                for (int j = 0; j < columnas; j++) {
                    reg.add(tblPerdidas.getValueAt(i, j));
                }
                cargaObj.insertarPerdidas(reg);
            } catch (Exception ex) {
                Logger.getLogger(Cargas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //JOptionPane.showMessageDialog(null,"Perdidas");
        limpiarTabla((DefaultTableModel) tblPerdidas.getModel());
    }
    
    private void limpiarTabla(DefaultTableModel tablaLimpiar) {
        for (int i = 0; i < tablaLimpiar.getRowCount(); i++) {
            tablaLimpiar.removeRow(i);
            i -= 1;
        }
    }

    public JComboBox<String> getCmbLinea() {
        return cmbLinea;
    }

    public JButton getBtnAceptar() {
        return btnAceptar;
    }
    

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public JTable getTblClientes() {
        return tblClientes;
    }

    public JTable getTblNumPartes() {
        return tblNumPartes;
    }

    public JTable getTblOperaciones() {
        return tblOperaciones;
    }
    
    public JTable getTblPerdidas() {
        return tblPerdidas;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cmbLinea;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTable tblNumPartes;
    private javax.swing.JTable tblOperaciones;
    private javax.swing.JTable tblPerdidas;
    // End of variables declaration//GEN-END:variables
}
