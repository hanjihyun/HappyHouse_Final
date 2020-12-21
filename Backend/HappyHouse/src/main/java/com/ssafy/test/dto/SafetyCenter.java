package com.ssafy.test.dto;

public class SafetyCenter {
   private String no;
   private String centerid;
   private String sido;
   private String gugun;
   private String dong;
   private String centername;
   private String lat;
   private String lng;
   public String getNo() {
      return no;
   }
   public void setNo(String no) {
      this.no = no;
   }
   public String getCenterid() {
      return centerid;
   }
   public void setCenterid(String centerid) {
      this.centerid = centerid;
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
   public String getCentername() {
      return centername;
   }
   public void setCentername(String centername) {
      this.centername = centername;
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
   @Override
   public String toString() {
      return "SafetyCenter [no=" + no + ", centerid=" + centerid + ", sido=" + sido + ", gugun=" + gugun + ", dong="
            + dong + ", centername=" + centername + ", lat=" + lat + ", lng=" + lng + "]";
   }
   
   
}