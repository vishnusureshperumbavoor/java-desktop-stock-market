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
public class Purchases extends javax.swing.JFrame {
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
    public Purchases() {
        initComponents();
        conn = Database.connect();
        clear();
        fetch();
    }
    public void fetch(){
        int sum=0;
        for(int i=0;i<tblpurchases.getRowCount();i++){
            sum += Integer.parseInt(tblpurchases.getValueAt(i,6).toString());
        }
        txttotalamount.setText(String.valueOf(sum));
    }
    public void clear(){
        txtcusid.setText(null);
        txtcusid.requestFocus();
        txtcusval.setText(null);
        customerClear();
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
        
        dtm = (DefaultTableModel)tblpurchases.getModel();
        dtm.setRowCount(0);
        btnpbills.setEnabled(false);
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
        btnlorder.setEnabled(false);
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
    public void purchase(){
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:mm:ss a");
            LocalDateTime now = LocalDateTime.now();
            String date = dtf.format(now);
            String time = dtf2.format(now);
            DefaultTableModel df = (DefaultTableModel)tblpurchases.getModel();
            int balance = Integer.parseInt(txtdemat.getText());
            int price = Integer.parseInt(txtprice.getText());
            int shares = Integer.parseInt(mordershares.getText());
            int total = Integer.parseInt(mordertotal.getText());
            int holdings = Integer.parseInt(txtholdings.getText());
            int invest = Integer.parseInt(txtinvest.getText());
            int avg = Integer.parseInt(txtavg.getText());
            String stockid = txtstockid.getText();
            String cusid = txtcusid.getText();
            df.addRow(new Object[]
            {
                txtstockid.getText(),
                date,
                time,
                txtname.getText(),
                txtprice.getText(),
                mordershares.getText(),
                String.valueOf(total)
            });
            
            int sum=0;
            for(int i=0;i<tblpurchases.getRowCount();i++){
                sum += Integer.parseInt(tblpurchases.getValueAt(i,6).toString());
            }
            txttotalamount.setText(String.valueOf(sum));
            
            pst = conn.prepareStatement("select * from pool where cusid = '"+cusid+"' and stockid = '"+stockid+"'");
            rs = pst.executeQuery();
            if(rs.next()==false){
                pst = conn.prepareStatement("insert into pool values ("+null+",'"+cusid+"','"+stockid+"','"+0+"','"+0+"')");
                pst.executeUpdate();
            }
            
            pst = conn.prepareStatement("update pool set amount = amount + '"+total+"', shares = shares + '"+shares+"' where cusid = '"+cusid+"' and stockid = '"+stockid+"'");
            pst.executeUpdate();
            
            pst = conn.prepareStatement("update customers set demat = demat - '"+total+"' where customerid = '"+cusid+"'");
            pst.executeUpdate();
            
            double inc = total * 0.001;
            pst = conn.prepareStatement("update stocks set supply = supply - '"+shares+"',price = price + '"+inc+"' where stockid = '"+stockid+"'");
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
                price = rs.getInt("price");
                String supply = rs.getString("supply");
                txtprice.setText(String.valueOf(price));
                txtsupply.setText(supply);
            }
            
            pst = conn.prepareStatement("select *,amount/shares from pool where cusid = '"+cusid+"' and stockid = '"+stockid+"'");
            rs = pst.executeQuery();
            if(rs.next()){
                invest = rs.getInt("amount");
                holdings = rs.getInt("shares");
                avg = rs.getInt("amount/shares");
                txtinvest.setText(String.valueOf(invest));
                txtholdings.setText(String.valueOf(holdings));
                txtavg.setText(String.valueOf(avg));
            }
            
            int amtnow = price * holdings ;
            txtamtnow.setText(String.valueOf(amtnow)+"₹");
            
            if(amtnow==0){
                txtreturn.setText(null);
            }else{
                float profit = amtnow * 100 / invest;
                profit = profit - 100;
                txtreturn.setText(String.valueOf(profit)+"%");
            }
            btnpbills.setEnabled(true);
        } catch (SQLException ex) {
            Logger.getLogger(Purchases.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    Purchases(String cusid) {
        try {
        initComponents();
        conn = Database.connect();
        txtcusid.setText(cusid);
        txtcusval.setText(null);
        txtsidval.setText(null);
        customerClear(); 
        txtstockid.requestFocus();
        fetch();
        pst = conn.prepareStatement("select name,demat from customers where customerid = '"+cusid+"'");
        rs = pst.executeQuery();
        while(rs.next()){
                String uname = rs.getString(1);
                String demat = rs.getString(2);
                txtcname.setText(uname.trim());
                txtdemat.setText(demat);
                
            }
//            cbseller.addItem(rs.getString(uname));
        } catch (SQLException ex) {
            Logger.getLogger(Purchases.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
        tblpurchases = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtdemat = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtinvoice = new javax.swing.JTextArea();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        txtprice = new javax.swing.JLabel();
        txtname = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtpurchase = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        mordertotal = new javax.swing.JLabel();
        txtholdings = new javax.swing.JLabel();
        btnpbills = new javax.swing.JButton();
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
        txtcusid = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtcname = new javax.swing.JLabel();
        txtcusval = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel15 = new javax.swing.JLabel();
        txtalloted = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtsupply = new javax.swing.JLabel();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        btnmorder = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        morderprice = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton5 = new javax.swing.JToggleButton();
        jLabel16 = new javax.swing.JLabel();
        lordertotal = new javax.swing.JLabel();
        lorderval = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lordershares = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        lorderprice = new javax.swing.JTextField();
        btnlorder = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        txttotalamount = new javax.swing.JLabel();
        jButton23 = new javax.swing.JButton();
        btnpbills1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("PURCHASES");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Stock ID :");

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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mordersharesKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Buying Shares : ");

        tblpurchases.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stock ID", "Date", "Time", "Stock Name", "Purchase Price", "Quantity", "Total"
            }
        ));
        jScrollPane1.setViewportView(tblpurchases);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Customer Name : ");

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
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtdemat, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(120, 120, 120))))
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

        jButton8.setBackground(new java.awt.Color(0, 0, 0));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Customers");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(0, 0, 0));
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Sales");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
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
        jButton21.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jButton21.setForeground(new java.awt.Color(255, 255, 255));
        jButton21.setText("PENDING PURCHASES");
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

        txtinvoice.setColumns(20);
        txtinvoice.setRows(5);
        jScrollPane2.setViewportView(txtinvoice);

        jButton24.setBackground(new java.awt.Color(0, 0, 0));
        jButton24.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jButton24.setForeground(new java.awt.Color(255, 255, 255));
        jButton24.setText("SALES RECORDS");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jButton25.setBackground(new java.awt.Color(0, 0, 0));
        jButton25.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jButton25.setForeground(new java.awt.Color(255, 255, 255));
        jButton25.setText("PURCHASE RECORDS");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jButton26.setBackground(new java.awt.Color(0, 0, 0));
        jButton26.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jButton26.setForeground(new java.awt.Color(255, 255, 255));
        jButton26.setText("Withdraw");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

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
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
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
        jLabel10.setText("Total Amount : ");

        txtpurchase.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Holding Shares :");

        mordertotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        mordertotal.setForeground(new java.awt.Color(255, 0, 0));
        mordertotal.setText("0");

        txtholdings.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtholdings.setForeground(new java.awt.Color(255, 0, 0));
        txtholdings.setText("0");

        btnpbills.setBackground(new java.awt.Color(0, 0, 0));
        btnpbills.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnpbills.setForeground(new java.awt.Color(255, 255, 255));
        btnpbills.setText("PURCHASE BILL");
        btnpbills.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpbillsActionPerformed(evt);
            }
        });

        txtsidval.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtsidval.setForeground(new java.awt.Color(255, 0, 0));
        txtsidval.setText("jLabel6");

        morderval.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
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
        jLabel12.setText("Average Buy Price :");

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

        txtcusid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcusidKeyReleased(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Customer ID : ");

        txtcname.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtcname.setText("jLabel15");

        txtcusval.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtcusval.setForeground(new java.awt.Color(255, 0, 0));
        txtcusval.setText("jLabel15");

        jToggleButton1.setBackground(new java.awt.Color(0, 153, 0));
        jToggleButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jToggleButton1.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton1.setText("STOCK DETAILS");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Alloted Shares :");

        txtalloted.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtalloted.setForeground(new java.awt.Color(255, 0, 0));
        txtalloted.setText("jLabel16");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Current Supply : ");

        txtsupply.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtsupply.setForeground(new java.awt.Color(255, 0, 0));
        txtsupply.setText("jLabel18");

        jToggleButton2.setBackground(new java.awt.Color(0, 153, 0));
        jToggleButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jToggleButton2.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton2.setText("HOLDINGS");

        jToggleButton4.setBackground(new java.awt.Color(0, 153, 0));
        jToggleButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jToggleButton4.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton4.setText("PURCHASE");

        btnmorder.setBackground(new java.awt.Color(0, 153, 0));
        btnmorder.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnmorder.setText("BUY");
        btnmorder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmorderActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Stock Price : ");

        morderprice.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        morderprice.setForeground(new java.awt.Color(255, 0, 0));
        morderprice.setText("0");

        jToggleButton3.setBackground(new java.awt.Color(0, 153, 0));
        jToggleButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jToggleButton3.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton3.setText("LIMIT ORDER");

        jToggleButton5.setBackground(new java.awt.Color(0, 153, 0));
        jToggleButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jToggleButton5.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton5.setText("MARKET ORDER");
        jToggleButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton5ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Total Amount : ");

        lordertotal.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lordertotal.setForeground(new java.awt.Color(255, 0, 0));
        lordertotal.setText("0");

        lorderval.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lorderval.setForeground(new java.awt.Color(255, 0, 0));
        lorderval.setText("jLabel6");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("Target Price : ");

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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lordersharesKeyTyped(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Buying Shares : ");

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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lorderpriceKeyTyped(evt);
            }
        });

        btnlorder.setBackground(new java.awt.Color(0, 153, 0));
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
        jLabel24.setText("MAXIMUM PRICE BUYER WILLING TO BUY");

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("TOTAL AMOUNT");

        txttotalamount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txttotalamount.setForeground(new java.awt.Color(255, 255, 255));
        txttotalamount.setText("jLabel26");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txttotalamount, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel27)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txttotalamount, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton23.setBackground(new java.awt.Color(0, 0, 0));
        jButton23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton23.setForeground(new java.awt.Color(255, 255, 255));
        jButton23.setText("Pending Purchase Orders");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        btnpbills1.setBackground(new java.awt.Color(0, 0, 0));
        btnpbills1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnpbills1.setForeground(new java.awt.Color(255, 255, 255));
        btnpbills1.setText("PRINT");
        btnpbills1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpbills1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(47, 47, 47)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel14)
                                                        .addGap(2, 2, 2)
                                                        .addComponent(txtcusid, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(41, 41, 41)
                                                        .addComponent(jLabel5)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(txtcname, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(txtcusval, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(446, 446, 446))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(260, 260, 260)
                                                .addComponent(jLabel1)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 1104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtpurchase, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtstockid, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(45, 45, 45))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtsidval, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)))
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtalloted, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtsupply, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jToggleButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 1103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 1104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(morderval, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(2303, 2303, 2303))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel7)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(mordershares, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel21)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(morderprice, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(2024, 2024, 2024)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(141, 141, 141)
                                                        .addComponent(jLabel10)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(mordertotal, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(192, 192, 192)
                                                        .addComponent(jLabel20)
                                                        .addGap(431, 431, 431)
                                                        .addComponent(jLabel24))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(108, 108, 108)
                                                        .addComponent(jToggleButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(126, 126, 126)
                                                        .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(1560, 1560, 1560)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel19)
                                            .addComponent(jLabel23)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtholdings, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6)
                                        .addGap(3, 3, 3)
                                        .addComponent(txtinvest, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtavg, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtamtnow, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtreturn, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnmorder, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnpbills)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnpbills1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnlorder, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 894, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(688, 688, 688)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel18)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lordershares, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel22)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lorderprice, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lorderval, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lordertotal, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(11298, 11298, 11298))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(txtcusid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel14))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtcname, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)))
                        .addComponent(txtcusval))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jToggleButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtprice)
                        .addComponent(jLabel4)
                        .addComponent(txtname)
                        .addComponent(jLabel3)
                        .addComponent(jLabel15)
                        .addComponent(jLabel17)
                        .addComponent(txtsupply, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtalloted, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtstockid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtsidval)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButton2)
                .addGap(12, 12, 12)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(jLabel24))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(mordershares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(14, 14, 14)
                                .addComponent(morderval, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(morderprice)
                                    .addComponent(jLabel21)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lordershares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel22)
                                    .addComponent(lorderprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lorderval, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mordertotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10)
                            .addComponent(lordertotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnpbills)
                            .addComponent(btnlorder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnmorder)
                            .addComponent(btnpbills1))
                        .addGap(8, 8, 8)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1177, 1177, 1177))
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(txtpurchase, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        new Customers().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        String cusid = txtcusid.getText();
        new Sales(cusid).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        String cusid = txtcusid.getText();
        new Deposit(cusid).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void btnpbillsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpbillsActionPerformed
        // TODO add your handling code here:
//        try {
//            // TODO add your handling code here:
//            String cusid = txtcusid.getText(); 
//            pst = conn.prepareStatement("select name from customers where customerid = '"+cusid+"'");
//            rs = pst.executeQuery();
//            String cusname = null;
//            if(rs.next()){
//                cusname = rs.getString(1);
//            }
//            try {
//                new PurchaseBill(cusname,tblpurchases.getModel()).setVisible(true);
//            } catch (PrinterException ex) {
//                Logger.getLogger(Purchases.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Purchases.class.getName()).log(Level.SEVERE, null, ex);
//        }
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
        for(int i=0;i<tblpurchases.getModel().getRowCount();i++){
            String name = (String)tblpurchases.getModel().getValueAt(i,3);
            String price = (String)tblpurchases.getModel().getValueAt(i,4);
            String qty = (String)tblpurchases.getModel().getValueAt(i,5);
            String amt = (String)tblpurchases.getModel().getValueAt(i,6);
            txtinvoice.setText(txtinvoice.getText() + name + "\t" + price + "\t" + qty + "\t" + amt + "\n");
        }
        int sum=0;
        for(int i=0;i<tblpurchases.getModel().getRowCount();i++){
            sum += Integer.parseInt(tblpurchases.getModel().getValueAt(i,6).toString());
        }
        txtinvoice.setText(txtinvoice.getText() + "\n");
        txtinvoice.setText(txtinvoice.getText() + "*******************************\n");
        txtinvoice.setText(txtinvoice.getText() + "         TOTAL AMOUNT : ₹" + sum + "\n");
        txtinvoice.setText(txtinvoice.getText() + "*******************************\n");
    }//GEN-LAST:event_btnpbillsActionPerformed

    private void txtstockidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtstockidKeyReleased
        // TODO add your handling code here:  
        txtsidval.setText(null);
            String id = txtstockid.getText();
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
                int amtnow=0;
                int profit=0;
                if(rs.next()){
                    amount = rs.getInt(1);
                    shares = rs.getInt(2);
                    avg = rs.getInt(3);
                    txtinvest.setText(String.valueOf(amount));
                    txtholdings.setText(String.valueOf(shares));
                    txtavg.setText(String.valueOf(avg));
                    
                   amtnow = price * shares ;
                txtamtnow.setText(String.valueOf(amtnow)+"₹");
                
                if(amtnow!=0){
                    profit = amtnow * 100 / amount;
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
                if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                    mordershares.requestFocus();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Purchases.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
            
    }//GEN-LAST:event_txtstockidKeyReleased

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
        String cusid = txtcusid.getText();
        new Withdraw(cusid).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton21ActionPerformed

    private void mordersharesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mordersharesKeyReleased
            // TODO add your handling code here:
            btnmorder.setEnabled(false);
            lorderclearbymorder();
            if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                    lordershares.requestFocus();
                }
            if("".equals(mordershares.getText())){
                mOrderClear();
            }
            else{
                int price = Integer.parseInt(txtprice.getText());
                int shares = Integer.parseInt(mordershares.getText());
                int buying = price * shares;
                int balance = Integer.parseInt(txtdemat.getText());
                int supply = Integer.parseInt(txtsupply.getText());
                mordertotal.setText(String.valueOf(buying));
                morderprice.setText(String.valueOf(price));
                if(buying>balance){
                    morderval.setText("more than demat account balance");
                }
                else if(shares>supply){
                    morderval.setText("Sellers not available");
                }
                else{
                    morderval.setText(null);
                    btnmorder.setEnabled(true);
                }
                
            }
    }//GEN-LAST:event_mordersharesKeyReleased

    private void mordersharesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mordersharesKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_mordersharesKeyTyped

    private void txtcusidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcusidKeyReleased
        // TODO add your handling code here:
        txtcusval.setText(null);
        try {
            // TODO add your handling code here:
            if("".equals(txtcusid.getText())){
                customerClear();
                fetch();
            }
            else{
                String cusid = txtcusid.getText();
                pst = conn.prepareStatement("select * from customers where customerid = '"+cusid+"'");
                rs = pst.executeQuery();
                if(rs.next()){
                  String name = rs.getString("name");
                  String demat = rs.getString("demat");
                    txtcname.setText(name.trim());
                    txtdemat.setText(demat);
                    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                    txtstockid.requestFocus();
                }
                }else{
                txtcusval.setText("customer not found");
                customerClear();
                }
            }
        } catch (SQLException ex) {        
            Logger.getLogger(Purchases.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtcusidKeyReleased

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void btnmorderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmorderActionPerformed
                // TODO add your handling code here:
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:mm:ss a");
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now);
        String time = dtf2.format(now);
        try {
            int price = Integer.parseInt(txtprice.getText());
            int shares = Integer.parseInt(mordershares.getText());
            String stockid = txtstockid.getText();
            String cusid = txtcusid.getText(); 
            String sql = "insert into purchases values ("+null+",'"+cusid+"','"+stockid+"','"+date+"','"+time+"','"+price+"','"+shares+"')";
            pst = conn.prepareStatement(sql);
            pst.executeUpdate();
            purchase();
            morderclearbypurchasebutton();
        } catch (SQLException ex) {
            Logger.getLogger(Sales.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnmorderActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
        String cusid = txtcusid.getText();
        new Holdings(cusid).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jToggleButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton5ActionPerformed

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
                int price = Integer.parseInt(lorderprice.getText());
                int shares = Integer.parseInt(lordershares.getText());
                int buying = price * shares;
                int balance = Integer.parseInt(txtdemat.getText());
                int supply = Integer.parseInt(txtsupply.getText());
                lordertotal.setText(String.valueOf(buying));
                lorderprice.setText(String.valueOf(price));
                if(buying>balance){
                    lorderval.setText("more than demat account balance");
                }
                else if(shares>supply){
                    lorderval.setText("Sellers not available");
                }
                else{
                    lorderval.setText(null);
                    btnlorder.setEnabled(true);
                }
                
                
            }
    }//GEN-LAST:event_lordersharesKeyReleased

    private void lordersharesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lordersharesKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_lordersharesKeyTyped

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
            if("".equals(lordershares.getText()) || "".equals(lorderprice.getText()) ){
                lorderClear();
            }
            else{
                int price = Integer.parseInt(lorderprice.getText());
                int shares = Integer.parseInt(lordershares.getText());
                int buying = price * shares;
                int balance = Integer.parseInt(txtdemat.getText());
                int supply = Integer.parseInt(txtsupply.getText());
                lordertotal.setText(String.valueOf(buying));
                lorderprice.setText(String.valueOf(price));
                if(buying>balance){
                    lorderval.setText("more than demat account balance");
                }
                else if(shares>supply){
                    lorderval.setText("Sellers not available");
                }
                else{
                    lorderval.setText(null);
                    btnlorder.setEnabled(true);
                } 
            }
    }//GEN-LAST:event_lorderpriceKeyReleased

    private void lorderpriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lorderpriceKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_lorderpriceKeyTyped

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
            String sql = "insert into purchaseorder values ("+null+",'"+cusid+"','"+stockid+"','"+date+"','"+time+"','"+targetprice+"','"+shares+"','pending')";
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
        new PendingPurchaseOrders().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton23ActionPerformed

    private void btnpbills1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpbills1ActionPerformed
        try {
            // TODO add your handling code here:
            txtinvoice.print();
        } catch (PrinterException ex) {
            Logger.getLogger(Purchases.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnpbills1ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        // TODO add your handling code here:
        new PurchaseRecords().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        // TODO add your handling code here:
        String cusid = txtcusid.getText();
        new Holdings(cusid).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton26ActionPerformed

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
            java.util.logging.Logger.getLogger(Purchases.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Purchases.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Purchases.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Purchases.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new Purchases().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnlorder;
    private javax.swing.JButton btnmorder;
    private javax.swing.JButton btnpbills;
    private javax.swing.JButton btnpbills1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
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
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
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
    private javax.swing.JTable tblpurchases;
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
    private javax.swing.JLabel txtprice;
    private javax.swing.JLabel txtpurchase;
    private javax.swing.JLabel txtreturn;
    private javax.swing.JLabel txtsidval;
    private javax.swing.JTextField txtstockid;
    private javax.swing.JLabel txtsupply;
    private javax.swing.JLabel txttotalamount;
    // End of variables declaration//GEN-END:variables
}
