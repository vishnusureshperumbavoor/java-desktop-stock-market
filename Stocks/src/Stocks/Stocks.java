package Stocks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Stocks extends javax.swing.JFrame {
    Connection conn;
    PreparedStatement pre;
    ResultSet rs;
    public Stocks() {
        initComponents();
        fetch();
        clear();
        connect();
        Sectors();
    }
    public void connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stock","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(searchStocks.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
            Logger.getLogger(searchStocks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Sectors(){
        try {
            pre = conn.prepareStatement("select sector from sectors");
            rs = pre.executeQuery();
            cbsector.removeAllItems();
            while(rs.next()){
                cbsector.addItem(rs.getString("sector"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(searchStocks.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
    private void clear(){
        txtname.setText(null);
        txtprice.setText(null);
        cbsector.setSelectedIndex(-1);
    }
    
    private void fetch(){
        try{
             Statement stmt = conn.createStatement();
             rs = stmt.executeQuery("select * from stocks");
             DefaultTableModel dl = (DefaultTableModel)tblstocks.getModel();
             dl.setRowCount(0);
             while(rs.next()){
                 Vector v2 = new Vector();
                 v2.add(rs.getString("stockid"));
                 v2.add(rs.getString("name"));
                 v2.add(rs.getString("price"));
                 v2.add(rs.getString("category"));
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
        txtid = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnadd = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        txtname = new javax.swing.JTextField();
        btndelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblstocks = new javax.swing.JTable();
        btndelete1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btndelete2 = new javax.swing.JButton();
        cbsector = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        txtprice = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 0, 51));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Stock Details");

        txtid.setBackground(new java.awt.Color(0, 0, 0));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Stock Name");

        btnadd.setBackground(new java.awt.Color(0, 153, 255));
        btnadd.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btnadd.setForeground(new java.awt.Color(0, 0, 0));
        btnadd.setText("ADD");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        btnupdate.setBackground(new java.awt.Color(0, 153, 255));
        btnupdate.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btnupdate.setForeground(new java.awt.Color(1, 1, 1));
        btnupdate.setText("EDIT");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        btndelete.setBackground(new java.awt.Color(0, 153, 255));
        btndelete.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btndelete.setForeground(new java.awt.Color(1, 1, 1));
        btndelete.setText("DELETE");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        tblstocks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "stockid", "name", "price", "Sector"
            }
        ));
        tblstocks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblstocksMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblstocks);

        btndelete1.setBackground(new java.awt.Color(0, 153, 255));
        btndelete1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btndelete1.setForeground(new java.awt.Color(1, 1, 1));
        btndelete1.setText("HOME");
        btndelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndelete1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 51, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setText("ADD STOCKS");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Sector");

        btndelete2.setBackground(new java.awt.Color(0, 153, 255));
        btndelete2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btndelete2.setForeground(new java.awt.Color(1, 1, 1));
        btndelete2.setText("CLEAR");
        btndelete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndelete2ActionPerformed(evt);
            }
        });

        cbsector.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbsector.setForeground(new java.awt.Color(0, 0, 0));
        cbsector.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "elon", "jeff", "mark" }));
        cbsector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbsectorActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Current Price");

        txtprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpriceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout txtidLayout = new javax.swing.GroupLayout(txtid);
        txtid.setLayout(txtidLayout);
        txtidLayout.setHorizontalGroup(
            txtidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtidLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(txtidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txtidLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btnadd)
                        .addGap(26, 26, 26)
                        .addComponent(btnupdate)
                        .addGap(26, 26, 26)
                        .addComponent(btndelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(btndelete2)
                        .addGap(37, 37, 37))
                    .addGroup(txtidLayout.createSequentialGroup()
                        .addGroup(txtidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(txtidLayout.createSequentialGroup()
                                .addGap(136, 136, 136)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(txtidLayout.createSequentialGroup()
                                .addGroup(txtidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(txtidLayout.createSequentialGroup()
                                        .addGap(61, 61, 61)
                                        .addGroup(txtidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel5)))
                                    .addGroup(txtidLayout.createSequentialGroup()
                                        .addGap(120, 120, 120)
                                        .addComponent(jLabel7)))
                                .addGap(20, 20, 20)
                                .addGroup(txtidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbsector, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(txtidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtname)
                                        .addComponent(txtprice, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE))))
                            .addGroup(txtidLayout.createSequentialGroup()
                                .addGap(189, 189, 189)
                                .addComponent(btndelete1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        txtidLayout.setVerticalGroup(
            txtidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtidLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(txtidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(txtidLayout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addGroup(txtidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(txtidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(txtidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cbsector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(txtidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnadd)
                            .addComponent(btnupdate)
                            .addComponent(btndelete)
                            .addComponent(btndelete2))
                        .addGap(44, 44, 44)
                        .addComponent(btndelete1)))
                .addContainerGap(195, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(545, 545, 545)
                .addComponent(jLabel1)
                .addContainerGap(386, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dl = (DefaultTableModel)tblstocks.getModel();
        int index = tblstocks.getSelectedRow();
        int id = Integer.parseInt(dl.getValueAt(index,0).toString());
            
        String name = txtname.getText();
        String price = txtprice.getText();
        String category = cbsector.getSelectedItem().toString();
        
        try{
               pre = conn.prepareStatement("update stocks set name=?,price=?,category=? where stockid=?");
               pre.setString(1, name);
               pre.setString(2, price);
               pre.setString(3, category);
               pre.setInt(4, id);
               
               int rs = pre.executeUpdate();
               
               if(rs==1){
                   JOptionPane.showMessageDialog(null, "stocks updated successfull");
                   fetch();
                   clear();
                   txtname.requestFocus();
                   btnadd.setEnabled(true);
               }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        // TODO add your handling code here:
           String name = txtname.getText();
           String price = txtprice.getText();
           String category = cbsector.getSelectedItem().toString();
           try{
               Class.forName("com.mysql.jdbc.Driver");
               conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stock","root","");
               
               pre = conn.prepareStatement("insert into stocks (name,price,category) values (?,?,?)");
               pre.setString(1, name);
               pre.setString(2, price);
               pre.setString(3, category);
               
               int rs = pre.executeUpdate();
               
               if(rs==1){
                   JOptionPane.showMessageDialog(null, "stocks added successfull");
                   fetch();
                   clear();
                   txtname.requestFocus();
               }
           }
           catch(Exception e){
               System.out.println("error" + e);
           }
    }//GEN-LAST:event_btnaddActionPerformed

    private void tblstocksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblstocksMouseClicked
        // TODO add your handling code here:
        DefaultTableModel dl=(DefaultTableModel)tblstocks.getModel();
        int index=tblstocks.getSelectedRow();
        txtname.setText(dl.getValueAt(index,1).toString());
        txtprice.setText(dl.getValueAt(index,2).toString());
        cbsector.setSelectedItem(dl.getValueAt(index,3).toString());
        btnadd.setEnabled(false);
    }//GEN-LAST:event_tblstocksMouseClicked

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
//        delete eneter here
        DefaultTableModel dl = (DefaultTableModel)tblstocks.getModel();
        int index = tblstocks.getSelectedRow();
        int id = Integer.parseInt(dl.getValueAt(index,0).toString());
        int dialogResult = JOptionPane.showConfirmDialog(null,"do u want to delete","warning",JOptionPane.YES_NO_OPTION);
        if(dialogResult==JOptionPane.YES_OPTION){
            try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/stock","root","");
            String sql = "delete from stocks where stockid='"+id+"'";
            System.out.println(sql);
            Statement stmt = (Statement) con.createStatement();
               int rs = stmt.executeUpdate(sql);
               System.out.println(rs);

               if(rs==1){
                   JOptionPane.showMessageDialog(this,"Successfully deleted");
                   fetch();
                   clear();
                   txtname.requestFocus();
                   btnadd.setEnabled(true);
               }
            
        }
        catch(Exception e){
            System.out.println(e);
        }
        }
        
            
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btndelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndelete1ActionPerformed
        // TODO add your handling code here:
//        Dashboard l = new Dashboard();
//        l.setVisible(true);
            this.setVisible(false);
    }//GEN-LAST:event_btndelete1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btndelete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndelete2ActionPerformed
        // TODO add your handling code here:
        clear();
        btnadd.setEnabled(true);
        txtname.requestFocus();
    }//GEN-LAST:event_btndelete2ActionPerformed

    private void cbsectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbsectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbsectorActionPerformed

    private void txtpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpriceActionPerformed

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
            java.util.logging.Logger.getLogger(Stocks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Stocks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Stocks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Stocks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Stocks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btndelete1;
    private javax.swing.JButton btndelete2;
    private javax.swing.JButton btnupdate;
    private javax.swing.JComboBox cbsector;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblstocks;
    private javax.swing.JPanel txtid;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtprice;
    // End of variables declaration//GEN-END:variables
}
