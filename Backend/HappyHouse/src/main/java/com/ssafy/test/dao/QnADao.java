package com.ssafy.test.dao;

import java.util.List;

import com.ssafy.test.dto.QnADto;

public interface QnADao {

	List<QnADto> findAllQnAs()throws Exception;

	QnADto findQnAByNo(int qnaNo)throws Exception;

	boolean qnaInsert(QnADto dto)throws Exception;

	boolean qnaDelete(int qnaNo)throws Exception;

	boolean qnaUpdate(QnADto qna)throws Exception;

	List<QnADto> findQnaByTitle(String title)throws Exception;

	List<QnADto> findQnaByWriter(String writer)throws Exception;



}
