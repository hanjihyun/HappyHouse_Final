package com.ssafy.test.service;

import java.util.List;
import java.util.Map;

import com.ssafy.test.dto.CCTV;
import com.ssafy.test.util.PageNavigation;

public interface CCTVService {

//	List<CCTVVideo> getCCTVVideoInfo()throws Exception;

	List<CCTV> getCCTVInfo(Map<String, String> map) throws Exception;

	PageNavigation makePageNavigation(Map<String, String> map)throws Exception;

}
