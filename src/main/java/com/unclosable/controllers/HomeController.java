package com.unclosable.controllers;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unclosable.services.base.Cookie;

@Controller
@RequestMapping(value = "/")
public class HomeController {
	@Resource
	Cookie cookie;
	protected Log logger = LogFactory.getLog(this.getClass());


	@RequestMapping(value = { "/", "" })
	public String index(Model model) throws InterruptedException {
		return "index";
	}

	@RequestMapping(value = { "/c" }, method = RequestMethod.GET)
	@ResponseBody
	public String cookieGet(Model model) throws InterruptedException {
		return cookie.getCookie();
	}
}
