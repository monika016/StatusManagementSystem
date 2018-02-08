package com.mindtree.StatusManagementSystem.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
 

@Entity
@Table(name = "Capability")
public class Capability {

	@Id
	private String capabilityId;
	
	@Column
	private String capabilityName;

	
	@ManyToOne(fetch = FetchType.EAGER,cascade={CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
	@JoinColumn(name = "trackId")
	@JsonBackReference
	private Track track;


	public Capability() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Capability(String capabilityId, String capabilityName, Track track) {
		super();
		this.capabilityId = capabilityId;
		this.capabilityName = capabilityName;
		this.track = track;
	}


	@Override
	public String toString() {
		return "Capability [capabilityId=" + capabilityId + ", capabilityName=" + capabilityName + ", track=" + track
				+ "]";
	}

//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((capabilityId == null) ? 0 : capabilityId.hashCode());
//		result = prime * result + ((capabilityName == null) ? 0 : capabilityName.hashCode());
//		result = prime * result + ((track == null) ? 0 : track.hashCode());
//		return result;
//	}
//

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Capability other = (Capability) obj;
		if (capabilityId == null) {
			if (other.capabilityId != null)
				return false;
		} else if (!capabilityId.equals(other.capabilityId))
			return false;
		if (capabilityName == null) {
			if (other.capabilityName != null)
				return false;
		} else if (!capabilityName.equals(other.capabilityName))
			return false;
		if (track == null) {
			if (other.track != null)
				return false;
		} else if (!track.equals(other.track))
			return false;
		return true;
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


	public Track getTrack() {
		return track;
	}


	public void setTrack(Track track) {
		this.track = track;
	}

			
}
