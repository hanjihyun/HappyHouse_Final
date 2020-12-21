package com.ssafy.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.test.dto.HospitalInfoDto;
import com.ssafy.test.dto.HouseInfoDto;
import com.ssafy.test.dto.MedicalCenterDto;
import com.ssafy.test.dto.SidoGugunCodeDto;
import com.ssafy.test.service.CoronaMapService;


@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/corona")
public class CoronaMapController{

	@Autowired
	private CoronaMapService coronaMapservice;
	
	@GetMapping("/coronaList")
	public ModelAndView houseSalesForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("corona/coronaList");
		return mv;
	}
	
	@GetMapping("/sido")
	public List<SidoGugunCodeDto> sido(){
//		System.out.println("#sido Code 목록 호출");
//		System.out.println();
		List<SidoGugunCodeDto> list = null;
		
		try {
			list = coronaMapservice.getSido();
			
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
			list = coronaMapservice.getGugunInSido(sido);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	@GetMapping("/dong")
	public List<HouseInfoDto> dong(String gugun) {
//		System.out.println("#"+gugun + " dong 목록 호출");
//		System.out.println();
//		
		List<HouseInfoDto> list = null;
		
		try {
			list = coronaMapservice.getDongInGugun(gugun);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	@GetMapping("/hospital")
	public List<HospitalInfoDto> getHospitalInfo(String gugun){
		List<HospitalInfoDto> list = null;
//		System.out.println(gugun);
		try {
			list = coronaMapservice.getHospitalInfo(gugun);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return list;
	}	
	@GetMapping("/medicalCenter")
	public List<MedicalCenterDto> getMedicalCenterInfo(String gugun){
		List<MedicalCenterDto> list = null;
//		System.out.println(gugun+"들어와?");
		try {
			list = coronaMapservice.getMedicalCenterInfo(gugun);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return list;
	}	
}