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
    private String tenChuHo;

    public DuNoVaHoKhauModel(HoKhauModel hokhau, DuNoModel duNo, String tenChuHo) {
        this.hokhau = hokhau;
        this.duNo = duNo;
        this.tenChuHo = tenChuHo;
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
    
    public String getTenChuHo() {
        return this.tenChuHo;
    }
}
