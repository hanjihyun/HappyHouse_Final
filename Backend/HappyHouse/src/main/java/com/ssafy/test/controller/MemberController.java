package com.ssafy.test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.test.dto.MemberDto;
import com.ssafy.test.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private MemberService memberService;

	@GetMapping("/findPW")
	public void findPWform() {
	}

	@GetMapping("/myPage")
	public void mypageForm() {
	}

	@PostMapping("/updateMyInfo")
	private String updateMyInfo(@RequestParam Map<String, String> map, Model model, HttpSession session) {
		MemberDto memberDto = (MemberDto) session.getAttribute("memberInfo");
		String userid = memberDto.getUserid();

		map.put("userid", userid);
		map.put("userpwd", map.get("userpwd1"));
		map.put("username", map.get("username"));
		map.put("phone", map.get("phone"));
		map.put("email", map.get("email"));

		try {
			memberService.updateMyInfo(map);
			// MemberDto member = memberService.login(map);
			// session.setAttribute("memberInfo",member);
			return "redirect:/index";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("msg", "회원정보 수정 도중 문제가 발생했습니다.");
		}
		return "/error/error";
	}

	@GetMapping("/join")
	public void joinForm() {
	}

	@PostMapping("/join")
	public ModelAndView signup(MemberDto member, ModelAndView mv) throws Exception {
		try {
			memberService.signup(member);
			// mv.addObject("cnt", insert);
			mv.setViewName("redirect:/index");
		} catch (RuntimeException e) {
			mv.addObject("msg", "회원가입 실패");
			mv.setViewName("/error/error");
		}

		return mv;
	}

	@GetMapping("/deleteMember")
	private String deleteMember(Model model, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String msg = "";

		MemberDto memberDto = (MemberDto) session.getAttribute("memberInfo");
		String userid = memberDto.getUserid();
		String userpw = memberDto.getUserpwd();

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userid", userid);
		param.put("cnt", -1);

//		System.out.println(userid);
		try {
			memberService.deleteMember(param);
			Cookie cookies[] = request.getCookies();
			if (cookies != null) { // 쿠키 삭제
				for (Cookie cookie : cookies) {
					if ("ssafy_id".equals(cookie.getName())) {
						cookie.setMaxAge(0);
						response.addCookie(cookie);
						break;
					}
				}
			}
			msg = "회원 탈퇴 완료";
			model.addAttribute("msg", msg);
			session.invalidate();
			return "/common/msg";
		} catch (Exception e) {
			e.printStackTrace();
			msg = "탈퇴 중 문제가 발생했습니다.";
			model.addAttribute("msg", msg);
		}

		return "/error/error";
	}

	@GetMapping("/deleteMemberForm")
	private String deleteMemberPage() {
		return "member/deleteMemberForm";
	}

	@GetMapping("/logout")
	   public String logout(HttpSession session) {
	      session.invalidate();
	      return "redirect:/index";
	   }


	@PostMapping("/login")
	public String login(MemberDto m, HttpServletRequest request, @RequestParam Map<String, String> map, Model model,
			HttpSession session, HttpServletResponse response) {
		try {
			MemberDto member = memberService.login(m);
			if (member != null) {

				session.setAttribute("memberInfo", member);

				Cookie cookie = new Cookie("ssafy_id", member.getUserid());
				cookie.setPath("/");
				if ("saveok".equals(map.get("store"))) {
					cookie.setMaxAge(60 * 60 * 24 * 365 * 40);// 40년간 저장.
				} else {
					cookie.setMaxAge(0);
				}
				response.addCookie(cookie);

			} // 로그인 실패시
			else {
				model.addAttribute("msg", "아이디 또는 패스워드가 다릅니다.");
				return "common/msg";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "로그인 중 문제가 발생했습니다.");
			return "common/msg";
		}
		return "index";
	}
	@RequestMapping("/googleLogin")
	   public String googleLogin(@RequestParam("gemail") String gemail,
	            @RequestParam("guserid") String guserid,
	            @RequestParam("gusername") String gusername,
	            ModelAndView mv,HttpServletRequest request, HttpSession session) {
//	      System.out.println(guserid+" "+gusername+" "+gemail);
	      MemberDto member = memberService.searchGoogle(gemail);
	      if(member != null) { // gmail로 이미 가입되어있는 경우
	         session.setAttribute("memberInfo", member);
	      }else { // gmail로 가입 안되어 있는 경우
	         Map<String,Object> map = new HashMap<>();
	         map.put("gemail", gemail);
	         map.put("gusername", gusername);
	         try { 
	            member = memberService.googleSignup(map);
	            session.setAttribute("memberInfo", member);
	            
	         } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }
	         
	      }
//	      System.out.println(member.toString());
	      mv.setViewName("redirect:/index");
	      return "redirect:/index";
	}
	
//   admin page
	@GetMapping("/memberInfo")
	public String listNotice(Model model) {
		try {
			List<MemberDto> list = memberService.listMember();
			// PageNavigation pageNavigation = noticeService.makePageNavigation(map);
			model.addAttribute("members", list);
			// model.addAttribute("navigation", pageNavigation);
			return "member/memberInfo";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "글목록을 얻어오는 중 문제가 발생했습니다.");
			return "error/error";
		}
	}

	@GetMapping("/deleteMemberById")
	private String deleteMemberById(String userid, Model model, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String msg = "";

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userid", userid);
		param.put("cnt", -1);

//		System.out.println(userid);
		try {
			memberService.deleteMember(param);
			msg = "회원 탈퇴 완료";
			model.addAttribute("msg", msg);
			return "redirect:/member/memberInfo";
		} catch (Exception e) {
			e.printStackTrace();
			msg = "탈퇴 중 문제가 발생했습니다.";
			model.addAttribute("msg", msg);
		}

		return "/error/error";
	}

	@PostMapping("/searchMember")
	private String searchMember(@RequestParam Map<String, String> map, Model model) {

		Map<String, String> param = new HashMap<String, String>();
		String searchKey = map.get("searchKey");
		String searchWord = map.get("searchWord");
		param.put("searchKey", searchKey);
		param.put("searchWord", searchWord);
		try {
			List<MemberDto> list = null;
			if (searchKey.equals("all")) {
				list = memberService.searchMember(param);
			} else if (searchKey.equals("userid")) {
				list = memberService.searchMemberById(param);
			} else {
				list = memberService.searchMemberByName(param);
			}
			model.addAttribute("searchKey", searchKey);
			model.addAttribute("searchWord", searchWord);
			model.addAttribute("members", list);
			return "member/searchMember";

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/error/error";
	}

	@GetMapping("/searchEmail/{email}/{userid}")
	public @ResponseBody String searchEmail(@PathVariable String email, @PathVariable String userid) {
//		System.out.println(email);

		Map<String, String> map = new HashMap<String, String>();
		map.put("email", email);
		map.put("userid", userid);
		String st = "";
		MemberDto member = null;
		try {
			member = memberService.searchEmail(map);
			if (member != null) {
				st = "1";
			} else {
				st = "0";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			st = "0";
		}

		return st;
	}

	@RequestMapping("/sendEmailAction")
	public ModelAndView sendEmailAction(@RequestParam String email, HttpServletResponse response) throws IOException {
		ModelAndView mv = new ModelAndView();
		Random r = new Random();
		int dice = r.nextInt(157211) + 48271;
		String setfrom = "gkswlgus96@gmail.com";
		String tomail = email; // 받는 사람의 이메일
		String title = "비밀번호 인증 메일 입니다."; // 제목
		String content = "안녕하세요 회원님 저희 홈페이지를 찾아주셔서 감사합니다." + "비밀번호 찾기 인증번호는 " + dice + " 입니다. "
				+ "받으신 인증번호를 홈페이지에 입력해 주시면 다음으로 넘어갑니다.";
		// 내용
		try {

			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

			messageHelper.setFrom(setfrom); // 보내는사람 생략하면 정상작동을 안함
			messageHelper.setTo(tomail); // 받는사람 이메일
			messageHelper.setSubject(title);
			// 메일제목은 생략이 가능하다
			messageHelper.setText(content); // 메일 내용

			mailSender.send(message);

		} catch (Exception e) {
			e.printStackTrace();
//			System.out.println(e);
		}

		mv.addObject("dice", dice);
		mv.addObject("email", email);
		mv.setViewName("/member/pswEmailCode"); // 뷰의이름
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out_email = response.getWriter();
		out_email.println("<script>alert('이메일이 발송되었습니다. 인증번호를 확인해주세요!');</script>");
		out_email.flush();
		return mv;

	}

	@RequestMapping("/injeungNumChk")
	public ModelAndView injeungNumberChk(@RequestParam("memberEmail") String memberEmail,
			@RequestParam("injeungNum") String injeungNum, @RequestParam("pswcode") String pswcode,
			HttpServletResponse response, ModelAndView mv) throws IOException {

		/*
		 * System.out.println("마지막 : injeungNum : "+injeungNum);
		 * 
		 * System.out.println("마지막 : pswcode : "+pswcode);
		 * System.out.println("마지막 : memberEmail : "+memberEmail);
		 */

		mv.setViewName("member/changePW");
		mv.addObject("memberEmail", memberEmail);

		if (injeungNum.equals(pswcode)) {
			// pswcode : 내가 쓴 인증번호
			// 인증번호가 일치할 경우 인증번호가 맞다는 창을 출력하고 비밀번호 변경창으로 이동시킨다

			mv.setViewName("member/changePW");
			mv.addObject("memberEmail", memberEmail);

			// 만약 인증번호가 같다면 이메일을 비밀번호 변경 페이지로 넘기고, 활용할 수 있도록 한다.

			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out_equals = response.getWriter();
			out_equals.println("<script>alert('인증번호가 일치하였습니다. 비밀번호 변경하고 이용하세요');</script>");
			out_equals.flush();

			return mv;

		} else if (injeungNum != pswcode) {

			ModelAndView mv2 = new ModelAndView();

			mv2.setViewName("member/pswEmailCode");

			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out_equals = response.getWriter();
			out_equals.println("<script>alert('인증번호가 일치하지않습니다. 인증번호를 다시 확인해주세요.'); history.back();</script>");
			out_equals.flush();

			return mv2;

		}

		return mv;

	}

	@RequestMapping("/changePW")
	public void changePW() {
	}
	@PostMapping("/changePWUpdate")
	public String changePWUpdate(String userpwd,String memberEmail,Model model) {
//		System.out.println(userpwd);
//		System.out.println(memberEmail);
		Map<String, String> map = new HashMap<String, String>();
		map.put("email", memberEmail);
		map.put("userpwd", userpwd);
	
		try {
			memberService.changePWUpdate(map);
			
			return "redirect:/index";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("msg", "회원정보 수정 도중 문제가 발생했습니다.");
		}
		return "/error/error";
	}
	@GetMapping("/sendEmailCode/{email}")
	   public @ResponseBody int sendEmailCode(@PathVariable String email) { 
	      Random r = new Random();
	      int dice = r.nextInt(157211) + 48271;
	      String setfrom = "HappyHouse";
	      String tomail = email; // 받는 사람의 이메일
	      String title = "이메일 인증 메일 입니다."; // 제목
	      String content = "안녕하세요 회원님 저희 홈페이지를 찾아주셔서 감사합니다." + "비밀번호 찾기 인증번호는 " + dice + " 입니다. "
	            + "받으신 인증번호를 홈페이지에 입력해 주시면 다음으로 넘어갑니다.";
	      // 내용
	      try {

	         MimeMessage message = mailSender.createMimeMessage();
	         MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

	         messageHelper.setFrom(setfrom); // 보내는사람 생략하면 정상작동을 안함
	         messageHelper.setTo(tomail); // 받는사람 이메일
	         messageHelper.setSubject(title);
	         // 메일제목은 생략이 가능하다
	         messageHelper.setText(content); // 메일 내용

	         mailSender.send(message);

	      } catch (Exception e) {
	    	  e.printStackTrace();
//	         System.out.println(e);
	      }

	      return dice;
	   }
}