package com.mindtree.StatusManagementSystem.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Accessory")
public class Accessory {

	@Id
	private String accessoryId;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinColumn(name = "accessoryTypeId")
	private AccessoryType accessoryType;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinColumn(name = "mid")
	@JsonBackReference
	private CampusMind assignedTo;

	@Column
	private String status;

	public Accessory() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accessoryId == null) ? 0 : accessoryId.hashCode());
		result = prime * result + ((accessoryType == null) ? 0 : accessoryType.hashCode());
		result = prime * result + ((assignedTo == null) ? 0 : assignedTo.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Accessory other = (Accessory) obj;
		if (accessoryId == null) {
			if (other.accessoryId != null)
				return false;
		} else if (!accessoryId.equals(other.accessoryId))
			return false;
		if (accessoryType == null) {
			if (other.accessoryType != null)
				return false;
		} else if (!accessoryType.equals(other.accessoryType))
			return false;
		if (assignedTo == null) {
			if (other.assignedTo != null)
				return false;
		} else if (!assignedTo.equals(other.assignedTo))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	public Accessory(String accessoryId, AccessoryType accessoryType, CampusMind assignedTo, String status) {
		super();
		this.accessoryId = accessoryId;
		this.accessoryType = accessoryType;
		this.assignedTo = assignedTo;
		this.status = status;
	}

	 

	@Override
	public String toString() {
		return "Accessory [accessoryId=" + accessoryId + ", accessoryType=" + accessoryType + ", assignedTo="
				+ assignedTo + ", status=" + status + "]";
	}

	public String getAccessoryId() {
		return accessoryId;
	}

	public void setAccessoryId(String accessoryId) {
		this.accessoryId = accessoryId;
	}

	public AccessoryType getAccessoryType() {
		return accessoryType;
	}

	public void setAccessoryType(AccessoryType accessoryType) {
		this.accessoryType = accessoryType;
	}

	public CampusMind getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(CampusMind assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
