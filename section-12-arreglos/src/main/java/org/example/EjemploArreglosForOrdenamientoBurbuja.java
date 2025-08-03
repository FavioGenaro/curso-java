package org.example;

import java.util.Arrays;

public class EjemploArreglosForOrdenamientoBurbuja {

    public static void sortBurbujaClassic(String[] arreglo){

        int total = arreglo.length;
        int contador = 0;

        for(int i = 0; i < total - 1; i++){
            for(int j = 0; j < total; j++){
                // usamos una compareTo porque es un método que compara cualquier objeto
                // en caso i sea mayor a j
                if( arreglo[i].compareTo(arreglo[j]) > 0 ){
                    // se intercambia i por j
                    String auxiliar = arreglo[i];
                    arreglo[i] = arreglo[j];
                    arreglo[j] = auxiliar;
                }
                contador++;
            }
        }

        System.out.println("contador classic= " + contador);
    }

    // con object podemos generalizar el ordenamiento a más tipos de datos
    public static void sortBurbuja(Object[] arreglo){

        int total = arreglo.length;
        int contador = 0;

        for(int i = 0; i < total - 1; i++){
            for(int j = 0; j < total -1 -i; j++){
                // casteamos a Comparable
                if( ((Comparable) arreglo[j+1]).compareTo(arreglo[j]) > 0 ){ // descendente, si queremos invertirlo usaremos <
                    Object auxiliar = arreglo[j];
                    arreglo[j] = arreglo[j+1];
                    arreglo[j+1] = auxiliar;
                }
                contador++;
            }
        }

        System.out.println("contador = " + contador);
    }

    public static void main(String[] args) {

        String[] productos = { "Kingston Pendrive 64GB", "Samsung Galaxy",
                "Disco Duro SSD Samsung Externo",
                "Asus Notebook", "Macbook Air",
                "Chromecast 4ta generación", "Bicicleta Oxford" };

        int total = productos.length;

        sortBurbujaClassic(productos);
        sortBurbuja(productos);

        System.out.println("=== Usando for ===");
        for(int i = 0; i < total; i++){
            System.out.println("para indice " + i + " : " + productos[i]);
        }

        Integer[] numeros = new Integer[4];

        numeros[0] = 10;
        numeros[1] = Integer.valueOf("7");
        numeros[2] = 35;
        numeros[3] = -1;

        sortBurbuja(numeros);

        for(int i = 0; i < numeros.length; i++){
            System.out.println("i = " + i + " : " + numeros[i]);
        }
    }
}