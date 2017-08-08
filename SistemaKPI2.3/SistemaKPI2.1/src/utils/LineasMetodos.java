package utils;

import dao.LineasDAOImpl;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.CargaOperaciones;
import vista.Lineas;

/**
 * Hecho con <3 por:
 * @author GarciHard
 * @boschUsr GJA5TL
 */
public class LineasMetodos {
    
    private final CargaOperaciones cargaOp = new CargaOperaciones();
    private DefaultTableModel tablaModelo;
    private String[] lineaObj;
    
    private boolean existeLinea(Lineas winLineas, String linea) {
        boolean existeLinea = false;
        try {
            existeLinea = new LineasDAOImpl().existeLinea(linea);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(winLineas, "LineasMetodos.existeLinea()\n"
                    + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return existeLinea;
    }
    
    private DefaultTableModel tablaLineas(Lineas winLineas) {
        try {
            tablaModelo = new LineasDAOImpl().listaLineasDesc((DefaultTableModel) winLineas.getTblLineas().getModel());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(winLineas, "LineasMetodos.tablaLineas()\n"
                    + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return tablaModelo;
    }
    
    private void limpiarTabla(DefaultTableModel winLineas) {
        int filas = winLineas.getRowCount();
        for (int i = 0; i < winLineas.getRowCount(); i++) {
            winLineas.removeRow(i);
            i -= 1;
        }
    }
    
    public void getTablaLineas(Lineas winLineas) {
        winLineas.getTblLineas().setModel(tablaLineas(winLineas));
    }
    
    public void actionPerformed(Lineas winLineas, ActionEvent e) {
        if (e.getSource().equals(winLineas.getBtnAgregar())) {
            switch (winLineas.getBtnAgregar().getText()) {
                case "Agregar":
                    if (!existeLinea(winLineas, winLineas.getTxtLinea().getText())) {
                        try {
                            new LineasDAOImpl().crearNvaLinea(
                                    winLineas.getTxtLinea().getText(),
                                    "0" + winLineas.getCmbTipoEnsamble().getSelectedIndex(),
                                    winLineas.getTxtNombre().getText()
                            );
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(winLineas, "LineasMetodos.actionPerformed().Agregar\n"
                                    + ex, "Error", JOptionPane.ERROR_MESSAGE);
                        } finally {
                            int op = JOptionPane.showConfirmDialog(null, "¿Desea hacer la carga de Perdidas de la linea?",  "Mensaje", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                            if (op == 0) {
                                //cargaOp.inicio();
                                System.err.println("esta entrando Si ");
                            } else {
                                System.out.println("else");
                            }
//                            JOptionPane.showMessageDialog(winLineas, "Linea agregada correctamente",
//                                    "Mensaje", JOptionPane.INFORMATION_MESSAGE);
//                            
//                            winLineas.getCmbTipoEnsamble().setSelectedIndex(0);
//                            limpiarTabla((DefaultTableModel) winLineas.getTblLineas().getModel());
//                            getTablaLineas(winLineas);
//                            System.out.println("utils.LineasMetodos.actionPerformed()");
                            
                        }
                    }
                    break;
                case "Modificar":
                    try {
                        Object[] lineaObj = new Object[3];
                        lineaObj[0] = winLineas.getTxtLinea().getText();
                        lineaObj[1] = "0" + winLineas.getCmbTipoEnsamble().getSelectedIndex();
                        lineaObj[2] = winLineas.getTxtNombre().getText();
                        new LineasDAOImpl().actualizarLinea(
                                winLineas.getTblLineas().getValueAt(winLineas.getTblLineas().getSelectedRow(), 0).toString()
                                , lineaObj);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(winLineas, "LineasMetodos.actionPerformed().Modificar\n"
                                + ex, "Error", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        JOptionPane.showMessageDialog(winLineas, "Linea modificada correctamente",
                                "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        winLineas.getCmbTipoEnsamble().setSelectedIndex(0);
                        limpiarTabla((DefaultTableModel) winLineas.getTblLineas().getModel());
                        getTablaLineas(winLineas);
                    }
                    break;
            }
        } else if (e.getSource().equals(winLineas.getBtnCancelar())) {
            winLineas.dispose();
        } else if (e.getSource().equals(winLineas.getMniModificar())) {
            try {
                lineaObj = new LineasDAOImpl().buscarRegistro(
                        winLineas.getTblLineas().getValueAt(winLineas.getTblLineas().getSelectedRow(), 0).toString()
                );
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(winLineas, "LineasMetodos.actionPerformed.mniModificar()\n"
                        + ex, "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                winLineas.getCmbTipoEnsamble().setSelectedIndex(
                        Integer.parseInt(String.valueOf(lineaObj[1].charAt(1)))
                );
                winLineas.getTxtLinea().setText(lineaObj[0]);
                winLineas.getTxtNombre().setText(lineaObj[2]);
                winLineas.getBtnAgregar().setText("Modificar");
            }
        } else if (e.getSource().equals(winLineas.getMniEliminar())) {
            switch (JOptionPane.showConfirmDialog(winLineas, "El registro se eliminara permanentemente\n¿Seguro que desea continuar?", "Mensaje",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
                case 0:
                    try {
                        new LineasDAOImpl().eliminarLinea(
                                String.valueOf(winLineas.getTblLineas().getValueAt(winLineas.getTblLineas().getSelectedRow(), 0))
                        );
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(winLineas, "LineasMetodos.actionPerformed.mniEliminar()\n"
                                + ex, "Error", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        JOptionPane.showMessageDialog(winLineas, "Linea eliminada correctamente",
                                "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        winLineas.getCmbTipoEnsamble().setSelectedIndex(0);
                        limpiarTabla((DefaultTableModel) winLineas.getTblLineas().getModel());
                        getTablaLineas(winLineas);
                        winLineas.getBtnAgregar().setText("Agregar");
                    }
                    break;
            }
        }
    }
}
