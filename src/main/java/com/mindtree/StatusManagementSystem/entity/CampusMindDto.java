package com.mindtree.StatusManagementSystem.entity;

public class CampusMindDto {

	private String mid;

	private String name;
	
	private String track;

	public CampusMindDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CampusMindDto(String mid, String name, String track) {
		super();
		this.mid = mid;
		this.name = name;
		this.track = track;
	}

	@Override
	public String toString() {
		return "CampusMindDto [mid=" + mid + ", name=" + name + ", track=" + track + "]";
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTrack() {
		return track;
	}

	public void setTrack(String track) {
		this.track = track;
	}

	
	
}
