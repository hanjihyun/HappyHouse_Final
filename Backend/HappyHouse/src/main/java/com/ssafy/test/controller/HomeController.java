package com.ssafy.test.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ssafy.test.service.HouseMapService;

@Controller
public class HomeController {
	
	@Autowired
	private HouseMapService houseMapService;
	
	
	@GetMapping({"/", "/index"})
	public String main(Model model) throws IOException {
//		날씨 크롤링
		String URL = "https://weather.naver.com/rgn/cityWetrMain.nhn";
		Document doc = Jsoup.connect(URL).get();
		Elements elem = doc.select("div.card.card_today");
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("temp", (String)elem.select("strong.current").text());
		map.put("weather", (String)elem.select("span.weather").text());
//		model.addAllAttributes(map);
		
//		부동산 뉴스 크롤링
		String newsURL = "https://news.naver.com/main/list.nhn?mode=LS2D&mid=shm&sid1=101&sid2=260";
		Document docNews = Jsoup.connect(newsURL).get();
		
		Elements elemNews = docNews.select("div[class=\"list_body newsflash_body\"]");
		Iterator<Element> ie1 = elemNews.select("dt+dt > a").iterator();
		
		Map<String,Object> newsMap = new HashMap<String, Object>();
		newsMap.put("news", ie1);
		
		model.addAllAttributes(map);
		model.addAllAttributes(newsMap);
		
		Map<String,Object> houseDealCnt = new HashMap<String, Object>();
		int salesCnt = 0;
		try {
			salesCnt = houseMapService.salesCnt();
//			System.out.println(salesCnt);
			houseDealCnt.put("hoseDealC", salesCnt);
			model.addAllAttributes(houseDealCnt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "index";
	}

}
