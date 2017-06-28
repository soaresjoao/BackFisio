package com.fisioFinal.domain;


import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;


@SuppressWarnings("serial")
@Entity
public class Usuario extends GenericDomain {

	@Column(length = 100, nullable = false,unique=true)
	private String email;
	
	@Column(length = 50, nullable = false)
	private String password;
	
	@Column(length = 50, nullable = false)
	private String nome;
	
	@Column(length = 50, nullable = true,unique=true)
	private String coffito;
	
	
	
	/*@ManyToMany(mappedBy="usuarios")
	private List<FiltroTratamento> listaTratamentos=null;
	*/
	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
	
	/*public List<FiltroTratamento> getTratamento() {
		return tratamentos;
	}*/

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	/*public void setEstado(List<FiltroTratamento> tratamentos) {
		this.tratamentos = tratamentos;
	}*/
	
	
}
