package kr.co.softcampus.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.softcampus.beans.BoardInfoBean;
import kr.co.softcampus.beans.UserBean;
import kr.co.softcampus.service.TopMenuService;

public class TopMenuInterceptor implements HandlerInterceptor {
	
	private TopMenuService topMenuService;
	
	private UserBean loginUserBean;
	
	public TopMenuInterceptor(TopMenuService topMenuService,UserBean loginUserBean) {
		this.topMenuService=topMenuService;
		this.loginUserBean=loginUserBean;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		// 인터셉터에서는 자동주입 autowired를 통해 빈을 자동 주입 받을 수 없다.
		// 그래서 인터셉터를 등록하는 쪽에서 빈을 주입받은 후 생성자로 넘겨서 작업해야한다.
		// 그러면 ServletappContext에서 autowired로 생성한 다음 TopMenuInterceptor로 주소값을 받아 쓰겠다는 말이다
		List<BoardInfoBean> topMenuList=topMenuService.getTopMenuList();
		request.setAttribute("topMenuList", topMenuList);
		request.setAttribute("loginUserBean", loginUserBean);
		return true;
	}
}
