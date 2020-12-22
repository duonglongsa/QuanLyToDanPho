package models;

public class KhoanThuModel {
	private int maThu;
	private int maPhi;
	private int idHoKhau;
	private int tienDaThu;
	private String ngayThu;
	
	
	public KhoanThuModel(int idHoKhau, int maThu, int maPhi, int tienDaThu, String ngayThu) {
		this.idHoKhau = idHoKhau;
		this.maThu = maThu;
		this.maPhi = maPhi;
		this.tienDaThu = tienDaThu;
		this.ngayThu = ngayThu;
	}


	public int getMaThu() {
		return maThu;
	}
	public void setMaThu(int maThu) {
		this.maThu = maThu;
	}
	public int getMaPhi() {
		return maPhi;
	}
	public void setMaPhi(int maPhi) {
		this.maPhi = maPhi;
	}
	public int getIdHoKhau() {
		return idHoKhau;
	}
	public void setIdHoKhau(int idHoKhau) {
		this.idHoKhau = idHoKhau;
	}
	public int getTienDaThu() {
		return tienDaThu;
	}
	public void setTienDaThu(int tienDaThu) {
		this.tienDaThu = tienDaThu;
	}
	public String getNgayThu() {
		return ngayThu;
	}
	public void setNgayThu(String ngayThu) {
		this.ngayThu = ngayThu;
	}
	
}
