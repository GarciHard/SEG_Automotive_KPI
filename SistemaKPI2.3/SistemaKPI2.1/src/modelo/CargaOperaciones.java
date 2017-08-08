/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import vista.CargaMPerdidas;

/**
 *
 * @author PRR1TL
 */
public class CargaOperaciones {
    private static DefaultTableModel modelo;
    private JFileChooser fileChooser = new JFileChooser();
     
    public void inicio(){
        disenioTabla();
        exportarDatosExcel();
    } 
    
    public void disenioTabla(){
        modelo = new DefaultTableModel();
        modelo.addColumn("Linea");
        modelo.addColumn("Tema");
        modelo.addColumn("Operacion");
        modelo.addColumn("Area");
        modelo.addColumn("Descripcion");
        
    }
    
    public void exportarDatosExcel(){
        fileChooser.showDialog(null, "Importar Hoja ");
        File file = fileChooser.getSelectedFile();
        
        if (file.getName().endsWith("xls") || file.getName().endsWith("xlsx")) {
            try {
                cargarValoresTabla(file);
            } catch (IOException ex) {
                Logger.getLogger(CargaMPerdidas.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un archivo excel...", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void cargarValoresTabla(File file) throws IOException {
        Workbook workbook = null;
        try {
            workbook = Workbook.getWorkbook(file);
            Sheet sheet = workbook.getSheet(0);
            for (int j = 0; j < sheet.getRows(); j++) { //contador para agarrar la primer linea, determina cuantas filas va agarrar
                Vector d = new Vector();
                for (int i = 0; i < 5 ; i++) { //determina cuantas columnas va agarrar 
                    Cell cell = sheet.getCell(i, j);
                    d.add(cell.getContents());
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
    
    public void insertarDatos(){
        dao.CargaMPerdidasDAOImpl cargaObj = new dao.CargaMPerdidasDAOImpl();
        int columnas = modelo.getColumnCount();
        ArrayList reg;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            try {
                reg = new ArrayList();
                for (int j = 0; j < columnas; j++) {
                    reg.add(modelo.getValueAt(i, j));
                }
                cargaObj.insertarRegistroAccess(reg);
            } catch (Exception ex) {
                Logger.getLogger(CargaMPerdidas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //limpiarTabla((DefaultTableModel) modelo.getModel());
        JOptionPane.showMessageDialog(null, "Operaciones Cargadas Correctamente","Guardar", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void limpiarTabla(DefaultTableModel mod) {
        for (int i = 0; i < mod.getRowCount(); i++) {
            mod.removeRow(i);
            i -= 1;
        }
    }
}
