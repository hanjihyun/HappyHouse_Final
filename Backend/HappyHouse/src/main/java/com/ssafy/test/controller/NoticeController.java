package com.ssafy.test.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.test.dto.MemberDto;
import com.ssafy.test.dto.NoticeDto;
import com.ssafy.test.service.NoticeService;
import com.ssafy.test.service.NoticeServiceImpl;
import com.ssafy.test.util.PageNavigation;


@Controller
@RequestMapping("/notice")
public class NoticeController{
 
   @Autowired
   private NoticeService noticeService;
   
   @GetMapping("/noticeList")
   public String listNotice(Model model,@RequestParam Map<String, String> map) {
	   String spp = map.get("spp");
		map.put("spp", spp != null ? spp : "3");//sizePerPage

		String pg = map.get("pg");
		map.put("pg", pg != null ? pg : "1");
		
      try {
         List<NoticeDto> list = noticeService.listNotice(map);
         PageNavigation pageNavigation = noticeService.makePageNavigation(map);
         model.addAttribute("navigation", pageNavigation);
         model.addAttribute("notices", list);
         //model.addAttribute("navigation", pageNavigation);
         return "notice/noticeList";
      } catch (Exception e) {
         e.printStackTrace();
         model.addAttribute("msg", "글목록을 얻어오는 중 문제가 발생했습니다.");
         return "error/error";
      }
   }
   
   @GetMapping("/detailNotice")
   private ModelAndView detailNotice(ModelAndView mv, String no)
         throws ServletException, IOException {
      int noticeNo = Integer.parseInt(no);
      NoticeDto noticeDto = null;
      try {
         noticeDto = noticeService.detailNotice(noticeNo);
         
      } catch (SQLException e) {
         e.printStackTrace();
         mv.addObject("msg", "글목록을 얻어오는 중 문제가 발생했습니다.");
      }
      mv.addObject("detailNotice", noticeDto);
      mv.setViewName("notice/detailNotice");
      return mv;
   }
   
   @GetMapping("/deleteNotice")
   private String deleteNotice(String no, Model model, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String msg = "";
      int noticeNo = Integer.parseInt(no);
      MemberDto memberDto = (MemberDto) session.getAttribute("memberInfo");
      String userid = memberDto.getUserid();
      
      Map<String, Object> param = new HashMap<String, Object>();
      param.put("userid",userid);
      param.put("noticeNo",noticeNo);
      try {
      noticeService.deleteNotice(param);
      msg = "공지사항 삭제 완료";
      model.addAttribute("msg", msg);
      return "redirect:/notice/noticeList";
   } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      msg = "탈퇴 중 문제가 발생했습니다.";
        model.addAttribute("msg", msg);
   }
      
      return "redirect:/notice/noticeList";
   }
   
   @GetMapping("/updateNotice")
   private ModelAndView updateNotice(ModelAndView mv, String no)
         throws ServletException, IOException {
      int noticeNo = Integer.parseInt(no);
      NoticeDto noticeDto = null;
      try {
         noticeDto = noticeService.detailNotice(noticeNo);
         
      } catch (SQLException e) {
         e.printStackTrace();
         mv.addObject("msg", "글목록을 얻어오는 중 문제가 발생했습니다.");
      }
      mv.addObject("detailNotice", noticeDto);
      mv.setViewName("notice/updateNotice");
      return mv;
   }
   
   @PostMapping("/modifyNotice")
   private String modifyNotice(@RequestParam Map<String, String> map,Model model) {

      Map<String, String> param = new HashMap<String, String>();
//      System.out.println(map.get("title"));
//      System.out.println(map.get("content"));
      param.put("title",map.get("title"));
      param.put("content",map.get("content"));
      try {
      noticeService.modifyNotice(param);
      return "redirect:/notice/noticeList";
   } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
   }
      return "/eror/error";
   }
   
   @GetMapping("/writeNotice")
   private void writeNoticeForm() {}
  
   @PostMapping("/writeNotice")
   private String writeNotice(@RequestParam Map<String, String> map, HttpSession session) {
      
      MemberDto memberDto = (MemberDto) session.getAttribute("memberInfo");
      String userid = memberDto.getUserid();
      Map<String, String> param = new HashMap<String, String>();
      param.put("title",map.get("title"));
      param.put("content",map.get("content"));
      param.put("writer",userid);
      
      try {
      noticeService.writeNotice(param);
      return "redirect:/notice/noticeList";
   } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
   }
      return "/error/error";
   }

}





