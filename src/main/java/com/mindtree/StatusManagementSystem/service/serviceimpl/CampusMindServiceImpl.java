package com.mindtree.StatusManagementSystem.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.StatusManagementSystem.dao.CampusMindDao;
import com.mindtree.StatusManagementSystem.entity.CampusMind;
import com.mindtree.StatusManagementSystem.exceptions.daoexceptions.SMSDaoException;
import com.mindtree.StatusManagementSystem.exceptions.serviceexceptions.SMSServiceException;
import com.mindtree.StatusManagementSystem.service.CampusMindService;

@Service
public class CampusMindServiceImpl implements CampusMindService {

	@Autowired
	private CampusMindDao campusMindDao;

	public boolean addCampusMind(CampusMind campusMind) throws SMSServiceException {
		try {
			this.campusMindDao.addCampusMind(campusMind);
		} catch (SMSDaoException e) {
			throw new SMSServiceException("Can't add campus mind", e);
		}
		return true;
	}

	public CampusMind getCampusMindByMid(String mid) throws SMSServiceException {

		CampusMind campusMind = new CampusMind();

		try {
			campusMind = this.campusMindDao.getCampusMindByMid(mid);
		} catch (SMSDaoException e) {
			throw new SMSServiceException("Can't get campus mind", e);
		}
		return campusMind;
	}

	public boolean deleteCampusMindByMid(String mid) throws SMSServiceException {
		CampusMind campusMind = new CampusMind();
		try {
			campusMind = this.campusMindDao.getCampusMindByMid(mid);
		} catch (SMSDaoException e) {
			throw new SMSServiceException("Can't get campus mind", e);
		}

		try {
			this.campusMindDao.deleteCampusMind(campusMind);
		} catch (SMSDaoException e) {
			throw new SMSServiceException("Can't delete campus mind", e);
		}
		return true;
	}

	public List<CampusMind> getAllCampusMind() throws SMSServiceException {

		List<CampusMind> campusMind = new ArrayList<CampusMind>();

		try {
			campusMind = this.campusMindDao.getAllCampusMinds();
		} catch (SMSDaoException e) {
			 throw new SMSServiceException("Can't add campus mind", e);
		}

		return campusMind;
	}

}
