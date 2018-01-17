package com.unclosable.filters;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Configuration;

import com.unclosable.services.base.Cookie;

@Configuration
@WebFilter(filterName = "CookieFilter", urlPatterns = "/*")
public class CookieFilter implements Filter {
	private static final String tokenKey = "token";
	Log logger = LogFactory.getLog(getClass());

	@Resource
	Cookie cookie;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("CookieFilter INIT");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest SHR = (HttpServletRequest) request;
		String uri = SHR.getRequestURI();
		String method = SHR.getMethod();
		if (uri.endsWith("/c") || "OPTIONS".equals(method)) {
			chain.doFilter(request, response);
		} else {
			String token = SHR.getHeader("token");
			if (cookie.ckeckCookie(token)) {
				chain.doFilter(request, response);
			}
		}
	}

	// private String getToken(javax.servlet.http.Cookie[] cookies) {
	// if (cookies == null || cookies.length == 0) {
	// return null;
	// }
	// for (javax.servlet.http.Cookie cookie : cookies) {
	// String key = cookie.getName();
	// if (tokenKey.equals(key)) {
	// return cookie.getValue();
	// }
	// }
	// return null;
	// }

	@Override
	public void destroy() {
		logger.info("CookieFilter destroy");
	}

}
