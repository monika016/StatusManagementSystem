package com.mindtree.StatusManagementSystem.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.StatusManagementSystem.dao.CapabilityDao;
import com.mindtree.StatusManagementSystem.entity.Capability;
import com.mindtree.StatusManagementSystem.entity.Track;
import com.mindtree.StatusManagementSystem.exceptions.daoexceptions.SMSDaoException;
import com.mindtree.StatusManagementSystem.exceptions.serviceexceptions.SMSServiceException;
import com.mindtree.StatusManagementSystem.service.CapabilityService;

@Service
public class CapabilityServiceImpl implements CapabilityService {

	@Autowired
	private CapabilityDao capabilityDao;

	public boolean addCapability(Capability capability) throws SMSServiceException {
		try {
			this.capabilityDao.addCapability(capability);
		} catch (SMSDaoException e) {
			throw new SMSServiceException("Error in given values", e);
		}
		return true;
	}

	public Capability getCapabilityByCapabilityId(String capabilityId) throws SMSServiceException {
		Capability capability;
		try {
			capability = this.capabilityDao.getCapabilityByCapabilityId(capabilityId);
		} catch (SMSDaoException e) {
			throw new SMSServiceException("Can't get capability", e);

		}
		return capability;
	}

	public boolean deleteCapability(String capabilityId) throws SMSServiceException {
		Capability capability = new Capability();
		try {
			capability = this.getCapabilityByCapabilityId(capabilityId);
		} catch (SMSServiceException e) {
			throw new SMSServiceException("Can't fetch capability", e);
		}
		try {
			this.capabilityDao.deleteCapability(capability);
		} catch (SMSDaoException e) {
			throw new SMSServiceException("Can't delete capability ", e);
		}
		return true;
	}

	public List<Capability> getAllCapability() throws SMSServiceException {
		try {
			return this.capabilityDao.getAllCapability();
		} catch (SMSDaoException e) {
			throw new SMSServiceException("Can't add campus mind", e);
		}
	}

	public boolean updateCapability(Capability capability) {

		this.capabilityDao.updateCapability(capability);

		return true;
	}

}
