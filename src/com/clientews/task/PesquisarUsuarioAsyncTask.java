package com.clientews.task;

import java.util.List;

import android.os.AsyncTask;

import com.clientews.Interface.PesquisarUsuarioInterface;
import com.clientews.acessows.UsuarioREST;
import com.clientews.entidade.Usuario;

public class PesquisarUsuarioAsyncTask extends AsyncTask<String, Void, List<Usuario>> {
	
	private PesquisarUsuarioInterface pui;
	

	public PesquisarUsuarioAsyncTask(PesquisarUsuarioInterface pui) {
		super();
		this.pui = pui;
	}

	@Override
	protected List<Usuario> doInBackground(String... p) {
		UsuarioREST ur = new UsuarioREST();
		List<Usuario> usuarios;
		try {
			usuarios = ur.buscarUsuario(p[0]);
			return usuarios;
		} catch (Exception e) {
			
			return null;
		}
		
	}
	
	@Override
	protected void onPostExecute(List<Usuario> result) {
		pui.pesquisarUsuarioHandler(result);
		super.onPostExecute(result);
	}


}
