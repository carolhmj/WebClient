package com.clientews.acessows;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.clientews.entidade.Usuario;


public class UsuarioREST {

	// EX: 200.153.36.140:8070
	private static String URI = "http://192.168.1.20:8081/ServerWS/"; 

	public List<Usuario> getUsuario() throws Exception {
		
		// Array de String que recebe o JSON do Web Service
		String[] json = new WebService().get(URI + "usuario/listar");
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		JSONArray uarray = new JSONObject(json[1]).getJSONArray("usuario");
		JSONObject usuariojson;
		

		if (json[0].equals("200")) {
			

			// Fazendo o parse do JSON para um JsonArray
			for(int i = 0; i<uarray.length(); i++){
				usuariojson = uarray.getJSONObject(i);
				Usuario usuario = new Usuario();
				usuario.setCpfUsuario(usuariojson.getString("cpfUsuario"));
				usuario.setIdUsuario(usuariojson.getInt("idUsuario"));
				usuario.setNomeUsuario(usuariojson.getString("nomeUsuario"));
				usuarios.add(usuario);
				System.out.println(usuarios.toString());
			}
			
			// retornado a lista que consumiu do WS
			for(Usuario u : usuarios){
				System.out.println(u.getNomeUsuario());
			}
			
			return usuarios;

		} else {
			throw new Exception(json[1]);
		}

	}
	
public List<Usuario> buscarUsuario(String p) throws Exception {
		
		// Array de String que recebe o JSON do Web Service
		String[] json = new WebService().post(URI + "usuario/pesquisar", p);
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		JSONArray uarray = new JSONObject(json[1]).getJSONArray("usuario");
		JSONObject usuariojson;
		

		if (json[0].equals("200")) {
			

			// Fazendo o parse do JSON para um JsonArray
			for(int i = 0; i<uarray.length(); i++){
				usuariojson = uarray.getJSONObject(i);
				Usuario usuario = new Usuario();
				usuario.setCpfUsuario(usuariojson.getString("cpfUsuario"));
				usuario.setIdUsuario(usuariojson.getInt("idUsuario"));
				usuario.setNomeUsuario(usuariojson.getString("nomeUsuario"));
				usuarios.add(usuario);
				System.out.println(usuarios.toString());
			}
			
			// retornado a lista que consumiu do WS
			for(Usuario u : usuarios){
				System.out.println(u.getNomeUsuario());
			}
			
			return usuarios;

		} else {
			throw new Exception(json[1]);
		}

	}
}