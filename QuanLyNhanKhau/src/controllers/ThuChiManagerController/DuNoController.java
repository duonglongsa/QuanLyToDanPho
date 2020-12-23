/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.ThuChiManagerController;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.DuNoVaHoKhauModel;
import models.KhoanThuVaHoKhauModel;
import services.ThuChiService;
import utility.ClassTableModel;

/**
 *
 * @author Zbook 15 G3
 */
public class DuNoController {
    private JPanel jpnView;
    private ThuChiService thuChiService;
    private List<DuNoVaHoKhauModel> listDuNo;
    private ClassTableModel classTableModel = null;
    private final String[] COLUMNS = {"Mã hộ khẩu","Họ tên chủ hộ","Mã thu chi", "Tiền nợ", "Ngày dư", "Từ ngày", "Đến ngày"};
    private JFrame parentJFrame;

    public DuNoController(JPanel jpnView) throws SQLException {
        this.jpnView = jpnView;
        classTableModel = new ClassTableModel();
        this.thuChiService = new ThuChiService();
        this.listDuNo = this.thuChiService.timHoKhauDangNo();
    }

    public DuNoController() {
    }
    
    
   
    public void setDataTable() {
        List<DuNoVaHoKhauModel> listItem = new ArrayList<>();
        this.listDuNo.forEach(duNo -> {
            listItem.add(duNo);
        });
        DefaultTableModel model = classTableModel.setTableDuNo(listItem, COLUMNS);
        JTable table = new JTable(model) {
            @Override
            public boolean editCellAt(int row, int column, EventObject e) {
                return false;
            }
            
        };
        
        // thiet ke bang
        
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.getColumnModel().getColumn(0).setMaxWidth(80);
        table.getColumnModel().getColumn(0).setMinWidth(80);
        table.getColumnModel().getColumn(0).setPreferredWidth(80);
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 400));
        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();
    }

    public void setParentJFrame(JFrame parentJFrame) {
        this.parentJFrame = parentJFrame;
    }
    
//    public void refreshData() {
//        this.listNhanKhauBeans = this.nhanKhauService.getListNhanKhau();
//        setDataTable();
//    }
    public JPanel getJpnView() {
        return jpnView;
    }

    public void setJpnView(JPanel jpnView) {
        this.jpnView = jpnView;
    }
    
}
