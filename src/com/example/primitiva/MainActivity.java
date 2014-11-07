package com.example.primitiva;

//import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	
	private Primitiva prim;
	TextView resul;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		resul = (TextView)findViewById(R.id.numeros);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void numerosGanadores(View v){	
		int[] resultado;
		String cadena;
		cadena ="";
		prim = new Primitiva();
		resultado = prim.generarNumeros();
		for(int i=0;i<resultado.length;i++){
			 cadena += resultado[i]+", " ;
		}
		resul.setText(cadena);
		
		SharedPreferences prefs =
			     getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = prefs.edit();
		editor.putString("numeros", cadena);
		editor.commit();
		
		//modificar esto no puede estar en oncreate
		if(resul!= null){
			SharedPreferences prefs =
				     getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
			int i  =  prefs.getInt("numeros",0);
			resul.setText(i);
		}
	
	}
}
