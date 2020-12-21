package com.ssafy.test.dto;

public class SafetyBell {
   private String no;
   private String safetyBellId;
   private String locationName;
   private String sido;
   private String gugun;
   private String dong;
   private String jibun;
   private String lat;
   private String lng;
   private String installYear;
   private String checkDate;
   private String tel;
   public String getNo() {
      return no;
   }
   public void setNo(String no) {
      this.no = no;
   }
   public String getSafetyBellId() {
      return safetyBellId;
   }
   public void setSafetyBellId(String safetyBellId) {
      this.safetyBellId = safetyBellId;
   }
   public String getLocationName() {
      return locationName;
   }
   public void setLocationName(String locationName) {
      this.locationName = locationName;
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
   public String getInstallYear() {
      return installYear;
   }
   public void setInstallYear(String installYear) {
      this.installYear = installYear;
   }
   public String getCheckDate() {
      return checkDate;
   }
   public void setCheckDate(String checkDate) {
      this.checkDate = checkDate;
   }
   public String getTel() {
      return tel;
   }
   public void setTel(String tel) {
      this.tel = tel;
   }
   @Override
   public String toString() {
      return "SafetyBell [no=" + no + ", safetyBellId=" + safetyBellId + ", locationName=" + locationName + ", sido="
            + sido + ", gugun=" + gugun + ", dong=" + dong + ", jibun=" + jibun + ", lat=" + lat + ", lng=" + lng
            + ", installYear=" + installYear + ", checkDate=" + checkDate + ", tel=" + tel + "]";
   }
   
   
}