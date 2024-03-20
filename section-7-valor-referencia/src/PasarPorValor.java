public class PasarPorValor {
    public static void main(String[] args) {

        int i = 10; // los tipos primitivos se pasan por valor, no por referencia
        // Integer i = 10; // incluso si usamos la forma de objeto se pasan por valor
        // esto se debe a que las clases tipo Wrapper son inmutables, es decir, que retornan una nueva instancia y no usan esa misma

        System.out.println("iniciamos el método main con i = " + i);
        test(i);
        System.out.println("Finaliza el método main con el valor de i (se mantiene igual) = " + i);
    }
    // método test
    public static void test(int i){
        System.out.println("Iniciamos el método test con i = " + i);
        i = 35;
        System.out.println("Finaliza el método test con i = " + i);
    }
}
