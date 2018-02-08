package com.mindtree.StatusManagementSystem.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.StatusManagementSystem.dao.TrackDao;
import com.mindtree.StatusManagementSystem.entity.Track;
import com.mindtree.StatusManagementSystem.exceptions.daoexceptions.SMSDaoException;
import com.mindtree.StatusManagementSystem.exceptions.serviceexceptions.SMSServiceException;
import com.mindtree.StatusManagementSystem.service.TrackService;

@Service
public class TrackServiceImpl implements TrackService {

	@Autowired
	private TrackDao trackDao;

	public boolean addTrack(Track track) throws SMSServiceException {
		try {
			this.trackDao.addTrack(track);
		} catch (SMSDaoException e) {
			throw new SMSServiceException("Can't add track", e);
		}
		return true;
	}

	public Track getTrackByTrackId(String trackId) throws SMSServiceException {
		Track track = new Track();

		try {
			track = this.trackDao.getTrackByTrackId(trackId);
		} catch (SMSDaoException e) {
			 throw new SMSServiceException("Can't get track", e);
		}
		return track;
	}

	public boolean deleteTrack(String trackId) throws SMSServiceException {

		Track track;
		try {
			track = this.getTrackByTrackId(trackId);
		} catch (SMSServiceException e) {
			 throw new SMSServiceException("Can't fetch track", e);
		}
		try {
			this.trackDao.deleteTrack(track);
		} catch (SMSDaoException e) {
			 throw new SMSServiceException("Can't delete track", e);
		}
		return true;
	}

	public List<Track> getAllTracks() throws SMSServiceException {
		
		List<Track> track= new ArrayList<Track>();
		
		
		try {
			return this.trackDao.getAllTracks();
		} catch (SMSDaoException e) {
			 throw new SMSServiceException("Can't delete track", e);
			
		}
	}

}
