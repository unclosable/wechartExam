package com.unclosable.services.base;

import java.util.Date;

public interface Cookie {
	static long aliveTime = 30 * 60 * 1000;

	String getCookie();

	boolean ckeckCookie(String cookie);

	public class MyCookie {
		private String key;
		private long maxAge;

		public MyCookie() {
			this.maxAge = new Date().getTime() + aliveTime;
		}
		public MyCookie(String key) {
			this.maxAge = new Date().getTime() + aliveTime;
			this.key = key;
		}

		public long getMaxAge() {
			return maxAge;
		}

		public void setMaxAge(long maxAge) {
			this.maxAge = maxAge;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

	}
}
