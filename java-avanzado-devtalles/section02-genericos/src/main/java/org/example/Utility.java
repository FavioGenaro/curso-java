package org.example;

public class Utility {
    // en estos métodos debemos declarar el tipado porque no lo tiene la clase perce (<T>)
    public static <T> void printItem(T value) {
        System.out.println(value);
    }
    public static <T, K> void printItem(T value, K key){
        System.out.println(value + " " + key);
    }
}
