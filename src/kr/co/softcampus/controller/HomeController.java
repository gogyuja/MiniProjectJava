package kr.co.softcampus.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	//@Resource(name="loginUserBean")
	//private UserBean loginUserBean;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
	//	System.out.println(loginUserBean);
		
		//실제 컴퓨터상에서의 물리적인 경로를 확인할수있다.
		//System.out.println(request.getServletContext().getRealPath("/"));
		//실제 서비스 에서는 서버의 경로를 적어주면 되지만 이클립스상에서는 이클립스 경로를 이런식으로 알아서 설정
		return "redirect:/main";
	}
}