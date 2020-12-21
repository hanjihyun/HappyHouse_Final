package com.ssafy.test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.test.dto.Favorite;
import com.ssafy.test.dto.HouseDealDto;
import com.ssafy.test.dto.MemberDto;
import com.ssafy.test.service.FavoriteService;
import com.ssafy.test.util.PageNavigation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/fav")
public class FavoriteController {

	@Autowired
	private FavoriteService service;
	
	@GetMapping("/searchDetail")
	private ModelAndView searchDetail(@RequestParam String no, HttpSession session) {
		ModelAndView mv = new ModelAndView();
//		System.out.println(no);

		MemberDto memberDto = (MemberDto) session.getAttribute("memberInfo");
		if (memberDto == null) {
			mv.addObject("msg", "로그인 이후 가능한 서비스 입니다.");
			mv.setViewName("common/msg");
			return mv;
		}
		String userid = memberDto.getUserid();
//		System.out.println(userid);

		Map<String, String> map = new HashMap<String, String>();
		HouseDealDto houseDeal = null;

		try {
			houseDeal = service.searchdetail(no);
//			System.out.println(houseDeal);
			map.put("userid", userid);
			map.put("no", houseDeal.getNo());
			map.put("dong", houseDeal.getDong());
			map.put("aptName", houseDeal.getAptName());
			map.put("code", houseDeal.getCode());
			map.put("dealAmount", houseDeal.getDealAmount());
			map.put("buildYear", houseDeal.getBuildYear());
			map.put("dealYear", houseDeal.getDealYear());
			map.put("dealMonth", houseDeal.getDealMonth());
			map.put("dealDay", houseDeal.getDealDay());
			map.put("area", houseDeal.getArea());
			map.put("floor", houseDeal.getFloor());
			map.put("jibun", houseDeal.getJibun());

			service.addFavorite(map);

			mv.addObject("msg", "관심 매물로 등록되었습니다.");
			mv.setViewName("/favorite/msg");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mv.addObject("msg", "이미 등록 되어있는 매물 입니다.");
			mv.setViewName("/favorite/msg");
		}

		return mv;
	}
	
	@GetMapping("/favoriteList")
	public ModelAndView favoriteList(@RequestParam Map<String, String> map,HttpSession session) {
		ModelAndView mv = new ModelAndView();
	    String spp = map.get("spp");
		map.put("spp", spp != null ? spp : "3");//sizePerPage

		String pg = map.get("pg");
		map.put("pg", pg != null ? pg : "1");
			
		MemberDto memberDto = (MemberDto) session.getAttribute("memberInfo");
		if (memberDto == null) {
			mv.addObject("msg", "로그인 이후 가능한 서비스 입니다.");
			mv.setViewName("common/msg");
			return mv;
		}
		String userid = memberDto.getUserid();
		map.put("userid", userid);
		
	
//		for(String key : map.keySet()) 
//		{ 
//			String value = (String) map.get(key); 
//			System.out.println(key + " : " + value); 
//		}

		try {
			List<Favorite> list = service.favoriteList(map);
			 PageNavigation pageNavigation = service.makePageNavigation(map);
//			 for (int i = 0; i < list.size(); i++) {
//				System.out.println(list);
//			}
			mv.addObject("favoriteH", list);
			mv.addObject("navigation", pageNavigation);
			mv.setViewName("favorite/favoriteList");

		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("msg", "글목록을 얻어오는 중 문제가 발생했습니다.");
			mv.setViewName("error/error");
		}
		
		return mv;
	}

	@GetMapping("/favoritedelete")
	public ModelAndView favoriteDelete(String no, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		MemberDto memberDto = (MemberDto) session.getAttribute("memberInfo");
		String userid = memberDto.getUserid();
//		System.out.println("C" + userid);
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", userid);
		map.put("no", no);
		try {
			service.favoriteDelete(map);
			mv.setViewName("redirect:/fav/favoriteList");
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("msg", "삭제 중 문제가 발생했습니다.");
			mv.setViewName("error/error");
		}
		return mv;

	}
}
