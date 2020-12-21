package com.ssafy.test.service;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.test.dto.MemberDto;
import com.ssafy.test.dto.NoticeDto;
import com.ssafy.test.util.PageNavigation;


public interface MemberService {

   public MemberDto login(MemberDto member)throws Exception;
   public MemberDto searchGoogle(String gemail);

   public MemberDto googleSignup(Map<String, Object> map)throws Exception;
   public void signup(MemberDto member)throws Exception;


   public void deleteMember(Map<String, Object> map)throws Exception;

   public void updateMyInfo(Map<String, String> map) throws Exception;

   public List<MemberDto> listMember() throws SQLException;
   
   public List<MemberDto> searchMemberById(Map<String, String> map) throws SQLException;

   public List<MemberDto> searchMemberByName(Map<String, String> map) throws SQLException;
   public MemberDto searchEmail(Map<String, String> map) throws SQLException;
   public List<MemberDto> searchMember(Map<String, String> map) throws SQLException;

   public void changePWUpdate(Map<String, String> map) throws SQLException;

}