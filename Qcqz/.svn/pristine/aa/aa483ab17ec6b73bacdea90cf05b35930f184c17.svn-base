package com.qcqz.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.qcqz.pageModel.Dept;
import com.qcqz.pageModel.Json;
import com.qcqz.service.DeptService;
@Controller
@RequestMapping("/dept")
public class DeptController extends BaseController {

	@Autowired
	private DeptService deptService;
	
	@RequestMapping(value = "/doNotNeedSession_treeRecursive", method = RequestMethod.POST)
	@ResponseBody
	public Object doNotNeedSession_treeRecursive(Dept dept) {
		return generateJson(deptService.tree(dept, true));
	}
	
	@RequestMapping(value = "/doNotNeedSession_tree", method = RequestMethod.POST)
	@ResponseBody
	public Object doNotNeedSession_tree(Dept dept) {
		return deptService.tree(dept, false);
	}
	
	@RequestMapping(value = "/deptEdit", method = RequestMethod.GET)
	public ModelAndView deptEdit(HttpServletRequest request){
		return new ModelAndView("/admin/deptEdit");
	}
	
	@RequestMapping(value = "/deptAdd", method = RequestMethod.GET)
	public ModelAndView deptAdd(HttpServletRequest request){
		return new ModelAndView("/admin/deptAdd");
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.POST)
	@ResponseBody
	public Object getAll(Dept dept) {
		return generateJson(deptService.treegrid(dept));
	}
	
	@RequestMapping(value = "/deleteDept", method = RequestMethod.POST)
	@ResponseBody
	public Object delete(Dept dept) {
		Json j = new Json();
		try {
			deptService.delete(dept);
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
	public Object add(Dept dept) {
		Json j = new Json();
		try {
			deptService.add(dept);
			j.setSuccess(true);
			j.setMsg("添加成功！");
		} catch (Exception e) {
			j.setMsg("添加失败！");
		}
		return j;
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public Object edit(Dept dept) {
		Json j = new Json();
		try {
			deptService.edit(dept);
			j.setSuccess(true);
			j.setMsg("编辑成功!");
		} catch (Exception e) {
			j.setMsg("编辑失败！");
		}
		return j;
	}
}