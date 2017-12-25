package com.unclosable.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class HomeController {
	protected Log logger = LogFactory.getLog(this.getClass());


	@RequestMapping(value = { "/", "" })
	public String index(Model model) throws InterruptedException {
		return "index";
	}
}
