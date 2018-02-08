package com.mindtree.StatusManagementSystem.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonManagedReference;
 
@Entity
@Table(name = "Track")
public class Track {

	@Id
	private String trackId;
	
	@Column
	private String trackName;

	@OneToMany(mappedBy = "capabilityId",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	private Set<Capability> capabilities = new HashSet<Capability>();

	public Track() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Track(String trackId, String trackName, Set<Capability> capabilities) {
		super();
		this.trackId = trackId;
		this.trackName = trackName;
		this.capabilities = capabilities;
	}

	@Override
	public String toString() {
		return "Track [trackId=" + trackId + ", trackName=]";
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((capabilities == null) ? 0 : capabilities.hashCode());
//		result = prime * result + ((trackId == null) ? 0 : trackId.hashCode());
//		result = prime * result + ((trackName == null) ? 0 : trackName.hashCode());
//		return result;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capabilities == null) ? 0 : capabilities.hashCode());
		result = prime * result + ((trackId == null) ? 0 : trackId.hashCode());
		result = prime * result + ((trackName == null) ? 0 : trackName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Track other = (Track) obj;
		if (capabilities == null) {
			if (other.capabilities != null)
				return false;
		} else if (!capabilities.equals(other.capabilities))
			return false;
		if (trackId == null) {
			if (other.trackId != null)
				return false;
		} else if (!trackId.equals(other.trackId))
			return false;
		if (trackName == null) {
			if (other.trackName != null)
				return false;
		} else if (!trackName.equals(other.trackName))
			return false;
		return true;
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
