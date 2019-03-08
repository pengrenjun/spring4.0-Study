package com.smart.GpSpringMVC.demo.mvc.action;

import com.smart.GpSpringMVC.demo.service.INamedService;
import com.smart.GpSpringMVC.demo.service.IService;
import com.smart.GpSpringMVC.framework.annotation.GPAutowired;
import com.smart.GpSpringMVC.framework.annotation.GPController;
import com.smart.GpSpringMVC.framework.annotation.GPRequestMapping;
import com.smart.GpSpringMVC.framework.annotation.GPRequestParam;
import com.smart.GpSpringMVC.framework.servlet.GPModelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@GPController
@GPRequestMapping("/web")
public class FirstAction {

	@GPAutowired
    private IService service;
	
	@GPAutowired("myName") private INamedService namedService;
	
	
	@GPRequestMapping("/query/.*.json")
//	@GPResponseBody
	public GPModelAndView query(HttpServletRequest request, HttpServletResponse response,
                                @GPRequestParam(value="name",required=false) String name,
                                @GPRequestParam("addr") String addr){
		//out(response,"get params name = " + name);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("name", name);
		model.put("addr", addr);
		return new GPModelAndView("first.pgml",model);
	}
	
	
	@GPRequestMapping("/add.json")
	public GPModelAndView add(HttpServletRequest request,HttpServletResponse response){
		out(response,"this is json string");
		return null;
	}
	
	
	
	public void out(HttpServletResponse response,String str){
		try {
			response.getWriter().write(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
