import java.util.Properties;
// import java.lang;
public class EjemploPropiedadesDeSistema {

    public static void main(String[] args) {

        java.lang.String username = System.getProperty("user.name");
        System.out.println("username = " + username); // favio
        
        java.lang.String home = System.getProperty("user.home");
        System.out.println("home = " + home); // C:\Users\favio

        java.lang.String workspace = System.getProperty("user.dir"); // directorio del proyecto actual
        System.out.println("workspace = " + workspace); // C:\Users\favio\OneDrive\Desktop\Cursos\curso-java\section-8-system

        java.lang.String java = System.getProperty("java.version");
        System.out.println("java = " + java); // 21.0.1

        java.lang.String lineSeparator = System.getProperty("line.separator"); // obtenemos el salto de línea
        java.lang.String lineSeparator2 = System.lineSeparator(); // obtenemos el salto de línea, lo mismo que System.getProperty("line.separator")
        System.out.println("lineSeparator:" + lineSeparator2 + "Una línea nueva ...");

        System.out.println("");
        Properties p = System.getProperties(); // retorna el conjunto completo de propiedades
        p.list(System.out); // se imprime la lista en la pantalla
    }
}
