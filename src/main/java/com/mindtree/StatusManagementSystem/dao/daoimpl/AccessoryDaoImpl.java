package com.mindtree.StatusManagementSystem.dao.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.StatusManagementSystem.dao.AccessoryDao;
import com.mindtree.StatusManagementSystem.entity.Accessory;

@Transactional
@Repository
public class AccessoryDaoImpl implements AccessoryDao{

	@Autowired
	private SessionFactory sessionFactory;

	public boolean addAccessory(Accessory accessory) {

		this.sessionFactory.getCurrentSession().save(accessory);
		return true;
	}

	public Accessory getAccessoryById(String accessory) {

		return this.sessionFactory.getCurrentSession().get(Accessory.class, accessory);
	}

	public boolean deleteAccessory(Accessory accessory) {
		this.sessionFactory.getCurrentSession().remove(accessory);
		return true;
	}

	public List<Accessory> getAllAccessory() {
		return this.sessionFactory.getCurrentSession().createQuery("from Accessory").list();
	}

	public boolean updateAccessory(Accessory accessory) {
		this.sessionFactory.getCurrentSession().update(accessory);
		return true;
	}

}
