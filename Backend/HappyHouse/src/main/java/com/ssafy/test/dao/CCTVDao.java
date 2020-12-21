package com.ssafy.test.dao;

import java.util.List;
import java.util.Map;

import com.ssafy.test.dto.CCTV;

public interface CCTVDao {


	List<CCTV> getCCTVInfo(Map<String, Object> param)throws Exception;

	int getTotalCount(Map<String, String> map)throws Exception;

}
