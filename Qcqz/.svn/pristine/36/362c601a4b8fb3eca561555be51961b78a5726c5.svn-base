package com.qcqz.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.qcqz.pageModel.DataGrid;
import com.qcqz.pageModel.Evalutative;
import com.qcqz.service.StudentclassService;

@Controller
@RequestMapping("/evalutative")
public class EvalutativeController extends BaseController {

	@Autowired
	private StudentclassService service;
	
	@RequestMapping(value = "/ceping", method = RequestMethod.GET)
	public ModelAndView editWords(HttpServletRequest request){
		return new ModelAndView("/jwgl/ceping_1");
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Object addCeiping(Evalutative evalutative){
		service.addCeping(evalutative);
		return null;
	}
	
	@RequestMapping(value = "/query", method = RequestMethod.POST)
	@ResponseBody
	public DataGrid queryEvalutative(Evalutative evalutative){
		return service.queryEvalutative(evalutative);
	}

}
