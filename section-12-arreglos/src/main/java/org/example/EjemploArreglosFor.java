package org.example;
import java.util.Arrays;

public class EjemploArreglosFor {
    public static void main(String[] args) {
        
        String[] productos = new String[7];
        int total = productos.length;

        productos[0] = "Kingston Pendrive 64GB";
        productos[1] = "Samsung Galaxy";
        productos[2] = "Disco Duro SSD Samsung Externo";
        productos[3] = "Asus Notebook";
        productos[4] = "Macbook Air";
        productos[5] = "Chromecast 4ta generación";
        productos[6] = "Bicicleta Oxford";

        Arrays.sort(productos); // ordena el arreglo, este mantiene ese orden

        System.out.println("=== Usando for ===");
        for(int i = 0; i < total; i++){
            System.out.println("para indice " + i + " : " + productos[i]);
        }


        System.out.println("=== Usando foreach ===");
        // prod es una elemento del arreglo produ
        for(String prod: productos){
            System.out.println("prod = " + prod);
        }


        System.out.println("=== Usando while ===");
        int i = 0; // con while usamos un contador para detener el bucle
        while(i < total){
            System.out.println("para indice " + i + " : " + productos[i]);
            i++;
        }

        System.out.println("=== Usando do while ===");
        // al menos se ejecuta una vez
        int j = 0;
        do {
            System.out.println("para indice " + j + " : " + productos[j]);
            j++;
        } while(j < total);


        // Prueba llenando un arreglo con For
        int[] numeros = new int[10];

        int totalNumeros = numeros.length;
        for(int k = 0; k < totalNumeros; k++){
            numeros[k] = k*3;
        }


        for(int k = 0; k < totalNumeros; k++){
            System.out.println("numeros = " + numeros[k]);
        }

    }
}
