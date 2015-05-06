package com.qcqz.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qcqz.service.RepairService;

@Controller
@RequestMapping("/repair")
public class RepairController extends BaseController {

	@Autowired
	private RepairService service;
	
	@RequestMapping(value = "/init", method = RequestMethod.GET)
	@ResponseBody
	public String init(HttpServletRequest request) {
		service.initDataBase();
		return "success";
	}
}
