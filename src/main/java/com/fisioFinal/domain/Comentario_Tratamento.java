package com.fisioFinal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Comentario_Tratamento extends GenericDomain {
	@Column(nullable = false)
	private String userEmail;
	
	@Column(nullable = false)
	private long tratID;
	
	@Column(nullable = true)
	private String comentario;

	public String getUserEmail() {
		return userEmail;
	}

	public long getTratID() {
		return tratID;
	}
	
	public String getComentario(){
		return comentario;
	}

	public void setUserEmail(String userEmail){
		this.userEmail=userEmail;
	}
	
	public void setTratId(long tratID){
		this.tratID=tratID;
	}
	
	public void setComentario(String comentario){
		this.comentario=comentario;
	}
	
}
