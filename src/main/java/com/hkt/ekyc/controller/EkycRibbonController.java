package com.hkt.ekyc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hkt.ekyc.service.EkycRibbonService;

@RestController
public class EkycRibbonController {
	
	@Autowired
	EkycRibbonService ekycRibbonService;
	
	@RequestMapping(
		    value = "/ribbon/poc", 
		    method = RequestMethod.POST)
	public String poc(@RequestBody String message) {
		return ekycRibbonService.ribbonService(message);
	}

}
