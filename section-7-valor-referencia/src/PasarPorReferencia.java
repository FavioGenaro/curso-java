public class PasarPorReferencia {
    public static void main(String[] args) {
        // usamos arreglos
        int[] edad = {10, 11, 12};

        System.out.println("iniciamos el método main");

        for(int i = 0; i < edad.length; i++){ // mostramos los valores del arreglo
            System.out.println("edad[i] = " + edad[i]);
        }

        System.out.println("Antes de llamar al método test");
        test(edad); // pasamos los valores, los arreglos se pasan por referencia
        System.out.println("Después de llamar al método test");

        for(int i = 0; i < edad.length; i++){ // mostramos nuevamente y vemos que los datos fueron cambiados
            System.out.println("edad[i] = " + edad[i]);
        }

        System.out.println("Finaliza el método main con los datos del arreglo modificados!");
    }

    public static void test(int[] edadArr){
        System.out.println("Iniciamos el método test");
        for(int i = 0; i < edadArr.length; i++){
            edadArr[i] = edadArr[i] + 20; // modificamos los elementos de la lista
        }
        System.out.println("Finaliza el método test");
    }
}

