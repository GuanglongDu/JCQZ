package com.qcqz.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qcqz.pageModel.Auth;
import com.qcqz.pageModel.SessionInfo;
import com.qcqz.pageModel.User;
import com.qcqz.service.AuthorityService;
import com.qcqz.service.UserService;
import com.qcqz.util.ResourceUtil;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

	@Autowired
	private UserService servicec;
	@Autowired
	private AuthorityService menuService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ResponseBody
	public String logIn(HttpServletRequest request) {
		String userName = request.getParameter("userName");
		String passwd = request.getParameter("passwd");
		 User user = new User();
		 user.setCname(userName);
		 user.setCpwd(passwd);
		User login = servicec.login(user);
		if(login != null){
			SessionInfo sessionInfo = new SessionInfo();
			sessionInfo.setUserId(login.getCid());
			sessionInfo.setLoginName(userName);
			sessionInfo.setLoginPassword(passwd);
			//sessionInfo.setMenus(menuService.findAll());
			sessionInfo.setAuthIds(login.getAuthIds());
			sessionInfo.setAuthNames(login.getAuthNames());
			sessionInfo.setRoleIds(login.getRoleIds());
			sessionInfo.setRoleNames(login.getRoleNames());
			sessionInfo.setAuthUrls(login.getAuthUrls());
			setSessionUser(request, login);
			request.getSession().setAttribute(ResourceUtil.getSessionInfoName(), sessionInfo);
		}else{
			request.setAttribute("msg", "提示：用户名或密码错误!");
			return "error";
		}
		
		return "login";
	}
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	@ResponseBody
	public String logOut(HttpServletRequest request){
		request.getSession().setAttribute(ResourceUtil.getSessionInfoName(), null);
		return "logout";
	}
	
	@RequestMapping(value = "/getAllMenus", method = RequestMethod.GET)
	@ResponseBody
	public Object getAllMenus(HttpServletRequest request){
		Auth menu = new Auth();
		SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute(ResourceUtil.getSessionInfoName());
		if(sessionInfo != null){
			if("admin".equals(sessionInfo.getLoginName())){
				return menuService.tree(menu, true);
			}else {
				String id = sessionInfo.getUserId();
				return servicec.getUserMenu(id);
			}
		}
		return new Object();
	}
}
