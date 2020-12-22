/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import models.ThuChi;
import models.KhoanThu;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import models.DuNo;
import models.DuNoVaHoKhau;
import models.HoKhauModel;
import models.KhoanThuVaHoKhau;

/**
 * @author Hehe
 */
public class ThuChiService {

    private final QueryService qs = new QueryService();
    
    public void themLoaiPhi(int maThu, String tenPhi, boolean batBuoc) throws SQLException {
        String sql = String.format("INSERT INTO `thu_chi`(`maThuChi`, `tenLoaiPhi`, `batBuoc`) VALUES (%d,%s,%s)", maThu, tenPhi, batBuoc);
        qs.queryNoResult(sql);
    }
    
    public List<ThuChi> tatCaLoaiPhi() throws SQLException {
        return qs.queryMultiple("SELECT * FROM `thu_chi`", (rs) -> {
            try {
                return new ThuChi(rs.getInt(1), rs.getString(2), rs.getBoolean(3));
            } catch (SQLException ex) {
                return new ThuChi();
            }
        });
    }

    /**
     * @return tong phi ve sinh
     * @throws SQLException
     * @author hehe
     */
    public long tongPhiVeSinh() throws SQLException {
        return qs.querySingle("SELECT SUM(tienDaThu) FROM `khoan_thu` WHERE maPhi=1", (rs) -> rs.getLong(1));
    }
    
    public List<DuNoVaHoKhau> timHoKhauDangNo(int loaiPhiId) throws SQLException {
        return qs.queryMultiple("SELECT * FROM `du_no` JOIN `ho_khau` ON `du_no`.`idHoKhau`=`ho_khau`.`ID` WHERE `maPhi` = " + Integer.toString(loaiPhiId), (rs) -> {
            DuNo no = new DuNo(rs.getInt(3), rs.getInt(1), rs.getInt(2), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7));
            HoKhauModel hoKhau = new HoKhauModel(rs.getInt(3), rs.getString(9), rs.getInt(10), rs.getString(12));
            return new DuNoVaHoKhau(hoKhau, no);
        });
    }    
    
    public List<KhoanThuVaHoKhau> timKhoanThuTheoHoKhau(int loaiPhiId) throws SQLException {
        return qs.queryMultiple("SELECT * FROM `khoan_thu` JOIN `ho_khau` ON `khoan_thu`.`idHoKhau`=`ho_khau`.`ID` WHERE `maPhi` = " + Integer.toString(loaiPhiId), (rs) -> {
            KhoanThu thu = new KhoanThu(rs.getInt(3), rs.getInt(1), rs.getInt(2), rs.getInt(4), rs.getString(5));
            HoKhauModel hoKhau = new HoKhauModel(rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getString(10));
            return new KhoanThuVaHoKhau(thu, hoKhau);
        });
    }
    
    public void xoaNo(int noId) throws SQLException {
        qs.queryNoResult("DELETE FROM `du_no` WHERE `idHoKhau` = " + Integer.toString(noId));
    }
    
    public void xoaPhi(int phiId) throws SQLException {
        qs.queryNoResult("DELETE FROM `thu_chi` WHERE `maThuChi` = " + Integer.toString(phiId));
    }
    
    public void dongPhi(int maPhi,int idHoKhau, int tienDaThu,String ngayThu) throws SQLException{
        String sql = String.format("INSERT INTO `khoan_thu`(`maPhi`, `idHoKhau`, `tienDaThu`, `ngayThu`) VALUES (%d,%d,%d,%s)", maPhi,idHoKhau,tienDaThu,ngayThu);
        qs.queryNoResult(sql);
    }
}
