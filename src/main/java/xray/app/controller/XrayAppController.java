package xray.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import xray.app.entity.User;
import xray.app.model.XrayAppData;
import xray.app.service.XrayAppService;

@RestController
@Slf4j
public class XrayAppController {

	@Autowired
	private XrayAppService xrayAppService;
	
	@PostMapping("/xray_app")
	@ResponseStatus(code = HttpStatus.CREATED) 
	public XrayAppData createUser(@RequestBody XrayAppData xrayAppData) {
		log.info("Saving user {}", xrayAppData);
		return XrayAppService.saveUser(XrayAppData);
	}
	@GetMapping("/xray_app/{UserId}")
	public XrayAppData retrieveUserById(@PathVariable Long userId) {
		log.info("Retrieving user with ID={}", userId);
		return xrayAppService.retrieveUserById();
		
		
	}
	
	
	@GetMapping("/xray_app")
	public List<XrayAppData> retrieveAllUsers() {
		return XrayAppService.retrieveAllUsers();
	}
}
