package com.aa;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RepoUpdateController {

	@Value("${spring.application.name}")
	String appName;

	@Value("${spring.profiles.active}")
	String profile;

	private final RestTemplate restTemplate = new RestTemplate();
	private static final String CONFIG_SERVER_URI = "http://localhost:8889/";
	
	@RequestMapping(value="/props", method=RequestMethod.GET)
	public String recieveUpdate() {
		String configServerEndpoint = CONFIG_SERVER_URI + appName + "/" + profile; 
		ResponseEntity<String> response = restTemplate.exchange(configServerEndpoint , HttpMethod.GET, null,
				String.class);

		return response.toString();
	}
	
}
