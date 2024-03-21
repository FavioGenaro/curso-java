public class ArgumentosLineaComando {

    public static void main(String[] args) {

        if(args.length == 0){ // si no pasamos argumentos, imprimimos un mensaje de error
            System.out.println("Debe ingresar argumentos o parámetros!");
            System.exit(-1);
        }
        // imprimimos los argumentos que le pasamos
        for(int i = 0; i < args.length; i++){
            System.out.println("Argumentos nº " + i + ": " + args[i]);
        }
    }
}
