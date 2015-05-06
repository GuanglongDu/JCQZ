package com.qcqz.web.controller;

import java.io.File;
import java.util.List;

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
import com.qcqz.pageModel.Words;
import com.qcqz.service.WordService;

@Controller
@RequestMapping("/nword")
public class WordController extends BaseController {

	@Autowired
	private WordService wordService;
	
	@RequestMapping(value = "/deleteWords", method = RequestMethod.POST)
	@ResponseBody
	public Object deleteWords(String ids){
		Json j = new Json();
		wordService.delete(ids);
		j.setSuccess(true);
		j.setMsg("删除成功!");
		return j;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Object addWords(Words words,@RequestParam MultipartFile picfiles, HttpServletRequest request) {
		Json j = new Json();
		try {
			if(picfiles != null){
				String realPath = request.getSession().getServletContext().getRealPath("/upload"); 
				File file = new File(realPath, picfiles.getOriginalFilename());
				FileUtils.copyInputStreamToFile(picfiles.getInputStream(), file);
				words.setCpath("upload"+File.separator+file.getName());
			}
			wordService.add(words);
			j.setMsg("添加成功！");
			j.setSuccess(true);
		} catch (Exception e) {
			j.setMsg(e.getLocalizedMessage());
		}
		return j;
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public Object editWords(Words words,@RequestParam MultipartFile picfiles, HttpServletRequest request) {
		Json j = new Json();
		try {
			String realPath = request.getSession().getServletContext().getRealPath("/upload"); 
			File file = new File(realPath, picfiles.getOriginalFilename());
			FileUtils.copyInputStreamToFile(picfiles.getInputStream(), file);
		 	words.setCpath("upload"+File.separator+file.getName());
			wordService.update(words);
			j.setSuccess(true);
			j.setMsg("编辑成功！");
		} catch (Exception e) {
			j.setMsg("编辑失败，用户名已存在！");
		}
		return j;
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	@ResponseBody
	public Object datagrid(Words words) {
		return wordService.datagrid(words);
	}
	
	@RequestMapping(value = "/addWords", method = RequestMethod.GET)
	public ModelAndView addCategories(HttpServletRequest request){
		return new ModelAndView("/dataEnter/enterDataAdd");
	}
	
	@RequestMapping(value = "/editWords", method = RequestMethod.GET)
	public ModelAndView editWords(HttpServletRequest request){
		return new ModelAndView("/dataEnter/enterDataEdit");
	}
	
	@RequestMapping(value = "/getRandomCourse", method = RequestMethod.GET)
	@ResponseBody
	public Object datagridCourse(Words words){
		return wordService.datagridCourse(words);
	}
}
