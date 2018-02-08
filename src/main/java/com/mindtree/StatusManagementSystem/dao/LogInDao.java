package com.mindtree.StatusManagementSystem.dao;

import java.util.Set;

import com.mindtree.StatusManagementSystem.entity.LogIn;
import com.mindtree.StatusManagementSystem.exceptions.daoexceptions.SMSDaoException;

public interface LogInDao {

	public boolean addLogInData(LogIn logIn);

	public LogIn getLogInDataByUsername(String userName) throws SMSDaoException;

	public boolean deleteLogIn(LogIn logIn) throws SMSDaoException;

	public Set<LogIn> getAllLogInData() throws SMSDaoException;
}
