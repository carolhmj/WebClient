package com.clientews.task;

import java.util.ArrayList;
import java.util.List;

import android.os.AsyncTask;

import com.clientews.Interface.GetListaUsuarioInterface;
import com.clientews.acessows.UsuarioREST;
import com.clientews.entidade.Usuario;


public class GetListaUsuarioAsyncTask extends AsyncTask<Void, Void, List<Usuario>> {
	
	private GetListaUsuarioInterface glui;
	

	public GetListaUsuarioAsyncTask(GetListaUsuarioInterface glui) {
		super();
		this.glui = glui;
	}

	@Override
	protected List<Usuario> doInBackground(Void... params) {
		UsuarioREST cr = new UsuarioREST();
		List<Usuario> usuarios;
		List<Usuario> usuarios2 = new ArrayList<Usuario>();
		Usuario u = new Usuario();
		u.setIdUsuario(55);
		u.setNomeUsuario("Deu erro");
		u.setCpfUsuario("234.345.678-12");
		usuarios2.add(u);
		try {
			usuarios = cr.getUsuario();
			return usuarios;
		} catch (Exception e) {
			
			return usuarios2;
		}
		
	}
	
	@Override
	protected void onPostExecute(List<Usuario> result) {
		glui.listaUsuarioHandler(result);
		super.onPostExecute(result);
	}


}
