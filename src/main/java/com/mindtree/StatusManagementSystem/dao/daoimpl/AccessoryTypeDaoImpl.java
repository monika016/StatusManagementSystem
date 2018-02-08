package com.mindtree.StatusManagementSystem.dao.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mindtree.StatusManagementSystem.dao.AccessoryTypeDao;
import com.mindtree.StatusManagementSystem.entity.AccessoryType;

public class AccessoryTypeDaoImpl implements AccessoryTypeDao{

	@Autowired
	private SessionFactory sessionFactory;

	public boolean addAccessoryType(AccessoryType accessoryType) {

		this.sessionFactory.getCurrentSession().save(accessoryType);

		return true;
	}

	public boolean deleteAccessoryType(AccessoryType accessoryType) {
		this.sessionFactory.getCurrentSession().remove(accessoryType);
		return false;
	}

	public AccessoryType getAccessoryTypeById(String accessoryTypeId) {
		AccessoryType accessoryType = this.sessionFactory.getCurrentSession().get(AccessoryType.class, accessoryTypeId);
		return accessoryType;
	}

	public List<AccessoryType> getAllAccessoryType() {
		return this.sessionFactory.getCurrentSession().createQuery("from AccessoryType").list();
	}

}
