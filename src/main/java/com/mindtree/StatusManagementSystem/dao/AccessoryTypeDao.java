package com.mindtree.StatusManagementSystem.dao;

import java.util.List;

import com.mindtree.StatusManagementSystem.entity.AccessoryType;

public interface AccessoryTypeDao {
	public boolean addAccessoryType(AccessoryType accessoryType);

	public boolean deleteAccessoryType(AccessoryType accessoryType);

	public AccessoryType getAccessoryTypeById(String accessoryTypeId);

	public List<AccessoryType> getAllAccessoryType();
}
