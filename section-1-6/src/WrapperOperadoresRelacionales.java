public class WrapperOperadoresRelacionales {
    public static void main(String[] args) {

        // objetos de tipo Integer
        Integer num1 = Integer.valueOf(1000);
        Integer num2 = num1;

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
        // verificamos que sean del mismo tipo
        System.out.println("Son el mismo objeto? " + (num1 == num2)); // true, pues asignamos num1 a num2, por lo que son los mismo

        num2 = 1000;

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);

        // false, pues a num2 es un objeto diferente al asignarse 1000 directamente, lo hace otra instancia
        // si colocamos num1=127 y num2=127, esto sale true, pues solo hasta 127 se hace la comparación por valor y no por objeto (particular de Java)
        // esto pasa para todos los tipos numericos que hay
        System.out.println("Son el mismo objeto? " + (num1 == num2));

        // esta comparación se puede aplicar a todos los demás tipos
        System.out.println("tienen el mismo valor? " + (num1.equals(num2))); // true, equals
        System.out.println("tienen el mismo valor? " + (num1.intValue() == num2.intValue())); // true, se retorna solo el valor tipo int

        // con < y >
        num2 = 500;
        boolean condicion = num1 > num2; // por debajo llama al intValue(), por lo que comparaba valor
        System.out.println("condicion = " + condicion);

        boolean condicion2 = num1.intValue() < num2.intValue();
        System.out.println("condicion2 = " + condicion2);
    }
}
