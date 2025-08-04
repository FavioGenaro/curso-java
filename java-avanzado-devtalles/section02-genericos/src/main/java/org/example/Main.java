package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        //Box<String> name = new Box<>("Hola Gabriel!");
        //System.out.println(name.getValue());

        //Box<Integer> integerBox = new Box<>(10);
        //System.out.println(integerBox.getValue());

        Utility.printItem("Gabriel", "2");
        Utility.printItem(10);

        MathUtils.sum(2,2);
        MathUtils.sum(2,4.2);
        // MathUtils.sum(2,"4"); // Error

        List<String> names = new ArrayList<>();
        names.add("Gabriel");
        names.add("María");

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);

        printList(numbers);
        printList(names);
        sumNumbers(numbers);
        addNumbers(numbers);
    }

    // <?> es un Wildcard
    public static void printList(List<?> list){
        for (Object o: list){
            System.out.println(o);
        }

        // list.add(null); // null es el único tipo de datos que podemos agregar, despues los demás esta restringido
    }
    // COVARIANZA
    // podemos restringuir que se pasen datos númericos
    public static void sumNumbers(List<? extends Number> numbers){
        double sum = 0;
        for (Number num: numbers){
            sum += num.doubleValue();
        }
        System.out.println(sum);

        // numbers.add(4); // solo sirve para lecturas especificas, si queremos modificar debemos usar super
        // al igual que el printList no podemos
    }

    // CONTRAVARIANZA
    // usamos super, acepta integer, number y object
    public static void addNumbers(List<? super Integer> numbers) {

        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        Object num = numbers.get(0); // leemos con el tipo object

        System.out.println(num);
    }
}