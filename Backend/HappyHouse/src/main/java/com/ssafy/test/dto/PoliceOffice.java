package com.ssafy.test.dto;

public class PoliceOffice {
   private String no;
   private String organization;
   private String officename;
   private String lng;
   private String lat;
   private String sido;
   private String gugun;
   private String dong;
   private String jibun;
   public String getNo() {
      return no;
   }
   public void setNo(String no) {
      this.no = no;
   }
   public String getOrganization() {
      return organization;
   }
   public void setOrganization(String organization) {
      this.organization = organization;
   }
   public String getOfficename() {
      return officename;
   }
   public void setOfficename(String officename) {
      this.officename = officename;
   }
   public String getLng() {
      return lng;
   }
   public void setLng(String lng) {
      this.lng = lng;
   }
   public String getLat() {
      return lat;
   }
   public void setLat(String lat) {
      this.lat = lat;
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
   @Override
   public String toString() {
      return "PoliceOffice [no=" + no + ", organization=" + organization + ", officename=" + officename + ", lng="
            + lng + ", lat=" + lat + ", sido=" + sido + ", gugun=" + gugun + ", dong=" + dong + ", jibun=" + jibun
            + "]";
   }
   
   
}