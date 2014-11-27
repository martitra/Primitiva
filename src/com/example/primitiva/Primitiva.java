package com.example.primitiva;

public class Primitiva {

	static int tam = 6;
	static int min = 1;
	static int max = 49;

	public static int[] generarCombinacion() {

		// generar combinacion() array
		// generar numeros ()int
		// existe nuevos (array)

		int[] numeros = new int[tam];
		int i = 0;

		// cambiar esto para no for, sino para que si se repite no i++ y si no
		// que se quede hasta que no haya repetidos
		while (i < tam) { 
			numeros[i] = generarNumeros();
			numerosIguales(numeros, i);

		}
		return numeros;
	}

	public static int generarNumeros() {
		int numero = min + (int) (Math.random() * max);
		return numero;
	}

	public static int[] numerosIguales(int[] numeros, int i) {

		int b = 0;
		if (numeros[i] == numeros[b]) {
			numeros[i] = generarNumeros();
			b = 0;
		} else {
			b++;
		}

		return numeros;
	}
}
