package models;

public class ThuChi {
	private int maThuChi;
	private String tenLoaiPhi;
	private boolean batBuoc;
	
	
	public ThuChi(int maThuChi, String tenLoaiPhi, boolean batBuoc) {
		this.maThuChi = maThuChi;
		this.tenLoaiPhi = tenLoaiPhi;
		this.batBuoc = batBuoc;
	}

	public ThuChi() {
	}

	public int getMaThuChi() {
		return maThuChi;
	}
	public void setMaThuChi(int maThuChi) {
		this.maThuChi = maThuChi;
	}
	public String getTenLoaiPhi() {
		return tenLoaiPhi;
	}
	public void setTenLoaiPhi(String tenLoaiPhi) {
		this.tenLoaiPhi = tenLoaiPhi;
	}
	public boolean isBatBuoc() {
		return batBuoc;
	}
	public void setBatBuoc(boolean batBuoc) {
		this.batBuoc = batBuoc;
	}

	@Override
	public String toString() {
		return "ThuChi{" +
				"maThuChi=" + maThuChi +
				", tenLoaiPhi='" + tenLoaiPhi + '\'' +
				", batBuoc=" + batBuoc +
				'}';
	}
}
