package com.qcqz.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.qcqz.pageModel.Categority;
import com.qcqz.pageModel.Json;
import com.qcqz.service.CategoriesService;

@Controller
@RequestMapping("/categories")
public class CategoriesController extends BaseController {
	@Autowired
	private CategoriesService categoriesService;
	
	@RequestMapping(value = "/doNotNeedSession_combobox", method = RequestMethod.POST)
	@ResponseBody
	public Object doNotNeedSession_treeRecursive() {
		return categoriesService.combobox();
	}
	
	@RequestMapping(value = "/deleteCategories", method = RequestMethod.POST)
	@ResponseBody
	public Object deleteCategories(Categority categority){
		Json j = new Json();
		categoriesService.delete(categority.getCid());
		j.setSuccess(true);
		j.setMsg("删除成功!");
		return j;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Object addCategories(Categority categority) {
		Json j = new Json();
		try {
			categoriesService.save(categority);
			j.setMsg("添加成功！");
			j.setSuccess(true);
		} catch (Exception e) {
			j.setMsg(e.getLocalizedMessage());
		}
		return j;
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public Object editCategories(Categority categority) {
		Json j = new Json();
		try {
			categoriesService.update(categority);
			j.setSuccess(true);
			j.setMsg("编辑成功！");
		} catch (Exception e) {
			j.setMsg("编辑失败，用户名已存在！");
		}
		return j;
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	@ResponseBody
	public Object datagrid(Categority categority) {
		return categoriesService.datagrid(categority);
	}
	
	@RequestMapping(value = "/addCategories", method = RequestMethod.GET)
	public ModelAndView addCategories(HttpServletRequest request){
		return new ModelAndView("/dataEnter/categoriesAdd");
	}
	
	@RequestMapping(value = "/editCategories", method = RequestMethod.GET)
	public ModelAndView editCategories(HttpServletRequest request){
		return new ModelAndView("/dataEnter/categoriesEdit");
	}
}
