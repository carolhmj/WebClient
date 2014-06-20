package com.example.clientews;

import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.clientews.Interface.GetListaUsuarioInterface;
import com.clientews.Interface.InserirUsuarioInterface;
import com.clientews.Interface.PesquisarUsuarioInterface;
import com.clientews.entidade.Usuario;
import com.clientews.task.GetListaUsuarioAsyncTask;
import com.clientews.task.InserirUsuarioAsyncTask;
import com.clientews.task.PesquisarUsuarioAsyncTask;

public class MainActivity extends Activity implements GetListaUsuarioInterface, PesquisarUsuarioInterface, InserirUsuarioInterface {

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
	
	public void chamaInserirUsuario(View v){
		String p = "";
		EditText nome = (EditText) findViewById(R.id.editText2);
		EditText cpf = (EditText) findViewById(R.id.editText3);
		p = ("{\"nomeUsuario\":" +"\""+ nome.getText().toString() + "\",\"cpfUsuario\":" + "\"" + cpf.getText().toString() + "\"}");
		System.out.println(p);
		inserirUsuario(p);
		limpaCamposUsuario();
	}
	
	public void limpaCamposUsuario(){
		EditText nome = (EditText) findViewById(R.id.editText2);
		EditText cpf = (EditText) findViewById(R.id.editText3);
		nome.setText("");
		cpf.setText("");
	}
	
	public void inserirUsuario(String p){
		new InserirUsuarioAsyncTask(this).execute(p);
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
	

	@Override
	public void inserirUsuarioHandler(String p) {
		System.out.println(p);
		
	}
}
