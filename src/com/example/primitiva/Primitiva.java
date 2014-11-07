package com.example.primitiva;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Primitiva extends Activity {

	int[] numeros = new int[6];
	int primitiva;
	int b;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

	}

	public int[] generarNumeros() {
		// TextView vernumeros = (TextView)findViewById(R.id.numeros);

		for (int i = 0; i < 6; i++) {
			numeros[i] = 1 + (int) (Math.random() * 49);
			while (b < i) {

				if (numeros[i] == numeros[b]) {
					numeros[i] = 1 + (int) (Math.random() * 49);
					b = 0;
				} else {
					b++;
				}
			}
			b = 0;
		}
		return numeros;
	}
}
