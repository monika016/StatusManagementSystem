package com.mindtree.StatusManagementSystem.dao;

import java.util.List;

import com.mindtree.StatusManagementSystem.entity.Accessory;

public interface AccessoryDao {

	public boolean addAccessory(Accessory accessory);

	public Accessory getAccessoryById(String accessory);

	public boolean deleteAccessory(Accessory accessory);

	public List<Accessory> getAllAccessory();

	public boolean updateAccessory(Accessory accessory);

}
