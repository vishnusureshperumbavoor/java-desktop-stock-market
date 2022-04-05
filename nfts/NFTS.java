package nfts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class NFTS extends javax.swing.JFrame {
    public NFTS() {
        initComponents();
        fetch();
        clear();
    }
    
    private void clear(){
        txtnftid.setText("");
        txtname.setText("");
        txtplatform.setText("");
        txtbought.setText("");
        txtbidding.setText("");
    }
    
    private void fetch(){
        try{
             Class.forName("com.mysql.jdbc.Driver");
             Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_nft","root","mysql");
    
             String sql = "select * from trending";
             System.out.println(sql);
            
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql);
             System.out.println(rs);
             DefaultTableModel dl = (DefaultTableModel)tblnft.getModel();
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
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnadd = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        txtname = new javax.swing.JTextField();
        txtplatform = new javax.swing.JTextField();
        txtbought = new javax.swing.JTextField();
        txtbidding = new javax.swing.JTextField();
        btndelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblnft = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtnftid = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(43, 255, 0));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 1, 1));
        jLabel1.setText("TRENDING NFTs");

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel7.setText("<<Back");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(486, 486, 486)
                .addComponent(jLabel1)
                .addContainerGap(509, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 0, 9));

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(1, 1, 1));
        jLabel3.setText("NAME");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(1, 1, 1));
        jLabel4.setText("PLATFORM");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(1, 1, 1));
        jLabel5.setText("BOUGHT PRICE ");

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(1, 1, 1));
        jLabel6.setText("BIDDING PRICE");

        btnadd.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btnadd.setForeground(new java.awt.Color(1, 1, 1));
        btnadd.setText("ADD");
        btnadd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnaddMouseClicked(evt);
            }
        });
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        btnupdate.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btnupdate.setForeground(new java.awt.Color(1, 1, 1));
        btnupdate.setText("UPDATE");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        txtplatform.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtplatformActionPerformed(evt);
            }
        });

        txtbought.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtboughtActionPerformed(evt);
            }
        });

        btndelete.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btndelete.setForeground(new java.awt.Color(1, 1, 1));
        btndelete.setText("DELETE");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        tblnft.setModel(new javax.swing.table.DefaultTableModel(
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
        tblnft.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblnftMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblnft);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(1, 1, 1));
        jLabel2.setText("NFT ID");

        txtnftid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnftidActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtname, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                                    .addComponent(txtnftid)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtbought, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtplatform, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtbidding, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(btnadd)
                        .addGap(88, 88, 88)
                        .addComponent(btnupdate)
                        .addGap(91, 91, 91)
                        .addComponent(btndelete)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtnftid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtplatform, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtbought, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtbidding, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnadd)
                            .addComponent(btnupdate)
                            .addComponent(btndelete)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(224, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtplatformActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtplatformActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtplatformActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dl = (DefaultTableModel)tblnft.getModel();
        int index = tblnft.getSelectedRow();
        int id = Integer.parseInt(dl.getValueAt(index,0).toString());
        
        String nftid = txtnftid.getText();
        String name = txtname.getText();
        System.out.println(name);
        String platform = txtplatform.getText();
        System.out.println(platform);
        String bought = txtbought.getText();
        System.out.println(bought);
        String bidding = txtbidding.getText();
        System.out.println(bidding);
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_nft","root","mysql");
            String sql = "update trending set nftid='"+nftid+"',name='"+name+"',platform = '"+platform+"', bought = '"+bought+"',bidding = '"+bidding+"' where nftid='"+id+"'";
            System.out.println(sql);
            Statement stmt = (Statement) con.createStatement();
               int rs = stmt.executeUpdate(sql);
               System.out.println(rs);

               if(rs==1){
                   JOptionPane.showMessageDialog(this,"Successfully updated");
                   fetch();
               }
            
        }
        catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        // TODO add your handling code here:
           String nftid = txtnftid.getText();
           System.out.println(nftid);
           String name = txtname.getText();
           System.out.println(name);
           String platform = txtplatform.getText();
           System.out.println(platform);
           String bought = txtbought.getText();
           System.out.println(bought);
           String bidding = txtbidding.getText();
           System.out.println(bidding);
           
           try{
               Class.forName("com.mysql.jdbc.Driver");
               Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_nft","root","mysql");
               String sql = "insert into trending values ('"+nftid+"','"+name+"','"+platform+"','"+bought+"','"+bidding+"')";
               System.out.println(sql);
               Statement stmt = (Statement) con.createStatement();
               int rs;
               rs = stmt.executeUpdate(sql);
               
               System.out.println(sql);
               
               if(rs==1){
                   JOptionPane.showMessageDialog(null, "adding to nfts successfull");
                   this.dispose();
                   NFTS l = new NFTS();
                   l.setVisible(true);
               }
           }
           catch(Exception e){
               System.out.println("error" + e);
           }
    }//GEN-LAST:event_btnaddActionPerformed

    private void tblnftMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblnftMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblnftMouseClicked

    private void txtboughtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtboughtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtboughtActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
//        delete eneter here
DefaultTableModel dl = (DefaultTableModel)tblnft.getModel();
        int index = tblnft.getSelectedRow();
        int id = Integer.parseInt(dl.getValueAt(index,0).toString());
        int dialogResult = JOptionPane.showConfirmDialog(null,"do u want to delete","warning",JOptionPane.YES_NO_OPTION);
        if(dialogResult==JOptionPane.YES_OPTION){
            try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_nft","root","mysql");
            String sql = "delete from trending where nftid='"+id+"'";
            System.out.println(sql);
            Statement stmt = (Statement) con.createStatement();
               int rs = stmt.executeUpdate(sql);
               System.out.println(rs);

               if(rs==1){
                   JOptionPane.showMessageDialog(this,"Successfully deleted");
                   fetch();
                   clear();
               }
            
        }
        catch(Exception e){
            System.out.println(e);
        }
        }
        
            
    }//GEN-LAST:event_btndeleteActionPerformed

    private void txtnftidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnftidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnftidActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        Dashboard l = new Dashboard();
        l.setVisible(true);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void btnaddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnaddMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnaddMouseClicked

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
            java.util.logging.Logger.getLogger(NFTS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NFTS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NFTS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NFTS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NFTS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblnft;
    private javax.swing.JTextField txtbidding;
    private javax.swing.JTextField txtbought;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtnftid;
    private javax.swing.JTextField txtplatform;
    // End of variables declaration//GEN-END:variables
}
