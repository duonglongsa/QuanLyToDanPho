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
public class KhoanThuVaHoKhau {
    private KhoanThu khoanThu;
    private HoKhauModel hoKhau;

    public KhoanThuVaHoKhau(KhoanThu khoanThu, HoKhauModel hoKhau) {
        this.khoanThu = khoanThu;
        this.hoKhau = hoKhau;
    }

    public KhoanThu getKhoanThu() {
        return khoanThu;
    }

    public void setKhoanThu(KhoanThu khoanThu) {
        this.khoanThu = khoanThu;
    }

    public HoKhauModel getHoKhau() {
        return hoKhau;
    }

    public void setHoKhau(HoKhauModel hoKhau) {
        this.hoKhau = hoKhau;
    }
    
}
