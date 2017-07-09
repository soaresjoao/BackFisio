package com.fisioFinal.service;

import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import javax.management.RuntimeErrorException;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.fisioFinal.dao.FiltroTratamentoDao;
import com.fisioFinal.domain.FiltroTratamento;
import com.google.gson.Gson;

@Path("filtro")
public class FiltroTratamentoService {

	@PUT
	@Path("update/{codigo}/{positiveOrNegative}/{notaTempoTratamento}/{notaEficacia}")
	public String editar(@PathParam("codigo") long codigo,@PathParam("positiveOrNegative") int posOrNeg,@PathParam("notaTempoTratamento") double notaTempTrat,@PathParam("notaEficacia") double notaEficacia){		
		FiltroTratamentoDao fDao = new FiltroTratamentoDao();
		FiltroTratamento ft = fDao.buscarPorAtributo("codigo",codigo);
		if(ft==null)throw new RuntimeException();
		if(posOrNeg==1)ft.setAvaliacoesPositivas(ft.getAvaliacoesPositivas()+1);
		else ft.setAvaliacoesNegativas(ft.getAvaliacoesNegativas()+1);
		ft.setMediaComentEficacia((ft.getMediaComentEficacia()+notaEficacia)/(2));
		ft.setMediaComentTempoTrat((ft.getMediaComentTempoTrat()+notaTempTrat)/(2));
		fDao.editar(ft);
		Gson gson = new Gson();
		String jsonSaida = gson.toJson(ft);
		return jsonSaida;
	}
	
	@GET
	public String Listar(){
		FiltroTratamentoDao filtroTratamentoDao = new FiltroTratamentoDao();
		List<FiltroTratamento> filtros = filtroTratamentoDao.listar("diagnostigo");
		
		Gson gson = new Gson();
		String json = gson.toJson(filtros);
		
		return json;
		
	}
	@GET
	@Path("/{codigo}/comentarios")
	public String buscarComentarios(@PathParam("codigo") long codigo){
		FiltroTratamentoDao filtroTratamentoDao = new FiltroTratamentoDao();
		FiltroTratamento tratamento = filtroTratamentoDao.buscarPorAtributo("codigo", codigo);
		
		List<Double> resultComments = new LinkedList<Double>();
		resultComments.add(tratamento.getMediaComentTempoTrat());
		resultComments.add(tratamento.getMediaComentEficacia());
		resultComments.add((double)(tratamento.getAvaliacoesNegativas()+tratamento.getAvaliacoesPositivas()));
		
		Gson gson = new Gson();
		String json = gson.toJson(resultComments);
		return json;
	}
	
	@GET
	@Path("/{codigo}")
	public String buscaSimples(@PathParam("codigo") long codigo){
		FiltroTratamentoDao filtroTratamentoDao = new FiltroTratamentoDao();
		FiltroTratamento tratamento = filtroTratamentoDao.buscarPorAtributo("codigo", codigo);
		List<FiltroTratamento> tratList = new LinkedList<FiltroTratamento>();
		tratList.add(tratamento);
		Gson gson = new Gson();
		String json = gson.toJson(tratList);
		return json;
	}
	
	@GET
	@Path("/{diagnostigo}/{tempoLesao}/{faixaEtaria}/{sexo}")
	public String buscar(@PathParam("diagnostigo") String diagnostigo,@PathParam("tempoLesao") String tempoLesao,@PathParam("faixaEtaria") String faixaEtaria,@PathParam("sexo") String sexo) {
		FiltroTratamentoDao filtroTratamentoDao = new FiltroTratamentoDao();
		List<FiltroTratamento> filtro = filtroTratamentoDao.buscar(diagnostigo);
		
		LinkedList<FiltroTratamento>finalFilter = new LinkedList<FiltroTratamento>();
		double relevance=0;
		Calendar now = Calendar.getInstance();   
		int year = now.get(Calendar.YEAR);
		int sexoToInt=0;
		if(sexo.equals("Homem"))sexoToInt=1;
		for(int i=0;i<filtro.size();i++){
			relevance=0;
			FiltroTratamento aux = filtro.get(i);
			//fazer os aumentos e diminuições de relevancia aqui de acordo com os atributos dos tratamentos
			relevance-=(year - (int)Integer.valueOf(aux.getAnoPublicacao()))*(0.15);
			int totAval = aux.getAvaliacoesNegativas()+aux.getAvaliacoesNegativas();
			if(totAval==0)totAval++;
			relevance+=2*((aux.getAvaliacoesPositivas()-aux.getAvaliacoesNegativas())/(totAval));
			relevance+=(aux.getMediaComentEficacia()+aux.getMediaComentTempoTrat())*(0.2);
			if(aux.getTempoLesao().equals(tempoLesao)){
				relevance+=10;
			}
			if(aux.getSexo()==sexoToInt){
				relevance+=10;
			}
			else if(aux.getSexo()==2)relevance+=6;
			if(aux.getFaixaEtaria().equals(faixaEtaria)){
				relevance+=10;
			}
			filtro.get(i).setRelevance(relevance);
		}
		
		Collections.sort(filtro, new Comparator<FiltroTratamento>() {
		        public int compare(FiltroTratamento o1, FiltroTratamento o2) {
		            return o1.getRelevance()<o2.getRelevance()?1:o1.getRelevance()>o2.getRelevance()?-1:0;
		        }
		 });
		
		for(int i=0;i<3;i++){
			finalFilter.add(filtro.get(i));
		}
		
		Gson gson = new Gson();
		String json = gson.toJson(finalFilter);

		return json;
	}
}
