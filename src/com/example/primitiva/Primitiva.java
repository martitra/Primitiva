package com.example.primitiva;

public class Primitiva {

	static int TAM = 6;
	static int MIN = 1;
	static int MAX = 49;

	public static int[] generarCombinacion() {

		// generar combinacion() array
		// generar numeros ()int
		// existe nuevos (array)

		int[] numeros = new int[TAM];
		int i = 0;
		int b = 0;

		// cambiar esto para no for, sino para que si se repite no i++ y si no
		// que se quede hasta que no haya repetidos
		for (i = 0; i < 6; i++) {
			numeros[i] = 1 + (int) (Math.random() * 49);
			while (b < i) {
				numerosIguales(numeros, i);
			}
			b = 0;
		}
		return numeros;
	}

	public static int generarNumeros() {
		int numero = MIN + (int) (Math.random() * MAX);
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
