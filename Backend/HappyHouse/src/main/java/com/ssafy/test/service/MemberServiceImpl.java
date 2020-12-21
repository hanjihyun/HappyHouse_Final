package com.ssafy.test.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.test.dao.MemberDao;
import com.ssafy.test.dao.NoticeDao;
import com.ssafy.test.dto.MemberDto;
import com.ssafy.test.dto.NoticeDto;
import com.ssafy.test.util.PageNavigation;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private SqlSession sqlSession;


	@Override
	public void updateMyInfo(Map<String, String> map) throws SQLException {
		sqlSession.getMapper(MemberDao.class).updateMyInfo(map);
	}
	@Override
	public void signup(MemberDto member) throws SQLException {
		sqlSession.getMapper(MemberDao.class).signup(member);
	}

	@Override
	public MemberDto login(MemberDto m) throws Exception {
		return sqlSession.getMapper(MemberDao.class).login(m);
	}

	@Override
	public MemberDto searchGoogle(String gemail) {
		return sqlSession.getMapper(MemberDao.class).searchGoogle(gemail);
	}

	@Override
	public MemberDto googleSignup(Map<String, Object> map) throws Exception {
		return sqlSession.getMapper(MemberDao.class).googleSignup(map);
	}

	@Override
	public void deleteMember(Map<String, Object> map) throws Exception {

		sqlSession.getMapper(MemberDao.class).deleteMember(map);

	}

	@Override
	public List<MemberDto> listMember() throws SQLException {
		return sqlSession.getMapper(MemberDao.class).listMember();
	}

	@Override
	public List<MemberDto> searchMemberById(Map<String, String> map) throws SQLException {
		return sqlSession.getMapper(MemberDao.class).searchMemberById(map);
	}

	@Override
	public List<MemberDto> searchMemberByName(Map<String, String> map) throws SQLException {
		return sqlSession.getMapper(MemberDao.class).searchMemberByName(map);
	}

	@Override
	public MemberDto searchEmail(Map<String, String> map) throws SQLException {
		return sqlSession.getMapper(MemberDao.class).searchEmail(map);
	}

	@Override
	public List<MemberDto> searchMember(Map<String, String> map) throws SQLException {
		return sqlSession.getMapper(MemberDao.class).searchMember(map);
	}

	@Override
	public void changePWUpdate(Map<String, String> map) throws SQLException {
		sqlSession.getMapper(MemberDao.class).changePWUpdate(map);

	}
}