package com.qcqz.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.qcqz.pageModel.SessionInfo;
import com.qcqz.util.RequestUtil;
import com.qcqz.util.ResourceUtil;
@Repository
public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute(ResourceUtil.getSessionInfoName());
		if(sessionInfo != null){
		if (sessionInfo.getLoginName().equals("admin")) {
			return true;
		}
		String requestPath = RequestUtil.getRequestPath(request);
		String authUrls = sessionInfo.getAuthUrls();
		boolean b = false;
		for (String url : authUrls.split(",")) {
			if (requestPath.equals(url)) {
				b = true;
				break;
			}
		}
		if (b) {
			return true;
		}
		
		request.setAttribute("msg", "您没有访问此功能的权限！权限路径为[" + requestPath + "]请联系管理员给你赋予相应权限。");
		}
		return false;
	}
	
}
