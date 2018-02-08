package com.mindtree.StatusManagementSystem.dao.daoimpl;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.StatusManagementSystem.dao.TrackDao;
import com.mindtree.StatusManagementSystem.entity.Track;
import com.mindtree.StatusManagementSystem.exceptions.daoexceptions.SMSDaoException;

@Transactional
@Repository
public class TrackDaoImpl implements TrackDao {

	@Autowired
	private SessionFactory sessionFactory;
	

	public boolean addTrack(Track track) throws SMSDaoException {
				
		
		try {
			this.sessionFactory.getCurrentSession().save(track);
		} catch (HibernateException hibernateException) {
			throw new SMSDaoException("Can't add Track ", hibernateException);
		}
		return true;
	}

	public Track getTrackByTrackId(String trackId) throws SMSDaoException {

		Track track = new Track();
		try {
			track = this.sessionFactory.getCurrentSession().get(Track.class, new String(trackId));
		} catch (DataIntegrityViolationException  hibernateException) {
			throw new SMSDaoException("No track present", hibernateException);
		}
		return track;
	}

	public boolean deleteTrack(Track track) throws SMSDaoException {

		try {
			this.sessionFactory.getCurrentSession().remove(track);
		} catch (HibernateException hibernateException) {
			throw new SMSDaoException("No track present", hibernateException);
		}
		return true;
	}

	public List<Track> getAllTracks() throws SMSDaoException {
		try{
		return this.sessionFactory.getCurrentSession().createQuery("from Track").list();
		}catch (HibernateException hibernateException) {
			throw new SMSDaoException("Error in fetching track", hibernateException);
		}
	}

}
