package com.ssafy.test.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.test.dao.QnADao;
import com.ssafy.test.dto.QnADto;

@Service
public class QnAServiceImpl implements QnAService {

   @Autowired
      private SqlSession sqlSession;

   
   @Override
   @Transactional(readOnly=true)
   public List<QnADto> findAllQnAs() throws Exception {
      return sqlSession.getMapper(QnADao.class).findAllQnAs();
   }

   @Override
   public QnADto findQnAByNo(int qnaNo) throws Exception {
      return sqlSession.getMapper(QnADao.class).findQnAByNo(qnaNo);
   }

   @Override
   public boolean qnaInsert(QnADto dto) throws Exception {
      return sqlSession.getMapper(QnADao.class).qnaInsert(dto);
   }

   @Override
   public boolean qnaDelete(int qnaNo) throws Exception {
      return sqlSession.getMapper(QnADao.class).qnaDelete(qnaNo);
   }

   @Override
   public boolean qnaUpdate(QnADto qna) throws Exception {
      return sqlSession.getMapper(QnADao.class).qnaUpdate(qna);
   }

   @Override
   public List<QnADto> findQnaByTitle(String title) throws Exception {
      return sqlSession.getMapper(QnADao.class).findQnaByTitle(title);
   }

   @Override
   public List<QnADto> findQnaByWriter(String writer) throws Exception {
      return sqlSession.getMapper(QnADao.class).findQnaByWriter(writer);
   }

}