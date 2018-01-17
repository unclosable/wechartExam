package com.unclosable.services.base.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.unclosable.services.base.Cookie;

@Service
public class CookieImpl implements Cookie {
	Map<String, MyCookie> synchronizedHashMap = Collections.synchronizedMap(new HashMap<String, MyCookie>());

	@Override
	public String getCookie() {
		String cookie = uuid();
		this.synchronizedHashMap.put(cookie.replaceAll("-", ""), new MyCookie(cookie));
		return cookie;
	}

	@Override
	public boolean ckeckCookie(String cookie) {
		if (cookie == null) {
			return false;
		}
		return synchronizedHashMap.get(cookie) != null;
	}

	private String uuid() {
		return UUID.randomUUID().toString();
	}
}
