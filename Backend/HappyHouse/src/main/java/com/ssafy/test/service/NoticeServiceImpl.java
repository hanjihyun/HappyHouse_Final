package com.ssafy.test.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.test.dao.HouseMapDao;
import com.ssafy.test.dao.MemberDao;
import com.ssafy.test.dao.NoticeDao;
import com.ssafy.test.dto.NoticeDto;
import com.ssafy.test.util.PageNavigation;


@Service
public class NoticeServiceImpl implements NoticeService {

   @Autowired
   private SqlSession sqlSession;
   
   
   private NoticeDao noticeDao;
  

   @Override
   public NoticeDto detailNotice(int noticeNo) throws SQLException {
      // TODO Auto-generated method stub
      return sqlSession.getMapper(NoticeDao.class).detailNotice(noticeNo);
   }

   @Override
   public void modifyNotice(Map<String, String> map) throws SQLException {
      sqlSession.getMapper(NoticeDao.class).modifyNotice(map);
   }
   
   
   @Override
   public List<NoticeDto> listNotice(Map<String, String> map) throws SQLException {
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
      return sqlSession.getMapper(NoticeDao.class).listNotice(param);
   }

   @Override
   public void deleteNotice(Map<String, Object> map) throws SQLException {
      sqlSession.getMapper(NoticeDao.class).deleteNotice(map);

   }

   @Override
   public void writeNotice(Map<String, String> map) throws SQLException {
      sqlSession.getMapper(NoticeDao.class).writeNotice(map);
   }

   @Override
   public List<NoticeDto> searchNoticeByTitle(Map<String, String> map) throws SQLException {
      return sqlSession.getMapper(NoticeDao.class).searchNoticeByTitle(map);
   }

   @Override
   public List<NoticeDto> searchNoticeByWriter(Map<String, String> map) throws SQLException {
      return sqlSession.getMapper(NoticeDao.class).searchNoticeByWriter(map);
   }
   @Override
   public List<NoticeDto> searchNotice(Map<String, String> map) throws SQLException {
      return sqlSession.getMapper(NoticeDao.class).searchNotice(map);
   }
	@Override
	public PageNavigation makePageNavigation(Map<String, String> map) throws SQLException {
		int naviSize = 5;
		int currentPage = Integer.parseInt(map.get("pg"));
		int sizePerPage = Integer.parseInt(map.get("spp"));
		PageNavigation pageNavigation = new PageNavigation();
		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setNaviSize(naviSize);
		int totalCount = sqlSession.getMapper(NoticeDao.class).getTotalCount(map);
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