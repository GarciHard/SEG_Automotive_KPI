package vista;

import java.awt.Cursor;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import utils.PrincipalMetodos;

/**
 * Hecho con <3 por:
 * @author GarciHard
 * @boschUsr GJA5TL
 */
public class SeleccionLinea extends javax.swing.JDialog {

    private final Principal winPrincipal;
    
    /** Creates new form SeleccionLinea */
    public SeleccionLinea(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        winPrincipal = (Principal) parent;
        cmbLinea.setModel(new PrincipalMetodos().listaLineas());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackground = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbLinea = new javax.swing.JComboBox<>();
        btnCambiarLinea = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnlBackground.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lineas de producción", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Linea:");

        cmbLinea.setEnabled(false);
        cmbLinea.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbLineaItemStateChanged(evt);
            }
        });

        btnCambiarLinea.setText("Seleccionar Linea");
        btnCambiarLinea.setToolTipText("");
        btnCambiarLinea.setFocusable(false);
        btnCambiarLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarLineaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(cmbLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCambiarLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbLinea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCambiarLinea))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        switch (JOptionPane.showConfirmDialog(this, "¿Seguro que desea salir?",
                "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE)) {
            case 0:
                System.exit(0);
                break;
            case 1:
                this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                break;
        }
    }//GEN-LAST:event_formWindowClosing

    private void btnCambiarLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarLineaActionPerformed
        switch (btnCambiarLinea.getText()) {
            case "Seleccionar Linea":
                cmbLinea.setEnabled(true);
                btnCambiarLinea.setEnabled(false);
                break;
            case "Aceptar":
                winPrincipal.getCmbLinea().setSelectedItem(cmbLinea.getSelectedItem());
                this.dispose();
                winPrincipal.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                break;
        }
    }//GEN-LAST:event_btnCambiarLineaActionPerformed

    private void cmbLineaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbLineaItemStateChanged
        switch (cmbLinea.getSelectedIndex()) {
            case 0:
                btnCambiarLinea.setText("Seleccionar Linea");
                btnCambiarLinea.setEnabled(false);
                break;
            default:
                btnCambiarLinea.setText("Aceptar");
                btnCambiarLinea.setEnabled(true);
                break;
        }
    }//GEN-LAST:event_cmbLineaItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiarLinea;
    private javax.swing.JComboBox<String> cmbLinea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel pnlBackground;
    // End of variables declaration//GEN-END:variables

}
