/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import models.ThuChi;
import services.ThuChiService;

/**
 *
 * @author Zbook 15 G3
 */
public class ThuChiController {

    private JScrollPane scroll;
    private ThuChiService thuChiService;
    private JPanel panel;

    public ThuChiController(JScrollPane scroll) {
        this.scroll = scroll;

        this.thuChiService = new ThuChiService();
    }

    public void setData() throws SQLException {
        List<ThuChi> thuChiList = this.thuChiService.tatCaLoaiPhi();

        this.panel = new JPanel(new GridLayout(20, 1, 15, 15));
        for (ThuChi item : thuChiList) {
            JPanel suKienPanel = new JPanel(new BorderLayout());

            if (item.isBatBuoc()) {
                suKienPanel.setBackground(new java.awt.Color(255, 204, 0));
            } else {
                suKienPanel.setBackground(new java.awt.Color(255, 10, 0));
            }

            suKienPanel.setPreferredSize(new Dimension(50, 100));
            // ten
            JLabel tenSuKien = new JLabel();
            tenSuKien.setFont(new java.awt.Font("Arial", 1, 20));

            String rangBuoc = item.isBatBuoc() ? "Bắt buộc" : "Tự nguyên";
            String ten = item.getTenLoaiPhi() + " (" + rangBuoc + ")";
            tenSuKien.setText(ten);

            // button
            JButton chiTietButton = new JButton("Chi Tiết");
            JButton xoaButton = new JButton("Xóa");

            //action Xóa
            xoaButton.addActionListener(e -> {

                if (JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa sự kiện này??", "Warning!!", JOptionPane.YES_NO_OPTION) == 0) {
                    try {
                        this.thuChiService.xoaPhi(item.getMaThuChi());
                        JOptionPane.showMessageDialog(null, "Xóa thành công!!");
                        refreshScrollPanel();
                    } catch (SQLException ex) {
                        Logger.getLogger(ThuChiController.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "Something was wrong!!");
                    }
                }

            });

            JPanel panelButton = new JPanel(new GridLayout(1, 2));
            panelButton.add(chiTietButton);
            panelButton.add(xoaButton);

            suKienPanel.add(tenSuKien, BorderLayout.WEST);
            suKienPanel.add(panelButton, BorderLayout.EAST);

            panel.add(suKienPanel);

        }

        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.getVerticalScrollBar().setUnitIncrement(15);
        scroll.getViewport().add(panel);

    }

    public void refreshScrollPanel() throws SQLException {
        this.scroll.remove(this.panel);
        this.scroll.revalidate();
        this.scroll.repaint();

        this.setData();
    }

}
