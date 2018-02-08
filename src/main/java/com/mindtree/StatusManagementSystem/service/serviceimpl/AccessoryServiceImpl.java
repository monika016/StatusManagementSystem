package com.mindtree.StatusManagementSystem.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.StatusManagementSystem.dao.AccessoryDao;
import com.mindtree.StatusManagementSystem.entity.Accessory;
import com.mindtree.StatusManagementSystem.service.AccessoryService;

@Service
public class AccessoryServiceImpl implements AccessoryService {

	@Autowired
	private AccessoryDao accessoryDao;

	public boolean addAccessory(Accessory accessory) {

		this.accessoryDao.addAccessory(accessory);
		return true;
	}

	public Accessory getAccessoryById(String accessory) {

		return this.accessoryDao.getAccessoryById(accessory);
	}

	public boolean deleteAccessory(Accessory accessory) {
		this.accessoryDao.deleteAccessory(accessory);
		return true;
	}

	public List<Accessory> getAllAccessory() {
		return this.accessoryDao.getAllAccessory();
	}

	public boolean updateAccessory(Accessory accessory) {
		this.accessoryDao.updateAccessory(accessory);
		return true;
	}

}
