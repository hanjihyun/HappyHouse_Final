package com.ssafy.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.test.dto.FireStation;
import com.ssafy.test.dto.PoliceOffice;
import com.ssafy.test.dto.SafeLevel;
import com.ssafy.test.dto.SafetyBell;
import com.ssafy.test.dto.SafetyCenter;
import com.ssafy.test.dto.Shelter;
import com.ssafy.test.service.HouseMapService;
import com.ssafy.test.service.SafetyService;


@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/safety")
public class SafetyMapController {
   
   @Autowired
   private HouseMapService service;
   
   @Autowired
   private SafetyService safetyService;
   
   @GetMapping("/safetyLevel")
   public ModelAndView houseSalesForm() {
      ModelAndView mv = new ModelAndView();
      mv.setViewName("safety/safetyMap");
      return mv;
   }

   @GetMapping("/type")
   public ModelAndView safetyForm() {
      ModelAndView mv = new ModelAndView();
      mv.setViewName("safety/safetyMap");
      return mv;
   }
   
   @GetMapping("/policeOffice")
   public List<PoliceOffice> getPoliceOffice(String dong) {
      List<PoliceOffice> list = null;
      
      try {
         list = safetyService.getPoliceOffice(dong);
//         System.out.println("police!!!!!!!");
         for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
         } 
//         
      } catch (Exception e) {
         e.printStackTrace();
      }
      
      return list;
   }
   
   @GetMapping("/shelter")
   public List<Shelter> getShelter(String dong) {
      List<Shelter> list = null;
      
      try {
//         System.out.println("shelter!!!!");
         list = safetyService.getShelter(dong);
         for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
         }
//         
      } catch (Exception e) {
         e.printStackTrace();
      }
      
      return list;
   }
   
   @GetMapping("/safetyBell")
   public List<SafetyBell> getSafetyBell(String dong) {
      List<SafetyBell> list = null;
      
      try {
//         System.out.println("safetyBell!!!");
         list = safetyService.getSafetyBell(dong);
          for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
         } 
//         
      } catch (Exception e) {
         e.printStackTrace();
      }
      
      return list;
   }
   
   @GetMapping("/safetyCenter")
   public List<SafetyCenter> getSafetyCenter(String dong) {
      List<SafetyCenter> list = null;
      
      try {
//         System.out.println("safeCenter!!!!");
         list = safetyService.getSafetyCenter(dong);
//         System.out.println("safetyCenter!!!");
         /* for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
         } */
//         
      } catch (Exception e) {
         e.printStackTrace();
      }
      
      return list;
   }
   
   @GetMapping("/fireStation")
   public List<FireStation> getFireStation(String dong) {
      List<FireStation> list = null;
      
      try {
//         System.out.println("fireStation!!!");
//         System.out.println("넘어옴!!!!!!!!!!!!!!!!!!!!");
         list = safetyService.getFireStation(dong);
//         for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).toString());
//         }
//         
      } catch (Exception e) {
         e.printStackTrace();
      }
      
      return list;
   }
   @GetMapping("/level")
   public List<SafeLevel> getTotalCnt(String dong) {
      List<SafeLevel> list = null;
      
      try {
         list = safetyService.getTotalCnt(dong);
         //System.out.println("totalcnt!!!!!!!");  
      } catch (Exception e) {
         e.printStackTrace();
      }
      
      return list;
   }
}