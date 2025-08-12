package com.exercise;

import java.util.ArrayList;
import java.util.List;

public class exercise1 {
  

  public static void main(String[] args) {

    int[] arreglo = new int[] {5,2,3,4,1,1,1,9,9,6,7};
    exercise1OrderNumbers(arreglo);

    String cadena = "holaaloh";
    isPalindromo(cadena);
    
    int number = 6;
    isPrimo(number);

    int cantidadPrimos = 10;
    numerosPrimos(cantidadPrimos);

  }

  // Implementa un método en Java que reciba una lista de números enteros y devuelva la lista ordenada en orden descendente, eliminando duplicados.
  public static void exercise1OrderNumbers(int[] arreglo) {

    for (int i = 0; i < arreglo.length; i++) {
      for (int j = 0; j < arreglo.length; j++) {
        if(arreglo[i] > arreglo[j]) {
          int aux = arreglo[i];
          arreglo[i] = arreglo[j];
          arreglo[j] = aux;
        }
      }
    }
    
    List<Integer> arregloWithOutRepeat = new ArrayList<>();

    for (int i = 0; i < arreglo.length; i++) {
      if(!arregloWithOutRepeat.contains(arreglo[i])) {
        arregloWithOutRepeat.add(arreglo[i]);
      }
    }

    // Integer[] arregloOrdenado = arregloWithOutRepeat.toArray(new Integer[0]);

    System.out.println(arregloWithOutRepeat);

    // for (int i = 0; i < arregloOrdenado.length; i++) {
    //   System.out.print(arregloOrdenado[i] + ", ");
    // }

    System.out.println();
  }


  // Implementa un método que determine si una palabra es un palíndromo.
  public static void isPalindromo(String palabra) {

    // List<String> p = palabra.
    String palabraInversa = "";

    for (int i = palabra.length() - 1; i >= 0; i--) {
      palabraInversa += palabra.charAt(i);
    }

    if(palabraInversa == palabra) {
      System.out.println("La palabra '" + palabra + "' no es palidrono");
    } else {
      System.out.println("La palabra '" + palabra + "' es palidrono");
    }
  }

  // Implementa una función que reciba un número y devuelva true si es primo, false en caso contrario
  public static boolean isPrimo(int number) {
    boolean isPrimo = true;

    for (int i = 2; i < number; i++) {
      if(number % i == 0) {
        isPrimo = false;
      } 
    }

    if(isPrimo) {
      System.out.println("El número '" + number + "' es primo");
    } else {
      System.out.println("El número '" + number + "' no es primo");
    }
    
    return isPrimo;

  }

  // Implementa una función que reciba un número y devuelva true si es primo, false en caso contrario
  public static void numerosPrimos(int number) {

    int contador = 0;
    int numbers = 2;
    List<Integer> listaPrimos = new ArrayList<>();

    while (contador != number) {
      if (isPrimo(numbers)) {

        listaPrimos.add(numbers);
        contador++;
      }
      numbers++;
    }

    Integer[] arregloPrimos = listaPrimos.toArray(new Integer[0]);

    for (int i = 0; i < arregloPrimos.length; i++) {
      System.out.print(arregloPrimos[i] + ", ");
    }
  }

}
