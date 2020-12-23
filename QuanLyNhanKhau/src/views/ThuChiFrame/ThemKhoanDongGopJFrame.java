/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.ThuChiFrame;

import controllers.ThuChiController;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import models.ThuChiModel;
import services.ThuChiService;

/**
 *
 * @author Admin
 */
public class ThemKhoanDongGopJFrame extends javax.swing.JFrame {

    private JFrame parentFrame;
    private ThuChiController parentController;
    private ThuChiModel thuChi;
    private ThuChiService thuChiService;

    /**
     * Creates new form ThemKhoanDongGop
     */
    public ThemKhoanDongGopJFrame() {
        initComponents();
    }

    public ThemKhoanDongGopJFrame(JFrame parentFrame, ThuChiController parentController) {
        initComponents();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.parentFrame = parentFrame;
        this.thuChi = new ThuChiModel();
        
        this.parentController = parentController;
        
        
        this.thuChiService = new ThuChiService();
        this.setTitle("Thêm khoản đóng góp");
        parentFrame.setEnabled(false);
       
        btnGroup.add(this.batBuoc);
        btnGroup.add(this.tuNguyen);
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                close();
            }
        });
    }

    public void close() {
        this.parentFrame.setEnabled(true);
        dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        maThu = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tenSuKien = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tuNguyen = new javax.swing.JRadioButton();
        batBuoc = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(221, 213, 188));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("Mã thu:");

        maThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maThuActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Tên Sự kiên:");

        tenSuKien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tenSuKienActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("Trạng thái:");

        tuNguyen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tuNguyen.setText("Tự nguyện");
        tuNguyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tuNguyenActionPerformed(evt);
            }
        });

        batBuoc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        batBuoc.setText("Bắt buộc");
        batBuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batBuocActionPerformed(evt);
            }
        });

        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tenSuKien, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                        .addComponent(maThu))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(batBuoc)
                        .addGap(42, 42, 42)
                        .addComponent(tuNguyen)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(252, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(237, 237, 237))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(maThu, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tenSuKien, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(tuNguyen)
                    .addComponent(batBuoc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        tuNguyen.getAccessibleContext().setAccessibleName("Bắt buộc");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tenSuKienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tenSuKienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tenSuKienActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String maThu = this.maThu.getText();
        String tenSuKien = this.tenSuKien.getText();
        int loaiPhi = this.batBuoc.isSelected() ? 1 : 0;
        
        // TODO
        try {
            this.thuChiService.themLoaiPhi(Integer.parseInt(maThu), tenSuKien, loaiPhi);
            this.parentController.refreshScrollPanel();
            JOptionPane.showMessageDialog(null, "Thêm thành công!!!");
            close();        
        } catch(NumberFormatException nfe) {
            Logger.getLogger(ThemKhoanDongGopJFrame.class.getName()).log(Level.SEVERE, null, nfe);
            JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin!!!");
        } catch (SQLException ex) {
            Logger.getLogger(ThemKhoanDongGopJFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Something wrong!!!");
        } 
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void maThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maThuActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_maThuActionPerformed

    private void batBuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batBuocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_batBuocActionPerformed

    private void tuNguyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tuNguyenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tuNguyenActionPerformed

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
            java.util.logging.Logger.getLogger(ThemKhoanDongGopJFrame.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemKhoanDongGopJFrame.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemKhoanDongGopJFrame.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemKhoanDongGopJFrame.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThemKhoanDongGopJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton batBuoc;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField maThu;
    private javax.swing.JTextField tenSuKien;
    private javax.swing.JRadioButton tuNguyen;
    // End of variables declaration//GEN-END:variables
    private ButtonGroup btnGroup = new ButtonGroup();
}
