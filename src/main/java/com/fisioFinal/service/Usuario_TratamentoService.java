package com.fisioFinal.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.fisioFinal.dao.UsuarioDao;
import com.fisioFinal.dao.Usuario_TratamentoDao;
import com.fisioFinal.domain.FiltroTratamento;
import com.fisioFinal.domain.Usuario;
import com.fisioFinal.domain.Usuario_Tratamento;
import com.google.gson.Gson;

@Path("user_trat")
public class Usuario_TratamentoService {
	
	@POST
	public String salvar(String json){
		Gson gson = new Gson();
		Usuario_Tratamento userTrat = gson.fromJson(json, Usuario_Tratamento.class);
		
		Usuario_TratamentoDao userTratDao = new Usuario_TratamentoDao();
		userTratDao.salvar(userTrat);
		
		String jsonSaida = gson.toJson(userTrat);
		
		if(jsonSaida.contains("\"codigo\":0"))jsonSaida ="Operação não pode ser realizada";
		
		return jsonSaida;
	}
	
	@GET
	@Path("/{email}/{tratOrCodes}")
	public String getByUserCode(@PathParam("email") String email,@PathParam("tratOrCodes") int tratOrCodes){
		Gson gson = new Gson();
		UsuarioDao userDao = new UsuarioDao();
		Usuario user = userDao.buscarPorAtributo("email", email);		
		if(user==null)throw new RuntimeException();
		Usuario_TratamentoDao userTratDao = new Usuario_TratamentoDao();
		String jsonSaida=null;
		if(tratOrCodes==1){
		  List<FiltroTratamento> userTrat = userTratDao.buscaPorEmail(email);
		  jsonSaida = gson.toJson(userTrat);			
		}
		else{
		  List<Integer> codes = userTratDao.buscaCodigosPorEmail(email);
		  jsonSaida = gson.toJson(codes);	
		}
		return jsonSaida;		
	}
	
	@DELETE
	@Path ("/{codigo}")
	public String excluir(@PathParam("codigo") long codigo){
		Gson gson = new Gson();
		
		Usuario_TratamentoDao userTratDao = new Usuario_TratamentoDao();
		Usuario_Tratamento userTrat = userTratDao.buscarPorAtributo("codigo", codigo);
		userTratDao.excluir(userTrat);
		
		String jsonSaida = gson.toJson(userTrat);
		
		return jsonSaida;
	}
}
