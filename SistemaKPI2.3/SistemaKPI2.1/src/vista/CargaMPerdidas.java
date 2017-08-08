/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import dao.CargaMPerdidasDAOImpl;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import modelo.CargaMPerdidasDAO;

/**
 *
 * @author PRR1TL
 */
public class CargaMPerdidas extends javax.swing.JFrame {
    
    private static DefaultTableModel modelo;
    //private JFileChooser fileChooser = new JFileChooser();
    private static CargaMPerdidas winCargaMOp;
    /**
     * Creates new form CargaMOperaciones
     */
    
    public CargaMPerdidas() {
        initComponents();
        modelo = new DefaultTableModel();
        modelo.addColumn("Linea");
        modelo.addColumn("Tema");
        modelo.addColumn("Operacion");
        modelo.addColumn("Area");
        modelo.addColumn("Descripcion");
        tablaCarga.setModel(modelo);   
        importarExcel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCarga = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaCarga.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaCarga.setEnabled(false);
        jScrollPane1.setViewportView(tablaCarga);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(btnGuardar)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnGuardar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        dao.CargaMPerdidasDAOImpl cargaObj = new dao.CargaMPerdidasDAOImpl();
        int columnas = tablaCarga.getColumnCount();
        ArrayList reg;
        for (int i = 0; i < tablaCarga.getRowCount(); i++) {
            try {
                reg = new ArrayList();
                for (int j = 0; j < columnas; j++) {
                    
                    reg.add(tablaCarga.getValueAt(i, j));
                }
                System.err.println("."+reg);
                cargaObj.insertarRegistroAccess(reg);
            } catch (Exception ex) {
                Logger.getLogger(CargaMPerdidas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        limpiarTabla((DefaultTableModel) tablaCarga.getModel());
        JOptionPane.showMessageDialog(null, "Operaciones guardadas Correctamente",
               "Guardar", JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }//GEN-LAST:event_btnGuardarActionPerformed
    
    public void importarExcel (){
        //fileChooser.showDialog(null, "Importar Hoja ");
        //File file = fileChooser.getSelectedFile();
        File file = new File("C:\\Users\\PRR1TL\\Documents\\Book1.xls");
        
        if (file.getName().endsWith("xls") || file.getName().endsWith("xlsx")) {
            try {
                crearTabla(file);
            } catch (IOException ex) {
                Logger.getLogger(CargaMPerdidas.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un archivo excel...", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void crearTabla(File file) throws IOException {
        Workbook workbook = null;

        try {
            workbook = Workbook.getWorkbook(file);
            Sheet sheet = workbook.getSheet(0);
            
            for (int j = 0; j < sheet.getRows(); j++) { //contador para agarrar la primer linea, determina cuantas filas va agarrar
                Vector d = new Vector();
                for (int i = 0; i < 4 ; i++) { //determina cuantas columnas va agarrar 
                    Cell cell = sheet.getCell(i, j);
                    d.add(cell.getContents());
                    //d.addElement("num Linea");
                }
                System.err.println("-"+d);
                d.add("\n");
                //filas.add(d);
                modelo.addRow(d);
            }

        } catch (BiffException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CargaMPerdidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CargaMPerdidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CargaMPerdidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CargaMPerdidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CargaMPerdidas().setVisible(true);
            }
        });
    }

    private void limpiarTabla(DefaultTableModel tableCarga) {
        for (int i = 0; i < tableCarga.getRowCount(); i++) {
            tableCarga.removeRow(i);
            i -= 1;
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaCarga;
    // End of variables declaration//GEN-END:variables
}
