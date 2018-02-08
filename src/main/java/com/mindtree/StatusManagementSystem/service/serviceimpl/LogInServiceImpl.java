package com.mindtree.StatusManagementSystem.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.StatusManagementSystem.dao.LogInDao;
import com.mindtree.StatusManagementSystem.entity.LogIn;
import com.mindtree.StatusManagementSystem.exceptions.daoexceptions.SMSDaoException;
import com.mindtree.StatusManagementSystem.exceptions.serviceexceptions.SMSServiceException;
import com.mindtree.StatusManagementSystem.service.LogInService;

@Service
public class LogInServiceImpl implements LogInService {

	@Autowired
	private LogInDao logInDao;

	public boolean addLogInData(LogIn logIn) {
		this.logInDao.addLogInData(logIn);
		return true;
	}

	public LogIn getLogInDataByUsername(String userName) throws SMSServiceException {
		LogIn logIn = new LogIn();
		try {
			System.out.println("in service");
			logIn = this.logInDao.getLogInDataByUsername(userName);
			System.out.println("out service");

		} catch (SMSDaoException e) {
			throw new SMSServiceException("Wrong user name entered", e);
		}
		
		
		return logIn;
	}

}
