
import database.MethodsUser;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mauro
 */
public class Update extends javax.swing.JFrame {

    private final String adminName;
    private final int adminId;
    private int id;

    /**
     * Creates new form Update
     */
    public Update(int adminId, String adminName) {
        initComponents();
        setIcon();
        
        this.adminId = adminId;
        this.adminName = adminName;

        MethodsUser object = new MethodsUser();
        List<String> cadena = object.allContactsUpdate(adminId);
        DefaultTableModel model = (DefaultTableModel) tblConsultUpdate.getModel();
        model.setRowCount(0);

        for (String contactDetails : cadena) {
            String[] rowData = contactDetails.split("\n");
            model.addRow(rowData);
        }
        tblConsultUpdate.setModel(model);
        jScrollPane1.setViewportView(tblConsultUpdate);
        tblConsultUpdate.setRowHeight(40);
        txtUpdateName.setEnabled(false);
        txtUpdateLastName.setEnabled(false);
        txtUpdateEmail.setEnabled(false);
        txtUpdatePhone.setEnabled(false);
        btnUpdate.setEnabled(false);
    }

    private Update() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnUpdateMenu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblConsultUpdate = new javax.swing.JTable();
        txtUpdateId = new javax.swing.JTextField();
        txtUpdateName = new javax.swing.JTextField();
        txtUpdateLastName = new javax.swing.JTextField();
        txtUpdatePhone = new javax.swing.JTextField();
        txtUpdateEmail = new javax.swing.JTextField();
        btnConsultUpdate = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        fondoUpdate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SmartManager");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnUpdateMenu.setBackground(new java.awt.Color(0, 0, 0));
        btnUpdateMenu.setFont(new java.awt.Font("Century Schoolbook", 3, 14)); // NOI18N
        btnUpdateMenu.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateMenu.setBorder(null);
        btnUpdateMenu.setContentAreaFilled(false);
        btnUpdateMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdateMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateMenuActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdateMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 30, 30));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        tblConsultUpdate.setBackground(new java.awt.Color(51, 51, 51));
        tblConsultUpdate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        tblConsultUpdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tblConsultUpdate.setForeground(new java.awt.Color(255, 255, 255));
        tblConsultUpdate.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Sobre Nome", "Telefone", "E-mail"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblConsultUpdate);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 780, 190));

        txtUpdateId.setBackground(new java.awt.Color(51, 51, 51));
        txtUpdateId.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtUpdateId.setForeground(new java.awt.Color(255, 255, 255));
        txtUpdateId.setBorder(null);
        txtUpdateId.setSelectionStart(1);
        getContentPane().add(txtUpdateId, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 320, 20));

        txtUpdateName.setBackground(new java.awt.Color(51, 51, 51));
        txtUpdateName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtUpdateName.setForeground(new java.awt.Color(255, 255, 255));
        txtUpdateName.setBorder(null);
        txtUpdateName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUpdateNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtUpdateName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 416, 300, 20));

        txtUpdateLastName.setBackground(new java.awt.Color(51, 51, 51));
        txtUpdateLastName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtUpdateLastName.setForeground(new java.awt.Color(255, 255, 255));
        txtUpdateLastName.setBorder(null);
        txtUpdateLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUpdateLastNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtUpdateLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 450, 260, 20));

        txtUpdatePhone.setBackground(new java.awt.Color(51, 51, 51));
        txtUpdatePhone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtUpdatePhone.setForeground(new java.awt.Color(255, 255, 255));
        txtUpdatePhone.setBorder(null);
        txtUpdatePhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUpdatePhoneActionPerformed(evt);
            }
        });
        getContentPane().add(txtUpdatePhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 486, 280, 20));

        txtUpdateEmail.setBackground(new java.awt.Color(51, 51, 51));
        txtUpdateEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtUpdateEmail.setForeground(new java.awt.Color(255, 255, 255));
        txtUpdateEmail.setBorder(null);
        getContentPane().add(txtUpdateEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 520, 300, 20));

        btnConsultUpdate.setBackground(new java.awt.Color(204, 204, 204));
        btnConsultUpdate.setFont(new java.awt.Font("Century Schoolbook", 3, 14)); // NOI18N
        btnConsultUpdate.setBorder(null);
        btnConsultUpdate.setContentAreaFilled(false);
        btnConsultUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConsultUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnConsultUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 360, 160, 40));

        btnUpdate.setBackground(new java.awt.Color(204, 204, 204));
        btnUpdate.setFont(new java.awt.Font("Century Schoolbook", 3, 14)); // NOI18N
        btnUpdate.setBorder(null);
        btnUpdate.setContentAreaFilled(false);
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 410, 160, 40));

        fondoUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ATUALIZAR_CONTATO.jpg"))); // NOI18N
        getContentPane().add(fondoUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateMenuActionPerformed
        MainMenu newFrame = new MainMenu(adminId, adminName);
        newFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnUpdateMenuActionPerformed

    private void btnConsultUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultUpdateActionPerformed
        try {
            MethodsUser object = new MethodsUser();
            id = Integer.parseInt(txtUpdateId.getText());
            List<String> updateDetails = object.getUpdate(id, adminId);

            if (updateDetails.size() >= 4) {
                txtUpdateName.setText(updateDetails.get(0));
                txtUpdateLastName.setText(updateDetails.get(1));
                txtUpdateEmail.setText(updateDetails.get(2));
                txtUpdatePhone.setText(updateDetails.get(3));

                txtUpdateName.setEnabled(true);
                txtUpdateLastName.setEnabled(true);
                txtUpdateEmail.setEnabled(true);
                txtUpdatePhone.setEnabled(true);
                btnUpdate.setEnabled(true);

            } else {
                JOptionPane.showMessageDialog(null, "A lista não tem elementos suficientes");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Insira um ID válido");
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + e.getMessage());
        }
    }//GEN-LAST:event_btnConsultUpdateActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            String name = txtUpdateName.getText();
            String lastName = txtUpdateLastName.getText();
            String email = txtUpdateEmail.getText();
            String phone = txtUpdatePhone.getText();
            String numsort = txtUpdatePhone.getText();
            String brinde = txtUpdatePhone.getText();
            
            if (!name.isEmpty() && !lastName.isEmpty() && !email.isEmpty() && !phone.isEmpty() && !numsort.isEmpty() && !brinde.isEmpty()) {
                MethodsUser object = new MethodsUser();
                object.update(id, name, lastName, email, phone, numsort, brinde, adminId);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + e.getMessage());
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtUpdateNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUpdateNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUpdateNameActionPerformed

    private void txtUpdateLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUpdateLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUpdateLastNameActionPerformed

    private void txtUpdatePhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUpdatePhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUpdatePhoneActionPerformed

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
            java.util.logging.Logger.getLogger(Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Update().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultUpdate;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdateMenu;
    private javax.swing.JLabel fondoUpdate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblConsultUpdate;
    private javax.swing.JTextField txtUpdateEmail;
    private javax.swing.JTextField txtUpdateId;
    private javax.swing.JTextField txtUpdateLastName;
    private javax.swing.JTextField txtUpdateName;
    private javax.swing.JTextField txtUpdatePhone;
    // End of variables declaration//GEN-END:variables
        private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/icone.png")));
    }
}
