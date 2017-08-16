package com.unclosable.controllers;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unclosable.services.TestService;

@Controller
@RequestMapping(value = "/index")
public class HomeController {
	protected Log logger = LogFactory.getLog(this.getClass());

	@Resource
	private TestService testService;

	@RequestMapping(value = { "/", "" })
	public String index(Model model) throws InterruptedException {
		model.addAttribute("testList", this.testService.getTest());
		this.testService.serviceUrl();
		Thread.sleep(1000L);
		return "index";
	}
}
