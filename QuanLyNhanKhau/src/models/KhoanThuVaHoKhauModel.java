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
public class KhoanThuVaHoKhauModel {
    private KhoanThuModel khoanThu;
    private HoKhauModel hoKhau;
    private String tenChuHo;

    public KhoanThuVaHoKhauModel(KhoanThuModel khoanThu, HoKhauModel hoKhau, String tenChuHo) {
        this.khoanThu = khoanThu;
        this.hoKhau = hoKhau;
        this.tenChuHo = tenChuHo;
    }

    public KhoanThuModel getKhoanThu() {
        return khoanThu;
    }

    public void setKhoanThu(KhoanThuModel khoanThu) {
        this.khoanThu = khoanThu;
    }

    public HoKhauModel getHoKhau() {
        return hoKhau;
    }

    public void setHoKhau(HoKhauModel hoKhau) {
        this.hoKhau = hoKhau;
    }
    
    public String getTenChuHo() {
        return this.tenChuHo;
    }
    
}
