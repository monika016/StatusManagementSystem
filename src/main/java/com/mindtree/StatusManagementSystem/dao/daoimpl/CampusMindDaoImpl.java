package com.mindtree.StatusManagementSystem.dao.daoimpl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.StatusManagementSystem.dao.CampusMindDao;
import com.mindtree.StatusManagementSystem.entity.CampusMind;
import com.mindtree.StatusManagementSystem.exceptions.StatusManagementException;
import com.mindtree.StatusManagementSystem.exceptions.daoexceptions.SMSDaoException;

@Transactional
@Repository
public class CampusMindDaoImpl implements CampusMindDao {

	@Autowired
	private SessionFactory sessionFactory;

	public boolean addCampusMind(CampusMind campusMind) throws SMSDaoException {
		try {
 			this.sessionFactory.getCurrentSession().save(campusMind);
 		} catch (DataIntegrityViolationException  diException) {
 			throw new SMSDaoException("Can't add CM", diException);
		}
		
		return true;
	}

	public CampusMind getCampusMindByMid(String mid) throws SMSDaoException {
		try {
			return this.sessionFactory.getCurrentSession().get(CampusMind.class, new String(mid));
		} catch (HibernateException hibernateException) {
			throw new SMSDaoException("Can't get CM", hibernateException);
		}
	}

	public boolean deleteCampusMind(CampusMind campusMind) throws SMSDaoException {
		try {
			this.sessionFactory.getCurrentSession().remove(campusMind);
		} catch (HibernateException hibernateException) {
			throw new SMSDaoException("Can't delete CM", hibernateException);
		}
		return true;
	}

	public List<CampusMind> getAllCampusMinds() throws SMSDaoException {
		try{
		return this.sessionFactory.getCurrentSession().createQuery("from CampusMind").list();
		}catch(HibernateException hibernateException)
		{
			throw new SMSDaoException("Can't delete CM", hibernateException);
		}
	}

}
