package org.example;

public class MathUtils {

    // T extends Number, restringe el tipo de dato a  byte, double, float, int, long y short.
    public static <T extends Number> double sum(T a, T b){
        return a.doubleValue() + b.doubleValue();
    }
}
