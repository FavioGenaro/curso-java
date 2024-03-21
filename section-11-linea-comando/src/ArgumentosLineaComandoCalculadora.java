public class ArgumentosLineaComandoCalculadora {
    public static void main(String[] args) {

        if(args.length != 3){ // debemos pasar 3 argumentos, operación y dos números
            System.err.println("Por favor ingresar una operación " +
                    "(suma, resta, div o multi) y dos enteros");
            System.exit(-1);
        }

        String operacion = args[0]; // primer argumento
        int a = 0;
        int b = 0;
        double resultado = 0.00;

        try {
            a = Integer.parseInt(args[1]); // segundo argmuento
            b = Integer.parseInt(args[2]); // tercer argumento
        } catch (NumberFormatException e){
            System.err.println("Cuidado a y b deben ser enteros, vuelva a intentar!");
            System.exit(-1);
        }
        // operaciones de calculadora, esto con el primer argumento
        switch(operacion){
            case "suma":
                resultado = a+b;
                break;
            case "resta":
                resultado = a-b;
                break;
            case "multi":
                resultado = a*b;
                break;
            case "div":
                if(b == 0){ // denominador no puede ser cero
                    System.err.println("No se puede dividir por zero!");
                    System.exit(-1);
                }
                resultado = (double)a/b;
                break;
            default: // por defecto, si pasamos cualquier otro valor, se realiza la suma
                resultado = a+b;
        }
        // mostramos el resultado
        System.out.println("Resultado de la operación '" + operacion + "' es: " +resultado);
    }
}
