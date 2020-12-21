package com.ssafy.test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.test.dto.HouseDealDto;
import com.ssafy.test.dto.HouseInfoDto;
import com.ssafy.test.dto.SidoGugunCodeDto;
import com.ssafy.test.service.HouseMapService;
import com.ssafy.test.util.PageNavigation;


@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/map")
public class HouseMapController {
	
	@Autowired
	private HouseMapService service;
	
	@GetMapping("/houseSales")
	public ModelAndView houseSalesForm(Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("map/houseSales");
		return mv;
	}
	
	@GetMapping("/detailHouse")
	public ModelAndView detailForm(String no) {
		ModelAndView mv = new ModelAndView();
		HouseDealDto hd = null;
		try {
			hd = service.detailForm(no);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.addObject("detailForm",hd);
		mv.setViewName("map/detailHouse");
		return mv;
	}
	@GetMapping("/sido")
	public List<SidoGugunCodeDto> sido() {
//		System.out.println("#sido Code 목록 호출");
//		System.out.println();
		List<SidoGugunCodeDto> list = null;
		
		try {
			list = service.getSido();
//			for (int i = 0; i < list.size(); i++) {
//				
//				System.out.println(list.get(i).toString());
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	@GetMapping("/gugun")
	public List<SidoGugunCodeDto> gugun(String sido) {
//		System.out.println("#"+sido + " gugun Code 목록 호출");
//		System.out.println();
		List<SidoGugunCodeDto> list = null;
		
		try {
			list = service.getGugunInSido(sido);
//for (int i = 0; i < list.size(); i++) {
//				
//				System.out.println(list.get(i).toString());
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	@GetMapping("/dong")
	public List<HouseInfoDto> dong(String gugun) {
//		System.out.println("#"+gugun + " dong 목록 호출");
//		System.out.println();
		
		List<HouseInfoDto> list = null;
		
		try {
			list = service.getDongInGugun(gugun);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	@GetMapping("/apt")
	public Map<String, Object> apt(String dong,String pg) {
		Map<String, String> map = new HashMap<String, String>();
		String spp = map.get("spp");
		map.put("spp", spp != null ? spp : "5");//sizePerPage

//		String pg = map.get("pg");
		map.put("pg", pg != "" ? pg : "1");
		map.put("dong", dong);
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			List<HouseDealDto> list = service.getAptDealInfo(map);
			PageNavigation pageNavigation = service.makePageNavigation(map);
//			 for (int i = 0; i < list.size(); i++) {
//				
//				System.out.println(list.get(i).toString());
//			}
			 param.put("list", list);
			 param.put("navigation", pageNavigation);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return param;
	}

}