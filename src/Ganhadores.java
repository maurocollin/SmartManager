
import database.MethodsUser;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mauro
 */
public class Ganhadores extends javax.swing.JFrame {

    private final String adminName;
    private final int adminId;

    /**
     * Creates new form SelectAll
     *
     * @param adminId
     * @param adminName
     */
    public Ganhadores(int adminId, String adminName) {
        initComponents();
        setIcon();

        this.adminId = adminId;
        this.adminName = adminName;
        MethodsUser object = new MethodsUser();
        List<String> cadena = object.allWinner(adminId);

        DefaultTableModel model = (DefaultTableModel) tblGanhadores.getModel();

        model.setRowCount(0);

        for (String winnerDetailsList : cadena) {
            String[] rowData = winnerDetailsList.split("\n");
            model.addRow(rowData);
        }

        tblGanhadores.setModel(model);
        srlPanel.setViewportView(tblGanhadores);
        tblGanhadores.setRowHeight(40);
    }

    private Ganhadores() {
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

        btnSelectAllMenu = new javax.swing.JButton();
        srlPanel = new javax.swing.JScrollPane();
        tblGanhadores = new javax.swing.JTable();
        fondoSelectAll = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SmartManager");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSelectAllMenu.setBackground(new java.awt.Color(0, 0, 0));
        btnSelectAllMenu.setFont(new java.awt.Font("Century Schoolbook", 3, 12)); // NOI18N
        btnSelectAllMenu.setForeground(new java.awt.Color(255, 255, 255));
        btnSelectAllMenu.setBorder(null);
        btnSelectAllMenu.setContentAreaFilled(false);
        btnSelectAllMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSelectAllMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectAllMenuActionPerformed(evt);
            }
        });
        getContentPane().add(btnSelectAllMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 50, 30));

        srlPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        tblGanhadores.setBackground(new java.awt.Color(51, 51, 51));
        tblGanhadores.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        tblGanhadores.setForeground(new java.awt.Color(255, 255, 255));
        tblGanhadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nome", "Sobrenome", "Telefone", "Email", "Brinde", "N_Sorteado", "SORTEIO DATA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        srlPanel.setViewportView(tblGanhadores);

        getContentPane().add(srlPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 160, 790, 430));

        fondoSelectAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/CONSULT_GANHADORES.jpg"))); // NOI18N
        getContentPane().add(fondoSelectAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        jButton1.setText("jButton1");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 550, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelectAllMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectAllMenuActionPerformed
        MainMenu newFrame = new MainMenu(adminId, adminName);
        newFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSelectAllMenuActionPerformed

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
            java.util.logging.Logger.getLogger(SelectAll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectAll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectAll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectAll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Ganhadores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSelectAllMenu;
    private javax.swing.JLabel fondoSelectAll;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane srlPanel;
    private javax.swing.JTable tblGanhadores;
    // End of variables declaration//GEN-END:variables
    private void setIcon() {
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/icone.png")));
    }
}