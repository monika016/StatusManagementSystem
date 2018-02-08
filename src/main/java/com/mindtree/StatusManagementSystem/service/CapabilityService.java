package com.mindtree.StatusManagementSystem.service;

import java.util.List;

import com.mindtree.StatusManagementSystem.entity.Capability;
import com.mindtree.StatusManagementSystem.entity.Track;
import com.mindtree.StatusManagementSystem.exceptions.serviceexceptions.SMSServiceException;

public interface CapabilityService {
	public boolean addCapability(Capability capability) throws SMSServiceException;

	public Capability getCapabilityByCapabilityId(String capabilityId) throws SMSServiceException;

	public boolean deleteCapability(String capabilityId) throws SMSServiceException;

	public List<Capability> getAllCapability() throws SMSServiceException;

	public boolean updateCapability(Capability capability);
}
