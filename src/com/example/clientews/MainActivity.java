package com.example.clientews;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.clientews.Interface.GetListaUsuarioInterface;
import com.clientews.Interface.PesquisarUsuarioInterface;
import com.clientews.entidade.Usuario;
import com.clientews.task.GetListaUsuarioAsyncTask;
import com.clientews.task.PesquisarUsuarioAsyncTask;

public class MainActivity extends Activity implements GetListaUsuarioInterface, PesquisarUsuarioInterface {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	}
	
	public void chamaTelaInicio(View v){
		setContentView(R.layout.activity_main);
	}
	
	public void chamaListarUsuario(View v) {
	    setContentView(R.layout.listar);
	    listarUsuario();
	}
	
	public void chamaLimparTexto(View v){
		EditText texto = (EditText) findViewById(R.id.editTextBusca);
		texto.setText(null);
	}
	
	public void listarUsuario(){
		
		new GetListaUsuarioAsyncTask(this).execute();
		
	}
	public void chamaPesquisarUsuario(View v){
		String p = "";
		EditText texto = (EditText) findViewById(R.id.editTextBusca);
		p = texto.getText().toString();
		setContentView(R.layout.listarbusca);
		pesquisarUsuario(p);
	}
	
	public void pesquisarUsuario(String p){
		new PesquisarUsuarioAsyncTask(this).execute(p);
	}

	@Override
	public void listaUsuarioHandler(List<Usuario> usuarios) {
		String listastring = "";
		TextView texto = (TextView) findViewById(R.id.textViewListaUsuario);
		if(usuarios != null){
			for (Usuario u : usuarios){
				listastring = listastring + "id: " + u.getIdUsuario() + "  Nome: " + u.getNomeUsuario()+ "  cpf: " + u.getCpfUsuario() + "\n";
			}
			texto.setText(listastring);
		}
		else{
			texto.setText("Não achou nada ou deu problema.");
		}
	}
	
	public void pesquisarUsuarioHandler(List<Usuario> usuarios) {
		String listastring = "";
		TextView texto = (TextView) findViewById(R.id.textViewListaUsuario);
		if(usuarios != null){
			for (Usuario u : usuarios){
				listastring = listastring + "id: " + u.getIdUsuario() + "  Nome: " + u.getNomeUsuario()+ "  cpf: " + u.getCpfUsuario() + "\n";
			}
			texto.setText(listastring);
		}
		else{
			texto.setText("Não foram encontrados resultados.");
		}
	}
}
