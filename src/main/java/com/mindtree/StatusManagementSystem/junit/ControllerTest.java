package com.mindtree.StatusManagementSystem.junit;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
//import org.springframework.test.web.servlet.MockMvc;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mindtree.StatusManagementSystem.controller.CampusMindController;
import com.mindtree.StatusManagementSystem.controller.TrackController;
import com.mindtree.StatusManagementSystem.dao.TrackDao;
import com.mindtree.StatusManagementSystem.dao.daoimpl.TrackDaoImpl;
import com.mindtree.StatusManagementSystem.entity.CampusMind;
import com.mindtree.StatusManagementSystem.entity.CampusMindDto;
import com.mindtree.StatusManagementSystem.entity.Track;
import com.mindtree.StatusManagementSystem.exceptions.daoexceptions.SMSDaoException;
import com.mindtree.StatusManagementSystem.exceptions.serviceexceptions.SMSServiceException;
import com.mindtree.StatusManagementSystem.service.CampusMindService;
import com.mindtree.StatusManagementSystem.service.TrackService;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-Config/AppContext.xml"})
public class ControllerTest {

	@Autowired
	private TrackDao trackDao;
	
	@Test
	public void testAddCampusMind() {

		Track track = new Track();
		track.setTrackId("t121aa12111");
		track.setTrackName("zzzzz");
		track.setCapabilities(null);
		
		boolean result = true; 
		try {
			result = trackDao.addTrack(track);
			System.out.println(result);
		} catch (SMSDaoException e) {
 			e.printStackTrace();
		}

		Track track2=new Track();
		try {
			track2=trackDao.getTrackByTrackId("t121aa12111");
 		} catch (SMSDaoException e1) {
 			e1.printStackTrace();
		}
					 assertEquals(track.getTrackId(), track2.getTrackId());
		
	}
		
	@Test
	public void testGetAllCampusMind() {

		 
		List<Track> list=new ArrayList<Track>();
		try {
			list = trackDao.getAllTracks();
		} catch (SMSDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		assertEquals(false, list.isEmpty());
		assertEquals(11, list.size());

	}
	
	

}
