package com.unclosable.services.offer.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.unclosable.DO.Offer;
import com.unclosable.mappers.OfferMapper;
import com.unclosable.services.offer.OfferService;

@Service
public class OfferServiceImpl implements OfferService {
	@Resource
	OfferMapper offerMapper;

	@Override
	public String newOfferAccess(Offer offer) {
		this.offerMapper.insertSelective(offer);
		return null;
	}

}
