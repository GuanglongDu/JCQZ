package com.qcqz.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qcqz.pageModel.Json;
import com.qcqz.pageModel.Test;
import com.qcqz.service.TestService;

@Controller
@RequestMapping("/test")
public class TestController  extends BaseController {
	@Autowired
	private TestService service;
	
	@RequestMapping(value = "/addTest", method = RequestMethod.POST)
	@ResponseBody
	public Object addTest(Test test){
		Json j = new Json();
		try {
			service.addTest(test);
			j.setMsg("添加成功！");
			j.setSuccess(true);
		} catch (Exception e) {
			j.setMsg(e.getLocalizedMessage());
		}
		return j;
	}
}
