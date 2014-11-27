package com.example.primitiva;

//import android.support.v7.app.ActionBarActivity;
import java.util.Arrays;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	// hacer una instancia de primitiva(clase) pero no es actividad
	// poner arraylist de enteros - generarcombinacion

	TextView resul;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		resul = (TextView) findViewById(R.id.numeros);

		// numerosGanadores(null);

		SharedPreferences prefe = getSharedPreferences("MisPreferencias",
				Context.MODE_PRIVATE);
		resul.setText(prefe.getString("numeros", ""));

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

	public void numerosGanadores(View v) {
		
		int[] resultado;
		String cadena;
		cadena = "";
		resultado = Primitiva.generarCombinacion();
		Arrays.sort(resultado);//ordenar de menor a mayor
		for (int i = 0; i < resultado.length; i++) {
			cadena += resultado[i] + (", ");
		}

		String ncadena = cadena.substring(0, cadena.length() - 2);// sacar coma
																	// del final
		resul.setText(ncadena);

	}

	public void guardarNumeros(View v) {

		SharedPreferences prefs = getSharedPreferences("MisPreferencias",
				Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = prefs.edit();
		editor.putString("numeros", resul.getText().toString());
		editor.commit();

		Toast.makeText(getBaseContext(), "Números Guardados", Toast.LENGTH_LONG)
				.show();
	}
}
