package com.unclosable.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unclosable.DO.Offer;
import com.unclosable.services.offer.OfferService;

@Controller
@CrossOrigin
@RequestMapping(value = "/offer")
public class OfferController extends BasicController {
	@Resource
	OfferService offerService;

	@RequestMapping(value="/post",method=RequestMethod.POST)
	@ResponseBody
	public String postOffer(@RequestBody Offer offer) {
		this.offerService.newOfferAccess(offer);
		return new JsonRespons<>("感谢惠顾").toString();
	}

}
