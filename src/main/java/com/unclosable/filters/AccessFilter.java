package com.unclosable.filters;

import java.io.IOException;

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

@Configuration
@WebFilter(filterName = "APITokenFilter", urlPatterns = "/*")
public class AccessFilter implements Filter {
	Log logger = LogFactory.getLog(getClass());

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("AccessFilter INIT");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest SHR = (HttpServletRequest) request;

		// access log
		String method = SHR.getMethod();
		String url = SHR.getRequestURL().toString();

		logger.info("<access log>[" + method + "]" + url);

		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		logger.info("AccessFilter DESTROY");
	}

}
