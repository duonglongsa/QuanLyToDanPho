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
public class DuNoVaHoKhauModel {
    private HoKhauModel hokhau;
    private DuNoModel duNo;

    public DuNoVaHoKhauModel(HoKhauModel hokhau, DuNoModel duNo) {
        this.hokhau = hokhau;
        this.duNo = duNo;
    }

    public HoKhauModel getHokhau() {
        return hokhau;
    }

    public void setHokhau(HoKhauModel hokhau) {
        this.hokhau = hokhau;
    }

    public DuNoModel getDuNo() {
        return duNo;
    }

    public void setDuNo(DuNoModel duNo) {
        this.duNo = duNo;
    }
}
