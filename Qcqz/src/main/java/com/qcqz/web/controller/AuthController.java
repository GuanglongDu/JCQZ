package com.qcqz.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.qcqz.pageModel.Auth;
import com.qcqz.pageModel.Json;
import com.qcqz.service.AuthorityService;

@Controller
@RequestMapping("/auth")
public class AuthController extends BaseController {
	
	@Autowired
	private AuthorityService authService;
	
	@RequestMapping(value = "/doNotNeedSession_tree", method = RequestMethod.POST)
	@ResponseBody
	public Object doNotNeedSession_tree(Auth auth) {
		return authService.tree(auth, false);
	}

	@RequestMapping(value = "/doNotNeedSession_treeRecursive", method = RequestMethod.POST)
	@ResponseBody
	public Object doNotNeedSession_treeRecursive(Auth auth) {
		return authService.tree(auth, true);
	}
	@RequestMapping(value = "/authEdit", method = RequestMethod.GET)
	public ModelAndView authEdit(HttpServletRequest request){
		return new ModelAndView("/admin/authEdit");
	}
	
	@RequestMapping(value = "/authAdd", method = RequestMethod.GET)
	public ModelAndView authAdd(HttpServletRequest request){
		return new ModelAndView("/admin/authAdd");
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.POST)
	@ResponseBody
	public Object getAll(Auth auth) {
		return generateJson(authService.treegrid(auth));
	}
	@RequestMapping(value = "/deleteAuth", method = RequestMethod.POST)
	@ResponseBody
	public Object delete(Auth auth) {
		Json j = new Json();
		try {
			authService.delete(auth);
			j.setSuccess(true);
			j.setMsg("删除成功！");
			j.setObj(auth.getCid());
		} catch (Exception e) {
			j.setMsg("删除失败！");
		}
		return j;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public Object edit(Auth auth) {
		Json j = new Json();
		try {
			authService.edit(auth);
			j.setSuccess(true);
			j.setMsg("编辑成功!");
		} catch (Exception e) {
			j.setMsg("编辑失败！");
		}
		return j;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Object add(Auth auth) {
		Json j = new Json();
		try {
			authService.add(auth);
			j.setSuccess(true);
			j.setMsg("添加成功!");
		} catch (Exception e) {
			j.setMsg("添加失败！");
		}
		return j;
	}
}
