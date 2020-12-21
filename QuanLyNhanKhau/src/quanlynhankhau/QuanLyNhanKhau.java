package quanlynhankhau;

import models.ThuChi;
import services.ThuChiService;
import views.MainFrame;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

/**
 * @author Hai
 */
public class QuanLyNhanKhau {

    public static Calendar calendar = Calendar.getInstance();

    public static void main(String[] args) throws SQLException {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }

        List<ThuChi> l = new ThuChiService().tatCaLoaiPhi();
        for (ThuChi thuChi : l) {
            System.out.print(thuChi);
        }

        MainFrame mainFrame = new MainFrame();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
//        LoginUI loginUI = new LoginUI();
//        loginUI.setVisible(true); 
    }

}
