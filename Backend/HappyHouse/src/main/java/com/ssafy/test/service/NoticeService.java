package com.ssafy.test.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.test.dto.NoticeDto;
import com.ssafy.test.util.PageNavigation;


public interface NoticeService {
   public void writeNotice(Map<String, String> map) throws SQLException;

   public NoticeDto detailNotice(int noticeNo) throws SQLException;

   public void modifyNotice(Map<String, String> map) throws SQLException;

   public void deleteNotice(Map<String, Object> map) throws SQLException;

   public List<NoticeDto> listNotice(Map<String, String> map) throws SQLException;
   public PageNavigation makePageNavigation(Map<String, String> map) throws SQLException;
   
   public List<NoticeDto> searchNoticeByTitle(Map<String, String> map) throws SQLException;

   public List<NoticeDto> searchNoticeByWriter(Map<String, String> map) throws SQLException;
   public List<NoticeDto> searchNotice(Map<String, String> map) throws SQLException;

}