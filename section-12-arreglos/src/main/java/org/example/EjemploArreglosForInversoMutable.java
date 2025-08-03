package org.example;

import java.util.Arrays;
import java.util.Collections;

public class EjemploArreglosForInversoMutable {

    public static void arregloInverso(String[] arreglo){
        int total2 = arreglo.length;
        int total = arreglo.length;
        for(int i = 0; i < total2; i++){
            String actual = arreglo[i];
            String inverso = arreglo[total-1-i];
            arreglo[i] = inverso;
            arreglo[total-1-i] = actual;
            total2--; // llega a la mitad
        }
    }

    public static void main(String[] args) {

        String[] productos = { "Kingston Pendrive 64GB", "Samsung Galaxy",
                "Disco Duro SSD Samsung Externo",
                "Asus Notebook", "Macbook Air",
                "Chromecast 4ta generación", "Bicicleta Oxford" };

        int total = productos.length;

        Arrays.sort(productos); // ordena de la A a Z
        arregloInverso(productos); // ordena de la Z a A
        // EjemploArreglosForInversoMutable.arregloInverso(productos); // Podemos usar de esta forma los métodos estaticos

        //Collections.reverse(Arrays.asList(productos)); // esta es otra forma

        System.out.println("=== Usando for ===");
        for(int i = 0; i < total; i++){
            System.out.println("para indice " + i + " : " + productos[i]);
        }
    }
}