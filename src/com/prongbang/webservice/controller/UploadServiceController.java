package com.prongbang.webservice.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.prongbang.dto.Properties;
import com.prongbang.service.impl.FileUploadServiceImpl;

@RestController
@RequestMapping("/service")
public class UploadServiceController {

	private FileUploadServiceImpl fileUploadServiceImpl;

	public UploadServiceController() {
		fileUploadServiceImpl = new FileUploadServiceImpl();
	}

	/**
	 * @param properties
	 * @return Boolean
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	public @ResponseBody Boolean upload(@RequestBody Properties properties) {
		System.out.println(new Gson().toJson(properties));
		return fileUploadServiceImpl.upload(properties);
	}

	/**
	 * @return String
	 */
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public @ResponseBody String get() {
		return fileUploadServiceImpl.get();
	}

}
