package com.prongbang.service;

import com.prongbang.dto.Properties;

public interface FileUploadService {
	public Boolean upload(Properties properties);

	public String get();
}
