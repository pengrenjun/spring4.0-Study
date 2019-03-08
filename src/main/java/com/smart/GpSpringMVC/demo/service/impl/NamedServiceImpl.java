package com.smart.GpSpringMVC.demo.service.impl;


import com.smart.GpSpringMVC.demo.service.INamedService;
import com.smart.GpSpringMVC.demo.service.IService;
import com.smart.GpSpringMVC.framework.annotation.GPAutowired;
import com.smart.GpSpringMVC.framework.annotation.GPService;

@GPService("myName")
public class NamedServiceImpl implements INamedService {

	@GPAutowired
    IService service;
	
}
