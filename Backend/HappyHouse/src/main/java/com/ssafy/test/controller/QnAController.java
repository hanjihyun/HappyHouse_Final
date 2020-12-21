package com.ssafy.test.controller;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.test.dto.QnADto;
import com.ssafy.test.service.QnAService;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/qna")
public class QnAController {
	public static final Logger logger = LoggerFactory.getLogger(QnAController.class);

	@Autowired
	private QnAService qnaService;

	@RequestMapping(value = "/findAllQnAs", method = RequestMethod.GET)
	public ResponseEntity<List<QnADto>> findAllQnAs() throws Exception {
		logger.info("1-------------findAllQnAs-----------------------------" + new Date());
		List<QnADto> qnas = qnaService.findAllQnAs();
	
		if (qnas.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<QnADto>>(qnas, HttpStatus.OK);
	}

	@RequestMapping(value = "/qnaDetail/{qnaNo}", method = RequestMethod.GET)
	public ResponseEntity<QnADto> findQnAByNo(@PathVariable int qnaNo) throws Exception {
		logger.info("1-------------findQnAByNo-----------------------------" + new Date());

//		System.out.println(qnaNo);
		QnADto qna = qnaService.findQnAByNo(qnaNo);
//		System.out.println(qna);
		if (qna == null || qna.getQnaNo() == 0) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<QnADto>(qna, HttpStatus.OK);
	}
	@RequestMapping(value = "/qnaUpdate/{qnaNo}", method = RequestMethod.GET)
	public ResponseEntity<QnADto> qnaUpdate(@PathVariable int qnaNo) throws Exception {
		logger.info("1-------------qnaUpdate-----------------------------" + new Date());

//		System.out.println(qnaNo);
		QnADto qna = qnaService.findQnAByNo(qnaNo);
//		System.out.println(qna);
		if (qna == null || qna.getQnaNo() == 0) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<QnADto>(qna, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/qnaInsert", method = RequestMethod.POST)
	public ResponseEntity<String> qnaInsert(@RequestBody QnADto dto) throws Exception {
		logger.info("5-------------qnaInsert-----------------------------" + new Date());
		logger.info("5-------------qnaInsert-----------------------------" + dto);
		if (qnaService.qnaInsert(dto)) {
			return new ResponseEntity<String>("success", HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/qnaDelete/{qnaNo}", method = RequestMethod.POST)
	public ResponseEntity<String> qnaDelete(@PathVariable int qnaNo) throws Exception {
		logger.info("1-------------qnaDelete-----------------------------" + new Date());
		logger.info("1-------------qnaDelete-----------------------------" + qnaNo);
		if (qnaService.qnaDelete(qnaNo)) {
			return new ResponseEntity<String>("success", HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value = "/qnaUpdate", method = RequestMethod.POST)
	public ResponseEntity<String> qnaUpdate(@RequestBody QnADto qna) throws Exception {
		logger.info("1-------------qnaUpdate-----------------------------"+new Date());
		
		if (qnaService.qnaUpdate(qna)) {
			return new ResponseEntity<String>("success", HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	@RequestMapping(value = "/findQnaByTitle/{title}", method = RequestMethod.GET)
	public ResponseEntity<List<QnADto>> findQnaByTitle(@PathVariable String title) throws Exception {
		logger.info("1-------------findQnaByTitle-----------------------------"+new Date());
		List<QnADto> dto = qnaService.findQnaByTitle(title);
		if (dto.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<QnADto>>(dto, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/findQnaByWriter/{writer}", method = RequestMethod.GET)
	public ResponseEntity<List<QnADto>> findQnaByWriter(@PathVariable String writer) throws Exception {
		logger.info("1-------------findQnaByTitle-----------------------------"+new Date());
		List<QnADto> dto = qnaService.findQnaByWriter(writer);
		if (dto.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<QnADto>>(dto, HttpStatus.OK);
	}
}
