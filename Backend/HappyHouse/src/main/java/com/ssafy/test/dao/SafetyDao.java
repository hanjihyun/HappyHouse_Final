package com.ssafy.test.dao;

import java.util.List;

import com.ssafy.test.dto.FireStation;
import com.ssafy.test.dto.PoliceOffice;
import com.ssafy.test.dto.SafeLevel;
import com.ssafy.test.dto.SafetyBell;
import com.ssafy.test.dto.SafetyCenter;
import com.ssafy.test.dto.Shelter;

public interface SafetyDao {

   List<PoliceOffice> getPoliceOffice(String dong)throws Exception;
   
   List<FireStation> getFireStation(String dong)throws Exception;
   
   List<SafetyCenter> getSafetyCenter(String dong)throws Exception;
   
   List<Shelter> getShelter(String dong)throws Exception;
   
   List<SafetyBell> getSafetyBell(String dong)throws Exception;
   List<SafeLevel> getTotalCnt(String dong)throws Exception;
}