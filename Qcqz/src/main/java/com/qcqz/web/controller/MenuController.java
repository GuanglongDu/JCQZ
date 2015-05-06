package com.qcqz.web.controller;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.qcqz.pageModel.Auth;
import com.qcqz.pageModel.Json;
import com.qcqz.pageModel.Menu;
import com.qcqz.service.MenuService;

@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController {

	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value = "/doNotNeedSession_tree", method = RequestMethod.POST)
	@ResponseBody
	public Object doNotNeedSession_tree(Auth menu) {
		return menuService.tree(menu, false);
	}
	
	@RequestMapping(value = "/doNotNeedSession_treeRecursive", method = RequestMethod.POST)
	@ResponseBody
	public Object doNotNeedSession_treeRecursive(Auth menu) {
		return menuService.tree(menu, true);
	}
	
	@RequestMapping(value = "/menuEdit", method = RequestMethod.GET)
	public ModelAndView menuEdit(HttpServletRequest request){
		return new ModelAndView("/admin/menuEdit");
	}
	
	@RequestMapping(value = "/menuAdd", method = RequestMethod.GET)
	public ModelAndView menuAdd(HttpServletRequest request){
		return new ModelAndView("/admin/menuAdd");
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.POST)
	@ResponseBody
	public Object getAll(Auth menu) {
		return generateJson(menuService.treegrid(menu));
	}
	
	@RequestMapping(value = "/deleteMenu", method = RequestMethod.POST)
	@ResponseBody
	public Object delete(Auth menu) {
		Json j = new Json();
		try {
			menuService.delete(menu);
			j.setSuccess(true);
			j.setMsg("删除成功！");
			j.setObj(menu.getCid());
		} catch (Exception e) {
			j.setMsg("删除失败！");
		}
		return j;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Object add(Auth menu) {
		Json j = new Json();
		try {
			menuService.add(menu);
			j.setSuccess(true);
			j.setMsg("添加成功！");
		} catch (Exception e) {
			j.setMsg("添加失败！");
		}
		return j;
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public Object edit(Auth menu) {
		Json j = new Json();
		try {
			menuService.edit(menu);
			j.setSuccess(true);
			j.setMsg("编辑成功!");
		} catch (Exception e) {
			j.setMsg("编辑失败！");
		}
		return j;
	}

}
