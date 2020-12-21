package com.ssafy.test.dao;

import java.util.List;
import java.util.Map;

import com.ssafy.test.dto.Favorite;
import com.ssafy.test.dto.HouseDealDto;
import com.ssafy.test.dto.NoticeDto;

public interface FavoriteDao {

	HouseDealDto searchdetail(String no)throws Exception;

	void addFavorite(Map<String, String> map)throws Exception;

	void favoriteDelete(Map<String, String> map) throws Exception;

	List<Favorite> searchfavorite(Map<String, String> param)throws Exception;

	List<Favorite> searchfavoriteByDong(Map<String, String> param)throws Exception;

	List<Favorite> searchfavoriteByApt(Map<String, String> param)throws Exception;

	List<Favorite> favoriteList(Map<String, Object> param)throws Exception;
	int getTotalCount(Map<String, String> map)throws Exception;

}
