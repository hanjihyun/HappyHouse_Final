package com.ssafy.test.service;

import java.util.List;
import java.util.Map;

import com.ssafy.test.dto.Favorite;
import com.ssafy.test.dto.HouseDealDto;
import com.ssafy.test.dto.NoticeDto;
import com.ssafy.test.util.PageNavigation;

public interface FavoriteService {

	HouseDealDto searchdetail(String no)throws Exception;

	void addFavorite(Map<String, String> map)throws Exception;

	List<Favorite> favoriteList(Map<String, String> map)throws Exception;
	PageNavigation makePageNavigation(Map<String, String> map) throws Exception;

	void favoriteDelete(Map<String, String> map)throws Exception;

	List<Favorite> searchfavorite(Map<String, String> param)throws Exception;

	List<Favorite> searchfavoriteByDong(Map<String, String> param)throws Exception;

	List<Favorite> searchfavoriteByApt(Map<String, String> param)throws Exception;



}
