/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Siparis;

import java.sql.ResultSet;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ozano
 */
public class Mutfak extends javax.swing.JFrame {

    DB db = new DB();
    Login lg = new Login();
    Garson garson = new Garson();
    public static String product_id ="";
    public static String order_id ="";
    public static String person_id ="";
    public static String  product_name = "";
    public static String  table_no = "";
    public static String order_count = "";
    public static String price = "";
    public static String productPrice = "";
    public static String prepare_status = "";
    public static  String delivery_status = "";
    public static int row = 0;
    Timer tm = null;
    
    public Mutfak() {
        initComponents();
        tableResult();
        // Garson ekranından girilen siparişler eşzamanlı olarak mutfak ekranına düşebilmesi için timer'a ihtiyaç duyuldu.
        
//         TimerTask task = new TimerTask() {
//            @Override
//            public void run() {
//                // Tablo 5sn'de bir yeniden çağırılır.
//                tableResult();
//            }
//        };
//        
//        tm = new Timer();
//        tm.schedule(task, 0, 10000);
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

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tblOrder = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblNameSurname = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("Sipariş Listesi");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Aşçı Liste Ekranı");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/exit.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblNameSurname.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Sipariş Stasüsünü Değiştir");

        jButton2.setText("Güncelle");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(lblNameSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNameSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-880)/2, (screenSize.height-709)/2, 880, 709);
    }// </editor-fold>//GEN-END:initComponents
    
    private void tblOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrderMouseClicked
        row = tblOrder.getSelectedRow();
        order_id = " " + tblOrder.getValueAt(row, 0);
        product_name = " " + tblOrder.getValueAt(row, 1);
        table_no = " " + tblOrder.getValueAt(row, 2);
        order_count = " " + tblOrder.getValueAt(row, 3);
        price = " " + tblOrder.getValueAt(row, 4);
        delivery_status = " " +  tblOrder.getValueAt(row, 5);

    }//GEN-LAST:event_tblOrderMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int answer = JOptionPane.showConfirmDialog(rootPane, "Çıkış Yapmak İstediğinizden Emin Misiniz?", "Uyarı Başlığı", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (answer == 0) {
            Login lg = new Login();
            lg.setVisible(true);
            dispose();

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       ImageIcon icon = new ImageIcon(this.getClass().getResource("/media/save.png"));

        int answer = JOptionPane.showConfirmDialog(rootPane, "Sipariş Statüsünü Değiştirmek İStediğinizden Emin Misiniz?", "Uyarı Başlığı", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE , icon);
        if (answer == 0) {
        String change = "F";  
            try {                
                int guncelle = db.baglan().executeUpdate("UPDATE `orders` SET `delivery_status` = '"+change+"'  WHERE `orders`.`order_id` ="+ order_id );
                if (guncelle > 0) {
                    JOptionPane.showMessageDialog(rootPane, "Güncelleme işlemi başarılı");
                    tableResult();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Güncelleme Hatası");
                }
            } catch (Exception e) {
                System.err.println("Güncelleme Hatasi : " + e);
            }
             
        } else {
            JOptionPane.showMessageDialog(rootPane, "Sipaiş statüsü güncellenmedi.");
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Mutfak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mutfak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mutfak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mutfak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Mutfak().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblNameSurname;
    private javax.swing.JTable tblOrder;
    // End of variables declaration//GEN-END:variables
}
