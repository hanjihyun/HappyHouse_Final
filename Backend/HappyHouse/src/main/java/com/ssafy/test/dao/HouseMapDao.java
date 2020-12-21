package com.ssafy.test.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.test.dto.HouseDealDto;
import com.ssafy.test.dto.HouseInfoDto;
import com.ssafy.test.dto.SidoGugunCodeDto;


public interface HouseMapDao {

	List<SidoGugunCodeDto> getSido()throws Exception;

	List<SidoGugunCodeDto> getGugunInSido(String sido)throws Exception;

	List<HouseInfoDto> getDongInGugun(String gugun)throws Exception;

//	List<HouseDealDto> getAptDealInfo(String dong)throws Exception;

	HouseDealDto getDetailHouse(String no)throws Exception;

	int salesCnt()throws Exception;

	int getTotalCount(Map<String, String> map)throws Exception;

	List<HouseDealDto> getAptDealInfo(Map<String, Object> param)throws Exception;
}