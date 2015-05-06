package com.qcqz.web.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.qcqz.pageModel.Json;
import com.qcqz.pageModel.Letter;
import com.qcqz.service.LetterService;

@Controller
@RequestMapping("/letter")
public class LetterController extends BaseController {

	@Autowired
	private LetterService letterService;
	
	@RequestMapping(value = "/deleteLetter", method = RequestMethod.POST)
	@ResponseBody
	public Object deleteLetter(Letter letter){
		Json j = new Json();
		letterService.delete(letter.getCid());
		j.setSuccess(true);
		j.setMsg("删除成功!");
		return j;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Object add(Letter letter,@RequestParam MultipartFile picfiles, HttpServletRequest request) {
		Json j = new Json();
		try {
			String realPath = request.getSession().getServletContext().getRealPath("/upload"); 
			File file = new File(realPath, picfiles.getOriginalFilename());
			FileUtils.copyInputStreamToFile(picfiles.getInputStream(), file);
		 	letter.setCpath("upload"+File.separator+file.getName());
			letterService.save(letter);
			j.setMsg("添加成功！");
			j.setSuccess(true);
		} catch (Exception e) {
			j.setMsg(e.getLocalizedMessage());
		}
		return j;
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public Object edit(Letter letter,@RequestParam MultipartFile picfiles, HttpServletRequest request) {
		Json j = new Json();
		try {
			String realPath = request.getSession().getServletContext().getRealPath("/upload"); 
			File file = new File(realPath, picfiles.getOriginalFilename());
			FileUtils.copyInputStreamToFile(picfiles.getInputStream(), file);
		 	letter.setCpath("upload"+File.separator+file.getName());
			letterService.update(letter);
			j.setSuccess(true);
			j.setMsg("编辑成功！");
		} catch (Exception e) {
			j.setMsg("编辑失败!");
		}
		return j;
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	@ResponseBody
	public Object datagrid(Letter letter) {
		return letterService.datagrid(letter);
	}
	
	@RequestMapping(value = "/addLetter", method = RequestMethod.GET)
	public ModelAndView addLetter(HttpServletRequest request){
		return new ModelAndView("/dataEnter/letterAdd");
	}
	
	@RequestMapping(value = "/editLetter", method = RequestMethod.GET)
	public ModelAndView editLetter(HttpServletRequest request){
		return new ModelAndView("/dataEnter/letterEdit");
	}
	
	
}
