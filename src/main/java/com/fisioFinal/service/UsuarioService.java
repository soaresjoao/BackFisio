package com.fisioFinal.service;

import java.util.List;

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
	@Path("/{coffito}/{password}")
	public String tryLogin(@PathParam("coffito") String coffito,@PathParam("password") String password ) {
		UsuarioDao usuarioDao = new UsuarioDao();
		Usuario user = usuarioDao.tryLogin(coffito,password);
		
		Gson gson = new Gson();
		String toReturn=null;
		if(user!=null)toReturn=user.getNome();
		String json = gson.toJson(toReturn);

		return json;
	}
	
	
	@POST
	public String salvar(String json){
		Gson gson = new Gson();
		Usuario user = gson.fromJson(json, Usuario.class);
		
		UsuarioDao usuarioDao = new UsuarioDao();
		usuarioDao.salvar(user);
		
		String jsonSaida = gson.toJson(user);
		
		if(jsonSaida.contains("\"codigo\":0"))jsonSaida = "Operação não pode ser realizada:Nome de usuário já existente";
		
		return jsonSaida;
	}
}
