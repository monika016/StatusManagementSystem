package com.mindtree.StatusManagementSystem.entity;

import java.util.HashSet;
import java.util.Set;

public class TrackDto {
	private String trackId;

	private String trackName;

	private Set<Capability> capabilities = new HashSet<Capability>();

	public TrackDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TrackDto(String trackId, String trackName, Set<Capability> capabilities) {
		super();
		this.trackId = trackId;
		this.trackName = trackName;
		this.capabilities = capabilities;
	}

	@Override
	public String toString() {
		return "TrackDto [trackId=" + trackId + ", trackName=" + trackName + ", capabilities=" + capabilities + "]";
	}

	public String getTrackId() {
		return trackId;
	}

	public void setTrackId(String trackId) {
		this.trackId = trackId;
	}

	public String getTrackName() {
		return trackName;
	}

	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}

	public Set<Capability> getCapabilities() {
		return capabilities;
	}

	public void setCapabilities(Set<Capability> capabilities) {
		this.capabilities = capabilities;
	}

	
	
	
	
}
