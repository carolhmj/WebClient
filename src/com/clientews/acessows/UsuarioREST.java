package com.clientews.acessows;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.clientews.entidade.Usuario;


public class UsuarioREST {

	// EX: 200.153.36.140:8070
	private static String URI = "http://192.168.1.100:8081/ServerWS/"; 

	public List<Usuario> getUsuario() throws Exception {
		
		// Array de String que recebe o JSON do Web Service
		String[] json = new WebService().get(URI + "usuario/listar");
		JSONObject ujson = new JSONObject(json[1]);
		JSONArray uarray = ujson.getJSONArray("Usuario");
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		if (json[0].equals("200")) {
			

			// Fazendo o parse do JSON para um JsonArray
			System.out.println(json[1].toString());
			System.out.println(ujson.toString());
			System.out.println(uarray.toString());
			
			// retornado a lista que consumiu do WS
			for(Usuario u : usuarios){
				System.out.println(u.getNomeUsuario());
			}
			
			return usuarios;

		} else {
			throw new Exception(json[1]);
		}

	}}