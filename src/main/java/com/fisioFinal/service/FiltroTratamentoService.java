package com.fisioFinal.service;

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

		Gson gson = new Gson();
		String json = gson.toJson(filtro);

		return json;
	}
}
