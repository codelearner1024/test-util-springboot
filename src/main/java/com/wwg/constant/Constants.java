package com.wwg.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Constants {

	public static String CAS_SERVER_URL;

	@Value("${cas.server.url}")
	private void setCasServerUrl(String casServerUrl) {
		CAS_SERVER_URL = casServerUrl;
	}
}
