package com.mindtree.StatusManagementSystem.entity;

public class CapabilityDto {
	private String capabilityId;
	private String capabilityName;
	private String trackId;
	public CapabilityDto() {
		super();
 	}
	public CapabilityDto(String capabilityId, String capabilityName, String trackId) {
		super();
		this.capabilityId = capabilityId;
		this.capabilityName = capabilityName;
		this.trackId = trackId;
	}
	@Override
	public String toString() {
		return "CapabilityDto [capabilityId=" + capabilityId + ", capabilityName=" + capabilityName + ", trackId="
				+ trackId + "]";
	}
	public String getCapabilityId() {
		return capabilityId;
	}
	public void setCapabilityId(String capabilityId) {
		this.capabilityId = capabilityId;
	}
	public String getCapabilityName() {
		return capabilityName;
	}
	public void setCapabilityName(String capabilityName) {
		this.capabilityName = capabilityName;
	}
	public String getTrackId() {
		return trackId;
	}
	public void setTrackId(String trackId) {
		this.trackId = trackId;
	}

	
	
	
}
