package com.mindtree.StatusManagementSystem.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.StatusManagementSystem.entity.Capability;
import com.mindtree.StatusManagementSystem.entity.CapabilityDto;
import com.mindtree.StatusManagementSystem.entity.Track;
import com.mindtree.StatusManagementSystem.exceptions.serviceexceptions.SMSServiceException;
import com.mindtree.StatusManagementSystem.service.CapabilityService;
import com.mindtree.StatusManagementSystem.service.TrackService;

@RestController
@CrossOrigin
public class CapabilityController {
	@Autowired
	private CapabilityService capabilityService;

	@Autowired
	private TrackService trackService;

	@RequestMapping(value = "/addCapability")
	public boolean addCapability(@RequestBody Capability capability) {

		try {
			Capability cCapability = this.capabilityService.getCapabilityByCapabilityId(capability.getCapabilityId());

			if (cCapability != null)
				return false;
		} catch (SMSServiceException e1) {
			e1.printStackTrace();
		}

		capability.setTrack(null);
		try {
			this.capabilityService.addCapability(capability);
			return true;
		} catch (SMSServiceException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		System.out.println("done");
		return true;
	}

	@RequestMapping(value = "/getAllCapability")
	@ResponseBody
	public List<CapabilityDto> getAllCapability() {
		List<Capability> list = new ArrayList<Capability>();
		try {
			list = this.capabilityService.getAllCapability();
		} catch (SMSServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list);
		List<CapabilityDto> dtoList = new ArrayList<CapabilityDto>();

		for (Capability c : list) {
			CapabilityDto cDto = new CapabilityDto();

			cDto.setCapabilityId(c.getCapabilityId());
			cDto.setCapabilityName(c.getCapabilityName());
			if (c.getTrack() != null) {
				System.out.println("null");
				cDto.setTrackId(c.getTrack().getTrackId());
			} else
				cDto.setTrackId("");

			dtoList.add(cDto);
		}

		System.out.println(dtoList);

		return dtoList;
	}

	@RequestMapping(value = "/map/{trackId}/{capabilityId}", method = RequestMethod.GET)
	public boolean mapCapabilityWithTrack(@PathVariable("trackId") String trackId,
			@PathVariable("capabilityId") String capabilityId) {

		// Track track = this.trackService.getTrackByTrackId(trackId);
		// Capability capability =
		// this.capabilityService.getCapabilityByCapabilityId(capabilityId);
		//
		// capability.setTrack(track);
		//
		// this.capabilityService.deleteCapability(capabilityId);
		// this.capabilityService.addCapability(capability);
		//
		// capability =
		// this.capabilityService.getCapabilityByCapabilityId(capabilityId);
		//
		// System.out.println(capability);

		Track track = new Track();
		try {
			track = this.trackService.getTrackByTrackId(trackId);
			if (track == null)
				return false;
		} catch (SMSServiceException e1) {
			e1.printStackTrace();
		}
		Capability capability = new Capability();
		try {
			capability = this.capabilityService.getCapabilityByCapabilityId(capabilityId);
			if (capability == null)
				return false;
		} catch (SMSServiceException e1) {
			e1.printStackTrace();
		}
		Set<Capability> list = track.getCapabilities();

		if (list == null) {
			list = new HashSet<Capability>();
		}

		list.add(capability);
		track.setCapabilities(list);

		try {
			this.trackService.deleteTrack(trackId);
		} catch (SMSServiceException e1) {
			e1.printStackTrace();
		}
		try {
			this.trackService.addTrack(track);
		} catch (SMSServiceException e1) {
			e1.printStackTrace();
		}

		try {
			this.capabilityService.deleteCapability(capabilityId);
		} catch (SMSServiceException e1) {
			e1.printStackTrace();
		}
		capability.setTrack(track);
		try {
			this.capabilityService.addCapability(capability);
		} catch (SMSServiceException e) {
			e.printStackTrace();
		}

		try {
			track = this.trackService.getTrackByTrackId(trackId);
		} catch (SMSServiceException e) {
			e.printStackTrace();
		}

		System.out.println(track);

		return true;

	}

	@RequestMapping(value = "/deleteCap")
	public void delete(@RequestBody String capabilityId) {

		try {

			this.capabilityService.deleteCapability(capabilityId);

			System.out.println("done");

		} catch (SMSServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping(value = "/updateCap")
	public void update(@RequestBody CapabilityDto capabilityDto) {

		System.out.println(capabilityDto);
		Capability capability = new Capability();
		capability.setCapabilityId(capabilityDto.getCapabilityId());
		capability.setCapabilityName(capabilityDto.getCapabilityName());

		try {
			Track track = this.trackService.getTrackByTrackId(capabilityDto.getTrackId());
			capability.setTrack(track);
		} catch (SMSServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.capabilityService.updateCapability(capability);
		System.out.println("cap updated");

	}

}
