package com.hkt.ekyc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class EkycRibbonService {
	
	 @Autowired
	 RestTemplate restTemplate;
	 
	 @HystrixCommand(fallbackMethod = "ribbonError")
	 public String ribbonService(String message) {
		 return restTemplate.postForObject("http://SERVICE-ZUUL/api-a", message, String.class);
	 }
	 
	 public String ribbonError(String message) {
		 return "System error,  cannot deliver message: " + message;
	 }

}
