package com.mindtree.StatusManagementSystem.dao.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.StatusManagementSystem.dao.CapabilityDao;
import com.mindtree.StatusManagementSystem.entity.Capability;
import com.mindtree.StatusManagementSystem.entity.Track;
import com.mindtree.StatusManagementSystem.exceptions.daoexceptions.SMSDaoException;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

@Transactional
@Repository
public class CapabilityDaoImpl implements CapabilityDao {
	@Autowired
	private SessionFactory sessionFactory;

	public boolean addCapability(Capability capability) throws SMSDaoException {

		
		try {
			this.sessionFactory.getCurrentSession().save(capability);
		} catch (HibernateException e) {
			throw new SMSDaoException("Duplicate value ", e);
		}
		return true;
	}

	public Capability getCapabilityByCapabilityId(String capabilityId) throws SMSDaoException {
		Capability capability = new Capability();

		try {
			capability = this.sessionFactory.getCurrentSession().get(Capability.class, new String(capabilityId));
		} catch (HibernateException hibernateException) {
			throw new SMSDaoException("No capability present", hibernateException);
		}
		return capability;
	}

	public boolean deleteCapability(Capability capability) throws SMSDaoException {

		try {
			this.sessionFactory.getCurrentSession().remove(capability);
		} catch (HibernateException hibernateException) {
			throw new SMSDaoException("No capability present", hibernateException);
		}
		return true;
	}

	public List<Capability> getAllCapability() throws SMSDaoException {
		try {
			return this.sessionFactory.getCurrentSession().createQuery("from Capability").list();
		} catch (HibernateException hibernateException) {
			throw new SMSDaoException("No capability present", hibernateException);
		}
	}
	
	
	public boolean updateCapability(Capability capability)	{
		this.sessionFactory.getCurrentSession().update(capability);
		return true;
	}
	
	
}
