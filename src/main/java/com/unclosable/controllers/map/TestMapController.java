package com.unclosable.controllers.map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unclosable.controllers.BasicController;

@Controller
@RequestMapping("/map")
public class TestMapController extends BasicController {

	@RequestMapping("/index")
	public String index() {
		return "map/index";
	}

}
