package com.ssafy.test.dto;

public class CCTV {
	private String no;
	private String guchung;
	private String sido;
	private String gugun;
	private String dong;
	private String jibun;
	private String pixel;
	private String angle;
	private String storeday;
	private String installdate;
	private String admintel;
	private String lat;
	private String lng;
	private String lastdate;
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getGuchung() {
		return guchung;
	}
	public void setGuchung(String guchung) {
		this.guchung = guchung;
	}
	public String getSido() {
		return sido;
	}
	public void setSido(String sido) {
		this.sido = sido;
	}
	public String getGugun() {
		return gugun;
	}
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getJibun() {
		return jibun;
	}
	public void setJibun(String jibun) {
		this.jibun = jibun;
	}
	public String getPixel() {
		return pixel;
	}
	public void setPixel(String pixel) {
		this.pixel = pixel;
	}
	public String getAngle() {
		return angle;
	}
	public void setAngle(String angle) {
		this.angle = angle;
	}
	public String getStoreday() {
		return storeday;
	}
	public void setStoreday(String storeday) {
		this.storeday = storeday;
	}
	public String getInstalldate() {
		return installdate;
	}
	public void setInstalldate(String installdate) {
		this.installdate = installdate;
	}
	public String getAdmintel() {
		return admintel;
	}
	public void setAdmintel(String admintel) {
		this.admintel = admintel;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getLastdate() {
		return lastdate;
	}
	public void setLastdate(String lastdate) {
		this.lastdate = lastdate;
	}
	@Override
	public String toString() {
		return "CCTV [no=" + no + ", guchung=" + guchung + ", sido=" + sido + ", gugun=" + gugun + ", dong=" + dong
				+ ", jibun=" + jibun + ", pixel=" + pixel + ", angle=" + angle + ", storeday=" + storeday
				+ ", installdate=" + installdate + ", admintel=" + admintel + ", lat=" + lat + ", lng=" + lng
				+ ", lastdate=" + lastdate + "]";
	}
	
	
}
