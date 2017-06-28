package com.fisioFinal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Usuario_Tratamento extends GenericDomain  {

	@Column(nullable = false)
	private String userEmail;
	
	@Column(nullable = false)
	private long tratID;

	public String getUserID() {
		return userEmail;
	}

	public long getTratID() {
		return tratID;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public void setTratID(long tratID) {
		this.tratID = tratID;
	}
}
