import java.lang.reflect.Method;

public class EjemploMetodoGetClass {
    // usaremos un metodo llamado GetClass que esta en todos los objetos, que permite saber detalles de su creación, propiedades, padres, etc.
    // esto es llamado Reflexión, tmb lo vi en C#
    public static void main(String[] args) {
        
        String texto = "Hola que tal!";
        
        Class strClass = texto.getClass(); // obtenemos la clase en un objeto tipo Class

        System.out.println("strClass.getName() = " + strClass.getName()); // java.lang.String
        System.out.println("strClass.getName() = " + strClass.getSimpleName()); // String
        System.out.println("strClass.getName() = " + strClass.getPackageName()); // java.lang, nombre del paquete
        System.out.println("strClass.getName() = " + strClass); // class java.lang.String

        // strClass.getMethods(): retorna un arreglo con todos los métodos de ese objeto o de la clase a la que pertenece el objeto
        // iteramos, cada elemento del arreglo es un tipo Method
        for(Method metodo: strClass.getMethods()){
            System.out.println("metodo.getName() = " + metodo.getName());
        }

        // vemos los mismo para el tipo Integer
        Integer num = 34;
        Class intClass = num.getClass();
        // getSuperclass() retorna la clase padre
        Class objClass = intClass.getSuperclass().getSuperclass(); // padre del padre
        System.out.println("intClass.getSuperclass().getSuperclass() = " + intClass.getSuperclass());
        System.out.println("intClass.getSuperclass().getSuperclass() = " + objClass);

        for(Method metodo: objClass.getMethods()){
            System.out.println("metodo.getName() = " + metodo.getName());
        }
    }
}