package com.accp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.Model;
import com.accp.service.modelService;

@Controller
@RequestMapping("/model")
public class ModelController {

	@Autowired
	modelService ms;
	
	@RequestMapping("/toQuery")
	public String toQuery() {
		return "query";
	}
	@RequestMapping("/toQwe")
	public String toQwe() {
		return "qwe";
	}
	//∂ØÃ¨º”‘ÿ
	@RequestMapping("/query")
	@ResponseBody
	public List<Model> query(Integer id){
		return ms.query(id);
	}
}
