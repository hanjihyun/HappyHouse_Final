package com.ssafy.test.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.test.dao.FavoriteDao;
import com.ssafy.test.dao.HouseMapDao;
import com.ssafy.test.dto.HouseDealDto;
import com.ssafy.test.dto.HouseInfoDto;
import com.ssafy.test.dto.SidoGugunCodeDto;
import com.ssafy.test.util.PageNavigation;

@Service
public class HouseMapServiceImpl implements HouseMapService {
	@Autowired
	private SqlSession sqlSession;


	@Override
	public List<SidoGugunCodeDto> getSido() throws Exception {
		return sqlSession.getMapper(HouseMapDao.class).getSido();
	}

	@Override
	public List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception {
		 return sqlSession.getMapper(HouseMapDao.class).getGugunInSido(sido);
	}

	@Override
	public List<HouseInfoDto> getDongInGugun(String gugun) throws Exception {
		 return sqlSession.getMapper(HouseMapDao.class).getDongInGugun(gugun);
	}


	@Override
	public HouseDealDto detailForm(String no) throws Exception {
		return sqlSession.getMapper(HouseMapDao.class).getDetailHouse(no);
	}

	@Override
	public int salesCnt() throws Exception {
		return sqlSession.getMapper(HouseMapDao.class).salesCnt();
	}

	@Override
	public PageNavigation makePageNavigation(Map<String, String> map) throws Exception {
		int naviSize = 5;
		int currentPage = Integer.parseInt(map.get("pg"));
		int sizePerPage = Integer.parseInt(map.get("spp"));
		PageNavigation pageNavigation = new PageNavigation();
		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setNaviSize(naviSize);
		int totalCount = sqlSession.getMapper(HouseMapDao.class).getTotalCount(map);
		pageNavigation.setTotalCount(totalCount);
		int totalPageCount = (totalCount - 1) / sizePerPage + 1;
		pageNavigation.setTotalPageCount(totalPageCount);
		boolean startRange = currentPage <= naviSize;
		pageNavigation.setStartRange(startRange);
		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < currentPage;
		pageNavigation.setEndRange(endRange);
		pageNavigation.makeNavigator();
		return pageNavigation;
		
	}
	
	@Override
	public List<HouseDealDto> getAptDealInfo(Map<String, String> map) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		int currentPage = Integer.parseInt(map.get("pg")); //문자열로 넘어와서 형변환!
//		System.out.println(currentPage);
		int sizePerPage = Integer.parseInt(map.get("spp"));
//		System.out.println(sizePerPage);
		int start = (currentPage - 1) * sizePerPage; //start = 0
		param.put("start", start);
		param.put("spp", sizePerPage);
		String dong = map.get("dong");
		param.put("dong", dong);
		return sqlSession.getMapper(HouseMapDao.class).getAptDealInfo(param);
	}

}