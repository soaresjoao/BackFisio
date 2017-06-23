package com.fisioFinal.domain;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@SuppressWarnings("serial")
@Entity
public class Usuario extends GenericDomain {
	
	@Column(length = 100, nullable = false,unique=true)
	private String coffito;
	
	@Column(length = 50, nullable = false)
	private String password;
	
	@Column(length = 50, nullable = false)
	private String nome;
	
	/*@ManyToMany(mappedBy="usuarios")
	private List<FiltroTratamento> listaTratamentos=null;
	*/
	public String getCoffito() {
		return coffito;
	}

	public String getPassword() {
		return password;
	}
	
	/*public List<FiltroTratamento> getTratamento() {
		return tratamentos;
	}*/

	public void setCoffito(String coffito) {
		this.coffito = coffito;
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
