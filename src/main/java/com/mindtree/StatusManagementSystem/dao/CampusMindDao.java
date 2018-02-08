package com.mindtree.StatusManagementSystem.dao;

import java.util.List;

import com.mindtree.StatusManagementSystem.entity.CampusMind;
import com.mindtree.StatusManagementSystem.exceptions.daoexceptions.SMSDaoException;

public interface CampusMindDao {
	public boolean addCampusMind(CampusMind campusMind) throws SMSDaoException;

	public CampusMind getCampusMindByMid(String mid) throws SMSDaoException;

	public boolean deleteCampusMind(CampusMind campusMind) throws SMSDaoException;

	public List<CampusMind> getAllCampusMinds() throws SMSDaoException;
}
