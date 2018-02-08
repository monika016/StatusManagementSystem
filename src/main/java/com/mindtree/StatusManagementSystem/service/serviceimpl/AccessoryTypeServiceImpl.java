package com.mindtree.StatusManagementSystem.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mindtree.StatusManagementSystem.dao.AccessoryTypeDao;
import com.mindtree.StatusManagementSystem.entity.AccessoryType;

public class AccessoryTypeServiceImpl {

	@Autowired
	private AccessoryTypeDao accessoryTypeDao;

	public boolean addAccessoryType(AccessoryType accessoryType) {

		this.accessoryTypeDao.addAccessoryType(accessoryType);

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
