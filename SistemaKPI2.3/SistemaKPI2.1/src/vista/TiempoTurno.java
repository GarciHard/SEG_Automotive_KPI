package vista;

import control.LoginControl;
import dao.TiempoTurnoDAOImpl;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.prompt.PromptSupport;

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
    public static  ArrayList cmbTiempoModel = new ArrayList();
    
    /** Creates new form TiempoTurno */    
    public TiempoTurno(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        PromptSupport.setPrompt("0-24 hrs",txtHoraInicial);
        PromptSupport.setPrompt("0-24 hrs",txtHoraFinal);
        PromptSupport.setPrompt("máx 30", txtnNoPersonas);
        winPrincipal = (Principal) parent;
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/bs.png")).getImage());
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
        txtHoraInicial = new javax.swing.JTextField();
        txtHoraFinal = new javax.swing.JTextField();
        txtnNoPersonas = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tiempo de Trabajo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        jLabel1.setText("Turno");

        jLabel2.setText("Hora Inicial:");

        jLabel3.setText("Hora Final:");

        jLabel4.setText("No. Personal:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona turno", "Primer Turno", "Segundo Turno", "Tercer Turno" }));
        jComboBox1.setNextFocusableComponent(txtHoraInicial);
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

        txtHoraInicial.setEnabled(false);
        txtHoraInicial.setNextFocusableComponent(txtHoraFinal);
        txtHoraInicial.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtHoraInicialCaretUpdate(evt);
            }
        });
        txtHoraInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtHoraInicialKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtHoraInicialKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHoraInicialKeyTyped(evt);
            }
        });

        txtHoraFinal.setEnabled(false);
        txtHoraFinal.setNextFocusableComponent(txtnNoPersonas);
        txtHoraFinal.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtHoraFinalCaretUpdate(evt);
            }
        });
        txtHoraFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtHoraFinalKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtHoraFinalKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHoraFinalKeyTyped(evt);
            }
        });

        txtnNoPersonas.setEnabled(false);
        txtnNoPersonas.setNextFocusableComponent(jButton1);
        txtnNoPersonas.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtnNoPersonasCaretUpdate(evt);
            }
        });
        txtnNoPersonas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnNoPersonasKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnNoPersonasKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnNoPersonasKeyTyped(evt);
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
                        .addComponent(txtnNoPersonas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addComponent(txtHoraFinal, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtHoraInicial, javax.swing.GroupLayout.Alignment.LEADING)))
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
                    .addComponent(txtHoraInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtHoraFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtnNoPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        Integer.parseInt(txtHoraInicial.getText()),
                        Integer.parseInt(txtHoraFinal.getText())
                );
                if (!existeHorario) {

                    new TiempoTurnoDAOImpl().registrarHorarioBitacora(
                            winPrincipal.getCmbLinea().getSelectedItem().toString(),
                            winPrincipal.getDteFecha().getText(),
                            String.valueOf(jComboBox1.getSelectedItem()),
                            Integer.parseInt(txtHoraInicial.getText()),
                            Integer.parseInt(txtHoraFinal.getText()),
                            Integer.parseInt(txtnNoPersonas.getText())
                    );
                    
                    int horaInicial = Integer.parseInt(txtHoraInicial.getText());
                    int horaFinal = Integer.parseInt(txtHoraFinal.getText());
                    if (horaInicial > horaFinal) {
                        cmbTiempoModel.clear();
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
                        cmbTiempoModel.clear();
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

    private void txtnNoPersonasCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtnNoPersonasCaretUpdate
        if ((evt.getDot() + evt.getMark()) == 0) {
            jButton1.setEnabled(false);
        } else if (evt.getDot() >= 1 && evt.getMark() >= 1) {
            jButton1.setEnabled(true);
        } else if (txtnNoPersonas.getText().isEmpty()) {
            jButton1.setEnabled(false);
        }
    }//GEN-LAST:event_txtnNoPersonasCaretUpdate

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        if (jComboBox1.getSelectedIndex() != 0) {
            txtHoraInicial.setText("");
            txtHoraInicial.setEnabled(true);
        } else {
            txtHoraInicial.setText("");
            txtHoraInicial.setEnabled(false);
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void txtHoraInicialCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtHoraInicialCaretUpdate
        if ((evt.getDot() + evt.getMark()) == 0) {
            txtHoraFinal.setEnabled(false);
            txtHoraFinal.setText("");
        } else if (evt.getDot() >= 1 && evt.getMark() >= 1) {
            txtHoraFinal.setEnabled(true);
        } else if (txtHoraInicial.getText().isEmpty()) {
            txtHoraFinal.setEnabled(false);
            txtHoraFinal.setText("");
        }
    }//GEN-LAST:event_txtHoraInicialCaretUpdate

    private void txtHoraFinalCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtHoraFinalCaretUpdate
        if ((evt.getDot() + evt.getMark()) == 0) {
            txtnNoPersonas.setEnabled(false);
            txtnNoPersonas.setText("");
        } else if (evt.getDot() >= 1 && evt.getMark() >= 1) {
            txtnNoPersonas.setEnabled(true);
        } else if (txtHoraFinal.getText().isEmpty()) {
            txtnNoPersonas.setEnabled(false);
            txtnNoPersonas.setText("");
        }
    }//GEN-LAST:event_txtHoraFinalCaretUpdate

    private void txtHoraInicialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoraInicialKeyTyped
        if ((evt.getKeyChar() < '0' || evt.getKeyChar() > '9')) {
            evt.consume();
        } else if (txtHoraInicial.getText().length() >= 2) {
            evt.consume();
        }
    }//GEN-LAST:event_txtHoraInicialKeyTyped

    private void txtHoraFinalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoraFinalKeyTyped
        if ((evt.getKeyChar() < '0' || evt.getKeyChar() > '9')) {
            evt.consume();
        } else if (txtHoraFinal.getText().length() >= 2) {
            evt.consume();
        }
    }//GEN-LAST:event_txtHoraFinalKeyTyped

    private void txtnNoPersonasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnNoPersonasKeyTyped
        if ((evt.getKeyChar() < '0' || evt.getKeyChar() > '9')) {
            evt.consume();
        } else if (txtnNoPersonas.getText().length() >= 2) {
            evt.consume();
        }
    }//GEN-LAST:event_txtnNoPersonasKeyTyped

    private void txtHoraInicialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoraInicialKeyReleased
        if (!txtHoraInicial.getText().isEmpty()) {
            if (Integer.parseInt(txtHoraInicial.getText()) > 23
                    || Integer.parseInt(txtHoraInicial.getText()) < 0) {
                txtHoraInicial.setText("");
            }
        }
    }//GEN-LAST:event_txtHoraInicialKeyReleased

    private void txtHoraFinalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoraFinalKeyReleased
        if (!txtHoraFinal.getText().isEmpty()) {
            if (Integer.parseInt(txtHoraFinal.getText()) > 24
                    || Integer.parseInt(txtHoraFinal.getText()) < 0) {
                txtHoraFinal.setText("");
            }
        }
    }//GEN-LAST:event_txtHoraFinalKeyReleased

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if (cerrarVentana == false) {
            winPrincipal.getCmbLinea().setSelectedIndex(0);
        }
    }//GEN-LAST:event_formWindowClosed

    private void txtnNoPersonasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnNoPersonasKeyReleased
        if (!txtnNoPersonas.getText().isEmpty()) {
            if (Integer.parseInt(txtnNoPersonas.getText()) > 30
                    || Integer.parseInt(txtnNoPersonas.getText()) < 1) {
                txtnNoPersonas.setText("");
            }
        }
    }//GEN-LAST:event_txtnNoPersonasKeyReleased

    private void jComboBox1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1KeyPressed
        if (evt.getKeyCode() == 10 && jComboBox1.getSelectedIndex() != 0) {
            jComboBox1.transferFocus();
        }
    }//GEN-LAST:event_jComboBox1KeyPressed

    private void txtHoraInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoraInicialKeyPressed
        if (evt.getKeyCode() == 10 && !txtHoraInicial.getText().isEmpty()) {
            txtHoraInicial.transferFocus();
        }
    }//GEN-LAST:event_txtHoraInicialKeyPressed

    private void txtHoraFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoraFinalKeyPressed
        if (evt.getKeyCode() == 10 && !txtHoraFinal.getText().isEmpty()) {
            txtHoraFinal.transferFocus();
        }
    }//GEN-LAST:event_txtHoraFinalKeyPressed

    private void txtnNoPersonasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnNoPersonasKeyPressed
        if (evt.getKeyCode() == 10 && !txtnNoPersonas.getText().isEmpty()) {
            txtnNoPersonas.transferFocus();
        }
    }//GEN-LAST:event_txtnNoPersonasKeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (winPrincipal.getLblTurno().getText().isEmpty()) {
            if (JOptionPane.showConfirmDialog(this, "¿Seguro que desea salir?", "Mensaje",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
                System.exit(0);
            }
        } else {
            if (JOptionPane.showConfirmDialog(this, "¿Seguro que desea salir?", "Mensaje",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
                System.exit(0);
            }
        }
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtHoraFinal;
    private javax.swing.JTextField txtHoraInicial;
    private javax.swing.JTextField txtnNoPersonas;
    // End of variables declaration//GEN-END:variables

}
