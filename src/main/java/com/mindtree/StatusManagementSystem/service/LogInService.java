package com.mindtree.StatusManagementSystem.service;

import com.mindtree.StatusManagementSystem.entity.LogIn;
import com.mindtree.StatusManagementSystem.exceptions.serviceexceptions.SMSServiceException;

public interface LogInService {
	public boolean addLogInData(LogIn logIn);

	public LogIn getLogInDataByUsername(String userName) throws SMSServiceException;

}
