/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import models.ThuChi;

import java.sql.SQLException;
import java.util.List;

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
     * @author asdasda
     */
    public long tongPhiVeSinh() throws SQLException {
        return qs.querySingle("SELECT SUM(tienDaThu) FROM `khoan_thu` WHERE maPhi=1", (rs) -> rs.getLong(1));
    }


}
