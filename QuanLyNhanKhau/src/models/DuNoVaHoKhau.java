/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Zbook 15 G3
 */
public class DuNoVaHoKhau {
    private HoKhauModel hokhau;
    private DuNo duNo;

    public DuNoVaHoKhau(HoKhauModel hokhau, DuNo duNo) {
        this.hokhau = hokhau;
        this.duNo = duNo;
    }

    public HoKhauModel getHokhau() {
        return hokhau;
    }

    public void setHokhau(HoKhauModel hokhau) {
        this.hokhau = hokhau;
    }

    public DuNo getDuNo() {
        return duNo;
    }

    public void setDuNo(DuNo duNo) {
        this.duNo = duNo;
    }
}
