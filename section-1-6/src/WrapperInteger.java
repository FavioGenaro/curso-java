public class WrapperInteger {
    public static void main(String[] args) {

        // De primitivo a Objeto
        int intPrimitivo = 32768;
        // creamos un objeto tipo integer, a esto se le conoce como Boxing, toma el valor primitivo y lo convierte en objeto
        Integer intObjeto = Integer.valueOf(intPrimitivo);
        // este es la forma autoBoxing, que toma un primitivo y lo convierta a un objeto. Esta es la forma más resumida
        Integer intObjeto2 = intPrimitivo;
        System.out.println("intObjeto = " + intObjeto);

        // de Objeto a primitivo
        int num = intObjeto; // podemos asignar un objeto de tipo Integer a un primitivo
        System.out.println("num = " + num);
        int num2 = intObjeto.intValue(); // este método retorna el valor, es lo mismo que no usar el método
        System.out.println("num2 = " + num2);
        
        String valorTvLcd = "67000";
        Integer valor = Integer.valueOf(valorTvLcd); // tmb puede recibir un string
        System.out.println("valor = " + valor);
        
        Short shortObjeto = intObjeto.shortValue(); // convertimos a tipo short, habrá perdida porque 32768 sobrepasa la capacidad de short
        System.out.println("shortObjeto = " + shortObjeto); // retorna -32768, porque dio la vuelta (short soporta desde -32768 a 32767)
        
        Byte byteObjeto = intObjeto.byteValue(); // tipo byte, el máximo que almacena es 127
        System.out.println("byteObjeto = " + byteObjeto); // retorna 0, se da la vuelta a su límite, hay perdida de información
        
        Long longObjeto = intObjeto.longValue(); // tipo long, este no genera perdida porque almacena más que int
        System.out.println("longObjeto = " + longObjeto);

    }
}