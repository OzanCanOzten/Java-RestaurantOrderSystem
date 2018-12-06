/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Siparis;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Garson extends javax.swing.JFrame {

    DB db = new DB();
    Login lg = new Login();
    public static String product_id ="";
    public static String order_id ="";
    public static String person_id ="";
    public static String  product_name = "";
    public static String  table_no = "";
    public static String order_count = "";
    public static String price = "";
    public static String productPrice = "";
    public static  String delivery_status = "";
    public static int row = 0;
    public static int sonuc = 0;

    ArrayList<String> kls = new ArrayList<>();
    String kaid = "-1";
    
    public Garson() {
        initComponents();
        String fullname = ( Login.name + " "+ Login.surname);   
        lblNameSurname.setText(fullname);
        categoryResult();
        tableResult(); 
    }
        

    public void totalPrice() {
        product_name = String.valueOf(jComboBox1.getSelectedItem());
        String query = "select product_id ,price from product where `product_name` = '"+ product_name +"'";
        
        lblToplamFiyat.setText(String.valueOf(sonuc));
        try {
                ResultSet rs = db.baglan().executeQuery(query);
                if (rs.next()) {
                   product_id = rs.getString("product_id");
                   price = rs.getString("price");
                   sonuc = (Integer.parseInt(order_count.trim()) * Integer.parseInt(price.trim()));   
                   lblToplamFiyat.setText(String.valueOf(sonuc));
                }
                else{               
                 JOptionPane.showMessageDialog(rootPane,"Toplam Fiyat Hesaplanamadı!" );
                    jTextField3.setText("");
                    jTextField3.requestFocus();
                }
            } catch (Exception e) {
            }
        
    }
    
    public void tableResult() {
        String query = "SELECT * FROM orders INNER JOIN product ON orders.product_id = product.product_id Order By order_id asc";
        try {
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("Sipariş ID");
            dtm.addColumn("Ürün Adı");
            dtm.addColumn("Masa No");
            dtm.addColumn("Sipariş Sayısı");
            dtm.addColumn("Toplam Tutar");
            dtm.addColumn("Teslimat Durumu");
            ResultSet rs = db.baglan().executeQuery(query);
            
            while(rs.next()) {
                delivery_status = rs.getString("delivery_status");
                if (delivery_status.equals("F")) {
                    delivery_status = "Tamamlandı";
                }else if(delivery_status.equals("W")){                
                    delivery_status = "Hazırlanıyor";
                    dtm.addRow(new String[]{ rs.getString("order_id"), rs.getString("product_name"), rs.getString("table_no"), rs.getString("order_count") , rs.getString("order_price"), delivery_status});
                
                }
                
            }
            tblOrder.setModel(dtm);
        } catch (Exception e) {
            System.err.println("table rest error : " + e);
        }
    }

    public void categoryResult() {
        DefaultComboBoxModel<String> dcm = new DefaultComboBoxModel<>();
        kls.clear();
        try {
            String query = "select * from product";
            ResultSet rs = db.baglan().executeQuery(query);
            while(rs.next()) {
                dcm.addElement(rs.getString("product_name"));
                kls.add(rs.getString("product_id"));
                productPrice = rs.getString("price");
            }
            jComboBox1.setModel(dcm);
        } catch (Exception e) {
            System.err.println("product result error : " + e);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNameSurname = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblOrder = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblProductPrice = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblToplamFiyat = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNameSurname.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/exit.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tblOrder.setModel(new javax.swing.table.DefaultTableModel(
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
        tblOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrderMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblOrder);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Garson Liste Ekranı");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("Sipariş Listesi");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Sipariş İşlemleri"));

        jLabel7.setText("Ürün Adı :");

        jLabel12.setText("TL");

        lblProductPrice.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel11.setText("TL");

        lblToplamFiyat.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jButton5.setText("Hesapla");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1İtemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel8.setText("Masa No:");

        jLabel9.setText("Sipariş Sayısı :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(lblProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(42, 42, 42)
                        .addComponent(lblToplamFiyat, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11))
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 238, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblProductPrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblToplamFiyat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Sipariş Güncelle");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/order-edit.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/order-add.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Sipariş Ekle");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Sipariş İptal");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/order-cancel.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/refresh.png"))); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Tabloyu Güncelle");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton9))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblNameSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNameSurname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(338, 338, 338))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-978)/2, (screenSize.height-657)/2, 978, 657);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int answer = JOptionPane.showConfirmDialog(rootPane, "Çıkış Yapmak İstediğinizden Emin Misiniz?", "Uyarı Başlığı", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (answer == 0) {
            Login lg = new Login();
            lg.setVisible(true);
            dispose();

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrderMouseClicked
        row = tblOrder.getSelectedRow();
        order_id  = " " + tblOrder.getValueAt(row, 0);
        product_name = " " + tblOrder.getValueAt(row, 1);
        table_no = " " + tblOrder.getValueAt(row, 2);
        order_count = " " +  tblOrder.getValueAt(row, 3);
        price = " " +  tblOrder.getValueAt(row, 4);
        delivery_status = " " +  tblOrder.getValueAt(row, 5);
        
        lblToplamFiyat.setText(String.valueOf(price));
        jTextField2.setText(table_no);
        jTextField3.setText(order_count);
        
    }//GEN-LAST:event_tblOrderMouseClicked

    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      
        ImageIcon icon = new ImageIcon(this.getClass().getResource("/media/save.png"));
        
        
        
        int answer = JOptionPane.showConfirmDialog(rootPane, "Siparişi güncellemek istediğinizden emin misiniz?", "Uyarı Başlığı", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE , icon);
        if (answer == 0) {
            
            table_no = jTextField2.getText();
            order_count = jTextField3.getText();
            product_name = String.valueOf(jComboBox1.getSelectedItem());
            String querySelect = "select product_id ,price from product where `product_name` = '"+ product_name +"'";
        
             try {
                ResultSet rs = db.baglan().executeQuery(querySelect);
                if (rs.next()) {
                   product_id = rs.getString("product_id");
                   price = rs.getString("price");
                   sonuc = (Integer.parseInt(order_count.trim()) * Integer.parseInt(price.trim()));   
                   lblToplamFiyat.setText(String.valueOf(sonuc));
                }
                else{               
                 JOptionPane.showMessageDialog(rootPane,"Product_ID bulunamadı!" );
                }
            } catch (Exception e) {
            }
            
            try { 
                
                String queryUpdate = "UPDATE `orders` SET `product_id` = ' "+ product_id +"', `table_no` = '" + table_no +"', `order_count` = '"+ order_count +"' , `order_price` = '"+ sonuc +"' WHERE `orders`.`order_id` ="+ order_id +";";
                int guncelle = db.baglan().executeUpdate(queryUpdate);
                if (guncelle > 0) {
                    JOptionPane.showMessageDialog(rootPane, "Güncelleme işlemi başarılı");
                    tableResult();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Güncelleme Hatası");
                }
            } catch (Exception e) {
                System.err.println("Güncelleme Hatası : " + e);
            }
             
        } else {
            JOptionPane.showMessageDialog(rootPane, "Sipaiş güncellenmedi.");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        product_name = String.valueOf(jComboBox1.getSelectedItem());
        table_no = jTextField2.getText();
        order_count = jTextField3.getText();
               
        totalPrice();
       
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy/MM/dd HH:mm:ss");
        
        try {
            String query = "INSERT INTO `orders` (`order_id`, `product_id`, `person_id`, `table_no`, `order_count`, `order_price`, `order_time`,`delivery_status`) "
                    + "VALUES (NULL, '"+product_id+"', '"+lg.person_id+"', '"+table_no+"', '"+order_count+"', '"+sonuc+"', '"+ ft.format(dNow) +"', '"+"W"+"');";
            int statu = db.baglan().executeUpdate(query);
            if(statu > 0) {
                if (order_count.equals("0") || table_no.equals("0") || order_count.equals("") || table_no.equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Lütfen Masa No ve Sipariş Sayısı bilgilerini giriniz!");
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Ekleme Başarılı");
                    tableResult();
                }
            }
        } catch (Exception e) {
            System.err.println("insert error : " + e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        order_count = jTextField3.getText();
        price = lblProductPrice.getText();
        sonuc = (Integer.parseInt(order_count.trim()) * Integer.parseInt(price.trim()));   
        lblToplamFiyat.setText(String.valueOf(sonuc));
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        tableResult();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox1İtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1İtemStateChanged
        String urunAdi = ""+ jComboBox1.getSelectedItem();
        String query = "select * from product where `product_name` = '"+ urunAdi +"'";
        try {
           ResultSet rs = db.baglan().executeQuery(query);  
           if (rs.next()) {                
            String totalPrice = rs.getString("price");
            lblProductPrice.setText(totalPrice);   
          }

        } catch (SQLException ex) {
            System.err.println("Ürün Fiyatı Alım Hatası : " + ex);
        
        }
               
    }//GEN-LAST:event_jComboBox1İtemStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
                
        ImageIcon icon = new ImageIcon(this.getClass().getResource("/media/delete.png"));
        if (order_id.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Lütfen silmek istediğiniz siparişi listeden seçiniz!"); // yesno mesajı çıkarılacak.
        }else{
            int answer = JOptionPane.showConfirmDialog(rootPane, "Siparişi silmek istediğinizden emin misiniz?", "Uyarı Başlığı", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE , icon);
            if (answer == 0) {  
            try {
                String query = "DELETE FROM `orders` WHERE `orders`.`order_id` =" + order_id ;  
                int sonuc = db.baglan().executeUpdate(query);
                if (sonuc>0) {
                    tableResult();
                    order_id = "";
                }
            } catch (Exception e) {
                System.err.println("Silme hatası : " + e);
            }
             
            } else {
                JOptionPane.showMessageDialog(rootPane, "Sipaiş silme işlemi iptal edildi.");
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed


    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Garson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Garson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Garson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Garson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Garson().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel lblNameSurname;
    private javax.swing.JLabel lblProductPrice;
    private javax.swing.JLabel lblToplamFiyat;
    private javax.swing.JTable tblOrder;
    // End of variables declaration//GEN-END:variables
}
