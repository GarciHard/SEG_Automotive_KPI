package vista;

import control.LoginControl;
import dao.TiempoTurnoDAOImpl;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 * Hecho con <3 por:
 * @author GarciHard
 * @boschUsr GJA5TL
 */
public class TiempoTurno extends javax.swing.JDialog {

    public static int auxiliarTiempoTurno;
    private boolean existeHorario;
    private boolean cerrarVentana;
    private Principal winPrincipal;
    private ParoRango winParoPeriodo;
    public static  ArrayList cmbTiempoModel = new ArrayList();
    
    /** Creates new form TiempoTurno */    
    public TiempoTurno(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        winPrincipal = (Principal) parent;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tiempo de Trabajo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        jLabel1.setText("Turno");

        jLabel2.setText("Hora Inicial:");

        jLabel3.setText("Hora Final:");

        jLabel4.setText("No. Personal:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona turno", "Primer Turno", "Segundo Turno", "Tercer Turno" }));
        jComboBox1.setNextFocusableComponent(jTextField1);
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox1KeyPressed(evt);
            }
        });

        jTextField1.setEnabled(false);
        jTextField1.setNextFocusableComponent(jTextField2);
        jTextField1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextField1CaretUpdate(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jTextField2.setEnabled(false);
        jTextField2.setNextFocusableComponent(jTextField3);
        jTextField2.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextField2CaretUpdate(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jTextField3.setEnabled(false);
        jTextField3.setNextFocusableComponent(jButton1);
        jTextField3.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextField3CaretUpdate(evt);
            }
        });
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField3KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });

        jButton1.setText("Validar");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Limpiar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        auxiliarTiempoTurno = 1;
        new LoginControl(new Login(winPrincipal, true));
        if (auxiliarTiempoTurno == 2) {
            try {
                existeHorario = new TiempoTurnoDAOImpl().horarioExisteBitacora(
                        winPrincipal.getCmbLinea().getSelectedItem().toString(),
                        winPrincipal.getDteFecha().getText(),
                        jComboBox1.getSelectedItem().toString(),
                        Integer.parseInt(jTextField1.getText()),
                        Integer.parseInt(jTextField2.getText())
                );
                if (!existeHorario) {

                    new TiempoTurnoDAOImpl().registrarHorarioBitacora(
                            winPrincipal.getCmbLinea().getSelectedItem().toString(),
                            winPrincipal.getDteFecha().getText(),
                            String.valueOf(jComboBox1.getSelectedItem()),
                            Integer.parseInt(jTextField1.getText()),
                            Integer.parseInt(jTextField2.getText()),
                            Integer.parseInt(jTextField3.getText())
                    );
                    
                    int horaInicial = Integer.parseInt(jTextField1.getText());
                    int horaFinal = Integer.parseInt(jTextField2.getText());
                    if (horaInicial > horaFinal) {
                        cmbTiempoModel.add("Selecciona Hora");
                        for (int i = horaInicial; i != 0; i++) {
                            if (i == 24) {
                                i = 0;
                            } else if (i == horaFinal) {
                                break;
                            }
                            cmbTiempoModel.add(i);
                        }
                    } else {
                        int duracionTurno = horaFinal - horaInicial;
                        cmbTiempoModel.add("Selecciona Hora");
                        for (int i = 0, j = horaInicial; i < duracionTurno; i++, j++) {
                            cmbTiempoModel.add(j);
                        }
                    }                 
                    
                    winPrincipal.getLblTurno().setText(jComboBox1.getSelectedItem().toString()
                            + " <> " + horaInicial + " - " + horaFinal);

                    winPrincipal.getCmbHora().setModel(new DefaultComboBoxModel(cmbTiempoModel.toArray()));
                    winPrincipal.getCmbTema().setEnabled(true);
                    winPrincipal.getMniOperaciones().setEnabled(true);
                    winPrincipal.getMniCargaMasiva().setEnabled(true);
                    cerrarVentana = true;
                    
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "TiempoTurno.btnIniciarActionPerformed()\n"
                            + "Turno ya registrado en la bitacora", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    jComboBox1.setSelectedIndex(0);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "TiempoTurno.btnIniciarActionPerformed()\n"
                        + e, "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jComboBox1.setSelectedIndex(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField3CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextField3CaretUpdate
        if ((evt.getDot() + evt.getMark()) == 0) {
            jButton1.setEnabled(false);
        } else if (evt.getDot() >= 1 && evt.getMark() >= 1) {
            jButton1.setEnabled(true);
        } else if (jTextField3.getText().isEmpty()) {
            jButton1.setEnabled(false);
        }
    }//GEN-LAST:event_jTextField3CaretUpdate

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        if (jComboBox1.getSelectedIndex() != 0) {
            jTextField1.setText("");
            jTextField1.setEnabled(true);
        } else {
            jTextField1.setText("");
            jTextField1.setEnabled(false);
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jTextField1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextField1CaretUpdate
        if ((evt.getDot() + evt.getMark()) == 0) {
            jTextField2.setEnabled(false);
            jTextField2.setText("");
        } else if (evt.getDot() >= 1 && evt.getMark() >= 1) {
            jTextField2.setEnabled(true);
        } else if (jTextField1.getText().isEmpty()) {
            jTextField2.setEnabled(false);
            jTextField2.setText("");
        }
    }//GEN-LAST:event_jTextField1CaretUpdate

    private void jTextField2CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextField2CaretUpdate
        if ((evt.getDot() + evt.getMark()) == 0) {
            jTextField3.setEnabled(false);
            jTextField3.setText("");
        } else if (evt.getDot() >= 1 && evt.getMark() >= 1) {
            jTextField3.setEnabled(true);
        } else if (jTextField2.getText().isEmpty()) {
            jTextField3.setEnabled(false);
            jTextField3.setText("");
        }
    }//GEN-LAST:event_jTextField2CaretUpdate

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        if ((evt.getKeyChar() < '0' || evt.getKeyChar() > '9')) {
            evt.consume();
        } else if (jTextField1.getText().length() >= 2) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        if ((evt.getKeyChar() < '0' || evt.getKeyChar() > '9')) {
            evt.consume();
        } else if (jTextField2.getText().length() >= 2) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyTyped
        if ((evt.getKeyChar() < '0' || evt.getKeyChar() > '9')) {
            evt.consume();
        } else if (jTextField3.getText().length() >= 2) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField3KeyTyped

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        if (!jTextField1.getText().isEmpty()) {
            if (Integer.parseInt(jTextField1.getText()) > 23
                    || Integer.parseInt(jTextField1.getText()) < 0) {
                jTextField1.setText("");
            }
        }
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        if (!jTextField2.getText().isEmpty()) {
            if (Integer.parseInt(jTextField2.getText()) > 23
                    || Integer.parseInt(jTextField2.getText()) < 0) {
                jTextField2.setText("");
            }
        }
    }//GEN-LAST:event_jTextField2KeyReleased

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if (cerrarVentana == false) {
            winPrincipal.getCmbLinea().setSelectedIndex(0);
        }
    }//GEN-LAST:event_formWindowClosed

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        if (!jTextField3.getText().isEmpty()) {
            if (Integer.parseInt(jTextField3.getText()) > 30
                    || Integer.parseInt(jTextField3.getText()) < 1) {
                jTextField3.setText("");
            }
        }
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jComboBox1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1KeyPressed
        if (evt.getKeyCode() == 10 && jComboBox1.getSelectedIndex() != 0) {
            jComboBox1.transferFocus();
        }
    }//GEN-LAST:event_jComboBox1KeyPressed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        if (evt.getKeyCode() == 10 && !jTextField1.getText().isEmpty()) {
            jTextField1.transferFocus();
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        if (evt.getKeyCode() == 10 && !jTextField2.getText().isEmpty()) {
            jTextField2.transferFocus();
        }
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jTextField3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyPressed
        if (evt.getKeyCode() == 10 && !jTextField3.getText().isEmpty()) {
            jTextField3.transferFocus();
        }
    }//GEN-LAST:event_jTextField3KeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables

}
