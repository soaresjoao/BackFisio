package com.fisioFinal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class FiltroTratamento extends GenericDomain{
	//INPUTS
	@Column(length = 100, nullable = false)
	private String diagnostigo; 
	
	@Column(length = 50, nullable = false)
	private String tempoLesao;//aguda ou cronica
	
	@Column(length = 50, nullable = false)
	private String faixaEtaria;//crianca,adulto ou idoso
	
	@Column(nullable = false)
	private int sexo;//0=fem,1=masc,2=masc&fem
	
	//OUTPUT Primario
	@Column(length = 500, nullable = false)
	private String titulo;
	
	@Column(length = 500, nullable = false)
	private String link;
	
	@Column(nullable = true)
	private String duracaoTrat;//em semanas
	
	@Column(nullable = false)
	private String numeroParticipantes;
	
	@Column(columnDefinition="TEXT", nullable=false)
	private String resumo;
	
	@Column(columnDefinition="TEXT", nullable=false)
	private String tratamento;
	
	//OUTPUT secundario
	
	@Column(length = 50, nullable = false)
	private String anoPublicacao;
	
	@Column(nullable = false)
	private int avaliacoesPositivas;
	
	@Column(nullable = false)
	private int avaliacoesNegativas;
	
	@Column(nullable = false)
	private int totalUsos;
	
	@Column(nullable = false)
	private double mediaComentTempoTrat;
	
	@Column(nullable = false)
	private double mediaComentEficacia;
	
	double relevance;

	public String getDiagnostigo() {
		return diagnostigo;
	}

	public void setDiagnostigo(String diagnostigo) {
		this.diagnostigo = diagnostigo;
	}

	public String getTempoLesao() {
		return tempoLesao;
	}

	public void setTempoLesao(String tempoLesao) {
		this.tempoLesao = tempoLesao;
	}

	public String getFaixaEtaria() {
		return faixaEtaria;
	}

	public void setFaixaEtaria(String faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
	}

	public int getSexo() {
		return sexo;
	}

	public void setSexo(int sexo) {
		this.sexo = sexo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getNumeroParticipantes() {
		return numeroParticipantes;
	}

	public void setNumeroParticipantes(String numeroParticipantes) {
		this.numeroParticipantes = numeroParticipantes;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getTratamento() {
		return tratamento;
	}

	public void setTratamento(String tratamento) {
		this.tratamento = tratamento;
	}

	public String getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(String anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public int getAvaliacoesPositivas() {
		return avaliacoesPositivas;
	}

	public void setAvaliacoesPositivas(int avaliacoesPositivas) {
		this.avaliacoesPositivas = avaliacoesPositivas;
	}

	public int getAvaliacoesNegativas() {
		return avaliacoesNegativas;
	}

	public void setAvaliacoesNegativas(int avaliacoesNegativas) {
		this.avaliacoesNegativas = avaliacoesNegativas;
	}

	public int getTotalUsos() {
		return totalUsos;
	}

	public void setTotalUsos(int totalUsos) {
		this.totalUsos = totalUsos;
	}

	public double getMediaComentTempoTrat() {
		return mediaComentTempoTrat;
	}

	public void setMediaComentTempoTrat(double mediaComentTempoTrat) {
		this.mediaComentTempoTrat = mediaComentTempoTrat;
	}

	public double getMediaComentEficacia() {
		return mediaComentEficacia;
	}

	public void setMediaComentEficacia(double mediaComentEficacia) {
		this.mediaComentEficacia = mediaComentEficacia;
	}

	public double getRelevance() {
		return relevance;
	}

	public void setRelevance(double relevance) {
		this.relevance = relevance;
	}

	public String getDuracaoTrat() {
		return duracaoTrat;
	}

	public void setDuracaoTrat(String duracaoTrat) {
		this.duracaoTrat = duracaoTrat;
	}
	
}