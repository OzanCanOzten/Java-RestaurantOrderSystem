/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Siparis;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ozano
 */
public class UpdateProduct extends javax.swing.JFrame {

    DB db = new DB();
//    public String id;
     Admin admin = new Admin();
    public UpdateProduct() {
        initComponents();
        txtAdi.setText(admin.u_name);
        txtCount.setText(admin.u_count);
        txtPrice.setText(admin.u_price);
             
//            try {                
//                String select = " SELECT product_id FROM `product` WHERE `product_name` LIKE `"+admin.u_name+"` AND `product_count` = `"+ admin.u_count +"` AND `price` = `" +admin.u_price +"`";
//                ResultSet rs = db.baglan().executeQuery(select);
//                id = rs.getString("product_id");
//                
//            } catch (SQLException ex) {
//                System.out.println(" ID alma hatası");
//            }
    }

//    public void dataResult(){
//        try {
//            DefaultTableModel dtm = new DefaultTableModel();
//            dtm.addColumn("ID");
//            dtm.addColumn("Adı");
//            dtm.addColumn("Soyadı");
//            dtm.addColumn("Email");
//            dtm.addColumn("Şifre");
//                       
//            String query = "SELECT * FROM `product`";
//            ResultSet rs = db.baglan().executeQuery(query);
//            while(rs.next()){
//                String id = rs.getString("k_id");
//                String adi = rs.getString("k_adi");
//                String soyadi = rs.getString("k_soyadi");
//                String email = rs.getString("k_mail");                
//                String sifre = rs.getString("k_sifre");
////                System.out.println("adı : " + adi);
//                 
//                //addRow satırları belirleyeceğiz.
//                dtm.addRow(new String[] { adi , soyadi , email , sifre});                               
//            }
//            tblKullanici.setModel(dtm);
//
//        } catch (Exception e) {
//        }
//        
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtAdi = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtPrice = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtCount = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Fiyatı");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ürün Sayısı");

        jButton1.setText("Güncelle");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ürün Adı");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtAdi, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(txtCount)
                    .addComponent(txtPrice))
                .addGap(28, 28, 28))
            .addGroup(layout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(199, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtAdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-552)/2, (screenSize.height-345)/2, 552, 345);
    }// </editor-fold>//GEN-END:initComponents

   
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        
        ImageIcon icon = new ImageIcon(this.getClass().getResource("/media/update-edit.png"));

        int answer = JOptionPane.showConfirmDialog(rootPane, "Keydetmek İstediğinizden Emin Misiniz?", "Uyarı Başlığı", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,icon);
        if (answer == 0) {
            String adi = txtAdi.getText();
            String count = txtPrice.getText();
            String price = txtCount.getText();
               
            try {
                
                String query = "UPDATE `product` SET `product_name` = '"+adi+"', `product_count` = '"+count+"', "
                    + "`price` = '"+price+"' WHERE `product`.`product_id` = '"+ admin.u_id +"'";
                
               int guncelle = db.baglan().executeUpdate(query);
                    
                    
                if (guncelle > 0) {
                    JOptionPane.showMessageDialog(rootPane, "Güncelleme işlemi başarılı");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Güncelleme Hatası");
                }
            } catch (Exception e) {
                System.err.println("Ekleme Hatasi : " + e);
            }
                 Admin admin = new Admin();
                 admin.setVisible(true);
                 dispose();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Ürün güncellenmedi.");
        }


    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(UpdateProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new UpdateProduct().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtAdi;
    private javax.swing.JTextField txtCount;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables
}
