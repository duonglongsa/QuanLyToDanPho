/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.ResultSet;
import models.ThuChiModel;
import models.KhoanThuModel;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import models.DuNoModel;
import models.DuNoVaHoKhauModel;
import models.HoKhauModel;
import models.KhoanThuVaHoKhauModel;

/**
 * @author Hehe
 */
public class ThuChiService {

    private final QueryService qs = new QueryService();

    public void themLoaiPhi(int maThu, String tenPhi, int batBuoc) throws SQLException {
        String sql = String.format("INSERT INTO thu_chi(maThuChi, tenLoaiPhi, batBuoc) VALUES ('" + maThu + "', '" + tenPhi + "', '" + batBuoc + "')");
        qs.queryNoResult(sql);
    }

    public List<ThuChiModel> tatCaLoaiPhi() throws SQLException {
        return qs.queryMultiple("SELECT * FROM `thu_chi`", (rs) -> {
            try {
                return new ThuChiModel(rs.getInt(1), rs.getString(2), rs.getBoolean(3));
            } catch (SQLException ex) {
                return new ThuChiModel();
            }
        });
    }

    /**
     * @return tong phi ve sinh
     * @throws SQLException
     * @author hehe
     */
    public List<DuNoVaHoKhauModel> timHoKhauDangNo() throws SQLException {
        return qs.queryMultiple("SELECT * FROM `du_no`\n"
                + "JOIN `ho_khau` ON `du_no`.`idHoKhau`=`ho_khau`.`ID`\n"
                + "JOIN `nhan_khau` ON `nhan_khau`.`ID`=`ho_khau`.`idChuHo`", (rs) -> {
                    DuNoModel no = new DuNoModel(rs.getInt(3), rs.getInt(1), rs.getInt(2), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7));
                    HoKhauModel hoKhau = new HoKhauModel(rs.getInt(3), rs.getString(9), rs.getInt(10), rs.getString(12));
                    return new DuNoVaHoKhauModel(hoKhau, no, rs.getString(19));
                });
    }

    public List<KhoanThuVaHoKhauModel> timKhoanThuTheoHoKhau(int loaiPhiId) throws SQLException {
        return qs.queryMultiple("SELECT * FROM `khoan_thu`\n"
                + "JOIN `ho_khau` ON `khoan_thu`.`idHoKhau`=`ho_khau`.`ID`\n"
                + "JOIN `nhan_khau` ON `nhan_khau`.`ID`=`ho_khau`.`idChuHo`\n"
                + "\n"
                + "WHERE `maPhi` = " + Integer.toString(loaiPhiId), (ResultSet rs) -> {
            KhoanThuModel thu = new KhoanThuModel(rs.getInt(3), rs.getInt(1), rs.getInt(2), rs.getInt(4), rs.getString(5));
            HoKhauModel hoKhau = new HoKhauModel(rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getString(10));
            return new KhoanThuVaHoKhauModel(thu, hoKhau, rs.getString(17));
        });
    }

    public void xoaNo(int noId) throws SQLException {
        qs.queryNoResult("DELETE FROM `du_no` WHERE `idHoKhau` = " + Integer.toString(noId));
    }

    public void xoaPhi(int phiId) throws SQLException {
        qs.queryNoResult("DELETE FROM `thu_chi` WHERE `maThuChi` = " + Integer.toString(phiId));
    }

    public void dongPhi(int maPhi, int idHoKhau, int tienDaThu, LocalDate ngayThu) throws SQLException {
        String sql = String.format("INSERT INTO `khoan_thu`(`maPhi`, `idHoKhau`, `tienDaThu`, `ngayThu`) VALUES ('" + maPhi + "', '" + idHoKhau + "', '" + tienDaThu + "', '" + ngayThu.toString() + "')");
        qs.queryNoResult(sql);
    }
}
