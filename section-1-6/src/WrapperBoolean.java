public class WrapperBoolean {
    public static void main(String[] args) {

        Integer num1, num2;
        num1 = 1;
        num2 = 2;

        // Boxing
        boolean primBoolean = num1 > num2; //false, recordemos que con los signos < y > se hace la comparación por valor
        Boolean objBoolean = Boolean.valueOf(primBoolean); // objeto de tipo Boolean
        Boolean objBoolean2 = Boolean.valueOf("false"); // tmb puede aceptar un string
        Boolean objBoolean3 = true; // y un boolean normal

        System.out.println("primBoolean = " + primBoolean);
        System.out.println("objBoolean = " + objBoolean);
        System.out.println("objBoolean2 = " + objBoolean2);

        // Comparaciones
        System.out.println("comparando dos objetos boolean: " + (objBoolean == objBoolean2)); // en boolean se compara el valor, por lo que sale true, diferente a los numeros
        System.out.println("comparando dos objetos boolean: " + (objBoolean.equals(objBoolean2))); // se puede usar el equals
        System.out.println("comparando dos objetos boolean: " + (objBoolean2 == objBoolean3));
        System.out.println("comparando dos objetos boolean: " + (objBoolean == objBoolean3));

        // UnBoxing: de tipo objeto a un primitivo
        boolean primBoolean2 = objBoolean2.booleanValue();
        System.out.println("primBoolean2 = " + primBoolean2);
    }
}