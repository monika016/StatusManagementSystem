package com.mindtree.StatusManagementSystem.dao;

import java.util.List;

import com.mindtree.StatusManagementSystem.entity.Capability;
import com.mindtree.StatusManagementSystem.entity.Track;
import com.mindtree.StatusManagementSystem.exceptions.daoexceptions.SMSDaoException;

public interface CapabilityDao {
	public boolean addCapability(Capability capability)throws SMSDaoException;

	public Capability getCapabilityByCapabilityId(String capabilityId) throws SMSDaoException;

	public boolean deleteCapability(Capability capability) throws SMSDaoException;

	public List<Capability> getAllCapability() throws SMSDaoException;
	
	public boolean updateCapability(Capability capability);
	
}
