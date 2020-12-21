package com.ssafy.test.dto;

public class FireStation {
   private String no;
   private String stationCode;
   private String x;
   private String y;
   private String sido;
   private String gugun;
   private String dong;
   private String stationName;
   private String lat;
   private String lng;
   public String getNo() {
      return no;
   }
   public void setNo(String no) {
      this.no = no;
   }
   public String getStationCode() {
      return stationCode;
   }
   public void setStationCode(String stationCode) {
      this.stationCode = stationCode;
   }
   public String getX() {
      return x;
   }
   public void setX(String x) {
      this.x = x;
   }
   public String getY() {
      return y;
   }
   public void setY(String y) {
      this.y = y;
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
   public String getStationName() {
      return stationName;
   }
   public void setStationName(String stationName) {
      this.stationName = stationName;
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
      return "FireStation [no=" + no + ", stationCode=" + stationCode + ", x=" + x + ", y=" + y + ", sido=" + sido
            + ", gugun=" + gugun + ", dong=" + dong + ", stationName=" + stationName + ", lat=" + lat + ", lng="
            + lng + "]";
   }
   
   
}