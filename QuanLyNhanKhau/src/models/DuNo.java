package models;

public class DuNo {
	
	private int maDuNo;
	private int maPhi;
	private int idHoKhau;
	private int tienNo;
	private int tienDu;
	private String tuNgay;
	private String denNgay;
	 
	
	public DuNo(int idHoKhau, int maDuNo, int maPhi, int tienNo, int tienDu, String tuNgay, String denNgay){
	    this.idHoKhau = idHoKhau;
	    this.maDuNo = maDuNo;
	    this.maPhi = maPhi;
	    this.tienNo = tienNo;
	    this.tienDu = tienDu;
	    this.tuNgay = tuNgay;
	    this.denNgay = denNgay;
	}

	
	public int getMaDuNo() {
		return maDuNo;
	}

	public void setMaDuNo(int maDuNo) {
		this.maDuNo = maDuNo;
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

	public int getTienNo() {
		return tienNo;
	}

	public void setTienNo(int tienNo) {
		this.tienNo = tienNo;
	}

	public int getTienDu() {
		return tienDu;
	}

	public void setTienDu(int tienDu) {
		this.tienDu = tienDu;
	}

	public String getTuNgay() {
		return tuNgay;
	}

	public void setTuNgay(String tuNgay) {
		this.tuNgay = tuNgay;
	}

	public String getDenNgay() {
		return denNgay;
	}

	public void setDenNgay(String denNgay) {
		this.denNgay = denNgay;
	}   
}
