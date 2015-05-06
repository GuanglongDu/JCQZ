package com.qcqz.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.qcqz.pageModel.Json;
import com.qcqz.pageModel.Role;
import com.qcqz.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {

	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value = "/doNotNeedSession_combobox", method = RequestMethod.POST)
	@ResponseBody
	public Object doNotNeedSession_treeRecursive() {
		return roleService.combobox();
	}
	@RequestMapping(value = "/allRole", method = RequestMethod.POST)
	@ResponseBody
	public Object allRole(Role role){
		return generateJson(roleService.datagrid(role));
	}
	
	@RequestMapping(value = "/roleEdit", method = RequestMethod.GET)
	public ModelAndView roleEdit(HttpServletRequest request){
		return new ModelAndView("/admin/roleEdit");
	}
	
	@RequestMapping(value = "/roleAdd", method = RequestMethod.GET)
	public ModelAndView roleAdd(HttpServletRequest request){
		return new ModelAndView("/admin/roleAdd");
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public Object editRole(Role role) {
		Json j = new Json();
		try {
			roleService.edit(role);
			j.setSuccess(true);
			j.setMsg("编辑成功！");
		} catch (Exception e) {
			j.setMsg("编辑失败，用户名已存在！");
		}
		return j;
	}
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Object add(Role role) {
		Json j = new Json();
		try {
			roleService.add(role);
			j.setSuccess(true);
			j.setMsg("添加成功！");
		} catch (Exception e) {
			j.setMsg("添加失败！");
		}
		return j;
	}

	@RequestMapping(value = "/deleteRole", method = RequestMethod.POST)
	@ResponseBody
	public Object delete(Role role) {
		Json j = new Json();
		roleService.delete(role.getIds());
		j.setSuccess(true);
		j.setMsg("删除成功！");
		return j;
	}

}
