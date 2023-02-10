package spring.mybatis;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	
	@Autowired
	@Qualifier("service")
	MemberService service;
	
	@RequestMapping("/")
	public String start() {
		return "mybatis/start";
	}
	
	@GetMapping("/login")
	public String login() {
		return "mybatis/loginform";
	}
	
	@PostMapping("/login")
	public String login2(String id, String pw, HttpSession session) {
		MemberDTO dto = service.onemember(id);
		String view = "";
		if(dto == null) {
			//회원가입화면 보여주는 컨트롤러 url
			view="mybatis/memberinsert";
		}else {
			if(pw.equals(dto.getPw())) {
				//로그인
				session.setAttribute("loginid", id);
				view="mybatis/start";
			}else {
				//암호 다르다
				view="mybatis/loginform";
			}
		}
		return view;
	}
	
	@RequestMapping("/mybatismemberlist")
	public ModelAndView memberlist() {
		List<MemberDTO> memberlist = service.memberlist();
		ModelAndView mv = new ModelAndView();
		mv.addObject("memberlist", memberlist);
		mv.setViewName("mybatis/memberlist");
		return mv;
	}
	
	@GetMapping("/memberinsert")
	public String memberinsert() {
		return "mybatis/memberinsert";
	}
	
	
	@PostMapping("/memberinsert")
	public ModelAndView memberinsert(MemberDTO dto) {
		//dto객체 저장값(폼 사용자값) member테이블에 저장
		//저장한 결과 int로 리턴.  
		//1->"정상 회원 가입 처리" => 모델로 저장
		//mybatis/memberinsert2 뷰
		MemberDTO db_dto = service.onemember(dto.getId());
		ModelAndView mv = new ModelAndView(); 
		String insertresult ="";
		if(db_dto == null) {
			int row = service.insertmember(dto);
			if(row==1) {
				insertresult="정상회원가입처리";
			}else {
				insertresult="회원가입처리오류발생";
			}
		}else{
			insertresult="이미 사용중인 아이디입니다.";
		}
		mv.addObject("insertresult","정상회원가입처리");
		mv.setViewName("mybatis/memberinsert2");
		return mv;
	}
	
	@RequestMapping("/memberinform")
	public ModelAndView memberinform(HttpSession session) {
//		1. HttpSession 객체에 저장된 loginid 값을 가져와서
//		2. MemberDTO <--service.onemember(loginid) 호출
//		3. 모델 저장
//		4. mybatis/memberinform 뷰
//		5. viwe - form태그로 출력. submit-내정보 수정
		
//		ModelAndView mv = new ModelAndView();
//		String id = (String)session.getAttribute("loginid");
//		System.out.println("================================="+id);
//		MemberDTO dto = service.onemember(id);
//		mv.addObject("dto",dto);
//		mv.setViewName("mybatis/memberinform");
//		return mv;
		///////////////////////////////////////////////////////////////
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("loginid") != null) {
			MemberDTO dto = service.onemember((String)session.getAttribute("loginid"));
			mv.addObject("dto",dto);
			mv.setViewName("mybatis/memberinform");
		}
		return mv;
		
	}

//post - /memberupdate
//1. 내정보 수정시 입력 정보 모두 가져온다.	
//2. updatemember2 id sql 실행
//-- service + serviceImpl + dao 메서드 추가
//4. "회원정보수정완료" 모델로 저장
//5. start.jsp 모델 출력 수정
	@PostMapping("/memberupdate")
	public ModelAndView memberupdate(MemberDTO dto) {
		ModelAndView mv = new ModelAndView();
		String result ="";
		int row = service.updatemember2(dto);
		if(row==1) {
			result="회원정보수정완료";
		}
		mv.addObject(dto);
		mv.addObject("updateresult",result);
		mv.setViewName("mybatis/start");
		return mv;
	}
	
//로그아웃
//	1. 세션에서 loginid속성값 읽는다.
//	2. 존재하면 세션ㅇ서 속성 없앤다. remove
//	3. start.jsp 이동
	@GetMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		System.out.println("======"+session.getAttribute("loginid"));
		session.removeAttribute("loginid");
		mv.setViewName("mybatis/start");
		return mv;
	}
	
	
//회원탈퇴
//	1. 세션에서 loginid속성값 읽는다
//	2. service.deletemember(loginid)
//	3. 2번 결과 1이면 "회원탈퇴정상처리" 모델(updateresult)로 저장 
//	4. start.jsp 이동
	@GetMapping("/memberdelete")
	public ModelAndView memberdelete(HttpSession session) {
		String updateresult = "";
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("loginid")!=null) {
			String id = (String)session.getAttribute("loginid");
			int row = service.deletemember(id);
			if(row == 1) {
				updateresult = "회원탈퇴정상처리";
			}else {
				updateresult="탈퇴실패";
			}			
		}
		mv.addObject("updateresult", updateresult);
		mv.setViewName("mybatis/start");
		return mv;
	}
	
}


















