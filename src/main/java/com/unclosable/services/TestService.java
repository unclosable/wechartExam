package com.unclosable.services;

import java.net.URI;
import java.util.List;

import com.unclosable.DO.Test;

public interface TestService {
	List<Test> getTest();

	public URI serviceUrl();
}
