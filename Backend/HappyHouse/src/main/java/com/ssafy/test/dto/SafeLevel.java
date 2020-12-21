package com.ssafy.test.dto;

public class SafeLevel {
   private String sido;
   private String gugun;
   private String dong;
   private String type;
   private int firestationcnt;
   private int policeofficecnt;
   private int sheltercnt;
   private int safetybellcnt;
   private int safetycentercnt;
   private int totalcnt;
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
   public int getFirestationcnt() {
      return firestationcnt;
   }
   public void setFirestationcnt(int firestationcnt) {
      this.firestationcnt = firestationcnt;
   }
   public int getPoliceofficecnt() {
      return policeofficecnt;
   }
   public void setPoliceofficecnt(int policeofficecnt) {
      this.policeofficecnt = policeofficecnt;
   }
   public int getSheltercnt() {
      return sheltercnt;
   }
   public void setSheltercnt(int sheltercnt) {
      this.sheltercnt = sheltercnt;
   }
   public int getSafetybellcnt() {
      return safetybellcnt;
   }
   public void setSafetybellcnt(int safetybellcnt) {
      this.safetybellcnt = safetybellcnt;
   }
   public int getSafetycentercnt() {
      return safetycentercnt;
   }
   public void setSafetycentercnt(int safetycentercnt) {
      this.safetycentercnt = safetycentercnt;
   }
   public int getTotalcnt() {
      return totalcnt;
   }
   public void setTotalcnt(int totalcnt) {
      this.totalcnt = totalcnt;
   }
   public String getType() {
      return type;
   }
   public void setType(String type) {
      this.type = type;
   }
   @Override
   public String toString() {
      return "SafeLevel [sido=" + sido + ", gugun=" + gugun + ", dong=" + dong + ", type=" + type
            + ", firestationcnt=" + firestationcnt + ", policeofficecnt=" + policeofficecnt + ", sheltercnt="
            + sheltercnt + ", safetybellcnt=" + safetybellcnt + ", safetycentercnt=" + safetycentercnt
            + ", totalcnt=" + totalcnt + "]";
   }
   
   
   
}