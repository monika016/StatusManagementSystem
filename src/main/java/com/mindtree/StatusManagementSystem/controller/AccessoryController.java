package com.mindtree.StatusManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.StatusManagementSystem.entity.Accessory;
import com.mindtree.StatusManagementSystem.entity.AccessoryType;
import com.mindtree.StatusManagementSystem.exceptions.serviceexceptions.SMSServiceException;
import com.mindtree.StatusManagementSystem.service.AccessoryService;
import com.mindtree.StatusManagementSystem.service.CampusMindService;

@RestController
@CrossOrigin
public class AccessoryController {

	@Autowired
	private AccessoryService accessoryService;

	@Autowired
	private CampusMindService campusMindService;

	@RequestMapping(value = "/addAcc")
	@ResponseBody
	public Accessory addacc() {
		Accessory accessory = new Accessory();
		accessory.setAccessoryId("1231");

		AccessoryType accessoryType = new AccessoryType();
		accessory.setAccessoryType(accessoryType);
		
		
		
		
		return this.accessoryService.getAccessoryById("123");
	}

}
