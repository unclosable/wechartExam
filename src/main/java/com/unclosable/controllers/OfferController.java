package com.unclosable.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.unclosable.querys.Offer;

@Controller
@RequestMapping(value = "/offer")
public class OfferController {

	@RequestMapping(value="/post",method=RequestMethod.POST)
	public String postOffer(@RequestBody Offer offer) {
		System.out.println(JSON.toJSONString(offer));
		return "";
	}

}
