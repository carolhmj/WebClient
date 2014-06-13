package com.clientews.acessows;

import java.util.ArrayList;
import java.util.List;

import com.clientews.entidade.Usuario;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class UsuarioREST {

	// EX: 200.153.36.140:8070
	private static String URI = "http://192.168.1.20:8081/ServerWS/"; 

	public List<Usuario> getUsuario() throws Exception {
		
		// Array de String que recebe o JSON do Web Service
		String[] json = new WebService().get(URI + "usuario/listar");

		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		if (json[0].equals("200")) {
			
			Gson gson = new Gson();

			JsonParser parser = new JsonParser();

			// Fazendo o parse do JSON para um JsonArray
			JsonArray array = parser.parse(json[1]).getAsJsonArray();
			System.out.println(array.toString());

			for (int i = 0; i < array.size(); i++) {

				// Adicionando na lista a posicao atual do JsonArray
				usuarios.add(gson.fromJson(array.get(i), Usuario.class));
			}
			// retornado a lista que consumiu do WS
			for(Usuario u : usuarios){
				System.out.println(u.getNomeUsuario());
			}
			
			return usuarios;

		} else {
			throw new Exception(json[1]);
		}

	}}