package com.qcqz.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.qcqz.pageModel.Json;
import com.qcqz.pageModel.UserClass;
import com.qcqz.service.ClassService;

@Controller
@RequestMapping("/nclass")
public class ClassController extends BaseController {
	@Autowired
	private ClassService classService;
	

	@RequestMapping(value = "/doNotNeedSession_treeRecursive", method = RequestMethod.POST)
	@ResponseBody
	public Object doNotNeedSession_treeRecursive(UserClass dept) {
		return classService.tree(dept, true);
	}
	
	@RequestMapping(value = "/doNotNeedSession_tree", method = RequestMethod.POST)
	@ResponseBody
	public Object doNotNeedSession_tree(UserClass dept) {
		return classService.tree(dept, false);
	}
	
	@RequestMapping(value = "/classEdit", method = RequestMethod.GET)
	public ModelAndView classEdit(HttpServletRequest request){
		return new ModelAndView("/dataEnter/classEdit");
	}
	
	@RequestMapping(value = "/classAdd", method = RequestMethod.GET)
	public ModelAndView classAdd(HttpServletRequest request){
		return new ModelAndView("/dataEnter/classAdd");
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.POST)
	@ResponseBody
	public Object getAll(UserClass dept) {
		return generateJson(classService.treegrid(dept));
	}
	
	@RequestMapping(value = "/deleteClass", method = RequestMethod.POST)
	@ResponseBody
	public Object delete(UserClass dept) {
		Json j = new Json();
		try {
			classService.delete(dept);
			j.setSuccess(true);
			j.setMsg("删除成功！");
			j.setObj(dept.getCid());
		} catch (Exception e) {
			j.setMsg("删除失败！部门已使用!");
		}
		return j;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Object add(UserClass dept) {
		Json j = new Json();
		try {
			classService.add(dept);
			j.setSuccess(true);
			j.setMsg("添加成功！");
		} catch (Exception e) {
			j.setMsg("添加失败！");
		}
		return j;
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public Object edit(UserClass dept) {
		Json j = new Json();
		try {
			classService.edit(dept);
			j.setSuccess(true);
			j.setMsg("编辑成功!");
		} catch (Exception e) {
			j.setMsg("编辑失败！");
		}
		return j;
	}
}
