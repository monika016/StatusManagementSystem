package com.mindtree.StatusManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.StatusManagementSystem.entity.LogIn;
import com.mindtree.StatusManagementSystem.service.LogInService;

@RestController
@CrossOrigin
public class LogInController {

	@Autowired
	private LogInService logInService;

	@RequestMapping(value = "/logIn")
	public boolean logIn(@RequestBody LogIn logIn) {
		LogIn vLogIn=new LogIn();
		try {
			  vLogIn = this.logInService.getLogInDataByUsername(logIn.getMid());
 		} catch (Exception e) {
			
			System.out.println("exception ");
			e.printStackTrace();
			return false;
		}
		
		if(vLogIn==null)
		{
			return false;
		}
		
		if(vLogIn.getPassword().equals(logIn.getPassword()))
		{
			return true;
		}
		
		return false;
	}

}
