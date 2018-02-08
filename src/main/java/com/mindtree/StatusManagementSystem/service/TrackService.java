package com.mindtree.StatusManagementSystem.service;

import java.util.List;
import java.util.Set;

import com.mindtree.StatusManagementSystem.entity.Track;
import com.mindtree.StatusManagementSystem.exceptions.serviceexceptions.SMSServiceException;

public interface TrackService {

	public boolean addTrack(Track track) throws SMSServiceException;

	public Track getTrackByTrackId(String trackId) throws SMSServiceException;

	public boolean deleteTrack(String trackId) throws SMSServiceException;

	public List<Track> getAllTracks() throws SMSServiceException;
}
