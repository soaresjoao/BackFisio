package com.fisioFinal.service;

import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.fisioFinal.dao.FiltroTratamentoDao;
import com.fisioFinal.domain.FiltroTratamento;
import com.google.gson.Gson;

@Path("filtro")
public class FiltroTratamentoService {
	
	
	@GET
	public String Listar(){
		FiltroTratamentoDao filtroTratamentoDao = new FiltroTratamentoDao();
		List<FiltroTratamento> filtros = filtroTratamentoDao.listar("diagnostigo");
		
		Gson gson = new Gson();
		String json = gson.toJson(filtros);
		
		return json;
		
	}
	
	/*@GET
	public String listar() {
		FiltroTratamentoDao filtroTratamentoDao = new FiltroTratamentoDao();
		List<FiltroTratamento> filtros = filtroTratamentoDao.listar("link");

		Gson gson = new Gson();
		String json = gson.toJson(filtros);

		return json;
	}*/
/*/{tempoLessao}  , @PathParam("tempoLessao") String tempoLessao  , tempoLessao*/
	@GET
	@Path("/{diagnostigo}/{tempoLesao}")
	public String buscar(@PathParam("diagnostigo") String diagnostigo,@PathParam("tempoLesao") String tempoLesao ) {
		FiltroTratamentoDao filtroTratamentoDao = new FiltroTratamentoDao();
		List<FiltroTratamento> filtro = filtroTratamentoDao.buscar(diagnostigo,tempoLesao);
		
		LinkedList<FiltroTratamento>finalFilter = new LinkedList<FiltroTratamento>();
		double relevance=0;
		Calendar now = Calendar.getInstance();   
		int year = now.get(Calendar.YEAR);  
		
		for(int i=0;i<filtro.size();i++){
			relevance=0;
			FiltroTratamento aux = filtro.get(i);
			//fazer os aumentos e diminuições de relevancia aqui de acordo com os atributos dos tratamentos
			relevance-=(year - (int)Integer.valueOf(aux.getAnoPublicacao()))*(0.15);
			relevance+=2*(aux.getQuantCurtidas()/aux.getTotalUsos());
			if(aux.getTempoLesao().equals(tempoLesao))relevance+=10;
			System.out.println("Relevance para o resultado "+ aux.getCodigo()+": "+relevance);
			filtro.get(i).setRelevance(relevance);
		}
		
		Collections.sort(filtro, new Comparator<FiltroTratamento>() {
		        public int compare(FiltroTratamento o1, FiltroTratamento o2) {
		            return o1.getRelevance()<o2.getRelevance()?1:o1.getRelevance()>o2.getRelevance()?-1:0;
		        }
		 });
			
		for(int i=0;i<3;i++){
			finalFilter.add(filtro.get(i));
			System.out.println(finalFilter.get(i).getLink() + " - " + finalFilter.get(i).getRelevance());
		}
		
		Gson gson = new Gson();
		String json = gson.toJson(finalFilter);

		return json;
	}
}
