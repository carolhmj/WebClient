package com.clientews.task;

import java.util.List;

import com.clientews.Interface.InserirUsuarioInterface;
import com.clientews.acessows.UsuarioREST;
import com.clientews.entidade.Usuario;

import android.os.AsyncTask;

public class InserirUsuarioAsyncTask extends AsyncTask<String, Void, String>{
	
	private InserirUsuarioInterface iui;

	public InserirUsuarioAsyncTask(InserirUsuarioInterface iui) {
		super();
		this.iui = iui;
	}

	@Override
	protected String doInBackground(String... p) {
		UsuarioREST ur = new UsuarioREST();
		String result = "";
		try {
			result = ur.inserirUsuario(p[0]);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	protected void onPostExecute(String result) {
		iui.inserirUsuarioHandler(result);
		super.onPostExecute(result);
	}

}
