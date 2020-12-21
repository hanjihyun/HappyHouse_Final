package com.ssafy.test.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.test.dao.CoronaMapDao;
import com.ssafy.test.dto.HospitalInfoDto;
import com.ssafy.test.dto.HouseInfoDto;
import com.ssafy.test.dto.MedicalCenterDto;
import com.ssafy.test.dto.SidoGugunCodeDto;

@Service
public class CoronaMapServiceImpl implements CoronaMapService {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<HospitalInfoDto> getHospitalInfo(String dong) throws Exception {
		return sqlSession.getMapper(CoronaMapDao.class).getHospitalInfo(dong);
	}

	@Override
	public List<MedicalCenterDto> getMedicalCenterInfo(String dong) throws Exception {
		return sqlSession.getMapper(CoronaMapDao.class).getMedicalCenterInfo(dong);
	}

	@Override
	public List<SidoGugunCodeDto> getSido() throws Exception {
		return sqlSession.getMapper(CoronaMapDao.class).getSido();
	}

	@Override
	public List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception {
		 return sqlSession.getMapper(CoronaMapDao.class).getGugunInSido(sido);
	}

	@Override
	public List<HouseInfoDto> getDongInGugun(String gugun) throws Exception {
		 return sqlSession.getMapper(CoronaMapDao.class).getDongInGugun(gugun);
	}


}
