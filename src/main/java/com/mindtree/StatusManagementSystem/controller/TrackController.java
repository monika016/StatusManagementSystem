package com.mindtree.StatusManagementSystem.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.StatusManagementSystem.entity.Track;
import com.mindtree.StatusManagementSystem.exceptions.serviceexceptions.SMSServiceException;
import com.mindtree.StatusManagementSystem.service.TrackService;

@RestController
@CrossOrigin
public class TrackController {

	@Autowired
	private TrackService trackService;

	@RequestMapping(value = "/addTrack")
	public boolean addTrack(@RequestBody Track track) {
		track.setCapabilities(null);
	
		
		try {
			Track tVerify = this.trackService.getTrackByTrackId(track.getTrackId());
			if(tVerify!=null)
				return false;
		} catch (SMSServiceException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			this.trackService.addTrack(track);
			return true;
		} catch (SMSServiceException e) {
			e.printStackTrace();
		}

		System.out.println("done");
		return false;
	}

	@RequestMapping(value = "/getAllTracks")
	@ResponseBody
	public List<Track> getAllTracks() {
		List<Track> tracks = new ArrayList<Track>();
		try {
			tracks = this.trackService.getAllTracks();
		} catch (SMSServiceException e) {
			e.printStackTrace();
		}
		return tracks;
	}

}
