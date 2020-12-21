package com.ssafy.test.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.test.dao.CCTVDao;
import com.ssafy.test.dao.HouseMapDao;
import com.ssafy.test.dto.CCTV;
import com.ssafy.test.util.PageNavigation;

@Service
public class CCTVServiceImpl implements CCTVService {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<CCTV> getCCTVInfo(Map<String, String> map) throws Exception {
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
		return sqlSession.getMapper(CCTVDao.class).getCCTVInfo(param);
	}

	@Override
	public PageNavigation makePageNavigation(Map<String, String> map) throws Exception {
		int naviSize = 5;
		int currentPage = Integer.parseInt(map.get("pg"));
		int sizePerPage = Integer.parseInt(map.get("spp"));
		PageNavigation pageNavigation = new PageNavigation();
		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setNaviSize(naviSize);
		int totalCount = sqlSession.getMapper(CCTVDao.class).getTotalCount(map);
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


}
