//package com.qcqz.web.controller;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.qcqz.pageModel.Group;
//import com.qcqz.pageModel.Json;
//
//@Controller
//@RequestMapping("/group")
//public class GroupController extends BaseController{
//
//	@Autowired
//	private GroupService groupService;
//	
//
//	@RequestMapping(value = "/groupEdit", method = RequestMethod.GET)
//	public ModelAndView menuEdit(HttpServletRequest request){
//		return new ModelAndView("/dataEnter/groupEdit");
//	}
//	
//	@RequestMapping(value = "/groupAdd", method = RequestMethod.GET)
//	public ModelAndView menuAdd(HttpServletRequest request){
//		return new ModelAndView("/dataEnter/groupAdd");
//	}
//	
//	@RequestMapping(value = "/getAll", method = RequestMethod.POST)
//	@ResponseBody
//	public Object getAll(Group group) {
//		return generateJson(groupService.combobox(group));
//	}
//	@RequestMapping(value = "/getGroupBytpropertyId", method = RequestMethod.GET)
//	@ResponseBody
//	public Object getGroupBytpropertyId(HttpServletRequest request) {
//		String tpropertyId = request.getParameter("tpropertyId");
//		Group group = new Group();
//		group.setTpropertyId(tpropertyId);
//		return generateJson(groupService.combobox(group));
//	}
//	@RequestMapping(value = "/deleteGroup", method = RequestMethod.POST)
//	@ResponseBody
//	public Object delete(Group group) {
//		Json j = new Json();
//		try {
//			groupService.delete(group);
//			j.setSuccess(true);
//			j.setMsg("删除成功！");
//			j.setObj(group.getCid());
//		} catch (Exception e) {
//			j.setMsg("删除失败！");
//		}
//		return j;
//	}
//	
//	@RequestMapping(value = "/add", method = RequestMethod.POST)
//	@ResponseBody
//	public Object add(Group group) {
//		Json j = new Json();
//		try {
//			groupService.add(group);
//			j.setSuccess(true);
//			j.setMsg("添加成功！");
//		} catch (Exception e) {
//			j.setMsg("添加失败！");
//		}
//		return j;
//	}
//	
//	@RequestMapping(value = "/edit", method = RequestMethod.POST)
//	@ResponseBody
//	public Object edit(Group group) {
//		Json j = new Json();
//		try {
//			groupService.edit(group);
//			j.setSuccess(true);
//			j.setMsg("编辑成功!");
//		} catch (Exception e) {
//			j.setMsg("编辑失败！");
//		}
//		return j;
//	}
//
//}
