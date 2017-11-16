package vista;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.Character.UnicodeBlock.of;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import utils.PrincipalMetodos;
import static vista.Cargas.linea;

/**
 *
 * @author PRR1TL
 */
public class CargaTargetEntregas extends javax.swing.JFrame {
    
    public static String linea = "";
    public static String mes = "";
    public static String anio = "";
    public static String noMes = "";
    public static String mes2 = "";
    
    String dias;
    String tek;
    String programado;
    String[] arrayNombres;    
        
    String dia = ""; 
    int existe = 0 ;
            
    public CargaTargetEntregas() {
        initComponents();
        cmbLinea.setModel(new PrincipalMetodos().listaLineas());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCargar = new javax.swing.JButton();
        cmbLinea = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        cmbMes = new javax.swing.JComboBox<>();
        txtAnio = new javax.swing.JTextField();
        lblDiasMes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCargar.setText("Cargar");
        btnCargar.setEnabled(false);
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });

        cmbLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLineaActionPerformed(evt);
            }
        });

        cmbMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona Mes", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        cmbMes.setEnabled(false);
        cmbMes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMesItemStateChanged(evt);
            }
        });

        txtAnio.setEnabled(false);
        txtAnio.setNextFocusableComponent(btnCargar);
        txtAnio.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtAnioCaretUpdate(evt);
            }
        });
        txtAnio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAnioKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(cmbLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnCargar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDiasMes, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(cmbLinea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCargar)
                        .addGap(31, 31, 31)))
                .addComponent(lblDiasMes, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAnioCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtAnioCaretUpdate
        if ((evt.getDot() + evt.getMark()) == 0 && cmbMes.getSelectedIndex() == 0) {
            btnCargar.setEnabled(false);            
        } else if (evt.getDot() >= 1 && evt.getMark() >= 1 && cmbMes.getSelectedIndex() != 0) {
            btnCargar.setEnabled(true);
        } 
    }//GEN-LAST:event_txtAnioCaretUpdate

    private void cmbMesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMesItemStateChanged
        if(cmbMes.getSelectedIndex() == 0){
            txtAnio.setEnabled(false);
        } else {
            txtAnio.setEnabled(true);
        }
    }//GEN-LAST:event_cmbMesItemStateChanged

    private void txtAnioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnioKeyTyped
        int dig = txtAnio.getText().length();
        if (!txtAnio.getText().isEmpty()) {
            if (((evt.getKeyChar() < '0' || evt.getKeyChar() > '9')) || dig > 3 ) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtAnioKeyTyped

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        linea = cmbLinea.getSelectedItem().toString();
        mes = cmbMes.getSelectedItem().toString();
        noMes = Integer.toString(cmbMes.getSelectedIndex());
        anio = txtAnio.getText();
        
        int cargaM = JOptionPane.showConfirmDialog(null, "¿Desea Cargar Targets de Entregas?\n\t"+ linea,  "Mensaje", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
      
        if (cargaM == 0) {
            File file = new File("C:\\Users\\PRR1TL.SG\\Documents\\Formatos\\Mach Target Produccion.xls");
            try {
                obtencionFecha(file);                
            } catch (IOException ex) {
                Logger.getLogger(CargaTargetEntregas.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(CargaTargetEntregas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
                    
    }//GEN-LAST:event_btnCargarActionPerformed

    private void cmbLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLineaActionPerformed
        if(cmbLinea.getSelectedIndex() != 0){
            cmbMes.setEnabled(true);
        } else {
            cmbMes.setEnabled(false);
        }
    }//GEN-LAST:event_cmbLineaActionPerformed

    public static void main(String args[]) {        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CargaTargetEntregas().setVisible(true);
            }
        });
    }

    public void obtencionFecha(File file) throws IOException, Exception{
        dao.CargaTargetEntregas cargaObj = new dao.CargaTargetEntregas();
        Workbook workbook = null;   
        ArrayList regDia;
        ArrayList regTEK;
        ArrayList regProg;
        try {
            workbook = Workbook.getWorkbook(file);
            Sheet sheet = workbook.getSheet(0);            
            regDia = new ArrayList();
            regTEK = new ArrayList();
            regProg = new ArrayList();
            
            for (int i = 1; i < sheet.getColumns()-1; i++) { //determina cuantas columnas va agarrar 
                jxl.Cell cellDia = sheet.getCell(i, 3); 
                jxl.Cell cellProg = sheet.getCell(i, 5); 
                jxl.Cell cellTEK = sheet.getCell(i, 6); 

                dias = cellDia.getContents();
                tek = cellTEK.getContents(); 
                programado = cellProg.getContents(); 

                regDia.add(cellDia.getContents());
                regTEK.add(cellTEK.getContents());
                regProg.add(cellProg.getContents());                                        

                arrayNombres = dias.split("-");

                for (int n = 0; n < arrayNombres.length-1; n++) {
                    if (n == 0) {
                        existe = 0;  
                        dia = arrayNombres[n].toUpperCase();
                        existe = cargaObj.consultaFechaExistente(linea, anio, mes, noMes, dia);
                        if (existe == 0 ) {
                            cargaObj.insertarFechaYLinea(linea, anio, mes, noMes, dia, tek, programado);
                        } else  if (existe == 1 ){  
                            noMes = String.valueOf(Integer.parseInt(noMes)+1);
                            transformaMes(noMes);
                            mes2 = transformaMes(noMes);
                            System.out.println(dia+","+noMes);
                            if (noMes == "12") {            
                                mes2 = transformaMes("1");
                                cargaObj.insertarFechaYLinea(linea, String.valueOf(Integer.parseInt(anio)+1), mes2, noMes, dia, tek, programado); 
                            } else {                                                              
                                cargaObj.insertarFechaYLinea(linea, anio, mes2, noMes, dia, tek, programado);                                
                            }
                        }
                    }                         
                }                   
            }
            System.out.println("regDia: "+regDia);
            System.out.println("regTek: "+regTEK);
            System.out.println("regProg: "+regProg);
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }    
    
    public String transformaMes (String numeroMes){
        switch (numeroMes){
            case "1":
                mes = "Enero";
                break;
            case "2":
                mes = "Febrero";
                break;
            case "3":
                mes = "Marzo";
                break;
            case "4":
                mes = "Abril";
                break;
            case "5":
                mes = "Mayo";
                break;
            case "6":
                mes = "Junio";
                break;
            case "7":
                mes = "Julio";
                break;
            case "8":
                mes = "Agosto";
                break;
            case "9":
                mes = "Septiembre";
                break;
            case "10":
                mes = "Octubre";
                break;
            case "11":
                mes = "Noviembre";
                break;
            case "12":
                mes = "Diciembre";
                break;
        }
        return mes;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargar;
    private javax.swing.JComboBox<String> cmbLinea;
    private javax.swing.JComboBox<String> cmbMes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDiasMes;
    private javax.swing.JTextField txtAnio;
    // End of variables declaration//GEN-END:variables
}
