package com.qcqz.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.qcqz.pageModel.Json;
import com.qcqz.pageModel.User;
import com.qcqz.service.RoleService;
import com.qcqz.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	

	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	@ResponseBody
	public Object deleteUser(User user){
		Json j = new Json();
		userService.delete(user.getIds());
		j.setSuccess(true);
		j.setMsg("删除成功!");
		return j;
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	@ResponseBody
	public Object addUser(User user) {
		Json j = new Json();
		try {
			userService.save(user);
			j.setMsg("添加成功！");
			j.setSuccess(true);
		} catch (Exception e) {
			j.setMsg(e.getLocalizedMessage());
		}
		return j;
	}
	
	@RequestMapping(value = "/editUser", method = RequestMethod.POST)
	@ResponseBody
	public Object editUser(User user) {
		Json j = new Json();
		try {
			userService.update(user);
			j.setSuccess(true);
			j.setMsg("编辑成功！");
		} catch (Exception e) {
			j.setMsg("编辑失败，用户名已存在！");
		}
		return j;
	}
	
	@RequestMapping(value = "/isAddUser", method = RequestMethod.GET)
	public ModelAndView isAddUser(HttpServletRequest request){
		return new ModelAndView("/admin/userAdd");
	}
	
	@RequestMapping(value = "/isEditUser", method = RequestMethod.GET)
	public ModelAndView isEditUser(HttpServletRequest request){
		return new ModelAndView("/admin/userEdit");
	}
	
	@RequestMapping(value = "/userMenu", method = RequestMethod.POST)
	public ModelAndView userMenu(HttpServletRequest request){
		return new ModelAndView("/userControl");
	}
	
	@RequestMapping(value = "/userRoleEdit", method = RequestMethod.GET)
	public ModelAndView userRoleEdit(HttpServletRequest request){
		return new ModelAndView("/admin/userRoleEdit");
	}
	
	@RequestMapping(value = "/roleEdit", method = RequestMethod.POST)
	@ResponseBody
	public Object roleEdit(User user) {
		Json j = new Json();
		try {
			userService.roleEdit(user);
			j.setSuccess(true);
			j.setMsg("编辑成功！");
		} catch (Exception e) {
		
			j.setMsg("编辑失败！");
		}
		return j;
	}

	
	@RequestMapping(value = "/allUser", method = RequestMethod.GET)
	@ResponseBody
	public Object datagrid(User user) {
		return this.generateJson(userService.datagrid(user));
	}
	
	
}
