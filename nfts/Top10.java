package nfts;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
public class Top10 extends javax.swing.JFrame {
    public Top10() {
        initComponents();
        fetch();
        clear();
    }
    private void clear(){
        txtnftid.setText("");
        txtname.setText("");
        txtplatform2.setText("");
        txtbidding2.setText("");
        txtbought2.setText("");
    }
    private void fetch(){
        try{
             Class.forName("com.mysql.jdbc.Driver");
             java.sql.Connection con = (java.sql.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_nft","root","mysql");
    
             String sql = "select * from top10";
             System.out.println(sql);
            
             java.sql.Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql);
             System.out.println(rs);
             DefaultTableModel dl = (DefaultTableModel)tbltop10.getModel();
             dl.setRowCount(0);
             while(rs.next()){
                 Vector v2 = new Vector();
                 v2.add(rs.getString("nftid"));
                 v2.add(rs.getString("name"));
                 v2.add(rs.getString("platform"));
                 v2.add(rs.getString("bought"));
                 v2.add(rs.getString("bidding"));
                 dl.addRow(v2);
             }             
        }
        catch(Exception e){
                     System.out.println("error" + e);
         }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtbought = new javax.swing.JLabel();
        txtbidding = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        txtplatform2 = new javax.swing.JTextField();
        txtbought2 = new javax.swing.JTextField();
        txtbidding2 = new javax.swing.JTextField();
        btnadd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbltop10 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtnftid = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 128, 0));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel1.setText("Top 10 NFTs by sales price");

        jPanel2.setBackground(new java.awt.Color(0, 84, 255));

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(1, 1, 1));
        jLabel3.setText("Name");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(1, 1, 1));
        jLabel4.setText("Platform");

        txtbought.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        txtbought.setForeground(new java.awt.Color(1, 1, 1));
        txtbought.setText("Bought Price");

        txtbidding.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        txtbidding.setForeground(new java.awt.Color(1, 1, 1));
        txtbidding.setText("Bidding Price");

        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });

        txtplatform2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtplatform2ActionPerformed(evt);
            }
        });

        txtbought2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbought2ActionPerformed(evt);
            }
        });

        txtbidding2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbidding2ActionPerformed(evt);
            }
        });

        btnadd.setBackground(new java.awt.Color(254, 254, 254));
        btnadd.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btnadd.setText("Add");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        tbltop10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "nftid", "name", "platform", "bought", "bidding"
            }
        ));
        jScrollPane1.setViewportView(tbltop10);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(1, 1, 1));
        jLabel2.setText("NFT ID");

        jButton1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButton1.setText("Update");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButton2.setText("Delete");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 741, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4)
                                .addComponent(txtbidding)
                                .addComponent(txtbought, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtplatform2, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(txtname, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(txtbought2, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(txtbidding2, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(txtnftid)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jButton1)
                        .addGap(72, 72, 72)
                        .addComponent(jButton2)
                        .addGap(21, 21, 21)))
                .addContainerGap(199, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtnftid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)))
                                .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtplatform2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtbought2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtbought))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtbidding2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtbidding)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(btnadd))
                .addContainerGap(260, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel5.setText("<<Back");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(342, 342, 342)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1931, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtbought2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbought2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbought2ActionPerformed

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    private void txtbidding2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbidding2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbidding2ActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        // TODO add your handling code here:
           String nftid = txtnftid.getText();
           System.out.println(nftid);
           String name = txtname.getText();
           System.out.println(name);
           String platform = txtplatform2.getText();
           System.out.println(platform);
           String bought = txtbought2.getText();
           System.out.println(bought);
           String bidding = txtbidding2.getText();
           System.out.println(bidding);
           
           try{
               Class.forName("com.mysql.jdbc.Driver");
               Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_nft","root","mysql");
               String sql = "insert into top10 values ('"+nftid+"','"+name+"','"+platform+"','"+bought+"','"+bidding+"')";
               System.out.println(sql);
               Statement stmt = (Statement) con.createStatement();
               int rs;
               rs = stmt.executeUpdate(sql);
               
               System.out.println(sql);
               
               if(rs==1){
                   JOptionPane.showMessageDialog(null, "adding to top 10 successfull");
                   this.dispose();
                   Top10 l = new Top10();
                   l.setVisible(true);
               }
           }
           catch(Exception e){
               System.out.println("error" + e);
           }
    }//GEN-LAST:event_btnaddActionPerformed

    private void txtplatform2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtplatform2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtplatform2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
//        enter update top 10 here
DefaultTableModel dl = (DefaultTableModel)tbltop10.getModel();
        int index = tbltop10.getSelectedRow();
        int id = Integer.parseInt(dl.getValueAt(index,0).toString());
        
        String nftid = txtnftid.getText();
        System.out.println(nftid);
        String name = txtname.getText();
        System.out.println(name);
        String platform = txtplatform2.getText();
        System.out.println(platform);
        String bought = txtbought2.getText();
        System.out.println(bought);
        String bidding = txtbidding2.getText();
        System.out.println(bidding);
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = (java.sql.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_nft","root","mysql");
            String sql = "update top10 set nftid='"+nftid+"',name='"+name+"',platform = '"+platform+"', bought = '"+bought+"',bidding = '"+bidding+"' where nftid='"+id+"'";
            System.out.println(sql);
            java.sql.Statement stmt = (java.sql.Statement) con.createStatement();
               int rs = stmt.executeUpdate(sql);
               System.out.println(rs);

               if(rs==1){
                   JOptionPane.showMessageDialog(this,"top 10 Successfully updated");
                   fetch();
               }
            
        }
        catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        
//        top 10 delete here
DefaultTableModel dl = (DefaultTableModel)tbltop10.getModel();
        int index = tbltop10.getSelectedRow();
        int id = Integer.parseInt(dl.getValueAt(index,0).toString());
        int dialogResult = JOptionPane.showConfirmDialog(null,"do u want to delete","warning",JOptionPane.YES_NO_OPTION);
        if(dialogResult==JOptionPane.YES_OPTION){
            try{
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = (java.sql.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_nft","root","mysql");
            String sql = "delete from top10 where nftid='"+id+"'";
            System.out.println(sql);
            java.sql.Statement stmt = (java.sql.Statement) con.createStatement();
               int rs = stmt.executeUpdate(sql);
               System.out.println(rs);

               if(rs==1){
                   JOptionPane.showMessageDialog(this,"top10 Successfully deleted");
                   fetch();
                   clear();
               }
            
        }
        catch(Exception e){
            System.out.println(e);
        }
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        Dashboard l = new Dashboard();
        l.setVisible(true);
    }//GEN-LAST:event_jLabel5MouseClicked

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
            java.util.logging.Logger.getLogger(Top10.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Top10.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Top10.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Top10.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Top10().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbltop10;
    private javax.swing.JLabel txtbidding;
    private javax.swing.JTextField txtbidding2;
    private javax.swing.JLabel txtbought;
    private javax.swing.JTextField txtbought2;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtnftid;
    private javax.swing.JTextField txtplatform2;
    // End of variables declaration//GEN-END:variables
}
