package com.mindtree.StatusManagementSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AccessoryType")
public class AccessoryType {

	@Id
	private String accessoryTypeId;
	
	@Column
	private String accessoryName;

	public AccessoryType() {
		super();
 	}

	public AccessoryType(String accessoryTypeId, String accessoryName) {
		super();
		this.accessoryTypeId = accessoryTypeId;
		this.accessoryName = accessoryName;
	}

	@Override
	public String toString() {
		return "AccessoryType [accessoryTypeId=" + accessoryTypeId + ", accessoryName=" + accessoryName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accessoryName == null) ? 0 : accessoryName.hashCode());
		result = prime * result + ((accessoryTypeId == null) ? 0 : accessoryTypeId.hashCode());
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
		AccessoryType other = (AccessoryType) obj;
		if (accessoryName == null) {
			if (other.accessoryName != null)
				return false;
		} else if (!accessoryName.equals(other.accessoryName))
			return false;
		if (accessoryTypeId == null) {
			if (other.accessoryTypeId != null)
				return false;
		} else if (!accessoryTypeId.equals(other.accessoryTypeId))
			return false;
		return true;
	}

	public String getAccessoryTypeId() {
		return accessoryTypeId;
	}

	public void setAccessoryTypeId(String accessoryTypeId) {
		this.accessoryTypeId = accessoryTypeId;
	}

	public String getAccessoryName() {
		return accessoryName;
	}

	public void setAccessoryName(String accessoryName) {
		this.accessoryName = accessoryName;
	}

	 
	
}
