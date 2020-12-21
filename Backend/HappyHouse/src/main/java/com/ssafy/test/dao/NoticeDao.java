package com.ssafy.test.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ssafy.test.dto.NoticeDto;

public interface NoticeDao {
   public void writeNotice(Map<String, String> map) throws SQLException;
   
   public NoticeDto detailNotice(int noticeNo) throws SQLException;

   public void modifyNotice(Map<String, String> map) throws SQLException;

   public void deleteNotice(Map<String, Object> map) throws SQLException;

   public List<NoticeDto> listNotice(Map<String, Object> param) throws SQLException;
   public int getTotalCount(Map<String, String> map) throws SQLException;
   
   public List<NoticeDto> searchNoticeByTitle(Map<String, String> map) throws SQLException;
   
   public List<NoticeDto> searchNoticeByWriter(Map<String, String> map) throws SQLException;
   public List<NoticeDto> searchNotice(Map<String, String> map) throws SQLException;

}