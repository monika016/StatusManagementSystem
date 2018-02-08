package com.mindtree.StatusManagementSystem.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonManagedReference;

 
@Entity
@Table(name="CampusMind")
public class CampusMind {

	@Id
	private String mid;
	
	@Column
	private String name;
	
	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "trackId")
	private Track track;

	
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<Accessory> accessories = new ArrayList<Accessory>();



	public CampusMind() {
		super();
		// TODO Auto-generated constructor stub
	}



	public CampusMind(String mid, String name, Track track, List<Accessory> accessories) {
		super();
		this.mid = mid;
		this.name = name;
		this.track = track;
		this.accessories = accessories;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accessories == null) ? 0 : accessories.hashCode());
		result = prime * result + ((mid == null) ? 0 : mid.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((track == null) ? 0 : track.hashCode());
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
		CampusMind other = (CampusMind) obj;
		if (accessories == null) {
			if (other.accessories != null)
				return false;
		} else if (!accessories.equals(other.accessories))
			return false;
		if (mid == null) {
			if (other.mid != null)
				return false;
		} else if (!mid.equals(other.mid))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (track == null) {
			if (other.track != null)
				return false;
		} else if (!track.equals(other.track))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "CampusMind [mid=" + mid + ", name=" + name + ", track=" + track + ", accessories=" + accessories + "]";
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



	public Track getTrack() {
		return track;
	}



	public void setTrack(Track track) {
		this.track = track;
	}



	public List<Accessory> getAccessories() {
		return accessories;
	}



	public void setAccessories(List<Accessory> accessories) {
		this.accessories = accessories;
	}
	
	
	
	
}
