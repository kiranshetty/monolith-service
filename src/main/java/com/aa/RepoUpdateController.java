package com.aa;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.aa.dto.ConfigProperties;
import com.aa.dto.PropertySource;

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
		
		ConfigProperties configProperties = restTemplate.getForObject(configServerEndpoint, ConfigProperties.class);
		
		List<PropertySource> propertySources = configProperties.getPropertySources();
		
		String service = "";
		String endpoint = "";
		
		for (PropertySource propertySource : propertySources) {
			if (StringUtils.isNotBlank(propertySource.getSource().getEndpoint())) {
				endpoint = propertySource.getSource().getEndpoint() ; 
			}
			if (StringUtils.isNotBlank(propertySource.getSource().getService())) {
				service = propertySource.getSource().getService() ; 
			}
		}
        
		StringBuilder strBuilder = new StringBuilder("Service Name: ");
		strBuilder.append(service);
		strBuilder.append("<br>");
		strBuilder.append("Endpoint: ");
		strBuilder.append(endpoint);

		return strBuilder.toString();

	}
	
}
