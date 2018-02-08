package com.mindtree.StatusManagementSystem.service;

import java.util.List;

import com.mindtree.StatusManagementSystem.entity.Accessory;

public interface AccessoryService {

	public boolean addAccessory(Accessory accessory);

	public Accessory getAccessoryById(String accessory);

	public boolean deleteAccessory(Accessory accessory);

	public List<Accessory> getAllAccessory();

	public boolean updateAccessory(Accessory accessory);

}
