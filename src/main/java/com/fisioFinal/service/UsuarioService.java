package com.fisioFinal.service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.fisioFinal.dao.UsuarioDao;
import com.fisioFinal.domain.Usuario;
import com.google.gson.Gson;

@Path("usuario")
public class UsuarioService {

	@GET
	@Path("/{email}/{password}")
	public String tryLogin(@PathParam("email") String email,@PathParam("password") String password ) {
		UsuarioDao usuarioDao = new UsuarioDao();
		Usuario user = usuarioDao.tryLogin(email,password);
		
		Gson gson = new Gson();
		String json = gson.toJson(user);
		return json;
	}
	
	@GET
	@Path ("/{email}")
	public String getNameByEmail(@PathParam("email") String email){
		UsuarioDao usuarioDao = new UsuarioDao();
		String username = usuarioDao.buscarPorAtributo("email", email).getNome();
		Gson gson = new Gson();
		String json = gson.toJson(username);
		return json;
	}
		
	/*@POST
	@Path ("/{email}/addTrat/{tratCod}")
	public String addTrat(@PathParam("email") String email, @PathParam("tratCod") long tratCod){
		UsuarioDao userDao= new UsuarioDao();
		long userCode = userDao.buscaPorEmail(email).getCodigo();
		FiltroTratamentoDao tratDao = new FiltroTratamentoDao();
		long tratCode = tratDao.buscaPorCodigo(tratCod).getCodigo();
		
		
	}*/
	
	
	@POST
	public String salvar(String json){
		Gson gson = new Gson();
		Usuario user = gson.fromJson(json, Usuario.class);
		
		UsuarioDao usuarioDao = new UsuarioDao();
		usuarioDao.salvar(user);
		
		String jsonSaida = gson.toJson(user);
		
		if(jsonSaida.contains("\"codigo\":0"))jsonSaida ="Operação não pode ser realizada:Nome de usuário já existente";
		
		return jsonSaida;
	}
}
