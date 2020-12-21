package com.ssafy.test.dto;

public class Shelter {
   private String no;
   private String sheltername;
   private String type;
   private String locationType;
   private String sido;
   private String gugun;
   private String dong;
   private String jibun;
   private String lat;
   private String lng;
   private String capableArea;
   private String capablePeople;
   private String isAvailable;
   private String tel;
   private String checkDate;
   public String getNo() {
      return no;
   }
   public void setNo(String no) {
      this.no = no;
   }
   public String getSheltername() {
      return sheltername;
   }
   public void setSheltername(String sheltername) {
      this.sheltername = sheltername;
   }
   public String getType() {
      return type;
   }
   public void setType(String type) {
      this.type = type;
   }
   public String getLocationType() {
      return locationType;
   }
   public void setLocationType(String locationType) {
      this.locationType = locationType;
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
   public String getCapableArea() {
      return capableArea;
   }
   public void setCapableArea(String capableArea) {
      this.capableArea = capableArea;
   }
   public String getCapablePeople() {
      return capablePeople;
   }
   public void setCapablePeople(String capablePeople) {
      this.capablePeople = capablePeople;
   }
   public String getIsAvailable() {
      return isAvailable;
   }
   public void setIsAvailable(String isAvailable) {
      this.isAvailable = isAvailable;
   }
   public String getTel() {
      return tel;
   }
   public void setTel(String tel) {
      this.tel = tel;
   }
   public String getCheckDate() {
      return checkDate;
   }
   public void setCheckDate(String checkDate) {
      this.checkDate = checkDate;
   }
   @Override
   public String toString() {
      return "Shelter [no=" + no + ", sheltername=" + sheltername + ", type=" + type + ", locationType="
            + locationType + ", sido=" + sido + ", gugun=" + gugun + ", dong=" + dong + ", jibun=" + jibun
            + ", lat=" + lat + ", lng=" + lng + ", capableArea=" + capableArea + ", capablePeople=" + capablePeople
            + ", isAvailable=" + isAvailable + ", tel=" + tel + ", checkDate=" + checkDate + "]";
   }
   
   
}