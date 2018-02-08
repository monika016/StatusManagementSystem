package com.mindtree.StatusManagementSystem.service;

import java.util.List;

import com.mindtree.StatusManagementSystem.entity.CampusMind;
import com.mindtree.StatusManagementSystem.exceptions.serviceexceptions.SMSServiceException;

public interface CampusMindService {

	public boolean addCampusMind(CampusMind campusMind) throws SMSServiceException;

	public CampusMind getCampusMindByMid(String mid) throws SMSServiceException;

	public boolean deleteCampusMindByMid(String mid) throws SMSServiceException;

	public List<CampusMind> getAllCampusMind() throws SMSServiceException;

}
