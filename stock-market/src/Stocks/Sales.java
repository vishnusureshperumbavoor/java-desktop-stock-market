/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Stocks;

import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class Sales extends javax.swing.JFrame {
    PreparedStatement pst;
    PreparedStatement pst2;
    PreparedStatement pst3;
    Connection conn;
    ResultSet rs;
    DefaultTableModel df;
    Statement stmt;
    DefaultTableModel  dtm;
    CallableStatement mycall;

    /**
     * Creates new form Purchase
     */
    public Sales() {
        initComponents();
        conn = Database.connect();
        clear();
        fetch();
    }
    public void fetch(){
        int sum=0;
        for(int i=0;i<tblsales.getRowCount();i++){
            sum += Integer.parseInt(tblsales.getValueAt(i,9).toString());
        }
        txtpnl.setText(String.valueOf(sum));
    }
    public void clear(){
        txtcusid.setText(null);
        txtcusid.requestFocus();
        txtcusval.setText(null);
        customerClear();
    }

    Sales(String cusid) {
        try {
            initComponents();
            conn = Database.connect();
            customerClear();
            txtcusval.setText(null);
            txtsidval.setText(null);
            txtcusid.setText(cusid);
            fetch();
            pst = conn.prepareStatement("select * from customers where customerid = '"+cusid+"'");
            rs = pst.executeQuery();
            if(rs.next()){
                String name = rs.getString("name");
                String demat = rs.getString("demat");
                txtcname.setText(name.trim());
                txtdemat.setText(demat);
                txtstockid.requestFocus();
            }
            // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        } catch (SQLException ex) {
            Logger.getLogger(Sales.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void customerClear(){
        txtcname.setText(null);
        txtdemat.setText(null);
        
        txtstockid.setText(null);
        txtsidval.setText(null);
        txtname.setText(null);
        txtprice.setText(null);
        txtalloted.setText(null);
        txtsupply.setText(null);
        
        txtholdings.setText(null);
        txtinvest.setText(null);
        txtavg.setText(null);
        txtamtnow.setText(null);
        txtreturn.setText(null);
        
        mordershares.setText(null);
        morderval.setText(null);
        morderprice.setText(null);
        mordertotal.setText(null);
        btnmorder.setEnabled(false);
        
        lordershares.setText(null);
        lorderval.setText(null);
        lorderprice.setText(null);
        lordertotal.setText(null);
        btnlorder.setEnabled(false);
        
        dtm = (DefaultTableModel)tblsales.getModel();
        dtm.setRowCount(0);
        btnsbills.setEnabled(false);
    }
    public void stockClear(){
        txtname.setText(null);
        txtprice.setText(null);
        txtalloted.setText(null);
        txtsupply.setText(null);
        
        txtholdings.setText(null);
        txtinvest.setText(null);
        txtavg.setText(null);
        txtamtnow.setText(null);
        txtreturn.setText(null);
        
        mordershares.setText(null);
        morderval.setText(null);
        morderprice.setText(null);
        mordertotal.setText(null);
        btnmorder.setEnabled(false);
        
        lordershares.setText(null);
        lorderval.setText(null);
        lorderprice.setText(null);
        lordertotal.setText(null);
    }
    public void mOrderClear(){
        morderprice.setText(null);
        mordertotal.setText(null);
        btnmorder.setEnabled(false);
    }
    public void lorderClear(){
        lordertotal.setText(null);
        btnlorder.setEnabled(false);
    }
    public void lorderclearbymorder(){
        lordershares.setText(null);
        lorderval.setText(null);
        lorderprice.setText(null);
        lordertotal.setText(null);
        btnlorder.setEnabled(false);
    }
    public void morderclearbylorder(){
        mordershares.setText(null);
        morderval.setText(null);
        morderprice.setText(null);
        mordertotal.setText(null);
        btnmorder.setEnabled(false);
    }
    public void morderclearbypurchasebutton(){
        mordershares.setText(null);
        morderval.setText(null);
        morderprice.setText(null);
        mordertotal.setText(null);
        btnmorder.setEnabled(false);
    }
    public void lorderclearbypurchasebutton(){
        lordershares.setText(null);
        lorderval.setText(null);
        lorderprice.setText(null);
        lordertotal.setText(null);
        btnlorder.setEnabled(false);
    }
    public void DatabaseEnteringUsingTable(){
//                    String tstockid,tdate,ttime,tstockname,tprice,tquantity,ttotal;
//            
//            for(int i=0;i<tblpurchases.getRowCount();i++){
//                tstockid = (String)tblpurchases.getValueAt(i,0);
//                tdate = (String)tblpurchases.getValueAt(i,1);
//                ttime = (String)tblpurchases.getValueAt(i,2);
//                tstockname = (String)tblpurchases.getValueAt(i,3);
//                tprice = (String)tblpurchases.getValueAt(i,4);
//                tquantity = (String)tblpurchases.getValueAt(i,5);
//                ttotal = (String)tblpurchases.getValueAt(i,6);
//                
//                pst.setString(1,cusid);
//                pst.setString(2,tstockid);
//                pst.setString(3,tstockname);
//                pst.setString(4,tdate);
//                pst.setString(5,ttime);
//                pst.setString(6, tprice);
//                pst.setString(7, tquantity);
//                pst.setString(8,ttotal);
//                pst.executeUpdate();
//            } 
    }
      /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtstockid = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        mordershares = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblsales = new javax.swing.JTable();
        btnmorder = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtdemat = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtinvoice = new javax.swing.JTextArea();
        txtprice = new javax.swing.JLabel();
        txtname = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtpurchase = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        mordertotal = new javax.swing.JLabel();
        txtholdings = new javax.swing.JLabel();
        btnsbills = new javax.swing.JButton();
        txtsidval = new javax.swing.JLabel();
        morderval = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtinvest = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtavg = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtreturn = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtamtnow = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtcusid = new javax.swing.JTextField();
        txtcusval = new javax.swing.JLabel();
        txtcname = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jLabel17 = new javax.swing.JLabel();
        txtsupply = new javax.swing.JLabel();
        txtalloted = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        morderprice = new javax.swing.JLabel();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton5 = new javax.swing.JToggleButton();
        jLabel16 = new javax.swing.JLabel();
        lordertotal = new javax.swing.JLabel();
        lorderval = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lorderprice = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        lordershares = new javax.swing.JTextField();
        btnlorder = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        txtpnl = new javax.swing.JLabel();
        jButton23 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("SALES");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Stock ID : ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Stock Name : ");

        txtstockid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtstockidMouseClicked(evt);
            }
        });
        txtstockid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstockidActionPerformed(evt);
            }
        });
        txtstockid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtstockidKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtstockidKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Stock Price : ");

        mordershares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mordersharesActionPerformed(evt);
            }
        });
        mordershares.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mordersharesKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mordersharesKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Selling Shares : ");

        tblsales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stock ID", "Date", "Time", "Stock Name", "Purchase Price", "Sell Price", "Quantity", "Purchase Total", "Sell Total", "PNL"
            }
        ));
        jScrollPane1.setViewportView(tblsales);

        btnmorder.setBackground(new java.awt.Color(255, 0, 0));
        btnmorder.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnmorder.setText("SELL");
        btnmorder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmorderActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Customer ID :");

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("DEMAT ACCOUNT BALANCE");

        txtdemat.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        txtdemat.setForeground(new java.awt.Color(255, 255, 255));
        txtdemat.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addComponent(txtdemat, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtdemat, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setForeground(new java.awt.Color(0, 0, 0));

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Home");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(0, 0, 0));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Stocks");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(0, 0, 0));
        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Purchases");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(0, 0, 0));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Customers");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(0, 0, 0));
        jButton10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Deposit");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton21.setBackground(new java.awt.Color(0, 0, 0));
        jButton21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton21.setForeground(new java.awt.Color(255, 255, 255));
        jButton21.setText("WITHDRAW");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jButton22.setBackground(new java.awt.Color(0, 0, 0));
        jButton22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton22.setForeground(new java.awt.Color(255, 255, 255));
        jButton22.setText("HOLDINGS");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton18.setBackground(new java.awt.Color(0, 0, 0));
        jButton18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton18.setForeground(new java.awt.Color(255, 255, 255));
        jButton18.setText("TOTAL PURCHASES");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setBackground(new java.awt.Color(0, 0, 0));
        jButton19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton19.setForeground(new java.awt.Color(255, 255, 255));
        jButton19.setText("Sales Records");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        txtinvoice.setColumns(20);
        txtinvoice.setRows(5);
        jScrollPane3.setViewportView(txtinvoice);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        txtprice.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtprice.setForeground(new java.awt.Color(255, 0, 0));
        txtprice.setText("0");

        txtname.setBackground(new java.awt.Color(255, 0, 0));
        txtname.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtname.setForeground(new java.awt.Color(255, 51, 51));
        txtname.setText("0");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Total Amount :");

        txtpurchase.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Holding Shares :");

        mordertotal.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        mordertotal.setForeground(new java.awt.Color(255, 0, 0));
        mordertotal.setText("0");

        txtholdings.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtholdings.setForeground(new java.awt.Color(255, 0, 0));
        txtholdings.setText("0");

        btnsbills.setBackground(new java.awt.Color(0, 0, 0));
        btnsbills.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnsbills.setForeground(new java.awt.Color(255, 255, 255));
        btnsbills.setText("SALES BILL");
        btnsbills.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsbillsActionPerformed(evt);
            }
        });

        txtsidval.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtsidval.setForeground(new java.awt.Color(255, 0, 0));
        txtsidval.setText("jLabel6");

        morderval.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        morderval.setForeground(new java.awt.Color(255, 0, 0));
        morderval.setText("jLabel6");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Total amount invested : ");

        txtinvest.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtinvest.setForeground(new java.awt.Color(255, 0, 0));
        txtinvest.setText("jLabel9");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Average Price :");

        txtavg.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtavg.setForeground(new java.awt.Color(255, 0, 0));
        txtavg.setText("jLabel13");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Return :");

        txtreturn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtreturn.setForeground(new java.awt.Color(255, 0, 0));
        txtreturn.setText("jLabel13");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Amount Now : ");

        txtamtnow.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtamtnow.setForeground(new java.awt.Color(255, 0, 0));
        txtamtnow.setText("jLabel14");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Customer : ");

        txtcusid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcusidActionPerformed(evt);
            }
        });
        txtcusid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcusidKeyReleased(evt);
            }
        });

        txtcusval.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtcusval.setForeground(new java.awt.Color(255, 0, 0));
        txtcusval.setText("jLabel15");

        txtcname.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtcname.setForeground(new java.awt.Color(0, 0, 0));
        txtcname.setText("jLabel16");

        jToggleButton1.setBackground(new java.awt.Color(255, 0, 0));
        jToggleButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jToggleButton1.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton1.setText("STOCK DETAILS");

        jToggleButton2.setBackground(new java.awt.Color(255, 0, 0));
        jToggleButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jToggleButton2.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton2.setText("HOLDINGS");

        jToggleButton4.setBackground(new java.awt.Color(255, 0, 0));
        jToggleButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jToggleButton4.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton4.setText("SALES");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Current Supply : ");

        txtsupply.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtsupply.setForeground(new java.awt.Color(255, 0, 0));
        txtsupply.setText("jLabel18");

        txtalloted.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtalloted.setForeground(new java.awt.Color(255, 0, 0));
        txtalloted.setText("jLabel16");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Alloted Shares :");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Stock Price : ");

        morderprice.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        morderprice.setForeground(new java.awt.Color(255, 0, 0));
        morderprice.setText("0");

        jToggleButton3.setBackground(new java.awt.Color(255, 0, 0));
        jToggleButton3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jToggleButton3.setText("LIMIT  ORDER");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        jToggleButton5.setBackground(new java.awt.Color(255, 0, 0));
        jToggleButton5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jToggleButton5.setText("MARKET ORDER");
        jToggleButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton5ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Total Amount :");

        lordertotal.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lordertotal.setForeground(new java.awt.Color(255, 0, 0));
        lordertotal.setText("0");

        lorderval.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lorderval.setForeground(new java.awt.Color(255, 0, 0));
        lorderval.setText("jLabel6");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("Stock Price : ");

        lorderprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lorderpriceActionPerformed(evt);
            }
        });
        lorderprice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lorderpriceKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lorderpriceKeyReleased(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Selling Shares : ");

        lordershares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lordersharesActionPerformed(evt);
            }
        });
        lordershares.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lordersharesKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lordersharesKeyReleased(evt);
            }
        });

        btnlorder.setBackground(new java.awt.Color(255, 0, 0));
        btnlorder.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnlorder.setText("CREATE LIMIT ORDER");
        btnlorder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlorderActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("BUY AT MARKET PRICE");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setText("MINIMUM PRICE SELLER WILLING TO SELL");

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("PNL");

        txtpnl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtpnl.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jLabel19))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(txtpnl, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtpnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton23.setBackground(new java.awt.Color(0, 0, 0));
        jButton23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton23.setForeground(new java.awt.Color(255, 255, 255));
        jButton23.setText("Pending Sales Orders");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButton1.setText("PRINT BILL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(94, 94, 94)
                                                        .addComponent(txtcusid, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jLabel14)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txtcname, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(233, 233, 233)
                                                        .addComponent(jLabel1)))
                                                .addGap(51, 51, 51)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel2)
                                                        .addGap(24, 24, 24)
                                                        .addComponent(txtstockid, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jLabel3))
                                                    .addComponent(txtsidval, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel4)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel15)
                                                .addGap(12, 12, 12)
                                                .addComponent(txtalloted, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(55, 55, 55)
                                                .addComponent(jLabel17)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtsupply, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel5)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addGap(166, 166, 166)
                                                    .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(txtcusval, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(1101, 1101, 1101))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 823, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(txtpurchase, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel11)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txtholdings, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jLabel6)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txtinvest, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jLabel12)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(txtavg, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jLabel13)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txtamtnow, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(49, 49, 49)
                                                        .addComponent(jToggleButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtreturn, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(morderval, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(72, 72, 72)
                                                        .addComponent(jLabel10)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(mordertotal, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel7)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(mordershares, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabel21)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(morderprice, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(179, 179, 179)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lorderval, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(72, 72, 72)
                                                        .addComponent(jLabel16)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(lordertotal, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel18)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(lordershares, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabel22)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(lorderprice, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(173, 173, 173)
                                        .addComponent(jToggleButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addComponent(btnmorder, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnsbills, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton1)
                                        .addGap(156, 156, 156)
                                        .addComponent(btnlorder, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jLabel20)
                        .addGap(431, 431, 431)
                        .addComponent(jLabel24)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(1312, 1312, 1312)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1312, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel14)
                            .addComponent(txtcusid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcname, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtcusval)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jToggleButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtalloted, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(txtprice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15)
                        .addComponent(txtstockid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtsupply, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtsidval, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtinvest, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtavg, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtholdings, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtamtnow, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtreturn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jToggleButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel24))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(mordershares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(morderprice)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(morderval, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(mordertotal, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(lorderprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lordershares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lorderval, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16)
                            .addComponent(lordertotal, javax.swing.GroupLayout.Alignment.LEADING))))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnmorder)
                    .addComponent(btnlorder)
                    .addComponent(btnsbills, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton23)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(txtpurchase, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(318, 318, 318)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(318, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnmorderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmorderActionPerformed
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:mm:ss a");
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now);
        String time = dtf2.format(now);
        
        try {
            String stockid = txtstockid.getText();
            String cusid = txtcusid.getText();   
            int balance = Integer.parseInt(txtdemat.getText());
            int sellavg = Integer.parseInt(txtprice.getText());
            int shares = Integer.parseInt(mordershares.getText());
            int selltotal = Integer.parseInt(mordertotal.getText());
            int holdings = Integer.parseInt(txtholdings.getText());
            int invest = Integer.parseInt(txtinvest.getText());
            int puravg = Integer.parseInt(txtavg.getText());
            int purtotal = puravg*shares;
                    
            String sql = "insert into sales values ("+null+",'"+cusid+"','"+stockid+"','"+date+"','"+time+"','"+puravg+"','"+sellavg+"','"+shares+"')";
            pst = conn.prepareStatement(sql);
            pst.executeUpdate();
        DefaultTableModel df = (DefaultTableModel)tblsales.getModel();
        df.addRow(new Object[]
        {
            txtstockid.getText(),
            date,
            time,
            txtname.getText(),
            txtavg.getText(),
            txtprice.getText(),
            mordershares.getText(),
            purtotal,
            selltotal,
            selltotal-purtotal
        });
        int sum=0;
        for(int i=0;i<tblsales.getRowCount();i++){
            sum += Integer.parseInt(tblsales.getValueAt(i,9).toString());
        }
        txtpnl.setText(String.valueOf(sum));
        pst = conn.prepareStatement("update customers set demat = demat + '"+selltotal+"' where customerid = '"+cusid+"'");
        pst.executeUpdate();
        double dec = selltotal * 0.001;
        pst = conn.prepareStatement("update stocks set supply = supply + '"+shares+"',price = price - '"+dec+"' where stockid = '"+stockid+"'");
        pst.executeUpdate();
        pst = conn.prepareStatement("update pool set amount = amount - '"+purtotal+"', shares = shares - '"+shares+"' where cusid = '"+cusid+"' and stockid = '"+stockid+"'");
        pst.executeUpdate();
        pst = conn.prepareStatement("select * from customers where customerid = '"+cusid+"'");
        rs = pst.executeQuery();
        if(rs.next()){
            balance = rs.getInt("demat");
            txtdemat.setText(String.valueOf(balance));
        }
        pst = conn.prepareStatement("select * from stocks where stockid = '"+stockid+"'");
        rs = pst.executeQuery();
        if(rs.next()){
            sellavg = rs.getInt("price");
            String supply = rs.getString("supply");
            txtprice.setText(String.valueOf(sellavg));
            txtsupply.setText(supply);
        }
        pst = conn.prepareStatement("select *,amount/shares from pool where cusid = '"+cusid+"' and stockid = '"+stockid+"'");
        rs = pst.executeQuery();
        if(rs.next()){
            invest = rs.getInt("amount");
            holdings = rs.getInt("shares");
            puravg = rs.getInt("amount/shares");
            txtinvest.setText(String.valueOf(invest));
            txtholdings.setText(String.valueOf(holdings));
            txtavg.setText(String.valueOf(puravg));
        }
        float amtnow = sellavg * holdings ;
        txtamtnow.setText(String.valueOf(amtnow)+"₹");
         
        if(amtnow==0){
            txtreturn.setText("0%");
        }else{
            float profit = amtnow * 100 / invest;
            profit = profit - 100; 
            txtreturn.setText(String.valueOf(profit)+"%");
        }
        mordershares.setText(null);
        btnsbills.setEnabled(true);
        morderclearbypurchasebutton();
//        JOptionPane.showMessageDialog(this,"sales completed");
        } catch (SQLException ex) {
            Logger.getLogger(Sales.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnmorderActionPerformed

    private void txtstockidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtstockidKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtstockidKeyPressed

    private void txtstockidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtstockidMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtstockidMouseClicked

    private void txtstockidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstockidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstockidActionPerformed

    private void mordersharesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mordersharesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mordersharesActionPerformed

    private void mordersharesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mordersharesKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_mordersharesKeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        new Dashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        new Stocks().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        String cusid = txtcusid.getText();
        new Purchases(cusid).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        new Customers().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        String cusid = txtcusid.getText();
        new Deposit(cusid).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void btnsbillsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsbillsActionPerformed
        // TODO add your handling code here:
            // TODO add your handling code here:
            txtinvoice.setText(null);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:mm:ss a");
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now);
        String time = dtf2.format(now);
        String cusname = txtcname.getText();
        
        txtinvoice.setText(txtinvoice.getText() + "*******************************\n");
        txtinvoice.setText(txtinvoice.getText() + "      Purchase Invoice " + "\n");
        txtinvoice.setText(txtinvoice.getText() + "*******************************\n");
        txtinvoice.setText(txtinvoice.getText() + "\n");
        txtinvoice.setText(txtinvoice.getText() + "Customer : " + cusname + "\n");
        txtinvoice.setText(txtinvoice.getText() + "Date : " + date + "\t" + time + "\n");
        txtinvoice.setText(txtinvoice.getText() + "\n");
        txtinvoice.setText(txtinvoice.getText() + "Stockname " + "\t" + "Price" + "\t" + "Qty" + "\t" + "Total" + "\n");
        for(int i=0;i<tblsales.getModel().getRowCount();i++){
            String name = (String)tblsales.getModel().getValueAt(i,3);
            String price = (String)tblsales.getModel().getValueAt(i,5);
            String qty = (String)tblsales.getModel().getValueAt(i,6);
            String amt = (String)tblsales.getModel().getValueAt(i,8).toString();
            txtinvoice.setText(txtinvoice.getText() + name + "\t" + price + "\t" + qty + "\t" + amt + "\n");
        }
        int sum=0;
        for(int i=0;i<tblsales.getModel().getRowCount();i++){
            sum += Integer.parseInt(tblsales.getModel().getValueAt(i,8).toString());
        }
        txtinvoice.setText(txtinvoice.getText() + "\n");
        txtinvoice.setText(txtinvoice.getText() + "*******************************\n");
        txtinvoice.setText(txtinvoice.getText() + "         TOTAL AMOUNT : ₹" + sum + "\n");
        txtinvoice.setText(txtinvoice.getText() + "*******************************\n");
    }//GEN-LAST:event_btnsbillsActionPerformed

    private void txtstockidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtstockidKeyReleased
        // TODO add your handling code here:
            // TODO add your handling code here:
            txtsidval.setText(null);
            String id = txtstockid.getText();
            if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                    mordershares.requestFocus();
                    }
            if("".equals(id)){
                stockClear();
                
            }else{
            
            try {
            
            String cusid = txtcusid.getText(); 
            pst = conn.prepareStatement("select * from stocks where stockid = '"+id+"'");
            rs = pst.executeQuery();
            if(rs.next() == false){
                txtsidval.setText("stockid not found");
                stockClear();
            }else{
                txtsidval.setText(null);
                String name = rs.getString("name");
                int price = rs.getInt("price");
                String alloted = rs.getString("shares");
                String supply = rs.getString("supply");
                txtname.setText(name.trim());
                txtprice.setText(String.valueOf(price));
                txtalloted.setText(alloted.trim());
                txtsupply.setText(supply.trim());
                
                pst = conn.prepareStatement("select amount,shares,amount/shares from pool where cusid = '"+cusid+"' and stockid = '"+id+"'");
                rs = pst.executeQuery();
                int avg = 0;
                int amount = 0;
                int shares = 0;
                if(rs.next()){
                    amount = rs.getInt(1);
                    shares = rs.getInt(2);
                    avg = rs.getInt(3);
                    txtinvest.setText(String.valueOf(amount));
                    txtholdings.setText(String.valueOf(shares));
                    txtavg.setText(String.valueOf(avg));
                    int amtnow = price * shares ;
                txtamtnow.setText(String.valueOf(amtnow)+"₹");
                int invest = Integer.parseInt(txtinvest.getText());
                
                
        if(amtnow==0 || invest==0){
            txtreturn.setText("0%");
        }else{
            float profit = amtnow * 100 / invest;
            profit = profit - 100; 
            txtreturn.setText(String.valueOf(profit)+"%");
        }
                
                    
                }
                else{
                    txtinvest.setText("0");
                    txtholdings.setText("0");
                    txtavg.setText("0");
                    txtamtnow.setText("0₹");
                    txtreturn.setText("0%");
                }  
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sales.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
       }
    }//GEN-LAST:event_txtstockidKeyReleased

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
        String cusid = txtcusid.getText();
        new Withdraw(cusid).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
        new PurchaseRecords().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
        new SalesRecords().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton19ActionPerformed

    private void mordersharesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mordersharesKeyReleased
            btnmorder.setEnabled(false);
            lorderclearbymorder();
            if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                    lordershares.requestFocus();
                }
            if("".equals(mordershares.getText())){
                mOrderClear();
            }
            else{
                int holdings = Integer.parseInt(txtholdings.getText());
                int price = Integer.parseInt(txtprice.getText());
                int shares = Integer.parseInt(mordershares.getText());
                int buying = price * shares;
                mordertotal.setText(String.valueOf(buying));
                morderprice.setText(String.valueOf(price));
                if(shares>holdings){
                    morderval.setText("more than holding stocks");
                }
                else{
                    morderval.setText(null);
                    btnmorder.setEnabled(true);
                }
            }
    }//GEN-LAST:event_mordersharesKeyReleased

    private void txtcusidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcusidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcusidActionPerformed

    private void txtcusidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcusidKeyReleased
        // TODO add your handling code here:
        txtcusval.setText(null);
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                    txtstockid.requestFocus();
                }
        try {
            // TODO add your handling code here:
            if("".equals(txtcusid.getText())){
                customerClear();
                fetch();
            }
            else{
                txtcusval.setText(null);
                String cusid = txtcusid.getText();
                pst = conn.prepareStatement("select * from customers where customerid = '"+cusid+"'");
                rs = pst.executeQuery();
                if(rs.next()){
                  String name = rs.getString("name");
                  String demat = rs.getString("demat");
                    txtcname.setText(name.trim());
                    txtdemat.setText(demat);
                    
                }else{
                txtcusval.setText("customer not found");
                customerClear();
                }
            }
        } catch (SQLException ex) {        
            Logger.getLogger(Purchases.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtcusidKeyReleased

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
        String cusid = txtcusid.getText();
        new Holdings(cusid).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jToggleButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton5ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void lorderpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lorderpriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lorderpriceActionPerformed

    private void lorderpriceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lorderpriceKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lorderpriceKeyPressed

    private void lorderpriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lorderpriceKeyReleased
        // TODO add your handling code here:
        morderclearbylorder();
            btnlorder.setEnabled(false);
            if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                    lorderprice.requestFocus();
                }
            if("".equals(lordershares.getText()) || "".equals(lorderprice.getText()) ){
                lorderClear();
            }
            else{
                int holdings = Integer.parseInt(txtholdings.getText());
                int price = Integer.parseInt(lorderprice.getText());
                int shares = Integer.parseInt(lordershares.getText());
                int buying = price * shares;
                lordertotal.setText(String.valueOf(buying));
                if(shares>holdings){
                    lorderval.setText("more than holding stocks");
                }
                else{
                    morderval.setText(null);
                    btnlorder.setEnabled(true);
                }
            }
    }//GEN-LAST:event_lorderpriceKeyReleased

    private void lordersharesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lordersharesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lordersharesActionPerformed

    private void lordersharesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lordersharesKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lordersharesKeyPressed

    private void lordersharesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lordersharesKeyReleased
        // TODO add your handling code here:
        
        morderclearbylorder();
            btnlorder.setEnabled(false);
            if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                    lorderprice.requestFocus();
                }
            if("".equals(lordershares.getText()) || "".equals(lorderprice.getText()) ){
                lorderClear();
            }
            else{
                int holdings = Integer.parseInt(txtholdings.getText());
                int price = Integer.parseInt(lorderprice.getText());
                int shares = Integer.parseInt(lordershares.getText());
                int buying = price * shares;
                lordertotal.setText(String.valueOf(buying));
                if(shares>holdings){
                    lorderval.setText("more than holding stocks");
                }
                else{
                    morderval.setText(null);
                    btnlorder.setEnabled(true);
                }
            }
    }//GEN-LAST:event_lordersharesKeyReleased

    private void btnlorderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlorderActionPerformed
        // TODO add your handling code here:
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:mm:ss a");
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now);
        String time = dtf2.format(now);
        try {
            int targetprice = Integer.parseInt(lorderprice.getText());
            int shares = Integer.parseInt(lordershares.getText());
            String stockid = txtstockid.getText();
            String cusid = txtcusid.getText(); 
            int puravg = Integer.parseInt(txtavg.getText());
            String sql = "insert into salesorder values ("+null+",'"+cusid+"','"+stockid+"','"+date+"','"+time+"','"+puravg+"','"+targetprice+"','"+shares+"','pending')";
            System.out.println(sql);
            pst = conn.prepareStatement(sql);
            pst.executeUpdate();
            lorderclearbypurchasebutton();
        } catch (SQLException ex) {
            Logger.getLogger(Sales.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnlorderActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        // TODO add your handling code here:
        new PendingSalesOrders().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            txtinvoice.print();
        } catch (PrinterException ex) {
            Logger.getLogger(Sales.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnlorder;
    private javax.swing.JButton btnmorder;
    private javax.swing.JButton btnsbills;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JTextField lorderprice;
    private javax.swing.JTextField lordershares;
    private javax.swing.JLabel lordertotal;
    private javax.swing.JLabel lorderval;
    private javax.swing.JLabel morderprice;
    private javax.swing.JTextField mordershares;
    private javax.swing.JLabel mordertotal;
    private javax.swing.JLabel morderval;
    private javax.swing.JTable tblsales;
    private javax.swing.JLabel txtalloted;
    private javax.swing.JLabel txtamtnow;
    private javax.swing.JLabel txtavg;
    private javax.swing.JLabel txtcname;
    private javax.swing.JTextField txtcusid;
    private javax.swing.JLabel txtcusval;
    private javax.swing.JLabel txtdemat;
    private javax.swing.JLabel txtholdings;
    private javax.swing.JLabel txtinvest;
    private javax.swing.JTextArea txtinvoice;
    private javax.swing.JLabel txtname;
    private javax.swing.JLabel txtpnl;
    private javax.swing.JLabel txtprice;
    private javax.swing.JLabel txtpurchase;
    private javax.swing.JLabel txtreturn;
    private javax.swing.JLabel txtsidval;
    private javax.swing.JTextField txtstockid;
    private javax.swing.JLabel txtsupply;
    // End of variables declaration//GEN-END:variables
}
