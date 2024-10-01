package vistas;

import controlador.ctrlBiologo;
import modelo.mdlBiologo;

public class jfrBiologo extends javax.swing.JFrame {

    public jfrBiologo() {
        initComponents();
        this.setLocationRelativeTo(this);
    }

    public static void initEstudiante() {
        mdlBiologo modelo = new mdlBiologo();
        jfrBiologo vista = new jfrBiologo();
        ctrlBiologo controlador = new ctrlBiologo(modelo, vista);

        vista.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtPesoBiologo = new javax.swing.JTextField();
        txtEdadBiologo = new javax.swing.JTextField();
        txtCorreoBiologo = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbBiologo = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        txtBuscarBiologo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombreBiologo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 255, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPesoBiologo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesoBiologoActionPerformed(evt);
            }
        });
        jPanel1.add(txtPesoBiologo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 220, 35));
        jPanel1.add(txtEdadBiologo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, 190, 35));

        txtCorreoBiologo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoBiologoActionPerformed(evt);
            }
        });
        jPanel1.add(txtCorreoBiologo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, 530, 35));

        btnGuardar.setText("Guardar");
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, -1, -1));

        tbBiologo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbBiologo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbBiologoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbBiologo);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 470, 590, 210));

        btnEliminar.setText("Eliminar");
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, -1, -1));

        btnActualizar.setText("Actualizar");
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 380, -1, -1));

        btnLimpiar.setText("Limpiar");
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 380, -1, -1));

        txtBuscarBiologo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarBiologoActionPerformed(evt);
            }
        });
        txtBuscarBiologo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarBiologoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarBiologoKeyReleased(evt);
            }
        });
        jPanel1.add(txtBuscarBiologo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 420, 410, 30));

        jLabel1.setText("Buscar");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, 50, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel3.setText("Correo:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 50, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel4.setText("Edad:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 280, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel6.setText("Peso");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 30, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel5.setText("Nombre:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 50, -1));

        txtNombreBiologo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreBiologoActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombreBiologo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 530, 35));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/Group 6.png"))); // NOI18N
        jLabel7.setText("jLabel7");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPesoBiologoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesoBiologoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesoBiologoActionPerformed

    private void txtCorreoBiologoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoBiologoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoBiologoActionPerformed

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked

    }//GEN-LAST:event_btnGuardarMouseClicked

    private void tbBiologoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBiologoMouseClicked

    }//GEN-LAST:event_tbBiologoMouseClicked

    private void txtBuscarBiologoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarBiologoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarBiologoActionPerformed

    private void txtBuscarBiologoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarBiologoKeyPressed

    }//GEN-LAST:event_txtBuscarBiologoKeyPressed

    private void txtBuscarBiologoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarBiologoKeyReleased

    }//GEN-LAST:event_txtBuscarBiologoKeyReleased

    private void txtNombreBiologoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreBiologoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreBiologoActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                initEstudiante();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActualizar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tbBiologo;
    public javax.swing.JTextField txtBuscarBiologo;
    public javax.swing.JTextField txtCorreoBiologo;
    public javax.swing.JTextField txtEdadBiologo;
    public javax.swing.JTextField txtNombreBiologo;
    public javax.swing.JTextField txtPesoBiologo;
    // End of variables declaration//GEN-END:variables
}
