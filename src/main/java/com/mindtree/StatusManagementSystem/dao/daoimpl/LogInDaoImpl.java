package com.mindtree.StatusManagementSystem.dao.daoimpl;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.StatusManagementSystem.dao.LogInDao;
import com.mindtree.StatusManagementSystem.entity.LogIn;
import com.mindtree.StatusManagementSystem.exceptions.daoexceptions.SMSDaoException;

@Transactional
@Repository
public class LogInDaoImpl implements LogInDao {

	@Autowired
	private SessionFactory sessionFacotry;

	public boolean addLogInData(LogIn logIn) {
		this.sessionFacotry.getCurrentSession().save(logIn);
		return true;
	}

	public LogIn getLogInDataByUsername(String userName) throws SMSDaoException {

		LogIn logIn = new LogIn();

		try {
			
			logIn = this.sessionFacotry.getCurrentSession().get(LogIn.class, new String(userName));
			System.out.println("here");
			System.out.println(logIn);
			
		} catch (HibernateException hibernateException) {
			System.out.println("caught");
			throw new SMSDaoException("No entry present", hibernateException);
		}

		return logIn;
	}

	public boolean deleteLogIn(LogIn logIn) throws SMSDaoException {
		try {
			this.sessionFacotry.getCurrentSession().remove(logIn);
		} catch (HibernateException hibernateException) {
			throw new SMSDaoException("No entry to remove", hibernateException);
		}
		return true;
	}

	public Set<LogIn> getAllLogInData() throws SMSDaoException {
		Set<LogIn> list = new HashSet<LogIn>();

		try {
			list = (Set<LogIn>) this.sessionFacotry.getCurrentSession().createQuery("from LogIn").list();
		} catch (HibernateException hibernateException) {
			throw new SMSDaoException("No entries to display", hibernateException);
		}
		return list;
	}
}
