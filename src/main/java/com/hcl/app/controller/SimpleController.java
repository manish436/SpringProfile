package com.hcl.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.app.YAMLConfig;

/**
 * @author manish.go
 *
 */
@RestController
public class SimpleController {

	@Autowired
	YAMLConfig configurations;

	@RequestMapping(value = "/config", method = RequestMethod.GET)
	public String getEmployees() {
		return "hello name is " + configurations.getName();
	}
}
