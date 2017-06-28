package com.fisioFinal.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.fisioFinal.dao.Comentario_TratamentoDao;
import com.fisioFinal.dao.FiltroTratamentoDao;
import com.fisioFinal.domain.Comentario_Tratamento;
import com.fisioFinal.domain.FiltroTratamento;
import com.google.gson.Gson;

@Path("comment_trat")
public class Comentario_TratamentoService {
	@POST
	public String salvar(String json){
		Gson gson = new Gson();
		Comentario_Tratamento comentarioTrat = gson.fromJson(json, Comentario_Tratamento.class);
		
		Comentario_TratamentoDao comentarioTratDao = new Comentario_TratamentoDao();
		comentarioTratDao.salvar(comentarioTrat);
		
		String jsonSaida = gson.toJson(comentarioTrat);
		
		if(jsonSaida.contains("\"codigo\":0"))jsonSaida ="Operação não pode ser realizada";
		
		return jsonSaida;
	}
	
	
	@GET
	@Path("/{tratCode}")
	public String getByTratCode(@PathParam("tratCode") long tratCode){
		Gson gson = new Gson();
		FiltroTratamentoDao fDao = new FiltroTratamentoDao();
		FiltroTratamento trat = fDao.buscarPorAtributo("codigo", tratCode);		
		
		if(trat==null)throw new RuntimeException();
		Comentario_TratamentoDao comentarioTratDao = new Comentario_TratamentoDao();		
		List<Comentario_Tratamento> comentarios = comentarioTratDao.buscaPorTratamento(tratCode);
		
		String jsonSaida = gson.toJson(comentarios);
		return jsonSaida;		
	}
	
	
	

}
