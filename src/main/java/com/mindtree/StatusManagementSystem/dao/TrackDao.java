package com.mindtree.StatusManagementSystem.dao;

import java.util.List;

import com.mindtree.StatusManagementSystem.entity.Track;
import com.mindtree.StatusManagementSystem.exceptions.daoexceptions.SMSDaoException;

public interface TrackDao {

	public boolean addTrack(Track track) throws SMSDaoException;

	public Track getTrackByTrackId(String trackId) throws SMSDaoException;

	public boolean deleteTrack(Track track) throws SMSDaoException;

	public List<Track> getAllTracks() throws SMSDaoException;
}
