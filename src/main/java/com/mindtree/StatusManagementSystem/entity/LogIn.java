	package com.mindtree.StatusManagementSystem.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LogIn")
public class LogIn {

	@Id
	private String mid;

	@Column
	private String password;

	public LogIn() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LogIn(String mid, String password) {
		super();
		this.mid = mid;
		this.password = password;
	}

	@Override
	public String toString() {
		return "LogIn [mid=" + mid + ", password=" + password + "]";
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}



