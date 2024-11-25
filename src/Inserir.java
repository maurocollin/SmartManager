import database.MethodsUser;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author mauro
 */
public class Inserir extends javax.swing.JFrame {

    private final int adminId;
    private final String adminName;

    /**
     * Creates new form insert
     *
     * @param adminId
     * @param adminName
     */
    public Inserir(int adminId, String adminName) {
        initComponents();
        setIcon();
        
        this.adminId = adminId;
        this.adminName = adminName;
    }

    private Inserir() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnInsertMenu = new javax.swing.JButton();
        txtInsertPhone = new javax.swing.JTextField();
        txtInsertEmail = new javax.swing.JTextField();
        txtInsertName = new javax.swing.JTextField();
        txtInsertLastName = new javax.swing.JTextField();
        btnInsert = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SmartManager");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnInsertMenu.setBackground(new java.awt.Color(204, 204, 204));
        btnInsertMenu.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnInsertMenu.setBorder(null);
        btnInsertMenu.setContentAreaFilled(false);
        btnInsertMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInsertMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertMenuActionPerformed(evt);
            }
        });
        getContentPane().add(btnInsertMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 50, 30));

        txtInsertPhone.setBackground(new java.awt.Color(51, 51, 51));
        txtInsertPhone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtInsertPhone.setForeground(new java.awt.Color(255, 255, 255));
        txtInsertPhone.setBorder(null);
        getContentPane().add(txtInsertPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, 290, 41));

        txtInsertEmail.setBackground(new java.awt.Color(51, 51, 51));
        txtInsertEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtInsertEmail.setForeground(new java.awt.Color(255, 255, 255));
        txtInsertEmail.setBorder(null);
        getContentPane().add(txtInsertEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, 310, 41));

        txtInsertName.setBackground(new java.awt.Color(51, 51, 51));
        txtInsertName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtInsertName.setForeground(new java.awt.Color(255, 255, 255));
        txtInsertName.setBorder(null);
        txtInsertName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInsertNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtInsertName, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 310, 41));

        txtInsertLastName.setBackground(new java.awt.Color(51, 51, 51));
        txtInsertLastName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtInsertLastName.setForeground(new java.awt.Color(255, 255, 255));
        txtInsertLastName.setBorder(null);
        txtInsertLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInsertLastNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtInsertLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 260, 41));

        btnInsert.setBackground(new java.awt.Color(204, 204, 204));
        btnInsert.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnInsert.setBorder(null);
        btnInsert.setContentAreaFilled(false);
        btnInsert.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });
        getContentPane().add(btnInsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 520, 140, 40));

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ADD_CLIENTE.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertMenuActionPerformed
        MainMenu newFrame = new MainMenu(adminId, adminName);
        newFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnInsertMenuActionPerformed

    private void txtInsertLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInsertLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInsertLastNameActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        try {
            MethodsUser object = new MethodsUser();
            String name = txtInsertName.getText();
            String last_name = txtInsertLastName.getText();
            String email = txtInsertEmail.getText();
            String phone = txtInsertPhone.getText();
            if (object.addContact(name, last_name, email, phone, adminId)) {
                JOptionPane.showMessageDialog(null, "O usuário foi adicionado com sucesso");
            }

        } catch (HeadlessException e) {

        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void txtInsertNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInsertNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInsertNameActionPerformed

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
            java.util.logging.Logger.getLogger(Inserir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inserir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inserir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inserir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Inserir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnInsertMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtInsertEmail;
    private javax.swing.JTextField txtInsertLastName;
    private javax.swing.JTextField txtInsertName;
    private javax.swing.JTextField txtInsertPhone;
    // End of variables declaration//GEN-END:variables
	private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/icone.png")));
    }
}
