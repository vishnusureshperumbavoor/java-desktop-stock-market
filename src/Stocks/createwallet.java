/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Stocks;

import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author LENOVO
 */
public class createwallet extends javax.swing.JFrame {
    PreparedStatement pst;
    ResultSet rs;
    Connection conn;
    

    /**
     * Creates new form walletdeposit
     */
    public createwallet() {
        initComponents();
        conn  = database.connect();
        clear();
    }
    public void clear(){
        txtname.setText(null);
        btnwallet.setEnabled(false);  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnwallet = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtcusid = new javax.swing.JTextField();
        jToggleButton2 = new javax.swing.JToggleButton();
        txtname = new javax.swing.JLabel();
        txtcustomers = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnwallet.setText("Create Wallet");
        btnwallet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnwalletActionPerformed(evt);
            }
        });

        jLabel1.setText("Enter Customer ID");

        jLabel3.setText("Customer Name :");

        txtcusid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtcusidMouseClicked(evt);
            }
        });
        txtcusid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcusidActionPerformed(evt);
            }
        });
        txtcusid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcusidKeyPressed(evt);
            }
        });

        jToggleButton2.setText("CREATE STOCK MARKET WALLET");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        txtname.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtname.setText("jLabel5");

        txtcustomers.setBackground(new java.awt.Color(0, 0, 0));
        txtcustomers.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtcustomers.setForeground(new java.awt.Color(255, 255, 255));
        txtcustomers.setText("Custormers");
        txtcustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcustomersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(btnwallet, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(txtcustomers, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jToggleButton2)
                        .addGap(194, 194, 194))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcusid, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jToggleButton2)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtcusid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(33, 33, 33)
                .addComponent(btnwallet, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(txtcustomers, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnwalletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnwalletActionPerformed
        try {
            // TODO add your handling code here:
            String cusid = txtcusid.getText();
            String cusname = txtname.getText();
            String query = "insert into wallet values ("+null+",'"+cusid+"','"+cusname+"',"+0+")";
            System.out.println(query);
            pst = conn.prepareStatement(query);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"wallet created successfully");
            new walletdeposit(cusid,cusname).setVisible(true);
        this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(createwallet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnwalletActionPerformed

    private void txtcusidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcusidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcusidActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void txtcusidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcusidKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        try {
            // TODO add your handling code here:
            String cusid = txtcusid.getText();
            pst = conn.prepareStatement("select * from wallet where cusid = '"+cusid+"'");
            rs = pst.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(this,"customer already has wallet");
            }
            else{
                pst = conn.prepareStatement("select name from customers where customerid = '"+cusid+"'");
            rs = pst.executeQuery();
            if(rs.next()==true){
                String cusname = rs.getString(1);
                txtname.setText(cusname.trim());
                btnwallet.setEnabled(true);  
            }else{
                JOptionPane.showMessageDialog(this,"customerid not found");
            }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(createwallet.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        
    }//GEN-LAST:event_txtcusidKeyPressed

    private void txtcusidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtcusidMouseClicked
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_txtcusidMouseClicked

    private void txtcustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcustomersActionPerformed
        // TODO add your handling code here:
        new Customers().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_txtcustomersActionPerformed

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
            java.util.logging.Logger.getLogger(createwallet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(createwallet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(createwallet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(createwallet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createwallet().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnwallet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JTextField txtcusid;
    private javax.swing.JButton txtcustomers;
    private javax.swing.JLabel txtname;
    // End of variables declaration//GEN-END:variables
}