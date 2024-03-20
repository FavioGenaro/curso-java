public class AutoboxingInteger {
    // Autoboxing: autoconvertir o anidar un primitivo en la clase Integer y viceversa
    public static void main(String[] args) {
        // arreglo de enteros
        // por defecto ya tenemos autoboxinog, pues convertimos número literales o primitivos en un objeto (o referencia)
        // el número 1 se convierte en objeto tmb
        Integer[] enteros = {Integer.valueOf(1), 2, 3, 4, 5, 6, 7,
                8, 9, 10, 11, 12, 13, 14, 15};

        int suma = 0;

        for(Integer i: enteros){ // recorremos la lista de enteros, i es de tipo Integer
            if(i.intValue() % 2 == 0){ // obtenemos el valor y sacamos el modulo con 2
                suma += i.intValue();
            }
        }
        System.out.println("suma = " + suma);

        // unBoxing: convertimo un objeto Integer a un primitivo int.
        suma = 0;
        for(Integer i: enteros){
            if(i % 2 == 0){ // directamente usamos i, ya no el método .intValue()
                suma += i;
            }
        }
        System.out.println("suma = " + suma);
    }
}