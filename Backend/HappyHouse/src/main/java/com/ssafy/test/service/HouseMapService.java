package com.ssafy.test.service;

import java.util.List;
import java.util.Map;

import com.ssafy.test.dto.HouseDealDto;
import com.ssafy.test.dto.HouseInfoDto;
import com.ssafy.test.dto.SidoGugunCodeDto;
import com.ssafy.test.util.PageNavigation;


public interface HouseMapService {

	List<SidoGugunCodeDto> getSido() throws Exception;

	List<SidoGugunCodeDto> getGugunInSido(String sido)throws Exception;

	List<HouseInfoDto> getDongInGugun(String gugun)throws Exception;

//	List<HouseDealDto> getAptDealInfo(String dong)throws Exception;

	HouseDealDto detailForm(String no)throws Exception;

	int salesCnt()throws Exception;

	PageNavigation makePageNavigation(Map<String, String> map)throws Exception;

	List<HouseDealDto> getAptDealInfo(Map<String, String> map)throws Exception;


   
//   List<SidoGugunCodeDto> getSido() throws Exception;
//   List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception;
//   List<HouseInfoDto> getDongInGugun(String gugun) throws Exception;
//   List<HouseInfoDto> getAptInDong(String dong) throws Exception;
//   List<HouseDealDto> getAptDealInfo(int pg, int sizePerPage, String dong) throws Exception;
//   public PageNavigation makePageNavigation(int pg, int sizePerPage, String dong) throws Exception;
//HouseDealDto getDetailHouse(String no) throws Exception;
}