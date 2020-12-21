package com.ssafy.test.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.test.dao.FavoriteDao;
import com.ssafy.test.dao.NoticeDao;
import com.ssafy.test.dto.Favorite;
import com.ssafy.test.dto.HouseDealDto;
import com.ssafy.test.util.PageNavigation;

@Service
public class FavoriteServiceImpl implements FavoriteService {
	@Autowired
	private SqlSession sqlSession;


	@Override
	public HouseDealDto searchdetail(String no) throws Exception {
		return sqlSession.getMapper(FavoriteDao.class).searchdetail(no);
	}

	@Override
	public void addFavorite(Map<String, String> map) throws Exception {
		sqlSession.getMapper(FavoriteDao.class).addFavorite(map);
	}

	@Override
	public List<Favorite> favoriteList(Map<String, String> map) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("searchKey", map.get("searchKey") == null ? "" : map.get("searchKey"));
		param.put("searchWord", map.get("searchWord") == null ? "" : map.get("searchWord"));
//		System.out.println(map.get("pg"));
		int currentPage = Integer.parseInt(map.get("pg")); //문자열로 넘어와서 형변환!
//		System.out.println(currentPage);
		int sizePerPage = Integer.parseInt(map.get("spp"));
//		System.out.println(sizePerPage);
		int start = (currentPage - 1) * sizePerPage; //start = 0
		param.put("start", start);
		param.put("spp", sizePerPage);
		String userid = map.get("userid");
		param.put("userid", userid);
		return sqlSession.getMapper(FavoriteDao.class).favoriteList(param);
	}

	@Override
	public void favoriteDelete(Map<String, String> map) throws Exception {
		sqlSession.getMapper(FavoriteDao.class).favoriteDelete(map);
	}

	@Override
	public List<Favorite> searchfavorite(Map<String, String> param) throws Exception {
		 return sqlSession.getMapper(FavoriteDao.class).searchfavorite(param);
	}

	@Override
	public List<Favorite> searchfavoriteByDong(Map<String, String> param) throws Exception {
		 return sqlSession.getMapper(FavoriteDao.class).searchfavoriteByDong(param);
	}

	@Override
	public List<Favorite> searchfavoriteByApt(Map<String, String> param) throws Exception {
		 return sqlSession.getMapper(FavoriteDao.class).searchfavoriteByApt(param);
	}

	@Override
	public PageNavigation makePageNavigation(Map<String, String> map) throws Exception {
		int naviSize = 5;
		int currentPage = Integer.parseInt(map.get("pg"));
		int sizePerPage = Integer.parseInt(map.get("spp"));
		PageNavigation pageNavigation = new PageNavigation();
		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setNaviSize(naviSize);
		int totalCount = sqlSession.getMapper(FavoriteDao.class).getTotalCount(map);
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
