package com.ssafy.test.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.test.dto.MemberDto;
import com.ssafy.test.dto.NoticeDto;



public interface MemberDao {
////   public List<MemberDto> search(String key, String word) throws SQLException;
//   public List<MemberDto> search(int currentPage, int sizePerPage, String key, String word);
//
//
//   public void addressdelete(String id) throws SQLException;
//
//   public int getTotalCount(String key, String word)throws SQLException;
   public MemberDto login(MemberDto member)throws SQLException;

   public void signup(MemberDto member) throws SQLException;

//   public void deleteMember(MemberDto member) throws SQLException;
   
   public void deleteMember(Map<String, Object> map) throws SQLException;

   public void updateMyInfo(Map<String, String> map)throws SQLException;

   public MemberDto login(Map<String, String> map);
   public MemberDto searchGoogle(String gemail);
   
   public MemberDto googleSignup(Map<String, Object> map)throws Exception;
   public List<MemberDto> listMember() throws SQLException;
   
   public List<MemberDto> searchMemberById(Map<String, String> map) throws SQLException;
   
   public List<MemberDto> searchMemberByName(Map<String, String> map) throws SQLException;

   public MemberDto searchEmail(Map<String, String> map)throws SQLException;
   public List<MemberDto> searchMember(Map<String, String> map) throws SQLException;

   public void changePWUpdate(Map<String, String> map)throws SQLException;	

}