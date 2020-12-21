package com.ssafy.test.dao;

import java.util.List;

import com.ssafy.test.dto.HospitalInfoDto;
import com.ssafy.test.dto.HouseDealDto;
import com.ssafy.test.dto.HouseInfoDto;
import com.ssafy.test.dto.MedicalCenterDto;
import com.ssafy.test.dto.SidoGugunCodeDto;


public interface CoronaMapDao {

	List<SidoGugunCodeDto> getSido() throws Exception;
	List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception;
	List<HouseInfoDto> getDongInGugun(String gugun) throws Exception;

	List<HospitalInfoDto> getHospitalInfo(String dong) throws Exception;
	List<MedicalCenterDto> getMedicalCenterInfo(String dong)throws Exception;
}
