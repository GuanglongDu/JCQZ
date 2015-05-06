package com.qcqz.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.qcqz.pageModel.Json;
import com.qcqz.pageModel.Student;
import com.qcqz.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController extends BaseController {
	@Autowired
	private StudentService studentService;
	

	@RequestMapping(value = "/deleteStudent", method = RequestMethod.POST)
	@ResponseBody
	public Object deleteStudent(Student user){
		Json j = new Json();
		studentService.delete(user.getIds());
		j.setSuccess(true);
		j.setMsg("删除成功!");
		return j;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Object addStudent(Student user) {
		Json j = new Json();
		try {
			studentService.save(user);
			j.setMsg("添加成功！");
			j.setSuccess(true);
		} catch (Exception e) {
			j.setMsg(e.getLocalizedMessage());
		}
		return j;
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public Object editStudent(Student user) {
		Json j = new Json();
		try {
			studentService.update(user);
			j.setSuccess(true);
			j.setMsg("编辑成功！");
		} catch (Exception e) {
			j.setMsg("编辑失败，用户名已存在！");
		}
		return j;
	}
	
	
	@RequestMapping(value = "/studentAdd", method = RequestMethod.GET)
	public ModelAndView studentAdd(HttpServletRequest request){
		return new ModelAndView("/dataEnter/studentDataAdd");
	}
	
	@RequestMapping(value = "/studentEdit", method = RequestMethod.GET)
	public ModelAndView studentEdit(HttpServletRequest request){
		return new ModelAndView("/dataEnter/studentDataEdit");
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	@ResponseBody
	public Object datagrid(Student student) {
		return studentService.datagrid(student);
	}
}
