package com.ssafy.test.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.test.dao.SafetyDao;
import com.ssafy.test.dto.FireStation;
import com.ssafy.test.dto.PoliceOffice;
import com.ssafy.test.dto.SafeLevel;
import com.ssafy.test.dto.SafetyBell;
import com.ssafy.test.dto.SafetyCenter;
import com.ssafy.test.dto.Shelter;

@Service
public class SafetyServiceImpl implements SafetyService {
   @Autowired
   private SqlSession sqlSession;

   @Override
   public List<PoliceOffice> getPoliceOffice(String dong) throws Exception {
      return sqlSession.getMapper(SafetyDao.class).getPoliceOffice(dong);
   }

   @Override
   public List<FireStation> getFireStation(String dong) throws Exception {
      return sqlSession.getMapper(SafetyDao.class).getFireStation(dong);
   }

   @Override
   public List<SafetyCenter> getSafetyCenter(String dong) throws Exception {
      return sqlSession.getMapper(SafetyDao.class).getSafetyCenter(dong);
   }

   @Override
   public List<Shelter> getShelter(String dong) throws Exception {
      return sqlSession.getMapper(SafetyDao.class).getShelter(dong);
   }

   @Override
   public List<SafetyBell> getSafetyBell(String dong) throws Exception {
      return sqlSession.getMapper(SafetyDao.class).getSafetyBell(dong);
   }
   @Override
   public List<SafeLevel> getTotalCnt(String dong) throws Exception {
      return sqlSession.getMapper(SafetyDao.class).getTotalCnt(dong);
   }

}