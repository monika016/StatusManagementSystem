package com.mindtree.StatusManagementSystem.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.StatusManagementSystem.entity.CampusMind;
import com.mindtree.StatusManagementSystem.entity.CampusMindDto;
import com.mindtree.StatusManagementSystem.entity.Capability;
import com.mindtree.StatusManagementSystem.entity.Track;
import com.mindtree.StatusManagementSystem.exceptions.serviceexceptions.SMSServiceException;
import com.mindtree.StatusManagementSystem.service.CampusMindService;
import com.mindtree.StatusManagementSystem.service.TrackService;

@RestController
@CrossOrigin
public class CampusMindController {

	@Autowired
	private CampusMindService campusMindService;

	@Autowired
	private TrackService trackService;

	@RequestMapping(value = "/addCM")
	@ResponseBody
	public boolean addCampusMind(@RequestBody CampusMindDto campusMindDto) {
		
		String mid=campusMindDto.getMid();
		
		try {
			CampusMind cm = this.campusMindService.getCampusMindByMid(mid);
			
			if(cm!=null)
				return false;	
		} catch (SMSServiceException e1) {
 			e1.printStackTrace();
		}
		
		CampusMind campusMind = new CampusMind();
		campusMind.setMid(campusMindDto.getMid());

		campusMind.setName(campusMindDto.getName());
		try {
			campusMind.setTrack(this.trackService.getTrackByTrackId(campusMindDto.getTrack()));
		} catch (SMSServiceException e) {
			e.printStackTrace();
		}

		try {
			this.campusMindService.addCampusMind(campusMind);
			return true;
		} catch (SMSServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	@RequestMapping(value = "/allCM")
	@ResponseBody
	public List<CampusMind> getAllCampusMind() {

		List<CampusMind> campusMind = new ArrayList<CampusMind>();

		try {
			campusMind = this.campusMindService.getAllCampusMind();
		} catch (SMSServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return campusMind;

	}

}
